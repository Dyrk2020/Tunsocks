package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class USBSharedDeviceInterface implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native int getInterfaceClass();

    public final native int getInterfaceProtocol();

    public final native int getInterfaceSubClass();

    public final native void setInterfaceClass(int v);

    public final native void setInterfaceProtocol(int v);

    public final native void setInterfaceSubClass(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    USBSharedDeviceInterface(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public USBSharedDeviceInterface() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof USBSharedDeviceInterface)) {
            return false;
        }
        USBSharedDeviceInterface that = (USBSharedDeviceInterface) o;
        int thisInterfaceClass = getInterfaceClass();
        int thatInterfaceClass = that.getInterfaceClass();
        if (thisInterfaceClass != thatInterfaceClass) {
            return false;
        }
        int thisInterfaceSubClass = getInterfaceSubClass();
        int thatInterfaceSubClass = that.getInterfaceSubClass();
        if (thisInterfaceSubClass != thatInterfaceSubClass) {
            return false;
        }
        int thisInterfaceProtocol = getInterfaceProtocol();
        int thatInterfaceProtocol = that.getInterfaceProtocol();
        if (thisInterfaceProtocol != thatInterfaceProtocol) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(getInterfaceClass()), Integer.valueOf(getInterfaceSubClass()), Integer.valueOf(getInterfaceProtocol())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("USBSharedDeviceInterface").append("{");
        b.append("InterfaceClass:").append(getInterfaceClass()).append(",");
        b.append("InterfaceSubClass:").append(getInterfaceSubClass()).append(",");
        b.append("InterfaceProtocol:").append(getInterfaceProtocol()).append(",");
        return b.append("}").toString();
    }
}
