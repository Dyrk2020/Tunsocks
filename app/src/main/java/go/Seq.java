package go;

import android.content.Context;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class Seq {
    private static final int NULL_REFNUM = 41;
    static final RefTracker tracker;
    private static Logger log = Logger.getLogger("GoSeq");
    public static final Ref nullRef = new Ref(41, null);
    private static final GoRefQueue goRefQueue = new GoRefQueue();

    public interface GoObject {
        int incRefnum();
    }

    public interface Proxy extends GoObject {
    }

    public static native void destroyRef(int refnum);

    public static native void incGoRef(int refnum, GoObject ref);

    private static native void init();

    static native void setContext(Object ctx);

    static {
        System.loadLibrary("box");
        init();
        Universe.touch();
        tracker = new RefTracker();
    }

    public static void setContext(Context context) {
        setContext((Object) context);
    }

    public static void touch() {
    }

    private Seq() {
    }

    public static void incRefnum(int refnum) {
        tracker.incRefnum(refnum);
    }

    public static int incRef(Object o) {
        return tracker.inc(o);
    }

    public static int incGoObjectRef(GoObject o) {
        return o.incRefnum();
    }

    public static void trackGoRef(int refnum, GoObject obj) {
        if (refnum > 0) {
            throw new RuntimeException("trackGoRef called with Java refnum " + refnum);
        }
        goRefQueue.track(refnum, obj);
    }

    public static Ref getRef(int refnum) {
        return tracker.get(refnum);
    }

    static void decRef(int refnum) {
        tracker.dec(refnum);
    }

    public static final class Ref {
        public final Object obj;
        private int refcnt;
        public final int refnum;

        static /* synthetic */ int access$110(Ref x0) {
            int i = x0.refcnt;
            x0.refcnt = i - 1;
            return i;
        }

        Ref(int refnum, Object o) {
            if (refnum < 0) {
                throw new RuntimeException("Ref instantiated with a Go refnum " + refnum);
            }
            this.refnum = refnum;
            this.refcnt = 0;
            this.obj = o;
        }

        void inc() {
            if (this.refcnt == Integer.MAX_VALUE) {
                throw new RuntimeException("refnum " + this.refnum + " overflow");
            }
            this.refcnt++;
        }
    }

    static final class RefTracker {
        private static final int REF_OFFSET = 42;
        private int next = 42;
        private final RefMap javaObjs = new RefMap();
        private final IdentityHashMap<Object, Integer> javaRefs = new IdentityHashMap<>();

        RefTracker() {
        }

        synchronized int inc(Object o) {
            if (o == null) {
                return 41;
            }
            if (o instanceof Proxy) {
                return ((Proxy) o).incRefnum();
            }
            Integer refnumObj = this.javaRefs.get(o);
            if (refnumObj == null) {
                if (this.next == Integer.MAX_VALUE) {
                    throw new RuntimeException("createRef overflow for " + o);
                }
                int i = this.next;
                this.next = i + 1;
                refnumObj = Integer.valueOf(i);
                this.javaRefs.put(o, refnumObj);
            }
            int refnum = refnumObj.intValue();
            Ref ref = this.javaObjs.get(refnum);
            if (ref == null) {
                ref = new Ref(refnum, o);
                this.javaObjs.put(refnum, ref);
            }
            ref.inc();
            return refnum;
        }

        synchronized void incRefnum(int refnum) {
            Ref ref = this.javaObjs.get(refnum);
            if (ref == null) {
                throw new RuntimeException("referenced Java object is not found: refnum=" + refnum);
            }
            ref.inc();
        }

        synchronized void dec(int refnum) {
            try {
                if (refnum <= 0) {
                    Seq.log.severe("dec request for Go object " + refnum);
                    return;
                }
                if (refnum == Seq.nullRef.refnum) {
                    return;
                }
                Ref obj = this.javaObjs.get(refnum);
                if (obj == null) {
                    throw new RuntimeException("referenced Java object is not found: refnum=" + refnum);
                }
                Ref.access$110(obj);
                if (obj.refcnt <= 0) {
                    this.javaObjs.remove(refnum);
                    this.javaRefs.remove(obj.obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        synchronized Ref get(int refnum) {
            try {
                if (refnum < 0) {
                    throw new RuntimeException("ref called with Go refnum " + refnum);
                }
                if (refnum == 41) {
                    return Seq.nullRef;
                }
                Ref ref = this.javaObjs.get(refnum);
                if (ref != null) {
                    return ref;
                }
                throw new RuntimeException("unknown java Ref: " + refnum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static class GoRefQueue extends ReferenceQueue<GoObject> {
        private final Collection<GoRef> refs = Collections.synchronizedCollection(new HashSet());

        void track(int refnum, GoObject obj) {
            this.refs.add(new GoRef(refnum, obj, this));
        }

        GoRefQueue() {
            Thread daemon = new Thread(new Runnable() { // from class: go.Seq.GoRefQueue.1
                /* JADX INFO: Infinite loop detected, blocks: 7, insns: 0 */
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        try {
                            GoRef ref = (GoRef) GoRefQueue.this.remove();
                            GoRefQueue.this.refs.remove(ref);
                            Seq.destroyRef(ref.refnum);
                            ref.clear();
                        } catch (InterruptedException e) {
                        }
                    }
                }
            });
            daemon.setDaemon(true);
            daemon.setName("GoRefQueue Finalizer Thread");
            daemon.start();
        }
    }

    static class GoRef extends PhantomReference<GoObject> {
        final int refnum;

        GoRef(int refnum, GoObject obj, GoRefQueue q) {
            super(obj, q);
            if (refnum > 0) {
                throw new RuntimeException("GoRef instantiated with a Java refnum " + refnum);
            }
            this.refnum = refnum;
        }
    }

    static final class RefMap {
        private int next = 0;
        private int live = 0;
        private int[] keys = new int[16];
        private Ref[] objs = new Ref[16];

        RefMap() {
        }

        Ref get(int key) {
            int i = Arrays.binarySearch(this.keys, 0, this.next, key);
            if (i >= 0) {
                return this.objs[i];
            }
            return null;
        }

        void remove(int key) {
            int i = Arrays.binarySearch(this.keys, 0, this.next, key);
            if (i >= 0 && this.objs[i] != null) {
                this.objs[i] = null;
                this.live--;
            }
        }

        void put(int key, Ref obj) {
            if (obj == null) {
                throw new RuntimeException("put a null ref (with key " + key + ")");
            }
            int i = Arrays.binarySearch(this.keys, 0, this.next, key);
            if (i >= 0) {
                if (this.objs[i] == null) {
                    this.objs[i] = obj;
                    this.live++;
                }
                if (this.objs[i] != obj) {
                    throw new RuntimeException("replacing an existing ref (with key " + key + ")");
                }
                return;
            }
            if (this.next >= this.keys.length) {
                grow();
                i = Arrays.binarySearch(this.keys, 0, this.next, key);
            }
            int i2 = ~i;
            if (i2 < this.next) {
                System.arraycopy(this.keys, i2, this.keys, i2 + 1, this.next - i2);
                System.arraycopy(this.objs, i2, this.objs, i2 + 1, this.next - i2);
            }
            this.keys[i2] = key;
            this.objs[i2] = obj;
            this.live++;
            this.next++;
        }

        private void grow() {
            int[] newKeys;
            Ref[] newObjs;
            int len = roundPow2(this.live) * 2;
            if (len > this.keys.length) {
                newKeys = new int[this.keys.length * 2];
                newObjs = new Ref[this.objs.length * 2];
            } else {
                newKeys = this.keys;
                newObjs = this.objs;
            }
            int j = 0;
            for (int i = 0; i < this.keys.length; i++) {
                if (this.objs[i] != null) {
                    newKeys[j] = this.keys[i];
                    newObjs[j] = this.objs[i];
                    j++;
                }
            }
            for (int i2 = j; i2 < newKeys.length; i2++) {
                newKeys[i2] = 0;
                newObjs[i2] = null;
            }
            this.keys = newKeys;
            this.objs = newObjs;
            this.next = j;
            if (this.live != this.next) {
                throw new RuntimeException("bad state: live=" + this.live + ", next=" + this.next);
            }
        }

        private static int roundPow2(int x) {
            int p = 1;
            while (p < x) {
                p *= 2;
            }
            return p;
        }
    }
}
