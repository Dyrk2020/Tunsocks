package cn.lolm.vpn;

import android.app.Application;
import android.util.Log;
import io.nekohasekai.libbox.Libbox;
import io.nekohasekai.libbox.SetupOptions;
import kotlin.Metadata;

/* JADX INFO: compiled from: LolmApp.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcn/lolm/vpn/LolmApp;", "Landroid/app/Application;", "<init>", "()V", "stateMachine", "Lcn/lolm/vpn/VpnStateMachine;", "getStateMachine", "()Lcn/lolm/vpn/VpnStateMachine;", "onCreate", "", "setupLibbox", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LolmApp extends Application {
    public static final int $stable = 8;
    private final VpnStateMachine stateMachine = new VpnStateMachine();

    public final VpnStateMachine getStateMachine() {
        return this.stateMachine;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        setupLibbox();
    }

    private final void setupLibbox() {
        try {
            SetupOptions options = new SetupOptions();
            options.setBasePath(getFilesDir().getAbsolutePath());
            options.setWorkingPath(getCacheDir().getAbsolutePath());
            options.setTempPath(getCacheDir().getAbsolutePath());
            options.setFixAndroidStack(true);
            options.setLogMaxLines(2000L);
            options.setDebug(false);
            Libbox.setup(options);
        } catch (Throwable e) {
            Log.e("LoLMVPN", "Libbox.setup failed", e);
        }
    }
}
