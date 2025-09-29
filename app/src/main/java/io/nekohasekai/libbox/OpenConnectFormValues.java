package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenConnectFormValues implements Seq.Proxy {
    public final int refnum;

    private static native int __NewOpenConnectFormValues();

    public native void add(String key, String value);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public OpenConnectFormValues() {
        this.refnum = __NewOpenConnectFormValues();
        Seq.trackGoRef(this.refnum, this);
    }

    OpenConnectFormValues(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OpenConnectFormValues)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OpenConnectFormValues").append("{");
        return b.append("}").toString();
    }
}
