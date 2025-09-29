package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenConnectEndpointStatus implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native OpenConnectAuthChallenge getAuthChallenge();

    public final native String getEndpointTag();

    public final native String getError();

    public final native String getState();

    public final native String getStateText();

    public final native OpenConnectTunnelInfo getTunnelInfo();

    public final native void setAuthChallenge(OpenConnectAuthChallenge v);

    public final native void setEndpointTag(String v);

    public final native void setError(String v);

    public final native void setState(String v);

    public final native void setStateText(String v);

    public final native void setTunnelInfo(OpenConnectTunnelInfo v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    OpenConnectEndpointStatus(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public OpenConnectEndpointStatus() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof OpenConnectEndpointStatus)) {
            return false;
        }
        OpenConnectEndpointStatus that = (OpenConnectEndpointStatus) o;
        String thisEndpointTag = getEndpointTag();
        String thatEndpointTag = that.getEndpointTag();
        if (thisEndpointTag == null) {
            if (thatEndpointTag != null) {
                return false;
            }
        } else if (!thisEndpointTag.equals(thatEndpointTag)) {
            return false;
        }
        String thisState = getState();
        String thatState = that.getState();
        if (thisState == null) {
            if (thatState != null) {
                return false;
            }
        } else if (!thisState.equals(thatState)) {
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
        OpenConnectAuthChallenge thisAuthChallenge = getAuthChallenge();
        OpenConnectAuthChallenge thatAuthChallenge = that.getAuthChallenge();
        if (thisAuthChallenge == null) {
            if (thatAuthChallenge != null) {
                return false;
            }
        } else if (!thisAuthChallenge.equals(thatAuthChallenge)) {
            return false;
        }
        String thisError = getError();
        String thatError = that.getError();
        if (thisError == null) {
            if (thatError != null) {
                return false;
            }
        } else if (!thisError.equals(thatError)) {
            return false;
        }
        OpenConnectTunnelInfo thisTunnelInfo = getTunnelInfo();
        OpenConnectTunnelInfo thatTunnelInfo = that.getTunnelInfo();
        if (thisTunnelInfo == null) {
            return thatTunnelInfo == null;
        }
        return thisTunnelInfo.equals(thatTunnelInfo);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getEndpointTag(), getState(), getStateText(), getAuthChallenge(), getError(), getTunnelInfo()});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("OpenConnectEndpointStatus").append("{");
        b.append("EndpointTag:").append(getEndpointTag()).append(",");
        b.append("State:").append(getState()).append(",");
        b.append("StateText:").append(getStateText()).append(",");
        b.append("AuthChallenge:").append(getAuthChallenge()).append(",");
        b.append("Error:").append(getError()).append(",");
        b.append("TunnelInfo:").append(getTunnelInfo()).append(",");
        return b.append("}").toString();
    }
}
