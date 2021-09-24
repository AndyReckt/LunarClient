package com.moonsworth.lunar.client.feature.type.waypoints;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.util.Vec3Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.WaypointsJson;
import com.moonsworth.lunar.client.setting.ColorSetting;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Waypoint {
    public String name;
    public Vec3Bridge location;
    public String world;
    public int dimension;
    public boolean visible;
    public boolean forced;
    public String server;
    public boolean handledByServer;
    public final ColorSetting color = new ColorSetting("color", LunarClient.RANDOM.nextFloat(), LunarClient.RANDOM.nextFloat(), LunarClient.RANDOM.nextFloat());

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return !LunarClient.getInstance().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll() && Ref.getWorld() != null && LunarClient.getInstance().lIlIlIlIlIIlIIlIIllIIIIIl(this.world) && (this.dimension == -999 || Ref.getWorld().bridge$getDimensionId() == this.dimension) && this.server.equals(WaypointsJson.IlllllIlIIIlIIlIIllIIlIll());
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        return string.equals("") || this.world.equals("") || LunarClient.getInstance().lIlIlIlIlIIlIIlIIllIIIIIl(string);
    }
}
