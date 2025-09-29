package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ProfilePreview implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getName();

    public final native long getProfileID();

    public final native int getType();

    public final native void setName(String v);

    public final native void setProfileID(long v);

    public final native void setType(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    ProfilePreview(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public ProfilePreview() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof ProfilePreview)) {
            return false;
        }
        ProfilePreview that = (ProfilePreview) o;
        long thisProfileID = getProfileID();
        long thatProfileID = that.getProfileID();
        if (thisProfileID != thatProfileID) {
            return false;
        }
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
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(getProfileID()), getName(), Integer.valueOf(getType())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("ProfilePreview").append("{");
        b.append("ProfileID:").append(getProfileID()).append(",");
        b.append("Name:").append(getName()).append(",");
        b.append("Type:").append(getType()).append(",");
        return b.append("}").toString();
    }
}
