package com.moonsworth.lunar.client.registry;

import com.moonsworth.lunar.bridge.lunar.LunarBorder;
import com.moonsworth.lunar.bridge.minecraft.util.AxisAlignedBBBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.entity.EntityBoundingBoxCollisionEvent;
import com.moonsworth.lunar.client.event.type.network.NetHandlerConnectionStateUpdateEvent;
import com.moonsworth.lunar.client.event.type.render.RenderWorldPassEvent;
import com.moonsworth.lunar.client.json.file.ItemMapLoader;
import com.moonsworth.lunar.client.ref.Ref;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BorderManager extends ItemMapLoader<String, LunarBorder> implements EventHandler {
    public BorderManager() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        if (Bridge.getMinecraftVersion() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderWorldPassEvent.class, renderWorldPassEvent -> {
                for (LunarBorder lunarBorder : this.llIlllIIIllllIIlllIllIIIl().values()) {
                    if (!lunarBorder.shouldRender()) continue;
                    lunarBorder.lIlIlIlIlIIlIIlIIllIIIIIl(renderWorldPassEvent.lIlIlIlIlIIlIIlIIllIIIIIl());
                }
            });
            this.lIlIlIlIlIIlIIlIIllIIIIIl(EntityBoundingBoxCollisionEvent.class, entityBoundingBoxCollisionEvent -> {
                for (LunarBorder lunarBorder : this.llIlllIIIllllIIlllIllIIIl().values()) {
                    if (!lunarBorder.shouldRender() || !lunarBorder.isCancelEntry() && !lunarBorder.contains(Ref.getPlayer().bridge$getPosX(), Ref.getPlayer().bridge$getPosZ()) || !lunarBorder.isCancelExit() && lunarBorder.contains(Ref.getPlayer().bridge$getPosX(), Ref.getPlayer().bridge$getPosZ())) continue;
                    for (AxisAlignedBBBridge axisAlignedBBBridge : lunarBorder.getWalls()) {
                        if (!axisAlignedBBBridge.bridge$intersectsWith(Ref.getPlayer().bridge$getBoundingBox().bridge$expand(Math.abs(Ref.getPlayer().bridge$getMotionX()), Math.abs(Ref.getPlayer().bridge$getMotionY()), Math.abs(Ref.getPlayer().bridge$getMotionZ())).bridge$offset(Ref.getPlayer().bridge$getMotionX(), Ref.getPlayer().bridge$getMotionY(), Ref.getPlayer().bridge$getMotionZ()))) continue;
                        entityBoundingBoxCollisionEvent.lIllIlIIIlIIIIIIIlllIlIll().add(axisAlignedBBBridge);
                    }
                }
            });
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent netHandlerConnectionStateUpdateEvent) {
        this.llIlllIIIllllIIlllIllIIIl().clear();
    }

    @Override
    public Map<String, LunarBorder> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new ConcurrentHashMap<>();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(LunarBorder lunarBorder) {
        this.llIlllIIIllllIIlllIllIIIl().put(lunarBorder.getId(), lunarBorder);
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        return this.llIlllIIIllllIIlllIllIIIl().remove(string) != null;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string, double d, double d2, double d3, double d4, int n) {
        LunarBorder lunarBorder = this.llIlllIIIllllIIlllIllIIIl().get(string);
        lunarBorder.update(d, d2, d3, d4, n * 50);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string, double d, double d2, double d3, double d4, int n, boolean bl, boolean bl2, int n2) {
        LunarBorder lunarBorder = this.llIlllIIIllllIIlllIllIIIl().get(string);
        lunarBorder.update(d, d2, d3, d4, n * 50);
        lunarBorder.setCancelEntry(bl);
        lunarBorder.setCancelExit(bl2);
        lunarBorder.setColor(n2);
    }
}
