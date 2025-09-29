package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface OpenConnectStatusHandler {
    void onError(String message);

    void onStatusUpdate(OpenConnectStatusUpdate status);
}
