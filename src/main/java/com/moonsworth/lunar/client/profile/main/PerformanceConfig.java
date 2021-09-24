package com.moonsworth.lunar.client.profile.main;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.tileentity.TileEntityBridge;
import com.moonsworth.lunar.bridge.minecraft.util.Vec3iBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.hud.EventRenderGlint;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.json.file.JsonFile;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.*;
import com.moonsworth.lunar.client.util.FriendStatusUtil;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PerformanceConfig extends ItemSetLoader<AbstractSetting<?>> implements EventHandler, JsonFile {
    public float lIlIlIlIlIIlIIlIIllIIIIIl;
    public EnumSetting<PerformanceConfig.GlintOption> IlllIIIIIIlllIlIIlllIlIIl;
    public BooleanSetting lIllIlIIIlIIIIIIIlllIlIll;
    public EnumSetting<PerformanceConfig.ChunkLoading> llIlllIIIllllIIlllIllIIIl;
    public EnumSetting<EntityRenderer> llllIIlIIlIIlIIllIIlIIllI;
    public EnumSetting<EntityRenderer> IlIlIlllllIlIIlIlIlllIlIl;
    public BooleanSetting llIIIIIIIllIIllIlIllIIIIl;
    public EnumSetting<Where> lIIIllIllIIllIlllIlIIlllI;
    public BooleanSetting IlllllIlIIIlIIlIIllIIlIll;
    public BooleanSetting llIIlIlIIIllIlIlIlIIlIIll;
    public final Map<EntityBridge, Double> llIIIlllIIlllIllllIlIllIl = new ConcurrentHashMap<>();
    public final Map<TileEntityBridge, Double> lllllIllIllIllllIlIllllII = new ConcurrentHashMap<>();
    public int lllIIIIIlllIIlIllIIlIIIlI;

    public PerformanceConfig() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(EventRenderGlint.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public Set<AbstractSetting<?>> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return ImmutableSet.of(
                   new SettingLabel("generalOptions"),
                   this.lIIIllIllIIllIlllIlIIlllI = new EnumSetting<>("hide_endportals", Where.lIllIlIIIlIIIIIIIlllIlIll),
                   this.lIllIlIIIlIIIIIIIlllIlIll = new BooleanSetting("skip_lighting", true),
                   this.IlllIIIIIIlllIlIIlllIlIIl = new EnumSetting<>("glint", PerformanceConfig.GlintOption.lIlIlIlIlIIlIIlIIllIIIIIl),
                   this.llIlllIIIllllIIlllIllIIIl = new EnumSetting<>("lazy_chunk_loading", PerformanceConfig.ChunkLoading.llIlllIIIllllIIlllIllIIIl),
                   new SettingLabel("entityOptions"),
                   this.llIIIIIIIllIIllIlIllIIIIl = new BooleanSetting("entity_shadow", true),
                   this.llllIIlIIlIIlIIllIIlIIllI = new EnumSetting<>("entity_render", EntityRenderer.lIllIlIIIlIIIIIIIlllIlIll),
                   this.IlIlIlllllIlIIlIlIlllIlIl = new EnumSetting<>("b_entity_render", EntityRenderer.lIllIlIIIlIIIIIIIlllIlIll),
                   this.IlllllIlIIIlIIlIIllIIlIll = new BooleanSetting("ground_arrows", true),
                   this.llIIlIlIIIllIlIlIlIIlIIll = new BooleanSetting("stuck_arrows", true));
    }

    public File IlIlIlllllIlIIlIlIlllIlIl() {
        return new File(LunarClient.getInstance().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().getSelectedProfile().getName(), this.llllIIlIIlIIlIIllIIlIIllI());
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(EntityBridge entityBridge) {
        if (entityBridge == Ref.getPlayer() || entityBridge instanceof EntityPlayerBridge) {
            return true;
        }
        if (Bridge.getMinecraftVersion() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl && (entityBridge instanceof com.moonsworth.lunar.bridge.minecraft.client.entity.lIIIllIllIIllIlllIlIIlllI || entityBridge instanceof com.moonsworth.lunar.bridge.minecraft.client.entity.lIllIlIIIlIIIIIIIlllIlIll)) {
            return true;
        }
        Double d = this.llIIIlllIIlllIllllIlIllIl.get(entityBridge);
        if (d == null) {
            d = Ref.getMinecraft().bridge$getRenderViewEntity().lIlIlIlIlIIlIIlIIllIIIIIl(entityBridge);
            this.llIIIlllIIlllIllllIlIllIl.put(entityBridge, d);
        }
        return !(d > (double) (((EntityRenderer) this.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl() * ((EntityRenderer) this.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl()));
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(EntityBridge var1, double var2, double var4, double var6) {
        if (var1 == null) {
            return true;
        } else {
            Double var8 = this.llIIIlllIIlllIllllIlIllIl.get(var1);
            if (var8 == null) {
                var8 = Ref.getMinecraft().bridge$getRenderViewEntity().lIlIlIlIlIIlIIlIIllIIIIIl(var1);
                this.llIIIlllIIlllIllllIlIllIl.put(var1, var8);
            }

            return !(var8 > (double) (((EntityRenderer) this.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl() * ((EntityRenderer) this.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl()));
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(TileEntityBridge var1) {
        Vec3iBridge var2 = var1.bridge$getPos();
        if (var1.bridge$getBlockType() == Bridge.IllIllIIIllIIIlIlIlIIIIll().bridge$end_portal() && (this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() == Where.lIlIlIlIlIIlIIlIIllIIIIIl || this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() == Where.IlllIIIIIIlllIlIIlllIlIIl && FriendStatusUtil.lIllIlIIIlIIIIIIIlllIlIll("Skyblock"))) {
            return false;
        } else {
            Double var3 = this.lllllIllIllIllllIlIllllII.get(var1);
            if (var3 == null) {
                var3 = Ref.getMinecraft().bridge$getRenderViewEntity().lIlIlIlIlIIlIIlIIllIIIIIl(var2.bridge$getX(), var2.bridge$getY(), var2.bridge$getZ());
                this.lllllIllIllIllllIlIllllII.put(var1, var3);
            }

            return !(var3 > (double) (((EntityRenderer) this.IlIlIlllllIlIIlIlIlllIlIl.llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl() * ((EntityRenderer) this.IlIlIlllllIlIIlIlIlllIlIl.llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl()));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent var1) {
        if (this.lllIIIIIlllIIlIllIIlIIIlI > 15) {
            this.llIIIlllIIlllIllllIlIllIl.clear();
            this.lllllIllIllIllllIlIllllII.clear();
            this.lllIIIIIlllIIlIllIIlIIIlI = 0;
        }

        ++this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public void b_() {
        super.b_();
        this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl((var1) -> {
            float var2 = var1 ? 100.0F : this.lIlIlIlIlIIlIIlIIllIIIIIl;
            Ref.getMinecraft().bridge$getGameSettings().bridge$setGamma(var2);
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EventRenderGlint var1) {
        if (this.IlllIIIIIIlllIlIIlllIlIIl.llIlllIIIllllIIlllIllIIIl() == PerformanceConfig.GlintOption.IlllIIIIIIlllIlIIlllIlIIl) {
            if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() != EventRenderGlint.Where.lIllIlIIIlIIIIIIIlllIlIll) {
                var1.setCancelled(true);
            }
        } else if (this.IlllIIIIIIlllIlIIlllIlIIl.llIlllIIIllllIIlllIllIIIl() == PerformanceConfig.GlintOption.lIllIlIIIlIIIIIIIlllIlIll) {
            var1.setCancelled(true);
        }

    }

    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "performance.json";
    }

    public void read(JsonObject var1) {

        for (AbstractSetting<?> var3 : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                var3.read(var1);
            } catch (Exception var5) {
            }
        }

        if (var1.has("gammaFromFile") && !var1.get("gammaFromFile").isJsonNull()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = var1.get("gammaFromFile").getAsFloat();
            if (!(Boolean) this.lIllIlIIIlIIIIIIIlllIlIll.llIlllIIIllllIIlllIllIIIl()) {
                Ref.getMinecraft().bridge$getGameSettings().bridge$setGamma(this.lIlIlIlIlIIlIIlIIllIIIIIl);
            } else {
                Ref.getMinecraft().bridge$getGameSettings().bridge$setGamma(100.0F);
            }
        } else {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = 1.0F;
        }

    }

    public void write(JsonObject var1) {
        Iterator var2 = this.llIlllIIIllllIIlllIllIIIl().iterator();

        while (var2.hasNext()) {
            AbstractSetting var3 = (AbstractSetting) var2.next();

            try {
                var3.write(var1);
            } catch (Exception var5) {
            }
        }

        var1.addProperty("gammaFromFile", this.lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public float IlllllIlIIIlIIlIIllIIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public EnumSetting llIIlIlIIIllIlIlIlIIlIIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public BooleanSetting llIIIlllIIlllIllllIlIllIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public BooleanSetting lllllIllIllIllllIlIllllII() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public Map lIlIIIIIIlIIIllllIllIIlII() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public Map llIlIIIllIIlIllIllIllllIl() {
        return this.lllllIllIllIllllIlIllllII;
    }

    public int IllIllIIIllIIIlIlIlIIIIll() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
    }

    public EnumSetting IIlIllIlllllllIIlIIIllIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public EnumSetting lIIlIlllIlIlIIIlllIIlIIII() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public EnumSetting llIllIlIllIlllIllIIIIllII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public BooleanSetting IllllllllllIlIIIlllIlllll() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public EnumSetting lllllIllIlIIlIIlIIIlllIlI() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public enum lIllIlIIIlIIIIIIIlllIlIll implements IEnumSetting {
        lIlIlIlIlIIlIIlIIllIIIIIl("no_arrows"),
        IlllIIIIIIlllIlIIlllIlIIl("all_arrows"),
        lIllIlIIIlIIIIIIIlllIlIll("cant_pickup_arrows");

        public final String llIlllIIIllllIIlllIllIIIl;

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.llIlllIIIllllIIlllIllIIIl;
        }

        public String toString() {
            return this.get(this.llIlllIIIllllIIlllIllIIIl);
        }

        lIllIlIIIlIIIIIIIlllIlIll(String var3) {
            this.llIlllIIIllllIIlllIllIIIl = var3;
        }
    }

    public enum EntityRenderer implements IEnumSetting {
        lIlIlIlIlIIlIIlIIllIIIIIl("off_van", 256.0F),
        IlllIIIIIIlllIlIIlllIlIIl("high", 100.0F),
        lIllIlIIIlIIIIIIIlllIlIll("medium", 48.0F),
        llIlllIIIllllIIlllIllIIIl("low", 28.0F),
        llllIIlIIlIIlIIllIIlIIllI("lowest", 16.0F);

        public final String IlIlIlllllIlIIlIlIlllIlIl;
        public final float llIIIIIIIllIIllIlIllIIIIl;

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.IlIlIlllllIlIIlIlIlllIlIl;
        }

        public String toString() {
            return this.get(this.IlIlIlllllIlIIlIlIlllIlIl);
        }

        EntityRenderer(String var3, float var4) {
            this.IlIlIlllllIlIIlIlIlllIlIl = var3;
            this.llIIIIIIIllIIllIlIllIIIIl = var4;
        }

        public float IlllIIIIIIlllIlIIlllIlIIl() {
            return this.llIIIIIIIllIIllIlIllIIIIl;
        }
    }

    public enum ChunkLoading implements IEnumSetting {
        lIlIlIlIlIIlIIlIIllIIIIIl("off_van", 1),
        IlllIIIIIIlllIlIIlllIlIIl("highest", 2),
        lIllIlIIIlIIIIIIIlllIlIll("high", 5),
        llIlllIIIllllIIlllIllIIIl("medium", 10),
        llllIIlIIlIIlIIllIIlIIllI("low", 15),
        IlIlIlllllIlIIlIlIlllIlIl("lowest", 30);

        public final String llIIIIIIIllIIllIlIllIIIIl;
        public final int lIIIllIllIIllIlllIlIIlllI;

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.llIIIIIIIllIIllIlIllIIIIl;
        }

        public String toString() {
            return this.get(this.llIIIIIIIllIIllIlIllIIIIl);
        }

        ChunkLoading(String var3, int var4) {
            this.llIIIIIIIllIIllIlIllIIIIl = var3;
            this.lIIIllIllIIllIlllIlIIlllI = var4;
        }

        public int IlllIIIIIIlllIlIIlllIlIIl() {
            return this.lIIIllIllIIllIlllIlIIlllI;
        }
    }

    public enum GlintOption implements IEnumSetting {
        lIlIlIlIlIIlIIlIIllIIIIIl("all"),
        IlllIIIIIIlllIlIIlllIlIIl("inventoryOnly"),
        lIllIlIIIlIIIIIIIlllIlIll("none");

        public final String llIlllIIIllllIIlllIllIIIl;

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.llIlllIIIllllIIlllIllIIIl;
        }

        public String toString() {
            return this.get(this.llIlllIIIllllIIlllIllIIIl);
        }

        GlintOption(String var3) {
            this.llIlllIIIllllIIlllIllIIIl = var3;
        }
    }
}