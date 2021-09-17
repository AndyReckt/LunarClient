package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.type.waypoints.Waypoint;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.IllllllllllIlIIIlllIlllll;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.waypoint.WaypointUIScreen;

public class WaypointUIComponent
extends UIComponent {
    public final Waypoint lIlIlIlIlIIlIIlIIllIIIIIl;
    public final ColorEase IlllIIIIIIlllIlIIlllIlIIl = new ColorEase(542594903, 1348953959);
    public final IllllllllllIlIIIlllIlllll lIllIlIIIlIIIIIIIlllIlIll;
    public final IllllllllllIlIIIlllIlllll llIlIIIllIIlIllIllIllllIl;
    public final IllllllllllIlIIIlllIlllll IllIllIIIllIIIlIlIlIIIIll;
    public final ResourceLocationBridge IIlIllIlllllllIIlIIIllIIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/cross.png");

    public WaypointUIComponent(UIComponent parent, Waypoint waypoint) {
        super(parent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = waypoint;
        this.lIllIlIIIlIIIIIIIlllIlIll = new IllllllllllIlIIIlllIlllll(this, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/pencil-24.png"), 4.5f);
        this.llIlIIIllIIlIllIllIllllIl = new IllllllllllIlIIIlllIlllll(this, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/eye-24.png"), 6.0f);
        this.IllIllIIIllIIIlIlIlIIIIll = new IllllllllllIlIIIlllIlllll(this, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/mainmenu/exit-17x17.png"), 4.25f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                waypoint.lIlIlIlIlIIlIIlIIllIIIIIl(!waypoint.IlIlIlllllIlIIlIlIlllIlIl());
            } else if (this.IllIllIIIllIIIlIlIlIIIIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && !waypoint.llIIIIIIIllIIllIlIllIIIIl()) {
                if (LunarClient.IIllIlIllIlIllIllIllIllII().llIllIlIllIlllIllIIIIllII().llIlllIIIllllIIlllIllIIIl(waypoint)) {
                    ((WaypointsListUIComponent)parent).llllIIlIIlIIlIIllIIlIIllI().removeIf(waypointUIComponent -> waypointUIComponent == this);
                }
            } else if (!waypoint.llIIIIIIIllIIllIlIllIIIIl()) {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new WaypointUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen(), waypoint)));
            }
            return true;
        });
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.0f, 0, 0, this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)));
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, 4.0f, 0x20E2E2E2);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x + 4.0f, this.y + 4.0f, this.height - 8.0f, this.height - 8.0f, 5.0f, 0xFF000000 | this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(0.0f));
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 5.0f, this.y + 5.0f, this.height - 10.0f, this.height - 10.0f, 2.5f, -1342177281, true, true, true, true);
        FontRegistry.IlIlIlllllIlIIlIlIlllIlIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(), this.x + 20.0f, this.y + 5.0f, -1);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.width - (this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIIIIIIllIIllIlIllIIIIl() ? 20.0f : 55.0f), this.y + 2.5f);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.width - (this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIIIIIIllIIllIlIllIIIIl() ? 20.0f : 40.0f), this.y + 1.0f);
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        if (!this.lIlIlIlIlIIlIIlIIllIIIIIl.IlIlIlllllIlIIlIlIlllIlIl()) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlIllIlllllllIIlIIIllIIl, 6.0f, this.x + this.width - (this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIIIIIIllIIllIlIllIIIIl() ? 20.0f : 40.0f) + 2.0f, this.y + 4.5f);
        }
        if (!this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIIIIIIllIIllIlIllIIIIl()) {
            this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.width - 20.0f, this.y + 4.0f);
            this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}
 