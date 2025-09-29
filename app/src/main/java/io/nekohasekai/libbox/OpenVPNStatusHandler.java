package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface OpenVPNStatusHandler {
    void onError(String message);

    void onStatusUpdate(OpenVPNStatusUpdate status);
}
