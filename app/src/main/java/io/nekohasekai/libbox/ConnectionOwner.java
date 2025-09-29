package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ConnectionOwner implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native StringIterator androidPackageNames();

    public final native String getProcessPath();

    public final native int getUserId();

    public final native String getUserName();

    public native void setAndroidPackageNames(StringIterator names);

    public final native void setProcessPath(String v);

    public final native void setUserId(int v);

    public final native void setUserName(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    ConnectionOwner(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public ConnectionOwner() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof ConnectionOwner)) {
            return false;
        }
        ConnectionOwner that = (ConnectionOwner) o;
        int thisUserId = getUserId();
        int thatUserId = that.getUserId();
        if (thisUserId != thatUserId) {
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
        return Arrays.hashCode(new Object[]{Integer.valueOf(getUserId()), getUserName(), getProcessPath()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("ConnectionOwner").append("{");
        b.append("UserId:").append(getUserId()).append(",");
        b.append("UserName:").append(getUserName()).append(",");
        b.append("ProcessPath:").append(getProcessPath()).append(",");
        return b.append("}").toString();
    }
}
