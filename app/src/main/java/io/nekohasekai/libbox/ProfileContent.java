package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ProfileContent implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native byte[] encode();

    public final native boolean getAutoUpdate();

    public final native int getAutoUpdateInterval();

    public final native String getConfig();

    public final native long getLastUpdated();

    public final native String getName();

    public final native String getRemotePath();

    public final native int getType();

    public final native void setAutoUpdate(boolean v);

    public final native void setAutoUpdateInterval(int v);

    public final native void setConfig(String v);

    public final native void setLastUpdated(long v);

    public final native void setName(String v);

    public final native void setRemotePath(String v);

    public final native void setType(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    ProfileContent(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public ProfileContent() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof ProfileContent)) {
            return false;
        }
        ProfileContent that = (ProfileContent) o;
        String thisName = getName();
        String thatName = that.getName();
        if (thisName == null) {
            if (thatName != null) {
                return false;
            }
        } else if (!thisName.equals(thatName)) {
            return false;
        }
        int thisType = getType();
        int thatType = that.getType();
        if (thisType != thatType) {
            return false;
        }
        String thisConfig = getConfig();
        String thatConfig = that.getConfig();
        if (thisConfig == null) {
            if (thatConfig != null) {
                return false;
            }
        } else if (!thisConfig.equals(thatConfig)) {
            return false;
        }
        String thisRemotePath = getRemotePath();
        String thatRemotePath = that.getRemotePath();
        if (thisRemotePath == null) {
            if (thatRemotePath != null) {
                return false;
            }
        } else if (!thisRemotePath.equals(thatRemotePath)) {
            return false;
        }
        boolean thisAutoUpdate = getAutoUpdate();
        boolean thatAutoUpdate = that.getAutoUpdate();
        if (thisAutoUpdate != thatAutoUpdate) {
            return false;
        }
        int thisAutoUpdateInterval = getAutoUpdateInterval();
        int thatAutoUpdateInterval = that.getAutoUpdateInterval();
        if (thisAutoUpdateInterval != thatAutoUpdateInterval) {
            return false;
        }
        long thisLastUpdated = getLastUpdated();
        long thatLastUpdated = that.getLastUpdated();
        return thisLastUpdated == thatLastUpdated;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getName(), Integer.valueOf(getType()), getConfig(), getRemotePath(), Boolean.valueOf(getAutoUpdate()), Integer.valueOf(getAutoUpdateInterval()), Long.valueOf(getLastUpdated())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("ProfileContent").append("{");
        b.append("Name:").append(getName()).append(",");
        b.append("Type:").append(getType()).append(",");
        b.append("Config:").append(getConfig()).append(",");
        b.append("RemotePath:").append(getRemotePath()).append(",");
        b.append("AutoUpdate:").append(getAutoUpdate()).append(",");
        b.append("AutoUpdateInterval:").append(getAutoUpdateInterval()).append(",");
        b.append("LastUpdated:").append(getLastUpdated()).append(",");
        return b.append("}").toString();
    }
}
