package com.moonsworth.lunar.client.nethandler;

import com.google.common.base.Charsets;
import com.lunarclient.bukkitapi.nethandler.LCPacket;
import com.lunarclient.bukkitapi.nethandler.client.obj.ModSettings;
import com.lunarclient.bukkitapi.nethandler.shared.*;
import com.lunarclient.bukkitapi.nethandler.server.*;
import com.lunarclient.bukkitapi.nethandler.client.*;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.LunarBorder;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.bridge.minecraft.util.AxisAlignedBBBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.bridge.minecraft.util.Vec3Bridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.entity.player.UnknownNetHandlerEvent;
import com.moonsworth.lunar.client.event.type.network.*;
import com.moonsworth.lunar.client.feature.staff.AbstractStaffMod;
import com.moonsworth.lunar.client.feature.staff.StaffModType;
import com.moonsworth.lunar.client.feature.staff.type.XrayMod;
import com.moonsworth.lunar.client.feature.type.coodowns.CooldownsMod;
import com.moonsworth.lunar.client.feature.type.hologram.Hologram;
import com.moonsworth.lunar.client.feature.type.title.Title;
import com.moonsworth.lunar.client.feature.type.waypoints.Waypoint;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.notification.Notification;
import com.moonsworth.lunar.client.profile.FriendProfile;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.CosmeticManager;
import com.moonsworth.lunar.client.registry.WaypointsJson;
import io.netty.buffer.Unpooled;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Decencies
 * @since 10/07/2021 12:48
 */
// todo implement
public class NetHandler implements LCNetHandlerClient, EventHandler, I18nBridge {
    public final String lIlIlIlIlIIlIIlIIllIIIIIl = "lunarclient:pm";
    public String channelName;
    public final String lIllIlIIIlIIIIIIIlllIlIll = "LC-Binary";
    public boolean llIlllIIIllllIIlllIllIIIl;

    public NetHandler() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(CustomPayloadEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ServerConnectEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(CustomPayloadEvent customPayloadEvent) {
        LCPacket lCPacket;
        if (customPayloadEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == null) {
            System.out.println("channel is null");
            return;
        }
        if (Ref.getNetHandler() == null) {
            System.out.println("Ref.net() is null");
            return;
        }
        if (Ref.getNetHandler().bridge$getRegisterPacketName() == null) {
            System.out.println("register packet name == null");
            return;
        }
        if (customPayloadEvent.lIlIlIlIlIIlIIlIIllIIIIIl().equals(Ref.getNetHandler().bridge$getRegisterPacketName())) {
            this.channelName = "";
            String string = new String(customPayloadEvent.IlllIIIIIIlllIlIIlllIlIIl(), Charsets.UTF_8);
            this.llIlllIIIllllIIlllIllIIIl = string.contains("lunarclient:pm") || string.contains(Ref.getNetHandler().bridge$getLCChannelName());
            if (this.llIlllIIIllllIIlllIllIIIl) {
                this.channelName = string.contains("lunarclient:pm") ? "lunarclient:pm" : Ref.getNetHandler().bridge$getLCChannelName();
                Ref.getNetHandler().bridge$addToSendQueue(Bridge.getInstance().initCustomPayload(Ref.getNetHandler().bridge$getRegisterPacketName(), Bridge.getInstance().initPacketBuffer(Unpooled.wrappedBuffer(this.channelName.getBytes(Charsets.UTF_8)))));
            }
            this.llIlllIIIllllIIlllIllIIIl();
        } else if (customPayloadEvent.lIlIlIlIlIIlIIlIIllIIIIIl().equals(this.channelName) && (lCPacket = LCPacket.handle(customPayloadEvent.IlllIIIIIIlllIlIIlllIlIIl())) != null) {
            lCPacket.process(this);
            EventBus.getInstance().call(new PacketPostProcessEvent(lCPacket));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ServerConnectEvent serverConnectEvent) {
        EventBus.getInstance().call(new NetHandlerConnectionStateUpdateEvent());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent serverDisconnectEvent) {
        LunarClient.getInstance().IlllIIIIIIlllIlIIlllIlIIl("");
        EventBus.getInstance().call(new NetHandlerConnectionStateUpdateEvent());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent netHandlerConnectionStateUpdateEvent) {
        LunarClient.getInstance().IlllIIIIIIlllIlIIlllIlIIl("");
        LunarClient.getInstance().llIllIlIllIlllIllIIIIllII().lIlIlIlIlIIlIIlIIllIIIIIl(Waypoint::isHandledByServer);
    }

    public void llIlllIIIllllIIlllIllIIIl() {
        LunarClient.getInstance().getHolograms().llIlllIIIllllIIlllIllIIIl().clear();
        EventBus.getInstance().call(new UnknownNetHandlerEvent());
        EventBus.getInstance().call(new NetHandlerConnectionStateUpdateEvent());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(LCPacket lCPacket) {
        if (Ref.getNetHandler() == null || this.channelName == null) {
            return;
        }
        Ref.getNetHandler().bridge$addToSendQueue(Bridge.getInstance().initCustomPayload(this.channelName, Bridge.getInstance().initPacketBuffer(LCPacket.getPacketBuf(lCPacket))));
    }

    @Override
    public void handleGhost(LCPacketGhost lCPacketGhost) {
    }

    @Override
    public void handleCooldown(LCPacketCooldown lCPacketCooldown) {
        CooldownsMod.IlllIIIIIIlllIlIIlllIlIIl(lCPacketCooldown.getMessage(), lCPacketCooldown.getDurationMs(), lCPacketCooldown.getIconId());
    }

    @Override
    public void handleNotification(LCPacketNotification lCPacketNotification) {
    }

    @Override
    public void handleStaffModState(LCPacketStaffModState lCPacketStaffModState) {
        for (AbstractStaffMod abstractStaffMod : Ref.getLC().IIlIllIlllllllIIlIIIllIIl().llIlllIIIllllIIlllIllIIIl()) {
            if (abstractStaffMod.IlIllIIlIIlIIIllIllllIIll() != StaffModType.valueOf(lCPacketStaffModState.getMod())) continue;
            abstractStaffMod.setState(lCPacketStaffModState.isState());
            if (lCPacketStaffModState.isState()) continue;
            abstractStaffMod.IlllIIIIIIlllIlIIlllIlIIl(false);
            if (!(abstractStaffMod instanceof XrayMod)) continue;
            ((XrayMod) abstractStaffMod).IlIlIlllllIlIIlIlIlllIlIl(false);
            Ref.getMinecraft().bridge$getRenderGlobal().bridge$reloadChunks();
        }
    }

    @Override
    public void handleNametagsUpdate(LCPacketNametagsUpdate lCPacketNametagsUpdate) {
    }

    @Override
    public void handleTeammates(LCPacketTeammates lCPacketTeammates) {
        Map<UUID, Map<String, Double>> map = lCPacketTeammates.getPlayers();
        for (Map.Entry<UUID, Map<String, Double>> entry : map.entrySet()) {
            FriendProfile friendProfile = LunarClient.getInstance().getFriendRegistry().llIlllIIIllllIIlllIllIIIl().get(entry.getKey());
            if (entry.getKey().equals(Ref.getPlayer().bridge$getUniqueID())) {
                friendProfile = LunarClient.getInstance().llllIIlIIlIIlIIllIIlIIllI();
            }
            if (friendProfile == null) {
                friendProfile = new FriendProfile(entry.getKey());
                friendProfile.IlllIIIIIIlllIlIIlllIlIIl(-16733568);
                LunarClient.getInstance().getFriendRegistry().lIlIlIlIlIIlIIlIIllIIIIIl(friendProfile);
            }
            Vec3Bridge vec3Bridge = Bridge.getInstance().initVec3d(entry.getValue().get("x"), entry.getValue().get("y"), entry.getValue().get("z"));
            if (entry.getValue().containsKey("world")) {
                friendProfile.setWorld(entry.getValue().get("world"));
            }
            friendProfile.lIlIlIlIlIIlIIlIIllIIIIIl(vec3Bridge);
            friendProfile.lastTeammateMS(lCPacketTeammates.getLastMs());
            LunarLogger.debug("Inc teammate " + vec3Bridge);
        }
        for (Map.Entry<UUID, FriendProfile> entry : LunarClient.getInstance().getFriendRegistry().llIlllIIIllllIIlllIllIIIl().entrySet()) {
            if (map.containsKey(entry.getKey())) continue;
            LunarClient.getInstance().getFriendRegistry().llIlllIIIllllIIlllIllIIIl().remove(entry.getKey());
        }
    }

    @Override
    public void handleOverrideNametags(LCPacketNametagsOverride lCPacketNametagsOverride) {
        if (lCPacketNametagsOverride.getTags() == null) {
            LunarClient.getInstance().llIIIlIllIIIIlIIIlIlIllIl().llIlllIIIllllIIlllIllIIIl().remove(lCPacketNametagsOverride.getPlayer());
        } else {
            Collections.reverse(lCPacketNametagsOverride.getTags());
            LunarClient.getInstance().llIIIlIllIIIIlIIIlIlIllIl().llIlllIIIllllIIlllIllIIIl().put(lCPacketNametagsOverride.getPlayer(), lCPacketNametagsOverride.getTags());
        }
    }

    @Override
    public void handleAddHologram(LCPacketHologram lCPacketHologram) {
        Hologram hologram = new Hologram(lCPacketHologram.getUuid(), new String[0], lCPacketHologram.getX(), lCPacketHologram.getY(), lCPacketHologram.getZ());
        LunarClient.getInstance().getHolograms().llIlllIIIllllIIlllIllIIIl().put(lCPacketHologram.getUuid(), hologram);
        hologram.setLines(lCPacketHologram.getLines().toArray(new String[0]));
    }

    @Override
    public void handleUpdateHologram(LCPacketHologramUpdate lCPacketHologramUpdate) {
        Hologram hologram = LunarClient.getInstance().getHolograms().llIlllIIIllllIIlllIllIIIl().get(lCPacketHologramUpdate.getUuid());
        if (hologram != null) {
            hologram.setLines(lCPacketHologramUpdate.getLines().toArray(new String[0]));
        }
    }

    @Override
    public void handleRemoveHologram(LCPacketHologramRemove lCPacketHologramRemove) {
        LunarClient.getInstance().getHolograms().llIlllIIIllllIIlllIllIIIl().remove(lCPacketHologramRemove.getUuid());
    }

    @Override
    public void handleTitle(LCPacketTitle lCPacketTitle) {
        Title.DisplayType displayType = Title.DisplayType.IlllIIIIIIlllIlIIlllIlIIl;
        if (lCPacketTitle.getType().equalsIgnoreCase("subtitle")) {
            displayType = Title.DisplayType.lIlIlIlIlIIlIIlIIllIIIIIl;
        }
        LunarClient.getInstance().lIllllIllIIlIIlIIIlIIIlII().llIlllIIIllllIIlllIllIIIl().add(new Title(lCPacketTitle.getMessage(), displayType, lCPacketTitle.getScale(), lCPacketTitle.getDisplayTimeMs(), lCPacketTitle.getFadeInTimeMs(), lCPacketTitle.getFadeOutTimeMs()));
    }

    @Override
    public void handleServerRule(LCPacketServerRule lCPacketServerRule) {
        Ref.getLC().lIIIllIllIIllIlllIlIIlllI().IlllIIIIIIlllIlIIlllIlIIl().put(lCPacketServerRule.getRule(), this.lIlIlIlIlIIlIIlIIllIIIIIl(lCPacketServerRule));
        com.moonsworth.lunar.client.feature.IlllIIIIIIlllIlIIlllIlIIl illlIIIIIIlllIlIIlllIlIIl = LunarClient.getInstance().lIlIIIIIIlIIIllllIllIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(lCPacketServerRule.getRule());
        if (illlIIIIIIlllIlIIlllIlIIl != null) {
            illlIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(illlIIIIIIlllIlIIlllIlIIl.IlIllIIlIIlIIIllIllllIIll().test(lCPacketServerRule.getRule()));
        }
        LunarLogger.debug("[Server Rule] " + lCPacketServerRule.getRule().getId() + " updated to '" + Ref.getLC().lIIIllIllIIllIlllIlIIlllI().IlllIIIIIIlllIlIIlllIlIIl().get(lCPacketServerRule.getRule()) + "'.");
    }

    public Object lIlIlIlIlIIlIIlIIllIIIIIl(LCPacketServerRule lCPacketServerRule) {
        Class<?> clazz = lCPacketServerRule.getRule().getType();
        if (clazz == Boolean.class) {
            return lCPacketServerRule.isBooleanValue();
        }
        if (clazz == Float.class) {
            return lCPacketServerRule.getFloatValue();
        }
        if (clazz == Integer.class) {
            return lCPacketServerRule.getIntValue();
        }
        if (clazz == String.class) {
            return lCPacketServerRule.getStringValue();
        }
        return null;
    }

    @Override
    public void handleVoice(LCPacketVoice lCPacketVoice) {
    }

    @Override
    public void handleVoiceChannels(LCPacketVoiceChannel lCPacketVoiceChannel) {
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(UUID uUID) {
        if (LunarClient.getInstance().IIlIlIIIllIIllllIllllIlIl().llIlllIIIllllIIlllIllIIIl().contains(uUID)) {
            LunarClient.getInstance().IIlIlIIIllIIllllIllllIlIl().lIlIlIlIlIIlIIlIIllIIIIIl(uUID);
        }
    }

    @Override
    public void handleVoiceChannelUpdate(LCPacketVoiceChannelUpdate lCPacketVoiceChannelUpdate) {
    }

    @Override
    public void handleVoiceChannelDelete(LCPacketVoiceChannelRemove lCPacketVoiceChannelRemove) {
        LunarLogger.debug((Object)"Deleted Voice Channel (%s)", lCPacketVoiceChannelRemove.getUuid());
        LunarClient.getInstance().lllllIIIIlIlllIllIIIlIIlI().lIlIlIlIlIIlIIlIIllIIIIIl(lCPacketVoiceChannelRemove.getUuid());
    }

    @Override
    public void handleModSettings(LCPacketModSettings lCPacketModSettings) {
        ModSettings modSettings = lCPacketModSettings.getSettings();
        StringBuilder stringBuilder = new StringBuilder();
        AtomicInteger atomicInteger = new AtomicInteger();
        Ref.getLC().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl().stream().filter(configurableFeature -> modSettings.getModSetting(configurableFeature.getDetails().getId()) != null).filter(configurableFeature -> configurableFeature.getDetails().isEnabledOnCurrentVersion()).forEach(configurableFeature -> {
            atomicInteger.getAndIncrement();
            stringBuilder.append(EnumChatColor.lllIIIIIlllIIlIllIIlIIIlI).append(configurableFeature.getDetails().get("name")).append(EnumChatColor.IllIllIIIllIIIlIlIlIIIIll).append(", ");
            ModSettings.ModSetting modSetting = modSettings.getModSetting(configurableFeature.getDetails().getId());
            configurableFeature.lIlIlIlIlIIlIIlIIllIIIIIl((Boolean)modSetting.isEnabled());
            LunarLogger.info("[Mod Setting] " + configurableFeature.getDetails().getId() + " updated to '" + modSetting.isEnabled() + "'.");
        });
        if (stringBuilder.toString().isEmpty()) {
            return;
        }
        Notification notification = new Notification(CosmeticManager.lIllIlIIIlIIIIIIIlllIlIll, EnumChatColor.lllIIIIIlllIIlIllIIlIIIlI + "Mod" + (atomicInteger.get() == 1 ? "" : "s") + " Disabled", this.get("mod" + (atomicInteger.get() == 1 ? "" : "s") + "-disabled-message", stringBuilder.substring(0, stringBuilder.length() - 2)));
        notification.lIlIlIlIlIIlIIlIIllIIIIIl(5000L);
        Ref.getMinecraft().bridge$submit(() -> Ref.getLC().IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(notification));
    }

    @Override
    public void handleUpdateWorld(LCPacketUpdateWorld lCPacketUpdateWorld) {
        LunarLogger.debug("Switched world: " + lCPacketUpdateWorld.getWorld());
        LunarClient.getInstance().IlllIIIIIIlllIlIIlllIlIIl(lCPacketUpdateWorld.getWorld());
    }

    @Override
    public void handleServerUpdate(LCPacketServerUpdate lCPacketServerUpdate) {
    }

    @Override
    public void handleWorldBorder(LCPacketWorldBorder lCPacketWorldBorder) {
        LunarBorder lunarBorder = Bridge.getInstance().initLCBorder(lCPacketWorldBorder.getId(), lCPacketWorldBorder.getWorld(), lCPacketWorldBorder.getColor());
        LunarClient.getInstance().IlIIlIIlIIlIIllIIIllIIllI().lIlIlIlIlIIlIIlIIllIIIIIl(lunarBorder);
        AxisAlignedBBBridge axisAlignedBBBridge = Bridge.getInstance().initAABB(lCPacketWorldBorder.getMinX(), 0, lCPacketWorldBorder.getMinZ(), lCPacketWorldBorder.getMaxX() + 1.0, 255, lCPacketWorldBorder.getMaxZ() + 1.0);
        lunarBorder.setCancelEntry(lCPacketWorldBorder.isCancelsExit());
        lunarBorder.setCancelExit(lCPacketWorldBorder.isCancelsExit());
        lunarBorder.setCanShrink(lCPacketWorldBorder.isCanShrinkExpand());
        lunarBorder.bridge$setCenter(axisAlignedBBBridge.bridge$getMinX() + (axisAlignedBBBridge.bridge$getMaxX() - axisAlignedBBBridge.bridge$getMinX()) / 2.0, axisAlignedBBBridge.bridge$getMinZ() + (axisAlignedBBBridge.bridge$getMaxZ() - axisAlignedBBBridge.bridge$getMinZ()) / 2.0);
        double d = axisAlignedBBBridge.bridge$getMaxX() - axisAlignedBBBridge.bridge$getMinX();
        double d2 = axisAlignedBBBridge.bridge$getMaxZ() - axisAlignedBBBridge.bridge$getMinZ();
        if (!lCPacketWorldBorder.isCanShrinkExpand()) {
            lunarBorder.setStaticBounds(axisAlignedBBBridge);
        }
        lunarBorder.bridge$setTransition(d / 2.0 + d2 / 2.0);
    }

    @Override
    public void handleWorldBorderCreateNew(LCPacketWorldBorderCreateNew lCPacketWorldBorderCreateNew) {
        LunarBorder lunarBorder = Bridge.getInstance().initLCBorder(lCPacketWorldBorderCreateNew.getId(), lCPacketWorldBorderCreateNew.getWorld(), lCPacketWorldBorderCreateNew.getColor());
        LunarClient.getInstance().IlIIlIIlIIlIIllIIIllIIllI().lIlIlIlIlIIlIIlIIllIIIIIl(lunarBorder);
        AxisAlignedBBBridge axisAlignedBBBridge = Bridge.getInstance().initAABB(lCPacketWorldBorderCreateNew.getMinX(), 0, lCPacketWorldBorderCreateNew.getMinZ(), lCPacketWorldBorderCreateNew.getMaxX() + 1.0, 255, lCPacketWorldBorderCreateNew.getMaxZ() + 1.0);
        lunarBorder.setCancelEntry(lCPacketWorldBorderCreateNew.isCancelsEntry());
        lunarBorder.setCancelExit(lCPacketWorldBorderCreateNew.isCancelsExit());
        lunarBorder.setCanShrink(lCPacketWorldBorderCreateNew.isCanShrinkExpand());
        lunarBorder.bridge$setCenter(axisAlignedBBBridge.bridge$getMinX() + (axisAlignedBBBridge.bridge$getMaxX() - axisAlignedBBBridge.bridge$getMinX()) / 2.0, axisAlignedBBBridge.bridge$getMinZ() + (axisAlignedBBBridge.bridge$getMaxZ() - axisAlignedBBBridge.bridge$getMinZ()) / 2.0);
        lunarBorder.setColor(lCPacketWorldBorderCreateNew.getColor());
        double d = axisAlignedBBBridge.bridge$getMaxX() - axisAlignedBBBridge.bridge$getMinX();
        double d2 = axisAlignedBBBridge.bridge$getMaxZ() - axisAlignedBBBridge.bridge$getMinZ();
        if (!lCPacketWorldBorderCreateNew.isCanShrinkExpand()) {
            lunarBorder.setStaticBounds(axisAlignedBBBridge);
        }
        lunarBorder.bridge$setTransition(d / 2.0 + d2 / 2.0);
    }

    @Override
    public void handleWorldBorderUpdate(LCPacketWorldBorderUpdate lCPacketWorldBorderUpdate) {
        LunarClient.getInstance().IlIIlIIlIIlIIllIIIllIIllI().lIlIlIlIlIIlIIlIIllIIIIIl(lCPacketWorldBorderUpdate.getId(), lCPacketWorldBorderUpdate.getMinX(), lCPacketWorldBorderUpdate.getMinZ(), lCPacketWorldBorderUpdate.getMaxX(), lCPacketWorldBorderUpdate.getMaxZ(), lCPacketWorldBorderUpdate.getDurationTicks());
    }

    @Override
    public void handleWorldBorderUpdateNew(LCPacketWorldBorderUpdateNew lCPacketWorldBorderUpdateNew) {
        LunarClient.getInstance().IlIIlIIlIIlIIllIIIllIIllI().lIlIlIlIlIIlIIlIIllIIIIIl(lCPacketWorldBorderUpdateNew.getId(), lCPacketWorldBorderUpdateNew.getMinX(), lCPacketWorldBorderUpdateNew.getMinZ(), lCPacketWorldBorderUpdateNew.getMaxX(), lCPacketWorldBorderUpdateNew.getMaxZ(), lCPacketWorldBorderUpdateNew.getDurationTicks(), lCPacketWorldBorderUpdateNew.isCancelsEntry(), lCPacketWorldBorderUpdateNew.isCancelsExit(), lCPacketWorldBorderUpdateNew.getColor());
    }

    @Override
    public void handleWorldBorderRemove(LCPacketWorldBorderRemove lCPacketWorldBorderRemove) {
        LunarClient.getInstance().IlIIlIIlIIlIIllIIIllIIllI().lIlIlIlIlIIlIIlIIllIIIIIl(lCPacketWorldBorderRemove.getId());
    }

    @Override
    public void handleBossBar(LCPacketBossBar lCPacketBossBar) {
    }

    @Override
    public void handleAddWaypoint(LCPacketWaypointAdd lCPacketWaypointAdd) {
        LunarLogger.debug((Object)"Received waypoint: %s", lCPacketWaypointAdd.getName());
        Vec3Bridge vec3Bridge = Bridge.getInstance().initVec3d((float)lCPacketWaypointAdd.getX() + 0.5f, lCPacketWaypointAdd.getY(), (float)lCPacketWaypointAdd.getZ() + 0.5f);
        Waypoint waypoint = new Waypoint(lCPacketWaypointAdd.getName(), vec3Bridge, lCPacketWaypointAdd.getWorld(), -999, lCPacketWaypointAdd.isVisible(), lCPacketWaypointAdd.isForced(), WaypointsJson.IlllllIlIIIlIIlIIllIIlIll(), true);
        waypoint.getColor().setColor(lCPacketWaypointAdd.getColor());
        LunarClient.getInstance().llIllIlIllIlllIllIIIIllII().lIlIlIlIlIIlIIlIIllIIIIIl(waypoint, false);
    }

    @Override
    public void handleRemoveWaypoint(LCPacketWaypointRemove lCPacketWaypointRemove) {
        LunarClient.getInstance().llIllIlIllIlllIllIIIIllII().llIlllIIIllllIIlllIllIIIl().removeIf(waypoint -> waypoint.isHandledByServer() && waypoint.getName().equals(lCPacketWaypointRemove.getName()) && waypoint.getWorld().equals(lCPacketWaypointRemove.getWorld()));
    }

    @Override
    public void handleEmote(LCPacketEmoteBroadcast lCPacketEmoteBroadcast) {
    }

    @Override
    public String getLanguagePath() {
        return "settings";
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.channelName;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return "LC-Binary";
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }
}
