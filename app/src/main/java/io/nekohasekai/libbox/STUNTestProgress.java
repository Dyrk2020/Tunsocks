package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class STUNTestProgress implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getExternalAddr();

    public final native int getLatencyMs();

    public final native int getNATFiltering();

    public final native int getNATMapping();

    public final native int getPhase();

    public final native void setExternalAddr(String v);

    public final native void setLatencyMs(int v);

    public final native void setNATFiltering(int v);

    public final native void setNATMapping(int v);

    public final native void setPhase(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    STUNTestProgress(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public STUNTestProgress() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof STUNTestProgress)) {
            return false;
        }
        STUNTestProgress that = (STUNTestProgress) o;
        int thisPhase = getPhase();
        int thatPhase = that.getPhase();
        if (thisPhase != thatPhase) {
            return false;
        }
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
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(getPhase()), getExternalAddr(), Integer.valueOf(getLatencyMs()), Integer.valueOf(getNATMapping()), Integer.valueOf(getNATFiltering())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("STUNTestProgress").append("{");
        b.append("Phase:").append(getPhase()).append(",");
        b.append("ExternalAddr:").append(getExternalAddr()).append(",");
        b.append("LatencyMs:").append(getLatencyMs()).append(",");
        b.append("NATMapping:").append(getNATMapping()).append(",");
        b.append("NATFiltering:").append(getNATFiltering()).append(",");
        return b.append("}").toString();
    }
}
