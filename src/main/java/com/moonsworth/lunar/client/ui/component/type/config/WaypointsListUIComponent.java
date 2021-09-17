package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.type.waypoints.Waypoint;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.IIlIllIlIIllIIlIlIllllllI;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaypointsListUIComponent
extends AbstractListUIComponent {
    public List<WaypointUIComponent> lIlIlIlIlIIlIIlIIllIIIIIl;
    public IIlIllIlIIllIIlIlIllllllI IlllIIIIIIlllIlIIlllIlIIl = new IIlIllIlIIllIIlIlIllllllI(this);

    public WaypointsListUIComponent(UIComponent parent) {
        super(parent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            for (WaypointUIComponent waypointUIComponent : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!waypointUIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll())) continue;
                return waypointUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            return this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        });
        ArrayList<WaypointUIComponent> arrayList = new ArrayList<WaypointUIComponent>();
        for (Waypoint waypoint : this.lIlIIIIIIlIIIllllIllIIlII.llIllIlIllIlllIllIIIIllII().llIlllIIIllllIIlllIllIIIl()) {
            if (!waypoint.lIlIlIlIlIIlIIlIIllIIIIIl()) continue;
            arrayList.add(new WaypointUIComponent(this, waypoint));
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl = Collections.synchronizedList(arrayList);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        float f5 = 0.0f;
        int n = 0;
        int n2 = 0;
        float f6 = 20.0f;
        float f7 = 182.0f;
        for (WaypointUIComponent waypointUIComponent : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            if (n == 2) {
                n = 0;
                ++n2;
            }
            waypointUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f + (f7 + 8.0f) * (float)n, f2 + 2.0f + (f6 + 8.0f) * (float)n2, f7, f6);
            ++n;
        }
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 6.0f, f2, 4.0f, f4 - 20.0f);
        this.IlllIIIIIIlllIlIIlllIlIIl.IlIlIlllllIlIIlIlIlllIlIl(n2 == 0 ? f6 + 4.0f : 4.0f + f6 + (f6 + 8.0f) * (float)n2);
    }

    @Override
    public List lIllIlIIIlIIIIIIIlllIlIll() {
        return new ArrayList();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        if (!this.lIlIlIlIlIIlIIlIIllIIIIIl.isEmpty()) {
            Object object;
            GL11.glEnable((int)3089);
            float f3 = 0.0f;
            if (this.lllIIIIIlllIIlIllIIlIIIlI.bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge) {
                WrappedGuiScreenBridge var5 = (WrappedGuiScreenBridge)this.lllIIIIIlllIIlIllIIlIIIlI.bridge$getCurrentScreen();
                if (var5.getCustomScreen() instanceof AbstractUIScreen) {
                    AbstractUIScreen var6 = (AbstractUIScreen)var5.getCustomScreen();
                    f3 = var6.lllllIllIlIIlIIlIIIlllIlI();
                }
            }
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x - 2.0f), (int)this.y, (int)(this.x + this.width + 2.0f), (int)(this.y + this.height + 5.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)f3);
            this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2, bl);
            for (I18nBridge i18nBridge : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                boolean bl2;
                boolean bl3 = ((UIComponent)i18nBridge).lIlIIIIIIlIIIllllIllIIlII() + ((UIComponent)i18nBridge).IllIllIIIllIIIlIlIlIIIIll() + this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll() < this.IlllIIIIIIlllIlIIlllIlIIl.lIlIIIIIIlIIIllllIllIIlII();
                boolean bl4 = bl2 = ((UIComponent)i18nBridge).lIlIIIIIIlIIIllllIllIIlII() + this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll() > this.IlllIIIIIIlllIlIIlllIlIIl.lIlIIIIIIlIIIllllIllIIlII() + this.IlllIIIIIIlllIlIIlllIlIIl.IllIllIIIllIIIlIlIlIIIIll();
                if (!(((UIComponent)i18nBridge).lllIIIIIlllIIlIllIIlIIIlI() >= this.x) || bl3 || bl2) continue;
                ((UIComponent)i18nBridge).lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll(), bl && !this.IlllIIIIIIlllIlIIlllIlIIl.lIIIllIllIIllIlllIlIIlllI());
            }
            this.IlllIIIIIIlllIlIIlllIlIIl.llllIIlIIlIIlIIllIIlIIllI(f, f2, bl);
            GL11.glDisable((int)3089);
        } else {
            FontRegistry.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(this.get("noWaypointsSet", new Object[0]), this.x + this.width / 2.0f, this.y + 30.0f, -1342177281);
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
        super.IlllIIIIIIlllIlIIlllIlIIl();
    }

    public List llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public IIlIllIlIIllIIlIlIllllllI llIIIIIIIllIIllIlIllIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}
 