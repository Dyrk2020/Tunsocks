package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class TailscaleUserGroup implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getDisplayName();

    public final native String getLoginName();

    public final native String getProfilePicURL();

    public final native long getUserID();

    public native TailscalePeerIterator peers();

    public final native void setDisplayName(String v);

    public final native void setLoginName(String v);

    public final native void setProfilePicURL(String v);

    public final native void setUserID(long v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    TailscaleUserGroup(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public TailscaleUserGroup() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof TailscaleUserGroup)) {
            return false;
        }
        TailscaleUserGroup that = (TailscaleUserGroup) o;
        long thisUserID = getUserID();
        long thatUserID = that.getUserID();
        if (thisUserID != thatUserID) {
            return false;
        }
        String thisLoginName = getLoginName();
        String thatLoginName = that.getLoginName();
        if (thisLoginName == null) {
            if (thatLoginName != null) {
                return false;
            }
        } else if (!thisLoginName.equals(thatLoginName)) {
            return false;
        }
        String thisDisplayName = getDisplayName();
        String thatDisplayName = that.getDisplayName();
        if (thisDisplayName == null) {
            if (thatDisplayName != null) {
                return false;
            }
        } else if (!thisDisplayName.equals(thatDisplayName)) {
            return false;
        }
        String thisProfilePicURL = getProfilePicURL();
        String thatProfilePicURL = that.getProfilePicURL();
        if (thisProfilePicURL == null) {
            if (thatProfilePicURL != null) {
                return false;
            }
            return true;
        }
        if (!thisProfilePicURL.equals(thatProfilePicURL)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(getUserID()), getLoginName(), getDisplayName(), getProfilePicURL()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("TailscaleUserGroup").append("{");
        b.append("UserID:").append(getUserID()).append(",");
        b.append("LoginName:").append(getLoginName()).append(",");
        b.append("DisplayName:").append(getDisplayName()).append(",");
        b.append("ProfilePicURL:").append(getProfilePicURL()).append(",");
        return b.append("}").toString();
    }
}
