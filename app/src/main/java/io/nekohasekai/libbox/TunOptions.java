package io.nekohasekai.libbox;

/* JADX INFO: loaded from: classes4.dex */
public interface TunOptions {
    boolean getAutoRoute();

    StringBox getDNSMode();

    StringIterator getDNSServerAddress() throws Exception;

    StringIterator getExcludePackage();

    StringIterator getHTTPProxyBypassDomain();

    StringIterator getHTTPProxyMatchDomain();

    String getHTTPProxyServer();

    int getHTTPProxyServerPort();

    StringIterator getIncludePackage();

    RoutePrefixIterator getInet4Address();

    RoutePrefixIterator getInet4RouteAddress();

    RoutePrefixIterator getInet4RouteExcludeAddress();

    RoutePrefixIterator getInet4RouteRange();

    RoutePrefixIterator getInet6Address();

    RoutePrefixIterator getInet6RouteAddress();

    RoutePrefixIterator getInet6RouteExcludeAddress();

    RoutePrefixIterator getInet6RouteRange();

    int getMTU();

    boolean getStrictRoute();

    boolean isHTTPProxyEnabled();
}
