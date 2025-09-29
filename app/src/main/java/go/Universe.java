package go;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Universe {
    private static native void _init();

    static {
        Seq.touch();
        _init();
    }

    private Universe() {
    }

    public static void touch() {
    }

    private static final class proxyerror extends Exception implements Seq.Proxy, error {
        public final int refnum;

        @Override // go.error
        public native String error();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyerror(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return error();
        }
    }
}
