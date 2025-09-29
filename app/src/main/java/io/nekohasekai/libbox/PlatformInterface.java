package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface PlatformInterface {
    void autoDetectInterfaceControl(int fd) throws Exception;

    void checkPlatformShell() throws Exception;

    void clearDNSCache();

    void closeDefaultInterfaceMonitor(InterfaceUpdateListener listener) throws Exception;

    void closeNeighborMonitor(NeighborUpdateListener listener) throws Exception;

    BridgeSession createBridge(BridgeOptions options) throws Exception;

    ConnectionOwner findConnectionOwner(int ipProtocol, String sourceAddress, int sourcePort, String destinationAddress, int destinationPort) throws Exception;

    NetworkInterfaceIterator getInterfaces() throws Exception;

    boolean includeAllNetworks();

    LocalDNSTransport localDNSTransport();

    String lookupSFTPServer() throws Exception;

    PlatformUser lookupUser(String username) throws Exception;

    ShellSession openShellSession(PlatformUser user, String command, StringIterator environ, String term, int rows, int cols) throws Exception;

    int openTun(TunOptions options) throws Exception;

    String readSystemSSHHostKey() throws Exception;

    WIFIState readWIFIState();

    void registerMyInterface(String name);

    void sendNotification(Notification notification) throws Exception;

    void startDefaultInterfaceMonitor(InterfaceUpdateListener listener) throws Exception;

    void startNeighborMonitor(NeighborUpdateListener listener) throws Exception;

    String tailscaleHostname();

    boolean underNetworkExtension();

    boolean usePlatformAutoDetectInterfaceControl();

    boolean usePlatformBridge();

    boolean usePlatformShell();

    boolean useProcFS();
}
