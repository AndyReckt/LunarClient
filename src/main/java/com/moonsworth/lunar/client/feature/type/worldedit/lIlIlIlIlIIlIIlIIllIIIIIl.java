package com.moonsworth.lunar.client.feature.type.worldedit;

import com.moonsworth.lunar.client.event.Event;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.network.WorldEditActionEvent;
import com.moonsworth.lunar.client.feature.type.worldedit.bp.WorldEditActionEventInterface;
import com.moonsworth.lunar.client.feature.type.worldedit.bp.llllIIlIIlIIlIIllIIlIIllI;

public final class lIlIlIlIlIIlIIlIIllIIIIIl {
    public IlllIIIIIIlllIlIIlllIlIIl lIlIlIlIlIIlIIlIIllIIIIIl;
    public WorldEditActionEventInterface worldEditActionEventInterface;

    public lIlIlIlIlIIlIIlIIllIIIIIl() {
        // IlllIIIIIIlllIlIIlllIlIIl
        this.lIlIlIlIlIIlIIlIIllIIIIIl = IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl;
        this.worldEditActionEventInterface = new llllIIlIIlIIlIIllIIlIIllI();
    }

    public IlllIIIIIIlllIlIIlllIlIIl lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public WorldEditActionEventInterface IlllIIIIIIlllIlIIlllIlIIl() {
        return this.worldEditActionEventInterface;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1) {
        String[] var2 = var1.split("\\|");
        if (var2[0].equalsIgnoreCase("s")) {
            this.worldEditActionEventInterface = (this.lIlIlIlIlIIlIIlIIllIIIIIl = IlllIIIIIIlllIlIIlllIlIIl.valueOf(var2[1].toUpperCase())).lIlIlIlIlIIlIIlIIllIIIIIl();
            EventBus.getInstance().call((Event)(new WorldEditActionEvent(this.worldEditActionEventInterface)));
        } else if (var2[0].equalsIgnoreCase("p")) {
            this.worldEditActionEventInterface.lIlIlIlIlIIlIIlIIllIIIIIl(Integer.parseInt(var2[1]), Double.parseDouble(var2[2]), Double.parseDouble(var2[3]), Double.parseDouble(var2[4]));
            if (this.worldEditActionEventInterface instanceof com.moonsworth.lunar.client.feature.type.worldedit.bp.IlllIIIIIIlllIlIIlllIlIIl) {
                ((com.moonsworth.lunar.client.feature.type.worldedit.bp.IlllIIIIIIlllIlIIlllIlIIl)this.worldEditActionEventInterface).lIlIlIlIlIIlIIlIIllIIIIIl(Integer.parseInt(var2[5]));
            }

            EventBus.getInstance().call((Event)(new WorldEditActionEvent(this.worldEditActionEventInterface)));
        }

    }
}