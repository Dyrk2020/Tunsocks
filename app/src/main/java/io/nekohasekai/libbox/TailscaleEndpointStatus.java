package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class TailscaleEndpointStatus implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getAuthURL();

    public final native String getBackendState();

    public final native String getEndpointTag();

    public final native TailscalePeer getExitNode();

    public final native boolean getKeyAuth();

    public final native String getMagicDNSSuffix();

    public final native String getNetworkName();

    public final native TailscalePeer getSelf();

    public final native String getStateText();

    public final native void setAuthURL(String v);

    public final native void setBackendState(String v);

    public final native void setEndpointTag(String v);

    public final native void setExitNode(TailscalePeer v);

    public final native void setKeyAuth(boolean v);

    public final native void setMagicDNSSuffix(String v);

    public final native void setNetworkName(String v);

    public final native void setSelf(TailscalePeer v);

    public final native void setStateText(String v);

    public native TailscaleUserGroupIterator userGroups();

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    TailscaleEndpointStatus(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public TailscaleEndpointStatus() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        boolean z;
        if (o != null && (o instanceof TailscaleEndpointStatus)) {
            TailscaleEndpointStatus that = (TailscaleEndpointStatus) o;
            String thisEndpointTag = getEndpointTag();
            String thatEndpointTag = that.getEndpointTag();
            if (thisEndpointTag == null) {
                if (thatEndpointTag != null) {
                    return false;
                }
            } else if (!thisEndpointTag.equals(thatEndpointTag)) {
                return false;
            }
            String thisBackendState = getBackendState();
            String thatBackendState = that.getBackendState();
            if (thisBackendState == null) {
                if (thatBackendState != null) {
                    return false;
                }
            } else if (!thisBackendState.equals(thatBackendState)) {
                return false;
            }
            String thisStateText = getStateText();
            String thatStateText = that.getStateText();
            if (thisStateText == null) {
                if (thatStateText != null) {
                    return false;
                }
            } else if (!thisStateText.equals(thatStateText)) {
                return false;
            }
            String thisAuthURL = getAuthURL();
            String thatAuthURL = that.getAuthURL();
            if (thisAuthURL == null) {
                if (thatAuthURL != null) {
                    return false;
                }
            } else if (!thisAuthURL.equals(thatAuthURL)) {
                return false;
            }
            String thisNetworkName = getNetworkName();
            String thatNetworkName = that.getNetworkName();
            if (thisNetworkName == null) {
                if (thatNetworkName != null) {
                    return false;
                }
            } else if (!thisNetworkName.equals(thatNetworkName)) {
                return false;
            }
            String thisMagicDNSSuffix = getMagicDNSSuffix();
            String thatMagicDNSSuffix = that.getMagicDNSSuffix();
            if (thisMagicDNSSuffix == null) {
                if (thatMagicDNSSuffix != null) {
                    return false;
                }
            } else if (!thisMagicDNSSuffix.equals(thatMagicDNSSuffix)) {
                return false;
            }
            TailscalePeer thisSelf = getSelf();
            TailscalePeer thatSelf = that.getSelf();
            if (thisSelf == null) {
                if (thatSelf != null) {
                    return false;
                }
            } else if (!thisSelf.equals(thatSelf)) {
                return false;
            }
            TailscalePeer thisExitNode = getExitNode();
            TailscalePeer thatExitNode = that.getExitNode();
            if (thisExitNode == null) {
                if (thatExitNode == null) {
                    z = false;
                } else {
                    return false;
                }
            } else {
                z = false;
                if (!thisExitNode.equals(thatExitNode)) {
                    return false;
                }
            }
            boolean thisKeyAuth = getKeyAuth();
            boolean thatKeyAuth = that.getKeyAuth();
            if (thisKeyAuth != thatKeyAuth) {
                return z;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getEndpointTag(), getBackendState(), getStateText(), getAuthURL(), getNetworkName(), getMagicDNSSuffix(), getSelf(), getExitNode(), Boolean.valueOf(getKeyAuth())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("TailscaleEndpointStatus").append("{");
        b.append("EndpointTag:").append(getEndpointTag()).append(",");
        b.append("BackendState:").append(getBackendState()).append(",");
        b.append("StateText:").append(getStateText()).append(",");
        b.append("AuthURL:").append(getAuthURL()).append(",");
        b.append("NetworkName:").append(getNetworkName()).append(",");
        b.append("MagicDNSSuffix:").append(getMagicDNSSuffix()).append(",");
        b.append("Self:").append(getSelf()).append(",");
        b.append("ExitNode:").append(getExitNode()).append(",");
        b.append("KeyAuth:").append(getKeyAuth()).append(",");
        return b.append("}").toString();
    }
}
