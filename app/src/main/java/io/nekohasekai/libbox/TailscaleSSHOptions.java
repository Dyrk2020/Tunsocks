package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class TailscaleSSHOptions implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native int getColumns();

    public final native String getEndpointTag();

    public final native boolean getForwardAgent();

    public final native int getHeightPixels();

    public final native StringIterator getHostKeys();

    public final native String getPeerAddress();

    public final native int getRows();

    public final native String getTerminalType();

    public final native String getUsername();

    public final native int getWidthPixels();

    public final native void setColumns(int v);

    public final native void setEndpointTag(String v);

    public final native void setForwardAgent(boolean v);

    public final native void setHeightPixels(int v);

    public final native void setHostKeys(StringIterator v);

    public final native void setPeerAddress(String v);

    public final native void setRows(int v);

    public final native void setTerminalType(String v);

    public final native void setUsername(String v);

    public final native void setWidthPixels(int v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    TailscaleSSHOptions(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public TailscaleSSHOptions() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o != null && (o instanceof TailscaleSSHOptions)) {
            TailscaleSSHOptions that = (TailscaleSSHOptions) o;
            String thisEndpointTag = getEndpointTag();
            String thatEndpointTag = that.getEndpointTag();
            if (thisEndpointTag == null) {
                if (thatEndpointTag != null) {
                    return false;
                }
            } else if (!thisEndpointTag.equals(thatEndpointTag)) {
                return false;
            }
            String thisPeerAddress = getPeerAddress();
            String thatPeerAddress = that.getPeerAddress();
            if (thisPeerAddress == null) {
                if (thatPeerAddress != null) {
                    return false;
                }
            } else if (!thisPeerAddress.equals(thatPeerAddress)) {
                return false;
            }
            String thisUsername = getUsername();
            String thatUsername = that.getUsername();
            if (thisUsername == null) {
                if (thatUsername != null) {
                    return false;
                }
            } else if (!thisUsername.equals(thatUsername)) {
                return false;
            }
            String thisTerminalType = getTerminalType();
            String thatTerminalType = that.getTerminalType();
            if (thisTerminalType == null) {
                if (thatTerminalType != null) {
                    return false;
                }
            } else if (!thisTerminalType.equals(thatTerminalType)) {
                return false;
            }
            int thisColumns = getColumns();
            int thatColumns = that.getColumns();
            if (thisColumns != thatColumns) {
                return false;
            }
            int thisRows = getRows();
            int thatRows = that.getRows();
            if (thisRows != thatRows) {
                return false;
            }
            int thisWidthPixels = getWidthPixels();
            int thatWidthPixels = that.getWidthPixels();
            if (thisWidthPixels != thatWidthPixels) {
                return false;
            }
            int thisHeightPixels = getHeightPixels();
            int thatHeightPixels = that.getHeightPixels();
            if (thisHeightPixels != thatHeightPixels) {
                return false;
            }
            StringIterator thisHostKeys = getHostKeys();
            StringIterator thatHostKeys = that.getHostKeys();
            if (thisHostKeys == null) {
                if (thatHostKeys != null) {
                    return false;
                }
            } else if (!thisHostKeys.equals(thatHostKeys)) {
                return false;
            }
            boolean thisForwardAgent = getForwardAgent();
            boolean thatForwardAgent = that.getForwardAgent();
            if (thisForwardAgent != thatForwardAgent) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getEndpointTag(), getPeerAddress(), getUsername(), getTerminalType(), Integer.valueOf(getColumns()), Integer.valueOf(getRows()), Integer.valueOf(getWidthPixels()), Integer.valueOf(getHeightPixels()), getHostKeys(), Boolean.valueOf(getForwardAgent())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("TailscaleSSHOptions").append("{");
        b.append("EndpointTag:").append(getEndpointTag()).append(",");
        b.append("PeerAddress:").append(getPeerAddress()).append(",");
        b.append("Username:").append(getUsername()).append(",");
        b.append("TerminalType:").append(getTerminalType()).append(",");
        b.append("Columns:").append(getColumns()).append(",");
        b.append("Rows:").append(getRows()).append(",");
        b.append("WidthPixels:").append(getWidthPixels()).append(",");
        b.append("HeightPixels:").append(getHeightPixels()).append(",");
        b.append("HostKeys:").append(getHostKeys()).append(",");
        b.append("ForwardAgent:").append(getForwardAgent()).append(",");
        return b.append("}").toString();
    }
}
