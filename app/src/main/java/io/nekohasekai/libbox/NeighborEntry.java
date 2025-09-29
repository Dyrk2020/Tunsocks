package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class NeighborEntry implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getAddress();

    public final native String getHostname();

    public final native String getMacAddress();

    public final native void setAddress(String v);

    public final native void setHostname(String v);

    public final native void setMacAddress(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    NeighborEntry(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public NeighborEntry() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof NeighborEntry)) {
            return false;
        }
        NeighborEntry that = (NeighborEntry) o;
        String thisAddress = getAddress();
        String thatAddress = that.getAddress();
        if (thisAddress == null) {
            if (thatAddress != null) {
                return false;
            }
        } else if (!thisAddress.equals(thatAddress)) {
            return false;
        }
        String thisMacAddress = getMacAddress();
        String thatMacAddress = that.getMacAddress();
        if (thisMacAddress == null) {
            if (thatMacAddress != null) {
                return false;
            }
        } else if (!thisMacAddress.equals(thatMacAddress)) {
            return false;
        }
        String thisHostname = getHostname();
        String thatHostname = that.getHostname();
        if (thisHostname == null) {
            if (thatHostname != null) {
                return false;
            }
            return true;
        }
        if (!thisHostname.equals(thatHostname)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getAddress(), getMacAddress(), getHostname()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("NeighborEntry").append("{");
        b.append("Address:").append(getAddress()).append(",");
        b.append("MacAddress:").append(getMacAddress()).append(",");
        b.append("Hostname:").append(getHostname()).append(",");
        return b.append("}").toString();
    }
}
