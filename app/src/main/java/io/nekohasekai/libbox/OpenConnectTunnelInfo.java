package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenConnectTunnelInfo implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native StringIterator dns();

    public final native long getConnectedSince();

    public final native String getFlavor();

    public final native int getMTU();

    public final native String getServer();

    public final native String getTransport();

    public native StringIterator iPv4();

    public native StringIterator iPv6();

    public final native void setConnectedSince(long v);

    public final native void setFlavor(String v);

    public final native void setMTU(int v);

    public final native void setServer(String v);

    public final native void setTransport(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    OpenConnectTunnelInfo(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public OpenConnectTunnelInfo() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OpenConnectTunnelInfo)) {
            return false;
        }
        OpenConnectTunnelInfo that = (OpenConnectTunnelInfo) o;
        String thisServer = getServer();
        String thatServer = that.getServer();
        if (thisServer == null) {
            if (thatServer != null) {
                return false;
            }
        } else if (!thisServer.equals(thatServer)) {
            return false;
        }
        String thisFlavor = getFlavor();
        String thatFlavor = that.getFlavor();
        if (thisFlavor == null) {
            if (thatFlavor != null) {
                return false;
            }
        } else if (!thisFlavor.equals(thatFlavor)) {
            return false;
        }
        String thisTransport = getTransport();
        String thatTransport = that.getTransport();
        if (thisTransport == null) {
            if (thatTransport != null) {
                return false;
            }
        } else if (!thisTransport.equals(thatTransport)) {
            return false;
        }
        int thisMTU = getMTU();
        int thatMTU = that.getMTU();
        if (thisMTU != thatMTU) {
            return false;
        }
        long thisConnectedSince = getConnectedSince();
        long thatConnectedSince = that.getConnectedSince();
        return thisConnectedSince == thatConnectedSince;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getServer(), getFlavor(), getTransport(), Integer.valueOf(getMTU()), Long.valueOf(getConnectedSince())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OpenConnectTunnelInfo").append("{");
        b.append("Server:").append(getServer()).append(",");
        b.append("Flavor:").append(getFlavor()).append(",");
        b.append("Transport:").append(getTransport()).append(",");
        b.append("MTU:").append(getMTU()).append(",");
        b.append("ConnectedSince:").append(getConnectedSince()).append(",");
        return b.append("}").toString();
    }
}
