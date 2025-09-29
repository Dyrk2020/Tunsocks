package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface LocalDNSTransport {
    void exchange(ExchangeContext ctx, byte[] message) throws Exception;

    void lookup(ExchangeContext ctx, String network, String domain) throws Exception;

    boolean raw();
}
