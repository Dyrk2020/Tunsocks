package cn.lolm.vpn;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.util.Log;
import io.nekohasekai.libbox.InterfaceUpdateListener;
import java.net.NetworkInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultNetworkMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcn/lolm/vpn/DefaultNetworkMonitor;", "", "<init>", "()V", "TAG", "", "NET_TAG", "connectivity", "Landroid/net/ConnectivityManager;", "callback", "Landroid/net/ConnectivityManager$NetworkCallback;", "defaultNetwork", "Landroid/net/Network;", "listener", "Lio/nekohasekai/libbox/InterfaceUpdateListener;", "start", "", "context", "Landroid/content/Context;", "stop", "setListener", "currentDefaultNetwork", "notifyListener", "network", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultNetworkMonitor {
    private static final String NET_TAG = "LoLMDefaultNet";
    private static final String TAG = "LoLMNet";
    private static ConnectivityManager.NetworkCallback callback;
    private static ConnectivityManager connectivity;
    private static volatile Network defaultNetwork;
    private static volatile InterfaceUpdateListener listener;
    public static final DefaultNetworkMonitor INSTANCE = new DefaultNetworkMonitor();
    public static final int $stable = 8;

    private DefaultNetworkMonitor() {
    }

    public final void start(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (callback != null) {
            return;
        }
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager cm = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (cm == null) {
            Log.e(TAG, "no ConnectivityManager");
            return;
        }
        connectivity = cm;
        NetworkRequest request = new NetworkRequest.Builder().addCapability(12).addCapability(15).build();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: cn.lolm.vpn.DefaultNetworkMonitor$start$cb$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                Log.d("LoLMNet", "underlying network available");
                DefaultNetworkMonitor defaultNetworkMonitor = DefaultNetworkMonitor.INSTANCE;
                DefaultNetworkMonitor.defaultNetwork = network;
                DefaultNetworkMonitor.INSTANCE.notifyListener(network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                Log.d("LoLMNet", "underlying network lost");
                if (Intrinsics.areEqual(DefaultNetworkMonitor.defaultNetwork, network)) {
                    DefaultNetworkMonitor defaultNetworkMonitor = DefaultNetworkMonitor.INSTANCE;
                    DefaultNetworkMonitor.defaultNetwork = null;
                    DefaultNetworkMonitor.INSTANCE.notifyListener(null);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities capabilities) {
                Intrinsics.checkNotNullParameter(network, "network");
                Intrinsics.checkNotNullParameter(capabilities, "capabilities");
                if (Intrinsics.areEqual(network, DefaultNetworkMonitor.defaultNetwork)) {
                    DefaultNetworkMonitor.INSTANCE.notifyListener(network);
                }
            }
        };
        try {
            cm.registerNetworkCallback(request, networkCallback);
            defaultNetwork = cm.getActiveNetwork();
            callback = networkCallback;
            Log.d(TAG, "monitor started");
        } catch (Throwable e) {
            Log.e(TAG, "registerNetworkCallback failed", e);
        }
    }

    public final void stop() {
        ConnectivityManager.NetworkCallback cb;
        ConnectivityManager cm = connectivity;
        if (cm == null || (cb = callback) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            DefaultNetworkMonitor defaultNetworkMonitor = this;
            cm.unregisterNetworkCallback(cb);
            Result.m6606constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m6606constructorimpl(ResultKt.createFailure(th));
        }
        callback = null;
        connectivity = null;
        defaultNetwork = null;
        Log.d(TAG, "monitor stopped");
    }

    public final void setListener(InterfaceUpdateListener listener2) {
        listener = listener2;
        notifyListener(defaultNetwork);
    }

    public final Network currentDefaultNetwork() {
        return defaultNetwork;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyListener(Network network) {
        Object objM6606constructorimpl;
        Object objM6606constructorimpl2;
        InterfaceUpdateListener l = listener;
        if (l == null) {
            return;
        }
        if (network == null) {
            try {
                l.updateDefaultInterface("", -1, false, false);
                return;
            } catch (Throwable e) {
                Log.e(TAG, "updateDefaultInterface(empty) failed", e);
                return;
            }
        }
        ConnectivityManager cm = connectivity;
        if (cm == null) {
            return;
        }
        for (int attempt = 0; attempt < 10; attempt++) {
            try {
                Result.Companion companion = Result.INSTANCE;
                DefaultNetworkMonitor defaultNetworkMonitor = this;
                objM6606constructorimpl = Result.m6606constructorimpl(cm.getLinkProperties(network));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM6606constructorimpl = Result.m6606constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m6612isFailureimpl(objM6606constructorimpl)) {
                objM6606constructorimpl = null;
            }
            LinkProperties lp = (LinkProperties) objM6606constructorimpl;
            String name = lp != null ? lp.getInterfaceName() : null;
            if (name != null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    DefaultNetworkMonitor defaultNetworkMonitor2 = this;
                    NetworkInterface byName = NetworkInterface.getByName(name);
                    objM6606constructorimpl2 = Result.m6606constructorimpl(byName != null ? Integer.valueOf(byName.getIndex()) : null);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM6606constructorimpl2 = Result.m6606constructorimpl(ResultKt.createFailure(th2));
                }
                Integer idx = (Integer) (Result.m6612isFailureimpl(objM6606constructorimpl2) ? null : objM6606constructorimpl2);
                if (idx != null) {
                    try {
                        l.updateDefaultInterface(name, idx.intValue(), false, false);
                        Log.d(TAG, "updateDefaultInterface(" + name + ", idx=" + idx + ")");
                        return;
                    } catch (Throwable e2) {
                        Log.e(TAG, "updateDefaultInterface failed", e2);
                        return;
                    }
                }
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        Log.w(TAG, "could not resolve default interface for network " + network);
    }
}
