package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class USBURBResponse implements Seq.Proxy {
    public final int refnum;

    private static native int __NewUSBURBResponse(String deviceID, long seq);

    public native void addIsoPacket(int offset, int length, int actualLength, int status);

    public final native int getActualLength();

    public final native String getDeviceID();

    public final native byte[] getInData();

    public final native long getSeq();

    public final native int getStatus();

    public final native void setActualLength(int v);

    public final native void setDeviceID(String v);

    public final native void setInData(byte[] v);

    public final native void setSeq(long v);

    public final native void setStatus(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public USBURBResponse(String deviceID, long seq) {
        this.refnum = __NewUSBURBResponse(deviceID, seq);
        Seq.trackGoRef(this.refnum, this);
    }

    USBURBResponse(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof USBURBResponse)) {
            return false;
        }
        USBURBResponse that = (USBURBResponse) o;
        String thisDeviceID = getDeviceID();
        String thatDeviceID = that.getDeviceID();
        if (thisDeviceID == null) {
            if (thatDeviceID != null) {
                return false;
            }
        } else if (!thisDeviceID.equals(thatDeviceID)) {
            return false;
        }
        long thisSeq = getSeq();
        long thatSeq = that.getSeq();
        if (thisSeq != thatSeq) {
            return false;
        }
        int thisStatus = getStatus();
        int thatStatus = that.getStatus();
        if (thisStatus != thatStatus) {
            return false;
        }
        int thisActualLength = getActualLength();
        int thatActualLength = that.getActualLength();
        if (thisActualLength != thatActualLength) {
            return false;
        }
        byte[] thisInData = getInData();
        byte[] thatInData = that.getInData();
        if (thisInData == null) {
            return thatInData == null;
        }
        return thisInData.equals(thatInData);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getDeviceID(), Long.valueOf(getSeq()), Integer.valueOf(getStatus()), Integer.valueOf(getActualLength()), getInData()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("USBURBResponse").append("{");
        b.append("DeviceID:").append(getDeviceID()).append(",");
        b.append("Seq:").append(getSeq()).append(",");
        b.append("Status:").append(getStatus()).append(",");
        b.append("ActualLength:").append(getActualLength()).append(",");
        b.append("InData:").append(getInData()).append(",");
        return b.append("}").toString();
    }
}
