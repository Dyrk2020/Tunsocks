package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class NetworkQualityResult implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native long getDownloadCapacity();

    public final native int getDownloadCapacityAccuracy();

    public final native int getDownloadRPM();

    public final native int getDownloadRPMAccuracy();

    public final native int getIdleLatencyMs();

    public final native long getUploadCapacity();

    public final native int getUploadCapacityAccuracy();

    public final native int getUploadRPM();

    public final native int getUploadRPMAccuracy();

    public final native void setDownloadCapacity(long v);

    public final native void setDownloadCapacityAccuracy(int v);

    public final native void setDownloadRPM(int v);

    public final native void setDownloadRPMAccuracy(int v);

    public final native void setIdleLatencyMs(int v);

    public final native void setUploadCapacity(long v);

    public final native void setUploadCapacityAccuracy(int v);

    public final native void setUploadRPM(int v);

    public final native void setUploadRPMAccuracy(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    NetworkQualityResult(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public NetworkQualityResult() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o != null && (o instanceof NetworkQualityResult)) {
            NetworkQualityResult that = (NetworkQualityResult) o;
            long thisDownloadCapacity = getDownloadCapacity();
            long thatDownloadCapacity = that.getDownloadCapacity();
            if (thisDownloadCapacity != thatDownloadCapacity) {
                return false;
            }
            long thisUploadCapacity = getUploadCapacity();
            long thatUploadCapacity = that.getUploadCapacity();
            if (thisUploadCapacity != thatUploadCapacity) {
                return false;
            }
            int thisDownloadRPM = getDownloadRPM();
            int thatDownloadRPM = that.getDownloadRPM();
            if (thisDownloadRPM != thatDownloadRPM) {
                return false;
            }
            int thisUploadRPM = getUploadRPM();
            int thatUploadRPM = that.getUploadRPM();
            if (thisUploadRPM != thatUploadRPM) {
                return false;
            }
            int thisIdleLatencyMs = getIdleLatencyMs();
            int thatIdleLatencyMs = that.getIdleLatencyMs();
            if (thisIdleLatencyMs != thatIdleLatencyMs) {
                return false;
            }
            int thisDownloadCapacityAccuracy = getDownloadCapacityAccuracy();
            int thatDownloadCapacityAccuracy = that.getDownloadCapacityAccuracy();
            if (thisDownloadCapacityAccuracy != thatDownloadCapacityAccuracy) {
                return false;
            }
            int thisUploadCapacityAccuracy = getUploadCapacityAccuracy();
            int thatUploadCapacityAccuracy = that.getUploadCapacityAccuracy();
            if (thisUploadCapacityAccuracy != thatUploadCapacityAccuracy) {
                return false;
            }
            int thisDownloadRPMAccuracy = getDownloadRPMAccuracy();
            int thatDownloadRPMAccuracy = that.getDownloadRPMAccuracy();
            if (thisDownloadRPMAccuracy != thatDownloadRPMAccuracy) {
                return false;
            }
            int thisUploadRPMAccuracy = getUploadRPMAccuracy();
            int thatUploadRPMAccuracy = that.getUploadRPMAccuracy();
            if (thisUploadRPMAccuracy != thatUploadRPMAccuracy) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(getDownloadCapacity()), Long.valueOf(getUploadCapacity()), Integer.valueOf(getDownloadRPM()), Integer.valueOf(getUploadRPM()), Integer.valueOf(getIdleLatencyMs()), Integer.valueOf(getDownloadCapacityAccuracy()), Integer.valueOf(getUploadCapacityAccuracy()), Integer.valueOf(getDownloadRPMAccuracy()), Integer.valueOf(getUploadRPMAccuracy())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("NetworkQualityResult").append("{");
        b.append("DownloadCapacity:").append(getDownloadCapacity()).append(",");
        b.append("UploadCapacity:").append(getUploadCapacity()).append(",");
        b.append("DownloadRPM:").append(getDownloadRPM()).append(",");
        b.append("UploadRPM:").append(getUploadRPM()).append(",");
        b.append("IdleLatencyMs:").append(getIdleLatencyMs()).append(",");
        b.append("DownloadCapacityAccuracy:").append(getDownloadCapacityAccuracy()).append(",");
        b.append("UploadCapacityAccuracy:").append(getUploadCapacityAccuracy()).append(",");
        b.append("DownloadRPMAccuracy:").append(getDownloadRPMAccuracy()).append(",");
        b.append("UploadRPMAccuracy:").append(getUploadRPMAccuracy()).append(",");
        return b.append("}").toString();
    }
}
