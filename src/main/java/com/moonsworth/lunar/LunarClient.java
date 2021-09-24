package com.moonsworth.lunar;

import com.google.common.collect.EvictingQueue;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.ByteStreams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.crash.CrashReportBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.SessionBridge;
import com.moonsworth.lunar.client.account.Account;
import com.moonsworth.lunar.client.blog.DiscordIPC;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.crash.CrashReportSerializer;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.handler.*;
import com.moonsworth.lunar.client.event.type.gui.SwapPackEvent;
import com.moonsworth.lunar.client.event.type.lunar.PostInitEvent;
import com.moonsworth.lunar.client.event.type.world.PreRunTickEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.external.ThirdPartyMod;
import com.moonsworth.lunar.client.feature.type.nick.lIllIlIIIlIIIIIIIlllIlIll;
import com.moonsworth.lunar.client.feature.type.replaymod.IReplayModWrapper;
import com.moonsworth.lunar.client.feature.type.replaymod.ReplayMod;
import com.moonsworth.lunar.client.json.file.ItemLoader;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.nethandler.NetHandler;
import com.moonsworth.lunar.client.notification.NotificationManager;
import com.moonsworth.lunar.client.profile.ProfileLoader;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.*;
import com.moonsworth.lunar.client.server.ServerIntegration;
import com.moonsworth.lunar.client.threading.LunarExecutors;
import com.moonsworth.lunar.client.ui.component.MainMenuRedirectListener;
import com.moonsworth.lunar.client.ui.screen.type.bugreport.BugReportUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuUIWrapper;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.base.CosmeticsListUIComponent;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.CosmeticsUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.base.CosmeticsUIScreenBase;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;
import com.moonsworth.lunar.client.util.AuthUtil;
import com.moonsworth.lunar.client.util.NullUtil;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;
import com.moonsworth.lunar.client.profile.FriendProfile;
import com.moonsworth.lunar.client.websocket.AuthenticatorWebSocket;
import com.moonsworth.lunar.client.websocket.Status;
import com.moonsworth.lunar.client.websocket.WebSocketState;
import com.moonsworth.lunar.client.websocket.packet.FeaturesConfigWebsocketPacket;
import lombok.Getter;
import mchorse.emoticons.Emoticons;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author Decencies
 * @since 18/06/2021 15:46
 */
public class LunarClient {
    public static String lIlIlIlIlIIlIIlIIllIIIIIl;
    public static String PROTOCOL_VERSION = "1";
    @Getter
    public static LunarClient lIlIIIIIIlIIIllllIllIIlII;
    public static String commitAbbr = "6f9eb86";
    public static String commitId = "6f9eb864d0d24cafb109d638a849d13ad67d5979";
    public static String branch = "master";
    public static String OS_NAME = "?";
    public static String OS_ARCH = "?";
    public static String LANG = "en_US";
    public static final EventBus EVENT_BUS = EventBus.getInstance();
    public static final Gson GSON = (new GsonBuilder()).registerTypeAdapter(CrashReportBridge.class, new CrashReportSerializer()).create();
    public static final Random RANDOM = new Random();
    public FriendProfile profile;
    public File gameSettingsDir;
    public final NetHandler netHandler;
    public ServerIntegration serverIntegration;
    public AssetsWebSocket assetsWebsocket;
    public String IllllllllllIlIIIlllIlllll = "";
    public final Set<ItemLoader> loaders;
    public final ModuleManager moduleManager;
    public final SettingsLoader settingsLoader;
    public final RuleFeaturesConfig featuresConfig;
    public final AccountsConfig accountsConfig;
    public final ConsoleLines loader;
    public final StaffModsConfig modsConfig;
    public final EmoteConfig emotesConfig;
    public final WaypointsJson waypointsJson;
    public final FavoriteColorsConfig favoriteColorsConfig;
    public final PlayerHeadManager playerHeadManager;
    public final UUIDFriendSetLoader uuidFriendSetLoader;
    public final CosmeticManager cosmeticManager;
    public final HologramsRegistry holograms;
    public final CustomNameplatesRegistry customNameplatesRegistry;
    public final PinnedServersConfig pinnedServersConfig;
    public final FriendLoader friendLoader;
    public final TitlesSetLoader titlesSetLoader;
    public final ProfileLoader profileLoader;
    public final FeaturesConfig featuresConfig1;
    public final BorderManager borderManager;
    public final MutedUsersConfig mutedUsersConfig;
    public final ProfileMapLoader profileMapLoader;
    public final BlogPostLoader blogPostLoader;
    public final LanguageConfig languageConfig;
    public final ResizeScreenNotificationSetLoader resizeScreenNotificationSetLoader;
    public final NotificationManager notificationManager;
    public final PlayerEventHandler playerEventHandler;
    public final MouseEventHandler mouseEventHandler;
    public Optional<lIllIlIIIlIIIIIIIlllIlIll> optional = Optional.empty();
    public EvictingQueue<String> queue = EvictingQueue.create(4);
    public static final ItemStackBridge emptyItemStack = Bridge.getInstance().initEmptyItemStack();
    public final Map<String, ThirdPartyMod> thirdPartyModHashMap = new HashMap<>();
    public boolean lllIIIIIlllIIlIllIIlIIIlI = true;

    public LunarClient() {
        lIlIIIIIIlIIIllllIllIIlII = this;
        Bridge.getInstance().lateInit();
        Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$setDisplayTitle(getDisplayTitle());
        LunarLogger.info("Starting Lunar client...");
        this.gameSettingsDir = new File(System.getProperty("user.home") + File.separator + ".lunarclient" + File.separator + "settings" + File.separator + "game");
        if (!this.gameSettingsDir.exists()) {
            this.gameSettingsDir.mkdirs();
            File var1 = new File(Ref.getMinecraft().bridge$getMcDataDir() + File.separator + "config" + File.separator + "assets" + File.separator + "lunar");
            File var2 = new File(Ref.getMinecraft().bridge$getMcDataDir() + File.separator + "config" + File.separator + "lunar");
            File var3 = null;
            if (var1.exists() && var2.exists()) {
                if (var1.lastModified() > var2.lastModified()) {
                    var3 = var1;
                } else {
                    var3 = var2;
                }
            } else if (var1.exists()) {
                var3 = var1;
            } else if (var2.exists()) {
                var3 = var2;
            }

            if (var3 != null) {
                try {
                    FileUtils.copyDirectory(var3, this.gameSettingsDir);
                } catch (IOException var5) {
                    var5.printStackTrace();
                }
            }
        }

        this.netHandler = new NetHandler();
        this.serverIntegration = new ServerIntegration();
        this.loaders = ImmutableSet.of(new FontRegistry(), this.resizeScreenNotificationSetLoader = new ResizeScreenNotificationSetLoader(), this.notificationManager = new NotificationManager(), this.languageConfig = new LanguageConfig(), this.profileLoader = new ProfileLoader(), this.moduleManager = new ModuleManager(), this.modsConfig = new StaffModsConfig(), this.settingsLoader = new SettingsLoader(), this.featuresConfig = new RuleFeaturesConfig(), this.accountsConfig = new AccountsConfig(), this.loader = new ConsoleLines(), this.waypointsJson = new WaypointsJson(), this.favoriteColorsConfig = new FavoriteColorsConfig(), this.playerHeadManager = new PlayerHeadManager(), this.uuidFriendSetLoader = new UUIDFriendSetLoader(), this.cosmeticManager = new CosmeticManager(), this.emotesConfig = new EmoteConfig(), this.holograms = new HologramsRegistry(), this.borderManager = new BorderManager(), this.customNameplatesRegistry = new CustomNameplatesRegistry(), this.pinnedServersConfig = new PinnedServersConfig(), this.friendLoader = new FriendLoader(), this.titlesSetLoader = new TitlesSetLoader(), this.featuresConfig1 = new FeaturesConfig(), this.profileMapLoader = new ProfileMapLoader(), this.mutedUsersConfig = new MutedUsersConfig(), this.blogPostLoader = new BlogPostLoader());
        new MainMenuRedirectListener();
        new UIEventHandler();
        new StatusUpdateEventListener();
        this.mouseEventHandler = new MouseEventHandler();
        this.playerEventHandler = new PlayerEventHandler();
        new ConnectionEventHandler();
        new ShaderServerRuleEventHandler();
        new KeybindEventHandler();
        FriendsUIScreen.save();
        new Emoticons();
        this.readThirdPartyMods();
        this.load();
        EventBus.getInstance().call((new PostInitEvent()));
        EventBus.getInstance().call((new SwapPackEvent(Ref.getMinecraft().bridge$getSelectedResourcePack())));
    }

    public void invokeDevEnvironment() {
        try {
            Class var1 = Class.forName("com.moonsworth.lunar.client.dev.DevEnvironment");
            Method var2 = var1.getMethod("init");
            var2.invoke(null);
        } catch (ReflectiveOperationException var3) {
            var3.printStackTrace();
        }

    }

    public void readThirdPartyMods() {
        try {
            InputStream var1 = LunarClient.class.getClassLoader().getResourceAsStream("thirdPartyMods.txt");
            if (var1 != null) {
                String[] var2 = (new String(ByteStreams.toByteArray(var1))).split("\n");
                String[] var3 = var2;
                int var4 = var2.length;

                for (int var5 = 0; var5 < var4; ++var5) {
                    String var6 = var3[var5];
                    if (!var6.trim().isEmpty()) {
                        LunarLogger.info("ThirdParty", "Creating mod " + var6.trim());
                        Class var7 = Class.forName(var6.trim());
                        Object var8 = var7.newInstance();
                        if (var7.isAnnotationPresent(ThirdPartyMod.class)) {
                            ThirdPartyMod var9 = (ThirdPartyMod) var7.getAnnotation(ThirdPartyMod.class);
                            this.thirdPartyModHashMap.put(var9.lIlIlIlIlIIlIIlIIllIIIIIl(), var9);
                            LunarLogger.info("ThirdParty", "Created mod: " + var9.IlllIIIIIIlllIlIIlllIlIIl() + " (" + var9.lIllIlIIIlIIIIIIIlllIlIll() + ")");
                        }
                    }
                }
            } else {
                LunarLogger.error("ThirdParty", "Couldn't load third party mods");
            }
        } catch (Throwable var10) {
            var10.printStackTrace();
        }

    }

    public void load() {
        this.languageConfig.lIlIlIlIlIIlIIlIIllIIIIIl(LANG);
        this.resizeScreenNotificationSetLoader.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getMinecraft(), Ref.getMinecraft().bridge$displayWidth(), Ref.getMinecraft().bridge$displayHeight());

        for (ItemLoader o : this.loaders) {
            try {
                o.b_();
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        System.out.println("Launching");
        (new Thread(new DiscordIPC())).start();
        EventBus.getInstance().register(PreRunTickEvent.class, (var0) -> {
            if (lIlIlIlIlIIlIIlIIllIIIIIl != null) {
                Ref.getMinecraft().bridge$connect(Bridge.getInstance().initServerData(lIlIlIlIlIIlIIlIIllIIIIIl, lIlIlIlIlIIlIIlIIllIIIIIl, false), Bridge.getInstance().initCustomScreen(new MainMenuUIScreen()));
                lIlIlIlIlIIlIIlIIllIIIIIl = null;
            }

            if (Ref.getAssetsWebsocket().isPresent() && (Ref.getAssetsWebsocket().get()).lIlIlIlIlIIlIIlIIllIIIIIl() == WebSocketState.READY) {
                int ticks = TickEvent.lIlIlIlIlIIlIIlIIllIIIIIl / 20;
                if (ticks % 30 == 0) {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new FeaturesConfigWebsocketPacket());
                }

            }
        });
    }

    public void shutdown() {
        ReplayMod var1 = this.moduleManager.lIlIIlIlllIIlIIIlIlIlIllI();
        IReplayModWrapper var2 = var1.lIllllIllIIlIIlIIIlIIIlII();
        if (var2 != null && (!var1.IlllIIIIIIlllIlIIlllIlIIl() || !var2.isRecording())) {
            var2.noRecover();
        }

        for (ItemLoader o : this.loaders) {
            o.lIllIlIIIlIIIIIIIlllIlIll();
        }

        if (this.assetsWebsocket != null && this.assetsWebsocket.isOpen()) {
            this.assetsWebsocket.close();
        }

        LunarExecutors.getLunarExecutor().lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    public void authenticate(Consumer<String> consumer) {
        SessionBridge session = Ref.getMinecraft().bridge$getSession();
        Account account = Ref.getLC().llIlIIIllIIlIllIllIllllIl().IlllllIlIIIlIIlIIllIIlIll();
        if (account == null) {
            LunarLogger.info("Auth", "Failed to establish connection with the auth server, account null.");
            consumer.accept(null);
        } else {
            try {
                (new AuthenticatorWebSocket(ImmutableMap.builder().put("username", session.bridge$getUsername()).put("playerId", AuthUtil.lIllIlIIIlIIIIIIIlllIlIll(session.bridge$getPlayerID())).build(), consumer)).connect();
            } catch (URISyntaxException var5) {
                var5.printStackTrace();
                consumer.accept(null);
            }
        }
    }

    public void loginToAssetsWebsocket() {
        LunarExecutors.getLunarExecutor().execute(() -> {
            try {
                LunarLogger.info("Assets", "Establishing connection");
                if (this.assetsWebsocket != null && this.assetsWebsocket.isOpen()) {
                    this.assetsWebsocket.closeBlocking();
                }
                SessionBridge sessionBridge = Ref.getMinecraft().bridge$getSession();
                Account account = Ref.getLC().llIlIIIllIIlIllIllIllllIl().IlllllIlIIIlIIlIIllIIlIll();
                String string = Ref.getLC().llllIIlIIlIIlIIllIIlIIllI().llIIIIIIIllIIllIlIllIIIIl();
                this.authenticate(string2 -> {
                    if (string2 == null) {
                        return;
                    }
                    try {
                        OS_NAME = System.getProperty("os.name");
                        OS_ARCH = (String) NullUtil.lIlIlIlIlIIlIIlIIllIIIIIl(System.getenv("PROCESSOR_ARCHITECTURE"), System.getProperty("os.arch"));
                        this.assetsWebsocket = new AssetsWebSocket(ImmutableMap.builder().put("accountType", account.getType().name()).put("version", Bridge.getMinecraftVersion().name()).put("gitCommit", LunarClient.llllIlIlIIIllllIIlIllIlII()).put("branch", LunarClient.llIIIllllIIIllIIIIlIlIlll()).put("os", OS_NAME).put("arch", OS_ARCH).put("server", string == null ? "" : string).put("launcherVersion", AssetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl).put("username", sessionBridge.bridge$getUsername()).put("playerId", AuthUtil.lIllIlIIIlIIIIIIIlllIlIll(sessionBridge.bridge$getPlayerID())).put("Authorization", string2).put("protocolVersion", PROTOCOL_VERSION).build());
                    } catch (URISyntaxException uRISyntaxException) {
                        uRISyntaxException.printStackTrace();
                    }
                    this.assetsWebsocket.connect();
                });
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(SessionBridge var1) {
        try {
            boolean var2 = var1 != null && var1.bridge$getProfile() != null && var1.bridge$getProfile().getId() != null;
            boolean var3 = var2 && !var1.bridge$getProfile().getId().equals(Ref.getMinecraft().bridge$getSession().bridge$getProfile().getId());
            boolean var4 = this.assetsWebsocket != null;
            if (var2 && var3) {
                this.cosmeticManager.llIlllIIIllllIIlllIllIIIl(var1.bridge$getProfile().getId());
            }

            this.profile = new FriendProfile(Ref.getMinecraft().bridge$getSession().bridge$getProfile().getId());
            this.profile.setStatus(Status.ONLINE);
            this.profile.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            this.profile.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getMinecraft().bridge$getSession().bridge$getUsername());
            this.profile.IlllIIIIIIlllIlIIlllIlIIl("In-Menus");
            this.loginToAssetsWebsocket();
            Ref.getMinecraft().bridge$submit(() -> {
                boolean var0 = false;
                if (Ref.getMinecraft().bridge$getCurrentScreen() != null && Ref.getMinecraft().bridge$getCurrentScreen().lIlIlIlIlIIlIIlIIllIIIIIl(CosmeticsUIScreen.class)) {
                    Ref.getMinecraft().bridge$displayScreen(null);
                    var0 = true;
                }

                CosmeticsUIScreen.silly();
                if (var0) {
                    Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new CosmeticsUIScreen()));
                }

            });
            Ref.getMinecraft().bridge$submit(() -> {
                boolean var0 = false;
                if (Ref.getMinecraft().bridge$getCurrentScreen() != null && Ref.getMinecraft().bridge$getCurrentScreen().lIlIlIlIlIIlIIlIIllIIIIIl(CosmeticsUIScreen.class)) {
                    Ref.getMinecraft().bridge$displayScreen(null);
                    var0 = true;
                }

                CosmeticsListUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(CosmeticsListUIComponent.llllIIlIIlIIlIIllIIlIIllI());
                if (var0) {
                    if (Ref.getWorld() == null) {
                        Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuUIWrapper(new CosmeticsUIScreenBase(Ref.getMinecraft().bridge$getCurrentScreen()))));
                    } else {
                        Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new CosmeticsUIScreenBase(Ref.getMinecraft().bridge$getCurrentScreen())));
                    }
                }

            });
            this.lllIIIIIlllIIlIllIIlIIIlI = false;
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiScreenBridge var1) {
        if (var1 != null) {
            if (var1 instanceof WrappedGuiScreenBridge) {
                if (!(((WrappedGuiScreenBridge) var1).getCustomScreen() instanceof BugReportUIScreen)) {
                    this.queue.add(((WrappedGuiScreenBridge) var1).getCustomScreen().getClass().getName());
                }
            } else {
                this.queue.add(var1.getClass().getName());
            }
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(String var1) {
        return this.IllllllllllIlIIIlllIlllll.equals("") || var1.equals("") || var1.equals(this.IllllllllllIlIIIlllIlllll);
    }

    public static String getDisplayTitle() {
        return "Lunar Client (" + Bridge.getMinecraftVersion().IlIlIlllllIlIIlIlIlllIlIl() + "-" + IlIlllIlIlllIllIIIIIIlllI() + "/" + llIIIllllIIIllIIIIlIlIlll() + ")";
    }

    public static int llIlllIIIllllIIlllIllIIIl() {
        return 64;
    }

    public FriendProfile llllIIlIIlIIlIIllIIlIIllI() {
        return this.profile;
    }

    public File IlIlIlllllIlIIlIlIlllIlIl() {
        return this.gameSettingsDir;
    }

    public NetHandler llIIIIIIIllIIllIlIllIIIIl() {
        return this.netHandler;
    }

    public ServerIntegration lIIIllIllIIllIlllIlIIlllI() {
        return this.serverIntegration;
    }

    public AssetsWebSocket IlllllIlIIIlIIlIIllIIlIll() {
        return this.assetsWebsocket;
    }

    public String llIIlIlIIIllIlIlIlIIlIIll() {
        return this.IllllllllllIlIIIlllIlllll;
    }

    public Set llIIIlllIIlllIllllIlIllIl() {
        return this.loaders;
    }

    public ModuleManager lllllIllIllIllllIlIllllII() {
        return this.moduleManager;
    }

    public SettingsLoader lllIIIIIlllIIlIllIIlIIIlI() {
        return this.settingsLoader;
    }

    public RuleFeaturesConfig lIlIIIIIIlIIIllllIllIIlII() {
        return this.featuresConfig;
    }

    public AccountsConfig llIlIIIllIIlIllIllIllllIl() {
        return this.accountsConfig;
    }

    public ConsoleLines IllIllIIIllIIIlIlIlIIIIll() {
        return this.loader;
    }

    public StaffModsConfig IIlIllIlllllllIIlIIIllIIl() {
        return this.modsConfig;
    }

    public EmoteConfig lIIlIlllIlIlIIIlllIIlIIII() {
        return this.emotesConfig;
    }

    public WaypointsJson llIllIlIllIlllIllIIIIllII() {
        return this.waypointsJson;
    }

    public FavoriteColorsConfig IllllllllllIlIIIlllIlllll() {
        return this.favoriteColorsConfig;
    }

    public PlayerHeadManager getPlayerHeadManager() {
        return this.playerHeadManager;
    }

    public UUIDFriendSetLoader IllIIIlllIIIlIlllIlIIlIII() {
        return this.uuidFriendSetLoader;
    }

    public CosmeticManager IIlIllIlIIllIIlIlIllllllI() {
        return this.cosmeticManager;
    }

    public HologramsRegistry getHolograms() {
        return this.holograms;
    }

    public CustomNameplatesRegistry llIIIlIllIIIIlIIIlIlIllIl() {
        return this.customNameplatesRegistry;
    }

    public PinnedServersConfig llllIlIllllIlIlIIIllIlIlI() {
        return this.pinnedServersConfig;
    }

    public FriendLoader getFriendRegistry() {
        return this.friendLoader;
    }

    public TitlesSetLoader lIllllIllIIlIIlIIIlIIIlII() {
        return this.titlesSetLoader;
    }

    public ProfileLoader lIlIlIIIIIIllIlIIIIllIIII() {
        return this.profileLoader;
    }

    public FeaturesConfig lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.featuresConfig1;
    }

    public BorderManager IlIIlIIlIIlIIllIIIllIIllI() {
        return this.borderManager;
    }

    public MutedUsersConfig IIlIlIIIllIIllllIllllIlIl() {
        return this.mutedUsersConfig;
    }

    public ProfileMapLoader lllllIIIIlIlllIllIIIlIIlI() {
        return this.profileMapLoader;
    }

    public BlogPostLoader IIlllIllIlIllIllIIllIlIIl() {
        return this.blogPostLoader;
    }

    public LanguageConfig lIlIIlIlllIIlIIIlIlIlIllI() {
        return this.languageConfig;
    }

    public ResizeScreenNotificationSetLoader lIIlllIIIIIlllIIIlIlIlllI() {
        return this.resizeScreenNotificationSetLoader;
    }

    public NotificationManager IIIlIIIIIIllIIIIllIIIIlII() {
        return this.notificationManager;
    }

    public PlayerEventHandler IlIIIlIlIlIlIlIllIIllIIlI() {
        return this.playerEventHandler;
    }

    public MouseEventHandler IlIlIllIIllllIllllllIIlIl() {
        return this.mouseEventHandler;
    }

    public EvictingQueue<String> getLastGuis() {
        return this.queue;
    }

    public boolean llIllIIIIlIIIIIIlllIllIlI() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public static String lIlIIIIIllIIlIIlIIlIlIIlI() {
        return lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public static LunarClient getInstance() {
        return lIlIIIIIIlIIIllllIllIIlII;
    }

    public static String IlIlllIlIlllIllIIIIIIlllI() {
        return commitAbbr;
    }

    public static String llllIlIlIIIllllIIlIllIlII() {
        return commitId;
    }

    public static String llIIIllllIIIllIIIIlIlIlll() {
        return branch;
    }

    public static String IIIIIIIIIIIIIIIllllIIlIIl() {
        return OS_NAME;
    }

    public static String llIIIIllIlIIlIlIIlllIllIl() {
        return OS_ARCH;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(String var1) {
        this.IllllllllllIlIIIlllIlllll = var1;
    }

    public Optional<lIllIlIIIlIIIIIIIlllIlIll> IIIIlIllIllIlIIIIIlIlIlIl() {
        return this.optional;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Optional var1) {
        this.optional = var1;
    }

    public Map<String, ThirdPartyMod> IlIlIlIlIIIlIIlIIlllIllIl() {
        return this.thirdPartyModHashMap;
    }
}

