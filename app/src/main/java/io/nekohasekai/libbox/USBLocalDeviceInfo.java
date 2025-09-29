package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class USBLocalDeviceInfo implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native int getBCDDevice();

    public final native int getBackend();

    public final native String getBusID();

    public final native int getBusNum();

    public final native int getConfigurationValue();

    public final native int getDevNum();

    public final native int getDeviceClass();

    public final native int getDeviceProtocol();

    public final native int getDeviceSubClass();

    public final native int getNumConfigurations();

    public final native String getProduct();

    public final native int getProductID();

    public final native String getSerial();

    public final native int getSpeed();

    public final native String getStableID();

    public final native int getVendorID();

    public native USBSharedDeviceInterfaceIterator interfaces();

    public final native void setBCDDevice(int v);

    public final native void setBackend(int v);

    public final native void setBusID(String v);

    public final native void setBusNum(int v);

    public final native void setConfigurationValue(int v);

    public final native void setDevNum(int v);

    public final native void setDeviceClass(int v);

    public final native void setDeviceProtocol(int v);

    public final native void setDeviceSubClass(int v);

    public final native void setNumConfigurations(int v);

    public final native void setProduct(String v);

    public final native void setProductID(int v);

    public final native void setSerial(String v);

    public final native void setSpeed(int v);

    public final native void setStableID(String v);

    public final native void setVendorID(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    USBLocalDeviceInfo(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public USBLocalDeviceInfo() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o != null && (o instanceof USBLocalDeviceInfo)) {
            USBLocalDeviceInfo that = (USBLocalDeviceInfo) o;
            String thisStableID = getStableID();
            String thatStableID = that.getStableID();
            if (thisStableID == null) {
                if (thatStableID != null) {
                    return false;
                }
            } else if (!thisStableID.equals(thatStableID)) {
                return false;
            }
            String thisBusID = getBusID();
            String thatBusID = that.getBusID();
            if (thisBusID == null) {
                if (thatBusID != null) {
                    return false;
                }
            } else if (!thisBusID.equals(thatBusID)) {
                return false;
            }
            int thisBackend = getBackend();
            int thatBackend = that.getBackend();
            if (thisBackend != thatBackend) {
                return false;
            }
            int thisBusNum = getBusNum();
            int thatBusNum = that.getBusNum();
            if (thisBusNum != thatBusNum) {
                return false;
            }
            int thisDevNum = getDevNum();
            int thatDevNum = that.getDevNum();
            if (thisDevNum != thatDevNum) {
                return false;
            }
            int thisSpeed = getSpeed();
            int thatSpeed = that.getSpeed();
            if (thisSpeed != thatSpeed) {
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
            int thisBCDDevice = getBCDDevice();
            int thatBCDDevice = that.getBCDDevice();
            if (thisBCDDevice != thatBCDDevice) {
                return false;
            }
            int thisDeviceClass = getDeviceClass();
            int thatDeviceClass = that.getDeviceClass();
            if (thisDeviceClass != thatDeviceClass) {
                return false;
            }
            int thisDeviceSubClass = getDeviceSubClass();
            int thatDeviceSubClass = that.getDeviceSubClass();
            if (thisDeviceSubClass != thatDeviceSubClass) {
                return false;
            }
            int thisDeviceProtocol = getDeviceProtocol();
            int thatDeviceProtocol = that.getDeviceProtocol();
            if (thisDeviceProtocol != thatDeviceProtocol) {
                return false;
            }
            int thisConfigurationValue = getConfigurationValue();
            int thatConfigurationValue = that.getConfigurationValue();
            if (thisConfigurationValue != thatConfigurationValue) {
                return false;
            }
            int thisNumConfigurations = getNumConfigurations();
            int thatNumConfigurations = that.getNumConfigurations();
            if (thisNumConfigurations != thatNumConfigurations) {
                return false;
            }
            String thisSerial = getSerial();
            String thatSerial = that.getSerial();
            if (thisSerial == null) {
                if (thatSerial != null) {
                    return false;
                }
            } else if (!thisSerial.equals(thatSerial)) {
                return false;
            }
            String thisProduct = getProduct();
            String thatProduct = that.getProduct();
            if (thisProduct == null) {
                if (thatProduct != null) {
                    return false;
                }
                return true;
            }
            if (!thisProduct.equals(thatProduct)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getStableID(), getBusID(), Integer.valueOf(getBackend()), Integer.valueOf(getBusNum()), Integer.valueOf(getDevNum()), Integer.valueOf(getSpeed()), Integer.valueOf(getVendorID()), Integer.valueOf(getProductID()), Integer.valueOf(getBCDDevice()), Integer.valueOf(getDeviceClass()), Integer.valueOf(getDeviceSubClass()), Integer.valueOf(getDeviceProtocol()), Integer.valueOf(getConfigurationValue()), Integer.valueOf(getNumConfigurations()), getSerial(), getProduct()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("USBLocalDeviceInfo").append("{");
        b.append("StableID:").append(getStableID()).append(",");
        b.append("BusID:").append(getBusID()).append(",");
        b.append("Backend:").append(getBackend()).append(",");
        b.append("BusNum:").append(getBusNum()).append(",");
        b.append("DevNum:").append(getDevNum()).append(",");
        b.append("Speed:").append(getSpeed()).append(",");
        b.append("VendorID:").append(getVendorID()).append(",");
        b.append("ProductID:").append(getProductID()).append(",");
        b.append("BCDDevice:").append(getBCDDevice()).append(",");
        b.append("DeviceClass:").append(getDeviceClass()).append(",");
        b.append("DeviceSubClass:").append(getDeviceSubClass()).append(",");
        b.append("DeviceProtocol:").append(getDeviceProtocol()).append(",");
        b.append("ConfigurationValue:").append(getConfigurationValue()).append(",");
        b.append("NumConfigurations:").append(getNumConfigurations()).append(",");
        b.append("Serial:").append(getSerial()).append(",");
        b.append("Product:").append(getProduct()).append(",");
        return b.append("}").toString();
    }
}
