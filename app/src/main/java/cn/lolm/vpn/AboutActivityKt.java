package cn.lolm.vpn;

import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AboutActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"AboutScreen", "", "(Landroidx/compose/runtime/Composer;I)V", "ABOUT_BODY", "", "app_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AboutActivityKt {
    private static final String ABOUT_BODY = "How this VPN routes LoLM traffic\n\nAndroid admits only `com.tencent.lolm` into this VPN. Other apps stay on the\nsystem network. For LoLM connections, a per-domain rule chooses the baked\nproxy node or a direct route. domain_strategy is AsIs, so rules match the\ndomain name as supplied.\n\nFixed private proxy node\n\nThis build uses the SOCKS endpoint `lol.yxhost.cn:26536`. It is a private\nproxy egress, not a private game server. The app depends on that endpoint and\nits remote privilege policy remaining available.\n\nRules (evaluated in order, first match wins):\n\n  1. full:ipecho.net           -> proxy   (diagnostic: verify node egress IP)\n  2. full:priv.igame.qq.com    -> proxy   (LoLM privilege check endpoint)\n  3. full:lbs.map.qq.com       -> direct  (location service stays local)\n  4. anything else             -> direct  (route.final fallback)\n\nOnly `priv.igame.qq.com` and the diagnostic endpoint use the node. Match\nservers, voice channels, and realtime UDP flows remain direct. The node makes\nthe privilege endpoint see its egress IP; the exact server-side decision is\nnot part of this app.\n\nObserved location and network sequence\n\nThe VPN does not request, spoof, or change Android location. LoLM itself must\nhave location permission. The following sequence has produced the privilege:\n\n  1. Grant LoLM location permission and enter the game on mobile data.\n  2. Turn on this VPN.\n  3. Switch the physical network to Wi-Fi.\n  4. Turn off system location.\n\nThis is observed behavior, not a guaranteed server protocol. A likely\nexplanation is that LoLM caches its initial real location/network context\nbefore the privilege check sees the node egress IP. Turning location off after\nswitching to Wi-Fi may prevent a later LBS refresh. The server implementation\nand cache lifetime are unknown.\n\nWhen the toggle is off:\n  • No residual tunnel, background service, or route override remains.\n\nIf another VPN app starts while this one is active, Android revokes this app's\nVPN and the toggle snaps back to off. No contention, no auto-reconnect. After\nthe app is killed or the device reboots, the VPN is off until you toggle it\nagain.\n\nThe node is fixed at build time. There is no node selection, subscription, or\nin-app configuration.";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AboutScreen$lambda$0(int i, Composer composer, int i2) {
        AboutScreen(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AboutScreen(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1500039862);
        ComposerKt.sourceInformation($composer2, "C(AboutScreen)33@1176L452:AboutActivity.kt#ls3kpf");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1500039862, $changed, -1, "cn.lolm.vpn.AboutScreen (AboutActivity.kt:32)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableSingletons$AboutActivityKt.INSTANCE.m6600getLambda2$app_debug(), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cn.lolm.vpn.AboutActivityKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AboutActivityKt.AboutScreen$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
