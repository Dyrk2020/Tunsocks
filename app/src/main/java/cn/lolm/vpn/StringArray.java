package cn.lolm.vpn;

import io.nekohasekai.libbox.StringIterator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: PlatformInterfaceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0004H\u0096\u0002J\t\u0010\f\u001a\u00020\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcn/lolm/vpn/StringArray;", "Lio/nekohasekai/libbox/StringIterator;", "iterator", "", "", "<init>", "(Ljava/util/Iterator;)V", "items", "", "pos", "", "next", "hasNext", "", "len", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class StringArray implements StringIterator {
    private final List<String> items;
    private final Iterator<String> iterator;
    private int pos;

    public StringArray(Iterator<String> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        this.iterator = iterator;
        this.items = SequencesKt.toList(SequencesKt.asSequence(this.iterator));
    }

    @Override // io.nekohasekai.libbox.StringIterator
    public String next() {
        List<String> list = this.items;
        int i = this.pos;
        this.pos = i + 1;
        return list.get(i);
    }

    @Override // io.nekohasekai.libbox.StringIterator
    public boolean hasNext() {
        return this.pos < this.items.size();
    }

    @Override // io.nekohasekai.libbox.StringIterator
    public int len() {
        return this.items.size();
    }
}
