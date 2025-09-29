package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoteConnectionOptions implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getSecret();

    public final native String getURL();

    public final native void setSecret(String v);

    public final native void setURL(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    RemoteConnectionOptions(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public RemoteConnectionOptions() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof RemoteConnectionOptions)) {
            return false;
        }
        RemoteConnectionOptions that = (RemoteConnectionOptions) o;
        String thisURL = getURL();
        String thatURL = that.getURL();
        if (thisURL == null) {
            if (thatURL != null) {
                return false;
            }
        } else if (!thisURL.equals(thatURL)) {
            return false;
        }
        String thisSecret = getSecret();
        String thatSecret = that.getSecret();
        if (thisSecret == null) {
            if (thatSecret != null) {
                return false;
            }
            return true;
        }
        if (!thisSecret.equals(thatSecret)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getURL(), getSecret()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("RemoteConnectionOptions").append("{");
        b.append("URL:").append(getURL()).append(",");
        b.append("Secret:").append(getSecret()).append(",");
        return b.append("}").toString();
    }
}
