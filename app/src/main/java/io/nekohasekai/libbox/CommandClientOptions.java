package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class CommandClientOptions implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native void addCommand(int command);

    public final native long getStatusInterval();

    public final native void setStatusInterval(long v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    CommandClientOptions(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public CommandClientOptions() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof CommandClientOptions)) {
            return false;
        }
        CommandClientOptions that = (CommandClientOptions) o;
        long thisStatusInterval = getStatusInterval();
        long thatStatusInterval = that.getStatusInterval();
        if (thisStatusInterval != thatStatusInterval) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(getStatusInterval())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("CommandClientOptions").append("{");
        b.append("StatusInterval:").append(getStatusInterval()).append(",");
        return b.append("}").toString();
    }
}
