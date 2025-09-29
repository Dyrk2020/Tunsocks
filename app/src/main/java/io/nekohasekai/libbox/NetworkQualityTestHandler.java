package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface NetworkQualityTestHandler {
    void onError(String message);

    void onProgress(NetworkQualityProgress progress);

    void onResult(NetworkQualityResult result);
}
