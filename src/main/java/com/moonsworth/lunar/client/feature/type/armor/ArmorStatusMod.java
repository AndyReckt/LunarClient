package com.moonsworth.lunar.client.feature.type.armor;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.feature.hud.Position;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;

public class ArmorStatusMod extends DraggableHudMod {
    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI;
    public BooleanSetting lIlIIIIIIlIIIllllIllIIlII;
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;
    public BooleanSetting IIlIllIlllllllIIlIIIllIIl;
    public BooleanSetting lIIlIlllIlIlIIIlllIIlIIII;
    public BooleanSetting llIllIlIllIlllIllIIIIllII;
    public BooleanSetting IllllllllllIlIIIlllIlllll;
    public BooleanSetting lllllIllIlIIlIIlIIIlllIlI;
    public EnumSetting IllIIIlllIIIlIlllIlIIlIII;
    public EnumSetting IIlIllIlIIllIIlIlIllllllI;
    public EnumSetting lIIIlllIIIIllllIlIIIlIIll;
    public ColorSetting llIIIlIllIIIIlIIIlIlIllIl;
    public ColorSetting llllIlIllllIlIlIIIllIlIlI;
    public ColorSetting IlIllIIlIIlIIIllIllllIIll;
    public ColorSetting lIllllIllIIlIIlIIIlIIIlII;
    public ColorSetting lIlIlIIIIIIllIlIIIIllIIII;
    public ColorSetting lIIlIIIIIIlIIlIIllIlIIlII;
    public ColorSetting IlIIlIIlIIlIIllIIIllIIllI;
    public BooleanSetting IIlIlIIIllIIllllIllllIlIl;
    public BooleanSupplier lllllIIIIlIlllIllIIIlIIlI = null;
    public final List IIlllIllIlIllIllIIllIlIIl = new ArrayList();
    public final List lIlIIlIlllIIlIIIlIlIlIllI = new ArrayList();

    public ArmorStatusMod() {
        super(true, HudModPosition.BOTTOM_RIGHT);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent var1) {
        this.IlllIIIIIIlllIlIIlllIlIIl(Ref.getMinecraft());
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        this.lllllIIIIlIlllIllIIIlIIlI = () -> {
            return (Boolean)this.IIlIlIIIllIIllllIllllIlIl.llIlllIIIllllIIlllIllIIIl();
        };
        return ImmutableList.of(new SettingLabel("generalOptions"), this.IllIIIlllIIIlIlllIlIIlIII = new EnumSetting("list_mode", ListMode.lIlIlIlIlIIlIIlIIllIIIIIl), this.lllIIIIIlllIIlIllIIlIIIlI = new BooleanSetting("item_name", false), this.lIlIIIIIIlIIIllllIllIIlII = new BooleanSetting("item_count", true), this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("equipped_item", true), this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("show_while_typing", false), this.IIlIllIlllllllIIlIIIllIIl = new BooleanSetting("text_shadow", true), new SettingLabel("damageOptions"), this.lIIlIlllIlIlIIIlllIIlIIII = new BooleanSetting("damage_overlay", true), this.llIllIlIllIlllIllIIIIllII = new BooleanSetting("item_dmg", true), this.IllllllllllIlIIIlllIlllll = new BooleanSetting("armor_dmg", true), this.lllllIllIlIIlIIlIIIlllIlI = new BooleanSetting("max_dmg", false), new SettingLabel("damageDisplay"), this.IIlIllIlIIllIIlIlIllllllI = new EnumSetting("dmg_display", DamageDisplay.VALUE), this.lIIIlllIIIIllllIlIIIlIIll = new EnumSetting("dmg_threshold", DamageThreshold.PERCENT), new SettingLabel("colorOptions"), this.IIlIlIIIllIIllllIllllIlIl = new BooleanSetting("static_colors", false), this.llIIIlIllIIIIlIIIlIlIllIl = new ColorSetting("name_text", -1), this.IlIIlIIlIIlIIllIIIllIIllI = new ColorSetting("highest", -1, this.lllllIIIIlIlllIllIIIlIIlI), this.lIIlIIIIIIlIIlIIllIlIIlII = new ColorSetting("high", -11141291, this.lllllIIIIlIlllIllIIIlIIlI), this.lIlIlIIIIIIllIlIIIIllIIII = new ColorSetting("medium", -171, this.lllllIIIIlIlllIllIIIlIIlI), this.lIllllIllIIlIIlIIIlIIIlII = new ColorSetting("medium_low", -22016, this.lllllIIIIlIlllIllIIIlIIlI), this.IlIllIIlIIlIIIllIllllIIll = new ColorSetting("low", -43691, this.lllllIIIIlIlllIllIIIlIIlI), this.llllIlIllllIlIlIIIllIlIlI = new ColorSetting("lowest", -5636096, this.lllllIIIIlIlllIllIIIlIIlI));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        if (!this.IIlllIllIlIllIllIIllIlIIl.isEmpty()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlllIllIlIllIllIIllIlIIl, var2, var3);
        }

    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getMinecraft());
        if (!this.lIlIIlIlllIIlIIIlIlIlIllI.isEmpty()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIlIlllIIlIIIlIlIlIllI, var2, var3);
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(MinecraftBridge var1) {
        this.lIlIIlIlllIIlIIIlIlIlIllI.clear();
        this.lIlIIlIlllIIlIIIlIlIlIllI.add(new ArmourStatusEntry(this, Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$diamond_helmet()), 16, 16, 2, true, -1));
        this.lIlIIlIlllIIlIIIlIlIlIllI.add(new ArmourStatusEntry(this, Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$diamond_chestplate()), 16, 16, 2, true, -1));
        this.lIlIIlIlllIIlIIIlIlIlIllI.add(new ArmourStatusEntry(this, Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$diamond_leggings()), 16, 16, 2, true, -1));
        this.lIlIIlIlllIIlIIIlIlIlIllI.add(new ArmourStatusEntry(this, Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$diamond_boots()), 16, 16, 2, true, -1));
        if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() && var1.bridge$getPlayer() != null && var1.bridge$getPlayer().bridge$getCurrentEquippedItem() != null && var1.bridge$getPlayer().bridge$getCurrentEquippedItem().bridge$getItem() != Bridge.llIlIIIllIIlIllIllIllllIl().bridge$air()) {
            this.lIlIIlIlllIIlIIIlIlIlIllI.add(new ArmourStatusEntry(this, var1.bridge$getPlayer().bridge$getCurrentEquippedItem(), 16, 16, 2, false, -1));
        } else if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
            this.lIlIIlIlllIIlIIIlIlIlIllI.add(new ArmourStatusEntry(this, Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$diamond_sword()), 16, 16, 2, false, -1));
        }

    }

    public ColorSetting IlllIIIIIIlllIlIIlllIlIIl(int var1) {
        if (this.IIlIlIIIllIIllllIllllIlIl.llIlllIIIllllIIlllIllIIIl()) {
            return this.IlIIlIIlIIlIIllIIIllIIllI;
        } else if (var1 <= 10) {
            return this.llllIlIllllIlIlIIIllIlIlI;
        } else if (var1 <= 25) {
            return this.IlIllIIlIIlIIIllIllllIIll;
        } else if (var1 <= 40) {
            return this.lIllllIllIIlIIlIIIlIIIlII;
        } else if (var1 <= 60) {
            return this.lIlIlIIIIIIllIlIIIIllIIII;
        } else {
            return var1 <= 80 ? this.lIIlIIIIIIlIIlIIllIlIIlII : this.IlIIlIIlIIlIIllIIIllIIllI;
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(MinecraftBridge var1) {
        if (Ref.getPlayer() != null) {
            this.IIlllIllIlIllIllIIllIlIIl.clear();

            for(int var2 = 3; var2 >= -1; --var2) {
                ItemStackBridge var3 = null;
                if (var2 == -1 && this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
                    var3 = var1.bridge$getPlayer().bridge$getCurrentEquippedItem();
                } else if (var2 != -1) {
                    var3 = (ItemStackBridge)var1.bridge$getPlayer().bridge$getInventory().bridge$getArmorInventory().get(var2);
                }

                if (var3 != null && var3.bridge$getItem() != Bridge.llIlIIIllIIlIllIllIllllIl().bridge$air()) {
                    this.IIlllIllIlIllIllIIllIlIIl.add(new ArmourStatusEntry(this, var3, 16, 16, 2, var2 > -1, var2));
                }
            }

        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(List var1, float var2, float var3) {
        if (var1.size() > 0) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
            RenderItemBridge var4 = Ref.getMinecraft().bridge$getRenderItem();
            float var5 = var4.bridge$getZLevel();
            int var6 = this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl() ? 18 : 16;
            int var8;
            if (this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl() == ListMode.lIlIlIlIlIIlIIlIIllIIIIIl) {
                int var13 = 0;
                var8 = 0;
                boolean var14 = this.lIlIIIIIllIIlIIlIIlIlIIlI().IlllIIIIIIlllIlIIlllIlIIl() == Position.RIGHT;
                Iterator var15 = var1.iterator();

                while(var15.hasNext()) {
                    ArmourStatusEntry var16 = (ArmourStatusEntry)var15.next();
                    var16.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var2 + (var14 ? this.llIIIIIIIllIIllIlIllIIIIl : 0.0F), var3 + (float)var13);
                    var13 += var6;
                    if (var16.lIlIlIlIlIIlIIlIIllIIIIIl() > var8) {
                        var8 = var16.lIlIlIlIlIIlIIlIIllIIIIIl();
                    }
                }

                this.lIIIllIllIIllIlllIlIIlllI = (float)var13;
                this.llIIIIIIIllIIllIlIllIIIIl = (float)var8;
            } else if (this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl() == ListMode.IlllIIIIIIlllIlIIlllIlIIl) {
                byte var7 = 0;
                var8 = 0;
                int var9 = 0;
                boolean var10 = this.lIlIIIIIllIIlIIlIIlIlIIlI().IlllIIIIIIlllIlIIlllIlIIl() == Position.RIGHT;
                Iterator var11 = var1.iterator();

                while(var11.hasNext()) {
                    ArmourStatusEntry var12 = (ArmourStatusEntry)var11.next();
                    if (var10) {
                        var8 += var12.lIlIlIlIlIIlIIlIIllIIIIIl();
                    }

                    var12.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var2 + (float)var8, var3 + (float)var7);
                    if (!var10) {
                        var8 += var12.lIlIlIlIlIIlIIlIIllIIIIIl();
                    }

                    if (var12.IlllIIIIIIlllIlIIlllIlIIl() > var9) {
                        var9 += var12.IlllIIIIIIlllIlIIlllIlIIl();
                    }
                }

                this.lIIIllIllIIllIlllIlIIlllI = (float)var9;
                this.llIIIIIIIllIIllIlIllIIIIl = (float)var8;
            }

            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
            var4.bridge$setZLevel(var5);
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Armor Status", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("armorstatus", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.HUD));
    }

    public BooleanSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public BooleanSetting IIIIIIIIIIIIIIIllllIIlIIl() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public BooleanSetting llIIIIllIlIIlIlIIlllIllIl() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public BooleanSetting IIIIlIllIllIlIIIIIlIlIlIl() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public BooleanSetting IlIlIlIlIIIlIIlIIlllIllIl() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public BooleanSetting lIIIlIllllIIlIIlIIlIIIIlI() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public BooleanSetting lllllIlIllIlIlllIIIlIIlIl() {
        return this.llIllIlIllIlllIllIIIIllII;
    }

    public BooleanSetting IllIlIIllIIlllIIllIlIlIII() {
        return this.IllllllllllIlIIIlllIlllll;
    }

    public BooleanSetting IlIlllIIIIIllIIllIllIIlll() {
        return this.lllllIllIlIIlIIlIIIlllIlI;
    }

    public EnumSetting IllllIIllllIllIIIIlllllII() {
        return this.IllIIIlllIIIlIlllIlIIlIII;
    }

    public EnumSetting IIllllIIlllIlIIlIIlllIlII() {
        return this.IIlIllIlIIllIIlIlIllllllI;
    }

    public EnumSetting IllIlIIlllIIlIIllIIIIIIIl() {
        return this.lIIIlllIIIIllllIlIIIlIIll;
    }

    public ColorSetting IllIllIllIIlIlllIIlllIIll() {
        return this.llIIIlIllIIIIlIIIlIlIllIl;
    }

    public ColorSetting IlIIIIlllIllllIlIlIllIlII() {
        return this.llllIlIllllIlIlIIIllIlIlI;
    }

    public ColorSetting lIlIIIlIIlIIIlIIIlllIlIII() {
        return this.IlIllIIlIIlIIIllIllllIIll;
    }

    public ColorSetting IlIllIIlIIlIlIIlIIlIllIll() {
        return this.lIllllIllIIlIIlIIIlIIIlII;
    }

    public ColorSetting lIlllllIIlllIllIIlIIlIlll() {
        return this.lIlIlIIIIIIllIlIIIIllIIII;
    }

    public ColorSetting lIIlIIllIlIIlIIllIIIIlIIl() {
        return this.lIIlIIIIIIlIIlIIllIlIIlII;
    }

    public ColorSetting IllIIlllIllIlllllIlIllIll() {
        return this.IlIIlIIlIIlIIllIIIllIIllI;
    }

    public BooleanSetting IIIlIlIllIlIlIIIIIlIllIII() {
        return this.IIlIlIIIllIIllllIllllIlIl;
    }

    public BooleanSupplier IIlllIllIIlllllIllllllIII() {
        return this.lllllIIIIlIlllIllIIIlIIlI;
    }

    public List IlIlIIllllllIIlIIllIIllIl() {
        return this.IIlllIllIlIllIllIIllIlIIl;
    }

    public List IIllIIlIIIlIlIlIlIIllIllI() {
        return this.lIlIIlIlllIIlIIIlIlIlIllI;
    }
}
