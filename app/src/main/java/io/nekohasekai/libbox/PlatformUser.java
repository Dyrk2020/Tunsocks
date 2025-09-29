package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class PlatformUser implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native int getGid();

    public final native String getHomeDir();

    public final native String getShell();

    public final native int getUid();

    public final native String getUsername();

    public native Int32Iterator groups();

    public final native void setGid(int v);

    public native void setGroups(Int32Iterator groups);

    public final native void setHomeDir(String v);

    public final native void setShell(String v);

    public final native void setUid(int v);

    public final native void setUsername(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    PlatformUser(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public PlatformUser() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof PlatformUser)) {
            return false;
        }
        PlatformUser that = (PlatformUser) o;
        String thisUsername = getUsername();
        String thatUsername = that.getUsername();
        if (thisUsername == null) {
            if (thatUsername != null) {
                return false;
            }
        } else if (!thisUsername.equals(thatUsername)) {
            return false;
        }
        int thisUid = getUid();
        int thatUid = that.getUid();
        if (thisUid != thatUid) {
            return false;
        }
        int thisGid = getGid();
        int thatGid = that.getGid();
        if (thisGid != thatGid) {
            return false;
        }
        String thisHomeDir = getHomeDir();
        String thatHomeDir = that.getHomeDir();
        if (thisHomeDir == null) {
            if (thatHomeDir != null) {
                return false;
            }
        } else if (!thisHomeDir.equals(thatHomeDir)) {
            return false;
        }
        String thisShell = getShell();
        String thatShell = that.getShell();
        if (thisShell == null) {
            if (thatShell != null) {
                return false;
            }
            return true;
        }
        if (!thisShell.equals(thatShell)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getUsername(), Integer.valueOf(getUid()), Integer.valueOf(getGid()), getHomeDir(), getShell()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("PlatformUser").append("{");
        b.append("Username:").append(getUsername()).append(",");
        b.append("Uid:").append(getUid()).append(",");
        b.append("Gid:").append(getGid()).append(",");
        b.append("HomeDir:").append(getHomeDir()).append(",");
        b.append("Shell:").append(getShell()).append(",");
        return b.append("}").toString();
    }
}
