package com.moonsworth.lunar.client.bridge.impl.type.player;

import com.moonsworth.lunar.bridge.minecraft.entity.boss.BossStatusBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import net.minecraft.entity.boss.BossStatus;

public class BossStatusImplementation implements BossStatusBridge {
    public float bridge$getHealthScale() {
        return BossStatus.healthScale;
    }

    public void bridge$setHealthScale(float var1) {
        BossStatus.healthScale = var1;
    }

    public String bridge$getBossName() {
        return BossStatus.bossName;
    }

    public void bridge$setBossName(String var1) {
        BossStatus.bossName = var1;
    }

    public int bridge$getStatusBarTime() {
        return BossStatus.statusBarTime;
    }

    public void bridge$setStatusBarTime(int var1) {
        BossStatus.statusBarTime = var1;
    }

    public boolean bridge$hasColorModifier() {
        return BossStatus.hasColorModifier;
    }

    public void bridge$setHasColorModifier(boolean var1) {
        BossStatus.hasColorModifier = var1;
    }

    public void bridge$drawBar(float var1, float var2) {
        Ref.getMinecraft().bridge$getTextureManager().bridge$bindTexture(Ref.getLC().lllllIllIllIllllIlIllllII().IlIIlIIlIIlIIllIIIllIIllI().IlIllIIlIIlIIIllIllllIIll());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$tryBlendFuncSeparate(770, 771, 1, 0);
        short var3 = 182;
        int var4 = (int)(this.bridge$getHealthScale() * (float)(var3 + 1));
        byte var5 = 12;
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2 + (float)var5, 0, 74, var3, 5);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2 + (float)var5, 0, 74, var3, 5);
        if (var4 > 0) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2 + (float)var5, 0, 79, var4, 5);
        }

    }
}