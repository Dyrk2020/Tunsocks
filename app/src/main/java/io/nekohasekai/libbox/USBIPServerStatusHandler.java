package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface USBIPServerStatusHandler {
    void onError(String message);

    void onStatusUpdate(USBIPServerStatusUpdate status);
}
