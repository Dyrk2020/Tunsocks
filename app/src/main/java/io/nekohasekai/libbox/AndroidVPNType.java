package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class AndroidVPNType implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getCorePath();

    public final native String getCoreType();

    public final native String getGoVersion();

    public final native void setCorePath(String v);

    public final native void setCoreType(String v);

    public final native void setGoVersion(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    AndroidVPNType(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public AndroidVPNType() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof AndroidVPNType)) {
            return false;
        }
        AndroidVPNType that = (AndroidVPNType) o;
        String thisCoreType = getCoreType();
        String thatCoreType = that.getCoreType();
        if (thisCoreType == null) {
            if (thatCoreType != null) {
                return false;
            }
        } else if (!thisCoreType.equals(thatCoreType)) {
            return false;
        }
        String thisCorePath = getCorePath();
        String thatCorePath = that.getCorePath();
        if (thisCorePath == null) {
            if (thatCorePath != null) {
                return false;
            }
        } else if (!thisCorePath.equals(thatCorePath)) {
            return false;
        }
        String thisGoVersion = getGoVersion();
        String thatGoVersion = that.getGoVersion();
        if (thisGoVersion == null) {
            if (thatGoVersion != null) {
                return false;
            }
            return true;
        }
        if (!thisGoVersion.equals(thatGoVersion)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getCoreType(), getCorePath(), getGoVersion()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("AndroidVPNType").append("{");
        b.append("CoreType:").append(getCoreType()).append(",");
        b.append("CorePath:").append(getCorePath()).append(",");
        b.append("GoVersion:").append(getGoVersion()).append(",");
        return b.append("}").toString();
    }
}
