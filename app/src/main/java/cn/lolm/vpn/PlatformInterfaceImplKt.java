package cn.lolm.vpn;

import java.net.InterfaceAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PlatformInterfaceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"toPrefix", "", "Ljava/net/InterfaceAddress;", "app_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PlatformInterfaceImplKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String toPrefix(InterfaceAddress $this$toPrefix) {
        String bare;
        String host = $this$toPrefix.getAddress().getHostAddress();
        if (host == null) {
            throw new IllegalArgumentException("interface address has no host address".toString());
        }
        int zoneIdx = StringsKt.indexOf$default((CharSequence) host, '%', 0, false, 6, (Object) null);
        if (zoneIdx >= 0) {
            bare = host.substring(0, zoneIdx);
            Intrinsics.checkNotNullExpressionValue(bare, "substring(...)");
        } else {
            bare = host;
        }
        return bare + "/" + ((int) $this$toPrefix.getNetworkPrefixLength());
    }
}
