package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ErrorMessage implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native byte[] encode();

    public final native String getMessage();

    public final native void setMessage(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    ErrorMessage(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public ErrorMessage() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof ErrorMessage)) {
            return false;
        }
        ErrorMessage that = (ErrorMessage) o;
        String thisMessage = getMessage();
        String thatMessage = that.getMessage();
        if (thisMessage == null) {
            if (thatMessage != null) {
                return false;
            }
            return true;
        }
        if (!thisMessage.equals(thatMessage)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getMessage()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("ErrorMessage").append("{");
        b.append("Message:").append(getMessage()).append(",");
        return b.append("}").toString();
    }
}
