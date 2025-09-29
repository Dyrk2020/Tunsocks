package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OutboundGroupItem implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getTag();

    public final native String getType();

    public final native int getURLTestDelay();

    public final native long getURLTestTime();

    public final native void setTag(String v);

    public final native void setType(String v);

    public final native void setURLTestDelay(int v);

    public final native void setURLTestTime(long v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    OutboundGroupItem(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public OutboundGroupItem() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OutboundGroupItem)) {
            return false;
        }
        OutboundGroupItem that = (OutboundGroupItem) o;
        String thisTag = getTag();
        String thatTag = that.getTag();
        if (thisTag == null) {
            if (thatTag != null) {
                return false;
            }
        } else if (!thisTag.equals(thatTag)) {
            return false;
        }
        String thisType = getType();
        String thatType = that.getType();
        if (thisType == null) {
            if (thatType != null) {
                return false;
            }
        } else if (!thisType.equals(thatType)) {
            return false;
        }
        long thisURLTestTime = getURLTestTime();
        long thatURLTestTime = that.getURLTestTime();
        if (thisURLTestTime != thatURLTestTime) {
            return false;
        }
        int thisURLTestDelay = getURLTestDelay();
        int thatURLTestDelay = that.getURLTestDelay();
        if (thisURLTestDelay != thatURLTestDelay) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getTag(), getType(), Long.valueOf(getURLTestTime()), Integer.valueOf(getURLTestDelay())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OutboundGroupItem").append("{");
        b.append("Tag:").append(getTag()).append(",");
        b.append("Type:").append(getType()).append(",");
        b.append("URLTestTime:").append(getURLTestTime()).append(",");
        b.append("URLTestDelay:").append(getURLTestDelay()).append(",");
        return b.append("}").toString();
    }
}
