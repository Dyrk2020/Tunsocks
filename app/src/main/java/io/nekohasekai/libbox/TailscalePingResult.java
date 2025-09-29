package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class TailscalePingResult implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getDERPRegionCode();

    public final native int getDERPRegionID();

    public final native String getEndpoint();

    public final native String getError();

    public final native boolean getIsDirect();

    public final native double getLatencyMs();

    public final native void setDERPRegionCode(String v);

    public final native void setDERPRegionID(int v);

    public final native void setEndpoint(String v);

    public final native void setError(String v);

    public final native void setIsDirect(boolean v);

    public final native void setLatencyMs(double v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    TailscalePingResult(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public TailscalePingResult() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o != null && (o instanceof TailscalePingResult)) {
            TailscalePingResult that = (TailscalePingResult) o;
            double thisLatencyMs = getLatencyMs();
            double thatLatencyMs = that.getLatencyMs();
            if (thisLatencyMs != thatLatencyMs) {
                return false;
            }
            boolean thisIsDirect = getIsDirect();
            boolean thatIsDirect = that.getIsDirect();
            if (thisIsDirect != thatIsDirect) {
                return false;
            }
            String thisEndpoint = getEndpoint();
            String thatEndpoint = that.getEndpoint();
            if (thisEndpoint == null) {
                if (thatEndpoint != null) {
                    return false;
                }
            } else if (!thisEndpoint.equals(thatEndpoint)) {
                return false;
            }
            int thisDERPRegionID = getDERPRegionID();
            int thatDERPRegionID = that.getDERPRegionID();
            if (thisDERPRegionID != thatDERPRegionID) {
                return false;
            }
            String thisDERPRegionCode = getDERPRegionCode();
            String thatDERPRegionCode = that.getDERPRegionCode();
            if (thisDERPRegionCode == null) {
                if (thatDERPRegionCode != null) {
                    return false;
                }
            } else if (!thisDERPRegionCode.equals(thatDERPRegionCode)) {
                return false;
            }
            String thisError = getError();
            String thatError = that.getError();
            if (thisError == null) {
                if (thatError != null) {
                    return false;
                }
                return true;
            }
            if (!thisError.equals(thatError)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Double.valueOf(getLatencyMs()), Boolean.valueOf(getIsDirect()), getEndpoint(), Integer.valueOf(getDERPRegionID()), getDERPRegionCode(), getError()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("TailscalePingResult").append("{");
        b.append("LatencyMs:").append(getLatencyMs()).append(",");
        b.append("IsDirect:").append(getIsDirect()).append(",");
        b.append("Endpoint:").append(getEndpoint()).append(",");
        b.append("DERPRegionID:").append(getDERPRegionID()).append(",");
        b.append("DERPRegionCode:").append(getDERPRegionCode()).append(",");
        b.append("Error:").append(getError()).append(",");
        return b.append("}").toString();
    }
}
