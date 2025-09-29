package cn.lolm.vpn;

import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.VpnService;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.OsConstants;
import android.util.Log;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import io.nekohasekai.libbox.BridgeOptions;
import io.nekohasekai.libbox.BridgeSession;
import io.nekohasekai.libbox.ConnectionOwner;
import io.nekohasekai.libbox.InterfaceUpdateListener;
import io.nekohasekai.libbox.LocalDNSTransport;
import io.nekohasekai.libbox.NeighborUpdateListener;
import io.nekohasekai.libbox.NetworkInterfaceIterator;
import io.nekohasekai.libbox.Notification;
import io.nekohasekai.libbox.PlatformInterface;
import io.nekohasekai.libbox.PlatformUser;
import io.nekohasekai.libbox.RoutePrefix;
import io.nekohasekai.libbox.RoutePrefixIterator;
import io.nekohasekai.libbox.ShellSession;
import io.nekohasekai.libbox.StringIterator;
import io.nekohasekai.libbox.TunOptions;
import io.nekohasekai.libbox.WIFIState;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformInterfaceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001FB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J0\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\b\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0013H\u0016J\n\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010-H\u0016J\b\u0010/\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u0007H\u0016JB\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00182\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\u00182\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\rH\u0016J\u0014\u0010;\u001a\u0004\u0018\u0001042\b\u0010<\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010=\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010>\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010?\u001a\u00020\u0018H\u0016J\b\u0010@\u001a\u00020\u0013H\u0016J\u0014\u0010A\u001a\u0004\u0018\u00010B2\b\u0010\u000e\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010D\u001a\u00020\u00072\b\u0010E\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcn/lolm/vpn/PlatformInterfaceImpl;", "Lio/nekohasekai/libbox/PlatformInterface;", NotificationCompat.CATEGORY_SERVICE, "Landroid/net/VpnService;", "onNotification", "Lkotlin/Function1;", "Lio/nekohasekai/libbox/Notification;", "", "onTunOpened", "Landroid/os/ParcelFileDescriptor;", "<init>", "(Landroid/net/VpnService;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "openTun", "", "options", "Lio/nekohasekai/libbox/TunOptions;", "autoDetectInterfaceControl", "fd", "usePlatformAutoDetectInterfaceControl", "", "findConnectionOwner", "Lio/nekohasekai/libbox/ConnectionOwner;", "ipProtocol", "sourceAddress", "", "sourcePort", "destinationAddress", "destinationPort", "getInterfaces", "Lio/nekohasekai/libbox/NetworkInterfaceIterator;", "startDefaultInterfaceMonitor", "listener", "Lio/nekohasekai/libbox/InterfaceUpdateListener;", "closeDefaultInterfaceMonitor", "localDNSTransport", "Lio/nekohasekai/libbox/LocalDNSTransport;", "sendNotification", "notification", "clearDNSCache", "useProcFS", "underNetworkExtension", "includeAllNetworks", "readWIFIState", "Lio/nekohasekai/libbox/WIFIState;", "startNeighborMonitor", "Lio/nekohasekai/libbox/NeighborUpdateListener;", "closeNeighborMonitor", "usePlatformShell", "checkPlatformShell", "openShellSession", "Lio/nekohasekai/libbox/ShellSession;", "user", "Lio/nekohasekai/libbox/PlatformUser;", "command", "environ", "Lio/nekohasekai/libbox/StringIterator;", "term", "rows", "cols", "lookupUser", HintConstants.AUTOFILL_HINT_USERNAME, "lookupSFTPServer", "readSystemSSHHostKey", "tailscaleHostname", "usePlatformBridge", "createBridge", "Lio/nekohasekai/libbox/BridgeSession;", "Lio/nekohasekai/libbox/BridgeOptions;", "registerMyInterface", HintConstants.AUTOFILL_HINT_NAME, "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformInterfaceImpl implements PlatformInterface {
    private static final String LOLM_PACKAGE = "com.tencent.lolm";
    private static final String TAG = "LoLMPlatform";
    private final Function1<Notification, Unit> onNotification;
    private final Function1<ParcelFileDescriptor, Unit> onTunOpened;
    private final VpnService service;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public PlatformInterfaceImpl(VpnService service, Function1<? super Notification, Unit> onNotification, Function1<? super ParcelFileDescriptor, Unit> onTunOpened) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(onNotification, "onNotification");
        Intrinsics.checkNotNullParameter(onTunOpened, "onTunOpened");
        this.service = service;
        this.onNotification = onNotification;
        this.onTunOpened = onTunOpened;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public int openTun(TunOptions options) throws Exception {
        Intrinsics.checkNotNullParameter(options, "options");
        VpnService.Builder builder = new VpnService.Builder(this.service).setSession("LoLM VPN").setMtu(options.getMTU());
        Intrinsics.checkNotNullExpressionValue(builder, "setMtu(...)");
        if (Build.VERSION.SDK_INT >= 29) {
            builder.setMetered(false);
        }
        StringIterator includedPackages = options.getIncludePackage();
        if (!includedPackages.hasNext()) {
            throw new IllegalStateException("android: TUN must include com.tencent.lolm".toString());
        }
        String includedPackage = includedPackages.next();
        if (!Intrinsics.areEqual(includedPackage, LOLM_PACKAGE)) {
            throw new IllegalStateException(("android: TUN must include only com.tencent.lolm, got " + includedPackage).toString());
        }
        if (includedPackages.hasNext()) {
            throw new IllegalStateException("android: TUN must include only com.tencent.lolm".toString());
        }
        try {
            builder.addAllowedApplication(includedPackage);
            RoutePrefixIterator inet4 = options.getInet4Address();
            while (inet4.hasNext()) {
                RoutePrefix addr = inet4.next();
                builder.addAddress(addr.address(), addr.prefix());
            }
            RoutePrefixIterator inet6 = options.getInet6Address();
            while (inet6.hasNext()) {
                RoutePrefix addr2 = inet6.next();
                builder.addAddress(addr2.address(), addr2.prefix());
            }
            if (options.getAutoRoute()) {
                StringIterator dns = options.getDNSServerAddress();
                while (dns.hasNext()) {
                    builder.addDnsServer(dns.next());
                }
                RoutePrefixIterator inet4Route = options.getInet4RouteRange();
                List inet4Routes = new ArrayList();
                while (inet4Route.hasNext()) {
                    RoutePrefix r = inet4Route.next();
                    inet4Routes.add(r.address() + "/" + r.prefix());
                    builder.addRoute(r.address(), r.prefix());
                }
                if (inet4Routes.isEmpty()) {
                    builder.addRoute("0.0.0.0", 0);
                }
                Log.d(TAG, "openTun: inet4 routes = " + inet4Routes);
                RoutePrefixIterator inet6Route = options.getInet6RouteRange();
                List inet6Routes = new ArrayList();
                while (inet6Route.hasNext()) {
                    RoutePrefix r2 = inet6Route.next();
                    inet6Routes.add(r2.address() + "/" + r2.prefix());
                    builder.addRoute(r2.address(), r2.prefix());
                    inet4 = inet4;
                }
                if (inet6Routes.isEmpty() && options.getInet6Address().hasNext()) {
                    builder.addRoute("::", 0);
                }
                if (!inet6Routes.isEmpty()) {
                    Log.d(TAG, "openTun: inet6 routes = " + inet6Routes);
                }
            }
            ParcelFileDescriptor pfd = builder.establish();
            if (pfd == null) {
                throw new IllegalStateException("android: the application is not prepared or is revoked".toString());
            }
            this.onTunOpened.invoke(pfd);
            return pfd.getFd();
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalStateException(("android: allowed package is not installed: " + includedPackage).toString());
        }
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public void autoDetectInterfaceControl(int fd) {
        boolean ok = this.service.protect(fd);
        Log.d(TAG, "autoDetectInterfaceControl: protect(fd=" + fd + ") = " + ok);
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public boolean usePlatformAutoDetectInterfaceControl() {
        return true;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public ConnectionOwner findConnectionOwner(int ipProtocol, String sourceAddress, int sourcePort, String destinationAddress, int destinationPort) {
        Intrinsics.checkNotNullParameter(sourceAddress, "sourceAddress");
        Intrinsics.checkNotNullParameter(destinationAddress, "destinationAddress");
        return new ConnectionOwner();
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public NetworkInterfaceIterator getInterfaces() {
        Object objM6606constructorimpl;
        Object objM6606constructorimpl2;
        String name;
        Object element$iv;
        Object objM6606constructorimpl3;
        int i;
        int i2;
        PlatformInterfaceImpl platformInterfaceImpl = this;
        Object systemService = platformInterfaceImpl.service.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager != null) {
            ConnectivityManager cm = connectivityManager;
            Network[] networks = cm.getAllNetworks();
            Intrinsics.checkNotNullExpressionValue(networks, "getAllNetworks(...)");
            try {
                Result.Companion companion = Result.INSTANCE;
                objM6606constructorimpl = Result.m6606constructorimpl(Collections.list(NetworkInterface.getNetworkInterfaces()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM6606constructorimpl = Result.m6606constructorimpl(ResultKt.createFailure(th));
            }
            List listEmptyList = CollectionsKt.emptyList();
            if (Result.m6612isFailureimpl(objM6606constructorimpl)) {
                objM6606constructorimpl = listEmptyList;
            }
            Iterable osInterfaces = (List) objM6606constructorimpl;
            List out = new ArrayList();
            int length = networks.length;
            int i3 = 0;
            while (i3 < length) {
                Network network = networks[i3];
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM6606constructorimpl2 = Result.m6606constructorimpl(cm.getLinkProperties(network));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM6606constructorimpl2 = Result.m6606constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m6612isFailureimpl(objM6606constructorimpl2)) {
                    objM6606constructorimpl2 = null;
                }
                LinkProperties lp = (LinkProperties) objM6606constructorimpl2;
                if (lp != null && (name = lp.getInterfaceName()) != null) {
                    Intrinsics.checkNotNull(osInterfaces);
                    Iterable $this$firstOrNull$iv = osInterfaces;
                    Iterator it = $this$firstOrNull$iv.iterator();
                    do {
                        if (!it.hasNext()) {
                            element$iv = null;
                            break;
                        }
                        element$iv = it.next();
                    } while (!Intrinsics.areEqual(((NetworkInterface) element$iv).getName(), name));
                    NetworkInterface osIf = (NetworkInterface) element$iv;
                    if (osIf != null) {
                        try {
                            Result.Companion companion5 = Result.INSTANCE;
                            objM6606constructorimpl3 = Result.m6606constructorimpl(cm.getNetworkCapabilities(network));
                        } catch (Throwable th3) {
                            Result.Companion companion6 = Result.INSTANCE;
                            objM6606constructorimpl3 = Result.m6606constructorimpl(ResultKt.createFailure(th3));
                        }
                        if (Result.m6612isFailureimpl(objM6606constructorimpl3)) {
                            objM6606constructorimpl3 = null;
                        }
                        NetworkCapabilities caps = (NetworkCapabilities) objM6606constructorimpl3;
                        if (caps != null) {
                            io.nekohasekai.libbox.NetworkInterface $this$getInterfaces_u24lambda_u248 = new io.nekohasekai.libbox.NetworkInterface();
                            $this$getInterfaces_u24lambda_u248.setName(name);
                            $this$getInterfaces_u24lambda_u248.setIndex(osIf.getIndex());
                            try {
                                Result.Companion companion7 = Result.INSTANCE;
                                $this$getInterfaces_u24lambda_u248.setMTU(osIf.getMTU());
                                Result.m6606constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th4) {
                                Result.Companion companion8 = Result.INSTANCE;
                                Result.m6606constructorimpl(ResultKt.createFailure(th4));
                            }
                            Iterable interfaceAddresses = osIf.getInterfaceAddresses();
                            Intrinsics.checkNotNullExpressionValue(interfaceAddresses, "getInterfaceAddresses(...)");
                            Iterable $this$map$iv = interfaceAddresses;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                InterfaceAddress it2 = (InterfaceAddress) item$iv$iv;
                                Intrinsics.checkNotNull(it2);
                                destination$iv$iv.add(PlatformInterfaceImplKt.toPrefix(it2));
                                $this$map$iv = $this$map$iv;
                            }
                            $this$getInterfaces_u24lambda_u248.setAddresses(new StringArray(((List) destination$iv$iv).iterator()));
                            int i4 = 1;
                            if (caps.hasTransport(1)) {
                                i4 = 0;
                                i = 0;
                            } else {
                                i = 0;
                                if (!caps.hasTransport(0)) {
                                    i4 = 3;
                                    if (caps.hasTransport(3)) {
                                        i4 = 2;
                                    }
                                }
                            }
                            $this$getInterfaces_u24lambda_u248.setType(i4);
                            if (caps.hasCapability(12)) {
                                i2 = OsConstants.IFF_UP | OsConstants.IFF_RUNNING;
                            } else {
                                i2 = i;
                            }
                            $this$getInterfaces_u24lambda_u248.setFlags(i2);
                            out.add($this$getInterfaces_u24lambda_u248);
                            Log.d(TAG, "getInterfaces: " + name + " idx=" + osIf.getIndex() + " type=" + $this$getInterfaces_u24lambda_u248.getType());
                        }
                    }
                }
                i3++;
                platformInterfaceImpl = this;
                cm = cm;
            }
            return new InterfaceArray(out.iterator());
        }
        return new InterfaceArray(new ArrayList().iterator());
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public void startDefaultInterfaceMonitor(InterfaceUpdateListener listener) {
        DefaultNetworkMonitor.INSTANCE.setListener(listener);
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public void closeDefaultInterfaceMonitor(InterfaceUpdateListener listener) {
        DefaultNetworkMonitor.INSTANCE.setListener(null);
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public LocalDNSTransport localDNSTransport() {
        return LocalResolver.INSTANCE;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public void sendNotification(Notification notification) {
        if (notification != null) {
            this.onNotification.invoke(notification);
        }
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public void clearDNSCache() {
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public boolean useProcFS() {
        return false;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public boolean underNetworkExtension() {
        return false;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public boolean includeAllNetworks() {
        return false;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public WIFIState readWIFIState() {
        return null;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public void startNeighborMonitor(NeighborUpdateListener listener) {
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public void closeNeighborMonitor(NeighborUpdateListener listener) {
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public boolean usePlatformShell() {
        return false;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public void checkPlatformShell() {
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public ShellSession openShellSession(PlatformUser user, String command, StringIterator environ, String term, int rows, int cols) {
        return null;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public PlatformUser lookupUser(String username) {
        return null;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public String lookupSFTPServer() {
        return null;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public String readSystemSSHHostKey() {
        return null;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public String tailscaleHostname() {
        return "";
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public boolean usePlatformBridge() {
        return false;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public BridgeSession createBridge(BridgeOptions options) {
        return null;
    }

    @Override // io.nekohasekai.libbox.PlatformInterface
    public void registerMyInterface(String name) {
    }
}
