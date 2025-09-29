package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class USBURBRequest implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getDeviceID();

    public final native boolean getDirectionIn();

    public final native int getEndpoint();

    public final native int getInterval();

    public native USBIsoPacket getIsoPacket(int index);

    public final native int getNumberOfPackets();

    public final native byte[] getOutData();

    public final native long getSeq();

    public final native byte[] getSetup();

    public final native int getStartFrame();

    public final native int getTransferBufferLength();

    public final native int getTransferFlags();

    public native int isoPacketCount();

    public final native void setDeviceID(String v);

    public final native void setDirectionIn(boolean v);

    public final native void setEndpoint(int v);

    public final native void setInterval(int v);

    public final native void setNumberOfPackets(int v);

    public final native void setOutData(byte[] v);

    public final native void setSeq(long v);

    public final native void setSetup(byte[] v);

    public final native void setStartFrame(int v);

    public final native void setTransferBufferLength(int v);

    public final native void setTransferFlags(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    USBURBRequest(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public USBURBRequest() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        boolean z;
        if (o != null && (o instanceof USBURBRequest)) {
            USBURBRequest that = (USBURBRequest) o;
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
            int thisEndpoint = getEndpoint();
            int thatEndpoint = that.getEndpoint();
            if (thisEndpoint != thatEndpoint) {
                return false;
            }
            boolean thisDirectionIn = getDirectionIn();
            boolean thatDirectionIn = that.getDirectionIn();
            if (thisDirectionIn != thatDirectionIn) {
                return false;
            }
            int thisTransferFlags = getTransferFlags();
            int thatTransferFlags = that.getTransferFlags();
            if (thisTransferFlags != thatTransferFlags) {
                return false;
            }
            byte[] thisSetup = getSetup();
            byte[] thatSetup = that.getSetup();
            if (thisSetup == null) {
                if (thatSetup == null) {
                    z = false;
                } else {
                    return false;
                }
            } else {
                z = false;
                if (!thisSetup.equals(thatSetup)) {
                    return false;
                }
            }
            int thisTransferBufferLength = getTransferBufferLength();
            int thatTransferBufferLength = that.getTransferBufferLength();
            if (thisTransferBufferLength != thatTransferBufferLength) {
                return z;
            }
            byte[] thisOutData = getOutData();
            byte[] thatOutData = that.getOutData();
            if (thisOutData == null) {
                if (thatOutData != null) {
                    return z;
                }
            } else if (!thisOutData.equals(thatOutData)) {
                return z;
            }
            int thisNumberOfPackets = getNumberOfPackets();
            int thatNumberOfPackets = that.getNumberOfPackets();
            if (thisNumberOfPackets != thatNumberOfPackets) {
                return z;
            }
            int thisStartFrame = getStartFrame();
            int thatStartFrame = that.getStartFrame();
            if (thisStartFrame != thatStartFrame) {
                return z;
            }
            int thisInterval = getInterval();
            int thatInterval = that.getInterval();
            if (thisInterval != thatInterval) {
                return z;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getDeviceID(), Long.valueOf(getSeq()), Integer.valueOf(getEndpoint()), Boolean.valueOf(getDirectionIn()), Integer.valueOf(getTransferFlags()), getSetup(), Integer.valueOf(getTransferBufferLength()), getOutData(), Integer.valueOf(getNumberOfPackets()), Integer.valueOf(getStartFrame()), Integer.valueOf(getInterval())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("USBURBRequest").append("{");
        b.append("DeviceID:").append(getDeviceID()).append(",");
        b.append("Seq:").append(getSeq()).append(",");
        b.append("Endpoint:").append(getEndpoint()).append(",");
        b.append("DirectionIn:").append(getDirectionIn()).append(",");
        b.append("TransferFlags:").append(getTransferFlags()).append(",");
        b.append("Setup:").append(getSetup()).append(",");
        b.append("TransferBufferLength:").append(getTransferBufferLength()).append(",");
        b.append("OutData:").append(getOutData()).append(",");
        b.append("NumberOfPackets:").append(getNumberOfPackets()).append(",");
        b.append("StartFrame:").append(getStartFrame()).append(",");
        b.append("Interval:").append(getInterval()).append(",");
        return b.append("}").toString();
    }
}
