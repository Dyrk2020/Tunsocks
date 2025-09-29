package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class StringBox implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getValue();

    public final native void setValue(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    StringBox(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public StringBox() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof StringBox)) {
            return false;
        }
        StringBox that = (StringBox) o;
        String thisValue = getValue();
        String thatValue = that.getValue();
        if (thisValue == null) {
            if (thatValue != null) {
                return false;
            }
            return true;
        }
        if (!thisValue.equals(thatValue)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getValue()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("StringBox").append("{");
        b.append("Value:").append(getValue()).append(",");
        return b.append("}").toString();
    }
}
