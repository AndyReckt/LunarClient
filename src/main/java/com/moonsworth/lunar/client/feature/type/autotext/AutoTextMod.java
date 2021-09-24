package com.moonsworth.lunar.client.feature.type.autotext;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.HKTextSetting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoTextMod
    extends ConfigurableFeature {
    public List<HKTextSetting> llllIIlIIlIIlIIllIIlIIllI;
    public HKTextSetting IlIlIlllllIlIIlIlIlllIlIl;
    public HKTextSetting llIIIIIIIllIIllIlIllIIIIl;
    public HKTextSetting lIIIllIllIIllIlllIlIIlllI;
    public HKTextSetting IlllllIlIIIlIIlIIllIIlIll;
    public HKTextSetting llIIlIlIIIllIlIlIlIIlIIll;
    public HKTextSetting llIIIlllIIlllIllllIlIllIl;
    public HKTextSetting lllIIIIIlllIIlIllIIlIIIlI;
    public HKTextSetting lIlIIIIIIlIIIllllIllIIlII;
    public HKTextSetting llIlIIIllIIlIllIllIllllIl;
    public HKTextSetting IllIllIIIllIIIlIlIlIIIIll;
    public HKTextSetting IIlIllIlllllllIIlIIIllIIl;
    public HKTextSetting lIIlIlllIlIlIIIlllIIlIIII;
    public HKTextSetting llIllIlIllIlllIllIIIIllII;
    public HKTextSetting IllllllllllIlIIIlllIlllll;
    public HKTextSetting lllllIllIlIIlIIlIIIlllIlI;
    public final Map<HKTextSetting, Integer> IllIIIlllIIIlIlllIlIIlIII = new HashMap<>();
    public final Map IIlIllIlIIllIIlIlIllllllI = new HashMap();
    public long lIIIlllIIIIllllIlIIIlIIll;

    public AutoTextMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, tickEvent -> {
            if (Ref.getPlayer() != null && Ref.getPlayer().bridge$isBlocking()) {
                this.lIIIlllIIIIllllIlIIIlIIll = System.currentTimeMillis();
            }
        });
    }

    @Override
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        this.IlIlIlllllIlIIlIlIlllIlIl = this.IlllIIIIIIlllIlIIlllIlIIl(1);
        this.llIIIIIIIllIIllIlIllIIIIl = this.IlllIIIIIIlllIlIIlllIlIIl(2);
        this.lIIIllIllIIllIlllIlIIlllI = this.IlllIIIIIIlllIlIIlllIlIIl(3);
        this.IlllllIlIIIlIIlIIllIIlIll = this.IlllIIIIIIlllIlIIlllIlIIl(4);
        this.llIIlIlIIIllIlIlIlIIlIIll = this.IlllIIIIIIlllIlIIlllIlIIl(5);
        this.llIIIlllIIlllIllllIlIllIl = this.IlllIIIIIIlllIlIIlllIlIIl(6);
        this.lllIIIIIlllIIlIllIIlIIIlI = this.IlllIIIIIIlllIlIIlllIlIIl(7);
        this.lIlIIIIIIlIIIllllIllIIlII = this.IlllIIIIIIlllIlIIlllIlIIl(8);
        this.llIlIIIllIIlIllIllIllllIl = this.IlllIIIIIIlllIlIIlllIlIIl(9);
        this.IllIllIIIllIIIlIlIlIIIIll = this.IlllIIIIIIlllIlIIlllIlIIl(10);
        this.IIlIllIlllllllIIlIIIllIIl = this.IlllIIIIIIlllIlIIlllIlIIl(11);
        this.lIIlIlllIlIlIIIlllIIlIIII = this.IlllIIIIIIlllIlIIlllIlIIl(12);
        this.llIllIlIllIlllIllIIIIllII = this.IlllIIIIIIlllIlIIlllIlIIl(13);
        this.llllIIlIIlIIlIIllIIlIIllI = ImmutableList.of(this.IlIlIlllllIlIIlIlIlllIlIl, this.llIIIIIIIllIIllIlIllIIIIl, this.lIIIllIllIIllIlllIlIIlllI, this.IlllllIlIIIlIIlIIllIIlIll, this.llIIlIlIIIllIlIlIlIIlIIll, this.llIIIlllIIlllIllllIlIllIl, this.lllIIIIIlllIIlIllIIlIIIlI, this.lIlIIIIIIlIIIllllIllIIlII, this.llIlIIIllIIlIllIllIllllIl, this.IllIllIIIllIIIlIlIlIIIIll, this.IIlIllIlllllllIIlIIIllIIl, this.lIIlIlllIlIlIIIlllIIlIIII, this.llIllIlIllIlllIllIIIIllII, this.IllllllllllIlIIIlllIlllll = this.IlllIIIIIIlllIlIIlllIlIIl(14), this.lllllIllIlIIlIIlIIIlllIlI = this.IlllIIIIIIlllIlIIlllIlIIl(15));
        return ImmutableList.of(this.IlIlIlllllIlIIlIlIlllIlIl, this.llIIIIIIIllIIllIlIllIIIIl, this.lIIIllIllIIllIlllIlIIlllI, this.IlllllIlIIIlIIlIIllIIlIll, this.llIIlIlIIIllIlIlIlIIlIIll, this.llIIIlllIIlllIllllIlIllIl, this.lllIIIIIlllIIlIllIIlIIIlI, this.lIlIIIIIIlIIIllllIllIIlII, this.llIlIIIllIIlIllIllIllllIl, this.IllIllIIIllIIIlIlIlIIIIll, this.IIlIllIlllllllIIlIIIllIIl, this.lIIlIlllIlIlIIIlllIIlIIII, this.llIllIlIllIlllIllIIIIllII, this.IllllllllllIlIIIlllIlllll, this.lllllIllIlIIlIIlIIIlllIlI);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Auto-Text", f, f2, f3, f4);
    }

    @Override
    public FeatureDetails initDetails() {
        return new FeatureDetails("textHotKey", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.MECHANIC));
    }

    public HKTextSetting IlllIIIIIIlllIlIIlllIlIIl(int n) {
        HKTextSetting hKTextSetting = new HKTextSetting(this, n + "_hk", "/Command", KeyType.KEY_NONE);
        hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(true).lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (Ref.getPlayer() != null && (Ref.getPlayer().bridge$isUsingItem() || Ref.getPlayer().bridge$isBlocking() || System.currentTimeMillis() - this.lIIIlllIIIIllllIlIIIlIIll < 100L)) {
                return;
            }
            if (hKTextSetting.llIlllIIIllllIIlllIllIIIl().equalsIgnoreCase("/Command")) {
                return;
            }
            if (this.IIlIllIlIIllIIlIlIllllllI.containsKey(hKTextSetting) && System.currentTimeMillis() - (Long)this.IIlIllIlIIllIIlIlIllllllI.get(hKTextSetting) < 1000L) {
                this.IllIIIlllIIIlIlllIlIIlIII.put(hKTextSetting, this.IllIIIlllIIIlIlllIlIIlIII.getOrDefault(hKTextSetting, 0) + 1);
                if (this.IllIIIlllIIIlIlllIlIIlIII.get(hKTextSetting) > 2) {
                    return;
                }
            } else {
                this.IllIIIlllIIIlIlllIlIIlIII.remove(hKTextSetting);
            }
            this.IIlIllIlIIllIIlIlIllllllI.put(hKTextSetting, System.currentTimeMillis());
            Ref.getPlayer().bridge$sendChatMessage(hKTextSetting.llIlllIIIllllIIlllIllIIIl());
        });
        return hKTextSetting;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        for (HKTextSetting hKTextSetting : this.llllIIlIIlIIlIIllIIlIIllI) {
            if (hKTextSetting.lIIlIlllIlIlIIIlllIIlIIII().equalsIgnoreCase(string) || !hKTextSetting.IlllIIIIIIlllIlIIlllIlIIl())
                continue;
            hKTextSetting.lIlIlIlIlIIlIIlIIllIIIIIl(false);
        }
    }
}