package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class USBDeviceDescriptor implements Seq.Proxy {
    public final int refnum;

    private static native int __NewUSBDeviceDescriptor(String serverTag, String deviceID);

    public native void addInterface(int interfaceClass, int interfaceSubClass, int interfaceProtocol);

    public final native int getBCDDevice();

    public final native int getBusNum();

    public final native int getConfigurationValue();

    public final native int getDevNum();

    public final native int getDeviceClass();

    public final native String getDeviceID();

    public final native int getDeviceProtocol();

    public final native int getDeviceSubClass();

    public final native int getNumConfigurations();

    public final native String getProduct();

    public final native int getProductID();

    public final native String getSerial();

    public final native String getServerTag();

    public final native int getSpeed();

    public final native int getVendorID();

    public final native void setBCDDevice(int v);

    public final native void setBusNum(int v);

    public final native void setConfigurationValue(int v);

    public final native void setDevNum(int v);

    public final native void setDeviceClass(int v);

    public final native void setDeviceID(String v);

    public final native void setDeviceProtocol(int v);

    public final native void setDeviceSubClass(int v);

    public final native void setNumConfigurations(int v);

    public final native void setProduct(String v);

    public final native void setProductID(int v);

    public final native void setSerial(String v);

    public final native void setServerTag(String v);

    public final native void setSpeed(int v);

    public final native void setVendorID(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public USBDeviceDescriptor(String serverTag, String deviceID) {
        this.refnum = __NewUSBDeviceDescriptor(serverTag, deviceID);
        Seq.trackGoRef(this.refnum, this);
    }

    USBDeviceDescriptor(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public boolean equals(Object o) {
        if (o != null && (o instanceof USBDeviceDescriptor)) {
            USBDeviceDescriptor that = (USBDeviceDescriptor) o;
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
        return Arrays.hashCode(new Object[]{getServerTag(), getDeviceID(), Integer.valueOf(getBusNum()), Integer.valueOf(getDevNum()), Integer.valueOf(getSpeed()), Integer.valueOf(getVendorID()), Integer.valueOf(getProductID()), Integer.valueOf(getBCDDevice()), Integer.valueOf(getDeviceClass()), Integer.valueOf(getDeviceSubClass()), Integer.valueOf(getDeviceProtocol()), Integer.valueOf(getConfigurationValue()), Integer.valueOf(getNumConfigurations()), getSerial(), getProduct()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("USBDeviceDescriptor").append("{");
        b.append("ServerTag:").append(getServerTag()).append(",");
        b.append("DeviceID:").append(getDeviceID()).append(",");
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
