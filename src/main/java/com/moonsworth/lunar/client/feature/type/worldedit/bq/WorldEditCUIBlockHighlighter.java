package com.moonsworth.lunar.client.feature.type.worldedit.bq;

import com.moonsworth.lunar.bridge.lunar.GeometryTessellator;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.type.worldedit.WorldEditCUIMod;
import com.moonsworth.lunar.client.setting.ColorSetting;

import java.util.Iterator;

public final class WorldEditCUIBlockHighlighter implements IWorldEditCUIHighlighter {
    public void lIlIlIlIlIIlIIlIIllIIIIIl(WorldEditCUIMod var1, float var2) {
        if (var1.IlIllIIlIIlIIIllIllllIIll().IlllIIIIIIlllIlIIlllIlIIl() != null && var1.IlIllIIlIIlIIIllIllllIIll().IlllIIIIIIlllIlIIlllIlIIl() instanceof com.moonsworth.lunar.client.feature.type.worldedit.bp.lIlIlIlIlIIlIIlIIllIIIIIl) {
            com.moonsworth.lunar.client.feature.type.worldedit.bp.lIlIlIlIlIIlIIlIIllIIIIIl var3 = (com.moonsworth.lunar.client.feature.type.worldedit.bp.lIlIlIlIlIIlIIlIIllIIIIIl)var1.IlIllIIlIIlIIIllIllllIIll().IlllIIIIIIlllIlIIlllIlIIl();
            com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl var4 = this.lIlIlIlIlIIlIIlIIllIIIIIl(var2);
            GeometryTessellator var5 = Bridge.getInstance().getGeometryTessellator();
            if (var5 == null) {
                return;
            }

            if (var5.bridge$isDrawing()) {
                return;
            }

            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            var5.lIlIlIlIlIIlIIlIIllIIIIIl();
            int var6 = 0;
            Iterator<com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl> var7 = var3.lIlIlIlIlIIlIIlIIllIIIIIl().iterator();

            while(var7.hasNext()) {
                com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl var8 = var7.next();
                ColorSetting var9 = var6++ % 2 == 0 ? var1.lIlIlIIIIIIllIlIIIIllIIII() : var1.lIIlIIIIIIlIIlIIllIlIIlII();
                int var10 = var9.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F);
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$highlightBlock(-var4.lIlIlIlIlIIlIIlIIllIIIIIl, -var4.IlllIIIIIIlllIlIIlllIlIIl, -var4.lIllIlIIIlIIIIIIIlllIlIll, var8.lIlIlIlIlIIlIIlIIllIIIIIl, var8.IlllIIIIIIlllIlIIlllIlIIl, var8.lIllIlIIIlIIIIIIIlllIlIll, var10);
            }

            var5.bridge$draw();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        }

    }
}