package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ConnectionEvents implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native boolean getReset();

    public native ConnectionEventIterator iterator();

    public final native void setReset(boolean v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    ConnectionEvents(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public ConnectionEvents() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof ConnectionEvents)) {
            return false;
        }
        ConnectionEvents that = (ConnectionEvents) o;
        boolean thisReset = getReset();
        boolean thatReset = that.getReset();
        if (thisReset != thatReset) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(getReset())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("ConnectionEvents").append("{");
        b.append("Reset:").append(getReset()).append(",");
        return b.append("}").toString();
    }
}
