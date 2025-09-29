package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface BridgeSession {
    void close() throws Exception;

    int fileDescriptor();

    boolean inet6Active();

    String name();

    void setEgress(String interfaceName) throws Exception;
}
