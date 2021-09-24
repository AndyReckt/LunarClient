package com.moonsworth.lunar.client.feature.type.armor;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.FontRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.Position;
import com.moonsworth.lunar.client.feature.type.sba.SkyBlockAddonsMod;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.ColorSetting;
import org.lwjgl.opengl.GL11;

public class ArmourStatusEntry {
    public final ItemStackBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public final int IlllIIIIIIlllIlIIlllIlIIl;
    public final int lIllIlIIIlIIIIIIIlllIlIll;
    public final int llIlllIIIllllIIlllIllIIIl;
    public int llllIIlIIlIIlIIllIIlIIllI;
    public int IlIlIlllllIlIIlIlIlllIlIl;
    public int llIIIIIIIllIIllIlIllIIIIl;
    public int lIIIllIllIIllIlllIlIIlllI;
    public ColorSetting IlllllIlIIIlIIlIIllIIlIll;
    public String llIIlIlIIIllIlIlIlIIlIIll = "";
    public String llIIIlllIIlllIllllIlIllIl = "";
    public final boolean lllllIllIllIllllIlIllllII;
    public int lllIIIIIlllIIlIllIIlIIIlI;
    public final ArmorStatusMod lIlIIIIIIlIIIllllIllIIlII;

    public ArmourStatusEntry(ArmorStatusMod var1, ItemStackBridge var2, int var3, int var4, int var5, boolean var6, int var7) {
        this.lIlIIIIIIlIIIllllIllIIlII = var1;
        this.lIlIlIlIlIIlIIlIIllIIIIIl = var2;
        this.IlllIIIIIIlllIlIIlllIlIIl = var3;
        this.lIllIlIIIlIIIIIIIlllIlIll = var4;
        this.llIlllIIIllllIIlllIllIIIl = var5;
        this.lllllIllIllIllllIlIllllII = var6;
        this.IlllllIlIIIlIIlIIllIIlIll = var1.IlllIIIIIIlllIlIIlllIlIIl(100);
        this.lllIIIIIlllIIlIllIIlIIIlI = var7;
        this.lIllIlIIIlIIIIIIIlllIlIll();
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.lIIIllIllIIllIlllIlIIlllI = this.lIlIIIIIIlIIIllllIllIIlII.IlIllIIlIIlIIIllIllllIIll().llIlllIIIllllIIlllIllIIIl() ? Math.max(Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() * 2, this.lIllIlIIIlIIIIIIIlllIlIll) : Math.max(Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl(), this.lIllIlIIIlIIIIIIIlllIlIll);
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl != null) {
            boolean var1 = true;
            boolean var2 = true;
            if ((this.lllllIllIllIllllIlIllllII && this.lIlIIIIIIlIIIllllIllIIlII.IllIlIIllIIlllIIllIlIlIII().llIlllIIIllllIIlllIllIIIl() || !this.lllllIllIllIllllIlIllllII && this.lIlIIIIIIlIIIllllIllIIlII.lllllIlIllIlIlllIIIlIIlIl().llIlllIIIllllIIlllIllIIIl()) && this.lIlIlIlIlIIlIIlIIllIIIIIl.bridge$isItemStackDamageableNoUnbr()) {
                int var6 = this.lIlIlIlIlIIlIIlIIllIIIIIl.bridge$getMaxDamage() + 1;
                int var5 = var6 - this.lIlIlIlIlIIlIIlIIllIIIIIl.bridge$getItemDamage();
                if (this.lIlIIIIIIlIIIllllIllIIlII.IIllllIIlllIlIIlIIlllIlII().llIlllIIIllllIIlllIllIIIl() == DamageDisplay.VALUE) {
                    this.IlllllIlIIIlIIlIIllIIlIll = this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl(var5 * 100 / var6);
                    this.llIIIlllIIlllIllllIlIllIl = var5 + (this.lIlIIIIIIlIIIllllIllIIlII.IlIlllIIIIIllIIllIllIIlll().llIlllIIIllllIIlllIllIIIl() ? "/" + var6 : "");
                } else if (this.lIlIIIIIIlIIIllllIllIIlII.IIllllIIlllIlIIlIIlllIlII().llIlllIIIllllIIlllIllIIIl() == DamageDisplay.PERCENT) {
                    this.IlllllIlIIIlIIlIIllIIlIll = this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl(var5 * 100 / var6);
                    this.llIIIlllIIlllIllllIlIllIl = var5 * 100 / var6 + "%";
                }
            }

            SkyBlockAddonsMod var3 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll();
            if (this.lllIIIIIlllIIlIllIIlIIIlI != -1 && var3 != null && var3.IlllIIIIIIlllIlIIlllIlIIl() && var3.lIlllllIIlllIllIIlIIlIlll().llIlllIIIllllIIlllIllIIIl() && var3.IIIllIlIllIIllIlIlllIllIl().isSkyBlock()) {
                com.moonsworth.lunar.client.sba.lIllIlIIIlIIIIIIIlllIlIll var4 = var3.IIIllIlIllIIllIlIlllIllIl().getSlayerProgress()[this.lllIIIIIlllIIlIllIIlIIIlI];
                if (var4 != null) {
                    this.llIIIlllIIlllIllllIlIllIl = var4.getPercent() + "% (" + var4.getDefence() + "§f)";
                }
            }

            this.IlIlIlllllIlIIlIlIlllIlIl = (int)Ref.getFontRenderer().bridge$getStringWidth(lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIIlllIIlllIllllIlIllIl));
            this.llIIIIIIIllIIllIlIllIIIIl = this.llIlllIIIllllIIlllIllIIIl + this.IlllIIIIIIlllIlIIlllIlIIl + this.llIlllIIIllllIIlllIllIIIl + this.IlIlIlllllIlIIlIlIlllIlIl;
            if (this.lIlIIIIIIlIIIllllIllIIlII.IlIllIIlIIlIIIllIllllIIll().llIlllIIIllllIIlllIllIIIl()) {
                this.llIIlIlIIIllIlIlIlIIlIIll = this.lIlIlIlIlIIlIIlIIllIIIIIl.bridge$getDisplayName();
                this.llIIIIIIIllIIllIlIllIIIIl = (int)((float)(this.llIlllIIIllllIIlllIllIIIl + this.IlllIIIIIIlllIlIIlllIlIIl + this.llIlllIIIllllIIlllIllIIIl) + Math.max(Ref.getFontRenderer().bridge$getStringWidth(lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIlIlIIIllIlIlIlIIlIIll)), (float)this.IlIlIlllllIlIIlIlIlllIlIl));
            }

            this.llllIIlIIlIIlIIllIIlIIllI = (int) Ref.getFontRenderer().bridge$getStringWidth(lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIlIlIIIllIlIlIlIIlIIll));
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderItemBridge var1, float var2, float var3) {
        HudModPosition var4 = this.lIlIIIIIIlIIIllllIllIIlII.lIlIIIIIllIIlIIlIIlIlIIlI();
        boolean var5 = var4.IlllIIIIIIlllIlIIlllIlIIl() == Position.RIGHT;
        if (var5) {
            if (llIlllIIIllllIIlllIllIIIl()) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableRescaleNormal();
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableStandardItemLighting();
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableGUIStandardItemLighting();
            }

            var1.bridge$renderItemAndEffectIntoGUI(this.lIlIlIlIlIIlIIlIIllIIIIIl, (int)(var2 - (float)(this.IlllIIIIIIlllIlIIlllIlIIl + this.llIlllIIIllllIIlllIllIIIl)), (int)var3);
            lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getFontRenderer(), this.lIlIlIlIlIIlIIlIIllIIIIIl, (int)(var2 - (float)(this.IlllIIIIIIlllIlIIlllIlIIl + this.llIlllIIIllllIIlllIllIIIl)), (int)var3, this.lIlIIIIIIlIIIllllIllIIlII.lIIIlIllllIIlIIlIIlIIIIlI().llIlllIIIllllIIlllIllIIIl(), this.lIlIIIIIIlIIIllllIllIIlII.IIIIIIIIIIIIIIIllllIIlIIl().llIlllIIIllllIIlllIllIIIl());
            if (llIlllIIIllllIIlllIllIIIl()) {
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$disableStandardItemLighting();
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableRescaleNormal();
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
            }

            this.lIlIIIIIIlIIIllllIllIIlII.IllIllIllIIlIlllIIlllIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIlIlIIIllIlIlIlIIlIIll, var2 - (float)(this.llIlllIIIllllIIlllIllIIIl + this.IlllIIIIIIlllIlIIlllIlIIl + this.llIlllIIIllllIIlllIllIIIl) - (float)this.llllIIlIIlIIlIIllIIlIIllI, var3, this.lIlIIIIIIlIIIllllIllIIlII.IlIlIlIlIIIlIIlIIlllIllIl().llIlllIIIllllIIlllIllIIIl());
            this.IlllllIlIIIlIIlIIllIIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIIlllIIlllIllllIlIllIl, var2 - (float)(this.llIlllIIIllllIIlllIllIIIl + this.IlllIIIIIIlllIlIIlllIlIIl + this.llIlllIIIllllIIlllIllIIIl) - (float)this.IlIlIlllllIlIIlIlIlllIlIl, var3 + (float)(this.lIlIIIIIIlIIIllllIllIIlII.IlIllIIlIIlIIIllIllllIIll().llIlllIIIllllIIlllIllIIIl() ? this.lIIIllIllIIllIlllIlIIlllI / 2 : this.lIIIllIllIIllIlllIlIIlllI / 4), this.lIlIIIIIIlIIIllllIllIIlII.IlIlIlIlIIIlIIlIIlllIllIl().llIlllIIIllllIIlllIllIIIl());
        } else {
            if (llIlllIIIllllIIlllIllIIIl()) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableRescaleNormal();
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableStandardItemLighting();
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableGUIStandardItemLighting();
            }

            var1.bridge$renderItemAndEffectIntoGUI(this.lIlIlIlIlIIlIIlIIllIIIIIl, (int)var2, (int)var3);
            lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getFontRenderer(), this.lIlIlIlIlIIlIIlIIllIIIIIl, (int)var2, (int)var3, this.lIlIIIIIIlIIIllllIllIIlII.lIIIlIllllIIlIIlIIlIIIIlI().llIlllIIIllllIIlllIllIIIl(), this.lIlIIIIIIlIIIllllIllIIlII.IIIIIIIIIIIIIIIllllIIlIIl().llIlllIIIllllIIlllIllIIIl());
            if (llIlllIIIllllIIlllIllIIIl()) {
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$disableStandardItemLighting();
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableRescaleNormal();
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
            }

            this.lIlIIIIIIlIIIllllIllIIlII.IllIllIllIIlIlllIIlllIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIlIlIIIllIlIlIlIIlIIll, var2 + (float)this.IlllIIIIIIlllIlIIlllIlIIl + (float)this.llIlllIIIllllIIlllIllIIIl, var3, this.lIlIIIIIIlIIIllllIllIIlII.IlIlIlIlIIIlIIlIIlllIllIl().llIlllIIIllllIIlllIllIIIl());
            this.IlllllIlIIIlIIlIIllIIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIIlllIIlllIllllIlIllIl, var2 + (float)this.IlllIIIIIIlllIlIIlllIlIIl + (float)this.llIlllIIIllllIIlllIllIIIl, var3 + (float)(this.lIlIIIIIIlIIIllllIllIIlII.IlIllIIlIIlIIIllIllllIIll().llIlllIIIllllIIlllIllIIIl() ? this.lIIIllIllIIllIlllIlIIlllI / 2 : this.lIIIllIllIIllIlllIlIIlllI / 4), this.lIlIIIIIIlIIIllllIllIIlII.IlIlIlIlIIIlIIlIIlllIllIl().llIlllIIIllllIIlllIllIIIl());
        }

    }

    public static String lIlIlIlIlIIlIIlIIllIIIIIl(String var0) {
        return var0.replaceAll("(?i)§[0-9a-fklmnor]", "");
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(FontRendererBridge var0, ItemStackBridge var1, int var2, int var3, boolean var4, boolean var5) {
        if (var1 != null && (var4 || var5)) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0F, 0.0F, 500.0F);
            int var6;
            if (var1.bridge$isItemDamaged() && var4) {
                var6 = (int)Math.round(13.0D - (double)var1.bridge$getItemDamage() * 13.0D / (double)var1.bridge$getMaxDamage());
                int var7 = (int)Math.round(255.0D - (double)var1.bridge$getItemDamage() * 255.0D / (double)var1.bridge$getMaxDamage());
                if (Bridge.getMinecraftVersion() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl) {
                    GL11.glDisable(2896);
                    GL11.glDisable(2929);
                    GL11.glDisable(3553);
                    GL11.glDisable(3008);
                    GL11.glDisable(3042);
                }

                int var8 = 255 - var7 << 16 | var7 << 8;
                int var9 = (255 - var7) / 4 << 16 | 16128;
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRect((float)(var2 + 2), (float)(var3 + 14), 13.0F, 2.0F, -16777216);
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRect((float)(var2 + 2), (float)(var3 + 14), 12.0F, 1.0F, -16777216 | var9);
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRect((float)(var2 + 2), (float)(var3 + 14), (float)var6, 1.0F, -16777216 | var8);
                if (Bridge.getMinecraftVersion() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl) {
                    GL11.glEnable(3042);
                    GL11.glEnable(3008);
                    GL11.glEnable(3553);
                    GL11.glEnable(2896);
                    GL11.glEnable(2929);
                }
            }

            if (var5) {
                var6 = 0;
                if (var1.bridge$getMaxStackSize() > 1) {
                    var6 = lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getMinecraft().bridge$getPlayer(), var1.bridge$getItem(), var1.bridge$getItemDamage());
                } else if (var1.bridge$getItem().equals(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$bow())) {
                    var6 = lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getMinecraft().bridge$getPlayer(), Bridge.llIlIIIllIIlIllIllIllllIl().bridge$arrow());
                }

                if (var6 > 1) {
                    String var10 = "" + var6;
                    var0.bridge$drawString(var10, (float)(var2 + 19 - 2) - var0.bridge$getStringWidth(var10), (float)(var3 + 6 + 3), -1, true);
                }
            }

            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        }

    }

    public static int lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerBridge var0, ItemBridge var1) {
        return lIlIlIlIlIIlIIlIIllIIIIIl(var0, var1, -1);
    }

    public static int lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerBridge var0, ItemBridge var1, int var2) {
        int var3 = 0;

        for(int var4 = 0; var4 < var0.bridge$getInventory().bridge$getMainInventory().size(); ++var4) {
            if (var0.bridge$getInventory().bridge$getMainInventory().get(var4) != null && var1.equals(var0.bridge$getInventory().bridge$getMainInventory().get(var4).bridge$getItem()) && (var2 == -1 || var0.bridge$getInventory().bridge$getMainInventory().get(var4).bridge$getItemDamage() == var2)) {
                var3 += var0.bridge$getInventory().bridge$getMainInventory().get(var4).bridge$getStackSize();
            }
        }

        return var3;
    }

    public static boolean llIlllIIIllllIIlllIllIIIl() {
        MinecraftVersion var0 = Bridge.getMinecraftVersion();
        return var0 == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl || var0 == MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl || var0 == MinecraftVersion.lIllIlIIIlIIIIIIIlllIlIll;
    }
}
