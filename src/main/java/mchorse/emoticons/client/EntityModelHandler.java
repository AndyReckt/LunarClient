/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  lunar.G.EntityBridge
 *  lunar.G.EntityLivingBaseBridge
 *  lunar.L.EntityPlayerBridge
 *  lunar.a.Bridge
 *  lunar.aH.PreRenderPlayerEvent
 */
package mchorse.emoticons.client;

import lunar.G.EntityBridge;
import lunar.G.EntityLivingBaseBridge;
import lunar.L.EntityPlayerBridge;
import lunar.a.Bridge;
import lunar.aH.PreRenderPlayerEvent;
import mchorse.emoticons.capabilities.cosmetic.Cosmetic;
import mchorse.emoticons.capabilities.cosmetic.ICosmetic;

public class EntityModelHandler {
    public void onRenderPlayer(PreRenderPlayerEvent preRenderPlayerEvent) {
        EntityPlayerBridge entityPlayerBridge = preRenderPlayerEvent.lIlIlIlIlIIlIIlIIllIIIIIl();
        if (entityPlayerBridge.bridge$isSpectator() || entityPlayerBridge.bridge$isInvisible()) {
            return;
        }
        ICosmetic iCosmetic = Cosmetic.get((EntityBridge)entityPlayerBridge);
        if (iCosmetic != null && iCosmetic.getEmote() != null) {
            if (Bridge.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIlIlIIlIIlIIllIIIIIl()) {
                preRenderPlayerEvent.setCancelled(true);
                preRenderPlayerEvent.lIlIlIlIlIIlIIlIIllIIIIIl(iCosmetic.render((EntityLivingBaseBridge)preRenderPlayerEvent.lIlIlIlIlIIlIIlIIllIIIIIl(), preRenderPlayerEvent.llIIIIIIIllIIllIlIllIIIIl(), preRenderPlayerEvent.IlllIIIIIIlllIlIIlllIlIIl(), preRenderPlayerEvent.lIllIlIIIlIIIIIIIlllIlIll(), preRenderPlayerEvent.llIlllIIIllllIIlllIllIIIl(), preRenderPlayerEvent.llllIIlIIlIIlIIllIIlIIllI(), preRenderPlayerEvent.IlIlIlllllIlIIlIlIlllIlIl()));
            } else {
                preRenderPlayerEvent.setCancelled(iCosmetic.render((EntityLivingBaseBridge)entityPlayerBridge, preRenderPlayerEvent.IlllIIIIIIlllIlIIlllIlIIl(), preRenderPlayerEvent.lIllIlIIIlIIIIIIIlllIlIll(), preRenderPlayerEvent.llIlllIIIllllIIlllIllIIIl(), preRenderPlayerEvent.llllIIlIIlIIlIIllIIlIIllI()));
            }
        }
    }
}

