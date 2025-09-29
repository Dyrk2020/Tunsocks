package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenVPNTunnelInfo implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native StringIterator dns();

    public final native String getCipher();

    public final native long getConnectedSince();

    public final native int getMTU();

    public final native String getNetwork();

    public final native String getServer();

    public native StringIterator iPv4();

    public native StringIterator iPv6();

    public final native void setCipher(String v);

    public final native void setConnectedSince(long v);

    public final native void setMTU(int v);

    public final native void setNetwork(String v);

    public final native void setServer(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    OpenVPNTunnelInfo(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public OpenVPNTunnelInfo() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OpenVPNTunnelInfo)) {
            return false;
        }
        OpenVPNTunnelInfo that = (OpenVPNTunnelInfo) o;
        String thisServer = getServer();
        String thatServer = that.getServer();
        if (thisServer == null) {
            if (thatServer != null) {
                return false;
            }
        } else if (!thisServer.equals(thatServer)) {
            return false;
        }
        String thisNetwork = getNetwork();
        String thatNetwork = that.getNetwork();
        if (thisNetwork == null) {
            if (thatNetwork != null) {
                return false;
            }
        } else if (!thisNetwork.equals(thatNetwork)) {
            return false;
        }
        String thisCipher = getCipher();
        String thatCipher = that.getCipher();
        if (thisCipher == null) {
            if (thatCipher != null) {
                return false;
            }
        } else if (!thisCipher.equals(thatCipher)) {
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
        return Arrays.hashCode(new Object[]{getServer(), getNetwork(), getCipher(), Integer.valueOf(getMTU()), Long.valueOf(getConnectedSince())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OpenVPNTunnelInfo").append("{");
        b.append("Server:").append(getServer()).append(",");
        b.append("Network:").append(getNetwork()).append(",");
        b.append("Cipher:").append(getCipher()).append(",");
        b.append("MTU:").append(getMTU()).append(",");
        b.append("ConnectedSince:").append(getConnectedSince()).append(",");
        return b.append("}").toString();
    }
}
