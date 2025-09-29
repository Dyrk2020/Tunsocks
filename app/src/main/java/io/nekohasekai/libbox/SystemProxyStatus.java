package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class SystemProxyStatus implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native boolean getAvailable();

    public final native boolean getEnabled();

    public final native void setAvailable(boolean v);

    public final native void setEnabled(boolean v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    SystemProxyStatus(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public SystemProxyStatus() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof SystemProxyStatus)) {
            return false;
        }
        SystemProxyStatus that = (SystemProxyStatus) o;
        boolean thisAvailable = getAvailable();
        boolean thatAvailable = that.getAvailable();
        if (thisAvailable != thatAvailable) {
            return false;
        }
        boolean thisEnabled = getEnabled();
        boolean thatEnabled = that.getEnabled();
        if (thisEnabled != thatEnabled) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(getAvailable()), Boolean.valueOf(getEnabled())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("SystemProxyStatus").append("{");
        b.append("Available:").append(getAvailable()).append(",");
        b.append("Enabled:").append(getEnabled()).append(",");
        return b.append("}").toString();
    }
}
