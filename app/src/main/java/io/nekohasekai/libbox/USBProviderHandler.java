package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface USBProviderHandler {
    void onAbort(String deviceID, int endpoint);

    void onError(String deviceID, String message);

    void onReady(String deviceID, String busID);

    void onURBRequest(USBURBRequest request);
}
