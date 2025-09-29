package cn.lolm.vpn;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: VpnState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcn/lolm/vpn/VpnStateMachine;", "", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcn/lolm/vpn/VpnState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "toggleOn", "", "markConnected", "error", "message", "", "toggleOff", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VpnStateMachine {
    public static final int $stable = 8;
    private final MutableStateFlow<VpnState> _state = StateFlowKt.MutableStateFlow(VpnState.Idle.INSTANCE);
    private final StateFlow<VpnState> state = FlowKt.asStateFlow(this._state);

    public final StateFlow<VpnState> getState() {
        return this.state;
    }

    public final void toggleOn() {
        if (this._state.getValue() instanceof VpnState.Idle) {
            this._state.setValue(VpnState.Connecting.INSTANCE);
        }
    }

    public final void markConnected() {
        if (this._state.getValue() instanceof VpnState.Connecting) {
            this._state.setValue(VpnState.Connected.INSTANCE);
        }
    }

    public final void error(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        VpnState current = this._state.getValue();
        if ((current instanceof VpnState.Connecting) || (current instanceof VpnState.Connected)) {
            this._state.setValue(new VpnState.Error(message));
        }
    }

    public final void toggleOff() {
        this._state.setValue(VpnState.Idle.INSTANCE);
    }
}
