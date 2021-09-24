/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  lunar.G.EntityBridge
 *  lunar.G.EntityLivingBaseBridge
 *  lunar.L.EntityPlayerBridge
 */
package mchorse.emoticons.common;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import mchorse.emoticons.capabilities.cosmetic.Cosmetic;
import mchorse.emoticons.capabilities.cosmetic.ICosmetic;
import mchorse.emoticons.common.emotes.Emote;
import mchorse.emoticons.common.emotes.Emotes;

public class EmoteAPI {
    public static void setEmoteClient(String string, EntityPlayerBridge entityPlayerBridge) {
        ICosmetic iCosmetic = Cosmetic.get(entityPlayerBridge);
        if (iCosmetic == null) {
            return;
        }
        Emote emote = Emotes.get(string);
        ICosmetic.CosmeticMode cosmeticMode = iCosmetic.getMode();
        if (cosmeticMode == ICosmetic.CosmeticMode.CLIENT || emote == null) {
            iCosmetic.setEmote(emote, entityPlayerBridge);
        }
    }
}

