package com.moonsworth.lunar.client.registry;

import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.IntergratedServerInterface;
import com.moonsworth.lunar.client.feature.type.autotext.AutoTextMod;
import com.moonsworth.lunar.client.feature.type.blur.MenuBlurMod;
import com.moonsworth.lunar.client.feature.type.cps.CPSMod;
import com.moonsworth.lunar.client.feature.type.crosshair.CrosshairMod;
import com.moonsworth.lunar.client.feature.type.fps.FPSMod;
import com.moonsworth.lunar.client.feature.type.keystrokes.KeyStrokesMod;
import com.moonsworth.lunar.client.feature.type.ping.PingMod;
import com.moonsworth.lunar.client.feature.type.replaymod.ReplayMod;
import com.moonsworth.lunar.client.feature.type.waypoints.WaypointsMod;
import com.moonsworth.lunar.client.json.file.DefaultJson;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.ref.Ref;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;

public class ModuleManager
extends ItemSetLoader<ConfigurableFeature>
implements DefaultJson {
    public AnimationsMod lIlIlIlIlIIlIIlIIllIIIIIl;
    public FOVMod IlllIIIIIIlllIlIIlllIlIIl;
    public KeyStrokesMod lIllIlIIIlIIIIIIIlllIlIll;
    public AutoTextMod llIlllIIIllllIIlllIllIIIl;
    public WaypointsMod llllIIlIIlIIlIIllIIlIIllI;
    public BlockOutlineMod IlIlIlllllIlIIlIlIlllIlIl;
    public ParticleMultiplierMod llIIIIIIIllIIllIlIllIIIIl;
    public PotionEffectsMod lIIIllIllIIllIlllIlIIlllI;
    public ShinyPotsMod IlllllIlIIIlIIlIIllIIlIll;
    public ToggleSneakMod llIIlIlIIIllIlIlIlIIlIIll;
    public Items2DMod llIIIlllIIlllIllllIlIllIl;
    public ItemPhysicsMod lllllIllIllIllllIlIllllII;
    public FreelookMod lllIIIIIlllIIlIllIIlIIIlI;
    public ScreenshotMod lIlIIIIIIlIIIllllIllIIlII;
    public CrosshairMod llIlIIIllIIlIllIllIllllIl;
    public SkyBlockAddonsMod IllIllIIIllIIIlIlIlIIIIll;
    public ReplayMod IIlIllIlllllllIIlIIIllIIl;
    public CooldownsMod lIIlIlllIlIlIIIlllIIlIIII;
    public NickHiderMod llIllIlIllIlllIllIIIIllII;
    public ArmorStatusMod IllllllllllIlIIIlllIlllll;
    public MenuBlurMod lllllIllIlIIlIIlIIIlllIlI;
    public MotionBlurMod IllIIIlllIIIlIlllIlIIlIII;
    public ScrollableTooltipsMod IIlIllIlIIllIIlIlIllllllI;
    public BossBarMod lIIIlllIIIIllllIlIIIlIIll;
    public ChatMod llIIIlIllIIIIlIIIlIlIllIl;
    public ZoomMod llllIlIllllIlIlIIIllIlIlI;
    public HitboxMod IlIllIIlIIlIIIllIllllIIll;

    @Override
    public Set<ConfigurableFeature> lIlIlIlIlIIlIIlIIllIIIIIl() {
        ConfigurableFeature[] configurableFeatureArray = new ConfigurableFeature[51];

        this.IIlIllIlllllllIIlIIIllIIl = new ReplayMod();
        configurableFeatureArray[0] = this.IIlIllIlllllllIIlIIIllIIl;
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new AnimationsMod();
        configurableFeatureArray[1] = this.lIlIlIlIlIIlIIlIIllIIIIIl;
        configurableFeatureArray[2] = new FPSMod();
        configurableFeatureArray[3] = new CPSMod();
        this.IllIllIIIllIIIlIlIlIIIIll = new SkyBlockAddonsMod();
        configurableFeatureArray[4] = this.IllIllIIIllIIIlIlIlIIIIll;
        this.llIIlIlIIIllIlIlIlIIlIIll = new ToggleSneakMod();
        configurableFeatureArray[5] = this.llIIlIlIIIllIlIlIlIIlIIll;
        this.llllIlIllllIlIlIIIllIlIlI = new ZoomMod();
        configurableFeatureArray[6] = this.llllIlIllllIlIlIIIllIlIlI;
        configurableFeatureArray[7] = new HypixelMod();
        this.IllllllllllIlIIIlllIlllll = new ArmorStatusMod();
        configurableFeatureArray[8] = this.IllllllllllIlIIIlllIlllll;
        this.lIllIlIIIlIIIIIIIlllIlIll = new KeyStrokesMod();
        configurableFeatureArray[9] = this.lIllIlIIIlIIIIIIIlllIlIll;
        configurableFeatureArray[10] = new CoordinatesMod();
        configurableFeatureArray[11] = new DayCounterMod();
        this.llIlIIIllIIlIllIllIllllIl = new CrosshairMod();
        configurableFeatureArray[12] = this.llIlIIIllIIlIllIllIllllIl;
        this.lIIIllIllIIllIlllIlIIlllI = new PotionEffectsMod();
        configurableFeatureArray[13] = this.lIIIllIllIIllIlllIlIIlllI;
        configurableFeatureArray[14] = new DirectionHudMod();
        this.llllIIlIIlIIlIIllIIlIIllI = new WaypointsMod();
        configurableFeatureArray[15] = this.llllIIlIIlIIlIIllIIlIIllI;
        configurableFeatureArray[16] = new ScoreboardMod();
        configurableFeatureArray[17] = new PotionCounterMod();
        configurableFeatureArray[18] = new PingMod();
        this.IllIIIlllIIIlIlllIlIIlIII = new MotionBlurMod();
        configurableFeatureArray[19] = this.IllIIIlllIIIlIlllIlIIlIII;
        this.llIIIlIllIIIIlIIIlIlIllIl = new ChatMod();
        configurableFeatureArray[20] = this.llIIIlIllIIIIlIIIlIlIllIl;
        this.IIlIllIlIIllIIlIlIllllllI = new ScrollableTooltipsMod();
        configurableFeatureArray[21] = this.IIlIllIlIIllIIlIlIllllllI;
        configurableFeatureArray[22] = new UHCOverlayMod();
        this.llIIIIIIIllIIllIlIllIIIIl = new ParticleMultiplierMod();
        configurableFeatureArray[23] = this.llIIIIIIIllIIllIlIllIIIIl;
        this.llIllIlIllIlllIllIIIIllII = new NickHiderMod();
        configurableFeatureArray[24] = this.llIllIlIllIlllIllIIIIllII;
        this.lIIlIlllIlIlIIIlllIIlIIII = new CooldownsMod();
        configurableFeatureArray[25] = this.lIIlIlllIlIlIIIlllIIlIIII;
        configurableFeatureArray[26] = new WorldEditCUIMod();
        configurableFeatureArray[27] = new ClockMod();
        configurableFeatureArray[28] = new StopwatchMod();
        configurableFeatureArray[29] = new MemoryMod();
        configurableFeatureArray[30] = new ComboMod();
        configurableFeatureArray[31] = new RangeMod();
        configurableFeatureArray[32] = new TimeChangerMod();
        configurableFeatureArray[33] = new ServerAddressMod();
        configurableFeatureArray[34] = new SaturationMod();
        this.lllllIllIllIllllIlIllllII = new ItemPhysicsMod();
        configurableFeatureArray[35] = this.lllllIllIllIllllIlIllllII;
        configurableFeatureArray[36] = new ItemTrackerMod();
        this.IlllllIlIIIlIIlIIllIIlIll = new ShinyPotsMod();
        configurableFeatureArray[37] = this.IlllllIlIIIlIIlIIllIIlIll;
        this.IlIlIlllllIlIIlIlIlllIlIl = new BlockOutlineMod();
        configurableFeatureArray[38] = this.IlIlIlllllIlIIlIlIlllIlIl;
        this.lIlIIIIIIlIIIllllIllIIlII = new ScreenshotMod();
        configurableFeatureArray[39] = this.lIlIIIIIIlIIIllllIllIIlII;
        this.IlllIIIIIIlllIlIIlllIlIIl = new FOVMod();
        configurableFeatureArray[40] = this.IlllIIIIIIlllIlIIlllIlIIl;
        this.llIlllIIIllllIIlllIllIIIl = new AutoTextMod();
        configurableFeatureArray[41] = this.llIlllIIIllllIIlllIllIIIl;
        configurableFeatureArray[42] = new NetGraphMod();
        configurableFeatureArray[43] = new MumbleLinkMod();
        this.llIIIlllIIlllIllllIlIllIl = new Items2DMod();
        configurableFeatureArray[44] = this.llIIIlllIIlllIllllIlIllIl;
        this.lIIIlllIIIIllllIlIIIlIIll = new BossBarMod();
        configurableFeatureArray[45] = this.lIIIlllIIIIllllIlIIIlIIll;
        this.lllIIIIIlllIIlIllIIlIIIlI = new FreelookMod();
        configurableFeatureArray[46] = this.lllIIIIIlllIIlIllIIlIIIlI;
        configurableFeatureArray[47] = new TeamViewMod();
        configurableFeatureArray[48] = new ResourceDisplayMod();
        this.lllllIllIlIIlIIlIIIlllIlI = new MenuBlurMod();
        configurableFeatureArray[49] = this.lllllIllIlIIlIIlIIIlllIlI;
        this.IlIllIIlIIlIIIllIllllIIll = new HitboxMod();
        configurableFeatureArray[50] = this.IlIllIIlIIlIIIllIllllIIll;
        LinkedHashSet linkedHashSet = this.lIlIlIlIlIIlIIlIIllIIIIIl(configurableFeatureArray);
        return linkedHashSet;
    }

    public LinkedHashSet lIlIlIlIlIIlIIlIIllIIIIIl(ConfigurableFeature... configurableFeatureArray) {
        LinkedHashSet<ConfigurableFeature> linkedHashSet = Sets.newLinkedHashSet();
        for (ConfigurableFeature configurableFeature : configurableFeatureArray) {
            linkedHashSet.add(configurableFeature);
        }
        return linkedHashSet;
    }

    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "mods.json";
    }

    @Override
    public void b_() {
        super.b_();
        for (ConfigurableFeature configurableFeature : this.llIlllIIIllllIIlllIllIIIl()) {
            configurableFeature.a_();
            if (!configurableFeature.lIlIIIIIIlIIIllllIllIIlII() || configurableFeature instanceof IntergratedServerInterface) continue;
            configurableFeature.lIllIlIIIlIIIIIIIlllIlIll();
        }
        this.load();
    }

    @Override
    public File IlIlIlllllIlIIlIlIlllIlIl() {
        return new File(LunarClient.IIllIlIllIlIllIllIllIllII().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + Ref.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIIIIIIllIlIIIIllIIII().llllIIlIIlIIlIIllIIlIIllI().IlllIIIIIIlllIlIIlllIlIIl(), this.llllIIlIIlIIlIIllIIlIIllI());
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        for (ConfigurableFeature configurableFeature : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                JsonObject jsonObject2 = jsonObject.has(configurableFeature.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl()) && !jsonObject.get(configurableFeature.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl()).isJsonNull() ? jsonObject.getAsJsonObject(configurableFeature.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl()) : new JsonObject();
                configurableFeature.IlllIIIIIIlllIlIIlllIlIIl(jsonObject2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        for (ConfigurableFeature configurableFeature : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                JsonObject jsonObject2 = new JsonObject();
                configurableFeature.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2);
                if (jsonObject2.entrySet().isEmpty()) continue;
                jsonObject.add(configurableFeature.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(), (JsonElement)jsonObject2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.save();
    }

    public AnimationsMod IlllllIlIIIlIIlIIllIIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public FOVMod llIIlIlIIIllIlIlIlIIlIIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public KeyStrokesMod llIIIlllIIlllIllllIlIllIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public AutoTextMod lllllIllIllIllllIlIllllII() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public WaypointsMod lllIIIIIlllIIlIllIIlIIIlI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public BlockOutlineMod lIlIIIIIIlIIIllllIllIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public ParticleMultiplierMod llIlIIIllIIlIllIllIllllIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public PotionEffectsMod IllIllIIIllIIIlIlIlIIIIll() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public ShinyPotsMod IIlIllIlllllllIIlIIIllIIl() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public ToggleSneakMod lIIlIlllIlIlIIIlllIIlIIII() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public Items2DMod llIllIlIllIlllIllIIIIllII() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public ItemPhysicsMod IllllllllllIlIIIlllIlllll() {
        return this.lllllIllIllIllllIlIllllII;
    }

    public FreelookMod lllllIllIlIIlIIlIIIlllIlI() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public ScreenshotMod IllIIIlllIIIlIlllIlIIlIII() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public CrosshairMod IIlIllIlIIllIIlIlIllllllI() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public SkyBlockAddonsMod lIIIlllIIIIllllIlIIIlIIll() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public CooldownsMod llIIIlIllIIIIlIIIlIlIllIl() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public NickHiderMod llllIlIllllIlIlIIIllIlIlI() {
        return this.llIllIlIllIlllIllIIIIllII;
    }

    public ArmorStatusMod IlIllIIlIIlIIIllIllllIIll() {
        return this.IllllllllllIlIIIlllIlllll;
    }

    public MenuBlurMod lIllllIllIIlIIlIIIlIIIlII() {
        return this.lllllIllIlIIlIIlIIIlllIlI;
    }

    public MotionBlurMod lIlIlIIIIIIllIlIIIIllIIII() {
        return this.IllIIIlllIIIlIlllIlIIlIII;
    }

    public ScrollableTooltipsMod lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.IIlIllIlIIllIIlIlIllllllI;
    }

    public BossBarMod IlIIlIIlIIlIIllIIIllIIllI() {
        return this.lIIIlllIIIIllllIlIIIlIIll;
    }

    public ChatMod IIlIlIIIllIIllllIllllIlIl() {
        return this.llIIIlIllIIIIlIIIlIlIllIl;
    }

    public ZoomMod lllllIIIIlIlllIllIIIlIIlI() {
        return this.llllIlIllllIlIlIIIllIlIlI;
    }

    public HitboxMod IIlllIllIlIllIllIIllIlIIl() {
        return this.IlIllIIlIIlIIIllIllllIIll;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(SkyBlockAddonsMod skyBlockAddonsMod) {
        this.IllIllIIIllIIIlIlIlIIIIll = skyBlockAddonsMod;
    }

    public ReplayMod lIlIIlIlllIIlIIIlIlIlIllI() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }
}
 