package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class Connections implements Seq.Proxy {
    public final int refnum;

    private static native int __NewConnections();

    public native void applyEvents(ConnectionEvents events);

    public native void filterState(int state);

    public native ConnectionIterator iterator();

    public native void sortByDate();

    public native void sortByTraffic();

    public native void sortByTrafficTotal();

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public Connections() {
        this.refnum = __NewConnections();
        Seq.trackGoRef(this.refnum, this);
    }

    Connections(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Connections)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("Connections").append("{");
        return b.append("}").toString();
    }
}
