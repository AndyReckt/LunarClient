package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RendererLivingEntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers.CustomLayer;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers.LayerCapeBridge;
import com.moonsworth.lunar.client.bridge.impl.type.util.CustomLayerRendererWrapper;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.entity.SetRenderLivingBrightnessEvent;
import com.moonsworth.lunar.client.event.type.hud.RenderNameEvent;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.NameLine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

@Mixin(RendererLivingEntity.class)
public abstract class MixinRendererLivingEntityz<T extends EntityLivingBase> extends Render<T> implements RendererLivingEntityBridge {
    public final Pattern pattern = Pattern.compile("\\<[0-9]*\\>.*\\<\\>");

    @Shadow
    protected boolean renderOutlines;
    @Shadow
    protected FloatBuffer brightnessBuffer;
    @Shadow
    private static DynamicTexture textureBrightness;
    @Shadow
    protected List<LayerRenderer<T>> layerRenderers;

    public LayerRenderer<T> layerCape;

    public MixinRendererLivingEntityz(RenderManager var1) {
        super(var1);
    }

    //@Shadow
    //public abstract void renderName(EntityLivingBase var1, double var2, double var4, double var6);

    @Shadow
    public abstract int getColorMultiplier(EntityLivingBase var1, float var2, float var3);

    @Shadow
    public abstract boolean addLayer(LayerRenderer var1);

    @Shadow
    public abstract float interpolateRotation(float var1, float var2, float var3);

    // @Shadow protected abstract boolean setBrightness(EntityLivingBase entitylivingbaseIn, float partialTicks, boolean combineTextures);


    @Overwrite
    public void renderName(final EntityLivingBase entityLivingBase, final double n, final double n2, final double n3) {
        final LinkedList<NameLine> list = new LinkedList<>();
        list.add(0, new NameLine(entityLivingBase.getDisplayName().getFormattedText()));
        final RenderNameEvent renderNameEvent = new RenderNameEvent((EntityLivingBaseBridge) entityLivingBase, entityLivingBase.getName(), n, n2, n3, list);
        EventBus.getInstance().call(renderNameEvent);                                                                                                                                                                                                                                 // d()
        if (!renderNameEvent.isCancelled() && (this.canRenderName((T) entityLivingBase) || (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IIlIllIlIIllIIlIlIllllllI().llIlllIIIllllIIlllIllIIIl() && entityLivingBase == Minecraft.getMinecraft().thePlayer && !entityLivingBase.isSneaking()))) {
            int n4 = 0;
            for (final NameLine nameLine : renderNameEvent.IlIlIlllllIlIIlIlIlllIlIl()) {
                final double n5 = renderNameEvent.llIlllIIIllllIIlllIllIIIl() + n4 / 3.5f - (entityLivingBase.isChild() ? (entityLivingBase.height / 2.0f) : 0.0);
                if (entityLivingBase.isRiding()) {
                    this.impl$renderLabelSneaking(nameLine, n, n5 + entityLivingBase.height + 0.22499999403953552, n3);
                } else if (this.impl$renderLivingLabel(entityLivingBase, nameLine, renderNameEvent.lIllIlIIIlIIIIIIIlllIlIll(), n5, renderNameEvent.llllIIlIIlIIlIIllIIlIIllI(), entityLivingBase.isRiding() ? 32 : 64) != n5) {
                    ++n4;
                }
                ++n4;
            }
        }
    }

    public void impl$renderLabelSneaking(NameLine var1, double var2, double var4, double var6) {
    }

    public double impl$renderLivingLabel(EntityLivingBase var1, NameLine var2, double var3, double var5, double var7, int var9) {
        return 0;
    }

    public void impl$onShouldShowName(EntityLivingBase var1, CallbackInfoReturnable var2) {

    }

    @Overwrite
    public boolean setBrightness(EntityLivingBase entityLivingBase, float n, boolean b) {
        final int colorMultiplier = this.getColorMultiplier(entityLivingBase, entityLivingBase.getBrightness(n), n);
        final boolean b2 = (colorMultiplier >> 24 & 0xFF) > 0;
        final boolean b3 = entityLivingBase.hurtTime > 0 || entityLivingBase.deathTime > 0;
        if (!b2 && !b3) {
            return false;
        }
        if (!b2 && !b) {
            return false;
        }
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.disableColorMaterial();
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.defaultTexUnit);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PRIMARY_COLOR);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.defaultTexUnit);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableColorMaterial();
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, OpenGlHelper.GL_INTERPOLATE);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.GL_CONSTANT);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE2_RGB, OpenGlHelper.GL_CONSTANT);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND2_RGB, 770);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.GL_PREVIOUS);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        this.brightnessBuffer.position(0);
        if (b3) {
            final SetRenderLivingBrightnessEvent setRenderLivingBrightnessEvent;
            EventBus.getInstance().call(setRenderLivingBrightnessEvent = new SetRenderLivingBrightnessEvent(1.0f, 0.0f, 0.0f, 0.3f));
            this.brightnessBuffer.put(setRenderLivingBrightnessEvent.lIlIlIlIlIIlIIlIIllIIIIIl());
            this.brightnessBuffer.put(setRenderLivingBrightnessEvent.IlllIIIIIIlllIlIIlllIlIIl());
            this.brightnessBuffer.put(setRenderLivingBrightnessEvent.lIllIlIIIlIIIIIIIlllIlIll());
            this.brightnessBuffer.put(setRenderLivingBrightnessEvent.llIlllIIIllllIIlllIllIIIl());
        } else {
            final float n2 = (colorMultiplier >> 24 & 0xFF) / 255.0f;
            final float n3 = (colorMultiplier >> 16 & 0xFF) / 255.0f;
            final float n4 = (colorMultiplier >> 8 & 0xFF) / 255.0f;
            final float n5 = (colorMultiplier & 0xFF) / 255.0f;
            this.brightnessBuffer.put(n3);
            this.brightnessBuffer.put(n4);
            this.brightnessBuffer.put(n5);
            this.brightnessBuffer.put(1.0f - n2);
        }
        this.brightnessBuffer.flip();
        GL11.glTexEnv(8960, 8705, this.brightnessBuffer);
        GlStateManager.setActiveTexture(OpenGlHelper.GL_TEXTURE2);
        GlStateManager.disableColorMaterial();
        GlStateManager.shadeModel(textureBrightness.getGlTextureId());
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.GL_PREVIOUS);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.lightmapTexUnit);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.GL_PREVIOUS);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        return true;
    }

    public void bridge$addLayer(CustomLayer var1, boolean var2) {
        if ((Render) this instanceof RenderPlayer) {
            this.addLayer(new CustomLayerRendererWrapper(var1, (RenderPlayer) (Render<AbstractClientPlayer>) this));
        }
    }

    public LayerCapeBridge bridge$getLayerCape() {
        if (this.layerCape != null) {
            return (LayerCapeBridge)this.layerCape;
        }
        for (final LayerRenderer<T> layerRenderer : this.layerRenderers) {
            if (layerRenderer instanceof LayerCapeBridge) {
                final LayerCapeBridge layerCape = (LayerCapeBridge)layerRenderer;
                this.layerCape = (LayerRenderer)layerCape;
                return layerCape;
            }
        }
        return null;
    }

//    // $FF: synthetic method
//    public static int lambda$impl$renderLivingLabel$2(FontRenderer var0, NameLine.NameLineData var1) {
//    }
//
//    // $FF: synthetic method
//    public static boolean lambda$impl$renderLivingLabel$1(EntityLivingBase var0, NameLine.NameLineData var1) {
//    }
//
//    // $FF: synthetic method
//    public static int lambda$impl$renderLabelSneaking$0(FontRenderer var0, NameLine.NameLineData var1) {
//    }
}
