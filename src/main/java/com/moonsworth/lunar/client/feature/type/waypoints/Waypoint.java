package com.moonsworth.lunar.client.feature.type.waypoints;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.util.Vec3Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.WaypointsJson;
import com.moonsworth.lunar.client.setting.ColorSetting;

public class Waypoint {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public Vec3Bridge IlllIIIIIIlllIlIIlllIlIIl;
    public String lIllIlIIIlIIIIIIIlllIlIll;
    public int llIlllIIIllllIIlllIllIIIl;
    public boolean llllIIlIIlIIlIIllIIlIIllI;
    public boolean IlIlIlllllIlIIlIlIlllIlIl;
    public String llIIIIIIIllIIllIlIllIIIIl;
    public boolean lIIIllIllIIllIlllIlIIlllI;
    public final ColorSetting IlllllIlIIIlIIlIIllIIlIll = new ColorSetting("color", LunarClient.random.nextFloat(), LunarClient.random.nextFloat(), LunarClient.random.nextFloat());

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return !LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll() && Ref.llIIIIIIIllIIllIlIllIIIIl() != null && LunarClient.IIllIlIllIlIllIllIllIllII().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll) && (this.llIlllIIIllllIIlllIllIIIl == -999 || Ref.llIIIIIIIllIIllIlIllIIIIl().bridge$getDimensionId() == this.llIlllIIIllllIIlllIllIIIl) && this.llIIIIIIIllIIllIlIllIIIIl.equals(WaypointsJson.IlllllIlIIIlIIlIIllIIlIll());
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        return string.equals("") || this.lIllIlIIIlIIIIIIIlllIlIll.equals("") || LunarClient.IIllIlIllIlIllIllIllIllII().lIlIlIlIlIIlIIlIIllIIIIIl(string);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Vec3Bridge vec3Bridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = vec3Bridge;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(String string) {
        this.lIllIlIIIlIIIIIIIlllIlIll = string;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.llIlllIIIllllIIlllIllIIIl = n;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.llllIIlIIlIIlIIllIIlIIllI = bl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        this.IlIlIlllllIlIIlIlIlllIlIl = bl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public Vec3Bridge lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public String llIlllIIIllllIIlllIllIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public int llllIIlIIlIIlIIllIIlIIllI() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public boolean IlIlIlllllIlIIlIlIlllIlIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public boolean llIIIIIIIllIIllIlIllIIIIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public String lIIIllIllIIllIlllIlIIlllI() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public ColorSetting IlllllIlIIIlIIlIIllIIlIll() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public String toString() {
        return "Waypoint(name=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", location=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ", world=" + this.llIlllIIIllllIIlllIllIIIl() + ", dimension=" + this.llllIIlIIlIIlIIllIIlIIllI() + ", visible=" + this.IlIlIlllllIlIIlIlIlllIlIl() + ", forced=" + this.llIIIIIIIllIIllIlIllIIIIl() + ", server=" + this.lIIIllIllIIllIlllIlIIlllI() + ", handledByServer=" + this.llIIlIlIIIllIlIlIlIIlIIll() + ", color=" + this.IlllllIlIIIlIIlIIllIIlIll() + ")";
    }

    public Waypoint() {
    }

    public Waypoint(String string, Vec3Bridge vec3Bridge, String string2, int n, boolean bl, boolean bl2, String string3, boolean bl3) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.IlllIIIIIIlllIlIIlllIlIIl = vec3Bridge;
        this.lIllIlIIIlIIIIIIIlllIlIll = string2;
        this.llIlllIIIllllIIlllIllIIIl = n;
        this.llllIIlIIlIIlIIllIIlIIllI = bl;
        this.IlIlIlllllIlIIlIlIlllIlIl = bl2;
        this.llIIIIIIIllIIllIlIllIIIIl = string3;
        this.lIIIllIllIIllIlllIlIIlllI = bl3;
    }

    public void llIlllIIIllllIIlllIllIIIl(String string) {
        this.llIIIIIIIllIIllIlIllIIIIl = string;
    }

    public boolean llIIlIlIIIllIlIlIlIIlIIll() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(boolean bl) {
        this.lIIIllIllIIllIlllIlIIlllI = bl;
    }
}
 