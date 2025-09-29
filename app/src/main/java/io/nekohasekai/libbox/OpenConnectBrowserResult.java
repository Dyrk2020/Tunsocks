package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenConnectBrowserResult implements Seq.Proxy {
    public final int refnum;

    private static native int __NewOpenConnectBrowserResult(String finalURL);

    public native void addCookie(String name, String value);

    public native void addHeader(String name, String value);

    public final native String getFinalURL();

    public final native void setFinalURL(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public OpenConnectBrowserResult(String finalURL) {
        this.refnum = __NewOpenConnectBrowserResult(finalURL);
        Seq.trackGoRef(this.refnum, this);
    }

    OpenConnectBrowserResult(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OpenConnectBrowserResult)) {
            return false;
        }
        OpenConnectBrowserResult that = (OpenConnectBrowserResult) o;
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
        return Arrays.hashCode(new Object[]{getFinalURL()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OpenConnectBrowserResult").append("{");
        b.append("FinalURL:").append(getFinalURL()).append(",");
        return b.append("}").toString();
    }
}
