package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class TailscaleSSHSession implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native void close() throws Exception;

    public native void sendInput(byte[] data) throws Exception;

    public native void sendResize(int columns, int rows, int widthPixels, int heightPixels) throws Exception;

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    TailscaleSSHSession(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public TailscaleSSHSession() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof TailscaleSSHSession)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("TailscaleSSHSession").append("{");
        return b.append("}").toString();
    }
}
