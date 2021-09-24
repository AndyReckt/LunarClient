package com.moonsworth.lunar.client.event.type.network;

import com.moonsworth.lunar.client.event.Event;
import com.moonsworth.lunar.client.feature.type.worldedit.bp.WorldEditActionEventInterface;

public class WorldEditActionEvent extends Event {
    public WorldEditActionEventInterface lIlIlIlIlIIlIIlIIllIIIIIl;

    public WorldEditActionEvent() {
    }

    public WorldEditActionEvent(WorldEditActionEventInterface worldEditActionEventInterface) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = worldEditActionEventInterface;
    }

    public WorldEditActionEventInterface lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
