package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.type.waypoints.Waypoint;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.IconButtonUIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.waypoint.WaypointUIScreen;

public class WaypointUIComponent
    extends UIComponent {
    public final Waypoint lIlIlIlIlIIlIIlIIllIIIIIl;
    public final ColorEase IlllIIIIIIlllIlIIlllIlIIl = new ColorEase(542594903, 1348953959);
    public final IconButtonUIComponent lIllIlIIIlIIIIIIIlllIlIll;
    public final IconButtonUIComponent llIlIIIllIIlIllIllIllllIl;
    public final IconButtonUIComponent IllIllIIIllIIIlIlIlIIIIll;
    public final ResourceLocationBridge IIlIllIlllllllIIlIIIllIIl = Bridge.getInstance().initResourceLocation("lunar", "icons/cross.png");

    public WaypointUIComponent(UIComponent parent, Waypoint waypoint) {
        super(parent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = waypoint;
        this.lIllIlIIIlIIIIIIIlllIlIll = new IconButtonUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/pencil-24.png"), 4.5f);
        this.llIlIIIllIIlIllIllIllllIl = new IconButtonUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/eye-24.png"), 6.0f);
        this.IllIllIIIllIIIlIlIlIIIIll = new IconButtonUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/mainmenu/exit-17x17.png"), 4.25f);
        this.onMouseClick((float f, float f2, int n) -> {
            if (this.llIlIIIllIIlIllIllIllllIl.mouseInside(f, f2)) {
                waypoint.setVisible(!waypoint.isVisible());
            } else if (this.IllIllIIIllIIIlIlIlIIIIll.mouseInside(f, f2) && !waypoint.isForced()) {
                if (LunarClient.getInstance().llIllIlIllIlllIllIIIIllII().llIlllIIIllllIIlllIllIIIl(waypoint)) {
                    ((WaypointsListUIComponent)parent).llllIIlIIlIIlIIllIIlIIllI().removeIf(waypointUIComponent -> waypointUIComponent == this);
                }
            } else if (!waypoint.isForced()) {
                Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new WaypointUIScreen(Ref.getMinecraft().bridge$getCurrentScreen(), waypoint)));
            }
            return true;
        });
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.0f, 0, 0, this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY)));
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, 4.0f, 0x20E2E2E2);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x + 4.0f, this.y + 4.0f, this.height - 8.0f, this.height - 8.0f, 5.0f, 0xFF000000 | this.lIlIlIlIlIIlIIlIIllIIIIIl.getColor().lIlIlIlIlIIlIIlIIllIIIIIl(0.0f));
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 5.0f, this.y + 5.0f, this.height - 10.0f, this.height - 10.0f, 2.5f, -1342177281, true, true, true, true);
        FontRegistry.IlIlIlllllIlIIlIlIlllIlIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.getName(), this.x + 20.0f, this.y + 5.0f, -1);
        this.lIllIlIIIlIIIIIIIlllIlIll.setPosition(this.x + this.width - (this.lIlIlIlIlIIlIIlIIllIIIIIl.isForced() ? 20.0f : 55.0f), this.y + 2.5f);
        this.lIllIlIIIlIIIIIIIlllIlIll.drawComponent(mouseX, mouseY, bl);
        this.llIlIIIllIIlIllIllIllllIl.setPosition(this.x + this.width - (this.lIlIlIlIlIIlIIlIIllIIIIIl.isForced() ? 20.0f : 40.0f), this.y + 1.0f);
        this.llIlIIIllIIlIllIllIllllIl.drawComponent(mouseX, mouseY, bl);
        if (!this.lIlIlIlIlIIlIIlIIllIIIIIl.isVisible()) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlIllIlllllllIIlIIIllIIl, 6.0f, this.x + this.width - (this.lIlIlIlIlIIlIIlIIllIIIIIl.isForced() ? 20.0f : 40.0f) + 2.0f, this.y + 4.5f);
        }
        if (!this.lIlIlIlIlIIlIIlIIllIIIIIl.isForced()) {
            this.IllIllIIIllIIIlIlIlIIIIll.setPosition(this.x + this.width - 20.0f, this.y + 4.0f);
            this.IllIllIIIllIIIlIlIlIIIIll.drawComponent(mouseX, mouseY, bl);
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }
}
