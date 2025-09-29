package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ProcessInfo implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native long getProcessID();

    public final native String getProcessPath();

    public final native int getUserID();

    public final native String getUserName();

    public native StringIterator packageNames();

    public final native void setProcessID(long v);

    public final native void setProcessPath(String v);

    public final native void setUserID(int v);

    public final native void setUserName(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    ProcessInfo(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public ProcessInfo() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof ProcessInfo)) {
            return false;
        }
        ProcessInfo that = (ProcessInfo) o;
        long thisProcessID = getProcessID();
        long thatProcessID = that.getProcessID();
        if (thisProcessID != thatProcessID) {
            return false;
        }
        int thisUserID = getUserID();
        int thatUserID = that.getUserID();
        if (thisUserID != thatUserID) {
            return false;
        }
        String thisUserName = getUserName();
        String thatUserName = that.getUserName();
        if (thisUserName == null) {
            if (thatUserName != null) {
                return false;
            }
        } else if (!thisUserName.equals(thatUserName)) {
            return false;
        }
        String thisProcessPath = getProcessPath();
        String thatProcessPath = that.getProcessPath();
        if (thisProcessPath == null) {
            if (thatProcessPath != null) {
                return false;
            }
            return true;
        }
        if (!thisProcessPath.equals(thatProcessPath)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(getProcessID()), Integer.valueOf(getUserID()), getUserName(), getProcessPath()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("ProcessInfo").append("{");
        b.append("ProcessID:").append(getProcessID()).append(",");
        b.append("UserID:").append(getUserID()).append(",");
        b.append("UserName:").append(getUserName()).append(",");
        b.append("ProcessPath:").append(getProcessPath()).append(",");
        return b.append("}").toString();
    }
}
