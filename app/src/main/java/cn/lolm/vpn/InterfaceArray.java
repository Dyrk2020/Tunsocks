package cn.lolm.vpn;

import io.nekohasekai.libbox.NetworkInterface;
import io.nekohasekai.libbox.NetworkInterfaceIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformInterfaceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0004H\u0096\u0002J\t\u0010\b\u001a\u00020\tH\u0096\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcn/lolm/vpn/InterfaceArray;", "Lio/nekohasekai/libbox/NetworkInterfaceIterator;", "iterator", "", "Lio/nekohasekai/libbox/NetworkInterface;", "<init>", "(Ljava/util/Iterator;)V", "next", "hasNext", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class InterfaceArray implements NetworkInterfaceIterator {
    private final Iterator<NetworkInterface> iterator;

    public InterfaceArray(Iterator<NetworkInterface> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        this.iterator = iterator;
    }

    @Override // io.nekohasekai.libbox.NetworkInterfaceIterator
    public NetworkInterface next() {
        return this.iterator.next();
    }

    @Override // io.nekohasekai.libbox.NetworkInterfaceIterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
}
