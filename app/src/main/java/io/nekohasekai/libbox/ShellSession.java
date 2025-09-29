package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface ShellSession {
    void close() throws Exception;

    int masterFD();

    void resize(int rows, int cols) throws Exception;

    void signal(int signal) throws Exception;

    int waitExit() throws Exception;
}
