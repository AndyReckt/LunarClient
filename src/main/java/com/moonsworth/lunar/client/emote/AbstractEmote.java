package com.moonsworth.lunar.client.emote;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.ease.AbstractEase;

public abstract class AbstractEmote implements com.moonsworth.lunar.client.cosmetic.iface.IlllIIIIIIlllIlIIlllIlIIl, IEmote {
    public final String lIlIlIlIlIIlIIlIIllIIIIIl;
    public final AbstractEase IlllIIIIIIlllIlIIlllIlIIl;
    public final int lIllIlIIIlIIIIIIIlllIlIll;
    public ResourceLocationBridge llIlllIIIllllIIlllIllIIIl;

    public AbstractEmote(int n, String string, AbstractEase abstractEase) {
        this.lIllIlIIIlIIIIIIIlllIlIll = n;
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.IlllIIIIIIlllIlIIlllIlIIl = abstractEase;
        if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
            this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll();
        }
        try {
            this.llIlllIIIllllIIlllIllIIIl = Bridge.getInstance().initResourceLocation("lunar", "emote/" + n + ".png");
        } catch (Exception exception) {
            exception.printStackTrace();
            this.llIlllIIIllllIIlllIllIIIl = null;
        }
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl.toLowerCase().replace(" ", "_");
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl.IlIlIlllllIlIIlIlIlllIlIl();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerBridge entityPlayerBridge) {
        if (entityPlayerBridge == null) {
            return;
        }
        if (entityPlayerBridge == Ref.getPlayer() && LunarClient.getInstance().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl) {
            if (!Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlIIlIIlIIlIIllIIIllIIllI()) {
                Ref.getMinecraft().bridge$getGameSettings().bridge$setThirdPersonView(0);
            }
            LunarClient.getInstance().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl = false;
        }
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    public String llIlllIIIllllIIlllIllIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public AbstractEase llllIIlIIlIIlIIllIIlIIllI() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public int IlIlIlllllIlIIlIlIlllIlIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public ResourceLocationBridge llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }
}
