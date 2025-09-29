package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class STUNTestResult implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getExternalAddr();

    public final native int getLatencyMs();

    public final native int getNATFiltering();

    public final native int getNATMapping();

    public final native boolean getNATTypeSupported();

    public final native void setExternalAddr(String v);

    public final native void setLatencyMs(int v);

    public final native void setNATFiltering(int v);

    public final native void setNATMapping(int v);

    public final native void setNATTypeSupported(boolean v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    STUNTestResult(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public STUNTestResult() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof STUNTestResult)) {
            return false;
        }
        STUNTestResult that = (STUNTestResult) o;
        String thisExternalAddr = getExternalAddr();
        String thatExternalAddr = that.getExternalAddr();
        if (thisExternalAddr == null) {
            if (thatExternalAddr != null) {
                return false;
            }
        } else if (!thisExternalAddr.equals(thatExternalAddr)) {
            return false;
        }
        int thisLatencyMs = getLatencyMs();
        int thatLatencyMs = that.getLatencyMs();
        if (thisLatencyMs != thatLatencyMs) {
            return false;
        }
        int thisNATMapping = getNATMapping();
        int thatNATMapping = that.getNATMapping();
        if (thisNATMapping != thatNATMapping) {
            return false;
        }
        int thisNATFiltering = getNATFiltering();
        int thatNATFiltering = that.getNATFiltering();
        if (thisNATFiltering != thatNATFiltering) {
            return false;
        }
        boolean thisNATTypeSupported = getNATTypeSupported();
        boolean thatNATTypeSupported = that.getNATTypeSupported();
        if (thisNATTypeSupported != thatNATTypeSupported) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getExternalAddr(), Integer.valueOf(getLatencyMs()), Integer.valueOf(getNATMapping()), Integer.valueOf(getNATFiltering()), Boolean.valueOf(getNATTypeSupported())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("STUNTestResult").append("{");
        b.append("ExternalAddr:").append(getExternalAddr()).append(",");
        b.append("LatencyMs:").append(getLatencyMs()).append(",");
        b.append("NATMapping:").append(getNATMapping()).append(",");
        b.append("NATFiltering:").append(getNATFiltering()).append(",");
        b.append("NATTypeSupported:").append(getNATTypeSupported()).append(",");
        return b.append("}").toString();
    }
}
