package com.moonsworth.lunar.client.event.type.network;

import com.moonsworth.lunar.bridge.minecraft.client.network.NetworkManagerBridge;
import com.moonsworth.lunar.client.event.Event;
import io.netty.channel.Channel;

import javax.crypto.SecretKey;

public class EnableEncryptionEvent extends Event {
    public final NetworkManagerBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public final Channel IlllIIIIIIlllIlIIlllIlIIl;
    public final SecretKey lIllIlIIIlIIIIIIIlllIlIll;

    public NetworkManagerBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public Channel IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public SecretKey lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public EnableEncryptionEvent(NetworkManagerBridge networkManagerBridge, Channel channel, SecretKey secretKey) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = networkManagerBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = channel;
        this.lIllIlIIIlIIIIIIIlllIlIll = secretKey;
    }
}
