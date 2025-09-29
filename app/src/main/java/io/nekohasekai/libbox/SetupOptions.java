package io.nekohasekai.libbox;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class SetupOptions implements Seq.Proxy {
    public final int refnum;

    private static native int __New();

    public final native String getBasePath();

    public final native int getCommandServerListenPort();

    public final native String getCommandServerSecret();

    public final native String getCrashReportSource();

    public final native boolean getDebug();

    public final native boolean getFixAndroidStack();

    public final native long getLogMaxLines();

    public final native boolean getOomKillerDisabled();

    public final native boolean getOomKillerEnabled();

    public final native long getOomMemoryLimit();

    public final native String getTempPath();

    public final native String getWorkingPath();

    public final native void setBasePath(String v);

    public final native void setCommandServerListenPort(int v);

    public final native void setCommandServerSecret(String v);

    public final native void setCrashReportSource(String v);

    public final native void setDebug(boolean v);

    public final native void setFixAndroidStack(boolean v);

    public final native void setLogMaxLines(long v);

    public final native void setOomKillerDisabled(boolean v);

    public final native void setOomKillerEnabled(boolean v);

    public final native void setOomMemoryLimit(long v);

    public final native void setTempPath(String v);

    public final native void setWorkingPath(String v);

    static {
        Libbox.touch();
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    SetupOptions(int refnum) {
        this.refnum = refnum;
        Seq.trackGoRef(refnum, this);
    }

    public SetupOptions() {
        this.refnum = __New();
        Seq.trackGoRef(this.refnum, this);
    }

    public boolean equals(Object o) {
        if (o != null && (o instanceof SetupOptions)) {
            SetupOptions that = (SetupOptions) o;
            String thisBasePath = getBasePath();
            String thatBasePath = that.getBasePath();
            if (thisBasePath == null) {
                if (thatBasePath != null) {
                    return false;
                }
            } else if (!thisBasePath.equals(thatBasePath)) {
                return false;
            }
            String thisWorkingPath = getWorkingPath();
            String thatWorkingPath = that.getWorkingPath();
            if (thisWorkingPath == null) {
                if (thatWorkingPath != null) {
                    return false;
                }
            } else if (!thisWorkingPath.equals(thatWorkingPath)) {
                return false;
            }
            String thisTempPath = getTempPath();
            String thatTempPath = that.getTempPath();
            if (thisTempPath == null) {
                if (thatTempPath != null) {
                    return false;
                }
            } else if (!thisTempPath.equals(thatTempPath)) {
                return false;
            }
            boolean thisFixAndroidStack = getFixAndroidStack();
            boolean thatFixAndroidStack = that.getFixAndroidStack();
            if (thisFixAndroidStack != thatFixAndroidStack) {
                return false;
            }
            int thisCommandServerListenPort = getCommandServerListenPort();
            int thatCommandServerListenPort = that.getCommandServerListenPort();
            if (thisCommandServerListenPort != thatCommandServerListenPort) {
                return false;
            }
            String thisCommandServerSecret = getCommandServerSecret();
            String thatCommandServerSecret = that.getCommandServerSecret();
            if (thisCommandServerSecret == null) {
                if (thatCommandServerSecret != null) {
                    return false;
                }
            } else if (!thisCommandServerSecret.equals(thatCommandServerSecret)) {
                return false;
            }
            long thisLogMaxLines = getLogMaxLines();
            long thatLogMaxLines = that.getLogMaxLines();
            if (thisLogMaxLines != thatLogMaxLines) {
                return false;
            }
            boolean thisDebug = getDebug();
            boolean thatDebug = that.getDebug();
            if (thisDebug != thatDebug) {
                return false;
            }
            String thisCrashReportSource = getCrashReportSource();
            String thatCrashReportSource = that.getCrashReportSource();
            if (thisCrashReportSource == null) {
                if (thatCrashReportSource != null) {
                    return false;
                }
            } else if (!thisCrashReportSource.equals(thatCrashReportSource)) {
                return false;
            }
            boolean thisOomKillerEnabled = getOomKillerEnabled();
            boolean thatOomKillerEnabled = that.getOomKillerEnabled();
            if (thisOomKillerEnabled != thatOomKillerEnabled) {
                return false;
            }
            boolean thisOomKillerDisabled = getOomKillerDisabled();
            boolean thatOomKillerDisabled = that.getOomKillerDisabled();
            if (thisOomKillerDisabled != thatOomKillerDisabled) {
                return false;
            }
            long thisOomMemoryLimit = getOomMemoryLimit();
            long thatOomMemoryLimit = that.getOomMemoryLimit();
            if (thisOomMemoryLimit != thatOomMemoryLimit) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getBasePath(), getWorkingPath(), getTempPath(), Boolean.valueOf(getFixAndroidStack()), Integer.valueOf(getCommandServerListenPort()), getCommandServerSecret(), Long.valueOf(getLogMaxLines()), Boolean.valueOf(getDebug()), getCrashReportSource(), Boolean.valueOf(getOomKillerEnabled()), Boolean.valueOf(getOomKillerDisabled()), Long.valueOf(getOomMemoryLimit())});
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("SetupOptions").append("{");
        b.append("BasePath:").append(getBasePath()).append(",");
        b.append("WorkingPath:").append(getWorkingPath()).append(",");
        b.append("TempPath:").append(getTempPath()).append(",");
        b.append("FixAndroidStack:").append(getFixAndroidStack()).append(",");
        b.append("CommandServerListenPort:").append(getCommandServerListenPort()).append(",");
        b.append("CommandServerSecret:").append(getCommandServerSecret()).append(",");
        b.append("LogMaxLines:").append(getLogMaxLines()).append(",");
        b.append("Debug:").append(getDebug()).append(",");
        b.append("CrashReportSource:").append(getCrashReportSource()).append(",");
        b.append("OomKillerEnabled:").append(getOomKillerEnabled()).append(",");
        b.append("OomKillerDisabled:").append(getOomKillerDisabled()).append(",");
        b.append("OomMemoryLimit:").append(getOomMemoryLimit()).append(",");
        return b.append("}").toString();
    }
}
