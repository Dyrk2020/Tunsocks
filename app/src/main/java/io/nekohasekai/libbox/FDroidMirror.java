package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class FDroidMirror implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getCountry();

    public final native String getName();

    public final native String getURL();

    public final native void setCountry(String v);

    public final native void setName(String v);

    public final native void setURL(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    FDroidMirror(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public FDroidMirror() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof FDroidMirror)) {
            return false;
        }
        FDroidMirror that = (FDroidMirror) o;
        String thisURL = getURL();
        String thatURL = that.getURL();
        if (thisURL == null) {
            if (thatURL != null) {
                return false;
            }
        } else if (!thisURL.equals(thatURL)) {
            return false;
        }
        String thisCountry = getCountry();
        String thatCountry = that.getCountry();
        if (thisCountry == null) {
            if (thatCountry != null) {
                return false;
            }
        } else if (!thisCountry.equals(thatCountry)) {
            return false;
        }
        String thisName = getName();
        String thatName = that.getName();
        if (thisName == null) {
            if (thatName != null) {
                return false;
            }
            return true;
        }
        if (!thisName.equals(thatName)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getURL(), getCountry(), getName()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("FDroidMirror").append("{");
        b.append("URL:").append(getURL()).append(",");
        b.append("Country:").append(getCountry()).append(",");
        b.append("Name:").append(getName()).append(",");
        return b.append("}").toString();
    }
}
