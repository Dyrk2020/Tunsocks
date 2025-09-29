package cn.lolm.vpn;

import kotlin.Metadata;

/* JADX INFO: compiled from: DnsResponseCodes.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcn/lolm/vpn/DnsResponseCodes;", "", "<init>", "()V", "SERVFAIL", "", "NXDOMAIN", "forResolverFailure", "forUnknownHost", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DnsResponseCodes {
    public static final int $stable = 0;
    public static final DnsResponseCodes INSTANCE = new DnsResponseCodes();
    private static final int NXDOMAIN = 3;
    private static final int SERVFAIL = 2;

    private DnsResponseCodes() {
    }

    public final int forResolverFailure() {
        return 2;
    }

    public final int forUnknownHost() {
        return 3;
    }
}
