package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class USBIPServerStatus implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native USBSharedDeviceIterator devices();

    public final native String getServerTag();

    public final native void setServerTag(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    USBIPServerStatus(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public USBIPServerStatus() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof USBIPServerStatus)) {
            return false;
        }
        USBIPServerStatus that = (USBIPServerStatus) o;
        String thisServerTag = getServerTag();
        String thatServerTag = that.getServerTag();
        if (thisServerTag == null) {
            if (thatServerTag != null) {
                return false;
            }
            return true;
        }
        if (!thisServerTag.equals(thatServerTag)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getServerTag()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("USBIPServerStatus").append("{");
        b.append("ServerTag:").append(getServerTag()).append(",");
        return b.append("}").toString();
    }
}
