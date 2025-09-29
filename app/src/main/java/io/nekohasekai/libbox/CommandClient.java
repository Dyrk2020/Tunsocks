package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class CommandClient implements Seq.Proxy {
    public final int refnum;

    private static native int __NewCommandClient(CommandClientHandler handler, CommandClientOptions options);

    public native void cancelOpenConnectAuthChallenge(String endpointTag, String challengeID) throws Exception;

    public native void cancelOpenVPNChallenge(String endpointTag, String challengeID) throws Exception;

    public native void clearLogs() throws Exception;

    public native void closeConnection(String connId) throws Exception;

    public native void closeConnections() throws Exception;

    public native void connect() throws Exception;

    public native void connectWithFD(int fd) throws Exception;

    public native void disconnect() throws Exception;

    public native int getAPIVersion() throws Exception;

    public native DeprecatedNoteIterator getDeprecatedNotes() throws Exception;

    public native long getStartedAt() throws Exception;

    public native SystemProxyStatus getSystemProxyStatus() throws Exception;

    public native USBLocalProviderManager newUSBLocalProvider(USBLocalProviderHandler handler) throws Exception;

    public native USBProviderSession provideUSBDevices(USBProviderHandler handler) throws Exception;

    public native void selectOutbound(String groupTag, String outboundTag) throws Exception;

    public native void serviceClose() throws Exception;

    public native void serviceReload() throws Exception;

    public native void setClashMode(String newMode) throws Exception;

    public native void setGroupExpand(String groupTag, boolean isExpand) throws Exception;

    public native void setSystemProxyEnabled(boolean isEnabled) throws Exception;

    public native void setTailscaleExitNode(String endpointTag, String stableID) throws Exception;

    public native NetworkQualityTestSession startNetworkQualityTest(String configURL, String outboundTag, boolean serial, int maxRuntimeSeconds, boolean http3, NetworkQualityTestHandler handler) throws Exception;

    public native STUNTestSession startSTUNTest(String server, String outboundTag, STUNTestHandler handler) throws Exception;

    public native TailscalePingSession startTailscalePing(String endpointTag, String peerIP, TailscalePingHandler handler) throws Exception;

    public native TailscaleSSHSession startTailscaleSSHSession(TailscaleSSHOptions opts, TailscaleSSHHandler handler) throws Exception;

    public native void submitOpenConnectAuthResponse(String endpointTag, String challengeID, OpenConnectAuthResponse response) throws Exception;

    public native void submitOpenVPNChallengeResponse(String endpointTag, String challengeID, OpenVPNChallengeResponse response) throws Exception;

    public native OpenConnectStatusSubscription subscribeOpenConnectStatus(OpenConnectStatusHandler handler) throws Exception;

    public native OpenVPNStatusSubscription subscribeOpenVPNStatus(OpenVPNStatusHandler handler) throws Exception;

    public native TailscaleStatusSubscription subscribeTailscaleStatus(TailscaleStatusHandler handler) throws Exception;

    public native USBIPServerStatusSubscription subscribeUSBIPServerStatus(USBIPServerStatusHandler handler) throws Exception;

    public native void tailscaleLogout(String endpointTag) throws Exception;

    public native void triggerGoCrash() throws Exception;

    public native void triggerNativeCrash() throws Exception;

    public native void triggerOOMReport() throws Exception;

    public native void urlTest(String groupTag) throws Exception;

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public CommandClient(CommandClientHandler handler, CommandClientOptions options) {
        this.refnum = __NewCommandClient(handler, options);
        Seq.trackGoRef(this.refnum, this);
    }

    CommandClient(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof CommandClient)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("CommandClient").append("{");
        return b.append("}").toString();
    }
}
