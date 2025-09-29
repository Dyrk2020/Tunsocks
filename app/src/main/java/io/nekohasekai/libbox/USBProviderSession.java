package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class USBProviderSession implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native void attachDevice(USBDeviceDescriptor descriptor) throws Exception;

    public native void close() throws Exception;

    public native void detachDevice(String deviceID) throws Exception;

    public native void sendURBResponse(USBURBResponse response) throws Exception;

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    USBProviderSession(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public USBProviderSession() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof USBProviderSession)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("USBProviderSession").append("{");
        return b.append("}").toString();
    }
}
