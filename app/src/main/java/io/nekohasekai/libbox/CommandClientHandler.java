package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface CommandClientHandler {
    void clearLogs();

    void connected();

    void disconnected(String message);

    void initializeClashMode(StringIterator modeList, String currentMode);

    void setDefaultLogLevel(int level);

    void updateClashMode(String newMode);

    void writeConnectionEvents(ConnectionEvents events);

    void writeGroups(OutboundGroupIterator message);

    void writeLogs(LogIterator messageList);

    void writeOutbounds(OutboundGroupItemIterator message);

    void writeStatus(StatusMessage message);
}
