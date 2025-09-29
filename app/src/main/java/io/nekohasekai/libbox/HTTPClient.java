package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface HTTPClient {
    void close();

    void keepAlive();

    void modernTLS();

    HTTPRequest newRequest();

    void pinnedSHA256(String sumHex);

    void pinnedTLS12();

    void restrictedTLS();

    void trySocks5(int port);
}
