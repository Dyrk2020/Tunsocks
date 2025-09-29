package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ProfileContentRequest implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public native byte[] encode();

    public final native long getProfileID();

    public final native void setProfileID(long v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    ProfileContentRequest(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public ProfileContentRequest() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof ProfileContentRequest)) {
            return false;
        }
        ProfileContentRequest that = (ProfileContentRequest) o;
        long thisProfileID = getProfileID();
        long thatProfileID = that.getProfileID();
        if (thisProfileID != thatProfileID) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(getProfileID())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("ProfileContentRequest").append("{");
        b.append("ProfileID:").append(getProfileID()).append(",");
        return b.append("}").toString();
    }
}
