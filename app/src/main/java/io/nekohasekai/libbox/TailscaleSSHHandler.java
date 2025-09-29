package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface TailscaleSSHHandler {
    void onAuthBanner(String message);

    void onError(String message);

    void onExit(int exitCode, String signal, String errorMessage);

    void onOutput(byte[] data);

    void onReady();
}
