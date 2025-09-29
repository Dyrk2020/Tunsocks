package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenConnectAuthChallenge implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getBanner();

    public final native OpenConnectBrowserRequest getBrowser();

    public final native String getError();

    public final native OpenConnectAuthForm getForm();

    public final native String getID();

    public final native String getMessage();

    public final native void setBanner(String v);

    public final native void setBrowser(OpenConnectBrowserRequest v);

    public final native void setError(String v);

    public final native void setForm(OpenConnectAuthForm v);

    public final native void setID(String v);

    public final native void setMessage(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    OpenConnectAuthChallenge(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public OpenConnectAuthChallenge() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OpenConnectAuthChallenge)) {
            return false;
        }
        OpenConnectAuthChallenge that = (OpenConnectAuthChallenge) o;
        String thisID = getID();
        String thatID = that.getID();
        if (thisID == null) {
            if (thatID != null) {
                return false;
            }
        } else if (!thisID.equals(thatID)) {
            return false;
        }
        String thisBanner = getBanner();
        String thatBanner = that.getBanner();
        if (thisBanner == null) {
            if (thatBanner != null) {
                return false;
            }
        } else if (!thisBanner.equals(thatBanner)) {
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
        String thisError = getError();
        String thatError = that.getError();
        if (thisError == null) {
            if (thatError != null) {
                return false;
            }
        } else if (!thisError.equals(thatError)) {
            return false;
        }
        OpenConnectAuthForm thisForm = getForm();
        OpenConnectAuthForm thatForm = that.getForm();
        if (thisForm == null) {
            if (thatForm != null) {
                return false;
            }
        } else if (!thisForm.equals(thatForm)) {
            return false;
        }
        OpenConnectBrowserRequest thisBrowser = getBrowser();
        OpenConnectBrowserRequest thatBrowser = that.getBrowser();
        if (thisBrowser == null) {
            return thatBrowser == null;
        }
        return thisBrowser.equals(thatBrowser);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getID(), getBanner(), getMessage(), getError(), getForm(), getBrowser()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OpenConnectAuthChallenge").append("{");
        b.append("ID:").append(getID()).append(",");
        b.append("Banner:").append(getBanner()).append(",");
        b.append("Message:").append(getMessage()).append(",");
        b.append("Error:").append(getError()).append(",");
        b.append("Form:").append(getForm()).append(",");
        b.append("Browser:").append(getBrowser()).append(",");
        return b.append("}").toString();
    }
}
