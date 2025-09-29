package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class NetworkQualityTest implements Seq.Proxy {
    public final int refnum;

    private static native int __NewNetworkQualityTest();

    public native void cancel();

    public native void start(String configURL, boolean serial, int maxRuntimeSeconds, boolean http3, NetworkQualityTestHandler handler);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public NetworkQualityTest() {
        this.refnum = __NewNetworkQualityTest();
        Seq.trackGoRef(this.refnum, this);
    }

    NetworkQualityTest(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof NetworkQualityTest)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("NetworkQualityTest").append("{");
        return b.append("}").toString();
    }
}
