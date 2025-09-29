package cn.lolm.vpn;

import android.app.Application;
import android.content.Intent;
import android.net.VpnService;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\r\u0010\u000b\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0017²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"Lcn/lolm/vpn/MainActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "prepareLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "MainScreen", "(Landroidx/compose/runtime/Composer;I)V", "toggle", "requested", "", "sm", "Lcn/lolm/vpn/VpnStateMachine;", "startVpnService", "statusText", "", "state", "Lcn/lolm/vpn/VpnState;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MainActivity extends ComponentActivity {
    public static final int $stable = 8;
    private ActivityResultLauncher<Intent> prepareLauncher;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainScreen$lambda$2(MainActivity mainActivity, int i, Composer composer, int i2) {
        mainActivity.MainScreen(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.prepareLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cn.lolm.vpn.MainActivity$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MainActivity.onCreate$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-1337239413, true, new Function2<Composer, Integer, Unit>() { // from class: cn.lolm.vpn.MainActivity.onCreate.2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "C47@1905L12:MainActivity.kt#ls3kpf");
                if (($changed & 3) == 2 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1337239413, $changed, -1, "cn.lolm.vpn.MainActivity.onCreate.<anonymous> (MainActivity.kt:47)");
                }
                MainActivity.this.MainScreen($composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(MainActivity this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            this$0.startVpnService();
            return;
        }
        Application application = this$0.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type cn.lolm.vpn.LolmApp");
        ((LolmApp) application).getStateMachine().toggleOff();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MainScreen(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-112850148);
        ComposerKt.sourceInformation($composer2, "C(MainScreen)53@2059L16,55@2175L719,55@2161L733:MainActivity.kt#ls3kpf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-112850148, $dirty2, -1, "cn.lolm.vpn.MainActivity.MainScreen (MainActivity.kt:51)");
            }
            Application application = getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type cn.lolm.vpn.LolmApp");
            VpnStateMachine sm = ((LolmApp) application).getStateMachine();
            State state$delegate = SnapshotStateKt.collectAsState(sm.getState(), null, $composer2, 0, 1);
            boolean on = (MainScreen$lambda$1(state$delegate) instanceof VpnState.Connecting) || (MainScreen$lambda$1(state$delegate) instanceof VpnState.Connected);
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableLambdaKt.rememberComposableLambda(466312648, true, new AnonymousClass1(on, this, sm, state$delegate), $composer2, 54), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cn.lolm.vpn.MainActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.MainScreen$lambda$2(this.f$0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VpnState MainScreen$lambda$1(State<? extends VpnState> state) {
        Object thisObj$iv = state.getValue();
        return (VpnState) thisObj$iv;
    }

    /* JADX INFO: renamed from: cn.lolm.vpn.MainActivity$MainScreen$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ boolean $on;
        final /* synthetic */ VpnStateMachine $sm;
        final /* synthetic */ State<VpnState> $state$delegate;
        final /* synthetic */ MainActivity this$0;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(boolean z, MainActivity mainActivity, VpnStateMachine vpnStateMachine, State<? extends VpnState> state) {
            this.$on = z;
            this.this$0 = mainActivity;
            this.$sm = vpnStateMachine;
            this.$state$delegate = state;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            Object value$iv;
            ComposerKt.sourceInformation($composer, "C56@2189L695:MainActivity.kt#ls3kpf");
            if (($changed & 3) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(466312648, $changed, -1, "cn.lolm.vpn.MainActivity.MainScreen.<anonymous> (MainActivity.kt:56)");
                }
                Modifier modifier$iv = PaddingKt.m681padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6299constructorimpl(24));
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getCenterHorizontally();
                boolean z = this.$on;
                final MainActivity mainActivity = this.this$0;
                final VpnStateMachine vpnStateMachine = this.$sm;
                State<VpnState> state = this.$state$delegate;
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                int $changed$iv$iv = (438 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    $composer.createNode(constructor);
                } else {
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3333constructorimpl($composer);
                Updater.m3340setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3340setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                }
                Updater.m3340setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i2 = ((438 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 996734595, "C61@2405L10,61@2366L65,62@2448L30,63@2534L38,63@2495L78,64@2590L29,65@2636L23,66@2676L30,67@2744L107,67@2723L147:MainActivity.kt#ls3kpf");
                TextKt.m2373Text4IGK_g("LoLM VPN", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getHeadlineMedium(), $composer, 6, 0, 65534);
                SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6299constructorimpl(16)), $composer, 6);
                $composer.startReplaceGroup(-799126354);
                ComposerKt.sourceInformation($composer, "CC(remember):MainActivity.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(mainActivity) | $composer.changedInstance(vpnStateMachine);
                Object value$iv2 = $composer.rememberedValue();
                if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function1() { // from class: cn.lolm.vpn.MainActivity$MainScreen$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivity.AnonymousClass1.invoke$lambda$4$lambda$1$lambda$0(mainActivity, vpnStateMachine, ((Boolean) obj).booleanValue());
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                }
                $composer.endReplaceGroup();
                SwitchKt.Switch(z, (Function1) value$iv2, null, null, false, null, null, $composer, 0, 124);
                SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6299constructorimpl(8)), $composer, 6);
                TextKt.m2373Text4IGK_g(mainActivity.statusText(MainActivity.MainScreen$lambda$1(state)), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
                SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6299constructorimpl(24)), $composer, 6);
                $composer.startReplaceGroup(-799119565);
                ComposerKt.sourceInformation($composer, "CC(remember):MainActivity.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance(mainActivity);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0() { // from class: cn.lolm.vpn.MainActivity$MainScreen$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainActivity.AnonymousClass1.invoke$lambda$4$lambda$3$lambda$2(mainActivity);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                ButtonKt.TextButton((Function0) value$iv, null, false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.m6601getLambda1$app_debug(), $composer, 805306368, 510);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$4$lambda$1$lambda$0(MainActivity this$0, VpnStateMachine $sm, boolean requested) {
            this$0.toggle(requested, $sm);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$4$lambda$3$lambda$2(MainActivity this$0) {
            this$0.startActivity(new Intent(this$0, (Class<?>) AboutActivity.class));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggle(boolean requested, VpnStateMachine sm) {
        if (requested) {
            sm.toggleOn();
            Intent prepare = VpnService.prepare(this);
            if (prepare != null) {
                ActivityResultLauncher<Intent> activityResultLauncher = this.prepareLauncher;
                if (activityResultLauncher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("prepareLauncher");
                    activityResultLauncher = null;
                }
                activityResultLauncher.launch(prepare);
                return;
            }
            startVpnService();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) LolmVpnService.class);
        intent.setAction(LolmVpnService.ACTION_STOP);
        startService(intent);
    }

    private final void startVpnService() {
        startService(new Intent(this, (Class<?>) LolmVpnService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String statusText(VpnState state) {
        if (Intrinsics.areEqual(state, VpnState.Idle.INSTANCE)) {
            return "Idle";
        }
        if (Intrinsics.areEqual(state, VpnState.Connecting.INSTANCE)) {
            return "Connecting…";
        }
        if (Intrinsics.areEqual(state, VpnState.Connected.INSTANCE)) {
            return "Connected";
        }
        if (!(state instanceof VpnState.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return "Error: " + ((VpnState.Error) state).getMessage();
    }
}
