package com.moonsworth.lunar.client.feature.type.netgraph;

import com.google.common.collect.ImmutableList;

import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.ServerDataBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.TessellatorBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.network.KeepAliveEvent;
import com.moonsworth.lunar.client.event.type.network.NetHandlerConnectionStateUpdateEvent;
import com.moonsworth.lunar.client.event.type.render.RenderScaledGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.*;
import java.util.List;

public class NetGraphMod extends ConfigurableFeature {
    public final int llllIIlIIlIIlIIllIIlIIllI = 125;
    public final ArrayDeque IlIlIlllllIlIIlIlIlllIlIl = new ArrayDeque(125);
    public long llIIIIIIIllIIllIlIllIIIIl = System.currentTimeMillis();
    public long lIIIllIllIIllIlllIlIIlllI = System.currentTimeMillis();
    public long IlllllIlIIIlIIlIIllIIlIll = 2000L;
    public boolean llIIlIlIIIllIlIlIlIIlIIll = false;
    public List<Long> llIIIlllIIlllIllllIlIllIl = new ArrayList<>();
    public final long[] lllIIIIIlllIIlIllIIlIIIlI = new long[] {250L, 500L, 750L, 1000L, 1250L, 1500L, 1750L, 2000L, 2500L};
    public int lIlIIIIIIlIIIllllIllIIlII = 15;

    public NetGraphMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderScaledGameOverlayEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(KeepAliveEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        (new Thread(new NetGraphMod.lIlIlIlIlIIlIIlIIllIIIIIl())).start();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent var1) {
        LunarLogger.debug("Switched server, finding new keepAlive rate");
        this.IlllllIlIIIlIIlIIllIIlIll = 2000L;
        this.llIIlIlIIIllIlIlIlIIlIIll = false;
        this.llIIIlllIIlllIllllIlIllIl = new ArrayList<>();
        this.llIIIIIIIllIIllIlIllIIIIl = System.currentTimeMillis();
        this.lIIIllIllIIllIlllIlIIlllI = System.currentTimeMillis();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(KeepAliveEvent var1) {
        long var2 = System.currentTimeMillis() - this.llIIIIIIIllIIllIlIllIIIIl - 50L;
        if (!this.llIIlIlIIIllIlIlIlIIlIIll) {
            if (System.currentTimeMillis() - this.lIIIllIllIIllIlllIlIIlllI < 2500L) {
                LunarLogger.debug("Added keepAlive (" + var2 + ")");
                this.llIIIlllIIlllIllllIlIllIl.add(var2);
                this.llIIIIIIIllIIllIlIllIIIIl = System.currentTimeMillis();
                return;
            }

            this.llIIlIlIIIllIlIlIlIIlIIll = true;
            long var4 = 0L;
            long var6 = 0L;

            long var10;
            for(Iterator<Long> var8 = this.llIIIlllIIlllIllllIlIllIl.iterator(); var8.hasNext(); ++var6) {
                Long var9 = var8.next();
                var10 = var9;
                var4 += var10;
            }

            if (var6 > 0L) {
                double var13 = (double)var4 / (double)var6;
                var10 = this.lIlIlIlIlIIlIIlIIllIIIIIl((long)var13);
                LunarLogger.debug("Decided that server keepAlive rate is " + var10 + "ms");
                this.IlllllIlIIIlIIlIIllIIlIll = var10;
            }
        }

        if (this.IlIlIlllllIlIIlIlIlllIlIl.size() > 125) {
            this.IlIlIlllllIlIIlIlIlllIlIl.poll();
        }

        NetGraphMod.IlllIIIIIIlllIlIIlllIlIIl var12 = new NetGraphMod.IlllIIIIIIlllIlIIlllIlIIl(20.0F * ((float)this.IlllllIlIIIlIIlIIllIIlIll / (float)var2));
        this.lIlIlIlIlIIlIIlIIllIIIIIl(var12);
        this.IlIlIlllllIlIIlIlIlllIlIl.add(var12);
        this.llIIIIIIIllIIllIlIllIIIIl = System.currentTimeMillis();
        ++this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderScaledGameOverlayEvent var1) {
        if (this.IlIlIlllllIlIIlIlIlllIlIl != null && !this.IlIlIlllllIlIIlIlIlllIlIl.isEmpty()) {
            float var2 = (float)var1.lIlIlIlIlIIlIIlIIllIIIIIl() - (float)this.IlIlIlllllIlIIlIlIlllIlIl.size() - 34.0F;
            float var3 = (float)var1.IlllIIIIIIlllIlIIlllIlIIl() + 1.0F;
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(var2, var3 - 42.0F, (float)this.IlIlIlllllIlIIlIlIlllIlIl.size() + 35.0F, 0.5F, -1342177281);
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl("20.0", var2, var3 - 42.0F, -1342177281);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(var2, var3 - 21.0F, (float)this.IlIlIlllllIlIIlIlIlllIlIl.size() + 35.0F, 0.5F, 1358954495);
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl("10.0", var2, var3 - 21.0F, 1358954495);
            float var4 = var3 - 42.0F;
            float var5 = ((NetGraphMod.IlllIIIIIIlllIlIIlllIlIIl)this.IlIlIlllllIlIIlIlIlllIlIl.getLast()).IlllIIIIIIlllIlIIlllIlIIl;
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl("sv: ", var2 - 46.0F, var3 - 42.0F, -1);
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl("" + (double)Math.round((double)var5 * 100.0D) / 100.0D + " TPS", var2 - 36.0F, var4, this.lIllIlIIIlIIIIIIIlllIlIll(var5 / 20.0F).getRGB());
            var4 += 6.0F;
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllllIlIIIlIIlIIllIIlIll - (long)Math.round(var5 / 20.0F * (float)this.IlllllIlIIIlIIlIIllIIlIll) + "ms", var2 - 36.0F, var4, this.lIllIlIIIlIIIIIIIlllIlIll(var5 / 20.0F).getRGB());
            var4 += 6.0F;
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl("cl: ", var2 - 46.0F, var4, -1);
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getMinecraft().bridge$getDebugFPS() + " FPS", var2 - 36.0F, var4, this.lIllIlIIIlIIIIIIIlllIlIll((float)Math.min(60, Ref.getMinecraft().bridge$getDebugFPS()) / 60.0F).getRGB());
            var4 += 6.0F;
            ServerDataBridge var6 = Ref.getMinecraft().bridge$getCurrentServerData();
            if (var6 != null) {
                FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl("ms: ", var2 - 46.0F, var4, -1);
                FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl(var6.bridge$getPingToServer() + " MS", var2 - 36.0F, var4, this.lIllIlIIIlIIIIIIIlllIlIll((float)Math.min(300L, var6.bridge$getPingToServer()) / 300.0F).getRGB());
                var4 += 6.0F;
            }

            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableCull();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(35.0F, -1.0F, 0.0F);
            GL11.glLineWidth(1.5F);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$tryBlendFuncSeparate(770, 771, 1, 0);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$shadeModel(7425);
            Iterator var7 = this.IlIlIlllllIlIIlIlIlllIlIl.clone().iterator();
            float var8 = 0.0F;
            int var9 = 0;

            NetGraphMod.IlllIIIIIIlllIlIIlllIlIIl var11;
            for(Color var10 = this.lIllIlIIIlIIIIIIIlllIlIll(0.0F); var7.hasNext(); ++var9) {
                var11 = (NetGraphMod.IlllIIIIIIlllIlIIlllIlIIl)var7.next();
                float var12 = var11.IlllIIIIIIlllIlIIlllIlIIl;
                Color var13 = this.lIllIlIIIlIIIIIIIlllIlIll(var12 / 20.0F);
                Color var14 = this.lIllIlIIIlIIIIIIIlllIlIll(var8 / 20.0F);
                TessellatorBridge var15 = Bridge.getInstance().initTessellator();
                var15.bridge$begin(1, false, true);
                var15.bridge$pos(var2, var3 - var8 * 2.0F, 0.0F).bridge$color((float)var14.getRed(), (float)var14.getGreen(), (float)var14.getBlue(), 175.0F).bridge$endVertex();
                var15.bridge$pos(var2, var3, 0.0F).bridge$color((float)var10.getRed(), (float)var10.getGreen(), (float)var10.getBlue(), 175.0F).bridge$endVertex();
                if (var9 > 0) {
                    var15.bridge$pos(var2, var3 - var8 * 2.0F, 0.0F).bridge$color((float)var14.getRed(), (float)var14.getGreen(), (float)var14.getBlue(), 255.0F).bridge$endVertex();
                    var15.bridge$pos(var2 + 1.0F, var3 - var12 * 2.0F, 0.0F).bridge$color((float)var13.getRed(), (float)var13.getGreen(), (float)var13.getBlue(), 255.0F).bridge$endVertex();
                } else {
                    var15.bridge$pos(var2 + 1.0F, var3 - var12 * 2.0F, 0.0F).bridge$color((float)var13.getRed(), (float)var13.getGreen(), (float)var13.getBlue(), 255.0F).bridge$endVertex();
                    var15.bridge$pos(var2 + 1.0F, var3 - var12 * 2.0F, 0.0F).bridge$color((float)var14.getRed(), (float)var14.getGreen(), (float)var14.getBlue(), 255.0F).bridge$endVertex();
                }

                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color((float)var13.getRed() / 255.0F, (float)var13.getGreen() / 255.0F, (float)var13.getBlue() / 255.0F);
                var15.bridge$end();
                var8 = var12;
                ++var2;
            }

            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableCull();
            var2 = (float)var1.lIlIlIlIlIIlIIlIIllIIIIIl() - (float)this.IlIlIlllllIlIIlIlIlllIlIl.size() + 2.0F;
            var9 = 0;

            for(var7 = this.IlIlIlllllIlIIlIlIlllIlIl.clone().iterator(); var7.hasNext(); ++var9) {
                var11 = (NetGraphMod.IlllIIIIIIlllIlIIlllIlIIl)var7.next();
                if (var11.lIllIlIIIlIIIIIIIlllIlIll) {
                    FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().IlllIIIIIIlllIlIIlllIlIIl((double)Math.round((double)var11.IlllIIIIIIlllIlIIlllIlIIl * 100.0D) / 100.0D + "", var2, var3 - 55.0F, -1);
                    AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(var2, var3 - 49.0F, 0.5F, 5.0F, -1);
                }

                ++var2;
            }

        }
    }

    public long lIlIlIlIlIIlIIlIIllIIIIIl(long var1) {
        long var3 = Math.abs(this.lllIIIIIlllIIlIllIIlIIIlI[0] - var1);
        int var5 = 0;

        for(int var6 = 1; var6 < this.lllIIIIIlllIIlIllIIlIIIlI.length; ++var6) {
            long var7 = Math.abs(this.lllIIIIIlllIIlIllIIlIIIlI[var6] - var1);
            if (var7 < var3) {
                var5 = var6;
                var3 = var7;
            }
        }

        return this.lllIIIIIlllIIlIllIIlIIIlI[var5];
    }

    public Color lIllIlIIIlIIIIIIIlllIlIll(float var1) {
        float var2 = var1 * 0.4F;
        float var3 = 0.9F;
        float var4 = 0.9F;
        return Color.getHSBColor(var2, var3, var4);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Net Graph", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("netgraph", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.SERVER));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetGraphMod.IlllIIIIIIlllIlIIlllIlIIl var1) {
        if (this.IlIlIlllllIlIIlIlIlllIlIl != null && !this.IlIlIlllllIlIIlIlIlllIlIl.isEmpty()) {
            NetGraphMod.IlllIIIIIIlllIlIIlllIlIIl var2 = (NetGraphMod.IlllIIIIIIlllIlIIlllIlIIl)this.IlIlIlllllIlIIlIlIlllIlIl.getLast();
            if ((var1.IlllIIIIIIlllIlIIlllIlIIl < var2.IlllIIIIIIlllIlIIlllIlIIl * 0.85F || var1.IlllIIIIIIlllIlIIlllIlIIl < 5.0F) && !this.IlIllIIlIIlIIIllIllllIIll()) {
                var1.lIllIlIIIlIIIIIIIlllIlIll = true;
                this.lIlIIIIIIlIIIllllIllIIlII = 0;
            }

        }
    }

    public boolean IlIllIIlIIlIIIllIllllIIll() {
        return this.lIlIIIIIIlIIIllllIllIIlII <= 14;
    }

    public class lIlIlIlIlIIlIIlIIllIIIIIl implements Runnable {
        public lIlIlIlIlIIlIIlIIllIIIIIl() {
        }

        public void run() {
            while(true) {
                if (NetGraphMod.this.enabled.llIlllIIIllllIIlllIllIIIl() && System.currentTimeMillis() - NetGraphMod.this.lIIIllIllIIllIlllIlIIlllI > 2500L && Ref.getWorld() != null && System.currentTimeMillis() - NetGraphMod.this.llIIIIIIIllIIllIlIllIIIIl > NetGraphMod.this.IlllllIlIIIlIIlIIllIIlIll * 2L) {
                    if (NetGraphMod.this.IlIlIlllllIlIIlIlIlllIlIl.size() > 125) {
                        NetGraphMod.this.IlIlIlllllIlIIlIlIlllIlIl.poll();
                    }

                    LunarLogger.debug("Is server down? Added 0TPS");
                    NetGraphMod.IlllIIIIIIlllIlIIlllIlIIl var1;
                    NetGraphMod.this.IlIlIlllllIlIIlIlIlllIlIl.add(var1 = NetGraphMod.this.new IlllIIIIIIlllIlIIlllIlIIl(0.0F));
                    NetGraphMod.this.lIlIlIlIlIIlIIlIIllIIIIIl(var1);
                }

                try {
                    Thread.sleep(NetGraphMod.this.IlllllIlIIIlIIlIIllIIlIll);
                } catch (InterruptedException var2) {
                }
            }
        }

        // $FF: synthetic method
        public lIlIlIlIlIIlIIlIIllIIIIIl(Object var2) {
            this();
        }
    }

    public class IlllIIIIIIlllIlIIlllIlIIl {
        public final float IlllIIIIIIlllIlIIlllIlIIl;
        public boolean lIllIlIIIlIIIIIIIlllIlIll;

        public IlllIIIIIIlllIlIIlllIlIIl(float var2) {
            this.IlllIIIIIIlllIlIIlllIlIIl = var2;
        }
    }
}
