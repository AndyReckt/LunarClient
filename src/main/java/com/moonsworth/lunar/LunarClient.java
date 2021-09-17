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
import com.moonsworth.lunar.client.feature.type.replaymod.IReplayModWrapper;
import com.moonsworth.lunar.client.feature.type.replaymod.ReplayMod;
import com.moonsworth.lunar.client.json.file.ItemLoader;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.nethandler.NetHandler;
import com.moonsworth.lunar.client.notification.NotificationManager;
import com.moonsworth.lunar.client.profile.Profile;
import com.moonsworth.lunar.client.profile.ProfileLoader;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.*;
import com.moonsworth.lunar.client.server.ServerIntegration;
import com.moonsworth.lunar.client.threading.LunarExecutors;
import com.moonsworth.lunar.client.ui.component.MainMenuRedirectListener;
import com.moonsworth.lunar.client.ui.screen.type.bugreport.BugReportUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuUIWrapper;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.CosmeticsListUIComponent;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.CosmeticsUIScreenBase;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;
import com.moonsworth.lunar.client.util.AuthUtil;
import com.moonsworth.lunar.client.util.NullUtil;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;
import com.moonsworth.lunar.client.websocket.FriendProfile;
import com.moonsworth.lunar.client.websocket.Status;
import com.moonsworth.lunar.client.websocket.WebSocketState;
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
    public static final EventBus IlllllIlIIIlIIlIIllIIlIll = EventBus.lIlIlIlIlIIlIIlIIllIIIIIl();
    public static final Gson llIIlIlIIIllIlIlIlIIlIIll = (new GsonBuilder()).registerTypeAdapter(CrashReportBridge.class, new CrashReportSerializer()).create();
    public static final Random random = new Random();
    public FriendProfile llIlIIIllIIlIllIllIllllIl;
    public File gameSettingsDir;
    public final NetHandler IIlIllIlllllllIIlIIIllIIl;
    public ServerIntegration lIIlIlllIlIlIIIlllIIlIIII;
    public AssetsWebSocket llIllIlIllIlllIllIIIIllII;
    public String IllllllllllIlIIIlllIlllll = "";
    public final Set lllllIllIlIIlIIlIIIlllIlI;
    public final ModuleManager IllIIIlllIIIlIlllIlIIlIII;
    public final SettingsLoader IIlIllIlIIllIIlIlIllllllI;
    public final RuleFeaturesConfig lIIIlllIIIIllllIlIIIlIIll;
    public final AccountsConfig llIIIlIllIIIIlIIIlIlIllIl;
    public final EmptySetLoader llllIlIllllIlIlIIIllIlIlI;
    public final StaffModsConfig IlIllIIlIIlIIIllIllllIIll;
    public final EmoteConfig lIllllIllIIlIIlIIIlIIIlII;
    public final WaypointsJson lIlIlIIIIIIllIlIIIIllIIII;
    public final FavoriteColorsConfig lIIlIIIIIIlIIlIIllIlIIlII;
    public final PlayerHeadManager IlIIlIIlIIlIIllIIIllIIllI;
    public final UUIDFriendSetLoader IIlIlIIIllIIllllIllllIlIl;
    public final CosmeticManager lllllIIIIlIlllIllIIIlIIlI;
    public final EmptyMapLoader IIlllIllIlIllIllIIllIlIIl;
    public final ConcurrentMapLoaderWrapper lIlIIlIlllIIlIIIlIlIlIllI;
    public final PinnedServersConfig lIIlllIIIIIlllIIIlIlIlllI;
    public final FriendLoader IIIlIIIIIIllIIIIllIIIIlII;
    public final TitlesSetLoader IlIIIlIlIlIlIlIllIIllIIlI;
    public final ProfileLoader IlIlIllIIllllIllllllIIlIl;
    public final FeaturesConfig lIIlIIlllIIIIlIlllIIIIlll;
    public final BorderManager llIllIIIIlIIIIIIlllIllIlI;
    public final MutedUsersConfig lIlIIIIIllIIlIIlIIlIlIIlI;
    public final ProfileMapLoader IIllIlIllIlIllIllIllIllII;
    public final BlogPostLoader IlIlllIlIlllIllIIIIIIlllI;
    public final LanguageConfig llllIlIlIIIllllIIlIllIlII;
    public final ResizeScreenNotificationSetLoader llIIIllllIIIllIIIIlIlIlll;
    public final NotificationManager IIIIIIIIIIIIIIIllllIIlIIl;
    public final PlayerEventHandler llIIIIllIlIIlIlIIlllIllIl;
    public final MouseEventHandler IIIIlIllIllIlIIIIIlIlIlIl;
    public Optional optional = Optional.empty();
    public EvictingQueue queue = EvictingQueue.create(4);
    public static final ItemStackBridge emptyItemStack = Bridge.llIlllIIIllllIIlllIllIIIl().initEmptyItemStack();
    public final Map<String, ThirdPartyMod> lllllIlIllIlIlllIIIlIIlIl = new HashMap();
    public boolean lllIIIIIlllIIlIllIIlIIIlI = true;

    public LunarClient() {
        lIlIIIIIIlIIIllllIllIIlII = this;
        Bridge.llIlllIIIllllIIlllIllIIIl().lateInit();
        Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$setDisplayTitle(getDisplayTitle());
        LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Starting Lunar client...");
        this.gameSettingsDir = new File(System.getProperty("user.home") + File.separator + ".lunarclient" + File.separator + "settings" + File.separator + "game");
        if (!this.gameSettingsDir.exists()) {
            this.gameSettingsDir.mkdirs();
            File var1 = new File(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getMcDataDir() + File.separator + "config" + File.separator + "assets" + File.separator + "lunar");
            File var2 = new File(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getMcDataDir() + File.separator + "config" + File.separator + "lunar");
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

        this.IIlIllIlllllllIIlIIIllIIl = new NetHandler();
        this.lIIlIlllIlIlIIIlllIIlIIII = new ServerIntegration();
        this.lllllIllIlIIlIIlIIIlllIlI = ImmutableSet.of(new FontRegistry(), this.llIIIllllIIIllIIIIlIlIlll = new ResizeScreenNotificationSetLoader(), this.IIIIIIIIIIIIIIIllllIIlIIl = new NotificationManager(), this.llllIlIlIIIllllIIlIllIlII = new LanguageConfig(), this.IlIlIllIIllllIllllllIIlIl = new ProfileLoader(), this.IllIIIlllIIIlIlllIlIIlIII = new ModuleManager(), new ItemLoader[]{this.IlIllIIlIIlIIIllIllllIIll = new StaffModsConfig(), this.IIlIllIlIIllIIlIlIllllllI = new SettingsLoader(), this.lIIIlllIIIIllllIlIIIlIIll = new RuleFeaturesConfig(), this.llIIIlIllIIIIlIIIlIlIllIl = new AccountsConfig(), this.llllIlIllllIlIlIIIllIlIlI = new EmptySetLoader(), this.lIlIlIIIIIIllIlIIIIllIIII = new WaypointsJson(), this.lIIlIIIIIIlIIlIIllIlIIlII = new FavoriteColorsConfig(), this.IlIIlIIlIIlIIllIIIllIIllI = new PlayerHeadManager(), this.IIlIlIIIllIIllllIllllIlIl = new UUIDFriendSetLoader(), this.lllllIIIIlIlllIllIIIlIIlI = new CosmeticManager(), this.lIllllIllIIlIIlIIIlIIIlII = new EmoteConfig(), this.IIlllIllIlIllIllIIllIlIIl = new EmptyMapLoader(), this.llIllIIIIlIIIIIIlllIllIlI = new BorderManager(), this.lIlIIlIlllIIlIIIlIlIlIllI = new ConcurrentMapLoaderWrapper(), this.lIIlllIIIIIlllIIIlIlIlllI = new PinnedServersConfig(), this.IIIlIIIIIIllIIIIllIIIIlII = new FriendLoader(), this.IlIIIlIlIlIlIlIllIIllIIlI = new TitlesSetLoader(), this.lIIlIIlllIIIIlIlllIIIIlll = new FeaturesConfig(), this.IIllIlIllIlIllIllIllIllII = new ProfileMapLoader(), this.lIlIIIIIllIIlIIlIIlIlIIlI = new MutedUsersConfig(), this.IlIlllIlIlllIllIIIIIIlllI = new BlogPostLoader()});
        new MainMenuRedirectListener();
        new UIEventHandler();
        new StatusUpdateEventListener();
        this.IIIIlIllIllIlIIIIIlIlIlIl = new MouseEventHandler();
        this.llIIIIllIlIIlIlIIlllIllIl = new PlayerEventHandler();
        new ConnectionEventHandler();
        new ShaderServerRuleEventHandler();
        new KeybindEventHandler();
        FriendsUIScreen.save();
        new Emoticons();
        this.readThirdPartyMods();
        this.load();
        EventBus.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl((new PostInitEvent()));
        EventBus.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl((new SwapPackEvent(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSelectedResourcePack())));
    }

    public void invokeDevEnvironment() {
        try {
            Class var1 = Class.forName("com.moonsworth.lunar.client.dev.DevEnvironment");
            Method var2 = var1.getMethod("init");
            var2.invoke((Object)null);
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

                for(int var5 = 0; var5 < var4; ++var5) {
                    String var6 = var3[var5];
                    if (!var6.trim().isEmpty()) {
                        LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("ThirdParty", "Creating mod " + var6.trim());
                        Class var7 = Class.forName(var6.trim());
                        Object var8 = var7.newInstance();
                        if (var7.isAnnotationPresent(ThirdPartyMod.class)) {
                            ThirdPartyMod var9 = (ThirdPartyMod)var7.getAnnotation(ThirdPartyMod.class);
                            this.lllllIlIllIlIlllIIIlIIlIl.put(var9.lIlIlIlIlIIlIIlIIllIIIIIl(), var9);
                            LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("ThirdParty", "Created mod: " + var9.IlllIIIIIIlllIlIIlllIlIIl() + " (" + var9.lIllIlIIIlIIIIIIIlllIlIll() + ")");
                        }
                    }
                }
            } else {
                LunarLogger.llIlllIIIllllIIlllIllIIIl("ThirdParty", "Couldn't load third party mods");
            }
        } catch (Throwable var10) {
            var10.printStackTrace();
        }

    }

    public void load() {
        this.llllIlIlIIIllllIIlIllIlII.lIlIlIlIlIIlIIlIIllIIIIIl(LANG);
        this.llIIIllllIIIllIIIIlIlIlll.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.lIlIlIlIlIIlIIlIIllIIIIIl(), Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayWidth(), Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayHeight());
        Iterator var1 = this.lllllIllIlIIlIIlIIIlllIlI.iterator();

        while(var1.hasNext()) {
            ItemLoader var2 = (ItemLoader)var1.next();

            try {
                var2.b_();
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        System.out.println("Launching");
        (new Thread(new DiscordIPC())).start();
        EventBus.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(PreRunTickEvent.class, (var0) -> {
            if (lIlIlIlIlIIlIIlIIllIIIIIl != null) {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$connect(Bridge.llIlllIIIllllIIlllIllIIIl().initServerData(lIlIlIlIlIIlIIlIIllIIIIIl, lIlIlIlIlIIlIIlIIllIIIIIl, false), Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIScreen()));
                lIlIlIlIlIIlIIlIIllIIIIIl = null;
            }

            if (Ref.getAssetsWebsocket().isPresent() && ((AssetsWebSocket)Ref.getAssetsWebsocket().get()).lIlIlIlIlIIlIIlIIllIIIIIl() == WebSocketState.READY) {
                int ticks = TickEvent.lIlIlIlIlIIlIIlIIllIIIIIl / 20;
                if (ticks % 30 == 0) {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl((AbstractWebSocketPacket)(new FeaturesConfigWebsocketPacket()));
                }

            }
        });
    }

    public void shutdown() {
        ReplayMod var1 = this.IllIIIlllIIIlIlllIlIIlIII.lIlIIlIlllIIlIIIlIlIlIllI();
        IReplayModWrapper var2 = var1.lIllllIllIIlIIlIIIlIIIlII();
        if (var2 != null && (!var1.IlllIIIIIIlllIlIIlllIlIIl() || !var2.isRecording())) {
            var2.noRecover();
        }

        Iterator var3 = this.lllllIllIlIIlIIlIIIlllIlI.iterator();

        while(var3.hasNext()) {
            ItemLoader var4 = (ItemLoader)var3.next();
            var4.lIllIlIIIlIIIIIIIlllIlIll();
        }

        if (this.llIllIlIllIlllIllIIIIllII != null && this.llIllIlIllIlllIllIIIIllII.isOpen()) {
            this.llIllIlIllIlllIllIIIIllII.close();
        }

        LunarExecutors.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    public void authenticate(Consumer var1) {
        SessionBridge var2 = Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSession();
        Account var3 = Ref.IlllIIIIIIlllIlIIlllIlIIl().llIlIIIllIIlIllIllIllllIl().IlllllIlIIIlIIlIIllIIlIll();
        if (var3 == null) {
            LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Auth", "Failed to establish connection with the auth server, account null.");
            var1.accept((Object)null);
        } else {
            try {
                (new AuthenticatorWebSocket(ImmutableMap.builder().put("username", var2.bridge$getUsername()).put("playerId", AuthUtil.lIllIlIIIlIIIIIIIlllIlIll(var2.bridge$getPlayerID())).build(), var1)).connect();
            } catch (URISyntaxException var5) {
                var5.printStackTrace();
                var1.accept((Object)null);
            }
        }
    }

    public void loginToAssetsWebsocket() {
        LunarExecutors.IlllIIIIIIlllIlIIlllIlIIl().execute(() -> {
            try {
                LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Assets", "Establishing connection");
                if (this.llIllIlIllIlllIllIIIIllII != null && this.llIllIlIllIlllIllIIIIllII.isOpen()) {
                    this.llIllIlIllIlllIllIIIIllII.closeBlocking();
                }

                SessionBridge var1 = Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSession();
                Account var2 = Ref.IlllIIIIIIlllIlIIlllIlIIl().llIlIIIllIIlIllIllIllllIl().IlllllIlIIIlIIlIIllIIlIll();
                String var3 = Ref.IlllIIIIIIlllIlIIlllIlIIl().llllIIlIIlIIlIIllIIlIIllI().llIIIIIIIllIIllIlIllIIIIl();
                this.authenticate((var4x) -> {
                    if (var4x != null) {
                        try {
                            this.llIllIlIllIlllIllIIIIllII = new AssetsWebSocket(ImmutableMap.builder().put("accountType", var2.llIIlIlIIIllIlIlIlIIlIIll().name()).put("version", Bridge.IlllIIIIIIlllIlIIlllIlIIl().name()).put("gitCommit", llllIlIlIIIllllIIlIllIlII()).put("branch", llIIIllllIIIllIIIIlIlIlll()).put("os", OS_NAME = System.getProperty("os.name")).put("arch", OS_ARCH = (String) Nul
                        } catch (URISyntaxException var6) {
                            var6.printStackTrace();
                        }

                        this.llIllIlIllIlllIllIIIIllII.connect();
                    }
                });
            } catch (InterruptedException var4) {
                var4.printStackTrace();
            }

        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(SessionBridge var1) {
        try {
            boolean var2 = var1 != null && var1.bridge$getProfile() != null && var1.bridge$getProfile().getId() != null;
            boolean var3 = var2 && !var1.bridge$getProfile().getId().equals(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSession().bridge$getProfile().getId());
            boolean var4 = this.llIllIlIllIlllIllIIIIllII != null;
            if (var2 && var3) {
                this.lllllIIIIlIlllIllIIIlIIlI.llIlllIIIllllIIlllIllIIIl(var1.bridge$getProfile().getId());
            }

            this.llIlIIIllIIlIllIllIllllIl = new FriendProfile(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSession().bridge$getProfile().getId());
            this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl(Status.lIlIlIlIlIIlIIlIIllIIIIIl);
            this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSession().bridge$getUsername());
            this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl("In-Menus");
            this.loginToAssetsWebsocket();
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$submit(() -> {
                boolean var0 = false;
                if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen() != null && Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen().lIlIlIlIlIIlIIlIIllIIIIIl(CosmeticsUIScreen.class)) {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(null);
                    var0 = true;
                }

                CosmeticsUIScreen.llIIIIIIIllIIllIlIllIIIIl();
                if (var0) {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new CosmeticsUIScreen()));
                }

            });
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$submit(() -> {
                boolean var0 = false;
                if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen() != null && Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen().lIlIlIlIlIIlIIlIIllIIIIIl(lunar.cl.CosmeticsUIScreen.class)) {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(null);
                    var0 = true;
                }

                CosmeticsListUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(CosmeticsListUIComponent.llllIIlIIlIIlIIllIIlIIllI());
                if (var0) {
                    if (Ref.llIIIIIIIllIIllIlIllIIIIl() == null) {
                        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIWrapper(new CosmeticsUIScreenBase(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen()))));
                    } else {
                        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new CosmeticsUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen())));
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
                if (!(((WrappedGuiScreenBridge)var1).getCustomScreen() instanceof BugReportUIScreen)) {
                    this.queue.add(((WrappedGuiScreenBridge)var1).getCustomScreen().getClass().getName());
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
        return "Lunar Client (" + Bridge.IlllIIIIIIlllIlIIlllIlIIl().IlIlIlllllIlIIlIlIlllIlIl() + "-" + IlIlllIlIlllIllIIIIIIlllI() + "/" + llIIIllllIIIllIIIIlIlIlll() + ")";
    }

    public static int llIlllIIIllllIIlllIllIIIl() {
        return 64;
    }

    public FriendProfile llllIIlIIlIIlIIllIIlIIllI() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public File IlIlIlllllIlIIlIlIlllIlIl() {
        return this.gameSettingsDir;
    }

    public NetHandler llIIIIIIIllIIllIlIllIIIIl() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public ServerIntegration lIIIllIllIIllIlllIlIIlllI() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public AssetsWebSocket IlllllIlIIIlIIlIIllIIlIll() {
        return this.llIllIlIllIlllIllIIIIllII;
    }

    public String llIIlIlIIIllIlIlIlIIlIIll() {
        return this.IllllllllllIlIIIlllIlllll;
    }

    public Set llIIIlllIIlllIllllIlIllIl() {
        return this.lllllIllIlIIlIIlIIIlllIlI;
    }

    public ModuleManager lllllIllIllIllllIlIllllII() {
        return this.IllIIIlllIIIlIlllIlIIlIII;
    }

    public SettingsLoader lllIIIIIlllIIlIllIIlIIIlI() {
        return this.IIlIllIlIIllIIlIlIllllllI;
    }

    public RuleFeaturesConfig lIlIIIIIIlIIIllllIllIIlII() {
        return this.lIIIlllIIIIllllIlIIIlIIll;
    }

    public AccountsConfig llIlIIIllIIlIllIllIllllIl() {
        return this.llIIIlIllIIIIlIIIlIlIllIl;
    }

    public EmptySetLoader IllIllIIIllIIIlIlIlIIIIll() {
        return this.llllIlIllllIlIlIIIllIlIlI;
    }

    public StaffModsConfig IIlIllIlllllllIIlIIIllIIl() {
        return this.IlIllIIlIIlIIIllIllllIIll;
    }

    public EmoteConfig lIIlIlllIlIlIIIlllIIlIIII() {
        return this.lIllllIllIIlIIlIIIlIIIlII;
    }

    public WaypointsJson llIllIlIllIlllIllIIIIllII() {
        return this.lIlIlIIIIIIllIlIIIIllIIII;
    }

    public FavoriteColorsConfig IllllllllllIlIIIlllIlllll() {
        return this.lIIlIIIIIIlIIlIIllIlIIlII;
    }

    public PlayerHeadManager lllllIllIlIIlIIlIIIlllIlI() {
        return this.IlIIlIIlIIlIIllIIIllIIllI;
    }

    public UUIDFriendSetLoader IllIIIlllIIIlIlllIlIIlIII() {
        return this.IIlIlIIIllIIllllIllllIlIl;
    }

    public CosmeticManager IIlIllIlIIllIIlIlIllllllI() {
        return this.lllllIIIIlIlllIllIIIlIIlI;
    }

    public EmptyMapLoader lIIIlllIIIIllllIlIIIlIIll() {
        return this.IIlllIllIlIllIllIIllIlIIl;
    }

    public ConcurrentMapLoaderWrapper llIIIlIllIIIIlIIIlIlIllIl() {
        return this.lIlIIlIlllIIlIIIlIlIlIllI;
    }

    public PinnedServersConfig llllIlIllllIlIlIIIllIlIlI() {
        return this.lIIlllIIIIIlllIIIlIlIlllI;
    }

    public FriendLoader IlIllIIlIIlIIIllIllllIIll() {
        return this.IIIlIIIIIIllIIIIllIIIIlII;
    }

    public TitlesSetLoader lIllllIllIIlIIlIIIlIIIlII() {
        return this.IlIIIlIlIlIlIlIllIIllIIlI;
    }

    public ProfileLoader lIlIlIIIIIIllIlIIIIllIIII() {
        return this.IlIlIllIIllllIllllllIIlIl;
    }

    public FeaturesConfig lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.lIIlIIlllIIIIlIlllIIIIlll;
    }

    public BorderManager IlIIlIIlIIlIIllIIIllIIllI() {
        return this.llIllIIIIlIIIIIIlllIllIlI;
    }

    public MutedUsersConfig IIlIlIIIllIIllllIllllIlIl() {
        return this.lIlIIIIIllIIlIIlIIlIlIIlI;
    }

    public ProfileMapLoader lllllIIIIlIlllIllIIIlIIlI() {
        return this.IIllIlIllIlIllIllIllIllII;
    }

    public BlogPostLoader IIlllIllIlIllIllIIllIlIIl() {
        return this.IlIlllIlIlllIllIIIIIIlllI;
    }

    public LanguageConfig lIlIIlIlllIIlIIIlIlIlIllI() {
        return this.llllIlIlIIIllllIIlIllIlII;
    }

    public ResizeScreenNotificationSetLoader lIIlllIIIIIlllIIIlIlIlllI() {
        return this.llIIIllllIIIllIIIIlIlIlll;
    }

    public NotificationManager IIIlIIIIIIllIIIIllIIIIlII() {
        return this.IIIIIIIIIIIIIIIllllIIlIIl;
    }

    public PlayerEventHandler IlIIIlIlIlIlIlIllIIllIIlI() {
        return this.llIIIIllIlIIlIlIIlllIllIl;
    }

    public MouseEventHandler IlIlIllIIllllIllllllIIlIl() {
        return this.IIIIlIllIllIlIIIIIlIlIlIl;
    }

    public EvictingQueue lIIlIIlllIIIIlIlllIIIIlll() {
        return this.queue;
    }

    public boolean llIllIIIIlIIIIIIlllIllIlI() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public static String lIlIIIIIllIIlIIlIIlIlIIlI() {
        return lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public static LunarClient IIllIlIllIlIllIllIllIllII() {
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

    public Optional IIIIlIllIllIlIIIIIlIlIlIl() {
        return this.optional;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Optional var1) {
        this.optional = var1;
    }

    public Map<String, ThirdPartyMod> IlIlIlIlIIIlIIlIIlllIllIl() {
        return this.lllllIlIllIlIlllIIIlIIlIl;
    }
}

