package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface CommandServerHandler {
    int connectSSHAgent() throws Exception;

    SystemProxyStatus getSystemProxyStatus() throws Exception;

    void serviceReload() throws Exception;

    void serviceStop() throws Exception;

    void setSystemProxyEnabled(boolean enabled) throws Exception;

    void triggerNativeCrash() throws Exception;

    void writeDebugMessage(String message);
}
