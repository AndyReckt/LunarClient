package com.moonsworth.lunar.client.emote;

import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelBipedBridge;
import mchorse.emoticons.common.EmoteAPI;
import org.apache.commons.lang3.text.WordUtils;

public class Emote extends AbstractEmote {
    public final String lIllIlIIIlIIIIIIIlllIlIll;
    public boolean llIlllIIIllllIIlllIllIIIl = false;
    public boolean llllIIlIIlIIlIIllIIlIIllI = false;

    public Emote(int n, String string) {
        super(n, WordUtils.capitalizeFully(string.replace("_", " ")), null);
        this.lIllIlIIIlIIIIIIIlllIlIll = string;
    }

    @Override
    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(EntityPlayerBridge entityPlayerBridge) {
        if (this.llIlllIIIllllIIlllIllIIIl) {
            return;
        }
        EmoteAPI.setEmoteClient(this.lIlIlIlIlIIlIIlIIllIIIIIl(), entityPlayerBridge);
        this.llIlllIIIllllIIlllIllIIIl = true;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerBridge entityPlayerBridge) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(entityPlayerBridge);
        this.llllIIlIIlIIlIIllIIlIIllI = true;
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, ModelBipedBridge modelBipedBridge, float f) {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, float f) {
    }
}
