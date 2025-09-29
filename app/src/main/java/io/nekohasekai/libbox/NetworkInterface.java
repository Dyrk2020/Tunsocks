package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class NetworkInterface implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native StringIterator getAddresses();

    public final native StringIterator getDNSServer();

    public final native int getFlags();

    public final native int getIndex();

    public final native int getMTU();

    public final native boolean getMetered();

    public final native String getName();

    public final native int getType();

    public final native void setAddresses(StringIterator v);

    public final native void setDNSServer(StringIterator v);

    public final native void setFlags(int v);

    public final native void setIndex(int v);

    public final native void setMTU(int v);

    public final native void setMetered(boolean v);

    public final native void setName(String v);

    public final native void setType(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    NetworkInterface(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public NetworkInterface() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        boolean z;
        if (o != null && (o instanceof NetworkInterface)) {
            NetworkInterface that = (NetworkInterface) o;
            int thisIndex = getIndex();
            int thatIndex = that.getIndex();
            if (thisIndex != thatIndex) {
                return false;
            }
            int thisMTU = getMTU();
            int thatMTU = that.getMTU();
            if (thisMTU != thatMTU) {
                return false;
            }
            String thisName = getName();
            String thatName = that.getName();
            if (thisName == null) {
                if (thatName != null) {
                    return false;
                }
            } else if (!thisName.equals(thatName)) {
                return false;
            }
            StringIterator thisAddresses = getAddresses();
            StringIterator thatAddresses = that.getAddresses();
            if (thisAddresses == null) {
                if (thatAddresses != null) {
                    return false;
                }
            } else if (!thisAddresses.equals(thatAddresses)) {
                return false;
            }
            int thisFlags = getFlags();
            int thatFlags = that.getFlags();
            if (thisFlags != thatFlags) {
                return false;
            }
            int thisType = getType();
            int thatType = that.getType();
            if (thisType != thatType) {
                return false;
            }
            StringIterator thisDNSServer = getDNSServer();
            StringIterator thatDNSServer = that.getDNSServer();
            if (thisDNSServer == null) {
                if (thatDNSServer == null) {
                    z = false;
                } else {
                    return false;
                }
            } else {
                z = false;
                if (!thisDNSServer.equals(thatDNSServer)) {
                    return false;
                }
            }
            boolean thisMetered = getMetered();
            boolean thatMetered = that.getMetered();
            if (thisMetered != thatMetered) {
                return z;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(getIndex()), Integer.valueOf(getMTU()), getName(), getAddresses(), Integer.valueOf(getFlags()), Integer.valueOf(getType()), getDNSServer(), Boolean.valueOf(getMetered())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("NetworkInterface").append("{");
        b.append("Index:").append(getIndex()).append(",");
        b.append("MTU:").append(getMTU()).append(",");
        b.append("Name:").append(getName()).append(",");
        b.append("Addresses:").append(getAddresses()).append(",");
        b.append("Flags:").append(getFlags()).append(",");
        b.append("Type:").append(getType()).append(",");
        b.append("DNSServer:").append(getDNSServer()).append(",");
        b.append("Metered:").append(getMetered()).append(",");
        return b.append("}").toString();
    }
}
