package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenConnectAuthFormField implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getKind();

    public final native String getLabel();

    public final native String getName();

    public final native String getSubmissionKey();

    public final native String getValue();

    public native OpenConnectAuthFormChoiceIterator options();

    public final native void setKind(String v);

    public final native void setLabel(String v);

    public final native void setName(String v);

    public final native void setSubmissionKey(String v);

    public final native void setValue(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    OpenConnectAuthFormField(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public OpenConnectAuthFormField() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OpenConnectAuthFormField)) {
            return false;
        }
        OpenConnectAuthFormField that = (OpenConnectAuthFormField) o;
        String thisSubmissionKey = getSubmissionKey();
        String thatSubmissionKey = that.getSubmissionKey();
        if (thisSubmissionKey == null) {
            if (thatSubmissionKey != null) {
                return false;
            }
        } else if (!thisSubmissionKey.equals(thatSubmissionKey)) {
            return false;
        }
        String thisName = getName();
        String thatName = that.getName();
        if (thisName == null) {
            if (thatName != null) {
                return false;
            }
        } else if (!thisName.equals(thatName)) {
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
        String thisKind = getKind();
        String thatKind = that.getKind();
        if (thisKind == null) {
            if (thatKind != null) {
                return false;
            }
        } else if (!thisKind.equals(thatKind)) {
            return false;
        }
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
        return Arrays.hashCode(new Object[]{getSubmissionKey(), getName(), getLabel(), getKind(), getValue()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OpenConnectAuthFormField").append("{");
        b.append("SubmissionKey:").append(getSubmissionKey()).append(",");
        b.append("Name:").append(getName()).append(",");
        b.append("Label:").append(getLabel()).append(",");
        b.append("Kind:").append(getKind()).append(",");
        b.append("Value:").append(getValue()).append(",");
        return b.append("}").toString();
    }
}
