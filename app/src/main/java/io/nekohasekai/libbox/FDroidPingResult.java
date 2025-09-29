package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class FDroidPingResult implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getError();

    public final native int getLatencyMs();

    public final native String getURL();

    public final native void setError(String v);

    public final native void setLatencyMs(int v);

    public final native void setURL(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    FDroidPingResult(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public FDroidPingResult() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof FDroidPingResult)) {
            return false;
        }
        FDroidPingResult that = (FDroidPingResult) o;
        String thisURL = getURL();
        String thatURL = that.getURL();
        if (thisURL == null) {
            if (thatURL != null) {
                return false;
            }
        } else if (!thisURL.equals(thatURL)) {
            return false;
        }
        int thisLatencyMs = getLatencyMs();
        int thatLatencyMs = that.getLatencyMs();
        if (thisLatencyMs != thatLatencyMs) {
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

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getURL(), Integer.valueOf(getLatencyMs()), getError()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("FDroidPingResult").append("{");
        b.append("URL:").append(getURL()).append(",");
        b.append("LatencyMs:").append(getLatencyMs()).append(",");
        b.append("Error:").append(getError()).append(",");
        return b.append("}").toString();
    }
}
