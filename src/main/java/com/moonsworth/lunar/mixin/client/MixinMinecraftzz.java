package com.moonsworth.lunar.mixin.client;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.lunarclient.bukkitapi.nethandler.client.obj.ServerRule;
import com.mojang.authlib.properties.PropertyMap;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.audio.SoundHandlerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.FontRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiIngameBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiMainMenuBridge;
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
import com.moonsworth.lunar.bridge.minecraft.world.WorldBridge;
import com.moonsworth.lunar.client.UsedEnum;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.impl.type.keyboard.KeyboardImplementation;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.state.EventState;
import com.moonsworth.lunar.client.event.state.KeyState;
import com.moonsworth.lunar.client.event.type.gui.GuiCloseEvent;
import com.moonsworth.lunar.client.event.type.gui.GuiOpenEvent;
import com.moonsworth.lunar.client.event.type.gui.ResizeWindowEvent;
import com.moonsworth.lunar.client.event.type.input.KeyPressEvent;
import com.moonsworth.lunar.client.event.type.input.MouseActionEvent;
import com.moonsworth.lunar.client.event.type.input.TogglePerspectiveEvent;
import com.moonsworth.lunar.client.event.type.world.*;
import com.moonsworth.lunar.client.feature.type.animations.AnimationVersion;
import com.moonsworth.lunar.client.feature.type.animations.AnimationsMod;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.server.ServerIntegration;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuUIScreen;
import com.moonsworth.lunar.client.util.ScaledResolutionHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.ResourcePackRepository;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.profiler.IPlayerUsage;
import net.minecraft.util.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Optional;

@Mixin(Minecraft.class)
public abstract class MixinMinecraftzz implements MinecraftBridge, IPlayerUsage, IThreadListener {
    @Shadow
    public GuiScreen currentScreen;
    @Shadow
    public EntityPlayerSP thePlayer;
    @Shadow
    public WorldClient theWorld;
    @Shadow
    public FontRenderer fontRendererObj;
    @Shadow
    public IReloadableResourceManager mcResourceManager;
    @Shadow
    public TextureManager renderEngine;
    @Shadow
    public Session session;
    @Shadow
    public File mcDataDir;
    @Shadow
    public PropertyMap profileProperties;
    @Shadow
    public int displayWidth;
    @Shadow
    public int displayHeight;
    @Shadow
    public GameSettings gameSettings;
    @Shadow
    public EntityRenderer entityRenderer;
    @Shadow
    public ServerData currentServerData;
    @Shadow
    public DefaultResourcePack mcDefaultResourcePack;
    @Shadow
    public GuiIngame ingameGUI;
    @Shadow
    public Entity pointedEntity;
    @Shadow
    public RenderItem renderItem;
    @Shadow
    public Timer timer;
    @Shadow
    public MovingObjectPosition objectMouseOver;
    @Shadow
    public Entity renderViewEntity;
    @Shadow
    public RenderGlobal renderGlobal;
    @Shadow
    public boolean inGameHasFocus;
    @Shadow
    public TextureMap textureMapBlocks;
    @Shadow
    public int leftClickCounter;
    @Shadow
    public PlayerControllerMP playerController;
    @Shadow
    public EffectRenderer effectRenderer;
    @Shadow
    public int tempDisplayWidth;
    @Shadow
    public int tempDisplayHeight;
    @Shadow
    public SoundHandler mcSoundHandler;
    @Shadow
    public boolean isGamePaused;
    @Shadow
    public String serverName;
    @Shadow
    public List defaultResourcePacks;
    @Shadow
    public long systemTime;
    @Shadow
    public RenderManager renderManager;


    public boolean mouseEventButtonState;
    public boolean lastMouseEvent;
    public boolean rightMouseClicked;
    public boolean currentlyBorderless;
    public ServerDataBridge lastServerData;

    @Shadow
    public abstract NetHandlerPlayClient getNetHandler();

    @Shadow
    public abstract void displayGuiScreen(GuiScreen var1);

    @Shadow
    public abstract boolean isUnicode();

    @Shadow
    public abstract void refreshResources();

    @Shadow
    public abstract RenderManager getRenderManager();

    @Shadow
    public abstract void shutdownMinecraftApplet();

    @Shadow
    public abstract void loadWorld(WorldClient var1);

    @Shadow
    public abstract Framebuffer getFramebuffer();

    @Shadow
    public abstract boolean isFullScreen();

    @Shadow
    public abstract void toggleFullscreen();

    @Shadow
    public abstract ListenableFuture addScheduledTask(Runnable var1);

    @Shadow
    public abstract ItemRenderer getItemRenderer();

    @Shadow
    public abstract Entity getRenderViewEntity();

    @Shadow
    public abstract ResourcePackRepository getResourcePackRepository();

    @Shadow
    private Framebuffer framebufferMc;

    @Shadow
    private ItemRenderer itemRenderer;

    @Shadow
    private boolean connectedToRealms;

    @Shadow protected abstract void resize(int width, int height);

    @Shadow private static int debugFPS;

    @Inject(method = "run", at = @At("HEAD"))
    public void impl$run(CallbackInfo var1) {
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    @Inject(method = "displayCrashReport", at = @At("HEAD"))
    public void impl$reportCrash(CrashReport var1, CallbackInfo var2) {
    }

    @Overwrite
    public int getLimitFramerate() {
        return 60; // todo
    }

    @Redirect(method = "createDisplay", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/Display;setTitle(Ljava/lang/String;)V"))
    public void impl$onStartGame(String var1) {
        Display.setTitle(LunarClient.getDisplayTitle());
    }

    @Inject(method = "shutdownMinecraftApplet", at = @At("HEAD"))
    public void impl$shutdownMinecraftApplet(CallbackInfo var1) {
        LunarClient.getInstance().shutdown();
    }

    @Inject(method = "displayGuiScreen", at = @At("HEAD"), cancellable = true)
    public void impl$displayGuiScreen(GuiScreen guiScreen, CallbackInfo callbackInfo) {
        if (guiScreen instanceof GuiMainMenuBridge) {
            callbackInfo.cancel();
            if (LunarClient.getInstance() != null) {
                this.bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuUIScreen()));
            }
            return;
        }
        GuiOpenEvent guiOpenEvent = new GuiOpenEvent((GuiScreenBridge) guiScreen);
        EventBus.getInstance().call(guiOpenEvent);
        if (guiOpenEvent.isCancelled()) {
            callbackInfo.cancel();
        }
    }

    public void impl$startGame(CallbackInfo var1) {
//        try {
//            //Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new OptifineImplementation());
//            System.out.println("[Bridge] Using OptiFine wrapper");
//        } catch (ClassNotFoundException classNotFoundException) {
//            System.out.println("[Bridge] Not using OptiFine wrapper");
//        }
    }

    @Inject(method = "startGame", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;ingameGUI:Lnet/minecraft/client/gui/GuiIngame;"))
    public void impl$startGame$afterInGame(CallbackInfo var1) {
        new LunarClient();
    }

    @Inject(method = "startGame", at = @At("TAIL"))
    public void impl$startGame$tail(CallbackInfo var1) {
        System.out.println("LUNARCLIENT_STATUS_STARTED");
        if (this.serverName == null) {
            this.bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuUIScreen()));
        }
    }

    @Redirect(method = "startGame", at = @At(value = "NEW", target = "net/minecraft/client/multiplayer/GuiConnecting"))
    public GuiConnecting impl$init(GuiScreen var1, Minecraft var2, String var3, int var4) {
        return new GuiConnecting(var1, var2, new ServerData(var3, var3, false));
    }

    public void impl$postDisplayGuiScreen(GuiScreen var1, CallbackInfo var2) {
    }

    public GuiScreenBridge bridge$getCurrentScreen() {
        return (GuiScreenBridge) currentScreen;
    }

    public EntityPlayerSPBridge bridge$getPlayer() {
        return (EntityPlayerSPBridge) thePlayer;
    }

    public void bridge$setPlayer(EntityPlayerSPBridge var1) {
    }

    public PlayerControllerMPBridge bridge$getPlayerController() {
        return (PlayerControllerMPBridge) playerController;
    }

    public WorldClientBridge bridge$getWorld() {
        return (WorldClientBridge) theWorld;
    }

    public FontRendererBridge bridge$getFontRenderer() {
        return (FontRendererBridge) fontRendererObj;
    }

    public IResourceManagerBridge bridge$getResourceManager() {
        return (IResourceManagerBridge) mcResourceManager;
    }

    public AbstractResourcePackBridge bridge$getMcDefaultResourcePack() {
        return (AbstractResourcePackBridge) mcDefaultResourcePack;
    }

    public TextureManagerBridge bridge$getTextureManager() {
        return (TextureManagerBridge) renderEngine;
    }

    public SessionBridge bridge$getSession() {
        return (SessionBridge) session;
    }

    public EntityRendererBridge bridge$getEntityRenderer() {
        return (EntityRendererBridge) entityRenderer;
    }

    public ServerDataBridge bridge$getCurrentServerData() {
        return (ServerDataBridge) currentServerData;
    }

    public RenderItemBridge bridge$getRenderItem() {
        return (RenderItemBridge) renderItem;
    }

    public SoundHandlerBridge bridge$getSoundHandler() {
        return (SoundHandlerBridge) mcSoundHandler;
    }

    public void bridge$setSession(SessionBridge var1) {
        this.session = (Session) var1;
    }

    public File bridge$getMcDataDir() {
        return mcDataDir;
    }

    public void bridge$displayScreen(GuiScreenBridge var1) {
        displayGuiScreen((GuiScreen) var1);
    }

    public int bridge$displayWidth() {
        return displayWidth;
    }

    public int bridge$displayHeight() {
        return displayHeight;
    }

    public boolean bridge$unicode() {
        return isUnicode();
    }

    public int bridge$getGuiScale() {
        return gameSettings.guiScale;
    }

    public void bridge$loadWorld(WorldClientBridge var1) {
        loadWorld((WorldClient) var1);
    }

    public void bridge$shutdownMinecraftApplet() {
        shutdownMinecraftApplet();
    }

    public NetHandlerPlayClientBridge bridge$getNetHandler() {
        return (NetHandlerPlayClientBridge) getNetHandler();
    }

    public void bridge$refreshResources() {
        refreshResources();
    }

    public RenderManagerBridge bridge$getRenderManager() {
        return (RenderManagerBridge) renderManager;
    }

    public Optional bridge$getPointedEntity() {
        return Optional.ofNullable(pointedEntity);
    }

    public long bridge$getSystemTime() {
        return Minecraft.getSystemTime();
    }

    public GameSettingsBridge bridge$getGameSettings() {
        return (GameSettingsBridge) gameSettings;
    }

    @Inject(method = "runGameLoop", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/EntityRenderer;updateCameraAndRender(FJ)V", shift = At.Shift.BEFORE))
    public void impl$onRenderTick$PRE(CallbackInfo var1) {
        EventBus.getInstance().call(new RenderTickEvent(EventState.PRE, this.timer.renderPartialTicks));
    }

    @Inject(method = "runGameLoop", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/EntityRenderer;updateCameraAndRender(FJ)V", shift = At.Shift.AFTER))
    public void impl$onRenderTick$POST(CallbackInfo var1) {
        EventBus.getInstance().call(new RenderTickEvent(EventState.POST, this.timer.renderPartialTicks));
    }

    @Inject(method = "runTick", at = @At("HEAD"))
    public void impl$preRunTick(CallbackInfo var1) {
        EventBus.getInstance().call(new TickEvent());
        if (TickEvent.lIlIlIlIlIIlIIlIIllIIIIIl != 0 && TickEvent.lIlIlIlIlIIlIIlIIllIIIIIl % 20 == 0) {
            EventBus.getInstance().call(new PreRunTickEvent());
        }
        ++TickEvent.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    @Redirect(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/EntityRenderer;loadEntityShader(Lnet/minecraft/entity/Entity;)V"))
    public void impl$runTick$loadEntityShader(EntityRenderer var1, Entity var2) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lIlIlIIIIIIllIlIIIIllIIII().IlllIIIIIIlllIlIIlllIlIIl()) {
            return;
        }
        entityRenderer.loadEntityShader(var2);
    }

    @Inject(method = "runTick", at = @At("RETURN"))
    public void impl$postRunTick(CallbackInfo var1) {
        EventBus.getInstance().call(new PostRunTickEvent());
    }

    @Redirect(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/EntityPlayerSP;dropOneItem(Z)Lnet/minecraft/entity/item/EntityItem;"))
    public EntityItem impl$onRunTickDropItem(EntityPlayerSP var1, boolean var2) {
        return var1.dropOneItem(Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().getDropStackBind().IlllIIIIIIlllIlIIlllIlIIl());
    }

    public GuiIngameBridge bridge$getGuiIngame() {
        return (GuiIngameBridge) ingameGUI;
    }

    @Inject(method = "dispatchKeypresses", at = @At("HEAD"), cancellable = true)
    public void impl$dispatchKeyPress(CallbackInfo callbackInfo) {
        int n = Keyboard.getEventKey();
        boolean bl = Keyboard.getEventKeyState();
        KeyPressEvent keyPressEvent = new KeyPressEvent(KeyboardImplementation.lIlIlIlIlIIlIIlIIllIIIIIl(n), bl ? KeyState.DOWN : KeyState.UP);
        EventBus.getInstance().call(keyPressEvent);
        if (keyPressEvent.isCancelled()) {
            callbackInfo.cancel();
        }
    }

    public int bridge$getDebugFPS() {
        return debugFPS;
    }

    public void impl$onRunTick(CallbackInfo var1) {
        if (Ref.getAssetsWebsocket().isPresent() && (Ref.getAssetsWebsocket().get()).isOpen() && LunarClient.getInstance().IlllllIlIIIlIIlIIllIIlIll().llIlllIIIllllIIlllIllIIIl()) {
            int n = LunarClient.RANDOM.nextInt(4);
//            switch (n) {
//                case 0: {
//                    S2BPacketChangeGameState s2BPacketChangeGameState = null;
//                    s2BPacketChangeGameState.func_149137_d();
//                    break;
//                }
//                case 1: {
//                    String[] stringArray = new String[]{};
//                    String string = stringArray[1];
//                    break;
//                }
//                case 2: {
//                    ArrayList arrayList = new ArrayList();
//                    arrayList.get(-97);
//                    break;
//                }
//                case 3: {
//                    List list = null;
//                    list.get(0);
//                }
//            }
            throw new RuntimeException("Manual crash.");
        }
        ((FontRendererBridge)this.fontRendererObj).tick();
    }

    @Inject(method = "runTick", at = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Mouse;getEventButton()I"))
    public void impl$postRunTick$eventMouseAction(CallbackInfo var1) {
        this.mouseEventButtonState = Mouse.getEventButtonState();
        MouseActionEvent mouseActionEvent = new MouseActionEvent(Mouse.getEventButton(), this.mouseEventButtonState ? KeyState.DOWN : KeyState.UP);
        EventBus.getInstance().call(mouseActionEvent);
        if (mouseActionEvent.isCancelled()) {
            this.mouseEventButtonState = false;
        }
        this.lastMouseEvent = mouseActionEvent.isCancelled();
    }

    @Redirect(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/settings/KeyBinding;isPressed()Z"))
    public boolean impl$onTogglePerspective(KeyBinding keyBinding) {
        if (keyBinding == this.gameSettings.keyBindTogglePerspective) {
            boolean bl = keyBinding.isPressed();
            if (bl) {
                TogglePerspectiveEvent togglePerspectiveEvent = new TogglePerspectiveEvent(this.gameSettings.thirdPersonView);
                EventBus.getInstance().call(togglePerspectiveEvent);
                if (togglePerspectiveEvent.isCancelled()) {
                    return false;
                }
            }
            return bl;
        }
        return keyBinding.isPressed();
    }

    @Redirect(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/settings/KeyBinding;setKeyBindState(IZ)V"))
    public void impl$onKeyBindingState(int var1, boolean var2) {
        if (!this.lastMouseEvent) {
            KeyBinding.setKeyBindState(var1, var2);
        }
    }

    @Redirect(method = "runTick", at = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Mouse;getEventButtonState()Z"))
    public boolean impl$getEventButtonState() {
        return this.mouseEventButtonState;
    }

    public void impl$clickMouse$eventPreAttackEntityClient(PlayerControllerMP var1, EntityPlayer var2, Entity var3) {
    }

    @Inject(method = "clickMouse", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/PlayerControllerMP;isNotCreative()Z"), cancellable = true)
    public void impl$clickMouseLegacyCombat(CallbackInfo var1) {
        if (this.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.MISS && ((Boolean) ServerIntegration.lIlIlIlIlIIlIIlIIllIIIIIl(ServerRule.LEGACY_COMBAT)).booleanValue()) {
            var1.cancel();
        }
    }

    @Inject(method = "loadWorld(Lnet/minecraft/client/multiplayer/WorldClient;Ljava/lang/String;)V", at = @At("HEAD"))
    public void impl$callWorldLoadEvent(WorldClient var1, String var2, CallbackInfo var3) {
        WorldLoadEvent worldLoadEvent = new WorldLoadEvent((WorldBridge) var1);
        EventBus.getInstance().call(worldLoadEvent);
    }

    @Redirect(method = "loadWorld(Lnet/minecraft/client/multiplayer/WorldClient;Ljava/lang/String;)V", at = @At(value = "INVOKE", target = "Ljava/lang/System;gc()V"))
    public void impl$cancelSystemGC() {
    }

    @Inject(method = "sendClickBlockToController", at = @At("HEAD"), cancellable = true)
    public void impl$sendClickBlockToController(boolean bl, CallbackInfo callbackInfo) {
        boolean bl2 = Ref.getLC().lllllIllIllIllllIlIllllII().IlllllIlIIIlIIlIIllIIlIll().lllllIIIIlIlllIllIIIlIIlI().isLegacy();
        EntityPlayerSP entityPlayerSP = this.thePlayer;
        if (bl2) {
            if (!bl) {
                this.leftClickCounter = 0;
            }
            if (this.leftClickCounter <= 0 && !entityPlayerSP.isUsingItem()) {
                if (bl && this.objectMouseOver != null && this.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                    BlockPos blockPos = this.objectMouseOver.getBlockPos();
                    Block block = this.theWorld.getBlockState(blockPos).getBlock();
                    if (block.getMaterial() != Material.air) {
                        boolean bl3;
                        ItemStack itemStack = this.thePlayer.inventory.getCurrentItem();
                        boolean bl4 = bl3 = itemStack != null && (itemStack.item instanceof ItemFood || itemStack.item instanceof ItemPotion || itemStack.item instanceof ItemSword || itemStack.item instanceof ItemBow || itemStack.item instanceof ItemBucket);
                        if (this.rightMouseClicked && bl3) {
                            this.rightMouseClicked = false;
                            this.impl$oneSevenSwing();
                        } else if (this.playerController.onPlayerDamageBlock(blockPos, this.objectMouseOver.sideHit)) {
                            this.effectRenderer.addBlockHitEffects(blockPos, this.objectMouseOver.sideHit);
                            this.thePlayer.swingItem();
                        }
                    }
                } else {
                    this.playerController.resetBlockRemoving();
                }
            } else if (bl && entityPlayerSP.isUsingItem()) {
                BlockPos blockPos;
                this.rightMouseClicked = false;
                if (this.objectMouseOver != null && this.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && this.theWorld.getBlockState(blockPos = this.objectMouseOver.getBlockPos()).getBlock().getMaterial() != Material.air) {
                    this.impl$oneSevenSwing();
                }
            }
            callbackInfo.cancel();
        }
    }

    // sendClickBlockToController
    public void impl$oneSevenSwing() {
        if (this.playerController.isHittingBlock) {
            this.thePlayer.swingItem();
            this.playerController.resetBlockRemoving();
            this.playerController.blockHitDelay = 5;
            this.playerController.currentItemHittingBlock = null;
        } else {
            this.bridge$getPlayer().bridge$swingItem0();
        }
    }

    @Redirect(method = "rightClickMouse", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/PlayerControllerMP;getIsHittingBlock()Z"))
    public boolean impl$getIsHittingBlock(PlayerControllerMP playerControllerMP) {
        BlockPos blockPos;
        Block block;
        AnimationsMod animationsMod = LunarClient.getInstance().lllllIllIllIllllIlIllllII().IlllllIlIIIlIIlIIllIIlIll();
        if (animationsMod.IlllIIIIIIlllIlIIlllIlIIl() && animationsMod.lllllIIIIlIlllIllIIIlIIlI().llIlllIIIllllIIlllIllIIIl() == AnimationVersion.VERSION_1_7 && this.objectMouseOver != null && this.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && (block = this.theWorld.getBlockState(blockPos = this.objectMouseOver.getBlockPos()).getBlock()).getMaterial() != Material.air) {
            this.rightMouseClicked = true;
            return false;
        }
        return playerControllerMP.isHittingBlock;
    }

    public EntityBridge bridge$getRenderViewEntity() {
        return (EntityBridge) renderViewEntity;
    }

    public RenderGlobalBridge bridge$getRenderGlobal() {
        return (RenderGlobalBridge) renderGlobal;
    }

    public FramebufferBridge bridge$getFramebuffer() {
        return (FramebufferBridge) framebufferMc;
    }

    public boolean bridge$hasInGameFocus() {
        return inGameHasFocus;
    }

    public TextureMapBridge bridge$getTextureMap() {
        return (TextureMapBridge) textureMapBlocks;
    }

    public boolean bridge$isFullScreen() {
        return isFullScreen();
    }

    public void bridge$toggleFullscreen() {
        toggleFullscreen();
    }

    public EffectRendererBridge bridge$getEffectRenderer() {
        return (EffectRendererBridge) effectRenderer;
    }

    public TimerBridge bridge$getTimer() {
        return (TimerBridge) timer;
    }

    public void startBorderlessFullscreen() throws LWJGLException {
        this.currentlyBorderless = true;
        System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle rectangle = graphicsEnvironment.getDefaultScreenDevice().getDefaultConfiguration().getBounds();
        this.displayWidth = (int)rectangle.getWidth();
        this.displayHeight = (int)rectangle.getHeight();
        Display.setLocation(rectangle.x, rectangle.y);
        Display.setResizable(false);
        Display.setDisplayMode(new DisplayMode(this.displayWidth, this.displayHeight));
    }

    @Redirect(method = "toggleFullscreen", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/Display;setFullscreen(Z)V"))
    public void impl$setFullscreen(boolean bl) throws LWJGLException {
        if (this.currentScreen == null) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(new ScaledResolutionHelper(Ref.getMinecraft()));
        }
        if (bl) {
            if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl()) {
                this.startBorderlessFullscreen();
            } else {
                this.currentlyBorderless = false;
            }
        } else {
            if (this.currentlyBorderless) {
                System.setProperty("org.lwjgl.opengl.Window.undecorated", "false");
                Display.setResizable(true);
                Display.setLocation(Display.getWidth() / 4, Display.getHeight() / 4);
            }
            this.currentlyBorderless = false;
            Display.setDisplayMode(new DisplayMode(this.displayWidth, this.displayHeight));
        }
        if (this.currentlyBorderless) {
            Display.setFullscreen(false);
        } else {
            Display.setFullscreen(bl);
        }
    }

    public MovingObjectPositionBridge bridge$getObjectMouseOver() {
        return (MovingObjectPositionBridge) objectMouseOver;
    }

    @Inject(method = "refreshResources", at = @At("RETURN"))
    public void impl$onRefreshResources(CallbackInfo var1) {
        if (this.fontRendererObj != null) {
            ((FontRendererBridge)this.fontRendererObj).clearCaches();
        }
    }

    public void bridge$submit(Runnable var1) {
        addScheduledTask(var1);
    }

    @Inject(method = "displayGuiScreen", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiScreen;onGuiClosed()V"))
    public void impl$event$onGuiClosed(GuiScreen var1, CallbackInfo var2) {
        EventBus.getInstance().call(new GuiCloseEvent((GuiScreenBridge) this.currentScreen, (GuiScreenBridge)  var1));
    }

    public ItemRendererBridge bridge$getItemRenderer() {
        return (ItemRendererBridge) itemRenderer;
    }

    public boolean bridge$isGamePaused() {
        return isGamePaused;
    }

    public boolean bridge$isDisplayActive() {
        return Display.isActive();
    }

    public boolean bridge$isDisplayCreated() {
        return Display.isCreated();
    }

    public void bridge$setDisplayTitle(String var1) {
        Display.setTitle(var1);
    }

    @Redirect(method = "rightClickMouse", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getMaterial()Lnet/minecraft/block/material/Material;"))
    public Material impl$rightClickMouse$border(Block var1) {
        return ((MovingObjectPositionBridge)this.objectMouseOver).bridge$isBorder() ? Material.rock : var1.getMaterial();
    }

    @Redirect(method = "runTick", at = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Keyboard;isKeyDown(I)Z"))
    public boolean impl$isKeyDown(int n) {
        int n2;
        int n3 = n2 = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
        if (n == 61) {
            switch (n2) {
            case 30: {
                if (!Ref.lIlIIIIIIlIIIllllIllIIlII() || Ref.isConnectedToWebSocket() && Ref.lIlIlIlIlIIlIIlIIllIIIIIl(UsedEnum.F3_KEYS)) break;
                return false;
            }
            }
        }
        return Keyboard.isKeyDown(n);
    }

    @Inject(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/settings/KeyBinding;onTick(I)V", shift = At.Shift.AFTER))
    public void impl$fixTogglePerspectiveMouse(CallbackInfo var1) {
        if (this.currentScreen == null && this.inGameHasFocus && this.gameSettings.keyBindTogglePerspective.isKeyDown()) {
            ++this.gameSettings.thirdPersonView;
            if (this.gameSettings.thirdPersonView > 2) {
                this.gameSettings.thirdPersonView = 0;
            }
            if (this.gameSettings.thirdPersonView == 0) {
                this.entityRenderer.loadEntityShader(this.getRenderViewEntity());
            } else if (this.gameSettings.thirdPersonView == 1) {
                this.entityRenderer.loadEntityShader(null);
            }
            this.renderGlobal.makeEntityOutlineShader();
        }
    }

    @Inject(method = "setServerData", at = @At("HEAD"))
    public void impl$setServerData(ServerData var1, CallbackInfo var2) {
        this.lastServerData = (ServerDataBridge) this.currentServerData;
    }

    public boolean bridge$repeatEventsEnabled() {
        return Keyboard.areRepeatEventsEnabled();
    }

    public void bridge$setRepeatEventsEnabled(boolean var1) {
        Keyboard.enableRepeatEvents(var1);
    }

    public ServerDataBridge bridge$lastServerData() {
        return lastServerData;
    }

    @Inject(method = "resize", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;loadingScreen:Lnet/minecraft/client/LoadingScreenRenderer;", shift = At.Shift.BEFORE))
    public void impl$onResize(int var1, int var2, CallbackInfo var3) {
        ScaledResolution scaledResolution = new ScaledResolution((Minecraft) (MinecraftBridge) this);
        EventBus.getInstance().call(new ResizeWindowEvent(scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight()));
    }

    @Inject(method = "setIngameFocus", at = @At("HEAD"))
    public void lunar$updateKeybindState(CallbackInfo var1) {
        boolean bl = LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IlIIIlIlIlIlIlIllIIllIIlI().llIlllIIIllllIIlllIllIIIl();
        if (bl && Display.isActive() && !this.inGameHasFocus) {
            for (KeyBinding keyBinding : KeyBinding.keybindArray) {
                boolean bl2 = keyBinding.keyCode > 0 && keyBinding.keyCode < 256 && Keyboard.isKeyDown(keyBinding.keyCode);
                KeyBinding.setKeyBindState(keyBinding.keyCode, bl2);
            }
        }
    }

    public List bridge$xrayBlocks() {
        return ImmutableList.of();
    }

    public AbstractResourcePackBridge bridge$getSelectedResourcePack() {
        return (AbstractResourcePackBridge)
               this.getResourcePackRepository().getRepositoryEntries().stream()
               .map(entry -> entry.reResourcePack).findFirst().orElseGet(() -> (IResourcePack) (this.bridge$getMcDefaultResourcePack()));
    }

    public void bridge$connect(ServerDataBridge var1, GuiScreenBridge var2) {
        this.displayGuiScreen(new GuiConnecting((GuiScreen) var1, (Minecraft) (MinecraftBridge) this, (ServerData) var2));
    }

    public boolean bridge$isConnectedToRealms() {
        return connectedToRealms;
    }

}