package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenVPNChallengeResponse implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getPassword();

    public final native String getSecret();

    public final native String getUsername();

    public final native void setPassword(String v);

    public final native void setSecret(String v);

    public final native void setUsername(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    OpenVPNChallengeResponse(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public OpenVPNChallengeResponse() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OpenVPNChallengeResponse)) {
            return false;
        }
        OpenVPNChallengeResponse that = (OpenVPNChallengeResponse) o;
        String thisUsername = getUsername();
        String thatUsername = that.getUsername();
        if (thisUsername == null) {
            if (thatUsername != null) {
                return false;
            }
        } else if (!thisUsername.equals(thatUsername)) {
            return false;
        }
        String thisPassword = getPassword();
        String thatPassword = that.getPassword();
        if (thisPassword == null) {
            if (thatPassword != null) {
                return false;
            }
        } else if (!thisPassword.equals(thatPassword)) {
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
        return Arrays.hashCode(new Object[]{getUsername(), getPassword(), getSecret()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OpenVPNChallengeResponse").append("{");
        b.append("Username:").append(getUsername()).append(",");
        b.append("Password:").append(getPassword()).append(",");
        b.append("Secret:").append(getSecret()).append(",");
        return b.append("}").toString();
    }
}
