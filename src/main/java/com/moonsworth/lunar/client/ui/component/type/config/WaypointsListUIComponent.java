package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.type.waypoints.Waypoint;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.ScrollbarUIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaypointsListUIComponent extends AbstractListUIComponent {
    public List<WaypointUIComponent> waypoints;
    public ScrollbarUIComponent scrollbar = new ScrollbarUIComponent(this);

    public WaypointsListUIComponent(UIComponent parent) {
        super(parent);
        this.onMouseClick((float f, float f2, int n) -> {
            for (WaypointUIComponent waypointUIComponent : this.waypoints) {
                if (!waypointUIComponent.mouseInside(f, f2 - this.scrollbar.getYOffset())) continue;
                return waypointUIComponent.onMouseClicked(f, f2, n);
            }
            return this.scrollbar.mouseInside(f, f2) && this.scrollbar.onMouseClicked(f, f2, n);
        });
        ArrayList<WaypointUIComponent> arrayList = new ArrayList<WaypointUIComponent>();
        for (Waypoint waypoint : this.lc.llIllIlIllIlllIllIIIIllII().llIlllIIIllllIIlllIllIIIl()) {
            if (!waypoint.lIlIlIlIlIIlIIlIIllIIIIIl()) continue;
            arrayList.add(new WaypointUIComponent(this, waypoint));
        }
        this.waypoints = Collections.synchronizedList(arrayList);
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        float f5 = 0.0f;
        int n = 0;
        int n2 = 0;
        float f6 = 20.0f;
        float f7 = 182.0f;
        for (WaypointUIComponent waypointUIComponent : this.waypoints) {
            if (n == 2) {
                n = 0;
                ++n2;
            }
            waypointUIComponent.setPositionAndSize(x + (f7 + 8.0f) * (float)n, y + 2.0f + (f6 + 8.0f) * (float)n2, f7, f6);
            ++n;
        }
        this.scrollbar.setPositionAndSize(x + width - 6.0f, y, 4.0f, height - 20.0f);
        this.scrollbar.setContentHeight(n2 == 0 ? f6 + 4.0f : 4.0f + f6 + (f6 + 8.0f) * (float)n2);
    }

    @Override
    public List lIllIlIIIlIIIIIIIlllIlIll() {
        return new ArrayList();
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        if (!this.waypoints.isEmpty()) {
            Object object;
            GL11.glEnable(3089);
            float f3 = 0.0f;
            if (this.mc.bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge) {
                WrappedGuiScreenBridge var5 = (WrappedGuiScreenBridge)this.mc.bridge$getCurrentScreen();
                if (var5.getCustomScreen() instanceof AbstractUIScreen) {
                    AbstractUIScreen var6 = (AbstractUIScreen)var5.getCustomScreen();
                    f3 = var6.lllllIllIlIIlIIlIIIlllIlI();
                }
            }
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x - 2.0f), (int)this.y, (int)(this.x + this.width + 2.0f), (int)(this.y + this.height + 5.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)f3);
            this.scrollbar.onDraw(mouseX, mouseY, bl);
            for (I18nBridge i18nBridge : this.waypoints) {
                boolean bl2;
                boolean bl3 = ((UIComponent)i18nBridge).getY() + ((UIComponent)i18nBridge).getHeight() + this.scrollbar.getYOffset() < this.scrollbar.getY();
                boolean bl4 = bl2 = ((UIComponent)i18nBridge).getY() + this.scrollbar.getYOffset() > this.scrollbar.getY() + this.scrollbar.getHeight();
                if (!(((UIComponent)i18nBridge).getX() >= this.x) || bl3 || bl2) continue;
                ((UIComponent)i18nBridge).drawComponent(mouseX, mouseY - this.scrollbar.getYOffset(), bl && !this.scrollbar.lIIIllIllIIllIlllIlIIlllI());
            }
            this.scrollbar.llllIIlIIlIIlIIllIIlIIllI(mouseX, mouseY, bl);
            GL11.glDisable(3089);
        } else {
            FontRegistry.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(this.get("noWaypointsSet"), this.x + this.width / 2.0f, this.y + 30.0f, -1342177281);
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        super.drawComponent(mouseX, mouseY, bl);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        super.onKeyTyped(c, keyType);
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        this.scrollbar.handleMouseScrollDelta(n);
        super.handleMouseScrollDelta(n);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }

    public List llllIIlIIlIIlIIllIIlIIllI() {
        return this.waypoints;
    }

    public ScrollbarUIComponent llIIIIIIIllIIllIlIllIIIIl() {
        return this.scrollbar;
    }
}
