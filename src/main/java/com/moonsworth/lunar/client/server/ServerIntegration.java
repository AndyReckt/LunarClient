package com.moonsworth.lunar.client.server;

import com.lunarclient.bukkitapi.nethandler.client.obj.ServerRule;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.network.*;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.IntergratedServerInterface;
import com.moonsworth.lunar.client.ref.Ref;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ServerIntegration
implements EventHandler {
    public Server lIlIlIlIlIIlIIlIIllIIIIIl;
    public final Set IlllIIIIIIlllIlIIlllIlIIl = new HashSet();
    public Map lIllIlIIIlIIIIIIIlllIlIll = this.lIllIlIIIlIIIIIIIlllIlIll();

    public ServerIntegration() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ServerConnectEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ServerConnectEvent serverConnectEvent) {
        System.out.println("[ServerIntegration::onConnect]: " + serverConnectEvent.IlllIIIIIIlllIlIIlllIlIIl());
        String string = serverConnectEvent.IlllIIIIIIlllIlIIlllIlIIl().toLowerCase();
        if (string.contains("hypixel.net")) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = Server.HYPIXEL;
        }
        for (ConfigurableFeature configurableFeature : Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl()) {
            if (!(configurableFeature instanceof IntergratedServerInterface) || ((IntergratedServerInterface) configurableFeature).lIlIlIlIlIIlIIlIIllIIIIIl() != this.lIlIlIlIlIIlIIlIIllIIIIIl) continue;
            this.lIlIlIlIlIIlIIlIIllIIIIIl(configurableFeature, true);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent serverDisconnectEvent) {
        System.out.println("[ServerIntegration::onDisconnect]");
        for (ConfigurableFeature configurableFeature : Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl()) {
            if (!(configurableFeature instanceof IntergratedServerInterface) || ((IntergratedServerInterface)((Object)configurableFeature)).lIlIlIlIlIIlIIlIIllIIIIIl() != this.lIlIlIlIlIIlIIlIIllIIIIIl) continue;
            this.lIlIlIlIlIIlIIlIIllIIIIIl(configurableFeature, false);
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl = null;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Feature feature, boolean bl) {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl == null) {
            return;
        }
        if (bl && !this.IlllIIIIIIlllIlIIlllIlIIl.contains(feature) && ((IntergratedServerInterface)((Object)feature)).lIlIlIlIlIIlIIlIIllIIIIIl() == this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            feature.lIllIlIIIlIIIIIIIlllIlIll();
            this.IlllIIIIIIlllIlIIlllIlIIl.add(feature);
            System.out.println("[ServerIntegration::updateFeature] enabled " + feature.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl());
        } else if (!bl && this.IlllIIIIIIlllIlIIlllIlIIl.contains(feature)) {
            feature.llIlllIIIllllIIlllIllIIIl();
            this.IlllIIIIIIlllIlIIlllIlIIl.remove(feature);
            System.out.println("[ServerIntegration::updateFeature] disabled " + feature.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl());
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent netHandlerConnectionStateUpdateEvent) {
        this.lIllIlIIIlIIIIIIIlllIlIll = this.lIllIlIIIlIIIIIIIlllIlIll();
        for (com.moonsworth.lunar.client.feature.IlllIIIIIIlllIlIIlllIlIIl illlIIIIIIlllIlIIlllIlIIl : Ref.IlllIIIIIIlllIlIIlllIlIIl().lIlIIIIIIlIIIllllIllIIlII().llIlllIIIllllIIlllIllIIIl()) {
            illlIIIIIIlllIlIIlllIlIIl.llIIIlllIIlllIllllIlIllIl().d_();
        }
        Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl().forEach(configurableFeature -> configurableFeature.lIlIlIlIlIIlIIlIIllIIIIIl((Boolean)null));
    }

    public static Object lIlIlIlIlIIlIIlIIllIIIIIl(ServerRule serverRule) {
        return LunarClient.IIllIlIllIlIllIllIllIllII().lIIIllIllIIllIlllIlIIlllI().lIllIlIIIlIIIIIIIlllIlIll.get(serverRule);
    }

    public Map lIllIlIIIlIIIIIIIlllIlIll() {
        Map<ServerRule, Object> hashMap = new HashMap<>();
        hashMap.put(ServerRule.COMPETITIVE_GAME, false);
        hashMap.put(ServerRule.MINIMAP_STATUS, "FORCED_OFF");
        hashMap.put(ServerRule.SERVER_HANDLES_WAYPOINTS, false);
        hashMap.put(ServerRule.VOICE_ENABLED, false);
        hashMap.put(ServerRule.SHADERS_DISABLED, false);
        hashMap.put(ServerRule.LEGACY_ENCHANTING, false);
        hashMap.put(ServerRule.LEGACY_COMBAT, false);
        if (hashMap.size() != ServerRule.values().length) {
            for (ServerRule serverRule : ServerRule.values()) {
                if (hashMap.containsKey((Object)serverRule)) continue;
                throw new RuntimeException("No default value for Server Rule [" + serverRule.getId() + "] found!");
            }
        }
        return hashMap;
    }

    public Server lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public Map IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public static enum Server {
        HYPIXEL;
    }
}