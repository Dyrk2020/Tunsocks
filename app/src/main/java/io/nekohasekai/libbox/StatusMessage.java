package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class StatusMessage implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native int getConnectionsIn();

    public final native int getConnectionsOut();

    public final native long getDownlink();

    public final native long getDownlinkTotal();

    public final native int getGoroutines();

    public final native long getMemory();

    public final native boolean getTrafficAvailable();

    public final native long getUplink();

    public final native long getUplinkTotal();

    public final native void setConnectionsIn(int v);

    public final native void setConnectionsOut(int v);

    public final native void setDownlink(long v);

    public final native void setDownlinkTotal(long v);

    public final native void setGoroutines(int v);

    public final native void setMemory(long v);

    public final native void setTrafficAvailable(boolean v);

    public final native void setUplink(long v);

    public final native void setUplinkTotal(long v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    StatusMessage(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public StatusMessage() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof StatusMessage)) {
            return false;
        }
        StatusMessage that = (StatusMessage) o;
        long thisMemory = getMemory();
        long thatMemory = that.getMemory();
        if (thisMemory != thatMemory) {
            return false;
        }
        int thisGoroutines = getGoroutines();
        int thatGoroutines = that.getGoroutines();
        if (thisGoroutines != thatGoroutines) {
            return false;
        }
        int thisConnectionsIn = getConnectionsIn();
        int thatConnectionsIn = that.getConnectionsIn();
        if (thisConnectionsIn != thatConnectionsIn) {
            return false;
        }
        int thisConnectionsOut = getConnectionsOut();
        int thatConnectionsOut = that.getConnectionsOut();
        if (thisConnectionsOut != thatConnectionsOut) {
            return false;
        }
        boolean thisTrafficAvailable = getTrafficAvailable();
        boolean thatTrafficAvailable = that.getTrafficAvailable();
        if (thisTrafficAvailable != thatTrafficAvailable) {
            return false;
        }
        long thisUplink = getUplink();
        long thatUplink = that.getUplink();
        if (thisUplink != thatUplink) {
            return false;
        }
        long thisDownlink = getDownlink();
        long thatDownlink = that.getDownlink();
        if (thisDownlink != thatDownlink) {
            return false;
        }
        long thisUplinkTotal = getUplinkTotal();
        long thatUplinkTotal = that.getUplinkTotal();
        if (thisUplinkTotal != thatUplinkTotal) {
            return false;
        }
        long thisDownlinkTotal = getDownlinkTotal();
        long thatDownlinkTotal = that.getDownlinkTotal();
        return thisDownlinkTotal == thatDownlinkTotal;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(getMemory()), Integer.valueOf(getGoroutines()), Integer.valueOf(getConnectionsIn()), Integer.valueOf(getConnectionsOut()), Boolean.valueOf(getTrafficAvailable()), Long.valueOf(getUplink()), Long.valueOf(getDownlink()), Long.valueOf(getUplinkTotal()), Long.valueOf(getDownlinkTotal())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("StatusMessage").append("{");
        b.append("Memory:").append(getMemory()).append(",");
        b.append("Goroutines:").append(getGoroutines()).append(",");
        b.append("ConnectionsIn:").append(getConnectionsIn()).append(",");
        b.append("ConnectionsOut:").append(getConnectionsOut()).append(",");
        b.append("TrafficAvailable:").append(getTrafficAvailable()).append(",");
        b.append("Uplink:").append(getUplink()).append(",");
        b.append("Downlink:").append(getDownlink()).append(",");
        b.append("UplinkTotal:").append(getUplinkTotal()).append(",");
        b.append("DownlinkTotal:").append(getDownlinkTotal()).append(",");
        return b.append("}").toString();
    }
}
