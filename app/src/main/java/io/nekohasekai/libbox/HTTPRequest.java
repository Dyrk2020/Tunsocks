package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface HTTPRequest {
    HTTPResponse execute() throws Exception;

    void randomUserAgent();

    void setContent(byte[] content);

    void setContentString(String content);

    void setHeader(String key, String value);

    void setMethod(String method);

    void setURL(String link) throws Exception;

    void setUserAgent(String userAgent);
}
