package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class NetworkQualityTestSession implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native void close() throws Exception;

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    NetworkQualityTestSession(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public NetworkQualityTestSession() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof NetworkQualityTestSession)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("NetworkQualityTestSession").append("{");
        return b.append("}").toString();
    }
}
