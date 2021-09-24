package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.gui.FontRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.util.FontCharParser;
import net.minecraft.client.gui.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Iterator;
import java.util.List;

@Mixin(FontRenderer.class)
public abstract class MixinFontRenderer implements FontRendererBridge {
    @Shadow
    private int textColor;
    @Shadow
    private float posX;
    @Shadow
    private float posY;
    @Shadow
    private int[] colorCode;

    @Shadow
    public abstract int drawString(String var1, float var2, float var3, int var4, boolean var5);

    @Shadow
    public abstract int getStringWidth(String var1);

    @Shadow
    protected abstract int renderString(String var1, float var2, float var3, int var4, boolean var5);

    public float bridge$getStringWidth(String var1) {
        return getStringWidth(var1);
    }

    public float bridge$drawString(String var1, float var2, float var3, int var4, boolean var5) {
        return drawString(var1, var2, var3, var4, var5);
    }

    public void bridge$drawStringElements(String var1, float var2, float var3, float var4, boolean var5) {
        try {
            List<FontCharParser.Element> var6 = FontCharParser.IlllIIIIIIlllIlIIlllIlIIl(var1);
            this.posX = var2;
            this.posY = var3;

            for (FontCharParser.Element var8 : var6) {
                if (var8.IlllIIIIIIlllIlIIlllIlIIl() == FontCharParser.ElementType.IlllIIIIIIlllIlIIlllIlIIl) {
                    this.textColor = Integer.parseInt(var8.lIllIlIIIlIIIIIIIlllIlIll(), 16);
                } else if (var8.IlllIIIIIIlllIlIIlllIlIIl() == FontCharParser.ElementType.lIlIlIlIlIIlIIlIIllIIIIIl) {
                    if (var8.lIllIlIIIlIIIIIIIlllIlIll().equalsIgnoreCase("color") && var8.lIlIlIlIlIIlIIlIIllIIIIIl().isPresent()) {
                        EnumChatColor var9 = EnumChatColor.valueOf(var8.lIlIlIlIlIIlIIlIIllIIIIIl().get());
                        this.textColor = this.colorCode[var9.ordinal()];
                    }
                } else if (var8.IlllIIIIIIlllIlIIlllIlIIl() == FontCharParser.ElementType.lIllIlIIIlIIIIIIIlllIlIll) {
                }
            }
        } catch (FontCharParser.llIlllIIIllllIIlllIllIIIl var10) {
        }
    }

    public int proxy$renderString(String var1, float var2, float var3, int var4, boolean var5) {
        return renderString(var1, var2, var3, var4, var5);
    }

    public int proxy$getStringWidth(String var1) {
        return getStringWidth(var1);
    }
}