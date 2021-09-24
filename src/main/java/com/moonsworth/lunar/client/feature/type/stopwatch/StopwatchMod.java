package com.moonsworth.lunar.client.feature.type.stopwatch;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudMod;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudModSize;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;

import java.util.List;

public class StopwatchMod extends SimpleHudMod {
    public boolean IllIIIlllIIIlIlllIlIIlIII = false;
    public long IIlIllIlIIllIIlIlIllllllI = -1L;
    public long lIIIlllIIIIllllIlIIIlIIll = -1L;
    public LunarKeybindSetting llIIIlIllIIIIlIIIlIlIllIl;
    public BooleanSetting llllIlIllllIlIlIIIllIlIlI;

    public StopwatchMod() {
        super(false, HudModPosition.TOP_RIGHT);
        this.llIIIlIllIIIIlIIIlIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (this.IllIIIlllIIIlIlllIlIIlIII) {
                this.IllIIIlllIIIlIlllIlIIlIII = false;
                this.lIIIlllIIIIllllIlIIIlIIll = System.currentTimeMillis();
            } else {
                this.IllIIIlllIIIlIlllIlIIlIII = true;
                this.lIIIlllIIIIllllIlIIIlIIll = -1L;
                if (this.llllIlIllllIlIlIIIllIlIlI.llIlllIIIllllIIlllIllIIIl() || this.IIlIllIlIIllIIlIlIllllllI == -1L) {
                    this.IIlIllIlIIllIIlIlIllllllI = System.currentTimeMillis();
                }
            }

        });
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(-10.0F, 30.0F);
    }

    public String IlIlIlIlIIIlIIlIIlllIllIl() {
        return "[10.93s]";
    }

    public SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI() {
        return new SimpleHudModSize(10, 18, 22, 44, 56, 62);
    }

    public String lllllIlIllIlIlllIIIlIIlIl() {
        long var1 = System.currentTimeMillis();
        long var3 = (this.lIIIlllIIIIllllIlIIIlIIll == -1L ? var1 : this.lIIIlllIIIIllllIlIIIlIIll) - this.IIlIllIlIIllIIlIlIllllllI;
        String var5 = String.format("%.2f", (float)var3 / 1000.0F) + "s";
        if (this.IIlIllIlIIllIIlIlIllllllI == -1L && this.lIIIlllIIIIllllIlIIIlIIll == -1L && !this.IllIIIlllIIIlIlllIlIIlIII) {
            var5 = "0.00s";
        }

        return var5;
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("stopwatch");
    }

    public List IIIIIIIIIIIIIIIllllIIlIIl() {
        return ImmutableList.of(this.llIIIlIllIIIIlIIIlIlIllIl = new LunarKeybindSetting(this, "stopwatch", KeyType.KEY_U), this.llllIlIllllIlIlIIIllIlIlI = new BooleanSetting("resetEveryStart", true));
    }
}
