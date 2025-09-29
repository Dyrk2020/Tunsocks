package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class FDroidUpdateInfo implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getDownloadURL();

    public final native String getFileSHA256();

    public final native long getFileSize();

    public final native int getVersionCode();

    public final native String getVersionName();

    public final native void setDownloadURL(String v);

    public final native void setFileSHA256(String v);

    public final native void setFileSize(long v);

    public final native void setVersionCode(int v);

    public final native void setVersionName(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    FDroidUpdateInfo(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public FDroidUpdateInfo() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof FDroidUpdateInfo)) {
            return false;
        }
        FDroidUpdateInfo that = (FDroidUpdateInfo) o;
        int thisVersionCode = getVersionCode();
        int thatVersionCode = that.getVersionCode();
        if (thisVersionCode != thatVersionCode) {
            return false;
        }
        String thisVersionName = getVersionName();
        String thatVersionName = that.getVersionName();
        if (thisVersionName == null) {
            if (thatVersionName != null) {
                return false;
            }
        } else if (!thisVersionName.equals(thatVersionName)) {
            return false;
        }
        String thisDownloadURL = getDownloadURL();
        String thatDownloadURL = that.getDownloadURL();
        if (thisDownloadURL == null) {
            if (thatDownloadURL != null) {
                return false;
            }
        } else if (!thisDownloadURL.equals(thatDownloadURL)) {
            return false;
        }
        long thisFileSize = getFileSize();
        long thatFileSize = that.getFileSize();
        if (thisFileSize != thatFileSize) {
            return false;
        }
        String thisFileSHA256 = getFileSHA256();
        String thatFileSHA256 = that.getFileSHA256();
        if (thisFileSHA256 == null) {
            return thatFileSHA256 == null;
        }
        return thisFileSHA256.equals(thatFileSHA256);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(getVersionCode()), getVersionName(), getDownloadURL(), Long.valueOf(getFileSize()), getFileSHA256()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("FDroidUpdateInfo").append("{");
        b.append("VersionCode:").append(getVersionCode()).append(",");
        b.append("VersionName:").append(getVersionName()).append(",");
        b.append("DownloadURL:").append(getDownloadURL()).append(",");
        b.append("FileSize:").append(getFileSize()).append(",");
        b.append("FileSHA256:").append(getFileSHA256()).append(",");
        return b.append("}").toString();
    }
}
