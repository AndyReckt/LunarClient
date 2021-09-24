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
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.*;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.List;

public class WaypointUIScreen extends AbstractUIScreen {
    public com.moonsworth.lunar.client.ui.component.type.setting.lIIlIlllIlIlIIIlllIIlIIII createWaypointAt;
    public Waypoint waypoint;
    public TextboxWithIcon name;
    public TextboxWithIcon x;
    public TextboxWithIcon y;
    public TextboxWithIcon z;
    public AbstractDescritiveSettingUIComponent<Number> color;
    public DefaultButtonUIComponent save;
    public SmallIconUIComponent back;
    public final boolean IllIllIIIllIIIlIlIlIIIIll;
    public final GuiScreenBridge parentScreen;
    public final float width = 350.0f;
    public final float height = 185.0f;

    public WaypointUIScreen(GuiScreenBridge parent) {
        this(parent, new Waypoint("", Bridge.getInstance().initVec3d(Ref.getPlayer().bridge$getPosX(), Ref.getPlayer().bridge$getBoundingBox().bridge$getMinY(), Ref.getPlayer().bridge$getPosZ()), LunarClient.getInstance().llIIlIlIIIllIlIlIlIIlIIll(), Ref.getWorld().bridge$getDimensionId(), true, false, WaypointsJson.IlllllIlIIIlIIlIIllIIlIll(), (Boolean) ServerIntegration.lIlIlIlIlIIlIIlIIllIIIIIl(ServerRule.SERVER_HANDLES_WAYPOINTS)), false);
    }

    public WaypointUIScreen(GuiScreenBridge parent, Waypoint waypoint) {
        this(parent, waypoint, true);
    }

    public WaypointUIScreen(GuiScreenBridge parent, Waypoint waypoint, boolean bl) {
        this.parentScreen = parent;
        this.waypoint = waypoint;
        this.IllIllIIIllIIIlIlIlIIIIll = bl;
        this.name = new TextboxWithIcon(this.createWaypointAt, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "namePlaceholder", 0x20FFFFFF, 0x35FFFFFF);
        this.x = new TextboxWithIcon(this.createWaypointAt, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "X", 0x20FFFFFF, 0x35FFFFFF);
        this.y = new TextboxWithIcon(this.createWaypointAt, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "Y", 0x20FFFFFF, 0x35FFFFFF);
        this.z = new TextboxWithIcon(this.createWaypointAt, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "Z", 0x20FFFFFF, 0x35FFFFFF);
        this.color = waypoint.getColor().getUIComponent(this.createWaypointAt);
        this.save = new DefaultButtonUIComponent(this.createWaypointAt, "save");
        this.back = new SmallIconUIComponent(null, Bridge.getInstance().initResourceLocation("lunar", "icons/cosmetics/back-40x40.png"));
        this.createWaypointAt.lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of(this.name, this.x, this.y, this.z, this.color, this.save, this.back));
        this.back.lIllIlIIIlIIIIIIIlllIlIll(new ColorEase(0x20FFFFFF, 1358901296));
        this.name.setTyping(true);
        this.save.onMouseClick((float f, float f2, int n) -> {
            try {
                if (this.name.getText().isEmpty() || this.x.getText().isEmpty() || this.y.getText().isEmpty() || this.z.getText().isEmpty()) {
                    return false;
                }
                if (bl) {
                    LunarClient.getInstance().llIllIlIllIlllIllIIIIllII().lIllIlIIIlIIIIIIIlllIlIll(waypoint);
                }
                String string = this.name.getText();
                float f3 = Float.parseFloat(this.x.getText());
                float f4 = Float.parseFloat(this.y.getText());
                float f5 = Float.parseFloat(this.z.getText());
                waypoint.setName(string);
                waypoint.setLocation(Bridge.getInstance().initVec3d(f3, f4, f5));
                if (bl) {
                    LunarClient.getInstance().llIllIlIllIlllIllIIIIllII().IlllIIIIIIlllIlIIlllIlIIl(waypoint);
                } else {
                    LunarClient.getInstance().llIllIlIllIlllIllIIIIllII().lIlIlIlIlIIlIIlIIllIIIIIl(waypoint);
                }
                Ref.getMinecraft().bridge$displayScreen(null);
                return true;
            } catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        });
        this.back.onMouseClick((float f, float f2, int n) -> {
            Ref.getMinecraft().bridge$displayScreen(parent);
            return true;
        });
    }

    @Override
    public List<UIComponent> llIIlIlIIIllIlIlIlIIlIIll() {
        this.createWaypointAt = new lIIlIlllIlIlIIIlllIIlIIII(null, "createAWaypoint") {
            @Override
            public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, float f3, float f4) {
                float f5 = (f3 - 16.0f) / 3.0f - 4.0f;
                WaypointUIScreen.this.name.setPositionAndSize(f + 8.0f, f2 + 32.0f, f3 - 16.0f, 16.0f);
                WaypointUIScreen.this.x.setPositionAndSize(f + 8.0f, f2 + 54.0f, f5, 12.0f);
                WaypointUIScreen.this.y.setPositionAndSize(f + 13.5f + f5, f2 + 54.0f, f5, 12.0f);
                WaypointUIScreen.this.z.setPositionAndSize(f + 19.0f + f5 * 2.0f, f2 + 54.0f, f5, 12.0f);
                WaypointUIScreen.this.save.setPositionAndSize(f + f3 - 56.0f, f2 + 185.0f - 24.0f, 50.0f, 18.0f);
                WaypointUIScreen.this.back.setPositionAndSize(f + 6.0f, f2 + 185.0f - 24.0f, 18.0f, 18.0f);
                WaypointUIScreen.this.color.resoze(f + 8.0f, f2 + 74.0f, f3 - 16.0f);
                if (WaypointUIScreen.this.x.getText().isEmpty()) {
                    WaypointUIScreen.this.x.setText((double)Math.round(WaypointUIScreen.this.waypoint.getLocation().bridge$xCoord() * 100.0) / 100.0 + "");
                    WaypointUIScreen.this.y.setText((double)Math.round(WaypointUIScreen.this.waypoint.getLocation().bridge$yCoord() * 100.0) / 100.0 + "");
                    WaypointUIScreen.this.z.setText((double)Math.round(WaypointUIScreen.this.waypoint.getLocation().bridge$zCoord() * 100.0) / 100.0 + "");
                    WaypointUIScreen.this.color.onMouseClicked(WaypointUIScreen.this.color.getX(), WaypointUIScreen.this.color.getY(), 0);
                    WaypointUIScreen.this.name.setText(WaypointUIScreen.this.waypoint.getName());
                }
            }
        };
        return ImmutableList.of(this.createWaypointAt);
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        float f = this.IllllllllllIlIIIlllIlllll() / 2.0f - 175.0f;
        float f2 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 92.5f;
        this.createWaypointAt.setPositionAndSize(f, f2, 350.0f, 185.0f);
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
