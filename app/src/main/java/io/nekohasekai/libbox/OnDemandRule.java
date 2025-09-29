package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface OnDemandRule {
    StringIterator dnsSearchDomainMatch();

    StringIterator dnsServerAddressMatch();

    int interfaceTypeMatch();

    String probeURL();

    StringIterator ssidMatch();

    int target();
}
