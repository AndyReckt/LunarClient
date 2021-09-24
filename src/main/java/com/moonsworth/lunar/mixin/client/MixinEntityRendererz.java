package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.EntityRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.RenderGlobalBridge;
import com.moonsworth.lunar.bridge.minecraft.client.shader.ShaderGroupBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.bridge.optifine.OptifineBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.entity.EntityRendererEvent;
import com.moonsworth.lunar.client.event.type.entity.EntityRendererSetAnglesEvent;
import com.moonsworth.lunar.client.event.type.gui.DrawScreenEvent;
import com.moonsworth.lunar.client.event.type.hud.FOVChangeEvent;
import com.moonsworth.lunar.client.event.type.hud.RenderHandEvent;
import com.moonsworth.lunar.client.event.type.render.RenderWorldPassEvent;
import com.moonsworth.lunar.client.event.type.world.ProfilerEndStartSectionEvent;
import com.moonsworth.lunar.client.profile.main.GeneralOptions;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.movement.MovementUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.entity.Entity;
import net.minecraft.profiler.Profiler;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(EntityRenderer.class)
public abstract class MixinEntityRendererz implements EntityRendererBridge {

    @Shadow
    private float fovModifierHandPrev;
    @Shadow
    private float fovModifierHand;
    @Shadow
    private Minecraft mc;
    @Shadow
    private double cameraZoom;
    public boolean getFOVModifierThreadLocal;

    @Shadow
    protected abstract void loadShader(ResourceLocation var1);

    @Shadow
    public abstract boolean isShaderActive();

    @Shadow
    public abstract ShaderGroup getShaderGroup();

    @Shadow
    public abstract void stopUseShader();

    @Override
    public void bridge$loadShader(ResourceLocationBridge var1) {
        this.loadShader((ResourceLocation) var1);
    }

    @Override
    public boolean bridge$isShaderActive() {
        return this.isShaderActive();
    }

    @Override
    public ShaderGroupBridge bridge$getShaderGroup() {
        return (ShaderGroupBridge) getShaderGroup();
    }

    @Override
    public void bridge$stopUseShader() {
        this.stopUseShader();
    }

    @Inject(method = "renderWorldPass", at = @At(value = "CONSTANT", args = "stringValue=hand"))
    public void impl$renderWorldPass(int var1, float var2, long var3, CallbackInfo var5) {
        Minecraft.getMinecraft().mcProfiler.endStartSection("event3d");
        EventBus.getInstance().call(new RenderWorldPassEvent(var2));
        Minecraft.getMinecraft().mcProfiler.endStartSection("hand");
    }

    @Redirect(method = "hurtCameraEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/MathHelper;sin(F)F"))
    public float impl$sin(float var1) {
        float n2 = (float) Math.sqrt(Math.sqrt(var1 / Math.PI));
        if (Ref.getLC().lllllIllIllIllllIlIllllII().IlllllIlIIIlIIlIIllIIlIll().lIIlIIIIIIlIIlIIllIlIIlII().isLegacy()) {
            n2 /= 1.15f;
        }
        return MathHelper.cos((float) (n2 * n2 * n2 * n2 * Math.PI));
    }

    @ModifyVariable(method = "getFOVModifier(FZ)F", at = @At(value = "HEAD"), argsOnly = true, ordinal = 0)
    public boolean impl$getFovModifier$modifyArg2(boolean var1) {
        this.getFOVModifierThreadLocal = var1;
        return false;
    }

    @Inject(method = "getFOVModifier", at = @At(value = "RETURN", ordinal = 0), cancellable = true)
    public void getZoomLevel(float var1, boolean var2, CallbackInfoReturnable<Float> var3) {
        final FOVChangeEvent fovChangeEvent = new FOVChangeEvent(FOVChangeEvent.Result.RETURN, var3.getReturnValue(), var1, 0.0f, 0.0f);
        EventBus.getInstance().call(fovChangeEvent);
        if (fovChangeEvent.isCancelled() || fovChangeEvent.IlllIIIIIIlllIlIIlllIlIIl() != var3.getReturnValue()) {
            var3.setReturnValue(fovChangeEvent.IlllIIIIIIlllIlIIlllIlIIl());
        }
    }

    @ModifyConstant(method = "getFOVModifier(FZ)F", constant = @Constant(floatValue = 70.0f, ordinal = 0))
    public float impl$fovModifierRedirect(float var1, float var2, boolean var3) {
        float illlIIIIIIlllIlIIlllIlIIl = var1;
        if (this.getFOVModifierThreadLocal) {
            final FOVChangeEvent fovChangeEvent = new FOVChangeEvent(FOVChangeEvent.Result.CONSTANT, this.mc.gameSettings.fovSetting, var2, this.fovModifierHandPrev, this.fovModifierHand);
            EventBus.getInstance().call(fovChangeEvent);
            illlIIIIIIlllIlIIlllIlIIl = fovChangeEvent.IlllIIIIIIlllIlIIlllIlIIl();
            if (!fovChangeEvent.isCancelled()) {
                final Optional<OptifineBridge> lIllIlIIIlIIIIIIIlllIlIll = Bridge.lIllIlIIIlIIIIIIIlllIlIll();
                if (lIllIlIIIlIIIIIIIlllIlIll.isPresent() && lIllIlIIIlIIIIIIIlllIlIll.get().getConfig().hasDynamicFov()) {
                    illlIIIIIIlllIlIIlllIlIIl *= this.fovModifierHandPrev + (this.fovModifierHand - this.fovModifierHandPrev) * var2;
                }
            }
        }
        return illlIIIIIIlllIlIIlllIlIIl;
    }

    @Redirect(method = "renderWorld", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityPlayerSP;setAngles(FF)V"))
    public void impl$setAngles(EntityPlayerSP var1, float var2, float var3) {
        EventBus.getInstance().call(new EntityRendererSetAnglesEvent(var2, var3));
        if (!Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlIIlIIlIIlIIllIIIllIIllI()) {
            var1.setAngles(var2, var3);
        }
    }

    @Redirect(method = "orientCamera", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/Entity;prevRotationYaw:F"))
    public float impl$prevRotationYaw(Entity entity) {
        final EntityRendererEvent.lIlIlIlIlIIlIIlIIllIIIIIl lIlIlIlIlIIlIIlIIllIIIIIl = new EntityRendererEvent.lIlIlIlIlIIlIIlIIllIIIIIl(this, (EntityBridge) entity, null, 0.0, entity.prevRotationYaw, entity.prevRotationPitch, 0.0f);
        EventBus.getInstance().call(lIlIlIlIlIIlIIlIIllIIIIIl);
        GlStateManager.rotate(lIlIlIlIlIIlIIlIIllIIIIIl.llIIIIIIIllIIllIlIllIIIIl(), 0.0f, 0.0f, 1.0f);
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlIIlIIlIIlIIllIIIllIIllI()) {
            return Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().lIlIlIIIIIIllIlIIIIllIIII();
        }
        return entity.prevRotationYaw;
    }

    @Redirect(method = "orientCamera", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/Entity;rotationYaw:F"))
    public float impl$rotationYaw(Entity entity) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlIIlIIlIIlIIllIIIllIIllI()) {
            return Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().lIlIlIIIIIIllIlIIIIllIIII();
        }
        return entity.rotationYaw;
    }

    @Redirect(method = "orientCamera", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/Entity;prevRotationPitch:F"))
    public float impl$prevRotationPitch(Entity entity) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlIIlIIlIIlIIllIIIllIIllI()) {
            return Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().lIIlIIIIIIlIIlIIllIlIIlII();
        }
        return entity.prevRotationPitch;
    }

    @Redirect(method = "orientCamera", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/Entity;rotationPitch:F"))
    public float impl$rotationPitch(Entity entity) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlIIlIIlIIlIIllIIIllIIllI()) {
            return Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().lIIlIIIIIIlIIlIIllIlIIlII();
        }
        return entity.rotationPitch;
    }

    @Redirect(method = "renderWorldPass", at = @At(value = "INVOKE", target = "Lnet/minecraft/profiler/Profiler;endStartSection(Ljava/lang/String;)V"))
    public void impl$onProfilerEndStartSection(Profiler profiler, String s, int var3, float var4, long var5) {
        if (s.equals("hand")) {
            LunarClient.EVENT_BUS.call(new ProfilerEndStartSectionEvent((RenderGlobalBridge) this.mc.renderGlobal, var4));
        }
        profiler.endStartSection(s);
    }

    @Redirect(method = "renderWorldPass", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/EntityRenderer;renderHand:Z"))
    public boolean impl$onRenderHand(EntityRenderer entityRenderer, int var2, float var3, long var4) {
        final RenderHandEvent renderHandEvent;
        LunarClient.EVENT_BUS.call(renderHandEvent = new RenderHandEvent((RenderGlobalBridge) this.mc.renderGlobal, var3, var2));
        return entityRenderer.renderHand && !renderHandEvent.isCancelled();
    }

    @Redirect(method = "updateCameraAndRender", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiScreen;drawScreen(IIF)V"))
    public void impl$updateCameraAndRender$drawScreen(GuiScreen guiScreen, int n, int n2, float n3) {
        guiScreen.drawScreen(n, n2, n3);
        EventBus.getInstance().call(new DrawScreenEvent(n, n2, n3));
    }

    @Inject(method = "updateCameraAndRender", at = @At("RETURN"))
    public void impl$onUpdateCameraRender(CallbackInfo var1) {
        final float liIlIlllIlIlIIIlllIIlIIII = AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII();
        GlStateManager.pushAttrib(); // todo
        if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SomeScaleFactorShit
                .OFF) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(liIlIlllIlIlIIIlllIIlIIII, liIlIlllIlIlIIIlllIIlIIII, liIlIlllIlIlIIIlllIIlIIII);
        }
        if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SomeScaleFactorShit.MODS && Ref.getMinecraft().bridge$getCurrentScreen() != null && Ref.llIIIlllIIlllIllllIlIllIl() != MovementUI.class && Ref.llIIIlllIIlllIllllIlIllIl() != GuiChat.class) {
            final float llIllIlIllIlllIllIIIIllII = AbstractUIScreen.llIllIlIllIlllIllIIIIllII();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(llIllIlIllIlllIllIIIIllII, llIllIlIllIlllIllIIIIllII, llIllIlIllIlllIllIIIIllII);
        }
        LunarClient.getInstance().lIIlllIIIIIlllIIIlIlIlllI().IlllIIIIIIlllIlIIlllIlIIl();
        GlStateManager.popAttrib(); // todo
    }
}