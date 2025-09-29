package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class WIFIState implements Seq.Proxy {
    public final int refnum;

    private static native int __NewWIFIState(String wifiSSID, String wifiBSSID);

    public final native String getBSSID();

    public final native String getSSID();

    public final native void setBSSID(String v);

    public final native void setSSID(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public WIFIState(String wifiSSID, String wifiBSSID) {
        this.refnum = __NewWIFIState(wifiSSID, wifiBSSID);
        Seq.trackGoRef(this.refnum, this);
    }

    WIFIState(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof WIFIState)) {
            return false;
        }
        WIFIState that = (WIFIState) o;
        String thisSSID = getSSID();
        String thatSSID = that.getSSID();
        if (thisSSID == null) {
            if (thatSSID != null) {
                return false;
            }
        } else if (!thisSSID.equals(thatSSID)) {
            return false;
        }
        String thisBSSID = getBSSID();
        String thatBSSID = that.getBSSID();
        if (thisBSSID == null) {
            if (thatBSSID != null) {
                return false;
            }
            return true;
        }
        if (!thisBSSID.equals(thatBSSID)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getSSID(), getBSSID()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("WIFIState").append("{");
        b.append("SSID:").append(getSSID()).append(",");
        b.append("BSSID:").append(getBSSID()).append(",");
        return b.append("}").toString();
    }
}
