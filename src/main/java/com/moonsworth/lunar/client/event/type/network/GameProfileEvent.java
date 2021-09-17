package com.moonsworth.lunar.client.event.type.network;

import com.mojang.authlib.GameProfile;
import com.moonsworth.lunar.client.event.Event;

public class GameProfileEvent
extends Event {
    public final GameProfile lIlIlIlIlIIlIIlIIllIIIIIl;

    public GameProfile lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public GameProfileEvent(GameProfile gameProfile) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = gameProfile;
    }

    public static class IlllIIIIIIlllIlIIlllIlIIl
    extends GameProfileEvent {
        public IlllIIIIIIlllIlIIlllIlIIl(GameProfile gameProfile) {
            super(gameProfile);
        }
    }

    public static class lIlIlIlIlIIlIIlIIllIIIIIl
    extends GameProfileEvent {
        public lIlIlIlIlIIlIIlIIllIIIIIl(GameProfile gameProfile) {
            super(gameProfile);
        }
    }
}
 