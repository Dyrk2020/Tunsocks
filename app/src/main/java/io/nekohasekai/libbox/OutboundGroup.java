package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OutboundGroup implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native boolean getIsExpand();

    public native OutboundGroupItemIterator getItems();

    public final native boolean getSelectable();

    public final native String getSelected();

    public final native String getTag();

    public final native String getType();

    public final native void setIsExpand(boolean v);

    public final native void setSelectable(boolean v);

    public final native void setSelected(String v);

    public final native void setTag(String v);

    public final native void setType(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    OutboundGroup(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public OutboundGroup() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OutboundGroup)) {
            return false;
        }
        OutboundGroup that = (OutboundGroup) o;
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
        boolean thisSelectable = getSelectable();
        boolean thatSelectable = that.getSelectable();
        if (thisSelectable != thatSelectable) {
            return false;
        }
        String thisSelected = getSelected();
        String thatSelected = that.getSelected();
        if (thisSelected == null) {
            if (thatSelected != null) {
                return false;
            }
        } else if (!thisSelected.equals(thatSelected)) {
            return false;
        }
        boolean thisIsExpand = getIsExpand();
        boolean thatIsExpand = that.getIsExpand();
        if (thisIsExpand != thatIsExpand) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getTag(), getType(), Boolean.valueOf(getSelectable()), getSelected(), Boolean.valueOf(getIsExpand())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OutboundGroup").append("{");
        b.append("Tag:").append(getTag()).append(",");
        b.append("Type:").append(getType()).append(",");
        b.append("Selectable:").append(getSelectable()).append(",");
        b.append("Selected:").append(getSelected()).append(",");
        b.append("IsExpand:").append(getIsExpand()).append(",");
        return b.append("}").toString();
    }
}
