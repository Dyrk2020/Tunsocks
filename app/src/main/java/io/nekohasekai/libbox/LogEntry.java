package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class LogEntry implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native int getLevel();

    public final native String getMessage();

    public final native void setLevel(int v);

    public final native void setMessage(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    LogEntry(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public LogEntry() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof LogEntry)) {
            return false;
        }
        LogEntry that = (LogEntry) o;
        int thisLevel = getLevel();
        int thatLevel = that.getLevel();
        if (thisLevel != thatLevel) {
            return false;
        }
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
        return Arrays.hashCode(new Object[]{Integer.valueOf(getLevel()), getMessage()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("LogEntry").append("{");
        b.append("Level:").append(getLevel()).append(",");
        b.append("Message:").append(getMessage()).append(",");
        return b.append("}").toString();
    }
}
