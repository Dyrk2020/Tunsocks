package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenConnectAuthFormChoice implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getLabel();

    public final native String getValue();

    public final native void setLabel(String v);

    public final native void setValue(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    OpenConnectAuthFormChoice(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public OpenConnectAuthFormChoice() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OpenConnectAuthFormChoice)) {
            return false;
        }
        OpenConnectAuthFormChoice that = (OpenConnectAuthFormChoice) o;
        String thisValue = getValue();
        String thatValue = that.getValue();
        if (thisValue == null) {
            if (thatValue != null) {
                return false;
            }
        } else if (!thisValue.equals(thatValue)) {
            return false;
        }
        String thisLabel = getLabel();
        String thatLabel = that.getLabel();
        if (thisLabel == null) {
            if (thatLabel != null) {
                return false;
            }
            return true;
        }
        if (!thisLabel.equals(thatLabel)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), getLabel()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OpenConnectAuthFormChoice").append("{");
        b.append("Value:").append(getValue()).append(",");
        b.append("Label:").append(getLabel()).append(",");
        return b.append("}").toString();
    }
}
