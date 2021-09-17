package com.moonsworth.lunar.bridge.minecraft.client;

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
    public EntityPlayerSPBridge bridge$getPlayer();

    public void bridge$setPlayer(EntityPlayerSPBridge var1);

    public PlayerControllerMPBridge bridge$getPlayerController();

    public WorldClientBridge bridge$getWorld();

    public Optional<EntityBridge> bridge$getPointedEntity();

    public NetHandlerPlayClientBridge bridge$getNetHandler();

    public GuiScreenBridge bridge$getCurrentScreen();

    public FontRendererBridge bridge$getFontRenderer();

    public IResourceManagerBridge bridge$getResourceManager();

    public AbstractResourcePackBridge bridge$getMcDefaultResourcePack();

    public TextureManagerBridge bridge$getTextureManager();

    public SessionBridge bridge$getSession();

    public EntityRendererBridge bridge$getEntityRenderer();

    public ServerDataBridge bridge$getCurrentServerData();

    public RenderItemBridge bridge$getRenderItem();

    public SoundHandlerBridge bridge$getSoundHandler();

    public void bridge$setSession(SessionBridge var1);

    public File bridge$getMcDataDir();

    public void bridge$displayScreen(GuiScreenBridge var1);

    public int bridge$displayWidth();

    public int bridge$displayHeight();

    public boolean bridge$unicode();

    public int bridge$getGuiScale();

    public void bridge$loadWorld(WorldClientBridge var1);

    public void bridge$refreshResources();

    public void bridge$shutdownMinecraftApplet();

    public GameSettingsBridge bridge$getGameSettings();

    default public Optional lIlIlIlIlIIlIIlIIllIIIIIl() {
        return Optional.empty();
    }

    public RenderManagerBridge bridge$getRenderManager();

    public long bridge$getSystemTime();

    public TimerBridge bridge$getTimer();

    public GuiIngameBridge bridge$getGuiIngame();

    public int bridge$getDebugFPS();

    public FramebufferBridge bridge$getFramebuffer();

    public EntityBridge bridge$getRenderViewEntity();

    public RenderGlobalBridge bridge$getRenderGlobal();

    public boolean bridge$hasInGameFocus();

    public TextureMapBridge bridge$getTextureMap();

    public boolean bridge$isFullScreen();

    public void bridge$toggleFullscreen();

    public EffectRendererBridge bridge$getEffectRenderer();

    public MovingObjectPositionBridge bridge$getObjectMouseOver();

    public void bridge$submit(Runnable var1);

    public ItemRendererBridge bridge$getItemRenderer();

    public boolean bridge$isGamePaused();

    public boolean bridge$isDisplayCreated();

    public boolean bridge$isDisplayActive();

    public void bridge$setDisplayTitle(String var1);

    public boolean bridge$repeatEventsEnabled();

    public void bridge$setRepeatEventsEnabled(boolean var1);

    public ServerDataBridge bridge$lastServerData();

    // com.moonsworth.lunar.bridge.minecraft.client.renderer.lIlIlIlIlIIlIIlIIllIIIIIl's optional return
    default public Optional IlllIIIIIIlllIlIIlllIlIIl() {
        return Optional.empty();
    }

    default public List bridge$xrayBlocks() {
        return new ArrayList();
    }

    public AbstractResourcePackBridge bridge$getSelectedResourcePack();

    public void bridge$connect(ServerDataBridge var1, GuiScreenBridge var2);

    public boolean bridge$isConnectedToRealms();
}