package com.moonsworth.lunar.client.event.type.world;

import com.moonsworth.lunar.bridge.minecraft.world.chunk.ChunkBridge;
import com.moonsworth.lunar.client.event.Event;

public class ChunkEvent
extends Event {
    public ChunkBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public ChunkEvent(ChunkBridge chunkBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = chunkBridge;
    }

    public ChunkBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public static class ChunkLoadEvent
    extends ChunkEvent {
        public ChunkLoadEvent(ChunkBridge chunkBridge) {
            super(chunkBridge);
        }
    }
}