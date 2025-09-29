package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface TailscaleStatusHandler {
    void onError(String message);

    void onStatusUpdate(TailscaleStatusUpdate status);
}
