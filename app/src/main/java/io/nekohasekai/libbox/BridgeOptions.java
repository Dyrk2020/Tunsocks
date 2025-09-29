package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class BridgeOptions implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getBridgeName();

    public final native String getInet4Port();

    public final native String getInet6Port();

    public final native String getInterface();

    public final native int getMTU();

    public final native int getRouteTable();

    public final native int getRuleIndex();

    public final native void setBridgeName(String v);

    public final native void setInet4Port(String v);

    public final native void setInet6Port(String v);

    public final native void setInterface(String v);

    public final native void setMTU(int v);

    public final native void setRouteTable(int v);

    public final native void setRuleIndex(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    BridgeOptions(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public BridgeOptions() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o != null && (o instanceof BridgeOptions)) {
            BridgeOptions that = (BridgeOptions) o;
            String thisBridgeName = getBridgeName();
            String thatBridgeName = that.getBridgeName();
            if (thisBridgeName == null) {
                if (thatBridgeName != null) {
                    return false;
                }
            } else if (!thisBridgeName.equals(thatBridgeName)) {
                return false;
            }
            int thisMTU = getMTU();
            int thatMTU = that.getMTU();
            if (thisMTU != thatMTU) {
                return false;
            }
            String thisInet4Port = getInet4Port();
            String thatInet4Port = that.getInet4Port();
            if (thisInet4Port == null) {
                if (thatInet4Port != null) {
                    return false;
                }
            } else if (!thisInet4Port.equals(thatInet4Port)) {
                return false;
            }
            String thisInet6Port = getInet6Port();
            String thatInet6Port = that.getInet6Port();
            if (thisInet6Port == null) {
                if (thatInet6Port != null) {
                    return false;
                }
            } else if (!thisInet6Port.equals(thatInet6Port)) {
                return false;
            }
            String thisInterface = getInterface();
            String thatInterface = that.getInterface();
            if (thisInterface == null) {
                if (thatInterface != null) {
                    return false;
                }
            } else if (!thisInterface.equals(thatInterface)) {
                return false;
            }
            int thisRuleIndex = getRuleIndex();
            int thatRuleIndex = that.getRuleIndex();
            if (thisRuleIndex != thatRuleIndex) {
                return false;
            }
            int thisRouteTable = getRouteTable();
            int thatRouteTable = that.getRouteTable();
            if (thisRouteTable != thatRouteTable) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getBridgeName(), Integer.valueOf(getMTU()), getInet4Port(), getInet6Port(), getInterface(), Integer.valueOf(getRuleIndex()), Integer.valueOf(getRouteTable())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("BridgeOptions").append("{");
        b.append("BridgeName:").append(getBridgeName()).append(",");
        b.append("MTU:").append(getMTU()).append(",");
        b.append("Inet4Port:").append(getInet4Port()).append(",");
        b.append("Inet6Port:").append(getInet6Port()).append(",");
        b.append("Interface:").append(getInterface()).append(",");
        b.append("RuleIndex:").append(getRuleIndex()).append(",");
        b.append("RouteTable:").append(getRouteTable()).append(",");
        return b.append("}").toString();
    }
}
