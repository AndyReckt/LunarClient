package com.moonsworth.lunar.client.registry;

import com.google.common.collect.BiMap;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.entity.player.CreatePlayerEvent;
import com.moonsworth.lunar.client.event.type.entity.player.RemovePlayerEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.json.file.ItemMapLoader;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EmoteConfig
extends ItemMapLoader
implements EventHandler {
    public static final BiMap llIlllIIIllllIIlllIllIIIl = ((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)ImmutableBiMap.builder().put((Object)7, "fresh")).put((Object)8, "hype")).put((Object)9, "squat_kick")).put((Object)10, "l_dance")).put((Object)11, "tidy")).put((Object)12, "free_flow")).put((Object)13, "shimmer")).put((Object)14, "get_funky")).put((Object)15, "gun_lean")).put((Object)16, "gangnam_style")).put((Object)17, "salute")).put((Object)18, "bitchslap")).put((Object)19, "bongo_cat")).put((Object)20, "breathtaking")).put((Object)21, "disgusted")).put((Object)22, "exhausted")).put((Object)23, "punch")).put((Object)24, "sneeze")).put((Object)25, "threatening")).put((Object)26, "woah")).put((Object)27, "boneless")).put((Object)28, "best_mates")).put((Object)29, "default")).put((Object)30, "disco_fever")).put((Object)31, "electro_shuffle")).put((Object)32, "floss")).put((Object)33, "infinite_dab")).put((Object)34, "orange_justice")).put((Object)35, "skibidi")).put((Object)36, "boy")).put((Object)37, "bow")).put((Object)38, "calculated")).put((Object)39, "chicken")).put((Object)40, "clapping")).put((Object)41, "club")).put((Object)42, "confused")).put((Object)43, "crying")).put((Object)44, "dab")).put((Object)45, "facepalm")).put((Object)46, "fist")).put((Object)47, "laughing")).put((Object)48, "no")).put((Object)49, "pointing")).put((Object)50, "popcorn")).put((Object)51, "pure_salt")).put((Object)52, "shrug")).put((Object)53, "t_pose")).put((Object)54, "thinking")).put((Object)55, "twerk")).put((Object)56, "wave")).put((Object)57, "yes")).put((Object)58, "naruto_run")).put((Object)59, "moonwalk")).put((Object)63, "whip_and_nae_nae")).put((Object)64, "hands_up")).put((Object)65, "renegade")).put((Object)66, "toosie_slide")).build();
    public List llllIIlIIlIIlIIllIIlIIllI = new ArrayList();
    public List IlIlIlllllIlIIlIlIlllIlIl = new ArrayList();
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl;
    public int IlllIIIIIIlllIlIIlllIlIIl;
    public boolean lIllIlIIIlIIIIIIIlllIlIll;

    public EmoteConfig() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RemovePlayerEvent.class, (removePlayerEvent) -> {
            if (Ref.llIIIIIIIllIIllIlIllIIIIl() == null) {
                return;
            }
            Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(removePlayerEvent.lIlIlIlIlIIlIIlIIllIIIIIl(), false);
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(CreatePlayerEvent.class, (createPlayerEvent) -> {
            if (Ref.llIIIIIIIllIIllIlIllIIIIl() == null) {
                return;
            }
            Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((EntityPlayerBridge)createPlayerEvent.lIlIlIlIlIIlIIlIIllIIIIIl(), false);
        });
    }

    public void llllIIlIIlIIlIIllIIlIIllI() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.IlIlIlllllIlIIlIlIlllIlIl(), false, false);
        if (Ref.llIIIIIIIllIIllIlIllIIIIl() != null) {
            for (EntityPlayerBridge entityPlayerBridge : Ref.llIIIIIIIllIIllIlIllIIIIl().bridge$getPlayerEntities()) {
                Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(entityPlayerBridge, false, false);
            }
        }
    }

    public void IlIlIlllllIlIIlIlIlllIlIl() {
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketEmotesList(new ArrayList(this.IlIlIlllllIlIIlIlIlllIlIl)));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractEmote abstractEmote) {
        if (Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll()) {
            return;
        }
        if (this.IlllIIIIIIlllIlIIlllIlIIl(abstractEmote)) {
            int n = (Integer)llIlllIIIllllIIlllIllIIIl.inverse().get(abstractEmote.lIlIlIlIlIIlIIlIIllIIIIIl());
            if (this.llIlllIIIllllIIlllIllIIIl().containsKey(Ref.IlIlIlllllIlIIlIlIlllIlIl().bridge$getUniqueID())) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl = false;
                this.lIllIlIIIlIIIIIIIlllIlIll = true;
            } else {
                this.lIllIlIIIlIIIIIIIlllIlIll = false;
            }
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientEmote(n));
        } else {
            LunarLogger.llIlllIIIllllIIlllIllIIIl((Object)"Couldn't perform emote (%s) as you do not own it", abstractEmote.getClass().getSimpleName());
        }
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(AbstractEmote abstractEmote) {
        return this.llllIIlIIlIIlIIllIIlIIllI.contains(llIlllIIIllllIIlllIllIIIl.inverse().get(abstractEmote.lIlIlIlIlIIlIIlIIllIIIIIl()));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerBridge entityPlayerBridge, AbstractEmote abstractEmote) {
        this.IlllIIIIIIlllIlIIlllIlIIl(entityPlayerBridge);
        if (abstractEmote != null && entityPlayerBridge == Ref.IlIlIlllllIlIIlIlIlllIlIl() && !Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll() && !Ref.IlIlIlllllIlIIlIlIlllIlIl().bridge$getMovementInput().bridge$isSneaking() && Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getGameSettings().bridge$getThirdPersonView() == 0) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = true;
            Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getGameSettings().bridge$setThirdPersonView(1);
        }
        if (abstractEmote != null) {
            this.llIlllIIIllllIIlllIllIIIl().putIfAbsent(entityPlayerBridge.bridge$getUniqueID(), abstractEmote);
            if (abstractEmote instanceof Emote) {
                ((Emote)abstractEmote).IlllIIIIIIlllIlIIlllIlIIl(entityPlayerBridge);
            }
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerBridge entityPlayerBridge) {
        Cosmetic cosmetic = (Cosmetic)Cosmetic.get(entityPlayerBridge.bridge$getUniqueID());
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
        if (entityPlayerBridge == Ref.IlIlIlllllIlIIlIlIlllIlIl() && Ref.getAssetsWebsocket().isPresent() && ((AssetsWebSocket)Ref.getAssetsWebsocket().get()).isOpen() && bl2 && !bl) {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientEmote(-1));
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(EntityPlayerBridge entityPlayerBridge) {
        Map<UUID, AbstractEmote> map = this.llIlllIIIllllIIlllIllIIIl();
        if (map != null && map.containsKey(entityPlayerBridge.bridge$getUniqueID())) {
            AbstractEmote abstractEmote = (AbstractEmote)map.get(entityPlayerBridge.bridge$getUniqueID());
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
            String string = (String)llIlllIIIllllIIlllIllIIIl.get(n);
            return string == null ? null : new Emote(n, string);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ModelBipedRenderEvent modelBipedRenderEvent) {
        AbstractEmote abstractEmote = (AbstractEmote)this.llIlllIIIllllIIlllIllIIIl().get(modelBipedRenderEvent.IlllIIIIIIlllIlIIlllIlIIl().bridge$getUniqueID());
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
            for (Map.Entry object : this.llIlllIIIllllIIlllIllIIIl().entrySet()) {
                UUID uUID = (UUID)object.getKey();
                AbstractEmote abstractEmote = (AbstractEmote)object.getValue();
                if (!abstractEmote.IlllIIIIIIlllIlIIlllIlIIl()) continue;
                Ref.llIIIIIIIllIIllIlIllIIIIl().bridge$getPlayerByUniqueId(uUID).ifPresent(entityPlayerBridge -> {
                    if (abstractEmote.IlllIIIIIIlllIlIIlllIlIIl()) {
                        abstractEmote.lIlIlIlIlIIlIIlIIllIIIIIl((EntityPlayerBridge)entityPlayerBridge);
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
    public Map lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new HashMap();
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(EntityLivingBaseBridge entityLivingBaseBridge) {
        AbstractEmote abstractEmote = (AbstractEmote)this.llIlllIIIllllIIlllIllIIIl().get(entityLivingBaseBridge.bridge$getUniqueID());
        return abstractEmote == null || abstractEmote.lIllIlIIIlIIIIIIIlllIlIll();
    }

    public List llIIIIIIIllIIllIlIllIIIIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(List list) {
        this.llllIIlIIlIIlIIllIIlIIllI = list;
    }

    public List lIIIllIllIIllIlllIlIIlllI() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(List list) {
        this.IlIlIlllllIlIIlIlIlllIlIl = list;
    }
}
 