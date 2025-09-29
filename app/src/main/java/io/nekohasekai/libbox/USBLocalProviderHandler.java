package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface USBLocalProviderHandler {
    void onDeviceError(String serverTag, String deviceID, String message);

    void onLocalDevicesChanged();

    void onSessionError(String serverTag, String message);
}
