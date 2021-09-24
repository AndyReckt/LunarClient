package com.moonsworth.lunar.client.feature.type.itemphysics;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.item.EntityItemBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.ItemModelMesherBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.block.model.ItemCameraTransformsBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.IBakedModelBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.bridge.minecraft.util.Vector3f;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.Event;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.entity.render.RenderEntityItemEvent;
import com.moonsworth.lunar.client.event.type.hud.RenderEntityItemScaleEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.NumberSetting;
import org.lwjgl.opengl.GL11;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ItemPhysicsMod extends ConfigurableFeature {
    public long llllIIlIIlIIlIIllIIlIIllI;
    public double IlIlIlllllIlIIlIlIlllIlIl;
    public final Random llIIIIIIIllIIllIlIllIIIIl = new Random();
    public NumberSetting lIIIllIllIIllIlllIlIIlllI;

    public ItemPhysicsMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, (var1) -> {
            this.llllIIlIIlIIlIIllIIlIIllI = System.nanoTime();
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderEntityItemEvent.class, this::lIllIlIIIlIIIIIIIlllIlIll);
    }

    public ResourceLocationBridge IlIllIIlIIlIIIllIllllIIll() {
        return this.mc.bridge$getTextureMap().bridge$getBlockTextures();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderEntityItemEvent var1) {
        if (!var1.lIIIllIllIIllIlllIlIIlllI()) {
            if (var1.llIlllIIIllllIIlllIllIIIl() != null) {
                var1.setCancelled(true);
                MatrixStackBridge var2 = var1.lIllIlIIIlIIIIIIIlllIlIll();
                var2.lIllIlIIIlIIIIIIIlllIlIll();
                EntityItemBridge var3 = var1.llIlllIIIllllIIlllIllIIIl();
                ItemStackBridge var4 = var1.llIlllIIIllllIIlllIllIIIl().bridge$getItem();
                int var5 = var4 != null && var4.bridge$getItem() != null ? Bridge.llIlIIIllIIlIllIllIllllIl().bridge$getItemID(var4.bridge$getItem()) + var4.bridge$getItemDamage() : 187;
                this.llIIIIIIIllIIllIlIllIIIIl.setSeed(var5);
                IBakedModelBridge var6 = Ref.getMinecraft().bridge$getItemRenderer().lIlIlIlIlIIlIIlIIllIIIIIl(var4, var1.llIlllIIIllllIIlllIllIIIl().bridge$getWorld(), null);
                boolean var7 = var6.bridge$isGui3D();
                int var8 = this.lIlIlIlIlIIlIIlIIllIIIIIl(var4);
                this.IlIlIlllllIlIIlIlIlllIlIl = (double)(System.nanoTime() - this.llllIIlIIlIIlIIllIIlIIllI) / 2500000.0D * (double)((Float)this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() / 100.0F);
                if (!this.mc.bridge$hasInGameFocus()) {
                    this.IlIlIlllllIlIIlIlIlllIlIl = 0.0D;
                }

                var2.lIlIlIlIlIIlIIlIIllIIIIIl(Vector3f.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(1.5707964F));
                var2.lIlIlIlIlIIlIIlIIllIIIIIl(Vector3f.IlIlIlllllIlIIlIlIlllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl((float)var1.llIlllIIIllllIIlllIllIIIl().bridge$getRotationYaw()));
                if (var7 || Ref.getMinecraft().bridge$getRenderManager() != null) {
                    if (var7) {
                        if (!var3.bridge$isOnGround()) {
                            var3.bridge$setRotationPitch(var3.bridge$getRotationPitch() + this.IlIlIlllllIlIIlIlIlllIlIl);
                        }
                    } else if (var3 != null && !Double.isNaN(var3.bridge$getPosX()) && !Double.isNaN(var3.bridge$getPosY()) && !Double.isNaN(var3.bridge$getPosZ()) && var1.llIlllIIIllllIIlllIllIIIl().bridge$getWorld() != null) {
                        if (var3.bridge$isOnGround()) {
                            var3.bridge$setRotationPitch(0.0D);
                        } else {
                            var3.bridge$setRotationPitch(var3.bridge$getRotationPitch() + this.IlIlIlllllIlIIlIlIlllIlIl);
                        }
                    }

                    if (var7) {
                        var2.lIlIlIlIlIIlIIlIIllIIIIIl(0.0D, -0.2D, -0.08D);
                    } else if (var3 != null && var3.bridge$getWorld() != null && var3.bridge$getWorld().bridge$getBlockAt(var3.bridge$getPosX(), var3.bridge$getPosY(), var3.bridge$getPosZ()) == Bridge.IllIllIIIllIIIlIlIlIIIIll().bridge$snow()) {
                        var2.lIlIlIlIlIIlIIlIIllIIIIIl(0.0D, 0.0D, -0.14D);
                    } else {
                        var2.lIlIlIlIlIIlIIlIIllIIIIIl(0.0D, 0.0D, -0.04D);
                    }

                    double var9 = 0.2D;
                    if (var7) {
                        var2.lIlIlIlIlIIlIIlIIllIIIIIl(0.0D, var9, 0.0D);
                    }

                    var2.lIlIlIlIlIIlIIlIIllIIIIIl(Vector3f.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl((float)var3.bridge$getRotationPitch()));
                    if (var7) {
                        var2.lIlIlIlIlIIlIIlIIllIIIIIl(0.0D, -var9, 0.0D);
                    }
                }

                float var10;
                float var11;
                if (!var7) {
                    float var13 = -0.0F;
                    var10 = -0.0F;
                    var11 = -0.0F;
                    var2.lIlIlIlIlIIlIIlIIllIIIIIl(var13, var10, (double)var11);
                }

                for(int var14 = 0; var14 < var8; ++var14) {
                    var2.lIllIlIIIlIIIIIIIlllIlIll();
                    if (var14 > 0 && var7) {
                        var10 = (this.llIIIIIIIllIIllIlIllIIIIl.nextFloat() * 2.0F - 1.0F) * 0.15F;
                        var11 = (this.llIIIIIIIllIIllIlIllIIIIl.nextFloat() * 2.0F - 1.0F) * 0.15F;
                        float var12 = (this.llIIIIIIIllIIllIlIllIIIIl.nextFloat() * 2.0F - 1.0F) * 0.15F;
                        var2.lIlIlIlIlIIlIIlIIllIIIIIl(var10, var11, (double)var12);
                    }

                    RenderEntityItemScaleEvent var15;
                    EventBus.getInstance().call((Event)(var15 = new RenderEntityItemScaleEvent(var3, true, false)));
                    var2.lIlIlIlIlIIlIIlIIllIIIIIl(var15.llIlllIIIllllIIlllIllIIIl(), var15.llIlllIIIllllIIlllIllIIIl(), var15.llIlllIIIllllIIlllIllIIIl());
                    Ref.getMinecraft().bridge$getItemRenderer().lIlIlIlIlIIlIIlIIllIIIIIl(var4, ItemCameraTransformsBridge.lIlIlIlIlIIlIIlIIllIIIIIl.lIIIllIllIIllIlllIlIIlllI, false, var2, var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIlIlIlIlIIlIIlIIllIIIIIl(), 655360, var6);
                    var2.IlllIIIIIIlllIlIIlllIlIIl();
                    if (!var7) {
                        var2.lIlIlIlIlIIlIIlIIllIIIIIl(0.0D, 0.0D, 0.05375000089406967D);
                    }
                }

                var2.IlllIIIIIIlllIlIIlllIlIIl();
            }
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderEntityItemEvent var1) {
        if (!var1.lIIIllIllIIllIlllIlIIlllI()) {
            if (var1.llIlllIIIllllIIlllIllIIIl() != null) {
                var1.setCancelled(true);
                this.IlIlIlllllIlIIlIlIlllIlIl = (double)(System.nanoTime() - this.llllIIlIIlIIlIIllIIlIIllI) / 2500000.0D * (double)((Float)this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() / 10.0F);
                if (!this.mc.bridge$hasInGameFocus()) {
                    this.IlIlIlllllIlIIlIlIlllIlIl = 0.0D;
                }

                GlStateManagerBridge var2 = Bridge.llIIIIIIIllIIllIlIllIIIIl();
                if (var1.llIlllIIIllllIIlllIllIIIl().bridge$getItem().bridge$getItem().bridge$isItemBlock()) {
                    this.mc.bridge$getTextureManager().bridge$bindTexture(this.mc.bridge$getTextureMap().bridge$getBlockTextures());
                } else {
                    this.mc.bridge$getTextureManager().bridge$bindTexture(this.mc.bridge$getTextureMap().bridge$getItemTextures());
                }

                var2.bridge$enableRescaleNormal();
                var2.bridge$alphaFunc(516, 0.1F);
                var2.bridge$enableBlend();
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableStandardItemLighting();
                var2.bridge$tryBlendFuncSeparate(770, 771, 1, 0);
                var2.bridge$pushMatrix();
                EntityItemBridge var3 = var1.llIlllIIIllllIIlllIllIIIl();
                ItemStackBridge var4 = var1.llIlllIIIllllIIlllIllIIIl().bridge$getItem();
                int var5 = var4 != null && var4.bridge$getItem() != null ? Bridge.llIlIIIllIIlIllIllIllllIl().bridge$getItemID(var4.bridge$getItem()) + var4.bridge$getItemDamage() : 187;
                this.llIIIIIIIllIIllIlIllIIIIl.setSeed(var5);
                this.lIlIlIlIlIIlIIlIIllIIIIIl(var4);
                var2.bridge$translate((float)var1.llllIIlIIlIIlIIllIIlIIllI(), (float)var1.IlIlIlllllIlIIlIlIlllIlIl() - 0.15F, (float)var1.llIIIIIIIllIIllIlIllIIIIl());
                GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef((float)var3.bridge$getRotationYaw(), 0.0F, 0.0F, 1.0F);
                var2.bridge$translate(0.0F, 0.0F, -0.04F);
                if (this.mc.bridge$getRenderManager() != null) {
                    if (!Double.isNaN(var3.bridge$getPosX()) && !Double.isNaN(var3.bridge$getPosY()) && !Double.isNaN(var3.bridge$getPosZ()) && var3.bridge$getWorld() != null) {
                        if (var3.bridge$isOnGround()) {
                            var3.bridge$setRotationPitch(0.0D);
                        } else {
                            double var7 = this.IlIlIlllllIlIIlIlIlllIlIl * 2.0D;
                            var3.bridge$setRotationPitch(var3.bridge$getRotationPitch() + var7);
                        }
                    }

                    var2.bridge$rotate((float)var3.bridge$getRotationPitch(), 1.0F, 0.0F, 0.0F);
                }

                var2.bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
                var2.bridge$pushMatrix();
                if (var3.bridge$getItem().bridge$getItem().bridge$isItemBlock()) {
                    var2.bridge$scale(0.30000001192092896D, 0.30000001192092896D, 0.30000001192092896D);
                } else {
                    var2.bridge$scale(0.5D, 0.5D, 0.5D);
                }

                int var17 = this.lIlIlIlIlIIlIIlIIllIIIIIl(var4);
                int var8 = var3.bridge$getItem().bridge$getStackSize();

                try {
                    var3.bridge$getItem().bridge$setStackSize(1);

                    for(int var9 = 0; var9 < var17; ++var9) {
                        if (var9 > 0) {
                            float var11 = (this.llIIIIIIIllIIllIlIllIIIIl.nextFloat() * 2.0F - 1.0F) * 0.15F;
                            float var12 = (this.llIIIIIIIllIIllIlIllIIIIl.nextFloat() * 2.0F - 1.0F) * 0.15F;
                            float var13 = (this.llIIIIIIIllIIllIlIllIIIIl.nextFloat() * 2.0F - 1.0F) * 0.15F;
                            var2.bridge$translate(var11, var12, var13);
                        }

                        for(int index = 0; index < (var4.bridge$getItem().lIlIlIlIlIIlIIlIIllIIIIIl() ? 2 : 1); ++index) {
                            int finalIndex = index;
                            var4.bridge$getItem().lIlIlIlIlIIlIIlIIllIIIIIl(var4, index).ifPresent((var6) -> {
                                var2.bridge$pushMatrix();
                                int var7 = var4.bridge$getItem().bridge$getColorFromItemStack(var4, finalIndex);
                                float r = (float)(var7 >> 16 & 255) / 255.0F;
                                float g = (float)(var7 >> 8 & 255) / 255.0F;
                                float b = (float)(var7 & 255) / 255.0F;
                                var2.bridge$color(r, g, b, 1.0F);
                                boolean var11 = Ref.getMinecraft().bridge$getGameSettings().bridge$isFancyGraphics();
                                if (!var11) {
                                    Ref.getMinecraft().bridge$getGameSettings().bridge$setFancyGraphics(true);
                                }

                                EventBus.getInstance().call((Event)(new RenderEntityItemScaleEvent(var1.llIlllIIIllllIIlllIllIIIl())));
                                Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getRenderItem().lIlIlIlIlIIlIIlIIllIIIIIl(var3, var6, 1, (float)this.IlIlIlllllIlIIlIlIlllIlIl, r, g, b);
                                if (!var11) {
                                    Ref.getMinecraft().bridge$getGameSettings().bridge$setFancyGraphics(false);
                                }

                                var2.bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
                                var2.bridge$popMatrix();
                            });
                        }
                    }
                } finally {
                    var3.bridge$getItem().bridge$setStackSize(var8);
                }

                var2.bridge$popMatrix();
                var2.bridge$translate(0.0F, 0.0F, 0.05375F);
                var2.bridge$popMatrix();
                var2.bridge$disableRescaleNormal();
                var2.bridge$disableBlend();
            }
        }
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(RenderEntityItemEvent var1) {
        if (Bridge.getMinecraftVersion() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl) {
            this.IlllIIIIIIlllIlIIlllIlIIl(var1);
        } else if (Bridge.getMinecraftVersion().lIllIlIIIlIIIIIIIlllIlIll()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(var1);
        } else {
            var1.setCancelled(true);
            this.IlIlIlllllIlIIlIlIlllIlIl = (double)(System.nanoTime() - this.llllIIlIIlIIlIIllIIlIIllI) / 2500000.0D * (double)((Float)this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() / 10.0F);
            if (!this.mc.bridge$hasInGameFocus()) {
                this.IlIlIlllllIlIIlIlIlllIlIl = 0.0D;
            }

            EntityItemBridge var2 = var1.llIlllIIIllllIIlllIllIIIl();
            ItemStackBridge var3 = var2.bridge$getItem();
            int var4 = var3 != null && var3.bridge$getItem() != null ? Bridge.llIlIIIllIIlIllIllIllllIl().bridge$getItemID(var3.bridge$getItem()) + var3.bridge$getItemDamage() : 187;
            this.llIIIIIIIllIIllIlIllIIIIl.setSeed(var4);
            GlStateManagerBridge var5 = Bridge.llIIIIIIIllIIllIlIllIIIIl();
            this.mc.bridge$getTextureManager().bridge$bindTexture(this.IlIllIIlIIlIIIllIllllIIll());
            var5.bridge$enableRescaleNormal();
            var5.bridge$alphaFunc(516, 0.1F);
            var5.bridge$enableBlend();
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableStandardItemLighting();
            var5.bridge$tryBlendFuncSeparate(770, 771, 1, 0);
            var5.bridge$pushMatrix();
            Optional<ItemModelMesherBridge> var6 = this.mc.bridge$getRenderItem().bridge$getItemModelShaper();
            if (var6.isPresent()) {
                IBakedModelBridge var7 = var6.get().bridge$getItemModel(var3);
                boolean var8 = var7.bridge$isGui3D();
                boolean var9 = var7.bridge$isGui3D();
                int var10 = this.lIlIlIlIlIIlIIlIIllIIIIIl(var3);
                var5.bridge$translate((float)var1.llllIIlIIlIIlIIllIIlIIllI(), (float)var1.IlIlIlllllIlIIlIlIlllIlIl(), (float)var1.llIIIIIIIllIIllIlIllIIIIl());
                if (Bridge.getMinecraftVersion() != MinecraftVersion.lIllIlIIIlIIIIIIIlllIlIll && var7.bridge$isGui3D()) {
                    var5.bridge$scale(0.5D, 0.5D, 0.5D);
                }

                GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef((float)var2.bridge$getRotationYaw(), 0.0F, 0.0F, 1.0F);
                var5.bridge$translate(0.0F, 0.0F, var9 ? -0.08F : -0.04F);
                if (var9 || this.mc.bridge$getRenderManager() != null) {
                    double var11;
                    if (var9) {
                        if (!var2.bridge$isOnGround()) {
                            var11 = this.IlIlIlllllIlIIlIlIlllIlIl * 2.0D;
                            var2.bridge$setRotationPitch(var2.bridge$getRotationPitch() + var11);
                        }
                    } else if (!Double.isNaN(var2.bridge$getPosX()) && !Double.isNaN(var2.bridge$getPosY()) && !Double.isNaN(var2.bridge$getPosZ()) && var2.bridge$getWorld() != null) {
                        if (var2.bridge$isOnGround()) {
                            var2.bridge$setRotationPitch(0.0D);
                        } else {
                            var11 = this.IlIlIlllllIlIIlIlIlllIlIl * 2.0D;
                            var2.bridge$setRotationPitch(var2.bridge$getRotationPitch() + var11);
                        }
                    }

                    var5.bridge$rotate((float)var2.bridge$getRotationPitch(), 1.0F, 0.0F, 0.0F);
                }

                var5.bridge$color(1.0F, 1.0F, 1.0F, 1.0F);

                for(int var15 = 0; var15 < var10; ++var15) {
                    var5.bridge$pushMatrix();
                    if (var8) {
                        if (var15 > 0) {
                            float var12 = (this.llIIIIIIIllIIllIlIllIIIIl.nextFloat() * 2.0F - 1.0F) * 0.15F;
                            float var13 = (this.llIIIIIIIllIIllIlIllIIIIl.nextFloat() * 2.0F - 1.0F) * 0.15F;
                            float var14 = (this.llIIIIIIIllIIllIlIllIIIIl.nextFloat() * 2.0F - 1.0F) * 0.15F;
                            var5.bridge$translate(var12, var13, var14);
                        }

                        EventBus.getInstance().call((Event)(new RenderEntityItemScaleEvent(var1.llIlllIIIllllIIlllIllIIIl())));
                        var7.bridge$getItemCameraTransforms().bridge$applyTransform(ItemCameraTransformsBridge.lIlIlIlIlIIlIIlIIllIIIIIl.lIIIllIllIIllIlllIlIIlllI);
                        this.mc.bridge$getRenderItem().bridge$renderItem(var3, var7);
                        var5.bridge$popMatrix();
                    } else {
                        EventBus.getInstance().call((Event)(new RenderEntityItemScaleEvent(var1.llIlllIIIllllIIlllIllIIIl())));
                        var7.bridge$getItemCameraTransforms().bridge$applyTransform(ItemCameraTransformsBridge.lIlIlIlIlIIlIIlIIllIIIIIl.lIIIllIllIIllIlllIlIIlllI);
                        this.mc.bridge$getRenderItem().bridge$renderItem(var3, var7);
                        var5.bridge$popMatrix();
                        var5.bridge$translate(0.0F, 0.0F, 0.05375F);
                    }
                }

                var5.bridge$popMatrix();
                var5.bridge$disableRescaleNormal();
                var5.bridge$disableBlend();
                this.mc.bridge$getTextureManager().bridge$bindTexture(this.IlIllIIlIIlIIIllIllllIIll());
            }
        }
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl(ItemStackBridge var1) {
        byte var2 = 1;
        if (var1 == null) {
            return 0;
        } else {
            if (var1.bridge$getStackSize() > 48) {
                var2 = 5;
            } else if (var1.bridge$getStackSize() > 32) {
                var2 = 4;
            } else if (var1.bridge$getStackSize() > 16) {
                var2 = 3;
            } else if (var1.bridge$getStackSize() > 1) {
                var2 = 2;
            }

            return var2;
        }
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.lIIIllIllIIllIlllIlIIlllI = new NumberSetting("rotationSpeed", 0.5F, 0.1F, 1.0F));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Item Physics", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("itemPhysic", ImmutableList.of(ModuleCategory.ALL));
    }
}
