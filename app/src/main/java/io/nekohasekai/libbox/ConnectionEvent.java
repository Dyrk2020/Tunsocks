package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ConnectionEvent implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native long getClosedAt();

    public final native Connection getConnection();

    public final native long getDownlinkDelta();

    public final native String getID();

    public final native int getType();

    public final native long getUplinkDelta();

    public final native void setClosedAt(long v);

    public final native void setConnection(Connection v);

    public final native void setDownlinkDelta(long v);

    public final native void setID(String v);

    public final native void setType(int v);

    public final native void setUplinkDelta(long v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    ConnectionEvent(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public ConnectionEvent() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof ConnectionEvent)) {
            return false;
        }
        ConnectionEvent that = (ConnectionEvent) o;
        int thisType = getType();
        int thatType = that.getType();
        if (thisType != thatType) {
            return false;
        }
        String thisID = getID();
        String thatID = that.getID();
        if (thisID == null) {
            if (thatID != null) {
                return false;
            }
        } else if (!thisID.equals(thatID)) {
            return false;
        }
        Connection thisConnection = getConnection();
        Connection thatConnection = that.getConnection();
        if (thisConnection == null) {
            if (thatConnection != null) {
                return false;
            }
        } else if (!thisConnection.equals(thatConnection)) {
            return false;
        }
        long thisUplinkDelta = getUplinkDelta();
        long thatUplinkDelta = that.getUplinkDelta();
        if (thisUplinkDelta != thatUplinkDelta) {
            return false;
        }
        long thisDownlinkDelta = getDownlinkDelta();
        long thatDownlinkDelta = that.getDownlinkDelta();
        if (thisDownlinkDelta != thatDownlinkDelta) {
            return false;
        }
        long thisClosedAt = getClosedAt();
        long thatClosedAt = that.getClosedAt();
        return thisClosedAt == thatClosedAt;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(getType()), getID(), getConnection(), Long.valueOf(getUplinkDelta()), Long.valueOf(getDownlinkDelta()), Long.valueOf(getClosedAt())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("ConnectionEvent").append("{");
        b.append("Type:").append(getType()).append(",");
        b.append("ID:").append(getID()).append(",");
        b.append("Connection:").append(getConnection()).append(",");
        b.append("UplinkDelta:").append(getUplinkDelta()).append(",");
        b.append("DownlinkDelta:").append(getDownlinkDelta()).append(",");
        b.append("ClosedAt:").append(getClosedAt()).append(",");
        return b.append("}").toString();
    }
}
