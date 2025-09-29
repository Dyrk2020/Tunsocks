package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OverrideOptions implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native boolean getAutoRedirect();

    public final native StringIterator getExcludePackage();

    public final native StringIterator getIncludePackage();

    public final native void setAutoRedirect(boolean v);

    public final native void setExcludePackage(StringIterator v);

    public final native void setIncludePackage(StringIterator v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    OverrideOptions(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public OverrideOptions() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OverrideOptions)) {
            return false;
        }
        OverrideOptions that = (OverrideOptions) o;
        boolean thisAutoRedirect = getAutoRedirect();
        boolean thatAutoRedirect = that.getAutoRedirect();
        if (thisAutoRedirect != thatAutoRedirect) {
            return false;
        }
        StringIterator thisIncludePackage = getIncludePackage();
        StringIterator thatIncludePackage = that.getIncludePackage();
        if (thisIncludePackage == null) {
            if (thatIncludePackage != null) {
                return false;
            }
        } else if (!thisIncludePackage.equals(thatIncludePackage)) {
            return false;
        }
        StringIterator thisExcludePackage = getExcludePackage();
        StringIterator thatExcludePackage = that.getExcludePackage();
        if (thisExcludePackage == null) {
            if (thatExcludePackage != null) {
                return false;
            }
            return true;
        }
        if (!thisExcludePackage.equals(thatExcludePackage)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(getAutoRedirect()), getIncludePackage(), getExcludePackage()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OverrideOptions").append("{");
        b.append("AutoRedirect:").append(getAutoRedirect()).append(",");
        b.append("IncludePackage:").append(getIncludePackage()).append(",");
        b.append("ExcludePackage:").append(getExcludePackage()).append(",");
        return b.append("}").toString();
    }
}
