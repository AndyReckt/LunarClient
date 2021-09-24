package com.moonsworth.lunar.client.bridge.impl.type.render;

import com.google.common.collect.ImmutableList;

import com.moonsworth.lunar.bridge.minecraft.client.entity.item.EntityItemBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderEntityItemBridge;
import com.moonsworth.lunar.client.event.Event;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.hud.RenderEntityItemScaleEvent;
import com.moonsworth.lunar.client.feature.type.items2d.Items2DMod;
import com.moonsworth.lunar.client.ref.Ref;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.*;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class DroppedItemRendererImplementation implements RenderEntityItemBridge {
    public static final Random random = new Random();
    public static final ResourceLocation SPLASH_POTION = new ResourceLocation("minecraft", "items/potion_bottle_splash");
    public static final ResourceLocation DRINK_POTION = new ResourceLocation("minecraft", "items/potion_bottle_drinkable");
    public static final ResourceLocation SPAWN_EGG_OVERLAY = new ResourceLocation("minecraft", "items/spawn_egg_overlay");
    public static final ResourceLocation FIREWORKS_CHARGE = new ResourceLocation("minecraft", "items/fireworks_charge_overlay");
    public static final List<ResourceLocation> LEATHER_ARMOR_OVERLAY = ImmutableList.of(new ResourceLocation("minecraft", "items/leather_helmet_overlay"), new ResourceLocation("minecraft", "items/leather_chestplate_overlay"), new ResourceLocation("minecraft", "items/leather_leggings_overlay"), new ResourceLocation("minecraft", "items/leather_boots_overlay"));

    public void renderBlock(EntityItem var1, double var2, double var4, double var6, float var8) {
        random.setSeed(187L);
        ItemStack var9 = var1.getEntityItem();
        IBakedModel var10 = Minecraft.getMinecraft().renderItem.itemModelMesher.getItemModel(var9);
        int var11 = this.renderStackSize(var9.stackSize);
        GlStateManager.pushAttrib();
        GlStateManager.popAttrib();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.pushAttrib();
        Render<EntityItem> var12 = Minecraft.getMinecraft().renderManager.getEntityRenderObject(var1);
        var12.bindEntityTexture(var1);
        float var13 = var10.getItemCameraTransforms().ground.scale.y;
        float var14 = MathHelper.cos(((float)var1.age + var8) / 10.0F + var1.hoverStart) * 0.1F + 0.1F;
        GL11.glTranslated(var2, var4 + (double)var14 + 0.25D * (double)var13, var6);

        for(int var15 = 0; var15 < var11; ++var15) {
            GlStateManager.pushAttrib();
            this.setupTransforms(var15);
            float var16 = this.getScale((EntityItemBridge)var1);
            GlStateManager.translate(var16, var16, var16);
            if (var10.isBuiltInRenderer() && !(var9.getItem() instanceof ItemSkull)) {
                GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
            } else if (var9.getItem().getUnlocalizedName().contains("Fence")) {
                GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (var10.isGui3d()) {
                GlStateManager.scale(0.5D, 0.5D, 0.5D);
            }

            var10.getItemCameraTransforms().applyTransform(ItemCameraTransforms.TransformType.GROUND);
            Minecraft.getMinecraft().renderItem.renderItem(var9, var10);
            GlStateManager.popAttrib();
        }

        GlStateManager.popAttrib();
        GlStateManager.pushAttrib();
        GlStateManager.enableBlend();
    }

    public void renderItemSprite(EntityItemBridge var1, double var2, double var4, double var6, float var8) {
        random.setSeed(187L);
        ItemStack var9 = (ItemStack)var1.bridge$getItem();
        Item var10 = var9.getItem();
        EntityItem var11 = (EntityItem)var1;
        if (!(var10 instanceof ItemBlock) && !(var10 instanceof ItemSkull) && Ref.getLC().lllllIllIllIllllIlIllllII().llIllIlIllIlllIllIIIIllII().IlIllIIlIIlIIIllIllllIIll().llIlllIIIllllIIlllIllIIIl() != Items2DMod.RenderingOptions.IlllIIIIIIlllIlIIlllIlIIl) {
            TextureAtlasSprite var12 = Minecraft.getMinecraft().renderItem.itemModelMesher.getParticleIcon(var10, var9.getItemDamage());
            boolean var13 = false;
            int var14 = -16777216;
            if (var10 instanceof ItemArmor || var10 instanceof ItemPotion || var10 instanceof ItemMonsterPlacer) {
                var13 = true;
                var14 = var10.getColorFromItemStack(var9, 0);
            }

            int var15 = this.renderStackSize(var9.stackSize);
            Tessellator var16 = Tessellator.getInstance();
            WorldRenderer var17 = var16.getWorldRenderer();
            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
            GlStateManager.pushAttrib();
            GlStateManager.disableColorMaterial();
            GlStateManager.disableAlpha();
            GlStateManager.popAttrib();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            RenderHelper.enableStandardItemLighting();
            float var18 = MathHelper.cos(((float)var11.age + var8) / 10.0F + var11.hoverStart) * 0.1F + 0.1F;
            GL11.glTranslated(var2, var4 + (double)var18 + 0.1D, var6);
            int var19 = var14 >> 16 & 255;
            int var20 = var14 >> 8 & 255;
            int var21 = var14 & 255;

            for(int var22 = 0; var22 < var15; ++var22) {
                GlStateManager.pushAttrib();
                this.setupTransforms(var22);
                float var23 = this.getScale(var1);
                GL11.glScalef(var23, var23, var23);
                GL11.glScalef(0.5F, 0.5F, 0.5F);
                if (this.hasOverlays(var9)) {
                    TextureAtlasSprite var24 = Minecraft.getMinecraft().textureMapBlocks.getAtlasSprite(Objects.requireNonNull(this.getOverlayTexture(var9)).toString());
                    int var25 = var10.getColorFromItemStack(var9, 1);
                    int var26 = var25 >> 16 & 255;
                    int var27 = var25 >> 8 & 255;
                    int var28 = var25 & 255;
                    this.renderSprite(var17, var24, var26, var27, var28, true);
                }

                this.renderSprite(var17, var12, var19, var20, var21, var13);
                GlStateManager.popAttrib();
            }

            GlStateManager.pushAttrib();
            GlStateManager.enableBlend();
        } else {
            this.renderBlock(var11, var2, var4, var6, var8);
        }
    }

    public void renderSprite(WorldRenderer var1, TextureAtlasSprite var2, int var3, int var4, int var5, boolean var6) {
        var1.begin(7, var6 ? DefaultVertexFormats.ITEM : DefaultVertexFormats.BLOCK);
        this.color(var1.pos(-0.5D, -0.25D, 0.0D).tex(var2.getMaxU(), var2.getMinV()), var3, var4, var5, var6).normal(0.0F, 1.0F, 0.0F).endVertex();
        this.color(var1.pos(0.5D, -0.25D, 0.0D).tex(var2.getMinU(), var2.getMinV()), var3, var4, var5, var6).normal(0.0F, 1.0F, 0.0F).endVertex();
        this.color(var1.pos(0.5D, 0.75D, 0.0D).tex(var2.getMinU(), var2.getMaxV()), var3, var4, var5, var6).normal(0.0F, 1.0F, 0.0F).endVertex();
        this.color(var1.pos(-0.5D, 0.75D, 0.0D).tex(var2.getMaxU(), var2.getMaxV()), var3, var4, var5, var6).normal(0.0F, 1.0F, 0.0F).endVertex();
        Tessellator.getInstance().draw();
    }

    public int renderStackSize(int var1) {
        byte var2 = 1;
        if (var1 > 1) {
            var2 = 2;
        }

        if (var1 > 5) {
            var2 = 3;
        }

        if (var1 > 20) {
            var2 = 4;
        }

        if (var1 > 40) {
            var2 = 5;
        }

        return var2;
    }

    public void setupTransforms(int var1) {
        float var2;
        float var3;
        if (var1 > 0) {
            var2 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
            var3 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
            float var4 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
            GL11.glTranslatef(var2, var3, var4);
        }

        var2 = -Minecraft.getMinecraft().renderManager.playerViewX;
        var3 = 180.0F - Minecraft.getMinecraft().renderManager.playerViewY;
        GL11.glRotatef(var3, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(var2, 1.0F, 0.0F, 0.0F);
    }

    public boolean hasOverlays(ItemStack var1) {
        Item var2 = var1.getItem();
        return var2 instanceof ItemPotion || var2 instanceof ItemArmor && ((ItemArmor)var1.getItem()).material == ItemArmor.ArmorMaterial.LEATHER || var2 instanceof ItemMonsterPlacer || var2 instanceof ItemFireworkCharge;
    }

    public ResourceLocation getOverlayTexture(ItemStack var1) {
        if (this.hasOverlays(var1)) {
            Item var2 = var1.getItem();
            if (var2 instanceof ItemPotion) {
                return ItemPotion.isSplash(var1.getItemDamage()) ? SPLASH_POTION : DRINK_POTION;
            } else if (var2 instanceof ItemMonsterPlacer) {
                return SPAWN_EGG_OVERLAY;
            } else {
                return var2 instanceof ItemFireworkCharge ? FIREWORKS_CHARGE : LEATHER_ARMOR_OVERLAY.get(((ItemArmor)var2).armorType);
            }
        } else {
            return null;
        }
    }

    public WorldRenderer color(WorldRenderer var1, int var2, int var3, int var4, boolean var5) {
        if (var5) {
            var1.color(var2, var3, var4, 255);
        }

        return var1;
    }

    public float getScale(EntityItemBridge var1) {
        RenderEntityItemScaleEvent var2 = new RenderEntityItemScaleEvent(var1, true, false);
        EventBus.getInstance().call((Event)var2);
        return var2.llIlllIIIllllIIlllIllIIIl();
    }
}
