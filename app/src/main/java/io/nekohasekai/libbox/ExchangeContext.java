package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ExchangeContext implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native void errnoCode(int code);

    public native void errorCode(int code);

    public native void onCancel(Func callback);

    public native void rawSuccess(byte[] result);

    public native void success(String result);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    ExchangeContext(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public ExchangeContext() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof ExchangeContext)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("ExchangeContext").append("{");
        return b.append("}").toString();
    }
}
