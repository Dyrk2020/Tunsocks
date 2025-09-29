package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface HTTPResponse {
    StringBox getContent() throws Exception;

    void writeTo(String path) throws Exception;

    void writeToWithProgress(String path, HTTPResponseWriteToProgressHandler handler) throws Exception;
}
