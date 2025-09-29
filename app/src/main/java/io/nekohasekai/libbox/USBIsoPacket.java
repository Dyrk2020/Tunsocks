package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class USBIsoPacket implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native int getActualLength();

    public final native int getLength();

    public final native int getOffset();

    public final native int getStatus();

    public final native void setActualLength(int v);

    public final native void setLength(int v);

    public final native void setOffset(int v);

    public final native void setStatus(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    USBIsoPacket(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public USBIsoPacket() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof USBIsoPacket)) {
            return false;
        }
        USBIsoPacket that = (USBIsoPacket) o;
        int thisOffset = getOffset();
        int thatOffset = that.getOffset();
        if (thisOffset != thatOffset) {
            return false;
        }
        int thisLength = getLength();
        int thatLength = that.getLength();
        if (thisLength != thatLength) {
            return false;
        }
        int thisActualLength = getActualLength();
        int thatActualLength = that.getActualLength();
        if (thisActualLength != thatActualLength) {
            return false;
        }
        int thisStatus = getStatus();
        int thatStatus = that.getStatus();
        if (thisStatus != thatStatus) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(getOffset()), Integer.valueOf(getLength()), Integer.valueOf(getActualLength()), Integer.valueOf(getStatus())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("USBIsoPacket").append("{");
        b.append("Offset:").append(getOffset()).append(",");
        b.append("Length:").append(getLength()).append(",");
        b.append("ActualLength:").append(getActualLength()).append(",");
        b.append("Status:").append(getStatus()).append(",");
        return b.append("}").toString();
    }
}
