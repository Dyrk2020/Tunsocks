package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class CommandServer implements Seq.Proxy {
    public final int refnum;

    private static native int __NewCommandServer(CommandServerHandler handler, PlatformInterface platformInterface);

    public native void checkConfig(String configContent) throws Exception;

    public native void close();

    public native void closeService() throws Exception;

    public native String formatConfig(String configContent) throws Exception;

    public native boolean needFindProcess();

    public native boolean needWIFIState();

    public native void pause();

    public native void resetNetwork();

    public native void setError(String message);

    public native void start() throws Exception;

    public native void startOrReloadService(String configContent, OverrideOptions options) throws Exception;

    public native void updateWIFIState();

    public native void wake();

    public native void writeMessage(int level, String message);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public CommandServer(CommandServerHandler handler, PlatformInterface platformInterface) {
        this.refnum = __NewCommandServer(handler, platformInterface);
        Seq.trackGoRef(this.refnum, this);
    }

    CommandServer(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof CommandServer)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("CommandServer").append("{");
        return b.append("}").toString();
    }
}
