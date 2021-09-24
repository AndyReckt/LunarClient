package com.moonsworth.lunar.client.registry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lunarclient.bukkitapi.nethandler.shared.LCPacketWaypointAdd;
import com.lunarclient.bukkitapi.nethandler.shared.LCPacketWaypointRemove;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.util.Vec3Bridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.input.KeyPressEvent;
import com.moonsworth.lunar.client.feature.type.waypoints.Waypoint;
import com.moonsworth.lunar.client.json.file.JsonFile;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.component.type.config.WaypointsListUIComponent;
import com.moonsworth.lunar.client.ui.screen.type.SettingsUIScreen;
import io.netty.util.internal.ConcurrentSet;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class WaypointsJson extends ItemSetLoader<Waypoint> implements EventHandler, JsonFile {
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
            if (Ref.getWorld() != null && keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().getWaypointsBind())) {
                SettingsUIScreen settingsUIScreen = new SettingsUIScreen(Ref.getMinecraft().bridge$getCurrentScreen());
                Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(settingsUIScreen));
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
            if (!waypoint.getName().equals(waypoint2.getName()) || !waypoint.getServer().equals(waypoint2.getServer()) || !waypoint.lIlIlIlIlIIlIIlIIllIIIIIl(waypoint2.getWorld())) continue;
            return false;
        }
        if (waypoint.isHandledByServer() && bl) {
            this.IlllIIIIIIlllIlIIlllIlIIl(waypoint);
        }
        this.llIlllIIIllllIIlllIllIIIl().add(waypoint);
        return true;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Waypoint waypoint) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(waypoint, true);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(Waypoint waypoint) {
        LunarLogger.info((Object)"Add: %s", waypoint.getName());
        LunarClient.getInstance().llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(new LCPacketWaypointAdd(waypoint.getName(), waypoint.getWorld(), (Integer)waypoint.getColor().llIlllIIIllllIIlllIllIIIl(), (int)waypoint.getLocation().bridge$xCoord(), (int)waypoint.getLocation().bridge$yCoord(), (int)waypoint.getLocation().bridge$zCoord(), false, waypoint.isVisible()));
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(Waypoint waypoint) {
        LunarLogger.info((Object)"Remove: %s", waypoint.getName());
        LunarClient.getInstance().llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(new LCPacketWaypointRemove(waypoint.getName(), waypoint.getWorld()));
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Predicate<Waypoint> predicate) {
        return this.llIlllIIIllllIIlllIllIIIl().removeIf(predicate);
    }

    public boolean llIlllIIIllllIIlllIllIIIl(Waypoint waypoint) {
        if (waypoint.isForced()) {
            return false;
        }
        if (waypoint.isHandledByServer()) {
            this.lIllIlIIIlIIIIIIIlllIlIll(waypoint);
        }
        return this.lIlIlIlIlIIlIIlIIllIIIIIl((waypoint2) -> waypoint2.equals(waypoint));
    }

    @Override
    public void read(JsonObject jsonObject) {
        this.llIlllIIIllllIIlllIllIIIl().clear();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            try {
                String string = entry.getKey();
                JsonObject jsonObject2 = entry.getValue().getAsJsonObject();
                for (Map.Entry entry2 : jsonObject2.entrySet()) {
                    String string2 = (String)entry2.getKey();
                    JsonObject jsonObject3 = ((JsonElement)entry2.getValue()).getAsJsonObject();
                    for (Map.Entry entry3 : jsonObject3.entrySet()) {
                        String string3 = (String)entry3.getKey();
                        JsonObject jsonObject4 = ((JsonElement)entry3.getValue()).getAsJsonObject();
                        JsonObject jsonObject5 = jsonObject4.getAsJsonObject("location");
                        Vec3Bridge vec3Bridge = Bridge.getInstance().initVec3d(jsonObject5.get("x").getAsDouble(), jsonObject5.get("y").getAsDouble(), jsonObject5.get("z").getAsDouble());
                        boolean bl = jsonObject4.get("visible").getAsBoolean();
                        int n = jsonObject4.get("dimension").getAsInt();
                        Waypoint waypoint = new Waypoint(string3, vec3Bridge, string2, n, bl, false, string, false);
                        this.lIlIlIlIlIIlIIlIIllIIIIIl(waypoint);
                        LunarLogger.info((Object)"Add waypoint (%s)", waypoint);
                        LunarLogger.info((Object)"Add waypoint (%s)", string);
                        waypoint.getColor().read(jsonObject4);
                    }
                }
            } catch (Exception exception) {
            }
        }
    }

    @Override
    public void write(JsonObject jsonObject) {
        for (Waypoint waypoint : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                JsonObject jsonObject2;
                JsonObject jsonObject3;
                if (waypoint.isHandledByServer()) continue;
                if (!jsonObject.has(waypoint.getServer())) {
                    jsonObject3 = new JsonObject();
                    jsonObject.add(waypoint.getServer(), jsonObject3);
                } else {
                    jsonObject3 = jsonObject.get(waypoint.getServer()).getAsJsonObject();
                }
                if (!jsonObject3.has(waypoint.getWorld())) {
                    jsonObject2 = new JsonObject();
                    jsonObject3.add(waypoint.getWorld(), jsonObject2);
                } else {
                    jsonObject2 = jsonObject3.get(waypoint.getWorld()).getAsJsonObject();
                }
                JsonObject jsonObject4 = new JsonObject();
                JsonObject jsonObject5 = new JsonObject();
                jsonObject5.addProperty("x", waypoint.getLocation().bridge$xCoord());
                jsonObject5.addProperty("y", waypoint.getLocation().bridge$yCoord());
                jsonObject5.addProperty("z", waypoint.getLocation().bridge$zCoord());
                jsonObject4.add("location", jsonObject5);
                jsonObject4.addProperty("visible", Boolean.valueOf(waypoint.isVisible()));
                jsonObject4.addProperty("dimension", waypoint.getDimension());
                waypoint.getColor().write(jsonObject4);
                jsonObject2.add(waypoint.getName(), jsonObject4);
            } catch (Exception exception) {}
        }
    }

    public static String IlllllIlIIIlIIlIIllIIlIll() {
        MinecraftBridge minecraftBridge = Ref.getMinecraft();
        String string = "";
        if (minecraftBridge.bridge$getWorld() != null && minecraftBridge.bridge$getCurrentServerData() == null) {
            string = string + "sp:";
        } else if (minecraftBridge.bridge$getCurrentServerData() != null) {
            string = string + "mp:" + minecraftBridge.bridge$getCurrentServerData().bridge$serverIP();
        }
        return string;
    }
}
