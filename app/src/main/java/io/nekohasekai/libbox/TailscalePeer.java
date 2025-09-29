package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class TailscalePeer implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native boolean getActive();

    public final native String getDNSName();

    public final native boolean getExitNode();

    public final native boolean getExitNodeOption();

    public final native boolean getExpired();

    public final native String getHostName();

    public final native long getKeyExpiry();

    public final native long getLastSeen();

    public final native String getOS();

    public final native boolean getOnline();

    public final native long getRxBytes();

    public final native boolean getShareeNode();

    public final native String getStableID();

    public final native long getTxBytes();

    public final native void setActive(boolean v);

    public final native void setDNSName(String v);

    public final native void setExitNode(boolean v);

    public final native void setExitNodeOption(boolean v);

    public final native void setExpired(boolean v);

    public final native void setHostName(String v);

    public final native void setKeyExpiry(long v);

    public final native void setLastSeen(long v);

    public final native void setOS(String v);

    public final native void setOnline(boolean v);

    public final native void setRxBytes(long v);

    public final native void setShareeNode(boolean v);

    public final native void setStableID(String v);

    public final native void setTxBytes(long v);

    public native StringIterator sshHostKeys();

    public native StringIterator tailscaleIPs();

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    TailscalePeer(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public TailscalePeer() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o != null && (o instanceof TailscalePeer)) {
            TailscalePeer that = (TailscalePeer) o;
            String thisStableID = getStableID();
            String thatStableID = that.getStableID();
            if (thisStableID == null) {
                if (thatStableID != null) {
                    return false;
                }
            } else if (!thisStableID.equals(thatStableID)) {
                return false;
            }
            String thisHostName = getHostName();
            String thatHostName = that.getHostName();
            if (thisHostName == null) {
                if (thatHostName != null) {
                    return false;
                }
            } else if (!thisHostName.equals(thatHostName)) {
                return false;
            }
            String thisDNSName = getDNSName();
            String thatDNSName = that.getDNSName();
            if (thisDNSName == null) {
                if (thatDNSName != null) {
                    return false;
                }
            } else if (!thisDNSName.equals(thatDNSName)) {
                return false;
            }
            String thisOS = getOS();
            String thatOS = that.getOS();
            if (thisOS == null) {
                if (thatOS != null) {
                    return false;
                }
            } else if (!thisOS.equals(thatOS)) {
                return false;
            }
            boolean thisOnline = getOnline();
            boolean thatOnline = that.getOnline();
            if (thisOnline != thatOnline) {
                return false;
            }
            boolean thisExitNode = getExitNode();
            boolean thatExitNode = that.getExitNode();
            if (thisExitNode != thatExitNode) {
                return false;
            }
            boolean thisExitNodeOption = getExitNodeOption();
            boolean thatExitNodeOption = that.getExitNodeOption();
            if (thisExitNodeOption != thatExitNodeOption) {
                return false;
            }
            boolean thisShareeNode = getShareeNode();
            boolean thatShareeNode = that.getShareeNode();
            if (thisShareeNode != thatShareeNode) {
                return false;
            }
            boolean thisExpired = getExpired();
            boolean thatExpired = that.getExpired();
            if (thisExpired != thatExpired) {
                return false;
            }
            boolean thisActive = getActive();
            boolean thatActive = that.getActive();
            if (thisActive != thatActive) {
                return false;
            }
            long thisRxBytes = getRxBytes();
            long thatRxBytes = that.getRxBytes();
            if (thisRxBytes != thatRxBytes) {
                return false;
            }
            long thisTxBytes = getTxBytes();
            long thatTxBytes = that.getTxBytes();
            if (thisTxBytes != thatTxBytes) {
                return false;
            }
            long thisKeyExpiry = getKeyExpiry();
            long thatKeyExpiry = that.getKeyExpiry();
            if (thisKeyExpiry != thatKeyExpiry) {
                return false;
            }
            long thisLastSeen = getLastSeen();
            long thatLastSeen = that.getLastSeen();
            if (thisLastSeen != thatLastSeen) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getStableID(), getHostName(), getDNSName(), getOS(), Boolean.valueOf(getOnline()), Boolean.valueOf(getExitNode()), Boolean.valueOf(getExitNodeOption()), Boolean.valueOf(getShareeNode()), Boolean.valueOf(getExpired()), Boolean.valueOf(getActive()), Long.valueOf(getRxBytes()), Long.valueOf(getTxBytes()), Long.valueOf(getKeyExpiry()), Long.valueOf(getLastSeen())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("TailscalePeer").append("{");
        b.append("StableID:").append(getStableID()).append(",");
        b.append("HostName:").append(getHostName()).append(",");
        b.append("DNSName:").append(getDNSName()).append(",");
        b.append("OS:").append(getOS()).append(",");
        b.append("Online:").append(getOnline()).append(",");
        b.append("ExitNode:").append(getExitNode()).append(",");
        b.append("ExitNodeOption:").append(getExitNodeOption()).append(",");
        b.append("ShareeNode:").append(getShareeNode()).append(",");
        b.append("Expired:").append(getExpired()).append(",");
        b.append("Active:").append(getActive()).append(",");
        b.append("RxBytes:").append(getRxBytes()).append(",");
        b.append("TxBytes:").append(getTxBytes()).append(",");
        b.append("KeyExpiry:").append(getKeyExpiry()).append(",");
        b.append("LastSeen:").append(getLastSeen()).append(",");
        return b.append("}").toString();
    }
}
