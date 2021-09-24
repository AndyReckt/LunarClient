package com.moonsworth.lunar.client.registry;

import com.google.common.base.Charsets;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RendererLivingEntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers.LayerCapeBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.AbstractTextureBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.CustomTextureBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.CustomTextureHolder;
import com.moonsworth.lunar.bridge.minecraft.client.resources.SimpleResourceBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.data.AnimationMetadataSectionBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ModelCloak;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.cosmetic.CloakCosmetic;
import com.moonsworth.lunar.client.cosmetic.Cosmetic;
import com.moonsworth.lunar.client.cosmetic.CosmeticIndexEntry;
import com.moonsworth.lunar.client.cosmetic.builder.HeadwearCosmeticBuilder;
import com.moonsworth.lunar.client.cosmetic.builder.TieCosmeticBuilder;
import com.moonsworth.lunar.client.cosmetic.layer.CosmeticManagerLayer;
import com.moonsworth.lunar.client.cosmetic.layer.LowBodyCustomLayer;
import com.moonsworth.lunar.client.cosmetic.model.ModelMesh;
import com.moonsworth.lunar.client.cosmetic.part.AbstractCosmetic;
import com.moonsworth.lunar.client.cosmetic.type.HatCosmetic;
import com.moonsworth.lunar.client.cosmetic.type.HatCosmeticType;
import com.moonsworth.lunar.client.cosmetic.type.HeadCustomLayer;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.state.EventState;
import com.moonsworth.lunar.client.event.type.entity.player.CreatePlayerEvent;
import com.moonsworth.lunar.client.event.type.entity.player.SetOptiFineCapeEvent;
import com.moonsworth.lunar.client.event.type.hud.ModelBipedRenderEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.texture.AnimationTickingTexture;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.base.CosmeticsListUIComponent;
import com.moonsworth.lunar.client.websocket.packet.WSPacketClientCosmetics;
import lombok.SneakyThrows;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJLoader;

import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

public class CosmeticManager extends ItemSetLoader<Cosmetic> implements EventHandler {
    public final Map<Integer, CosmeticIndexEntry> llIlllIIIllllIIlllIllIIIl = new HashMap<>();
    public final Map<UUID, List<Cosmetic>> llllIIlIIlIIlIIllIIlIIllI = new HashMap<>();
    public Map<UUID, NameTagLogo> IlIlIlllllIlIIlIlIlllIlIl = new HashMap<>();
    public BiMap<String, UUID> llIIIIIIIllIIllIlIllIIIIl = HashBiMap.create();
    public Map<ResourceLocationBridge, ModelCloak> lIIIllIllIIllIlllIlIIlllI = new HashMap<>();
    public final Map<ResourceLocationBridge, ModelMesh> IlllllIlIIIlIIlIIllIIlIll = new HashMap<>();
    public boolean llIIlIlIIIllIlIlIlIIlIIll = false;
    public static final Function<ResourceLocationBridge, HatCosmetic> llIIIlllIIlllIllllIlIllIl = resourceLocationBridge -> {
        if (resourceLocationBridge.bridge$getPath().toLowerCase().contains("masks/halloween")) {
            return (HatCosmetic) HeadwearCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.get("halloween_mask");
        }
        if (resourceLocationBridge.bridge$getPath().toLowerCase().contains("bandanna")) {
            return (HatCosmetic) HeadwearCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.get("bandanna");
        }
        if (resourceLocationBridge.bridge$getPath().toLowerCase().contains("mask")) {
            return (HatCosmetic) HeadwearCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.get("mask");
        }
        if (resourceLocationBridge.bridge$getPath().toLowerCase().contains("halos")) {
            return (HatCosmetic) HeadwearCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.get("halo");
        }
        if (resourceLocationBridge.bridge$getPath().toLowerCase().contains("headsets")) {
            return (HatCosmetic) HeadwearCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.get("gaming_headset");
        }
        if (resourceLocationBridge.bridge$getPath().toLowerCase().contains("catears")) {
            return (HatCosmetic) HeadwearCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.get("cute_cat_ears");
        }
        if (resourceLocationBridge.bridge$getPath().toLowerCase().contains("tophats")) {
            return (HatCosmetic) HeadwearCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.get("tophats");
        }
        return (HatCosmetic) HeadwearCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.get(resourceLocationBridge.bridge$getPath().toLowerCase());
    };
    public static final Function<ResourceLocationBridge, AbstractCosmetic> lllllIllIllIllllIlIllllII = resourceLocationBridge -> {
        HatCosmetic hatCosmetic = llIIIlllIIlllIllllIlIllIl.apply(resourceLocationBridge);
        if (hatCosmetic != null) {
            return hatCosmetic;
        }
        if (resourceLocationBridge.bridge$getPath().contains("ties")) {
            if (resourceLocationBridge.bridge$getPath().toLowerCase().contains("_bowtie")) {
                return (AbstractCosmetic) TieCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.get("bowtie");
            }
            if (resourceLocationBridge.bridge$getPath().toLowerCase().contains("_tie")) {
                return (AbstractCosmetic) TieCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.get("tie");
            }
        }
        return (AbstractCosmetic) TieCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.get(resourceLocationBridge.bridge$getPath().toLowerCase());
    };
    public HeadCustomLayer lllIIIIIlllIIlIllIIlIIIlI;
    public CosmeticManagerLayer lIlIIIIIIlIIIllllIllIIlII;
    public LowBodyCustomLayer llIlIIIllIIlIllIllIllllIl;
    public LayerCapeBridge IllIllIIIllIIIlIlIlIIIIll;
    public static AtomicBoolean IIlIllIlllllllIIlIIIllIIl = new AtomicBoolean(false);
    public static final ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl = Bridge.getInstance().initResourceLocation("lunar", "logo/logo-64x64.png");
    public static final ResourceLocationBridge IlllIIIIIIlllIlIIlllIlIIl = Bridge.getInstance().initResourceLocation("lunar", "logo/logo-100x100.png");
    public static final ResourceLocationBridge lIllIlIIIlIIIIIIIlllIlIll = Bridge.getInstance().initResourceLocation("lunar", "logo/logo-32x30.png");

    public CosmeticManager() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(SetOptiFineCapeEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(CreatePlayerEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        if (Bridge.getMinecraftVersion() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(ModelBipedRenderEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        }
        System.out.println("Loading cosmetic index...");
        try {
            ResourceLocationBridge resourceLocationBridge = Bridge.getInstance().initResourceLocation("lunar", "cosmetics/index");
            SimpleResourceBridge simpleResourceBridge = Ref.getMinecraft().bridge$getResourceManager().bridge$getResource(resourceLocationBridge);
            Scanner scanner = new Scanner(new InputStreamReader(simpleResourceBridge.bridge$getInputStream()));
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                if (string.isEmpty()) continue;
                CosmeticIndexEntry cosmeticIndexEntry = new CosmeticIndexEntry(string);
                this.llIlllIIIllllIIlllIllIIIl.put(cosmeticIndexEntry.lIlIlIlIlIIlIIlIIllIIIIIl(), cosmeticIndexEntry);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public HatCosmetic lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge) {
        return llIIIlllIIlllIllllIlIllIl.apply(resourceLocationBridge);
    }

    public AbstractCosmetic IlllIIIIIIlllIlIIlllIlIIl(ResourceLocationBridge resourceLocationBridge) {
        return lllllIllIllIllllIlIllllII.apply(resourceLocationBridge);
    }

    @Override
    public Set lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new HashSet();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ModelBipedRenderEvent modelBipedRenderEvent) {
        if (!modelBipedRenderEvent.lIlIlIlIlIIlIIlIIllIIIIIl().equals(EventState.POST) || modelBipedRenderEvent.IlllIIIIIIlllIlIIlllIlIIl().bridge$isSpectator()) {
            return;
        }
        for (Cosmetic cosmetic : this.llllIIlIIlIIlIIllIIlIIllI(modelBipedRenderEvent.IlllIIIIIIlllIlIIlllIlIIl().bridge$getUniqueID())) {
            cosmetic.lIlIlIlIlIIlIIlIIllIIIIIl(modelBipedRenderEvent.IlllIIIIIIlllIlIIlllIlIIl(), modelBipedRenderEvent.llIlllIIIllllIIlllIllIIIl());
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(SetOptiFineCapeEvent setOptiFineCapeEvent) {
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(CreatePlayerEvent createPlayerEvent) {
        if (createPlayerEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == Ref.getPlayer()) {
            this.IlIlIlllllIlIIlIlIlllIlIl();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(UUID uUID, Cosmetic cosmetic) {
        this.llllIIlIIlIIlIIllIIlIIllI.putIfAbsent(uUID, new ArrayList<>());
        (this.llllIIlIIlIIlIIllIIlIIllI.get(uUID)).add(cosmetic);
    }

    public CloakCosmetic lIlIlIlIlIIlIIlIIllIIIIIl(UUID uUID) {
        if (this.llllIIlIIlIIlIIllIIlIIllI.containsKey(uUID)) {
            for (Cosmetic cosmetic : this.llllIIlIIlIIlIIllIIlIIllI.get(uUID)) {
                if (!(cosmetic instanceof CloakCosmetic)) continue;
                return (CloakCosmetic) cosmetic;
            }
        }
        return null;
    }

    public HatCosmeticType IlllIIIIIIlllIlIIlllIlIIl(UUID uUID) {
        return this.IlllIIIIIIlllIlIIlllIlIIl(uUID, HatCosmeticType.class);
    }

    public List<HatCosmeticType> lIllIlIIIlIIIIIIIlllIlIll(UUID uUID) {
        ArrayList<HatCosmeticType> arrayList = new ArrayList<HatCosmeticType>();
        if (this.llllIIlIIlIIlIIllIIlIIllI.containsKey(uUID)) {
            for (Cosmetic cosmetic : this.llllIIlIIlIIlIIllIIlIIllI.get(uUID)) {
                if (!(cosmetic instanceof HatCosmeticType)) continue;
                arrayList.add((HatCosmeticType) cosmetic);
            }
        }
        return arrayList;
    }

    public <T extends Cosmetic> List<T> lIlIlIlIlIIlIIlIIllIIIIIl(UUID uUID, Class<T> clazz) {
        ArrayList<T> arrayList = new ArrayList<>();
        if (this.llllIIlIIlIIlIIllIIlIIllI.containsKey(uUID)) {
            for (Cosmetic cosmetic : this.llllIIlIIlIIlIIllIIlIIllI.get(uUID)) {
                if (!cosmetic.getClass().isAssignableFrom(clazz)) continue;
                arrayList.add(clazz.cast(cosmetic));
            }
        }
        return arrayList;
    }

    public <T extends Cosmetic> T IlllIIIIIIlllIlIIlllIlIIl(UUID uUID, Class<T> clazz) {
        if (this.llllIIlIIlIIlIIllIIlIIllI.containsKey(uUID)) {
            for (Cosmetic cosmetic : this.llllIIlIIlIIlIIllIIlIIllI.get(uUID)) {
                if (!cosmetic.getClass().isAssignableFrom(clazz)) continue;
                return clazz.cast(cosmetic);
            }
        }
        return null;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll(ResourceLocationBridge resourceLocationBridge) {
        return this.IlllllIlIIIlIIlIIllIIlIll.containsKey(resourceLocationBridge);
    }

    @Override
    public void b_() {
        super.b_();
        this.lllIIIIIlllIIlIllIIlIIIlI = new HeadCustomLayer(this);
        this.lIlIIIIIIlIIIllllIllIIlII = new CosmeticManagerLayer(this);
        this.llIlIIIllIIlIllIllIllllIl = new LowBodyCustomLayer(this);
        if (Bridge.getMinecraftVersion().ordinal() >= MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl.ordinal()) {
            for (Object object : Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getRenderManager().bridge$getSkinMap().values()) {
                if (object instanceof RendererLivingEntityBridge) {
                    RendererLivingEntityBridge rendererLivingEntityBridge = (RendererLivingEntityBridge) object;
                    rendererLivingEntityBridge.bridge$addLayer(this.lllIIIIIlllIIlIllIIlIIIlI, true);
                    rendererLivingEntityBridge.bridge$addLayer(this.lIlIIIIIIlIIIllllIllIIlII, true);
                    rendererLivingEntityBridge.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl);
                }
                this.IllIllIIIllIIIlIlIlIIIIll = ((RendererLivingEntityBridge) (Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getRenderManager().bridge$defaultPlayerRenderer())).bridge$getLayerCape();
            }
        }
        for (Object object : HeadwearCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.values()) {
            try {
                ((AbstractCosmetic) object).lIllIlIIIlIIIIIIIlllIlIll();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        for (Object object : TieCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.values()) {
            try {
                ((AbstractCosmetic) object).lIllIlIIIlIIIIIIIlllIlIll();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, (tickEvent) -> {
            if (!IIlIllIlllllllIIlIIIllIIl.get()) {
                this.llIlllIIIllllIIlllIllIIIl.forEach((n, cosmeticIndexEntry) -> {
                    if (cosmeticIndexEntry.IlIlIlllllIlIIlIlIlllIlIl()) {
                        try {
                            ResourceLocationBridge resourceLocationBridge = Bridge.getInstance().initResourceLocation("lunar", cosmeticIndexEntry.lIllIlIIIlIIIIIIIlllIlIll());
                            AnimationTickingTexture animationTickingTexture = this.llIlllIIIllllIIlllIllIIIl(resourceLocationBridge);
                            if (cosmeticIndexEntry.llllIIlIIlIIlIIllIIlIIllI().equalsIgnoreCase("cape")) {
                                this.llIIIlllIIlllIllllIlIllIl().put(resourceLocationBridge, Bridge.getInstance().initModelCloak(animationTickingTexture.IlllIIIIIIlllIlIIlllIlIIl()));
                            } else {
                                SimpleResourceBridge simpleResourceBridge = Ref.getMinecraft().bridge$getResourceManager().bridge$getResource(lllllIllIllIllllIlIllllII.apply(resourceLocationBridge).IlllIIIIIIlllIlIIlllIlIIl());
                                BOBJLoader.BOBJData bOBJData = BOBJLoader.readData(simpleResourceBridge.bridge$getInputStream());
                                ModelMesh modelMesh = new ModelMesh(bOBJData);
                                modelMesh.lIlIlIlIlIIlIIlIIllIIIIIl();
                                this.lllllIllIllIllllIlIllllII().put(resourceLocationBridge, modelMesh);
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                IIlIllIlllllllIIlIIIllIIl.set(true);
            }
            for (HatCosmetic object : HeadwearCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.values()) {
                if (!object.IlllllIlIIIlIIlIIllIIlIll()) continue;
                object.llIlIIIllIIlIllIllIllllIl();
            }
            for (AbstractCosmetic abstractCosmetic : TieCosmeticBuilder.lIlIlIlIlIIlIIlIIllIIIIIl.values()) {
                if (!abstractCosmetic.IlllllIlIIIlIIlIIllIIlIll()) continue;
                abstractCosmetic.llIlIIIllIIlIllIllIllllIl();
            }
            for (Map.Entry<ResourceLocationBridge, ModelMesh> entry : this.IlllllIlIIIlIIlIIllIIlIll.entrySet()) {
                CustomTextureBridge customTextureBridge;
                AbstractTextureBridge abstractTextureBridge = Ref.getMinecraft().bridge$getTextureManager().bridge$getTexture(entry.getKey());
                if (abstractTextureBridge == null || !(abstractTextureBridge instanceof CustomTextureHolder) || !((customTextureBridge = ((CustomTextureHolder) abstractTextureBridge).getCustomTexture()) instanceof AnimationTickingTexture))
                    continue;
                AnimationTickingTexture animationTickingTexture = (AnimationTickingTexture) customTextureBridge;
                animationTickingTexture.bridge$tick();
                int n2 = animationTickingTexture.lIlIlIlIlIIlIIlIIllIIIIIl() * animationTickingTexture.IlllIIIIIIlllIlIIlllIlIIl();
                int n3 = animationTickingTexture.IlllIIIIIIlllIlIIlllIlIIl();
                entry.getValue().lIlIlIlIlIIlIIlIIllIIIIIl(n2, n3);
            }
        });
    }

    public void llIlllIIIllllIIlllIllIIIl(UUID uUID) {
        this.llIlllIIIllllIIlllIllIIIl().clear();
        this.llllIIlIIlIIlIIllIIlIIllI.remove(uUID);
    }

    public List<Cosmetic> llllIIlIIlIIlIIllIIlIIllI(UUID uUID) {
        return this.llllIIlIIlIIlIIllIIlIIllI.getOrDefault(uUID, ImmutableList.of());
    }

    public void llllIIlIIlIIlIIllIIlIIllI() {
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientCosmetics(new ArrayList<>(this.llIlllIIIllllIIlllIllIIIl())));
        LunarLogger.debug("Synced cosmetics to assets server.");
        this.IlIlIlllllIlIIlIlIlllIlIl();
    }

    public void IlIlIlllllIlIIlIlIlllIlIl() {
        UUID uUID = Ref.getMinecraft().bridge$getSession().bridge$getProfile().getId();
        this.llllIIlIIlIIlIIllIIlIIllI.remove(uUID);
        for (Cosmetic cosmetic : this.llIlllIIIllllIIlllIllIIIl()) {
            if (!cosmetic.llIIIIIIIllIIllIlIllIIIIl()) continue;
            this.lIlIlIlIlIIlIIlIIllIIIIIl(uUID, cosmetic);
        }
        try {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(uUID, CosmeticsListUIComponent.llIIIIIIIllIIllIlIllIIIIl().bridge$getGameProfile().getId());
        } catch (Exception exception) {
            // empty catch block
        }
    }

    @SneakyThrows
    public AnimationTickingTexture llIlllIIIllllIIlllIllIIIl(ResourceLocationBridge resourceLocationBridge) {
        SimpleResourceBridge simpleResourceBridge = Ref.getMinecraft().bridge$getResourceManager().bridge$getResource(resourceLocationBridge);
        if (simpleResourceBridge.bridge$hasMetadata() && simpleResourceBridge.bridge$getMetadata("animation") != null) {
            AnimationTickingTexture animationTickingTexture = new AnimationTickingTexture(resourceLocationBridge, (AnimationMetadataSectionBridge) simpleResourceBridge.bridge$getMetadata("animation"));
            Ref.getMinecraft().bridge$getTextureManager().bridge$loadTickableTexture(resourceLocationBridge, Bridge.getInstance().initTickingTexture(animationTickingTexture));
            return animationTickingTexture;
        }
        return null;
    }

    public UUID lIlIlIlIlIIlIIlIIllIIIIIl(GameProfile gameProfile) {
        try {
            if (gameProfile.getProperties().containsKey( "textures")) {
                Property property = Iterables.getFirst(gameProfile.getProperties().get("textures"), null);
                String string = new String(org.apache.commons.codec.binary.Base64.decodeBase64(property.getValue()), Charsets.UTF_8);
                JsonObject jsonObject = new JsonParser().parse(string).getAsJsonObject();
                String string2 = jsonObject.get("profileId").getAsString().replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5");
                return UUID.fromString(string2);
            }
        } catch (Exception exception) {
            // empty catch block
        }
        return null;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(UUID uUID, UUID uUID2) {
        if (this.llllIIlIIlIIlIIllIIlIIllI.containsKey(uUID)) {
            this.llllIIlIIlIIlIIllIIlIIllI.remove(uUID2);
            for (Cosmetic cosmetic : this.llllIIlIIlIIlIIllIIlIIllI.get(uUID)) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(uUID2, cosmetic);
            }
        }
    }

    public Map<Integer, CosmeticIndexEntry> llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public Map lIIIllIllIIllIlllIlIIlllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public Map<UUID, NameTagLogo> IlllllIlIIIlIIlIIllIIlIll() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public BiMap<String, UUID> llIIlIlIIIllIlIlIlIIlIIll() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public Map<ResourceLocationBridge, ModelCloak> llIIIlllIIlllIllllIlIllIl() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public Map<ResourceLocationBridge, ModelMesh> lllllIllIllIllllIlIllllII() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public boolean lllIIIIIlllIIlIllIIlIIIlI() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.llIIlIlIIIllIlIlIlIIlIIll = bl;
    }

    public HeadCustomLayer lIlIIIIIIlIIIllllIllIIlII() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public CosmeticManagerLayer llIlIIIllIIlIllIllIllllIl() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public LowBodyCustomLayer IllIllIIIllIIIlIlIlIIIIll() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public LayerCapeBridge IIlIllIlllllllIIlIIIllIIl() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public static class NameTagLogo {
        public float lIlIlIlIlIIlIIlIIllIIIIIl;
        public float IlllIIIIIIlllIlIIlllIlIIl;
        public float lIllIlIIIlIIIIIIIlllIlIll;
        public boolean llIlllIIIllllIIlllIllIIIl;

        public NameTagLogo(float f, float f2, float f3, boolean bl) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
            this.IlllIIIIIIlllIlIIlllIlIIl = f2;
            this.lIllIlIIIlIIIIIIIlllIlIll = f3;
            this.llIlllIIIllllIIlllIllIIIl = bl;
        }

        public float lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public float IlllIIIIIIlllIlIIlllIlIIl() {
            return this.IlllIIIIIIlllIlIIlllIlIIl;
        }

        public float lIllIlIIIlIIIIIIIlllIlIll() {
            return this.lIllIlIIIlIIIIIIIlllIlIll;
        }

        public boolean llIlllIIIllllIIlllIllIIIl() {
            return this.llIlllIIIllllIIlllIllIIIl;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
        }

        public void IlllIIIIIIlllIlIIlllIlIIl(float f) {
            this.IlllIIIIIIlllIlIIlllIlIIl = f;
        }

        public void lIllIlIIIlIIIIIIIlllIlIll(float f) {
            this.lIllIlIIIlIIIIIIIlllIlIll = f;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
            this.llIlllIIIllllIIlllIllIIIl = bl;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof NameTagLogo)) {
                return false;
            }
            NameTagLogo nameTagLogo = (NameTagLogo) object;
            if (!nameTagLogo.lIlIlIlIlIIlIIlIIllIIIIIl(this)) {
                return false;
            }
            if (Float.compare(this.lIlIlIlIlIIlIIlIIllIIIIIl(), nameTagLogo.lIlIlIlIlIIlIIlIIllIIIIIl()) != 0) {
                return false;
            }
            if (Float.compare(this.IlllIIIIIIlllIlIIlllIlIIl(), nameTagLogo.IlllIIIIIIlllIlIIlllIlIIl()) != 0) {
                return false;
            }
            if (Float.compare(this.lIllIlIIIlIIIIIIIlllIlIll(), nameTagLogo.lIllIlIIIlIIIIIIIlllIlIll()) != 0) {
                return false;
            }
            return this.llIlllIIIllllIIlllIllIIIl() == nameTagLogo.llIlllIIIllllIIlllIllIIIl();
        }

        public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object object) {
            return object instanceof NameTagLogo;
        }

        public int hashCode() {
            int n = 59;
            int n2 = 1;
            n2 = n2 * 59 + Float.floatToIntBits(this.lIlIlIlIlIIlIIlIIllIIIIIl());
            n2 = n2 * 59 + Float.floatToIntBits(this.IlllIIIIIIlllIlIIlllIlIIl());
            n2 = n2 * 59 + Float.floatToIntBits(this.lIllIlIIIlIIIIIIIlllIlIll());
            n2 = n2 * 59 + (this.llIlllIIIllllIIlllIllIIIl() ? 79 : 97);
            return n2;
        }

        public String toString() {
            return "CosmeticManager.NameTagLogo(r=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", g=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", b=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ", nametagOverride=" + this.llIlllIIIllllIIlllIllIIIl() + ")";
        }
    }
}