package mchorse.emoticons.client;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.entity.player.PreRenderPlayerEvent;
import mchorse.emoticons.capabilities.cosmetic.Cosmetic;
import mchorse.emoticons.capabilities.cosmetic.ICosmetic;

public class EntityModelHandler {
    public void onRenderPlayer(PreRenderPlayerEvent preRenderPlayerEvent) {
        EntityPlayerBridge entityPlayerBridge = preRenderPlayerEvent.lIlIlIlIlIIlIIlIIllIIIIIl();
        if (entityPlayerBridge.bridge$isSpectator() || entityPlayerBridge.bridge$isInvisible()) {
            return;
        }
        ICosmetic iCosmetic = Cosmetic.get(entityPlayerBridge);
        if (iCosmetic != null && iCosmetic.getEmote() != null) {
            if (Bridge.getMinecraftVersion().lIlIlIlIlIIlIIlIIllIIIIIl()) {
                preRenderPlayerEvent.setCancelled(true);
                preRenderPlayerEvent.lIlIlIlIlIIlIIlIIllIIIIIl(iCosmetic.render(preRenderPlayerEvent.lIlIlIlIlIIlIIlIIllIIIIIl(), preRenderPlayerEvent.llIIIIIIIllIIllIlIllIIIIl(), preRenderPlayerEvent.IlllIIIIIIlllIlIIlllIlIIl(), preRenderPlayerEvent.lIllIlIIIlIIIIIIIlllIlIll(), preRenderPlayerEvent.llIlllIIIllllIIlllIllIIIl(), preRenderPlayerEvent.llllIIlIIlIIlIIllIIlIIllI(), preRenderPlayerEvent.IlIlIlllllIlIIlIlIlllIlIl()));
            } else {
                preRenderPlayerEvent.setCancelled(iCosmetic.render(entityPlayerBridge, preRenderPlayerEvent.IlllIIIIIIlllIlIIlllIlIIl(), preRenderPlayerEvent.lIllIlIIIlIIIIIIIlllIlIll(), preRenderPlayerEvent.llIlllIIIllllIIlllIllIIIl(), preRenderPlayerEvent.llllIIlIIlIIlIIllIIlIIllI()));
            }
        }
    }
}

