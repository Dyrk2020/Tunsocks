package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenConnectStatusUpdate implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native OpenConnectEndpointStatusIterator endpoints();

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    OpenConnectStatusUpdate(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public OpenConnectStatusUpdate() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OpenConnectStatusUpdate)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OpenConnectStatusUpdate").append("{");
        return b.append("}").toString();
    }
}
