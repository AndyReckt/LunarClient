package com.moonsworth.lunar.client.event.handler;

import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.network.ServerConnectEvent;
import com.moonsworth.lunar.client.event.type.network.ServerDisconnectEvent;
import com.moonsworth.lunar.client.event.type.network.VanillaCustomPayloadEvent;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.FriendStatusUtil;
import com.moonsworth.lunar.client.util.KnownServerPMC;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ConnectionEventHandler implements EventHandler {
    public final List<lIlIlIlIlIIlIIlIIllIIIIIl> lIlIlIlIlIIlIIlIIllIIIIIl = new ArrayList();
    public lIlIlIlIlIIlIIlIIllIIIIIl IlllIIIIIIlllIlIIlllIlIIl;

    public ConnectionEventHandler() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ServerConnectEvent.class, serverConnectEvent -> {
            for (lIlIlIlIlIIlIIlIIllIIIIIl lIlIlIlIlIIlIIlIIllIIIIIl2 : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!lIlIlIlIlIIlIIlIIllIIIIIl2.lIlIlIlIlIIlIIlIIllIIIIIl.test(serverConnectEvent.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$serverIP())) continue;
                if (this.IlllIIIIIIlllIlIIlllIlIIl == lIlIlIlIlIIlIIlIIllIIIIIl2) {
                    return;
                }
                lIlIlIlIlIIlIIlIIllIIIIIl2.lIlIlIlIlIIlIIlIIllIIIIIl();
                this.IlllIIIIIIlllIlIIlllIlIIl = lIlIlIlIlIIlIIlIIllIIIIIl2;
                break;
            }
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent.class, serverDisconnectEvent -> {
            if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
                this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl();
                this.IlllIIIIIIlllIlIIlllIlIIl = null;
            }
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(VanillaCustomPayloadEvent.class, vanillaCustomPayloadEvent -> {
            if (!vanillaCustomPayloadEvent.lIlIlIlIlIIlIIlIIllIIIIIl().toLowerCase().contains("brand")) {
                return;
            }
            if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
                return;
            }
            for (lIlIlIlIlIIlIIlIIllIIIIIl lIlIlIlIlIIlIIlIIllIIIIIl2 : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!lIlIlIlIlIIlIIlIIllIIIIIl2.lIlIlIlIlIIlIIlIIllIIIIIl.test(Ref.getPlayer().bridge$getClientBrand().orElse(null))) continue;
                if (this.IlllIIIIIIlllIlIIlllIlIIl == lIlIlIlIlIIlIIlIIllIIIIIl2) {
                    return;
                }
                lIlIlIlIlIIlIIlIIllIIIIIl2.lIlIlIlIlIIlIIlIIllIIIIIl();
                this.IlllIIIIIIlllIlIIlllIlIIl = lIlIlIlIlIIlIIlIIllIIIIIl2;
                break;
            }
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl.add(new lIlIlIlIlIIlIIlIIllIIIIIl(string -> string != null && (string.toLowerCase().endsWith("shotbow.net") || string.toLowerCase().endsWith("shotbow.com"))) {

            @Override
            public void lIlIlIlIlIIlIIlIIllIIIIIl() {
                Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIllIllllIlIllllII().lIlIlIlIlIIlIIlIIllIIIIIl((Boolean)false);
            }

            @Override
            public void IlllIIIIIIlllIlIIlllIlIIl() {
                Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIllIllllIlIllllII().lIlIlIlIlIIlIIlIIllIIIIIl((Boolean)null);
            }
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl.add(new lIlIlIlIlIIlIIlIIllIIIIIl(string -> string != null && (string.toLowerCase().endsWith("hypixel.net") || FriendStatusUtil.lIlIlIlIlIIlIIlIIllIIIIIl(KnownServerPMC.HYPIXEL))) {

            @Override
            public void lIlIlIlIlIIlIIlIIllIIIIIl() {
                Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIllIllllIlIllllII().lIlIlIlIlIIlIIlIIllIIIIIl((Boolean)false);
            }

            @Override
            public void IlllIIIIIIlllIlIIlllIlIIl() {
                Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIllIllllIlIllllII().lIlIlIlIlIIlIIlIIllIIIIIl((Boolean)null);
            }
        });
    }

    public abstract static class lIlIlIlIlIIlIIlIIllIIIIIl {
        public final Predicate<String> lIlIlIlIlIIlIIlIIllIIIIIl;

        public abstract void lIlIlIlIlIIlIIlIIllIIIIIl();

        public abstract void IlllIIIIIIlllIlIIlllIlIIl();

        public lIlIlIlIlIIlIIlIIllIIIIIl(Predicate<String> predicate) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = predicate;
        }
    }
}
