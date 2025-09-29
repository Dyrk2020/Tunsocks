package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface STUNTestHandler {
    void onError(String message);

    void onProgress(STUNTestProgress progress);

    void onResult(STUNTestResult result);
}
