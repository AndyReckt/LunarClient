package com.moonsworth.lunar.client.registry;

import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.IntergratedServerInterface;
import com.moonsworth.lunar.client.feature.type.animations.AnimationsMod;
import com.moonsworth.lunar.client.feature.type.armor.ArmorStatusMod;
import com.moonsworth.lunar.client.feature.type.autotext.AutoTextMod;
import com.moonsworth.lunar.client.feature.type.blockoutline.BlockOutlineMod;
import com.moonsworth.lunar.client.feature.type.blur.MenuBlurMod;
import com.moonsworth.lunar.client.feature.type.bossbar.BossBarMod;
import com.moonsworth.lunar.client.feature.type.chat.ChatMod;
import com.moonsworth.lunar.client.feature.type.clock.ClockMod;
import com.moonsworth.lunar.client.feature.type.combo.ComboMod;
import com.moonsworth.lunar.client.feature.type.coodowns.CooldownsMod;
import com.moonsworth.lunar.client.feature.type.coords.CoordinatesMod;
import com.moonsworth.lunar.client.feature.type.cps.CPSMod;
import com.moonsworth.lunar.client.feature.type.crosshair.CrosshairMod;
import com.moonsworth.lunar.client.feature.type.dirhud.DirectionHudMod;
import com.moonsworth.lunar.client.feature.type.doycounter.DayCounterMod;
import com.moonsworth.lunar.client.feature.type.fov.FOVMod;
import com.moonsworth.lunar.client.feature.type.fps.FPSMod;
import com.moonsworth.lunar.client.feature.type.freelook.FreelookMod;
import com.moonsworth.lunar.client.feature.type.hitbox.HitboxMod;
import com.moonsworth.lunar.client.feature.type.hypixel.HypixelMod;
import com.moonsworth.lunar.client.feature.type.itemphysics.ItemPhysicsMod;
import com.moonsworth.lunar.client.feature.type.items2d.Items2DMod;
import com.moonsworth.lunar.client.feature.type.itemtacker.ItemTrackerMod;
import com.moonsworth.lunar.client.feature.type.keystrokes.KeyStrokesMod;
import com.moonsworth.lunar.client.feature.type.memory.MemoryMod;
import com.moonsworth.lunar.client.feature.type.motionblur.MotionBlurMod;
import com.moonsworth.lunar.client.feature.type.mumblelink.MumbleLinkMod;
import com.moonsworth.lunar.client.feature.type.netgraph.NetGraphMod;
import com.moonsworth.lunar.client.feature.type.nick.NickHiderMod;
import com.moonsworth.lunar.client.feature.type.particles.ParticleMultiplierMod;
import com.moonsworth.lunar.client.feature.type.ping.PingMod;
import com.moonsworth.lunar.client.feature.type.potioncounter.PotionCounterMod;
import com.moonsworth.lunar.client.feature.type.potioneffects.PotionEffectsMod;
import com.moonsworth.lunar.client.feature.type.range.RangeMod;
import com.moonsworth.lunar.client.feature.type.replaymod.ReplayMod;
import com.moonsworth.lunar.client.feature.type.resourcedisplay.ResourceDisplayMod;
import com.moonsworth.lunar.client.feature.type.saturation.SaturationMod;
import com.moonsworth.lunar.client.feature.type.sba.SkyBlockAddonsMod;
import com.moonsworth.lunar.client.feature.type.scoreboard.ScoreboardMod;
import com.moonsworth.lunar.client.feature.type.screenshot.ScreenshotMod;
import com.moonsworth.lunar.client.feature.type.serveraddress.ServerAddressMod;
import com.moonsworth.lunar.client.feature.type.shinypots.ShinyPotsMod;
import com.moonsworth.lunar.client.feature.type.stopwatch.StopwatchMod;
import com.moonsworth.lunar.client.feature.type.teamview.TeamViewMod;
import com.moonsworth.lunar.client.feature.type.timechanger.TimeChangerMod;
import com.moonsworth.lunar.client.feature.type.togglesneak.ToggleSneakMod;
import com.moonsworth.lunar.client.feature.type.tooltips.ScrollableTooltipsMod;
import com.moonsworth.lunar.client.feature.type.uhc.UHCOverlayMod;
import com.moonsworth.lunar.client.feature.type.waypoints.WaypointsMod;
import com.moonsworth.lunar.client.feature.type.worldedit.WorldEditCUIMod;
import com.moonsworth.lunar.client.feature.type.zoom.ZoomMod;
import com.moonsworth.lunar.client.json.file.JsonFile;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.ref.Ref;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class ModuleManager extends ItemSetLoader<ConfigurableFeature> implements JsonFile {
    public AnimationsMod lIlIlIlIlIIlIIlIIllIIIIIl;
    public FOVMod IlllIIIIIIlllIlIIlllIlIIl;
    public KeyStrokesMod lIllIlIIIlIIIIIIIlllIlIll;
    public AutoTextMod autoTextMod;
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
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(
                   this.IIlIllIlllllllIIlIIIllIIl = new ReplayMod(),
                   this.lIlIlIlIlIIlIIlIIllIIIIIl = new AnimationsMod(),
                   new FPSMod(),
                   new CPSMod(),
                   this.IllIllIIIllIIIlIlIlIIIIll = new SkyBlockAddonsMod(),
                   this.llIIlIlIIIllIlIlIlIIlIIll = new ToggleSneakMod(),
                   this.llllIlIllllIlIlIIIllIlIlI = new ZoomMod(),
                   new HypixelMod(),
                   this.IllllllllllIlIIIlllIlllll = new ArmorStatusMod(),
                   this.lIllIlIIIlIIIIIIIlllIlIll = new KeyStrokesMod(),
                   new CoordinatesMod(),
                   new DayCounterMod(),
                   this.llIlIIIllIIlIllIllIllllIl = new CrosshairMod(),
                   this.lIIIllIllIIllIlllIlIIlllI = new PotionEffectsMod(),
                   new DirectionHudMod(),
                   this.llllIIlIIlIIlIIllIIlIIllI = new WaypointsMod(),
                   new ScoreboardMod(),
                   new PotionCounterMod(),
                   new PingMod(),
                   this.IllIIIlllIIIlIlllIlIIlIII = new MotionBlurMod(),
                   this.llIIIlIllIIIIlIIIlIlIllIl = new ChatMod(),
                   this.IIlIllIlIIllIIlIlIllllllI = new ScrollableTooltipsMod(),
                   new UHCOverlayMod(),
                   this.llIIIIIIIllIIllIlIllIIIIl = new ParticleMultiplierMod(),
                   this.llIllIlIllIlllIllIIIIllII = new NickHiderMod(),
                   this.lIIlIlllIlIlIIIlllIIlIIII = new CooldownsMod(),
                   new WorldEditCUIMod(),
                   new ClockMod(),
                   new StopwatchMod(),
                   new MemoryMod(),
                   new ComboMod(),
                   new RangeMod(),
                   new TimeChangerMod(),
                   new ServerAddressMod(),
                   new SaturationMod(),
                   this.lllllIllIllIllllIlIllllII = new ItemPhysicsMod(),
                   new ItemTrackerMod(),
                   this.IlllllIlIIIlIIlIIllIIlIll = new ShinyPotsMod(),
                   this.IlIlIlllllIlIIlIlIlllIlIl = new BlockOutlineMod(),
                   this.lIlIIIIIIlIIIllllIllIIlII = new ScreenshotMod(),
                   this.IlllIIIIIIlllIlIIlllIlIIl = new FOVMod(),
                   this.autoTextMod = new AutoTextMod(),
                   new NetGraphMod(),
                   new MumbleLinkMod(),
                   this.llIIIlllIIlllIllllIlIllIl = new Items2DMod(),
                   this.lIIIlllIIIIllllIlIIIlIIll = new BossBarMod(),
                   this.lllIIIIIlllIIlIllIIlIIIlI = new FreelookMod(),
                   new TeamViewMod(),
                   new ResourceDisplayMod(),
                   this.lllllIllIlIIlIIlIIIlllIlI = new MenuBlurMod(),
                   this.IlIllIIlIIlIIIllIllllIIll = new HitboxMod()
               );
    }

    public LinkedHashSet<ConfigurableFeature> lIlIlIlIlIIlIIlIIllIIIIIl(ConfigurableFeature... configurableFeatureArray) {
        LinkedHashSet<ConfigurableFeature> linkedHashSet = Sets.newLinkedHashSet();
        linkedHashSet.addAll(Arrays.asList(configurableFeatureArray));
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
            configurableFeature.setupNameFilter();
            if (!configurableFeature.lIlIIIIIIlIIIllllIllIIlII() || configurableFeature instanceof IntergratedServerInterface) continue;
            configurableFeature.lIllIlIIIlIIIIIIIlllIlIll();
        }
        this.load();
    }

    @Override
    public File IlIlIlllllIlIIlIlIlllIlIl() {
        return new File(LunarClient.getInstance().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().getSelectedProfile().getName(), this.llllIIlIIlIIlIIllIIlIIllI());
    }

    @Override
    public void read(JsonObject jsonObject) {
        for (ConfigurableFeature configurableFeature : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                JsonObject jsonObject2 = jsonObject.has(configurableFeature.getDetails().getId()) && !jsonObject.get(configurableFeature.getDetails().getId()).isJsonNull() ? jsonObject.getAsJsonObject(configurableFeature.getDetails().getId()) : new JsonObject();
                configurableFeature.read(jsonObject2);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void write(JsonObject jsonObject) {
        for (ConfigurableFeature configurableFeature : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                JsonObject jsonObject2 = new JsonObject();
                configurableFeature.write(jsonObject2);
                if (jsonObject2.entrySet().isEmpty()) continue;
                jsonObject.add(configurableFeature.getDetails().getId(), jsonObject2);
            } catch (Exception exception) {
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
        return this.autoTextMod;
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
