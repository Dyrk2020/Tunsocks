package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class STUNTest implements Seq.Proxy {
    public final int refnum;

    private static native int __NewSTUNTest();

    public native void cancel();

    public native void start(String server, STUNTestHandler handler);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public STUNTest() {
        this.refnum = __NewSTUNTest();
        Seq.trackGoRef(this.refnum, this);
    }

    STUNTest(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof STUNTest)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("STUNTest").append("{");
        return b.append("}").toString();
    }
}
