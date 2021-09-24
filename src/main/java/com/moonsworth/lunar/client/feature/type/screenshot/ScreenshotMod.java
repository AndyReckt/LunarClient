package com.moonsworth.lunar.client.feature.type.screenshot;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.shader.FramebufferBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.state.KeyState;
import com.moonsworth.lunar.client.event.type.chat.OutgoingChatEvent;
import com.moonsworth.lunar.client.event.type.input.KeyPressEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.*;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import java.io.File;
import java.nio.IntBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ScreenshotMod extends ConfigurableFeature {
    public BooleanSetting llllIIlIIlIIlIIllIIlIIllI;
    public BooleanSetting IlIlIlllllIlIIlIlIlllIlIl;
    public BooleanSetting llIIIIIIIllIIllIlIllIIIIl;
    public BooleanSetting lIIIllIllIIllIlllIlIIlllI;
    public IntBuffer llIIlIlIIIllIlIlIlIIlIIll;
    public int[] llIIIlllIIlllIllllIlIllIl;
    public final String IlllllIlIIIlIIlIIllIIlIll = "/lc_upload_screenshot";
    public static final DateFormat lllIIIIIlllIIlIllIIlIIIlI = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");

    public ScreenshotMod() {
        super(true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyPressEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(OutgoingChatEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(OutgoingChatEvent var1) {
        boolean var2 = var1.lIlIlIlIlIIlIIlIIllIIIIIl("/lc_upload_screenshot_tweet");
        boolean var3 = var1.lIlIlIlIlIIlIIlIIllIIIIIl("/lc_upload_screenshot_copy");
        if (var1.lIlIlIlIlIIlIIlIIllIIIIIl("/lc_upload_screenshot") || var2 || var3) {
            var1.cancel();
            String var4 = var1.lIlIlIlIlIIlIIlIIllIIIIIl();
            File var5 = new File(this.mc.bridge$getMcDataDir() + File.separator + "screenshots" + File.separator + var4);
            if (var5.exists()) {
                (new ScreenshotUploadThread(var5, var2, var3)).start();
            }
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(KeyPressEvent var1) {
        MinecraftBridge var2 = Ref.getMinecraft();
        boolean var3 = true;
        if (!LunarClient.getInstance().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll() && var1.IlllIIIIIIlllIlIIlllIlIIl() == KeyState.DOWN && var1.lIlIlIlIlIIlIIlIIllIIIIIl() == Ref.getMinecraft().bridge$getGameSettings().bridge$getScreenshotKey()) {
            var1.cancel();
            this.lIlIlIlIlIIlIIlIIllIIIIIl(var2.bridge$getMcDataDir(), var2.bridge$displayWidth(), var2.bridge$displayHeight(), var2.bridge$getFramebuffer());
            LunarLogger.debug("Screenshot taken");
        }

    }

    public static File lIlIlIlIlIIlIIlIIllIIIIIl(File var0) {
        String var1 = lllIIIIIlllIIlIllIIlIIIlI.format(new Date());
        int var2 = 1;

        while(true) {
            File var3 = new File(var0, var1 + (var2 == 1 ? "" : "_" + var2) + ".png");
            if (!var3.exists()) {
                return var3;
            }

            ++var2;
        }
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(int[] var0, int var1, int var2) {
        int[] var3 = new int[var1];
        int var4 = var2 / 2;

        for(int var5 = 0; var5 < var4; ++var5) {
            System.arraycopy(var0, var5 * var1, var3, 0, var1);
            System.arraycopy(var0, (var2 - 1 - var5) * var1, var0, var5 * var1, var1);
            System.arraycopy(var3, 0, var0, (var2 - 1 - var5) * var1, var1);
        }

    }

    public void IlIllIIlIIlIIIllIllllIIll() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.mc.bridge$getMcDataDir(), this.mc.bridge$displayWidth(), this.mc.bridge$displayHeight(), this.mc.bridge$getFramebuffer());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(File var1, int var2, int var3, FramebufferBridge var4) {
        try {
            File var5 = new File(var1, "screenshots");
            if (!var5.exists()) {
                var5.mkdir();
            }

            if (Bridge.lIlIIIIIIlIIIllllIllIIlII().bridge$isFramebufferEnabled()) {
                var2 = var4.bridge$framebufferTextureWidth();
                var3 = var4.bridge$framebufferTextureHeight();
            }

            int var6 = var2 * var3;
            if (this.llIIlIlIIIllIlIlIlIIlIIll == null || this.llIIlIlIIIllIlIlIlIIlIIll.capacity() < var6) {
                this.llIIlIlIIIllIlIlIlIIlIIll = BufferUtils.createIntBuffer(var6);
                this.llIIIlllIIlllIllllIlIllIl = new int[var6];
            }

            GL11.glPixelStorei(3333, 1);
            GL11.glPixelStorei(3317, 1);
            this.llIIlIlIIIllIlIlIlIIlIIll.clear();
            if (Bridge.lIlIIIIIIlIIIllllIllIIlII().bridge$isFramebufferEnabled()) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$bindTexture(var4.bridge$getFramebufferTexture());
                GL11.glGetTexImage(3553, 0, 32993, 33639, this.llIIlIlIIIllIlIlIlIIlIIll);
            } else {
                GL11.glReadPixels(0, 0, var2, var3, 32993, 33639, this.llIIlIlIIIllIlIlIlIIlIIll);
            }

            this.llIIlIlIIIllIlIlIlIIlIIll.get(this.llIIIlllIIlllIllllIlIllIl);
            (new ScreenshotSaveThread(this, this.llIIIlllIIlllIllllIlIllIl, var2, var3, var4, var5)).start();
        } catch (Exception var9) {
            LunarLogger.warn("Couldn't save screenshot", var9);
            var9.printStackTrace();
        }

    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(new SettingLabel("screenshotOptions"), this.llllIIlIIlIIlIIllIIlIIllI = new BooleanSetting(this.enabled, "copy_automatically", false), new SettingLabel("screenshotChatOptions"), this.IlIlIlllllIlIIlIlIlllIlIl = new BooleanSetting(this.enabled, "upload_option", true), this.llIIIIIIIllIIllIlIllIIIIl = new BooleanSetting(this.enabled, "tweet_option", true), this.lIIIllIllIIllIlllIlIIlllI = new BooleanSetting(this.enabled, "copy_option", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("[UPLOAD]", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("screenshot", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.MECHANIC));
    }
}
