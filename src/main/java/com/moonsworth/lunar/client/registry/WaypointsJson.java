package com.moonsworth.lunar.client.registry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.util.Vec3Bridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.input.KeyPressEvent;
import com.moonsworth.lunar.client.feature.type.waypoints.Waypoint;
import com.moonsworth.lunar.client.json.file.DefaultJson;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.component.type.config.WaypointsListUIComponent;
import com.moonsworth.lunar.client.ui.screen.type.SettingsUIScreen;
import io.netty.util.internal.ConcurrentSet;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class WaypointsJson
extends ItemSetLoader<Waypoint>
implements EventHandler,
        DefaultJson {
    @Override
    public Set lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new ConcurrentSet();
    }

    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "waypoints.json";
    }

    @Override
    public void b_() {
        super.b_();
        this.load();
        this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyPressEvent.class, keyPressEvent -> {
            if (Ref.llIIIIIIIllIIllIlIllIIIIl() != null && keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().llIIlIlIIIllIlIlIlIIlIIll())) {
                SettingsUIScreen settingsUIScreen = new SettingsUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen());
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(settingsUIScreen));
                settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(new WaypointsListUIComponent(settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl()));
                settingsUIScreen.llIlllIIIllllIIlllIllIIIl(2);
            }
        });
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.save();
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Waypoint waypoint, boolean bl) {
        for (Waypoint waypoint2 : this.llIlllIIIllllIIlllIllIIIl()) {
            if (!waypoint.IlllIIIIIIlllIlIIlllIlIIl().equals(waypoint2.IlllIIIIIIlllIlIIlllIlIIl()) || !waypoint.lIIIllIllIIllIlllIlIIlllI().equals(waypoint2.lIIIllIllIIllIlllIlIIlllI()) || !waypoint.lIlIlIlIlIIlIIlIIllIIIIIl(waypoint2.llIlllIIIllllIIlllIllIIIl())) continue;
            return false;
        }
        if (waypoint.llIIlIlIIIllIlIlIlIIlIIll() && bl) {
            this.IlllIIIIIIlllIlIIlllIlIIl(waypoint);
        }
        this.llIlllIIIllllIIlllIllIIIl().add(waypoint);
        return true;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Waypoint waypoint) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(waypoint, true);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(Waypoint waypoint) {
        LunarLogger.IlllIIIIIIlllIlIIlllIlIIl((Object)"Add: %s", waypoint.IlllIIIIIIlllIlIIlllIlIIl());
        LunarClient.IIllIlIllIlIllIllIllIllII().llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(new LCPacketWaypointAdd(waypoint.IlllIIIIIIlllIlIIlllIlIIl(), waypoint.llIlllIIIllllIIlllIllIIIl(), (Integer)waypoint.IlllllIlIIIlIIlIIllIIlIll().llIlllIIIllllIIlllIllIIIl(), (int)waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$xCoord(), (int)waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$yCoord(), (int)waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$zCoord(), false, waypoint.IlIlIlllllIlIIlIlIlllIlIl()));
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(Waypoint waypoint) {
        LunarLogger.IlllIIIIIIlllIlIIlllIlIIl((Object)"Remove: %s", waypoint.IlllIIIIIIlllIlIIlllIlIIl());
        LunarClient.IIllIlIllIlIllIllIllIllII().llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(new LCPacketWaypointRemove(waypoint.IlllIIIIIIlllIlIIlllIlIIl(), waypoint.llIlllIIIllllIIlllIllIIIl()));
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Predicate predicate) {
        return this.llIlllIIIllllIIlllIllIIIl().removeIf(predicate);
    }

    public boolean llIlllIIIllllIIlllIllIIIl(Waypoint waypoint) {
        if (waypoint.llIIIIIIIllIIllIlIllIIIIl()) {
            return false;
        }
        if (waypoint.llIIlIlIIIllIlIlIlIIlIIll()) {
            this.lIllIlIIIlIIIIIIIlllIlIll(waypoint);
        }
        return this.lIlIlIlIlIIlIIlIIllIIIIIl((waypoint2) -> waypoint2.equals(waypoint));
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        this.llIlllIIIllllIIlllIllIIIl().clear();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            try {
                String string = (String)entry.getKey();
                JsonObject jsonObject2 = ((JsonElement)entry.getValue()).getAsJsonObject();
                for (Map.Entry entry2 : jsonObject2.entrySet()) {
                    String string2 = (String)entry2.getKey();
                    JsonObject jsonObject3 = ((JsonElement)entry2.getValue()).getAsJsonObject();
                    for (Map.Entry entry3 : jsonObject3.entrySet()) {
                        String string3 = (String)entry3.getKey();
                        JsonObject jsonObject4 = ((JsonElement)entry3.getValue()).getAsJsonObject();
                        JsonObject jsonObject5 = jsonObject4.getAsJsonObject("location");
                        Vec3Bridge vec3Bridge = Bridge.llIlllIIIllllIIlllIllIIIl().initVec3d(jsonObject5.get("x").getAsDouble(), jsonObject5.get("y").getAsDouble(), jsonObject5.get("z").getAsDouble());
                        boolean bl = jsonObject4.get("visible").getAsBoolean();
                        int n = jsonObject4.get("dimension").getAsInt();
                        Waypoint waypoint = new Waypoint(string3, vec3Bridge, string2, n, bl, false, string, false);
                        this.lIlIlIlIlIIlIIlIIllIIIIIl(waypoint);
                        LunarLogger.IlllIIIIIIlllIlIIlllIlIIl((Object)"Add waypoint (%s)", waypoint);
                        LunarLogger.IlllIIIIIIlllIlIIlllIlIIl((Object)"Add waypoint (%s)", string);
                        waypoint.IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl(jsonObject4);
                    }
                }
            }
            catch (Exception exception) {
            }
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        for (Waypoint waypoint : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                JsonObject jsonObject2;
                JsonObject jsonObject3;
                if (waypoint.llIIlIlIIIllIlIlIlIIlIIll()) continue;
                if (!jsonObject.has(waypoint.lIIIllIllIIllIlllIlIIlllI())) {
                    jsonObject3 = new JsonObject();
                    jsonObject.add(waypoint.lIIIllIllIIllIlllIlIIlllI(), (JsonElement)jsonObject3);
                } else {
                    jsonObject3 = jsonObject.get(waypoint.lIIIllIllIIllIlllIlIIlllI()).getAsJsonObject();
                }
                if (!jsonObject3.has(waypoint.llIlllIIIllllIIlllIllIIIl())) {
                    jsonObject2 = new JsonObject();
                    jsonObject3.add(waypoint.llIlllIIIllllIIlllIllIIIl(), (JsonElement)jsonObject2);
                } else {
                    jsonObject2 = jsonObject3.get(waypoint.llIlllIIIllllIIlllIllIIIl()).getAsJsonObject();
                }
                JsonObject jsonObject4 = new JsonObject();
                JsonObject jsonObject5 = new JsonObject();
                jsonObject5.addProperty("x", (Number)waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$xCoord());
                jsonObject5.addProperty("y", (Number)waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$yCoord());
                jsonObject5.addProperty("z", (Number)waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$zCoord());
                jsonObject4.add("location", (JsonElement)jsonObject5);
                jsonObject4.addProperty("visible", Boolean.valueOf(waypoint.IlIlIlllllIlIIlIlIlllIlIl()));
                jsonObject4.addProperty("dimension", (Number)waypoint.llllIIlIIlIIlIIllIIlIIllI());
                waypoint.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject4);
                jsonObject2.add(waypoint.IlllIIIIIIlllIlIIlllIlIIl(), (JsonElement)jsonObject4);
            }
            catch (Exception exception) {}
        }
    }

    public static String IlllllIlIIIlIIlIIllIIlIll() {
        MinecraftBridge minecraftBridge = Ref.lIlIlIlIlIIlIIlIIllIIIIIl();
        String string = "";
        if (minecraftBridge.bridge$getWorld() != null && minecraftBridge.bridge$getCurrentServerData() == null) {
            string = string + "sp:";
        } else if (minecraftBridge.bridge$getCurrentServerData() != null) {
            string = string + "mp:" + minecraftBridge.bridge$getCurrentServerData().bridge$serverIP();
        }
        return string;
    }
}
 