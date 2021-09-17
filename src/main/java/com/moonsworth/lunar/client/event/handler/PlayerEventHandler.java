package com.moonsworth.lunar.client.event.handler;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.entity.player.CreatePlayerEvent;
import com.moonsworth.lunar.client.event.type.entity.player.RemovePlayerEvent;
import com.moonsworth.lunar.client.event.type.network.NetHandlerConnectionStateUpdateEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.PlayerNameUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class PlayerEventHandler
implements EventHandler {
    public static final long lIlIlIlIlIIlIIlIIllIIIIIl = 150L;
    public static final long IlllIIIIIIlllIlIIlllIlIIl = 750L;
    public final Set lIllIlIIIlIIIIIIIlllIlIll = new HashSet();
    public final Map<UUID, Long> llIlllIIIllllIIlllIllIIIl = new ConcurrentHashMap<>();
    public final Queue llllIIlIIlIIlIIllIIlIIllI = new ConcurrentLinkedQueue();
    public boolean IlIlIlllllIlIIlIlIlllIlIl;
    public long llIIIIIIIllIIllIlIllIIIIl = Ref.lllIIIIIlllIIlIllIIlIIIlI();
    public long lIIIllIllIIllIlllIlIIlllI = Ref.lllIIIIIlllIIlIllIIlIIIlI();

    public PlayerEventHandler() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(CreatePlayerEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RemovePlayerEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent tickEvent) {
        if (!this.IlIlIlllllIlIIlIlIlllIlIl) {
            return;
        }
        long l = Ref.lllIIIIIlllIIlIllIIlIIIlI() - this.llIIIIIIIllIIllIlIllIIIIl;
        if (l > 150L && this.llIlllIIIllllIIlllIllIIIl.size() > 0) {
            List<UUID> list = this.llIlllIIIllllIIlllIllIIIl.entrySet().stream().filter(entry -> entry.getValue() <= System.currentTimeMillis()).map(Map.Entry::getKey).collect(Collectors.toList());
            if (!list.isEmpty()) {
                // todo: websocket packet
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new llIlIIIllIIlIllIllIllllIl(list));
                this.lIllIlIIIlIIIIIIIlllIlIll.addAll(list);
                for (UUID uUID : list) {
                    this.llIlllIIIllllIIlllIllIIIl.remove(uUID);
                }
            }
            this.llIIIIIIIllIIllIlIllIIIIl = Ref.lllIIIIIlllIIlIllIIlIIIlI();
        }
        int n = this.llllIIlIIlIIlIIllIIlIIllI.size();
        l = Ref.lllIIIIIlllIIlIllIIlIIIlI() - this.lIIIllIllIIllIlllIlIIlllI;
        if (l > 750L && n > 0) {
            //todo: ws packet
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new IIlIllIlllllllIIlIIIllIIl(new ArrayList(this.llllIIlIIlIIlIIllIIlIIllI)));
            this.lIllIlIIIlIIIIIIIlllIlIll.removeAll(this.llllIIlIIlIIlIIllIIlIIllI);
            this.llllIIlIIlIIlIIllIIlIIllI.clear();
            this.lIIIllIllIIllIlllIlIIlllI = Ref.lllIIIIIlllIIlIllIIlIIIlI();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent netHandlerConnectionStateUpdateEvent) {
        if (!this.IlIlIlllllIlIIlIlIlllIlIl) {
            return;
        }
        this.llllIIlIIlIIlIIllIIlIIllI.clear();
        this.llIlllIIIllllIIlllIllIIIl.clear();
        this.llllIIlIIlIIlIIllIIlIIllI.addAll(this.lIllIlIIIlIIIIIIIlllIlIll);
        this.lIllIlIIIlIIIIIIIlllIlIll.clear();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(CreatePlayerEvent createPlayerEvent) {
        if (!this.IlIlIlllllIlIIlIlIlllIlIl) {
            return;
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(createPlayerEvent.lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RemovePlayerEvent removePlayerEvent) {
        if (!this.IlIlIlllllIlIIlIlIlllIlIl) {
            return;
        }
        this.IlllIIIIIIlllIlIIlllIlIIl(removePlayerEvent.lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerBridge entityPlayerBridge) {
        if (entityPlayerBridge.bridge$getUniqueID().equals(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSession().bridge$getProfile().getId()) || PlayerNameUtil.lIlIlIlIlIIlIIlIIllIIIIIl(entityPlayerBridge)) {
            return;
        }
        this.llIlllIIIllllIIlllIllIIIl.put(entityPlayerBridge.bridge$getUniqueID(), System.currentTimeMillis() + 150L);
        this.llllIIlIIlIIlIIllIIlIIllI.remove(entityPlayerBridge.bridge$getUniqueID());
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(EntityPlayerBridge entityPlayerBridge) {
        this.llIlllIIIllllIIlllIllIIIl.remove(entityPlayerBridge.bridge$getUniqueID());
        if (!this.lIllIlIIIlIIIIIIIlllIlIll.contains(entityPlayerBridge.bridge$getUniqueID())) {
            return;
        }
        if (entityPlayerBridge.bridge$getUniqueID().equals(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSession().bridge$getProfile().getId()) || PlayerNameUtil.lIlIlIlIlIIlIIlIIllIIIIIl(entityPlayerBridge)) {
            return;
        }
        this.llllIIlIIlIIlIIllIIlIIllI.add(entityPlayerBridge.bridge$getUniqueID());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.IlIlIlllllIlIIlIlIlllIlIl = true;
        if (Ref.llIIIIIIIllIIllIlIllIIIIl() != null) {
            for (EntityPlayerBridge entityPlayerBridge : Ref.llIIIIIIIllIIllIlIllIIIIl().bridge$getPlayerEntities()) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(entityPlayerBridge);
            }
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl() {
        this.IlIlIlllllIlIIlIlIlllIlIl = false;
        this.llllIIlIIlIIlIIllIIlIIllI.clear();
        this.llIlllIIIllllIIlllIllIIIl.clear();
        this.lIllIlIIIlIIIIIIIlllIlIll.clear();
    }
}
 