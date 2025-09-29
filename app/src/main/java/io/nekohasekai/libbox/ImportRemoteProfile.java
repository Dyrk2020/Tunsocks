package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ImportRemoteProfile implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getHost();

    public final native String getName();

    public final native String getURL();

    public final native void setHost(String v);

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

    ImportRemoteProfile(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public ImportRemoteProfile() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof ImportRemoteProfile)) {
            return false;
        }
        ImportRemoteProfile that = (ImportRemoteProfile) o;
        String thisName = getName();
        String thatName = that.getName();
        if (thisName == null) {
            if (thatName != null) {
                return false;
            }
        } else if (!thisName.equals(thatName)) {
            return false;
        }
        String thisURL = getURL();
        String thatURL = that.getURL();
        if (thisURL == null) {
            if (thatURL != null) {
                return false;
            }
        } else if (!thisURL.equals(thatURL)) {
            return false;
        }
        String thisHost = getHost();
        String thatHost = that.getHost();
        if (thisHost == null) {
            if (thatHost != null) {
                return false;
            }
            return true;
        }
        if (!thisHost.equals(thatHost)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getName(), getURL(), getHost()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("ImportRemoteProfile").append("{");
        b.append("Name:").append(getName()).append(",");
        b.append("URL:").append(getURL()).append(",");
        b.append("Host:").append(getHost()).append(",");
        return b.append("}").toString();
    }
}
