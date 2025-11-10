# Tunsocks

Research archive of an Android VPN wrapper around [sing-box](https://github.com/SagerNet/sing-box) / `libbox`, rebuilt from the decompiled APK of `cn.lolm.vpn` (*LoLM VPN*). It documents how per-application traffic routing is implemented on Android: a tun inbound consuming packets from a `VpnService` TUN interface, a SOCKS5 outbound, and domain-based routing rules.

> Study material for network protocol / Android VPN internals. Not a general-purpose VPN client. Decompiled with JADX — Kotlin sources carry `JADX INFO` annotations and synthetic names; the `io.nekohasekai.libbox.*` and `go.*` layers are `gomobile bind` generated code.

## How the pieces fit

| Component | Role |
|---|---|
| `LolmVpnService` | Android `VpnService` — owns the TUN interface lifecycle |
| sing-box tun inbound | consumes packets from the TUN (gVisor stack, `auto_route`) |
| SOCKS5 outbound | forwards matching traffic to a user-supplied server |
| Route rules | steer selected domains through the proxy; everything else stays direct |
| `VpnStateMachine` / `DefaultNetworkMonitor` | connection state + network switching |

## Fixed configuration

The app ships one minimal sing-box config (`app/src/main/assets/lolm-config.example.json`):

- **Inbound:** `tun` with `stack: "gvisor"`, `auto_route: true`, `include_package: ["com.tencent.lolm"]` — only that package's traffic enters the tunnel
- **Outbounds:** one `socks5` (server/port/credentials from the UI) + `direct`
- **Route:** `sniff` → DNS hijack (port 53) → domain list (`ipecho.net`, `priv.igame.qq.com`, ...) → `proxy`; final = `direct`

## Source layout

```
app/src/main/java/cn/lolm/vpn/   application layer (recovered Kotlin, decompiled)
app/src/main/java/io/nekohasekai/libbox/   libbox facade (gomobile generated)
app/src/main/java/go/            gomobile runtime (go.Seq / go.Universe)
```

## Build

Standard Android Gradle project: open in Android Studio or `./gradlew assembleDebug` (Android SDK 34+, NDK not required — the Go runtime is prebuilt inside `libbox`).
