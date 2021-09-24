package com.moonsworth.lunar.client.registry;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.emote.AbstractEmote;
import com.moonsworth.lunar.client.emote.Emote;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.state.EventState;
import com.moonsworth.lunar.client.event.type.entity.player.CreatePlayerEvent;
import com.moonsworth.lunar.client.event.type.entity.player.RemovePlayerEvent;
import com.moonsworth.lunar.client.event.type.hud.ModelBipedRenderEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.json.file.ItemMapLoader;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.websocket.packet.WSPacketClientEmote;
import com.moonsworth.lunar.client.websocket.packet.WSPacketEmotesList;
import mchorse.emoticons.capabilities.cosmetic.Cosmetic;
import mchorse.emoticons.common.EmoteAPI;

import java.util.*;

public class EmoteConfig extends ItemMapLoader<UUID, AbstractEmote> implements EventHandler {
    public static final BiMap<Integer, String> llIlllIIIllllIIlllIllIIIl = (BiMap)(ImmutableBiMap.builder()
            .put(7, "fresh")
            .put(8, "hype")
            .put(9, "squat_kick")
            .put(10, "l_dance")
            .put(11, "tidy")
            .put(12, "free_flow")
            .put(13, "shimmer")
            .put(14, "get_funky")
            .put(15, "gun_lean")
            .put(16, "gangnam_style")
            .put(17, "salute")
            .put(18, "bitchslap")
            .put(19, "bongo_cat")
            .put(20, "breathtaking")
            .put(21, "disgusted")
            .put(22, "exhausted")
            .put(23, "punch")
            .put(24, "sneeze")
            .put(25, "threatening")
            .put(26, "woah")
            .put(27, "boneless")
            .put(28, "best_mates")
            .put(29, "default")
            .put(30, "disco_fever")
            .put(31, "electro_shuffle")
            .put(32, "floss")
            .put(33, "infinite_dab")
            .put(34, "orange_justice")
            .put(35, "skibidi")
            .put(36, "boy")
            .put(37, "bow")
            .put(38, "calculated")
            .put(39, "chicken")
            .put(40, "clapping")
            .put(41, "club")
            .put(42, "confused")
            .put(43, "crying")
            .put(44, "dab")
            .put(45, "facepalm")
            .put(46, "fist")
            .put(47, "laughing")
            .put(48, "no")
            .put(49, "pointing")
            .put(50, "popcorn")
            .put(51, "pure_salt")
            .put(52, "shrug")
            .put(53, "t_pose")
            .put(54, "thinking")
            .put(55, "twerk")
            .put(56, "wave")
            .put(57, "yes")
            .put(58, "naruto_run")
            .put(59, "moonwalk")
            .put(63, "whip_and_nae_nae")
            .put(64, "hands_up")
            .put(65, "renegade")
            .put(66, "toosie_slide")
            .build());
    public List<Integer> llllIIlIIlIIlIIllIIlIIllI = new ArrayList<>();
    public List<Integer> IlIlIlllllIlIIlIlIlllIlIl = new ArrayList<>();
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl;
    public int IlllIIIIIIlllIlIIlllIlIIl;
    public boolean lIllIlIIIlIIIIIIIlllIlIll;

    public EmoteConfig() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RemovePlayerEvent.class, (removePlayerEvent) -> {
            if (Ref.getWorld() == null) {
                return;
            }
            Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(removePlayerEvent.lIlIlIlIlIIlIIlIIllIIIIIl(), false);
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(CreatePlayerEvent.class, (createPlayerEvent) -> {
            if (Ref.getWorld() == null) {
                return;
            }
            Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(createPlayerEvent.lIlIlIlIlIIlIIlIIllIIIIIl(), false);
        });
    }

    public void llllIIlIIlIIlIIllIIlIIllI() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getPlayer(), false, false);
        if (Ref.getWorld() != null) {
            for (EntityPlayerBridge entityPlayerBridge : Ref.getWorld().bridge$getPlayerEntities()) {
                Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(entityPlayerBridge, false, false);
            }
        }
    }

    public void IlIlIlllllIlIIlIlIlllIlIl() {
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketEmotesList(new ArrayList<>(this.IlIlIlllllIlIIlIlIlllIlIl)));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractEmote abstractEmote) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll()) {
            return;
        }
        if (this.IlllIIIIIIlllIlIIlllIlIIl(abstractEmote)) {
            int n = llIlllIIIllllIIlllIllIIIl.inverse().get(abstractEmote.lIlIlIlIlIIlIIlIIllIIIIIl());
            if (this.llIlllIIIllllIIlllIllIIIl().containsKey(Ref.getPlayer().bridge$getUniqueID())) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl = false;
                this.lIllIlIIIlIIIIIIIlllIlIll = true;
            } else {
                this.lIllIlIIIlIIIIIIIlllIlIll = false;
            }
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientEmote(n));
        } else {
            LunarLogger.error((Object) "Couldn't perform emote (%s) as you do not own it", abstractEmote.getClass().getSimpleName());
        }
    }

    // IlllIIIIIIlllIlIIlllIlIIl
    public boolean IlllIIIIIIlllIlIIlllIlIIl(AbstractEmote abstractEmote) {
        return this.llllIIlIIlIIlIIllIIlIIllI.contains(llIlllIIIllllIIlllIllIIIl.inverse().get(abstractEmote.lIlIlIlIlIIlIIlIIllIIIIIl()));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerBridge entityPlayerBridge, AbstractEmote abstractEmote) {
        this.IlllIIIIIIlllIlIIlllIlIIl(entityPlayerBridge);
        if (abstractEmote != null && entityPlayerBridge == Ref.getPlayer() && !Ref.getLC().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll() && !Ref.getPlayer().bridge$getMovementInput().bridge$isSneaking() && Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getGameSettings().bridge$getThirdPersonView() == 0) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = true;
            Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getGameSettings().bridge$setThirdPersonView(1);
        }
        if (abstractEmote != null) {
            this.llIlllIIIllllIIlllIllIIIl().putIfAbsent(entityPlayerBridge.bridge$getUniqueID(), abstractEmote);
            if (abstractEmote instanceof Emote) {
                ((Emote) abstractEmote).IlllIIIIIIlllIlIIlllIlIIl(entityPlayerBridge);
            }
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerBridge entityPlayerBridge) {
        Cosmetic cosmetic = (Cosmetic) Cosmetic.get(entityPlayerBridge.bridge$getUniqueID());
        return cosmetic != null && cosmetic.emote != null;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerBridge entityPlayerBridge, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(entityPlayerBridge, bl, true);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerBridge entityPlayerBridge, boolean bl, boolean bl2) {
        if (!this.llIlllIIIllllIIlllIllIIIl().containsKey(entityPlayerBridge.bridge$getUniqueID())) {
            return;
        }
        this.IlllIIIIIIlllIlIIlllIlIIl(entityPlayerBridge);
        if (entityPlayerBridge == Ref.getPlayer() && Ref.getAssetsWebsocket().isPresent() && Ref.getAssetsWebsocket().get().isOpen() && bl2 && !bl) {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientEmote(-1));
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(EntityPlayerBridge entityPlayerBridge) {
        Map<UUID, AbstractEmote> map = this.llIlllIIIllllIIlllIllIIIl();
        if (map != null && map.containsKey(entityPlayerBridge.bridge$getUniqueID())) {
            AbstractEmote abstractEmote = map.get(entityPlayerBridge.bridge$getUniqueID());
            if (abstractEmote != null) {
                if (abstractEmote instanceof Emote) {
                    EmoteAPI.setEmoteClient(null, entityPlayerBridge);
                }
                abstractEmote.lIlIlIlIlIIlIIlIIllIIIIIl(entityPlayerBridge);
            }
            map.remove(entityPlayerBridge.bridge$getUniqueID());
        }
    }

    public AbstractEmote lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        try {
            String string = llIlllIIIllllIIlllIllIIIl.get(n);
            return string == null ? null : new Emote(n, string);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ModelBipedRenderEvent modelBipedRenderEvent) {
        AbstractEmote abstractEmote = this.llIlllIIIllllIIlllIllIIIl().get(modelBipedRenderEvent.IlllIIIIIIlllIlIIlllIlIIl().bridge$getUniqueID());
        if (abstractEmote != null && !modelBipedRenderEvent.IlllIIIIIIlllIlIIlllIlIIl().bridge$isInvisible()) {
            if (modelBipedRenderEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == EventState.PRE) {
                abstractEmote.lIlIlIlIlIIlIIlIIllIIIIIl(modelBipedRenderEvent.IlllIIIIIIlllIlIIlllIlIIl(), modelBipedRenderEvent.lIllIlIIIlIIIIIIIlllIlIll(), modelBipedRenderEvent.llIlllIIIllllIIlllIllIIIl());
            } else {
                abstractEmote.lIlIlIlIlIIlIIlIIllIIIIIl(modelBipedRenderEvent.IlllIIIIIIlllIlIIlllIlIIl(), modelBipedRenderEvent.llIlllIIIllllIIlllIllIIIl());
            }
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent tickEvent) {
        if (!this.llIlllIIIllllIIlllIllIIIl().isEmpty()) {
            ArrayList<UUID> arrayList = new ArrayList<UUID>();
            for (Map.Entry<UUID, AbstractEmote> object : this.llIlllIIIllllIIlllIllIIIl().entrySet()) {
                UUID uUID = object.getKey();
                AbstractEmote abstractEmote = object.getValue();
                if (!abstractEmote.IlllIIIIIIlllIlIIlllIlIIl()) continue;
                Ref.getWorld().bridge$getPlayerByUniqueId(uUID).ifPresent(entityPlayerBridge -> {
                    if (abstractEmote.IlllIIIIIIlllIlIIlllIlIIl()) {
                        abstractEmote.lIlIlIlIlIIlIIlIIllIIIIIl(entityPlayerBridge);
                    }
                });
                arrayList.add(uUID);
            }
            for (UUID uUID : arrayList) {
                this.llIlllIIIllllIIlllIllIIIl().remove(uUID);
            }
        }
    }

    @Override
    public Map<UUID, AbstractEmote> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new HashMap<>();
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(EntityLivingBaseBridge entityLivingBaseBridge) {
        AbstractEmote abstractEmote = this.llIlllIIIllllIIlllIllIIIl().get(entityLivingBaseBridge.bridge$getUniqueID());
        return abstractEmote == null || abstractEmote.lIllIlIIIlIIIIIIIlllIlIll();
    }

    public List<Integer> llIIIIIIIllIIllIlIllIIIIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(List<Integer> list) {
        this.llllIIlIIlIIlIIllIIlIIllI = list;
    }

    public List<Integer> lIIIllIllIIllIlllIlIIlllI() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(List<Integer> list) {
        this.IlIlIlllllIlIIlIlIlllIlIl = list;
    }
}
