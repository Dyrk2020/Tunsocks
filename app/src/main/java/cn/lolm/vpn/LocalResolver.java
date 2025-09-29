package cn.lolm.vpn;

import android.net.DnsResolver;
import android.net.Network;
import android.os.Build;
import android.os.CancellationSignal;
import android.util.Log;
import io.nekohasekai.libbox.ExchangeContext;
import io.nekohasekai.libbox.Func;
import io.nekohasekai.libbox.LocalDNSTransport;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: LocalResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J \u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcn/lolm/vpn/LocalResolver;", "Lio/nekohasekai/libbox/LocalDNSTransport;", "<init>", "()V", "TAG", "", "raw", "", "exchange", "", "ctx", "Lio/nekohasekai/libbox/ExchangeContext;", "message", "", "lookup", "network", "domain", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocalResolver implements LocalDNSTransport {
    public static final int $stable = 0;
    public static final LocalResolver INSTANCE = new LocalResolver();
    private static final String TAG = "LoLMDNS";

    private LocalResolver() {
    }

    @Override // io.nekohasekai.libbox.LocalDNSTransport
    public boolean raw() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // io.nekohasekai.libbox.LocalDNSTransport
    public void exchange(ExchangeContext ctx, byte[] message) throws InterruptedException {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(message, "message");
        Network network = DefaultNetworkMonitor.INSTANCE.currentDefaultNetwork();
        if (network != null) {
            BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(ctx, network, message, null), 1, null);
        } else {
            ctx.errorCode(DnsResponseCodes.INSTANCE.forResolverFailure());
            Log.w(TAG, "exchange: no default network");
        }
    }

    /* JADX INFO: renamed from: cn.lolm.vpn.LocalResolver$exchange$1, reason: invalid class name */
    /* JADX INFO: compiled from: LocalResolver.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "cn.lolm.vpn.LocalResolver$exchange$1", f = "LocalResolver.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExchangeContext $ctx;
        final /* synthetic */ byte[] $message;
        final /* synthetic */ Network $network;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ExchangeContext exchangeContext, Network network, byte[] bArr, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$ctx = exchangeContext;
            this.$network = network;
            this.$message = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$ctx, this.$network, this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final ExchangeContext exchangeContext = this.$ctx;
                    Network network = this.$network;
                    byte[] bArr = this.$message;
                    this.L$0 = exchangeContext;
                    this.L$1 = network;
                    this.L$2 = bArr;
                    this.label = 1;
                    SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(this));
                    final SafeContinuation cont = safeContinuation;
                    final CancellationSignal signal = new CancellationSignal();
                    exchangeContext.onCancel(new Func() { // from class: cn.lolm.vpn.LocalResolver$exchange$1$1$1
                        @Override // io.nekohasekai.libbox.Func
                        public final void invoke() {
                            signal.cancel();
                        }
                    });
                    DnsResolver.getInstance().rawQuery(network, bArr, 1, ExecutorsKt.asExecutor(Dispatchers.getIO()), signal, (DnsResolver.Callback) new DnsResolver.Callback<byte[]>() { // from class: cn.lolm.vpn.LocalResolver$exchange$1$1$2
                        @Override // android.net.DnsResolver.Callback
                        public void onAnswer(byte[] answer, int rcode) {
                            Intrinsics.checkNotNullParameter(answer, "answer");
                            if (rcode == 0) {
                                exchangeContext.rawSuccess(answer);
                            } else {
                                exchangeContext.errorCode(rcode);
                            }
                            Continuation<Unit> continuation = cont;
                            Result.Companion companion = Result.INSTANCE;
                            continuation.resumeWith(Result.m6606constructorimpl(Unit.INSTANCE));
                        }

                        @Override // android.net.DnsResolver.Callback
                        public void onError(DnsResolver.DnsException error) {
                            Intrinsics.checkNotNullParameter(error, "error");
                            exchangeContext.errorCode(DnsResponseCodes.INSTANCE.forResolverFailure());
                            Log.w("LoLMDNS", "exchange error: " + error.getMessage());
                            Continuation<Unit> continuation = cont;
                            Result.Companion companion = Result.INSTANCE;
                            continuation.resumeWith(Result.m6606constructorimpl(Unit.INSTANCE));
                        }
                    });
                    Object orThrow = safeContinuation.getOrThrow();
                    if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(this);
                    }
                    if (orThrow == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Override // io.nekohasekai.libbox.LocalDNSTransport
    public void lookup(ExchangeContext ctx, String network, String domain) throws InterruptedException {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Network defaultNetwork = DefaultNetworkMonitor.INSTANCE.currentDefaultNetwork();
        if (defaultNetwork != null) {
            BuildersKt__BuildersKt.runBlocking$default(null, new C05661(defaultNetwork, domain, ctx, null), 1, null);
        } else {
            ctx.errorCode(DnsResponseCodes.INSTANCE.forResolverFailure());
            Log.w(TAG, "lookup: no default network");
        }
    }

    /* JADX INFO: renamed from: cn.lolm.vpn.LocalResolver$lookup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalResolver.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "cn.lolm.vpn.LocalResolver$lookup$1", f = "LocalResolver.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    static final class C05661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExchangeContext $ctx;
        final /* synthetic */ Network $defaultNetwork;
        final /* synthetic */ String $domain;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05661(Network network, String str, ExchangeContext exchangeContext, Continuation<? super C05661> continuation) {
            super(2, continuation);
            this.$defaultNetwork = network;
            this.$domain = str;
            this.$ctx = exchangeContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05661(this.$defaultNetwork, this.$domain, this.$ctx, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (Build.VERSION.SDK_INT >= 29) {
                        final ExchangeContext exchangeContext = this.$ctx;
                        Network network = this.$defaultNetwork;
                        String str = this.$domain;
                        this.L$0 = exchangeContext;
                        this.L$1 = network;
                        this.L$2 = str;
                        this.label = 1;
                        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(this));
                        final SafeContinuation cont = safeContinuation;
                        final CancellationSignal signal = new CancellationSignal();
                        exchangeContext.onCancel(new Func() { // from class: cn.lolm.vpn.LocalResolver$lookup$1$1$1
                            @Override // io.nekohasekai.libbox.Func
                            public final void invoke() {
                                signal.cancel();
                            }
                        });
                        DnsResolver.getInstance().query(network, str, 1, ExecutorsKt.asExecutor(Dispatchers.getIO()), signal, new DnsResolver.Callback<Collection<? extends InetAddress>>() { // from class: cn.lolm.vpn.LocalResolver$lookup$1$1$2
                            @Override // android.net.DnsResolver.Callback
                            public void onAnswer(Collection<? extends InetAddress> answer, int rcode) {
                                Intrinsics.checkNotNullParameter(answer, "answer");
                                exchangeContext.success(CollectionsKt.joinToString$default(answer, "\n", null, null, 0, null, new Function1<InetAddress, CharSequence>() { // from class: cn.lolm.vpn.LocalResolver$lookup$1$1$2$onAnswer$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final CharSequence invoke(InetAddress it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        String hostAddress = it.getHostAddress();
                                        Intrinsics.checkNotNullExpressionValue(hostAddress, "getHostAddress(...)");
                                        return hostAddress;
                                    }
                                }, 30, null));
                                Continuation<Unit> continuation = cont;
                                Result.Companion companion = Result.INSTANCE;
                                continuation.resumeWith(Result.m6606constructorimpl(Unit.INSTANCE));
                            }

                            @Override // android.net.DnsResolver.Callback
                            public void onError(DnsResolver.DnsException error) {
                                Intrinsics.checkNotNullParameter(error, "error");
                                exchangeContext.errorCode(DnsResponseCodes.INSTANCE.forResolverFailure());
                                Log.w("LoLMDNS", "lookup error: " + error.getMessage());
                                Continuation<Unit> continuation = cont;
                                Result.Companion companion = Result.INSTANCE;
                                continuation.resumeWith(Result.m6606constructorimpl(Unit.INSTANCE));
                            }
                        });
                        Object orThrow = safeContinuation.getOrThrow();
                        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(this);
                        }
                        if (orThrow == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        try {
                            InetAddress[] answer = this.$defaultNetwork.getAllByName(this.$domain);
                            ExchangeContext exchangeContext2 = this.$ctx;
                            Intrinsics.checkNotNull(answer);
                            Collection destination$iv$iv = new ArrayList();
                            for (InetAddress inetAddress : answer) {
                                String hostAddress = inetAddress.getHostAddress();
                                if (hostAddress != null) {
                                    destination$iv$iv.add(hostAddress);
                                }
                            }
                            exchangeContext2.success(CollectionsKt.joinToString$default((List) destination$iv$iv, "\n", null, null, 0, null, null, 62, null));
                        } catch (UnknownHostException e) {
                            this.$ctx.errorCode(DnsResponseCodes.INSTANCE.forUnknownHost());
                            return Unit.INSTANCE;
                        }
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}
