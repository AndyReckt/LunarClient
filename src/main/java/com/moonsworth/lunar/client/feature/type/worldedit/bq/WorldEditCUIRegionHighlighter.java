package com.moonsworth.lunar.client.feature.type.worldedit.bq;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.type.worldedit.WorldEditCUIMod;
import com.moonsworth.lunar.client.feature.type.worldedit.bp.WorldEditActionEventInterface;
import com.moonsworth.lunar.client.feature.type.worldedit.br.IlllIIIIIIlllIlIIlllIlIIl;
import com.moonsworth.lunar.client.ref.Ref;

public final class WorldEditCUIRegionHighlighter implements IWorldEditCUIHighlighter {
    public void lIlIlIlIlIIlIIlIIllIIIIIl(WorldEditCUIMod var1, float var2) {
        WorldEditActionEventInterface var3 = var1.IlIllIIlIIlIIIllIllllIIll().IlllIIIIIIlllIlIIlllIlIIl();
        EntityPlayerSPBridge var4 = Ref.getPlayer();
        com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl var5 = this.lIlIlIlIlIIlIIlIIllIIIIIl(var2);
        if (var3 instanceof com.moonsworth.lunar.client.feature.type.worldedit.bp.llllIIlIIlIIlIIllIIlIIllI) {
            com.moonsworth.lunar.client.feature.type.worldedit.bp.llllIIlIIlIIlIIllIIlIIllI var6 = (com.moonsworth.lunar.client.feature.type.worldedit.bp.llllIIlIIlIIlIIllIIlIIllI)var3;
            int var7 = var6.lIlIlIlIlIIlIIlIIllIIIIIl().size();
            if (var7 >= 2) {
                com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl var8 = var6.lIlIlIlIlIIlIIlIIllIIIIIl().get(0);
                com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl var9 = var6.lIlIlIlIlIIlIIlIIllIIIIIl().get(1);
                com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl var10 = IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var8, var9);
                com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl var11 = IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(var8, var9);
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$highlightRegion(-var5.lIlIlIlIlIIlIIlIIllIIIIIl, -var5.IlllIIIIIIlllIlIIlllIlIIl, -var5.lIllIlIIIlIIIIIIIlllIlIll, var10.lIlIlIlIlIIlIIlIIllIIIIIl, var10.IlllIIIIIIlllIlIIlllIlIIl, var10.lIllIlIIIlIIIIIIIlllIlIll, var11.lIlIlIlIlIIlIIlIIllIIIIIl, var11.IlllIIIIIIlllIlIIlllIlIIl, var11.lIllIlIIIlIIIIIIIlllIlIll, var1.IlIIlIIlIIlIIllIIIllIIllI().lIlIlIlIlIIlIIlIIllIIIIIl(0.0F));
            }
        }

    }
}