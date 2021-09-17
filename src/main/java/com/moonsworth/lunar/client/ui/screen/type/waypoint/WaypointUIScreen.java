package com.moonsworth.lunar.client.ui.screen.type.waypoint;

import com.google.common.collect.ImmutableList;
import com.lunarclient.bukkitapi.nethandler.client.obj.ServerRule;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.type.waypoints.Waypoint;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.registry.WaypointsJson;
import com.moonsworth.lunar.client.server.ServerIntegration;
import com.moonsworth.lunar.client.ui.component.type.setting.*;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.List;

public class WaypointUIScreen
extends AbstractUIScreen {
    public com.moonsworth.lunar.client.ui.component.type.setting.lIIlIlllIlIlIIIlllIIlIIII lIlIlIlIlIIlIIlIIllIIIIIl;
    public Waypoint waypoint;
    public lllllIllIlIIlIIlIIIlllIlI lIllIlIIIlIIIIIIIlllIlIll;
    public lllllIllIlIIlIIlIIIlllIlI llIlllIIIllllIIlllIllIIIl;
    public lllllIllIlIIlIIlIIIlllIlI llIIIlllIIlllIllllIlIllIl;
    public lllllIllIlIIlIIlIIIlllIlI lllllIllIllIllllIlIllllII;
    public AbstractDescritiveSettingUIComponent lllIIIIIlllIIlIllIIlIIIlI;
    public IlllIIIIIIlllIlIIlllIlIIl lIlIIIIIIlIIIllllIllIIlII;
    public llIllIlIllIlllIllIIIIllII llIlIIIllIIlIllIllIllllIl; // llIllIlIllIlllIllIIIIllII
    public final boolean IllIllIIIllIIIlIlIlIIIIll;
    public final GuiScreenBridge IIlIllIlllllllIIlIIIllIIl;
    public final float width = 350.0f;
    public final float height = 185.0f;

    public WaypointUIScreen(GuiScreenBridge guiScreenBridge) {
        this(guiScreenBridge, new Waypoint("", Bridge.llIlllIIIllllIIlllIllIIIl().initVec3d(Ref.IlIlIlllllIlIIlIlIlllIlIl().bridge$getPosX(), Ref.IlIlIlllllIlIIlIlIlllIlIl().bridge$getBoundingBox().bridge$getMinY(), Ref.IlIlIlllllIlIIlIlIlllIlIl().bridge$getPosZ()), LunarClient.IIllIlIllIlIllIllIllIllII().llIIlIlIIIllIlIlIlIIlIIll(), Ref.llIIIIIIIllIIllIlIllIIIIl().bridge$getDimensionId(), true, false, WaypointsJson.IlllllIlIIIlIIlIIllIIlIll(), (Boolean) ServerIntegration.lIlIlIlIlIIlIIlIIllIIIIIl(ServerRule.SERVER_HANDLES_WAYPOINTS)), false);
    }

    public WaypointUIScreen(GuiScreenBridge guiScreenBridge, Waypoint waypoint) {
        this(guiScreenBridge, waypoint, true);
    }

    public WaypointUIScreen(GuiScreenBridge guiScreenBridge, Waypoint waypoint, boolean bl) {
        this.IIlIllIlllllllIIlIIIllIIl = guiScreenBridge;
        this.waypoint = waypoint;
        this.IllIllIIIllIIIlIlIlIIIIll = bl;
        this.lIllIlIIIlIIIIIIIlllIlIll = new lllllIllIlIIlIIlIIIlllIlI(this.lIlIlIlIlIIlIIlIIllIIIIIl, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "namePlaceholder", 0x20FFFFFF, 0x35FFFFFF);
        this.llIlllIIIllllIIlllIllIIIl = new lllllIllIlIIlIIlIIIlllIlI(this.lIlIlIlIlIIlIIlIIllIIIIIl, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "X", 0x20FFFFFF, 0x35FFFFFF);
        this.llIIIlllIIlllIllllIlIllIl = new lllllIllIlIIlIIlIIIlllIlI(this.lIlIlIlIlIIlIIlIIllIIIIIl, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "Y", 0x20FFFFFF, 0x35FFFFFF);
        this.lllllIllIllIllllIlIllllII = new lllllIllIlIIlIIlIIIlllIlI(this.lIlIlIlIlIIlIIlIIllIIIIIl, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "Z", 0x20FFFFFF, 0x35FFFFFF);
        this.lllIIIIIlllIIlIllIIlIIIlI = waypoint.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIIIIIIlIIIllllIllIIlII = new IlllIIIIIIlllIlIIlllIlIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl, "save");
        this.llIlIIIllIIlIllIllIllllIl = new llIllIlIllIlllIllIIIIllII(null, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/cosmetics/back-40x40.png"));
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of(this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl, this.llIIIlllIIlllIllllIlIllIl, this.lllllIllIllIllllIlIllllII, this.lllIIIIIlllIIlIllIIlIIIlI, this.lIlIIIIIIlIIIllllIllIIlII, this.llIlIIIllIIlIllIllIllllIl));
        this.llIlIIIllIIlIllIllIllllIl.lIllIlIIIlIIIIIIIlllIlIll(new ColorEase(0x20FFFFFF, 1358901296));
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(true);
        this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            try {
                if (this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI().isEmpty() || this.llIlllIIIllllIIlllIllIIIl.llllIIlIIlIIlIIllIIlIIllI().isEmpty() || this.llIIIlllIIlllIllllIlIllIl.llllIIlIIlIIlIIllIIlIIllI().isEmpty() || this.lllllIllIllIllllIlIllllII.llllIIlIIlIIlIIllIIlIIllI().isEmpty()) {
                    return false;
                }
                if (bl) {
                    LunarClient.IIllIlIllIlIllIllIllIllII().llIllIlIllIlllIllIIIIllII().lIllIlIIIlIIIIIIIlllIlIll(waypoint);
                }
                String string = this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI();
                float f3 = Float.parseFloat(this.llIlllIIIllllIIlllIllIIIl.llllIIlIIlIIlIIllIIlIIllI());
                float f4 = Float.parseFloat(this.llIIIlllIIlllIllllIlIllIl.llllIIlIIlIIlIIllIIlIIllI());
                float f5 = Float.parseFloat(this.lllllIllIllIllllIlIllllII.llllIIlIIlIIlIIllIIlIIllI());
                waypoint.IlllIIIIIIlllIlIIlllIlIIl(string);
                waypoint.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.llIlllIIIllllIIlllIllIIIl().initVec3d(f3, f4, f5));
                if (bl) {
                    LunarClient.IIllIlIllIlIllIllIllIllII().llIllIlIllIlllIllIIIIllII().IlllIIIIIIlllIlIIlllIlIIl(waypoint);
                } else {
                    LunarClient.IIllIlIllIlIllIllIllIllII().llIllIlIllIlllIllIIIIllII().lIlIlIlIlIIlIIlIIllIIIIIl(waypoint);
                }
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(null);
                return true;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        });
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(guiScreenBridge);
            return true;
        });
    }

    @Override
    public List llIIlIlIIIllIlIlIlIIlIIll() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new lIIlIlllIlIlIIIlllIIlIIII(null, "createAWaypoint"){

            @Override
            public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, float f3, float f4) {
                float f5 = (f3 - 16.0f) / 3.0f - 4.0f;
                WaypointUIScreen.this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f + 8.0f, f2 + 32.0f, f3 - 16.0f, 16.0f);
                WaypointUIScreen.this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + 8.0f, f2 + 54.0f, f5, 12.0f);
                WaypointUIScreen.this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + 13.5f + f5, f2 + 54.0f, f5, 12.0f);
                WaypointUIScreen.this.lllllIllIllIllllIlIllllII.lIlIlIlIlIIlIIlIIllIIIIIl(f + 19.0f + f5 * 2.0f, f2 + 54.0f, f5, 12.0f);
                WaypointUIScreen.this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 56.0f, f2 + 185.0f - 24.0f, 50.0f, 18.0f);
                WaypointUIScreen.this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + 6.0f, f2 + 185.0f - 24.0f, 18.0f, 18.0f);
                WaypointUIScreen.this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(f + 8.0f, f2 + 74.0f, f3 - 16.0f);
                if (WaypointUIScreen.this.llIlllIIIllllIIlllIllIIIl.llllIIlIIlIIlIIllIIlIIllI().isEmpty()) {
                    WaypointUIScreen.this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl((double)Math.round(WaypointUIScreen.this.waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$xCoord() * 100.0) / 100.0 + "");
                    WaypointUIScreen.this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl((double)Math.round(WaypointUIScreen.this.waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$yCoord() * 100.0) / 100.0 + "");
                    WaypointUIScreen.this.lllllIllIllIllllIlIllllII.lIlIlIlIlIIlIIlIIllIIIIIl((double)Math.round(WaypointUIScreen.this.waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$zCoord() * 100.0) / 100.0 + "");
                    WaypointUIScreen.this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(WaypointUIScreen.this.lllIIIIIlllIIlIllIIlIIIlI.lllIIIIIlllIIlIllIIlIIIlI(), WaypointUIScreen.this.lllIIIIIlllIIlIllIIlIIIlI.lIlIIIIIIlIIIllllIllIIlII(), 0);
                    WaypointUIScreen.this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(WaypointUIScreen.this.waypoint.IlllIIIIIIlllIlIIlllIlIIl());
                }
            }
        };
        return ImmutableList.of(this.lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        float f = this.IllllllllllIlIIIlllIlllll() / 2.0f - 175.0f;
        float f2 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 92.5f;
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, 350.0f, 185.0f);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(char c, KeyType keyType) {
    }

    @Override
    public void lIlIIIIIIlIIIllllIllIIlII() {
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }
}
 