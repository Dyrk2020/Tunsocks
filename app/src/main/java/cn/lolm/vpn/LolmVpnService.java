package cn.lolm.vpn;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.VpnService;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import io.nekohasekai.libbox.CommandServer;
import io.nekohasekai.libbox.Notification;
import io.nekohasekai.libbox.OverrideOptions;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: LolmVpnService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\b\u0010!\u001a\u00020\u0015H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0016J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcn/lolm/vpn/LolmVpnService;", "Landroid/net/VpnService;", "<init>", "()V", "platformInterface", "Lcn/lolm/vpn/PlatformInterfaceImpl;", "commandServer", "Lio/nekohasekai/libbox/CommandServer;", "handler", "Lcn/lolm/vpn/BoxCommandHandler;", "pfd", "Landroid/os/ParcelFileDescriptor;", "tunnelLock", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "boxJob", "Lkotlinx/coroutines/Job;", "commandServerStarted", "", "onCreate", "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "stopVpn", "retainTun", "descriptor", "closeTun", "stopVpnInternal", "onRevoke", "onDestroy", "showBoxNotification", "notification", "Lio/nekohasekai/libbox/Notification;", "buildForegroundNotification", "Landroid/app/Notification;", "createNotificationChannel", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LolmVpnService extends VpnService {
    public static final String ACTION_STOP = "cn.lolm.vpn.STOP";
    private static final String CHANNEL_ID = "cn.lolm.vpn.foreground";
    private static final String CONFIG_ASSET = "lolm-config.json";
    private static final int NOTIF_ID = 1;
    private static final String TAG = "LoLMVPN";
    private Job boxJob;
    private CommandServer commandServer;
    private volatile boolean commandServerStarted;
    private BoxCommandHandler handler;
    private ParcelFileDescriptor pfd;
    private PlatformInterfaceImpl platformInterface;
    public static final int $stable = 8;
    private final Object tunnelLock = new Object();
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type cn.lolm.vpn.LolmApp");
        LolmApp app = (LolmApp) application;
        this.handler = new BoxCommandHandler(app.getStateMachine());
        this.platformInterface = new PlatformInterfaceImpl(this, new AnonymousClass1(this), new AnonymousClass2(this));
        BoxCommandHandler boxCommandHandler = this.handler;
        PlatformInterfaceImpl platformInterfaceImpl = null;
        if (boxCommandHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handler");
            boxCommandHandler = null;
        }
        BoxCommandHandler boxCommandHandler2 = boxCommandHandler;
        PlatformInterfaceImpl platformInterfaceImpl2 = this.platformInterface;
        if (platformInterfaceImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformInterface");
        } else {
            platformInterfaceImpl = platformInterfaceImpl2;
        }
        this.commandServer = new CommandServer(boxCommandHandler2, platformInterfaceImpl);
        createNotificationChannel();
        DefaultNetworkMonitor.INSTANCE.start(this);
    }

    /* JADX INFO: renamed from: cn.lolm.vpn.LolmVpnService$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: LolmVpnService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Notification, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, LolmVpnService.class, "showBoxNotification", "showBoxNotification(Lio/nekohasekai/libbox/Notification;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Notification notification) {
            invoke2(notification);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Notification p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((LolmVpnService) this.receiver).showBoxNotification(p0);
        }
    }

    /* JADX INFO: renamed from: cn.lolm.vpn.LolmVpnService$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: LolmVpnService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ParcelFileDescriptor, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, LolmVpnService.class, "retainTun", "retainTun(Landroid/os/ParcelFileDescriptor;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ParcelFileDescriptor parcelFileDescriptor) {
            invoke2(parcelFileDescriptor);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ParcelFileDescriptor p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((LolmVpnService) this.receiver).retainTun(p0);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, ACTION_STOP)) {
            stopVpn();
            return 2;
        }
        if (VpnService.prepare(this) != null) {
            Application application = getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type cn.lolm.vpn.LolmApp");
            ((LolmApp) application).getStateMachine().toggleOff();
            stopSelf();
            return 2;
        }
        Application application2 = getApplication();
        Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type cn.lolm.vpn.LolmApp");
        ((LolmApp) application2).getStateMachine().toggleOn();
        startForeground(1, buildForegroundNotification());
        this.boxJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C05671(null), 3, null);
        return 2;
    }

    /* JADX INFO: renamed from: cn.lolm.vpn.LolmVpnService$onStartCommand$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LolmVpnService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "cn.lolm.vpn.LolmVpnService$onStartCommand$1", f = "LolmVpnService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05671(Continuation<? super C05671> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LolmVpnService.this.new C05671(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    try {
                        CommandServer commandServer = null;
                        if (!LolmVpnService.this.commandServerStarted) {
                            CommandServer commandServer2 = LolmVpnService.this.commandServer;
                            if (commandServer2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("commandServer");
                                commandServer2 = null;
                            }
                            commandServer2.start();
                            LolmVpnService.this.commandServerStarted = true;
                        }
                        InputStream inputStreamOpen = LolmVpnService.this.getAssets().open(LolmVpnService.CONFIG_ASSET);
                        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
                        Reader inputStreamReader = new InputStreamReader(inputStreamOpen, Charsets.UTF_8);
                        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                        try {
                            BufferedReader it = bufferedReader;
                            String config = TextStreamsKt.readText(it);
                            CloseableKt.closeFinally(bufferedReader, null);
                            CommandServer commandServer3 = LolmVpnService.this.commandServer;
                            if (commandServer3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("commandServer");
                            } else {
                                commandServer = commandServer3;
                            }
                            commandServer.startOrReloadService(config, new OverrideOptions());
                            Application application = LolmVpnService.this.getApplication();
                            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type cn.lolm.vpn.LolmApp");
                            ((LolmApp) application).getStateMachine().markConnected();
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(bufferedReader, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable e) {
                        Log.e(LolmVpnService.TAG, "box start failed", e);
                        Application application2 = LolmVpnService.this.getApplication();
                        Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type cn.lolm.vpn.LolmApp");
                        VpnStateMachine stateMachine = ((LolmApp) application2).getStateMachine();
                        String message = e.getMessage();
                        if (message == null) {
                            message = "start failed";
                        }
                        stateMachine.error(message);
                        LolmVpnService.this.stopVpnInternal();
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void stopVpn() {
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type cn.lolm.vpn.LolmApp");
        ((LolmApp) application).getStateMachine().toggleOff();
        Job job = this.boxJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.boxJob = null;
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C05681(null), 3, null);
    }

    /* JADX INFO: renamed from: cn.lolm.vpn.LolmVpnService$stopVpn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LolmVpnService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "cn.lolm.vpn.LolmVpnService$stopVpn$1", f = "LolmVpnService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05681(Continuation<? super C05681> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LolmVpnService.this.new C05681(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    LolmVpnService.this.stopVpnInternal();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retainTun(ParcelFileDescriptor descriptor) {
        Object objM6606constructorimpl;
        synchronized (this.tunnelLock) {
            ParcelFileDescriptor it = this.pfd;
            if (it != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    LolmVpnService lolmVpnService = this;
                    it.close();
                    objM6606constructorimpl = Result.m6606constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM6606constructorimpl = Result.m6606constructorimpl(ResultKt.createFailure(th));
                }
                Result.m6605boximpl(objM6606constructorimpl);
            }
            this.pfd = descriptor;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void closeTun() {
        Object objM6606constructorimpl;
        synchronized (this.tunnelLock) {
            ParcelFileDescriptor it = this.pfd;
            if (it != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    LolmVpnService lolmVpnService = this;
                    it.close();
                    objM6606constructorimpl = Result.m6606constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM6606constructorimpl = Result.m6606constructorimpl(ResultKt.createFailure(th));
                }
                Result.m6605boximpl(objM6606constructorimpl);
            }
            this.pfd = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopVpnInternal() {
        closeTun();
        CommandServer commandServer = null;
        try {
            if (this.commandServerStarted) {
                CommandServer commandServer2 = this.commandServer;
                if (commandServer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("commandServer");
                    commandServer2 = null;
                }
                commandServer2.closeService();
            }
        } catch (Throwable e) {
            Log.e(TAG, "closeService", e);
        }
        try {
            if (this.commandServerStarted) {
                CommandServer commandServer3 = this.commandServer;
                if (commandServer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("commandServer");
                } else {
                    commandServer = commandServer3;
                }
                commandServer.close();
            }
        } catch (Throwable e2) {
            Log.e(TAG, "close", e2);
        }
        this.commandServerStarted = false;
        stopForeground(1);
        stopSelf();
    }

    @Override // android.net.VpnService
    public void onRevoke() {
        stopVpn();
    }

    @Override // android.app.Service
    public void onDestroy() {
        closeTun();
        CommandServer commandServer = null;
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        try {
            if (this.commandServerStarted) {
                CommandServer commandServer2 = this.commandServer;
                if (commandServer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("commandServer");
                } else {
                    commandServer = commandServer2;
                }
                commandServer.close();
            }
        } catch (Throwable th) {
        }
        DefaultNetworkMonitor.INSTANCE.stop();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBoxNotification(Notification notification) {
        NotificationManager nm = (NotificationManager) getSystemService(NotificationManager.class);
        if (nm == null) {
            return;
        }
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(android.R.drawable.ic_dialog_info);
        String title = notification.getTitle();
        if (title == null) {
            title = getString(R.string.notification_connected);
            Intrinsics.checkNotNullExpressionValue(title, "getString(...)");
        }
        NotificationCompat.Builder contentTitle = smallIcon.setContentTitle(title);
        String body = notification.getBody();
        if (body == null) {
            body = getString(R.string.notification_text);
            Intrinsics.checkNotNullExpressionValue(body, "getString(...)");
        }
        android.app.Notification n = contentTitle.setContentText(body).setOngoing(true).build();
        Intrinsics.checkNotNullExpressionValue(n, "build(...)");
        nm.notify(1, n);
    }

    private final android.app.Notification buildForegroundNotification() {
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class), 201326592);
        android.app.Notification notificationBuild = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(android.R.drawable.ic_dialog_info).setContentTitle(getString(R.string.notification_connected)).setContentText(getString(R.string.notification_text)).setOngoing(true).setContentIntent(pi).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        return notificationBuild;
    }

    private final void createNotificationChannel() {
        NotificationManager nm;
        if (Build.VERSION.SDK_INT >= 26 && (nm = (NotificationManager) getSystemService(NotificationManager.class)) != null && nm.getNotificationChannel(CHANNEL_ID) == null) {
            NotificationChannel $this$createNotificationChannel_u24lambda_u246 = new NotificationChannel(CHANNEL_ID, getString(R.string.notification_channel), 2);
            $this$createNotificationChannel_u24lambda_u246.setDescription(getString(R.string.notification_text));
            nm.createNotificationChannel($this$createNotificationChannel_u24lambda_u246);
        }
    }
}
