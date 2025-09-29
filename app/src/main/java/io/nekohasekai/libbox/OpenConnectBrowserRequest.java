package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenConnectBrowserRequest implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native StringIterator cookieNames();

    public final native String getFinalURL();

    public final native String getURL();

    public native StringIterator headerNames();

    public final native void setFinalURL(String v);

    public final native void setURL(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    OpenConnectBrowserRequest(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public OpenConnectBrowserRequest() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OpenConnectBrowserRequest)) {
            return false;
        }
        OpenConnectBrowserRequest that = (OpenConnectBrowserRequest) o;
        String thisURL = getURL();
        String thatURL = that.getURL();
        if (thisURL == null) {
            if (thatURL != null) {
                return false;
            }
        } else if (!thisURL.equals(thatURL)) {
            return false;
        }
        String thisFinalURL = getFinalURL();
        String thatFinalURL = that.getFinalURL();
        if (thisFinalURL == null) {
            if (thatFinalURL != null) {
                return false;
            }
            return true;
        }
        if (!thisFinalURL.equals(thatFinalURL)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getURL(), getFinalURL()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OpenConnectBrowserRequest").append("{");
        b.append("URL:").append(getURL()).append(",");
        b.append("FinalURL:").append(getFinalURL()).append(",");
        return b.append("}").toString();
    }
}
