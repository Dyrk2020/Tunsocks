package cn.lolm.vpn;

import android.util.Log;
import io.nekohasekai.libbox.CommandServerHandler;
import io.nekohasekai.libbox.SystemProxyStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxCommandHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcn/lolm/vpn/BoxCommandHandler;", "Lio/nekohasekai/libbox/CommandServerHandler;", "stateMachine", "Lcn/lolm/vpn/VpnStateMachine;", "<init>", "(Lcn/lolm/vpn/VpnStateMachine;)V", "serviceStop", "", "serviceReload", "getSystemProxyStatus", "Lio/nekohasekai/libbox/SystemProxyStatus;", "setSystemProxyEnabled", "enabled", "", "triggerNativeCrash", "writeDebugMessage", "message", "", "connectSSHAgent", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BoxCommandHandler implements CommandServerHandler {
    public static final int $stable = 8;
    private final VpnStateMachine stateMachine;

    public BoxCommandHandler(VpnStateMachine stateMachine) {
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        this.stateMachine = stateMachine;
    }

    @Override // io.nekohasekai.libbox.CommandServerHandler
    public void serviceStop() {
        this.stateMachine.toggleOff();
    }

    @Override // io.nekohasekai.libbox.CommandServerHandler
    public void serviceReload() {
    }

    @Override // io.nekohasekai.libbox.CommandServerHandler
    public SystemProxyStatus getSystemProxyStatus() {
        return new SystemProxyStatus();
    }

    @Override // io.nekohasekai.libbox.CommandServerHandler
    public void setSystemProxyEnabled(boolean enabled) {
    }

    @Override // io.nekohasekai.libbox.CommandServerHandler
    public void triggerNativeCrash() {
    }

    @Override // io.nekohasekai.libbox.CommandServerHandler
    public void writeDebugMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Log.d("LoLMVPN", message);
    }

    @Override // io.nekohasekai.libbox.CommandServerHandler
    public int connectSSHAgent() {
        return -1;
    }
}
