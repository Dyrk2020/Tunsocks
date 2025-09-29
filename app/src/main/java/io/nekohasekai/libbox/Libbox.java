package io.nekohasekai.libbox;

import go.Seq;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Libbox {
    public static final int CommandClashMode = 3;
    public static final int CommandConnections = 4;
    public static final int CommandGroup = 2;
    public static final int CommandLog = 0;
    public static final int CommandOutbounds = 5;
    public static final int CommandStatus = 1;
    public static final long ConnectionEventClosed = 2;
    public static final long ConnectionEventNew = 0;
    public static final long ConnectionEventUpdate = 1;
    public static final long ConnectionStateActive = 1;
    public static final long ConnectionStateAll = 0;
    public static final long ConnectionStateClosed = 2;
    public static final String DNSModeDisabled = "disabled";
    public static final String DNSModeHijack = "hijack";
    public static final String DNSModeNative = "native";
    public static final int InterfaceTypeCellular = 1;
    public static final int InterfaceTypeEthernet = 2;
    public static final int InterfaceTypeOther = 3;
    public static final int InterfaceTypeWIFI = 0;
    public static final long MessageTypeError = 0;
    public static final long MessageTypeProfileContent = 3;
    public static final long MessageTypeProfileContentRequest = 2;
    public static final long MessageTypeProfileList = 1;
    public static final int NATFilteringAddressAndPortDependent = 3;
    public static final int NATFilteringAddressDependent = 2;
    public static final int NATFilteringEndpointIndependent = 1;
    public static final int NATMappingAddressAndPortDependent = 4;
    public static final int NATMappingAddressDependent = 3;
    public static final int NATMappingEndpointIndependent = 2;
    public static final int NetworkQualityAccuracyHigh = 2;
    public static final int NetworkQualityAccuracyLow = 0;
    public static final int NetworkQualityAccuracyMedium = 1;
    public static final String NetworkQualityDefaultConfigURL = "https://mensura.cdn-apple.com/api/v1/gm/config";
    public static final int NetworkQualityDefaultMaxRuntimeSeconds = 20;
    public static final int NetworkQualityPhaseDone = 3;
    public static final int NetworkQualityPhaseDownload = 1;
    public static final int NetworkQualityPhaseIdle = 0;
    public static final int NetworkQualityPhaseUpload = 2;
    public static final int ProfileTypeLocal = 0;
    public static final int ProfileTypeRemote = 2;
    public static final int ProfileTypeiCloud = 1;
    public static final String STUNDefaultServer = "stun.voipgate.com:3478";
    public static final int STUNPhaseBinding = 0;
    public static final int STUNPhaseDone = 3;
    public static final int STUNPhaseNATFiltering = 2;
    public static final int STUNPhaseNATMapping = 1;
    public static final int USBBackendDarwinIOKit = 3;
    public static final int USBBackendDynamic = 2;
    public static final int USBBackendLinuxSysfs = 1;
    public static final int USBBackendUnspecified = 0;
    public static final int USBBackendWindowsVBoxUSB = 4;
    public static final int USBDeviceStateAttached = 1;
    public static final int USBDeviceStateIdle = 0;
    public static final int USBDeviceStateUnavailable = 2;

    private static native void _init();

    public static native int availablePort(int startPort) throws Exception;

    public static native void checkConfig(String configContent) throws Exception;

    public static native FDroidUpdateInfo checkFDroidUpdate(String mirrorURL, String packageName, int currentVersionCode, String cachePath) throws Exception;

    public static native boolean compareSemver(String left, String right);

    public static native void createZipArchive(String sourcePath, String destinationPath, boolean encrypt) throws Exception;

    public static native ErrorMessage decodeErrorMessage(byte[] data) throws Exception;

    public static native int decodeLengthChunk(byte[] data);

    public static native ProfileContent decodeProfileContent(byte[] data) throws Exception;

    public static native ProfileContentRequest decodeProfileContentRequest(byte[] data) throws Exception;

    public static native byte[] encodeChunkedMessage(byte[] data);

    public static native String formatBitrate(long bps);

    public static native String formatBytes(long length);

    public static native StringBox formatConfig(String configContent) throws Exception;

    public static native String formatDuration(long duration);

    public static native String formatFQDN(String fqdn);

    public static native String formatMemoryBytes(long length);

    public static native String formatNATFiltering(int value);

    public static native String formatNATMapping(int value);

    public static native String generateRemoteProfileImportLink(String name, String remoteURL);

    public static native FDroidMirrorIterator getFDroidMirrors();

    public static native String goVersion();

    public static native BridgeSession newBridgeService(BridgeOptions options) throws Exception;

    public static native CommandClient newCommandClient(CommandClientHandler handler, CommandClientOptions options);

    public static native CommandServer newCommandServer(CommandServerHandler handler, PlatformInterface platformInterface) throws Exception;

    public static native Connections newConnections();

    public static native HTTPClient newHTTPClient();

    public static native NetworkQualityTest newNetworkQualityTest();

    public static native OpenConnectAuthResponse newOpenConnectAuthFormResponse(OpenConnectFormValues values);

    public static native OpenConnectAuthResponse newOpenConnectBrowserAuthResponse(OpenConnectBrowserResult result);

    public static native OpenConnectBrowserResult newOpenConnectBrowserResult(String finalURL);

    public static native OpenConnectFormValues newOpenConnectFormValues();

    public static native PProfServer newPProfServer(long port);

    public static native CommandClient newRemoteCommandClient(CommandClientHandler handler, CommandClientOptions options, RemoteConnectionOptions remoteOptions) throws Exception;

    public static native STUNTest newSTUNTest();

    public static native CommandClient newStandaloneCommandClient();

    public static native CommandClient newStandaloneRemoteCommandClient(RemoteConnectionOptions remoteOptions) throws Exception;

    public static native USBDeviceDescriptor newUSBDeviceDescriptor(String serverTag, String deviceID);

    public static native USBURBResponse newUSBURBResponse(String deviceID, long seq);

    public static native WIFIState newWIFIState(String wifiSSID, String wifiBSSID);

    public static native ShellSession openNativePipeSession(String shell, String cwd, StringIterator args, StringIterator environ, int uid, int gid, Int32Iterator groups) throws Exception;

    public static native ShellSession openNativeShellSession(String shell, String cwd, StringIterator args, StringIterator environ, String term, int rows, int cols, int uid, int gid, Int32Iterator groups) throws Exception;

    public static native ImportRemoteProfile parseRemoteProfileImportLink(String importLink) throws Exception;

    public static native FDroidPingResult pingFDroidMirror(String mirrorURL);

    public static native FDroidPingResultIterator pingFDroidMirrors(String mirrorURLs) throws Exception;

    public static native void prepareCrashSignalHandlers();

    public static native void promoteOOMDraft();

    public static native void promoteOOMDraftAt(String workingPath);

    public static native String proxyDisplayType(String proxyType);

    public static native StringBox randomHex(int length);

    public static native AndroidVPNType readAndroidVPNType(StringIterator publicSourceDirList) throws Exception;

    public static native void reinstallCrashSignalHandlers();

    public static native void reloadSetupOptions(SetupOptions options);

    public static native void setLocale(String localeID) throws Exception;

    public static native void setXPCDialer(XPCDialer dialer);

    public static native void setup(SetupOptions options) throws Exception;

    public static native NeighborSubscription subscribeNeighborTable(NeighborUpdateListener listener) throws Exception;

    public static native void triggerGoPanic();

    public static native String version();

    static {
        Seq.touch();
        _init();
    }

    private Libbox() {
    }

    public static void touch() {
    }

    private static final class proxyBridgeSession implements Seq.Proxy, BridgeSession {
        public final int refnum;

        @Override // io.nekohasekai.libbox.BridgeSession
        public native void close() throws Exception;

        @Override // io.nekohasekai.libbox.BridgeSession
        public native int fileDescriptor();

        @Override // io.nekohasekai.libbox.BridgeSession
        public native boolean inet6Active();

        @Override // io.nekohasekai.libbox.BridgeSession
        public native String name();

        @Override // io.nekohasekai.libbox.BridgeSession
        public native void setEgress(String interfaceName) throws Exception;

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyBridgeSession(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyCommandClientHandler implements Seq.Proxy, CommandClientHandler {
        public final int refnum;

        @Override // io.nekohasekai.libbox.CommandClientHandler
        public native void clearLogs();

        @Override // io.nekohasekai.libbox.CommandClientHandler
        public native void connected();

        @Override // io.nekohasekai.libbox.CommandClientHandler
        public native void disconnected(String message);

        @Override // io.nekohasekai.libbox.CommandClientHandler
        public native void initializeClashMode(StringIterator modeList, String currentMode);

        @Override // io.nekohasekai.libbox.CommandClientHandler
        public native void setDefaultLogLevel(int level);

        @Override // io.nekohasekai.libbox.CommandClientHandler
        public native void updateClashMode(String newMode);

        @Override // io.nekohasekai.libbox.CommandClientHandler
        public native void writeConnectionEvents(ConnectionEvents events);

        @Override // io.nekohasekai.libbox.CommandClientHandler
        public native void writeGroups(OutboundGroupIterator message);

        @Override // io.nekohasekai.libbox.CommandClientHandler
        public native void writeLogs(LogIterator messageList);

        @Override // io.nekohasekai.libbox.CommandClientHandler
        public native void writeOutbounds(OutboundGroupItemIterator message);

        @Override // io.nekohasekai.libbox.CommandClientHandler
        public native void writeStatus(StatusMessage message);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyCommandClientHandler(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyCommandServerHandler implements Seq.Proxy, CommandServerHandler {
        public final int refnum;

        @Override // io.nekohasekai.libbox.CommandServerHandler
        public native int connectSSHAgent() throws Exception;

        @Override // io.nekohasekai.libbox.CommandServerHandler
        public native SystemProxyStatus getSystemProxyStatus() throws Exception;

        @Override // io.nekohasekai.libbox.CommandServerHandler
        public native void serviceReload() throws Exception;

        @Override // io.nekohasekai.libbox.CommandServerHandler
        public native void serviceStop() throws Exception;

        @Override // io.nekohasekai.libbox.CommandServerHandler
        public native void setSystemProxyEnabled(boolean enabled) throws Exception;

        @Override // io.nekohasekai.libbox.CommandServerHandler
        public native void triggerNativeCrash() throws Exception;

        @Override // io.nekohasekai.libbox.CommandServerHandler
        public native void writeDebugMessage(String message);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyCommandServerHandler(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyConnectionEventIterator implements Seq.Proxy, ConnectionEventIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.ConnectionEventIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.ConnectionEventIterator
        public native ConnectionEvent next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyConnectionEventIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyConnectionIterator implements Seq.Proxy, ConnectionIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.ConnectionIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.ConnectionIterator
        public native Connection next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyConnectionIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyDeprecatedNoteIterator implements Seq.Proxy, DeprecatedNoteIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.DeprecatedNoteIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.DeprecatedNoteIterator
        public native DeprecatedNote next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyDeprecatedNoteIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyFDroidMirrorIterator implements Seq.Proxy, FDroidMirrorIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.FDroidMirrorIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.FDroidMirrorIterator
        public native int len();

        @Override // io.nekohasekai.libbox.FDroidMirrorIterator
        public native FDroidMirror next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyFDroidMirrorIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyFDroidPingResultIterator implements Seq.Proxy, FDroidPingResultIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.FDroidPingResultIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.FDroidPingResultIterator
        public native int len();

        @Override // io.nekohasekai.libbox.FDroidPingResultIterator
        public native FDroidPingResult next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyFDroidPingResultIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyFunc implements Seq.Proxy, Func {
        public final int refnum;

        @Override // io.nekohasekai.libbox.Func
        public native void invoke() throws Exception;

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyFunc(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyHTTPClient implements Seq.Proxy, HTTPClient {
        public final int refnum;

        @Override // io.nekohasekai.libbox.HTTPClient
        public native void close();

        @Override // io.nekohasekai.libbox.HTTPClient
        public native void keepAlive();

        @Override // io.nekohasekai.libbox.HTTPClient
        public native void modernTLS();

        @Override // io.nekohasekai.libbox.HTTPClient
        public native HTTPRequest newRequest();

        @Override // io.nekohasekai.libbox.HTTPClient
        public native void pinnedSHA256(String sumHex);

        @Override // io.nekohasekai.libbox.HTTPClient
        public native void pinnedTLS12();

        @Override // io.nekohasekai.libbox.HTTPClient
        public native void restrictedTLS();

        @Override // io.nekohasekai.libbox.HTTPClient
        public native void trySocks5(int port);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyHTTPClient(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyHTTPRequest implements Seq.Proxy, HTTPRequest {
        public final int refnum;

        @Override // io.nekohasekai.libbox.HTTPRequest
        public native HTTPResponse execute() throws Exception;

        @Override // io.nekohasekai.libbox.HTTPRequest
        public native void randomUserAgent();

        @Override // io.nekohasekai.libbox.HTTPRequest
        public native void setContent(byte[] content);

        @Override // io.nekohasekai.libbox.HTTPRequest
        public native void setContentString(String content);

        @Override // io.nekohasekai.libbox.HTTPRequest
        public native void setHeader(String key, String value);

        @Override // io.nekohasekai.libbox.HTTPRequest
        public native void setMethod(String method);

        @Override // io.nekohasekai.libbox.HTTPRequest
        public native void setURL(String link) throws Exception;

        @Override // io.nekohasekai.libbox.HTTPRequest
        public native void setUserAgent(String userAgent);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyHTTPRequest(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyHTTPResponse implements Seq.Proxy, HTTPResponse {
        public final int refnum;

        @Override // io.nekohasekai.libbox.HTTPResponse
        public native StringBox getContent() throws Exception;

        @Override // io.nekohasekai.libbox.HTTPResponse
        public native void writeTo(String path) throws Exception;

        @Override // io.nekohasekai.libbox.HTTPResponse
        public native void writeToWithProgress(String path, HTTPResponseWriteToProgressHandler handler) throws Exception;

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyHTTPResponse(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyHTTPResponseWriteToProgressHandler implements Seq.Proxy, HTTPResponseWriteToProgressHandler {
        public final int refnum;

        @Override // io.nekohasekai.libbox.HTTPResponseWriteToProgressHandler
        public native void update(long progress, long total);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyHTTPResponseWriteToProgressHandler(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyInt32Iterator implements Seq.Proxy, Int32Iterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.Int32Iterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.Int32Iterator
        public native int len();

        @Override // io.nekohasekai.libbox.Int32Iterator
        public native int next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyInt32Iterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyInterfaceUpdateListener implements Seq.Proxy, InterfaceUpdateListener {
        public final int refnum;

        @Override // io.nekohasekai.libbox.InterfaceUpdateListener
        public native void updateDefaultInterface(String interfaceName, int interfaceIndex, boolean isExpensive, boolean isConstrained);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyInterfaceUpdateListener(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyLocalDNSTransport implements Seq.Proxy, LocalDNSTransport {
        public final int refnum;

        @Override // io.nekohasekai.libbox.LocalDNSTransport
        public native void exchange(ExchangeContext ctx, byte[] message) throws Exception;

        @Override // io.nekohasekai.libbox.LocalDNSTransport
        public native void lookup(ExchangeContext ctx, String network, String domain) throws Exception;

        @Override // io.nekohasekai.libbox.LocalDNSTransport
        public native boolean raw();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyLocalDNSTransport(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyLogIterator implements Seq.Proxy, LogIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.LogIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.LogIterator
        public native int len();

        @Override // io.nekohasekai.libbox.LogIterator
        public native LogEntry next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyLogIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyNeighborEntryIterator implements Seq.Proxy, NeighborEntryIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.NeighborEntryIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.NeighborEntryIterator
        public native NeighborEntry next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyNeighborEntryIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyNeighborUpdateListener implements Seq.Proxy, NeighborUpdateListener {
        public final int refnum;

        @Override // io.nekohasekai.libbox.NeighborUpdateListener
        public native void updateNeighborTable(NeighborEntryIterator entries);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyNeighborUpdateListener(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyNetworkInterfaceIterator implements Seq.Proxy, NetworkInterfaceIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.NetworkInterfaceIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.NetworkInterfaceIterator
        public native NetworkInterface next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyNetworkInterfaceIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyNetworkQualityTestHandler implements Seq.Proxy, NetworkQualityTestHandler {
        public final int refnum;

        @Override // io.nekohasekai.libbox.NetworkQualityTestHandler
        public native void onError(String message);

        @Override // io.nekohasekai.libbox.NetworkQualityTestHandler
        public native void onProgress(NetworkQualityProgress progress);

        @Override // io.nekohasekai.libbox.NetworkQualityTestHandler
        public native void onResult(NetworkQualityResult result);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyNetworkQualityTestHandler(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyOnDemandRule implements Seq.Proxy, OnDemandRule {
        public final int refnum;

        @Override // io.nekohasekai.libbox.OnDemandRule
        public native StringIterator dnsSearchDomainMatch();

        @Override // io.nekohasekai.libbox.OnDemandRule
        public native StringIterator dnsServerAddressMatch();

        @Override // io.nekohasekai.libbox.OnDemandRule
        public native int interfaceTypeMatch();

        @Override // io.nekohasekai.libbox.OnDemandRule
        public native String probeURL();

        @Override // io.nekohasekai.libbox.OnDemandRule
        public native StringIterator ssidMatch();

        @Override // io.nekohasekai.libbox.OnDemandRule
        public native int target();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyOnDemandRule(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyOnDemandRuleIterator implements Seq.Proxy, OnDemandRuleIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.OnDemandRuleIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.OnDemandRuleIterator
        public native OnDemandRule next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyOnDemandRuleIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyOpenConnectAuthFormChoiceIterator implements Seq.Proxy, OpenConnectAuthFormChoiceIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.OpenConnectAuthFormChoiceIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.OpenConnectAuthFormChoiceIterator
        public native OpenConnectAuthFormChoice next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyOpenConnectAuthFormChoiceIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyOpenConnectAuthFormFieldIterator implements Seq.Proxy, OpenConnectAuthFormFieldIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.OpenConnectAuthFormFieldIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.OpenConnectAuthFormFieldIterator
        public native OpenConnectAuthFormField next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyOpenConnectAuthFormFieldIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyOpenConnectEndpointStatusIterator implements Seq.Proxy, OpenConnectEndpointStatusIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.OpenConnectEndpointStatusIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.OpenConnectEndpointStatusIterator
        public native OpenConnectEndpointStatus next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyOpenConnectEndpointStatusIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyOpenConnectStatusHandler implements Seq.Proxy, OpenConnectStatusHandler {
        public final int refnum;

        @Override // io.nekohasekai.libbox.OpenConnectStatusHandler
        public native void onError(String message);

        @Override // io.nekohasekai.libbox.OpenConnectStatusHandler
        public native void onStatusUpdate(OpenConnectStatusUpdate status);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyOpenConnectStatusHandler(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyOpenVPNEndpointStatusIterator implements Seq.Proxy, OpenVPNEndpointStatusIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.OpenVPNEndpointStatusIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.OpenVPNEndpointStatusIterator
        public native OpenVPNEndpointStatus next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyOpenVPNEndpointStatusIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyOpenVPNStatusHandler implements Seq.Proxy, OpenVPNStatusHandler {
        public final int refnum;

        @Override // io.nekohasekai.libbox.OpenVPNStatusHandler
        public native void onError(String message);

        @Override // io.nekohasekai.libbox.OpenVPNStatusHandler
        public native void onStatusUpdate(OpenVPNStatusUpdate status);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyOpenVPNStatusHandler(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyOutboundGroupItemIterator implements Seq.Proxy, OutboundGroupItemIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.OutboundGroupItemIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.OutboundGroupItemIterator
        public native OutboundGroupItem next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyOutboundGroupItemIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyOutboundGroupIterator implements Seq.Proxy, OutboundGroupIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.OutboundGroupIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.OutboundGroupIterator
        public native OutboundGroup next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyOutboundGroupIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyPlatformInterface implements Seq.Proxy, PlatformInterface {
        public final int refnum;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native void autoDetectInterfaceControl(int fd) throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native void checkPlatformShell() throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native void clearDNSCache();

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native void closeDefaultInterfaceMonitor(InterfaceUpdateListener listener) throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native void closeNeighborMonitor(NeighborUpdateListener listener) throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native BridgeSession createBridge(BridgeOptions options) throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native ConnectionOwner findConnectionOwner(int ipProtocol, String sourceAddress, int sourcePort, String destinationAddress, int destinationPort) throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native NetworkInterfaceIterator getInterfaces() throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native boolean includeAllNetworks();

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native LocalDNSTransport localDNSTransport();

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native String lookupSFTPServer() throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native PlatformUser lookupUser(String username) throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native ShellSession openShellSession(PlatformUser user, String command, StringIterator environ, String term, int rows, int cols) throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native int openTun(TunOptions options) throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native String readSystemSSHHostKey() throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native WIFIState readWIFIState();

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native void registerMyInterface(String name);

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native void sendNotification(Notification notification) throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native void startDefaultInterfaceMonitor(InterfaceUpdateListener listener) throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native void startNeighborMonitor(NeighborUpdateListener listener) throws Exception;

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native String tailscaleHostname();

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native boolean underNetworkExtension();

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native boolean usePlatformAutoDetectInterfaceControl();

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native boolean usePlatformBridge();

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native boolean usePlatformShell();

        @Override // io.nekohasekai.libbox.PlatformInterface
        public native boolean useProcFS();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyPlatformInterface(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyProfilePreviewIterator implements Seq.Proxy, ProfilePreviewIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.ProfilePreviewIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.ProfilePreviewIterator
        public native ProfilePreview next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyProfilePreviewIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyRoutePrefixIterator implements Seq.Proxy, RoutePrefixIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.RoutePrefixIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.RoutePrefixIterator
        public native RoutePrefix next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyRoutePrefixIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxySTUNTestHandler implements Seq.Proxy, STUNTestHandler {
        public final int refnum;

        @Override // io.nekohasekai.libbox.STUNTestHandler
        public native void onError(String message);

        @Override // io.nekohasekai.libbox.STUNTestHandler
        public native void onProgress(STUNTestProgress progress);

        @Override // io.nekohasekai.libbox.STUNTestHandler
        public native void onResult(STUNTestResult result);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxySTUNTestHandler(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyShellSession implements Seq.Proxy, ShellSession {
        public final int refnum;

        @Override // io.nekohasekai.libbox.ShellSession
        public native void close() throws Exception;

        @Override // io.nekohasekai.libbox.ShellSession
        public native int masterFD();

        @Override // io.nekohasekai.libbox.ShellSession
        public native void resize(int rows, int cols) throws Exception;

        @Override // io.nekohasekai.libbox.ShellSession
        public native void signal(int signal) throws Exception;

        @Override // io.nekohasekai.libbox.ShellSession
        public native int waitExit() throws Exception;

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyShellSession(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyStringIterator implements Seq.Proxy, StringIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.StringIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.StringIterator
        public native int len();

        @Override // io.nekohasekai.libbox.StringIterator
        public native String next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyStringIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyTailscaleEndpointStatusIterator implements Seq.Proxy, TailscaleEndpointStatusIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.TailscaleEndpointStatusIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.TailscaleEndpointStatusIterator
        public native TailscaleEndpointStatus next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyTailscaleEndpointStatusIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyTailscalePeerIterator implements Seq.Proxy, TailscalePeerIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.TailscalePeerIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.TailscalePeerIterator
        public native TailscalePeer next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyTailscalePeerIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyTailscalePingHandler implements Seq.Proxy, TailscalePingHandler {
        public final int refnum;

        @Override // io.nekohasekai.libbox.TailscalePingHandler
        public native void onError(String message);

        @Override // io.nekohasekai.libbox.TailscalePingHandler
        public native void onPingResult(TailscalePingResult result);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyTailscalePingHandler(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyTailscaleSSHHandler implements Seq.Proxy, TailscaleSSHHandler {
        public final int refnum;

        @Override // io.nekohasekai.libbox.TailscaleSSHHandler
        public native void onAuthBanner(String message);

        @Override // io.nekohasekai.libbox.TailscaleSSHHandler
        public native void onError(String message);

        @Override // io.nekohasekai.libbox.TailscaleSSHHandler
        public native void onExit(int exitCode, String signal, String errorMessage);

        @Override // io.nekohasekai.libbox.TailscaleSSHHandler
        public native void onOutput(byte[] data);

        @Override // io.nekohasekai.libbox.TailscaleSSHHandler
        public native void onReady();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyTailscaleSSHHandler(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyTailscaleStatusHandler implements Seq.Proxy, TailscaleStatusHandler {
        public final int refnum;

        @Override // io.nekohasekai.libbox.TailscaleStatusHandler
        public native void onError(String message);

        @Override // io.nekohasekai.libbox.TailscaleStatusHandler
        public native void onStatusUpdate(TailscaleStatusUpdate status);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyTailscaleStatusHandler(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyTailscaleUserGroupIterator implements Seq.Proxy, TailscaleUserGroupIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.TailscaleUserGroupIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.TailscaleUserGroupIterator
        public native TailscaleUserGroup next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyTailscaleUserGroupIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyTunOptions implements Seq.Proxy, TunOptions {
        public final int refnum;

        @Override // io.nekohasekai.libbox.TunOptions
        public native boolean getAutoRoute();

        @Override // io.nekohasekai.libbox.TunOptions
        public native StringBox getDNSMode();

        @Override // io.nekohasekai.libbox.TunOptions
        public native StringIterator getDNSServerAddress() throws Exception;

        @Override // io.nekohasekai.libbox.TunOptions
        public native StringIterator getExcludePackage();

        @Override // io.nekohasekai.libbox.TunOptions
        public native StringIterator getHTTPProxyBypassDomain();

        @Override // io.nekohasekai.libbox.TunOptions
        public native StringIterator getHTTPProxyMatchDomain();

        @Override // io.nekohasekai.libbox.TunOptions
        public native String getHTTPProxyServer();

        @Override // io.nekohasekai.libbox.TunOptions
        public native int getHTTPProxyServerPort();

        @Override // io.nekohasekai.libbox.TunOptions
        public native StringIterator getIncludePackage();

        @Override // io.nekohasekai.libbox.TunOptions
        public native RoutePrefixIterator getInet4Address();

        @Override // io.nekohasekai.libbox.TunOptions
        public native RoutePrefixIterator getInet4RouteAddress();

        @Override // io.nekohasekai.libbox.TunOptions
        public native RoutePrefixIterator getInet4RouteExcludeAddress();

        @Override // io.nekohasekai.libbox.TunOptions
        public native RoutePrefixIterator getInet4RouteRange();

        @Override // io.nekohasekai.libbox.TunOptions
        public native RoutePrefixIterator getInet6Address();

        @Override // io.nekohasekai.libbox.TunOptions
        public native RoutePrefixIterator getInet6RouteAddress();

        @Override // io.nekohasekai.libbox.TunOptions
        public native RoutePrefixIterator getInet6RouteExcludeAddress();

        @Override // io.nekohasekai.libbox.TunOptions
        public native RoutePrefixIterator getInet6RouteRange();

        @Override // io.nekohasekai.libbox.TunOptions
        public native int getMTU();

        @Override // io.nekohasekai.libbox.TunOptions
        public native boolean getStrictRoute();

        @Override // io.nekohasekai.libbox.TunOptions
        public native boolean isHTTPProxyEnabled();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyTunOptions(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyUSBIPServerStatusHandler implements Seq.Proxy, USBIPServerStatusHandler {
        public final int refnum;

        @Override // io.nekohasekai.libbox.USBIPServerStatusHandler
        public native void onError(String message);

        @Override // io.nekohasekai.libbox.USBIPServerStatusHandler
        public native void onStatusUpdate(USBIPServerStatusUpdate status);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyUSBIPServerStatusHandler(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyUSBIPServerStatusIterator implements Seq.Proxy, USBIPServerStatusIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.USBIPServerStatusIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.USBIPServerStatusIterator
        public native USBIPServerStatus next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyUSBIPServerStatusIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyUSBLocalDeviceInfoIterator implements Seq.Proxy, USBLocalDeviceInfoIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.USBLocalDeviceInfoIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.USBLocalDeviceInfoIterator
        public native USBLocalDeviceInfo next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyUSBLocalDeviceInfoIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyUSBLocalProviderHandler implements Seq.Proxy, USBLocalProviderHandler {
        public final int refnum;

        @Override // io.nekohasekai.libbox.USBLocalProviderHandler
        public native void onDeviceError(String serverTag, String deviceID, String message);

        @Override // io.nekohasekai.libbox.USBLocalProviderHandler
        public native void onLocalDevicesChanged();

        @Override // io.nekohasekai.libbox.USBLocalProviderHandler
        public native void onSessionError(String serverTag, String message);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyUSBLocalProviderHandler(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyUSBProviderHandler implements Seq.Proxy, USBProviderHandler {
        public final int refnum;

        @Override // io.nekohasekai.libbox.USBProviderHandler
        public native void onAbort(String deviceID, int endpoint);

        @Override // io.nekohasekai.libbox.USBProviderHandler
        public native void onError(String deviceID, String message);

        @Override // io.nekohasekai.libbox.USBProviderHandler
        public native void onReady(String deviceID, String busID);

        @Override // io.nekohasekai.libbox.USBProviderHandler
        public native void onURBRequest(USBURBRequest request);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyUSBProviderHandler(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyUSBSharedDeviceInterfaceIterator implements Seq.Proxy, USBSharedDeviceInterfaceIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.USBSharedDeviceInterfaceIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.USBSharedDeviceInterfaceIterator
        public native USBSharedDeviceInterface next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyUSBSharedDeviceInterfaceIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyUSBSharedDeviceIterator implements Seq.Proxy, USBSharedDeviceIterator {
        public final int refnum;

        @Override // io.nekohasekai.libbox.USBSharedDeviceIterator
        public native boolean hasNext();

        @Override // io.nekohasekai.libbox.USBSharedDeviceIterator
        public native USBSharedDevice next();

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyUSBSharedDeviceIterator(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }

    private static final class proxyXPCDialer implements Seq.Proxy, XPCDialer {
        public final int refnum;

        @Override // io.nekohasekai.libbox.XPCDialer
        public native int dialXPC() throws Exception;

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyXPCDialer(int refnum) {
            this.refnum = refnum;
            Seq.trackGoRef(refnum, this);
        }
    }
}
