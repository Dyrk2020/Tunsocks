package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenVPNChallenge implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native long getDeadline();

    public final native boolean getEcho();

    public final native String getID();

    public final native String getKind();

    public final native String getMessage();

    public final native String getPreviousError();

    public final native String getSecretMessage();

    public final native String getURL();

    public final native String getUsername();

    public final native void setDeadline(long v);

    public final native void setEcho(boolean v);

    public final native void setID(String v);

    public final native void setKind(String v);

    public final native void setMessage(String v);

    public final native void setPreviousError(String v);

    public final native void setSecretMessage(String v);

    public final native void setURL(String v);

    public final native void setUsername(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    OpenVPNChallenge(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public OpenVPNChallenge() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o != null && (o instanceof OpenVPNChallenge)) {
            OpenVPNChallenge that = (OpenVPNChallenge) o;
            String thisID = getID();
            String thatID = that.getID();
            if (thisID == null) {
                if (thatID != null) {
                    return false;
                }
            } else if (!thisID.equals(thatID)) {
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
            String thisUsername = getUsername();
            String thatUsername = that.getUsername();
            if (thisUsername == null) {
                if (thatUsername != null) {
                    return false;
                }
            } else if (!thisUsername.equals(thatUsername)) {
                return false;
            }
            String thisMessage = getMessage();
            String thatMessage = that.getMessage();
            if (thisMessage == null) {
                if (thatMessage != null) {
                    return false;
                }
            } else if (!thisMessage.equals(thatMessage)) {
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
            String thisSecretMessage = getSecretMessage();
            String thatSecretMessage = that.getSecretMessage();
            if (thisSecretMessage == null) {
                if (thatSecretMessage != null) {
                    return false;
                }
            } else if (!thisSecretMessage.equals(thatSecretMessage)) {
                return false;
            }
            boolean thisEcho = getEcho();
            boolean thatEcho = that.getEcho();
            if (thisEcho != thatEcho) {
                return false;
            }
            String thisPreviousError = getPreviousError();
            String thatPreviousError = that.getPreviousError();
            if (thisPreviousError == null) {
                if (thatPreviousError != null) {
                    return false;
                }
            } else if (!thisPreviousError.equals(thatPreviousError)) {
                return false;
            }
            long thisDeadline = getDeadline();
            long thatDeadline = that.getDeadline();
            if (thisDeadline != thatDeadline) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getID(), getKind(), getUsername(), getMessage(), getURL(), getSecretMessage(), Boolean.valueOf(getEcho()), getPreviousError(), Long.valueOf(getDeadline())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OpenVPNChallenge").append("{");
        b.append("ID:").append(getID()).append(",");
        b.append("Kind:").append(getKind()).append(",");
        b.append("Username:").append(getUsername()).append(",");
        b.append("Message:").append(getMessage()).append(",");
        b.append("URL:").append(getURL()).append(",");
        b.append("SecretMessage:").append(getSecretMessage()).append(",");
        b.append("Echo:").append(getEcho()).append(",");
        b.append("PreviousError:").append(getPreviousError()).append(",");
        b.append("Deadline:").append(getDeadline()).append(",");
        return b.append("}").toString();
    }
}
