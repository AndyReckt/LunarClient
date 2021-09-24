package com.moonsworth.lunar.bridge.minecraft.client;

import com.moonsworth.lunar.bridge.minecraft.block.BlockBridge;
import com.moonsworth.lunar.bridge.minecraft.client.audio.SoundHandlerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.FontRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiIngameBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.PlayerControllerMPBridge;
import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.ServerDataBridge;
import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.WorldClientBridge;
import com.moonsworth.lunar.bridge.minecraft.client.network.NetHandlerPlayClientBridge;
import com.moonsworth.lunar.bridge.minecraft.client.particle.EffectRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.EntityRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.ItemRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.RenderGlobalBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderItemBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureMapBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.AbstractResourcePackBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.settings.GameSettingsBridge;
import com.moonsworth.lunar.bridge.minecraft.client.shader.FramebufferBridge;
import com.moonsworth.lunar.bridge.minecraft.util.MovingObjectPositionBridge;
import com.moonsworth.lunar.bridge.minecraft.util.SessionBridge;
import com.moonsworth.lunar.bridge.minecraft.util.TimerBridge;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 14:09
 */
public interface MinecraftBridge {
    EntityPlayerSPBridge bridge$getPlayer();

    void bridge$setPlayer(EntityPlayerSPBridge var1);

    PlayerControllerMPBridge bridge$getPlayerController();

    WorldClientBridge bridge$getWorld();

    Optional<EntityBridge> bridge$getPointedEntity();

    NetHandlerPlayClientBridge bridge$getNetHandler();

    GuiScreenBridge bridge$getCurrentScreen();

    FontRendererBridge bridge$getFontRenderer();

    IResourceManagerBridge bridge$getResourceManager();

    AbstractResourcePackBridge bridge$getMcDefaultResourcePack();

    TextureManagerBridge bridge$getTextureManager();

    SessionBridge bridge$getSession();

    EntityRendererBridge bridge$getEntityRenderer();

    ServerDataBridge bridge$getCurrentServerData();

    RenderItemBridge bridge$getRenderItem();

    SoundHandlerBridge bridge$getSoundHandler();

    void bridge$setSession(SessionBridge var1);

    File bridge$getMcDataDir();

    void bridge$displayScreen(GuiScreenBridge var1);

    int bridge$displayWidth();

    int bridge$displayHeight();

    boolean bridge$unicode();

    int bridge$getGuiScale();

    void bridge$loadWorld(WorldClientBridge var1);

    void bridge$refreshResources();

    void bridge$shutdownMinecraftApplet();

    GameSettingsBridge bridge$getGameSettings();

default Optional lIlIlIlIlIIlIIlIIllIIIIIl() {
        return Optional.empty();
    }

    RenderManagerBridge bridge$getRenderManager();

    long bridge$getSystemTime();

    TimerBridge bridge$getTimer();

    GuiIngameBridge bridge$getGuiIngame();

    int bridge$getDebugFPS();

    FramebufferBridge bridge$getFramebuffer();

    EntityBridge bridge$getRenderViewEntity();

    RenderGlobalBridge bridge$getRenderGlobal();

    boolean bridge$hasInGameFocus();

    TextureMapBridge bridge$getTextureMap();

    boolean bridge$isFullScreen();

    void bridge$toggleFullscreen();

    EffectRendererBridge bridge$getEffectRenderer();

    MovingObjectPositionBridge bridge$getObjectMouseOver();

    void bridge$submit(Runnable var1);

    ItemRendererBridge bridge$getItemRenderer();

    boolean bridge$isGamePaused();

    boolean bridge$isDisplayCreated();

    boolean bridge$isDisplayActive();

    void bridge$setDisplayTitle(String var1);

    boolean bridge$repeatEventsEnabled();

    void bridge$setRepeatEventsEnabled(boolean var1);

    ServerDataBridge bridge$lastServerData();

default Optional<com.moonsworth.lunar.bridge.minecraft.client.renderer.llIIlIlIIIllIlIlIlIIlIIll> IlllIIIIIIlllIlIIlllIlIIl() {
        return Optional.empty();
    }

default List<BlockBridge> bridge$xrayBlocks() {
        return new ArrayList<>();
    }

    AbstractResourcePackBridge bridge$getSelectedResourcePack();

    void bridge$connect(ServerDataBridge var1, GuiScreenBridge var2);

    boolean bridge$isConnectedToRealms();
}