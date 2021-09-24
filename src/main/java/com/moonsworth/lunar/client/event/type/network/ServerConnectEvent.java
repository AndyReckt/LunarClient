package com.moonsworth.lunar.client.event.type.network;

import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.ServerDataBridge;
import com.moonsworth.lunar.client.event.Event;
import com.moonsworth.lunar.client.ref.Ref;

public class ServerConnectEvent
    extends Event {
    public final ServerDataBridge lIlIlIlIlIIlIIlIIllIIIIIl = Ref.getMinecraft().bridge$getCurrentServerData();
    public final String IlllIIIIIIlllIlIIlllIlIIl;
    public final int lIllIlIIIlIIIIIIIlllIlIll;

    public ServerDataBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public int lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public ServerConnectEvent(String string, int n) {
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
        this.lIllIlIIIlIIIIIIIlllIlIll = n;
    }
}
