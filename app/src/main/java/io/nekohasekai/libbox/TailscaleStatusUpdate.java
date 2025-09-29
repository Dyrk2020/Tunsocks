package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class TailscaleStatusUpdate implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native TailscaleEndpointStatusIterator endpoints();

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    TailscaleStatusUpdate(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public TailscaleStatusUpdate() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof TailscaleStatusUpdate)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("TailscaleStatusUpdate").append("{");
        return b.append("}").toString();
    }
}
