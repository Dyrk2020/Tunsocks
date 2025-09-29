package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface LogIterator {
    boolean hasNext();

    int len();

    LogEntry next();
}
