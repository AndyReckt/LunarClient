/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  lunar.G.EntityLivingBaseBridge
 *  lunar.c.MatrixStackBridge
 *  lunar.de.lIllIlIIIlIIIIIIIlllIlIll
 */
package mchorse.emoticons.capabilities.cosmetic;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.client.cosmetic.de.lIllIlIIIlIIIIIIIlllIlIll;
import mchorse.emoticons.common.emotes.Emote;

public interface ICosmetic {
    CosmeticMode getMode();

    void setMode(CosmeticMode var1);

    void setEmote(Emote var1, EntityLivingBaseBridge var2);

    Emote getEmote();

    boolean shouldRender(EntityLivingBaseBridge var1);

    void update(EntityLivingBaseBridge var1);

    boolean render(EntityLivingBaseBridge var1, double var2, double var4, double var6, float var8);

    lIllIlIIIlIIIIIIIlllIlIll render(EntityLivingBaseBridge var1, MatrixStackBridge var2, double var3, double var5, double var7, float var9, int var10);

    enum CosmeticMode {
        CLIENT,
        PLUGIN,
        SERVER

    }
}

