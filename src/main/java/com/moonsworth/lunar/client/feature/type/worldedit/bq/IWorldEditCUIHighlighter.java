package com.moonsworth.lunar.client.feature.type.worldedit.bq;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.client.feature.type.worldedit.WorldEditCUIMod;
import com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl;
import com.moonsworth.lunar.client.ref.Ref;

public interface IWorldEditCUIHighlighter {
    void lIlIlIlIlIIlIIlIIllIIIIIl(WorldEditCUIMod var1, float var2);

default lIlIlIlIlIIlIIlIIllIIIIIl lIlIlIlIlIIlIIlIIllIIIIIl(float var1) {
        EntityPlayerSPBridge var2 = Ref.getPlayer();
        return new lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getRenderManager().getRenderPosX(), Ref.getRenderManager().getRenderPosY(), Ref.getRenderManager().getRenderPosZ());
    }

default double lIlIlIlIlIIlIIlIIllIIIIIl(double var1, double var3) {
        return var1 <= -0.0D ? var1 - var3 : var1 + var3;
    }
}
