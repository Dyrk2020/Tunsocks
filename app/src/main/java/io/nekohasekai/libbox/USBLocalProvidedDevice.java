package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class USBLocalProvidedDevice implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getDeviceID();

    public final native String getLabel();

    public final native String getLocalDeviceID();

    public final native int getProductID();

    public final native String getServerTag();

    public final native int getVendorID();

    public final native void setDeviceID(String v);

    public final native void setLabel(String v);

    public final native void setLocalDeviceID(String v);

    public final native void setProductID(int v);

    public final native void setServerTag(String v);

    public final native void setVendorID(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    USBLocalProvidedDevice(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public USBLocalProvidedDevice() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof USBLocalProvidedDevice)) {
            return false;
        }
        USBLocalProvidedDevice that = (USBLocalProvidedDevice) o;
        String thisServerTag = getServerTag();
        String thatServerTag = that.getServerTag();
        if (thisServerTag == null) {
            if (thatServerTag != null) {
                return false;
            }
        } else if (!thisServerTag.equals(thatServerTag)) {
            return false;
        }
        String thisDeviceID = getDeviceID();
        String thatDeviceID = that.getDeviceID();
        if (thisDeviceID == null) {
            if (thatDeviceID != null) {
                return false;
            }
        } else if (!thisDeviceID.equals(thatDeviceID)) {
            return false;
        }
        String thisLocalDeviceID = getLocalDeviceID();
        String thatLocalDeviceID = that.getLocalDeviceID();
        if (thisLocalDeviceID == null) {
            if (thatLocalDeviceID != null) {
                return false;
            }
        } else if (!thisLocalDeviceID.equals(thatLocalDeviceID)) {
            return false;
        }
        String thisLabel = getLabel();
        String thatLabel = that.getLabel();
        if (thisLabel == null) {
            if (thatLabel != null) {
                return false;
            }
        } else if (!thisLabel.equals(thatLabel)) {
            return false;
        }
        int thisVendorID = getVendorID();
        int thatVendorID = that.getVendorID();
        if (thisVendorID != thatVendorID) {
            return false;
        }
        int thisProductID = getProductID();
        int thatProductID = that.getProductID();
        if (thisProductID != thatProductID) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getServerTag(), getDeviceID(), getLocalDeviceID(), getLabel(), Integer.valueOf(getVendorID()), Integer.valueOf(getProductID())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("USBLocalProvidedDevice").append("{");
        b.append("ServerTag:").append(getServerTag()).append(",");
        b.append("DeviceID:").append(getDeviceID()).append(",");
        b.append("LocalDeviceID:").append(getLocalDeviceID()).append(",");
        b.append("Label:").append(getLabel()).append(",");
        b.append("VendorID:").append(getVendorID()).append(",");
        b.append("ProductID:").append(getProductID()).append(",");
        return b.append("}").toString();
    }
}
