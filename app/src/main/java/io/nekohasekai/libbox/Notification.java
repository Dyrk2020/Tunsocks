package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class Notification implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getBody();

    public final native String getIdentifier();

    public final native String getOpenURL();

    public final native String getSubtitle();

    public final native String getTitle();

    public final native int getTypeID();

    public final native String getTypeName();

    public final native void setBody(String v);

    public final native void setIdentifier(String v);

    public final native void setOpenURL(String v);

    public final native void setSubtitle(String v);

    public final native void setTitle(String v);

    public final native void setTypeID(int v);

    public final native void setTypeName(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    Notification(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public Notification() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o != null && (o instanceof Notification)) {
            Notification that = (Notification) o;
            String thisIdentifier = getIdentifier();
            String thatIdentifier = that.getIdentifier();
            if (thisIdentifier == null) {
                if (thatIdentifier != null) {
                    return false;
                }
            } else if (!thisIdentifier.equals(thatIdentifier)) {
                return false;
            }
            String thisTypeName = getTypeName();
            String thatTypeName = that.getTypeName();
            if (thisTypeName == null) {
                if (thatTypeName != null) {
                    return false;
                }
            } else if (!thisTypeName.equals(thatTypeName)) {
                return false;
            }
            int thisTypeID = getTypeID();
            int thatTypeID = that.getTypeID();
            if (thisTypeID != thatTypeID) {
                return false;
            }
            String thisTitle = getTitle();
            String thatTitle = that.getTitle();
            if (thisTitle == null) {
                if (thatTitle != null) {
                    return false;
                }
            } else if (!thisTitle.equals(thatTitle)) {
                return false;
            }
            String thisSubtitle = getSubtitle();
            String thatSubtitle = that.getSubtitle();
            if (thisSubtitle == null) {
                if (thatSubtitle != null) {
                    return false;
                }
            } else if (!thisSubtitle.equals(thatSubtitle)) {
                return false;
            }
            String thisBody = getBody();
            String thatBody = that.getBody();
            if (thisBody == null) {
                if (thatBody != null) {
                    return false;
                }
            } else if (!thisBody.equals(thatBody)) {
                return false;
            }
            String thisOpenURL = getOpenURL();
            String thatOpenURL = that.getOpenURL();
            if (thisOpenURL == null) {
                if (thatOpenURL != null) {
                    return false;
                }
                return true;
            }
            if (!thisOpenURL.equals(thatOpenURL)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getIdentifier(), getTypeName(), Integer.valueOf(getTypeID()), getTitle(), getSubtitle(), getBody(), getOpenURL()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("Notification").append("{");
        b.append("Identifier:").append(getIdentifier()).append(",");
        b.append("TypeName:").append(getTypeName()).append(",");
        b.append("TypeID:").append(getTypeID()).append(",");
        b.append("Title:").append(getTitle()).append(",");
        b.append("Subtitle:").append(getSubtitle()).append(",");
        b.append("Body:").append(getBody()).append(",");
        b.append("OpenURL:").append(getOpenURL()).append(",");
        return b.append("}").toString();
    }
}
