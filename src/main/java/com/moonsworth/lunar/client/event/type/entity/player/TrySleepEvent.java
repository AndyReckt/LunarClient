package com.moonsworth.lunar.client.event.type.entity.player;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.BlockPosBridge;

public class TrySleepEvent
    extends PlayerEvent {
    public Result lIlIlIlIlIIlIIlIIllIIIIIl;
    public final BlockPosBridge IlllIIIIIIlllIlIIlllIlIIl;

    public TrySleepEvent(EntityPlayerBridge entityPlayerBridge, BlockPosBridge blockPosBridge) {
        super(entityPlayerBridge);
        this.IlllIIIIIIlllIlIIlllIlIIl = blockPosBridge;
    }

    public Result IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public BlockPosBridge lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Result result) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = result;
    }

    public enum Result {
        OK,
        NOT_POSSIBLE_HERE,
        NOT_POSSIBLE_NOW,
        TOO_FAR_AWAY,
        OTHER_PROBLEM,
        NOT_SAFE

    }
}