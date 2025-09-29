package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class Connection implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native StringIterator chain();

    public native String displayDestination();

    public final native long getClosedAt();

    public final native long getCreatedAt();

    public final native String getDestination();

    public final native String getDomain();

    public final native long getDownlink();

    public final native long getDownlinkTotal();

    public final native String getFromOutbound();

    public final native String getID();

    public final native int getIPVersion();

    public final native String getInbound();

    public final native String getInboundType();

    public final native String getNetwork();

    public final native String getOutbound();

    public final native String getOutboundType();

    public final native ProcessInfo getProcessInfo();

    public final native String getProtocol();

    public final native String getRule();

    public final native String getSource();

    public final native long getUplink();

    public final native long getUplinkTotal();

    public final native String getUser();

    public final native void setClosedAt(long v);

    public final native void setCreatedAt(long v);

    public final native void setDestination(String v);

    public final native void setDomain(String v);

    public final native void setDownlink(long v);

    public final native void setDownlinkTotal(long v);

    public final native void setFromOutbound(String v);

    public final native void setID(String v);

    public final native void setIPVersion(int v);

    public final native void setInbound(String v);

    public final native void setInboundType(String v);

    public final native void setNetwork(String v);

    public final native void setOutbound(String v);

    public final native void setOutboundType(String v);

    public final native void setProcessInfo(ProcessInfo v);

    public final native void setProtocol(String v);

    public final native void setRule(String v);

    public final native void setSource(String v);

    public final native void setUplink(long v);

    public final native void setUplinkTotal(long v);

    public final native void setUser(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    Connection(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public Connection() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        boolean z;
        if (o != null && (o instanceof Connection)) {
            Connection that = (Connection) o;
            String thisID = getID();
            String thatID = that.getID();
            if (thisID == null) {
                if (thatID != null) {
                    return false;
                }
            } else if (!thisID.equals(thatID)) {
                return false;
            }
            String thisInbound = getInbound();
            String thatInbound = that.getInbound();
            if (thisInbound == null) {
                if (thatInbound != null) {
                    return false;
                }
            } else if (!thisInbound.equals(thatInbound)) {
                return false;
            }
            String thisInboundType = getInboundType();
            String thatInboundType = that.getInboundType();
            if (thisInboundType == null) {
                if (thatInboundType != null) {
                    return false;
                }
            } else if (!thisInboundType.equals(thatInboundType)) {
                return false;
            }
            int thisIPVersion = getIPVersion();
            int thatIPVersion = that.getIPVersion();
            if (thisIPVersion != thatIPVersion) {
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
            String thisSource = getSource();
            String thatSource = that.getSource();
            if (thisSource == null) {
                if (thatSource != null) {
                    return false;
                }
            } else if (!thisSource.equals(thatSource)) {
                return false;
            }
            String thisDestination = getDestination();
            String thatDestination = that.getDestination();
            if (thisDestination == null) {
                if (thatDestination != null) {
                    return false;
                }
            } else if (!thisDestination.equals(thatDestination)) {
                return false;
            }
            String thisDomain = getDomain();
            String thatDomain = that.getDomain();
            if (thisDomain == null) {
                if (thatDomain != null) {
                    return false;
                }
            } else if (!thisDomain.equals(thatDomain)) {
                return false;
            }
            String thisProtocol = getProtocol();
            String thatProtocol = that.getProtocol();
            if (thisProtocol == null) {
                if (thatProtocol != null) {
                    return false;
                }
            } else if (!thisProtocol.equals(thatProtocol)) {
                return false;
            }
            String thisUser = getUser();
            String thatUser = that.getUser();
            if (thisUser == null) {
                if (thatUser != null) {
                    return false;
                }
            } else if (!thisUser.equals(thatUser)) {
                return false;
            }
            String thisFromOutbound = getFromOutbound();
            String thatFromOutbound = that.getFromOutbound();
            if (thisFromOutbound == null) {
                if (thatFromOutbound == null) {
                    z = false;
                } else {
                    return false;
                }
            } else {
                z = false;
                if (!thisFromOutbound.equals(thatFromOutbound)) {
                    return false;
                }
            }
            long thisCreatedAt = getCreatedAt();
            long thatCreatedAt = that.getCreatedAt();
            if (thisCreatedAt != thatCreatedAt) {
                return z;
            }
            long thisClosedAt = getClosedAt();
            long thatClosedAt = that.getClosedAt();
            if (thisClosedAt != thatClosedAt) {
                return z;
            }
            long thisUplink = getUplink();
            long thatUplink = that.getUplink();
            if (thisUplink != thatUplink) {
                return z;
            }
            long thisDownlink = getDownlink();
            long thatDownlink = that.getDownlink();
            if (thisDownlink != thatDownlink) {
                return z;
            }
            long thisUplinkTotal = getUplinkTotal();
            long thatUplinkTotal = that.getUplinkTotal();
            if (thisUplinkTotal != thatUplinkTotal) {
                return z;
            }
            long thisDownlinkTotal = getDownlinkTotal();
            long thatDownlinkTotal = that.getDownlinkTotal();
            if (thisDownlinkTotal != thatDownlinkTotal) {
                return z;
            }
            String thisRule = getRule();
            String thatRule = that.getRule();
            if (thisRule == null) {
                if (thatRule != null) {
                    return z;
                }
            } else if (!thisRule.equals(thatRule)) {
                return z;
            }
            String thisOutbound = getOutbound();
            String thatOutbound = that.getOutbound();
            if (thisOutbound == null) {
                if (thatOutbound != null) {
                    return false;
                }
            } else if (!thisOutbound.equals(thatOutbound)) {
                return false;
            }
            String thisOutboundType = getOutboundType();
            String thatOutboundType = that.getOutboundType();
            if (thisOutboundType == null) {
                if (thatOutboundType != null) {
                    return false;
                }
            } else if (!thisOutboundType.equals(thatOutboundType)) {
                return false;
            }
            ProcessInfo thisProcessInfo = getProcessInfo();
            ProcessInfo thatProcessInfo = that.getProcessInfo();
            if (thisProcessInfo == null) {
                if (thatProcessInfo != null) {
                    return false;
                }
                return true;
            }
            if (!thisProcessInfo.equals(thatProcessInfo)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getID(), getInbound(), getInboundType(), Integer.valueOf(getIPVersion()), getNetwork(), getSource(), getDestination(), getDomain(), getProtocol(), getUser(), getFromOutbound(), Long.valueOf(getCreatedAt()), Long.valueOf(getClosedAt()), Long.valueOf(getUplink()), Long.valueOf(getDownlink()), Long.valueOf(getUplinkTotal()), Long.valueOf(getDownlinkTotal()), getRule(), getOutbound(), getOutboundType(), getProcessInfo()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("Connection").append("{");
        b.append("ID:").append(getID()).append(",");
        b.append("Inbound:").append(getInbound()).append(",");
        b.append("InboundType:").append(getInboundType()).append(",");
        b.append("IPVersion:").append(getIPVersion()).append(",");
        b.append("Network:").append(getNetwork()).append(",");
        b.append("Source:").append(getSource()).append(",");
        b.append("Destination:").append(getDestination()).append(",");
        b.append("Domain:").append(getDomain()).append(",");
        b.append("Protocol:").append(getProtocol()).append(",");
        b.append("User:").append(getUser()).append(",");
        b.append("FromOutbound:").append(getFromOutbound()).append(",");
        b.append("CreatedAt:").append(getCreatedAt()).append(",");
        b.append("ClosedAt:").append(getClosedAt()).append(",");
        b.append("Uplink:").append(getUplink()).append(",");
        b.append("Downlink:").append(getDownlink()).append(",");
        b.append("UplinkTotal:").append(getUplinkTotal()).append(",");
        b.append("DownlinkTotal:").append(getDownlinkTotal()).append(",");
        b.append("Rule:").append(getRule()).append(",");
        b.append("Outbound:").append(getOutbound()).append(",");
        b.append("OutboundType:").append(getOutboundType()).append(",");
        b.append("ProcessInfo:").append(getProcessInfo()).append(",");
        return b.append("}").toString();
    }
}
