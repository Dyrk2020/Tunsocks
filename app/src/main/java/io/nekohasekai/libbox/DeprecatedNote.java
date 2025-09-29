package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class DeprecatedNote implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getDeprecatedVersion();

    public final native String getDescription();

    public final native String getEnvName();

    public final native String getMigrationLink();

    public final native String getName();

    public final native String getScheduledVersion();

    public native boolean impending();

    public native String message();

    public native String messageWithLink();

    public final native void setDeprecatedVersion(String v);

    public final native void setDescription(String v);

    public final native void setEnvName(String v);

    public final native void setMigrationLink(String v);

    public final native void setName(String v);

    public final native void setScheduledVersion(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    DeprecatedNote(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public DeprecatedNote() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof DeprecatedNote)) {
            return false;
        }
        DeprecatedNote that = (DeprecatedNote) o;
        String thisName = getName();
        String thatName = that.getName();
        if (thisName == null) {
            if (thatName != null) {
                return false;
            }
        } else if (!thisName.equals(thatName)) {
            return false;
        }
        String thisDescription = getDescription();
        String thatDescription = that.getDescription();
        if (thisDescription == null) {
            if (thatDescription != null) {
                return false;
            }
        } else if (!thisDescription.equals(thatDescription)) {
            return false;
        }
        String thisDeprecatedVersion = getDeprecatedVersion();
        String thatDeprecatedVersion = that.getDeprecatedVersion();
        if (thisDeprecatedVersion == null) {
            if (thatDeprecatedVersion != null) {
                return false;
            }
        } else if (!thisDeprecatedVersion.equals(thatDeprecatedVersion)) {
            return false;
        }
        String thisScheduledVersion = getScheduledVersion();
        String thatScheduledVersion = that.getScheduledVersion();
        if (thisScheduledVersion == null) {
            if (thatScheduledVersion != null) {
                return false;
            }
        } else if (!thisScheduledVersion.equals(thatScheduledVersion)) {
            return false;
        }
        String thisEnvName = getEnvName();
        String thatEnvName = that.getEnvName();
        if (thisEnvName == null) {
            if (thatEnvName != null) {
                return false;
            }
        } else if (!thisEnvName.equals(thatEnvName)) {
            return false;
        }
        String thisMigrationLink = getMigrationLink();
        String thatMigrationLink = that.getMigrationLink();
        if (thisMigrationLink == null) {
            return thatMigrationLink == null;
        }
        return thisMigrationLink.equals(thatMigrationLink);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getName(), getDescription(), getDeprecatedVersion(), getScheduledVersion(), getEnvName(), getMigrationLink()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("DeprecatedNote").append("{");
        b.append("Name:").append(getName()).append(",");
        b.append("Description:").append(getDescription()).append(",");
        b.append("DeprecatedVersion:").append(getDeprecatedVersion()).append(",");
        b.append("ScheduledVersion:").append(getScheduledVersion()).append(",");
        b.append("EnvName:").append(getEnvName()).append(",");
        b.append("MigrationLink:").append(getMigrationLink()).append(",");
        return b.append("}").toString();
    }
}
