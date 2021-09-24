package com.moonsworth.lunar.client.websocket;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import com.mojang.authlib.exceptions.InvalidCredentialsException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiNewChatBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ChatComponentTextBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.UsedEnum;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.cosmetic.Cosmetic;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.network.NetHandlerPlayClientInitEvent;
import com.moonsworth.lunar.client.event.type.network.ServerDisconnectEvent;
import com.moonsworth.lunar.client.event.type.world.PreRunTickEvent;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.notification.NotificationType;
import com.moonsworth.lunar.client.profile.FriendProfile;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.CosmeticManager;
import com.moonsworth.lunar.client.ui.screen.type.emotes.EmotesUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.CosmeticsUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;
import com.moonsworth.lunar.client.websocket.packet.*;
import io.netty.buffer.Unpooled;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import javax.crypto.SecretKey;
import java.math.BigInteger;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.security.PublicKey;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssetsWebSocket extends WebSocketClient implements llIlllIIIllllIIlllIllIIIl, EventHandler {

    public static final int IlllIIIIIIlllIlIIlllIlIIl = 15;
    public static final int lIllIlIIIlIIIIIIIlllIlIll = 1;
    public static llllIIlIIlIIlIIllIIlIIllI llIlllIIIllllIIlllIllIIIl;
    public static String lIlIlIlIlIIlIIlIIllIIIIIl;
    public String llllIIlIIlIIlIIllIIlIIllI;
    public final Cache IlIlIlllllIlIIlIlIlllIlIl;
    public final LunarClient llIIIIIIIllIIllIlIllIIIIl;
    public final MinecraftBridge lIIIllIllIIllIlllIlIIlllI;
    public WebSocketState IlllllIlIIIlIIlIIllIIlIll;
    public long llIIlIlIIIllIlIlIlIIlIIll;
    public boolean llIIIlllIIlllIllllIlIllIl;
    public boolean lllllIllIllIllllIlIllllII;
    public boolean lllIIIIIlllIIlIllIIlIIIlI;

    public AssetsWebSocket(final Map map) throws URISyntaxException {
        super(new URI("wss://assetserver.lunarclientprod.com/connect"), new Draft_6455(), map, 30000);
        this.llllIIlIIlIIlIIllIIlIIllI = null;
        this.IlIlIlllllIlIIlIlIlllIlIl = CacheBuilder.newBuilder().expireAfterWrite(3L, TimeUnit.MINUTES).build();
        this.IlllllIlIIIlIIlIIllIIlIll = WebSocketState.DISCONNECTED;
        this.lllIIIIIlllIIlIllIIlIIIlI = false;
        LunarLogger.info("Assets", "Instantiate");
        this.llIIIIIIIllIIllIlIllIIIIl = Ref.getLC();
        this.lIIIllIllIIllIlllIlIIlllI = Ref.getMinecraft();
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerPlayClientInitEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void onOpen(final ServerHandshake serverHandshake) {
        AssetsWebSocket.llIlllIIIllllIIlllIllIIIl = null;
        this.IlllllIlIIIlIIlIIllIIlIll = WebSocketState.AWAITING_ENCRYPTION_REQUEST;
        LunarLogger.info("Assets", "Connection established as %s", this.llIIIIIIIllIIllIlIllIIIIl.llllIIlIIlIIlIIllIIlIIllI().llIlllIIIllllIIlllIllIIIl());
        this.llIIIIIIIllIIllIlIllIIIIl.IlIIIlIlIlIlIlIllIIllIIlI().lIlIlIlIlIIlIIlIIllIIIIIl();
        this.llIIlIlIIIllIlIlIlIIlIIll = System.currentTimeMillis();
    }

    public void onClose(final int n, final String s, final boolean b) {
        if (this.IlllllIlIIIlIIlIIllIIlIll == null) {
            boolean asBoolean = true;
            int asInt = 15;
            if (n == 1000) {
                try {
                    final JsonObject jsonObject = LunarClient.GSON.fromJson(s, JsonObject.class);
                    if (jsonObject.isJsonObject()) {
                        if (jsonObject.has("exponentialBackoff") && !jsonObject.get("exponentialBackoff").isJsonNull()) {
                            asBoolean = jsonObject.getAsBoolean();
                        }
                        if (jsonObject.has("time") && !jsonObject.get("time").isJsonNull()) {
                            asInt = jsonObject.get("time").getAsInt();
                        }
                    }
                } catch (JsonSyntaxException ex) {
                    if (s.equalsIgnoreCase("Server rebooting")) {
                        asInt = 5;
                        asBoolean = false;
                    }
                }
            }
            AssetsWebSocket.llIlllIIIllllIIlllIllIIIl = new llllIIlIIlIIlIIllIIlIIllI(asInt, asBoolean);
        }
        this.IlllllIlIIIlIIlIIllIIlIll = WebSocketState.DISCONNECTED;
        LunarLogger.debug("Assets", "Connection closed (%d, \"%s\")", n, s);
        this.llIIIlllIIlllIllllIlIllIl = false;
        this.lllllIllIllIllllIlIllllII = false;
        this.llIIIIIIIllIIllIlIllIIIIl.IlIIIlIlIlIlIlIllIIllIIlI().IlllIIIIIIlllIlIIlllIlIIl();
        this.llIIIIIIIllIIllIlIllIIIIl.lIIlIlllIlIlIIIlllIIlIIII().llllIIlIIlIIlIIllIIlIIllI();
    }

    public void onMessage(final ByteBuffer byteBuffer) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.getInstance().initPacketBuffer(Unpooled.wrappedBuffer(byteBuffer.array())));
    }

    public void onError(final Exception ex) {
        LunarLogger.error("Assets", "WS-Error:" + ex.getMessage());
        if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl(UsedEnum.ASSET_SERVER)) {
            ex.printStackTrace();
        }
    }

    public void onMessage(final String s) {
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AbstractWebSocketPacket abstractWebSocketPacket) {
        if (!this.isOpen()) {
            return;
        }
        final PacketBufferBridge initPacketBuffer = Bridge.getInstance().initPacketBuffer(Unpooled.buffer());
        initPacketBuffer.bridge$writeVarIntToBuffer((int) AbstractWebSocketPacket.REGISTRY.get(abstractWebSocketPacket.getClass()));
        abstractWebSocketPacket.IlllIIIIIIlllIlIIlllIlIIl(initPacketBuffer);
        final byte[] array = new byte[initPacketBuffer.bridge$readableBytes()];
        initPacketBuffer.bridge$readBytes(array);
        initPacketBuffer.bridge$release();
        this.send(array);
        if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl(UsedEnum.ASSET_SERVER)) {
            LunarLogger.info("Assets", "Sent: %s", abstractWebSocketPacket.getClass().getSimpleName());
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(Object p0) {

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final PacketBufferBridge packetBufferBridge) {
        final Class clazz = (Class) AbstractWebSocketPacket.REGISTRY.inverse().get(packetBufferBridge.bridge$readVarIntFromBuffer());
        try {
            final AbstractWebSocketPacket abstractWebSocketPacket = (clazz == null) ? null : (AbstractWebSocketPacket) clazz.newInstance();
            if (abstractWebSocketPacket == null) {
                return;
            }
            if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl(UsedEnum.ASSET_SERVER)) {
                LunarLogger.info("Assets", "Received: %s", clazz.getSimpleName());
            }
            abstractWebSocketPacket.lIllIlIIIlIIIIIIIlllIlIll(packetBufferBridge);
            abstractWebSocketPacket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
        } catch (Exception ex) {
            LunarLogger.info("Assets", "Error from: " + clazz);
            ex.printStackTrace();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final ServerDisconnectEvent serverDisconnectEvent) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("");
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final NetHandlerPlayClientInitEvent netHandlerPlayClientInitEvent) {
        if (Ref.getMinecraft().bridge$getCurrentServerData() == null) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl("singleplayer");
        } else if (Ref.getMinecraft().bridge$isConnectedToRealms()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl("Minecraft Realms");
        } else {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getMinecraft().bridge$getCurrentServerData().bridge$serverIP());
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final String llllIIlIIlIIlIIllIIlIIllI) {
        if (llllIIlIIlIIlIIllIIlIIllI.equalsIgnoreCase(this.llllIIlIIlIIlIIllIIlIIllI)) {
            return;
        }
        final Matcher matcher = Pattern.compile("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)").matcher(llllIIlIIlIIlIIllIIlIIllI);
        this.llllIIlIIlIIlIIllIIlIIllI = llllIIlIIlIIlIIllIIlIIllI;
        if (!matcher.find()) {
            this.llIIIIIIIllIIllIlIllIIIIl.llllIIlIIlIIlIIllIIlIIllI().lIllIlIIIlIIIIIIIlllIlIll(llllIIlIIlIIlIIllIIlIIllI);
            this.lIlIlIlIlIIlIIlIIllIIIIIl((AbstractWebSocketPacket) new WSPacketServerUpdate("", llllIIlIIlIIlIIllIIlIIllI));
        } else {
            this.llIIIIIIIllIIllIlIllIIIIl.llllIIlIIlIIlIIllIIlIIllI().lIllIlIIIlIIIIIIIlllIlIll("_numeric_");
            this.lIlIlIlIlIIlIIlIIllIIIIIl((AbstractWebSocketPacket) new WSPacketServerUpdate("", "_numeric_"));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final WSPacketMessage wsPacketMessage) {
        this.llIIIIIIIllIIllIlIllIIIIl.getPlayerHeadManager().lIlIlIlIlIIlIIlIIllIIIIIl(UUID.fromString(wsPacketMessage.lIlIlIlIlIIlIIlIIllIIIIIl()), wsPacketMessage.IlllIIIIIIlllIlIIlllIlIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final WSPacketServerUpdate wsPacketServerUpdate) {
        final UUID fromString = UUID.fromString(wsPacketServerUpdate.IlllIIIIIIlllIlIIlllIlIIl());
        final String lIlIlIlIlIIlIIlIIllIIIIIl = wsPacketServerUpdate.lIlIlIlIlIIlIIlIIllIIIIIl();
        final FriendProfile lIlIlIlIlIIlIIlIIllIIIIIl2 = this.llIIIIIIIllIIllIlIllIIIIl.getPlayerHeadManager().lIlIlIlIlIIlIIlIIllIIIIIl(fromString);
        if (lIlIlIlIlIIlIIlIIllIIIIIl2 != null) {
            lIlIlIlIlIIlIIlIIllIIIIIl2.lIllIlIIIlIIIIIIIlllIlIll(lIlIlIlIlIIlIIlIIllIIIIIl);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final WSPacketConsole wsPacketConsole) {
        LunarLogger.info("Assets", "[Console] %s", wsPacketConsole.lIlIlIlIlIIlIIlIIllIIIIIl());
        this.llIIIIIIIllIIllIlIllIIIIl.IllIllIIIllIIIlIlIlIIIIll().addLine(wsPacketConsole.lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final WSPacketClientFriendRequestUpdate wsPacketClientFriendRequestUpdate) {
        if (!wsPacketClientFriendRequestUpdate.lIlIlIlIlIIlIIlIIllIIIIIl()) {
            this.llIIIIIIIllIIllIlIllIIIIl.IllIIIlllIIIlIlllIlIIlIII().lIlIlIlIlIIlIIlIIllIIIIIl(UUID.fromString(wsPacketClientFriendRequestUpdate.IlllIIIIIIlllIlIIlllIlIIl()));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final WSPacketFriendUpdate wsPacketFriendUpdate) {
        final UUID fromString = UUID.fromString(wsPacketFriendUpdate.lIlIlIlIlIIlIIlIIllIIIIIl());
        final String illlIIIIIIlllIlIIlllIlIIl = wsPacketFriendUpdate.IlllIIIIIIlllIlIIlllIlIIl();
        final boolean llIlllIIIllllIIlllIllIIIl = wsPacketFriendUpdate.llIlllIIIllllIIlllIllIIIl();
        FriendProfile lIlIlIlIlIIlIIlIIllIIIIIl = this.llIIIIIIIllIIllIlIllIIIIl.getPlayerHeadManager().lIlIlIlIlIIlIIlIIllIIIIIl(fromString);
        if (lIlIlIlIlIIlIIlIIllIIIIIl == null) {
            lIlIlIlIlIIlIIlIIllIIIIIl = new FriendProfile(fromString);
        }
        if (wsPacketFriendUpdate.lIllIlIIIlIIIIIIIlllIlIll() < 10L) {
            final int n = (int) wsPacketFriendUpdate.lIllIlIIIlIIIIIIIlllIlIll();
            Status lIlIlIlIlIIlIIlIIllIIIIIl2 = Status.ONLINE;
            for (final Status status : Status.values()) {
                if (status.ordinal() == n) {
                    lIlIlIlIlIIlIIlIIllIIIIIl2 = status;
                }
            }
            if (this.IlIlIlllllIlIIlIlIlllIlIl.getIfPresent(lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll()) == null && this.llIIIIIIIllIIllIlIllIIIIl.lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lllllIllIlIIlIIlIIIlllIlI().llIlllIIIllllIIlllIllIIIl() && lIlIlIlIlIIlIIlIIllIIIIIl2 == Status.ONLINE && lIlIlIlIlIIlIIlIIllIIIIIl.llIllIlIllIlllIllIIIIllII() != Status.ONLINE && System.currentTimeMillis() - this.llIIlIlIIIllIlIlIlIIlIIll > TimeUnit.SECONDS.toMillis(1L)) {
                this.llIIIIIIIllIIllIlIllIIIIl.IIIlIIIIIIllIIIIllIIIIlII().lIllIlIIIlIIIIIIIlllIlIll(lIlIlIlIlIIlIIlIIllIIIIIl.llIlllIIIllllIIlllIllIIIl(), EnumChatColor.llIIIlllIIlllIllllIlIllIl.toString() + EnumChatColor.lIIlIlllIlIlIIIlllIIlIIII + lIlIlIlIlIIlIIlIIllIIIIIl.llIlllIIIllllIIlllIllIIIl() + EnumChatColor.IllIllIIIllIIIlIlIlIIIIll + " is now online");
            }
            lIlIlIlIlIIlIIlIIllIIIIIl.setStatus(lIlIlIlIlIIlIIlIIllIIIIIl2);
        }
        this.IlIlIlllllIlIIlIlIlllIlIl.put(lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(), false);
        lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(llIlllIIIllllIIlllIllIIIl);
        lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(illlIIIIIIlllIlIIlllIlIIl);
        lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(Arrays.stream(MinecraftVersion.values()).filter(minecraftVersion -> minecraftVersion.name().equals(wsPacketFriendUpdate.llllIIlIIlIIlIIllIIlIIllI())).findFirst().orElse(null));
        if (!llIlllIIIllllIIlllIllIIIl) {
            lIlIlIlIlIIlIIlIIllIIIIIl.setStatus(Status.OFFLINE);
            lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(wsPacketFriendUpdate.lIllIlIIIlIIIIIIIlllIlIll());
        }
        if (!this.llIIIIIIIllIIllIlIllIIIIl.getPlayerHeadManager().IlllIIIIIIlllIlIIlllIlIIl(fromString)) {
            this.llIIIIIIIllIIllIlIllIIIIl.getPlayerHeadManager().lIlIlIlIlIIlIIlIIllIIIIIl(lIlIlIlIlIIlIIlIIllIIIIIl);
        }
        this.llIIIIIIIllIIllIlIllIIIIl.getPlayerHeadManager().IlIlIlllllIlIIlIlIlllIlIl();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsPacketBulkFriends assetsPacketBulkFriends) {
        this.llIIIIIIIllIIllIlIllIIIIl.IllIIIlllIIIlIlllIlIIlIII().llllIIlIIlIIlIIllIIlIIllI();
        for (JsonElement jsonElement : assetsPacketBulkFriends.lIlIlIlIlIIlIIlIIllIIIIIl()) {
            final JsonObject asJsonObject = jsonElement.getAsJsonObject();
            this.llIIIIIIIllIIllIlIllIIIIl.IllIIIlllIIIlIlllIlIIlIII().IlllIIIIIIlllIlIIlllIlIIl(UUID.fromString(asJsonObject.get("uuid").getAsString()), asJsonObject.get("name").getAsString());
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final WSPacketChat wsPacketChat) {
        final MinecraftBridge lIlIlIlIlIIlIIlIIllIIIIIl = Ref.getMinecraft();
        if (lIlIlIlIlIIlIIlIIllIIIIIl.bridge$getGuiIngame() != null && lIlIlIlIlIIlIIlIIllIIIIIl.bridge$getGuiIngame().bridge$getChatGUI() != null) {
            lIlIlIlIlIIlIIlIIllIIIIIl.bridge$getGuiIngame().bridge$getChatGUI().bridge$printChatMessage(Bridge.getInstance().initChatText(wsPacketChat.lIlIlIlIlIIlIIlIIllIIIIIl()));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final WSPacketFormattedConsoleOutput wsPacketFormattedConsoleOutput) {
        final String lIlIlIlIlIIlIIlIIllIIIIIl = wsPacketFormattedConsoleOutput.lIlIlIlIlIIlIIlIIllIIIIIl();
        final String illlIIIIIIlllIlIIlllIlIIl = wsPacketFormattedConsoleOutput.IlllIIIIIIlllIlIIlllIlIIl();
        LunarLogger.info("Assets", EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl("[" + lIlIlIlIlIIlIIlIIllIIIIIl + "] " + illlIIIIIIlllIlIIlllIlIIl));
        this.llIIIIIIIllIIllIlIllIIIIl.IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(lIlIlIlIlIIlIIlIIllIIIIIl, illlIIIIIIlllIlIIlllIlIIl);
        this.llIIIIIIIllIIllIlIllIIIIl.IllIllIIIllIIIlIlIlIIIIll().addLine(EnumChatColor.IlllllIlIIIlIIlIIllIIlIll + "[" + EnumChatColor.RESET + wsPacketFormattedConsoleOutput.lIlIlIlIlIIlIIlIIllIIIIIl() + EnumChatColor.IlllllIlIIIlIIlIIllIIlIll + "] " + EnumChatColor.RESET + wsPacketFormattedConsoleOutput.IlllIIIIIIlllIlIIlllIlIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final WSPacketFriendsUpdate wsPacketFriendsUpdate) {
        this.IlllllIlIIIlIIlIIllIIlIll = WebSocketState.READY;
        this.llIIIIIIIllIIllIlIllIIIIl.getPlayerHeadManager().llllIIlIIlIIlIIllIIlIIllI();
        final Map<String, List<Object>> lIllIlIIIlIIIIIIIlllIlIll = wsPacketFriendsUpdate.lIllIlIIIlIIIIIIIlllIlIll();
        final Map<String, List<Object>> llIlllIIIllllIIlllIllIIIl = wsPacketFriendsUpdate.llIlllIIIllllIIlllIllIIIl();
        this.llIIIlllIIlllIllllIlIllIl = wsPacketFriendsUpdate.lIlIlIlIlIIlIIlIIllIIIIIl();
        this.lllllIllIllIllllIlIllllII = wsPacketFriendsUpdate.IlllIIIIIIlllIlIIlllIlIIl();
        for (final Map.Entry<String, List<Object>> entry : lIllIlIIIlIIIIIIIlllIlIll.entrySet()) {
            final UUID fromString = UUID.fromString(entry.getKey());
            final String s = (String) entry.getValue().get(0);
            final int intValue = (int) entry.getValue().get(1);
            final String s2 = (String) entry.getValue().get(2);
            Status lIlIlIlIlIIlIIlIIllIIIIIl = Status.ONLINE;
            for (final Status status : Status.values()) {
                if (status.ordinal() == intValue) {
                    lIlIlIlIlIIlIIlIIllIIIIIl = status;
                }
            }
            final FriendProfile friendProfile = new FriendProfile(fromString);
            friendProfile.lIlIlIlIlIIlIIlIIllIIIIIl(s);
            friendProfile.lIllIlIIIlIIIIIIIlllIlIll(s2);
            friendProfile.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            friendProfile.setStatus(lIlIlIlIlIIlIIlIIllIIIIIl);
            this.llIIIIIIIllIIllIlIllIIIIl.getPlayerHeadManager().lIlIlIlIlIIlIIlIIllIIIIIl(friendProfile);
        }
        for (final Map.Entry<String, List<Object>> entry2 : llIlllIIIllllIIlllIllIIIl.entrySet()) {
            final UUID fromString2 = UUID.fromString(entry2.getKey());
            final String s3 = (String) entry2.getValue().get(0);
            final FriendProfile friendProfile2 = new FriendProfile(fromString2);
            friendProfile2.lIlIlIlIlIIlIIlIIllIIIIIl(s3);
            friendProfile2.lIllIlIIIlIIIIIIIlllIlIll("");
            friendProfile2.setStatus(Status.OFFLINE);
            friendProfile2.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            friendProfile2.lIlIlIlIlIIlIIlIIllIIIIIl((Boolean) entry2.getValue().get(1));
            this.llIIIIIIIllIIllIlIllIIIIl.getPlayerHeadManager().lIlIlIlIlIIlIIlIIllIIIIIl(friendProfile2);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AbstractWebSocketPacket abstractPacket, final boolean b) {
        if (b) {
            final WSPacketFriendStatusUpdate wsPacketFriendStatusUpdate = (WSPacketFriendStatusUpdate) abstractPacket;
            this.llIIIIIIIllIIllIlIllIIIIl.IllIIIlllIIIlIlllIlIIlIII().lIlIlIlIlIIlIIlIIllIIIIIl(UUID.fromString(wsPacketFriendStatusUpdate.lIlIlIlIlIIlIIlIIllIIIIIl()), wsPacketFriendStatusUpdate.IlllIIIIIIlllIlIIlllIlIIl());
        } else {
            final WSPacketFriendRequest wsPacketFriendRequest = (WSPacketFriendRequest) abstractPacket;
            final UUID uuid = UUID.fromString(wsPacketFriendRequest.getPlayerId());
            final String name = wsPacketFriendRequest.getName();
            this.llIIIIIIIllIIllIlIllIIIIl.IllIIIlllIIIlIlllIlIIlIII().IlllIIIIIIlllIlIIlllIlIIl(uuid, name);
            this.llIIIIIIIllIIllIlIllIIIIl.IIIlIIIIIIllIIIIllIIIIlII().lIllIlIIIlIIIIIIIlllIlIll(name, EnumChatColor.lIIlIlllIlIlIIIlllIIlIIII + name + EnumChatColor.RESET + " wants to be your friend");
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final WSPacketClientFriendRemove wsPacketClientFriendRemove) {
        final UUID uuid = UUID.fromString(wsPacketClientFriendRemove.getPlayerId());
        if (this.llIIIIIIIllIIllIlIllIIIIl.getPlayerHeadManager().lIlIlIlIlIIlIIlIIllIIIIIl(uuid) != null) {
            this.llIIIIIIIllIIllIlIllIIIIl.getPlayerHeadManager().lIllIlIIIlIIIIIIIlllIlIll(uuid);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final WSPacketClientUnknownCosmetic wsPacketClientUnknownCosmetic) {
        final boolean equals = wsPacketClientUnknownCosmetic.IlllIIIIIIlllIlIIlllIlIIl().equals(this.lIIIllIllIIllIlllIlIIlllI.bridge$getSession().bridge$getProfile().getId());
        if (equals) {
            this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().llIlllIIIllllIIlllIllIIIl().clear();
        } else {
            this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().lIIIllIllIIllIlllIlIIlllI().remove(wsPacketClientUnknownCosmetic.IlllIIIIIIlllIlIIlllIlIIl());
        }
        for (final Cosmetic cosmetic : wsPacketClientUnknownCosmetic.lIlIlIlIlIIlIIlIIllIIIIIl()) {
            if (cosmetic == null) {
                continue;
            }
            if (equals) {
                this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().llIlllIIIllllIIlllIllIIIl().add(cosmetic);
            }
            if (equals && !cosmetic.llIIIIIIIllIIllIlIllIIIIl()) {
                continue;
            }
            this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(wsPacketClientUnknownCosmetic.IlllIIIIIIlllIlIIlllIlIIl(), cosmetic);
        }
        if (equals) {
            this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().IlIlIlllllIlIIlIlIlllIlIl();
        }
        final int lIllIlIIIlIIIIIIIlllIlIll = wsPacketClientUnknownCosmetic.lIllIlIIIlIIIIIIIlllIlIll();
        final float lIlIlIlIlIIlIIlIIllIIIIIl = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(lIllIlIIIlIIIIIIIlllIlIll);
        final float lIllIlIIIlIIIIIIIlllIlIll2 = ColorUtil.lIllIlIIIlIIIIIIIlllIlIll(lIllIlIIIlIIIIIIIlllIlIll);
        final float llllIIlIIlIIlIIllIIlIIllI = ColorUtil.llllIIlIIlIIlIIllIIlIIllI(lIllIlIIIlIIIIIIIlllIlIll);
        if (Bridge.getMinecraftVersion() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl && Ref.getMinecraft().bridge$getWorld() != null) {
            Ref.getMinecraft().bridge$getWorld().bridge$getPlayerByUniqueId(wsPacketClientUnknownCosmetic.IlllIIIIIIlllIlIIlllIlIIl()).ifPresent(entityPlayerBridge -> this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().llIIlIlIIIllIlIlIlIIlIIll().put(entityPlayerBridge.bridge$getName(), wsPacketClientUnknownCosmetic.IlllIIIIIIlllIlIIlllIlIIl()));
        }
        this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().IlllllIlIIIlIIlIIllIIlIll().put(wsPacketClientUnknownCosmetic.IlllIIIIIIlllIlIIlllIlIIl(), new CosmeticManager.NameTagLogo(lIlIlIlIlIIlIIlIIllIIIIIl, lIllIlIIIlIIIIIIIlllIlIll2, llllIIlIIlIIlIIllIIlIIllI, wsPacketClientUnknownCosmetic.llIlllIIIllllIIlllIllIIIl()));
        if (this.lIIIllIllIIllIlllIlIIlllI.bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge && Ref.llIIIlllIIlllIllllIlIllIl() == CosmeticsUIScreen.class) {
            this.lIIIllIllIIllIlllIlIIlllI.bridge$submit(() -> this.lIIIllIllIIllIlllIlIIlllI.bridge$displayScreen(Bridge.getInstance().initCustomScreen(new CosmeticsUIScreen())));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final WSPacketJoinServer wsPacketJoinServer) {
        final SecretKey bridge$createNewSharedKey = Bridge.IlIlIlllllIlIIlIlIlllIlIl().bridge$createNewSharedKey();
        final PublicKey lIlIlIlIlIIlIIlIIllIIIIIl = wsPacketJoinServer.lIlIlIlIlIIlIIlIIllIIIIIl();
        final byte[] bridge$getServerIdHash = Bridge.IlIlIlllllIlIIlIlIlllIlIl().bridge$getServerIdHash("", lIlIlIlIlIIlIIlIIllIIIIIl, bridge$createNewSharedKey);
        if (bridge$getServerIdHash == null) {
            return;
        }
        final String string = new BigInteger(bridge$getServerIdHash).toString(16);
        try {
            new YggdrasilAuthenticationService(Proxy.NO_PROXY, UUID.randomUUID().toString()).createMinecraftSessionService().joinServer(Ref.getMinecraft().bridge$getSession().bridge$getProfile(), Ref.getMinecraft().bridge$getSession().bridge$getToken(), string);
        } catch (AuthenticationUnavailableException ex) {
            Ref.getLC().IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(NotificationType.ERROR, "Authentication Unavailable", ex.getMessage());
            LunarLogger.info("Auth", "Authentication Unavailable (%s)", ex.getMessage());
            return;
        } catch (InvalidCredentialsException ex2) {
            Ref.getLC().IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(NotificationType.ERROR, "Invalid Credentials", ex2.getMessage());
            LunarLogger.info("Auth", "Invalid Credentials (%s)", ex2.getMessage());
            return;
        } catch (AuthenticationException ex3) {
            Ref.getLC().IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(NotificationType.ERROR, "Authentication Error", ex3.getMessage());
            LunarLogger.info("Auth", "Authentication Error (%s)", ex3.getMessage());
            return;
        } catch (NullPointerException ex4) {
            this.close();
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientJoinServerResponse(bridge$createNewSharedKey, lIlIlIlIlIIlIIlIIllIIIIIl, wsPacketJoinServer.IlllIIIIIIlllIlIIlllIlIIl()));
        this.IlllllIlIIIlIIlIIllIIlIll = WebSocketState.AUTHENTICATING;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final IlIIlIIlIIlIIllIIIllIIllI ilIIlIIlIIlIIllIIIllIIllI) {
        Ref.getWorld().bridge$getPlayerByUniqueId(ilIIlIIlIIlIIllIIIllIIllI.lIlIlIlIlIIlIIlIIllIIIIIl()).ifPresent(entityPlayerBridge -> this.llIIIIIIIllIIllIlIllIIIIl.lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(entityPlayerBridge, this.llIIIIIIIllIIllIlIllIIIIl.lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(ilIIlIIlIIlIIllIIIllIIllI.IlllIIIIIIlllIlIIlllIlIIl())));
        if (LunarClient.getInstance().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlllIIIIIIlllIlIIlllIlIIl()) {
            LunarClient.getInstance().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().lIllllIllIIlIIlIIIlIIIlII().handleAssetPacket(ilIIlIIlIIlIIllIIIllIIllI);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final IIlIlIIIllIIllllIllllIlIl ilIlIIIllIIllllIllllIlIl) {
        this.llIIIIIIIllIIllIlIllIIIIl.lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(ilIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final IlIlIllIIllllIllllllIIlIl ilIlIllIIllllIllllllIIlIl) {
        this.llIIIIIIIllIIllIlIllIIIIl.lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(ilIlIllIIllllIllllllIIlIl.lIlIlIlIlIIlIIlIIllIIIIIl());
        this.llIIIIIIIllIIllIlIllIIIIl.lIIlIlllIlIlIIIlllIIlIIII().IlllIIIIIIlllIlIIlllIlIIl(ilIlIllIIllllIllllllIIlIl.IlllIIIIIIlllIlIIlllIlIIl());
        if (Ref.llIIIlllIIlllIllllIlIllIl() == EmotesUIScreen.class) {
            ((EmotesUIScreen) Ref.getMinecraft().bridge$getCurrentScreen()).llIIIlllIIlllIllllIlIllIl();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final WSPacketForceCrash wsPacketForceCrash) {
        this.lllIIIIIlllIIlIllIIlIIIlI = true;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final lIlIIIIIllIIlIIlIIlIlIIlI lIlIIIIIllIIlIIlIIlIlIIlI) {
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final WSPacketClientBan wsPacketClientBan) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().IIlIlIIIllIIllllIllllIlIl().IlIllIIlIIlIIIllIllllIIll().lIlIlIlIlIIlIIlIIllIIIIIl()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        for (String s : wsPacketClientBan.lIllIlIIIlIIIIIIIlllIlIll()) {
            sb.append(EnumChatColor.lllllIllIllIllllIlIllllII).append(s).append(EnumChatColor.IllIllIIIllIIIlIlIlIIIIll).append(", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 4);
        } else {
            sb.append(EnumChatColor.lllllIllIllIllllIlIllllII).append("Lunar Client");
        }
        final String string = EnumChatColor.lllllIllIllIllllIlIllllII + "Ban: " + EnumChatColor.lIIIllIllIIllIlllIlIIlllI + wsPacketClientBan.IlllIIIIIIlllIlIIlllIlIIl();
        final String string2 = EnumChatColor.IllIllIIIllIIIlIlIlIIIIll + "Detected on " + sb;
        final MinecraftBridge lIlIlIlIlIIlIIlIIllIIIIIl = Ref.getMinecraft();
        if (lIlIlIlIlIIlIIlIIllIIIIIl.bridge$getGuiIngame() != null && lIlIlIlIlIIlIIlIIllIIIIIl.bridge$getGuiIngame().bridge$getChatGUI() != null) {
            final GuiNewChatBridge bridge$getChatGUI = lIlIlIlIlIIlIIlIIllIIIIIl.bridge$getGuiIngame().bridge$getChatGUI();
            final ChatComponentTextBridge initChatText = Bridge.getInstance().initChatText("      " + string);
            initChatText.setLc(true);
            bridge$getChatGUI.bridge$printChatMessage(initChatText);
            bridge$getChatGUI.bridge$printChatMessage(Bridge.getInstance().initChatText("      " + string2));
        }
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(final llllIIlIIlIIlIIllIIlIIllI llIlllIIIllllIIlllIllIIIl) {
        AssetsWebSocket.llIlllIIIllllIIlllIllIIIl = llIlllIIIllllIIlllIllIIIl;
    }

    public WebSocketState lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lllllIllIllIllllIlIllllII;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final boolean lllllIllIllIllllIlIllllII) {
        this.lllllIllIllIllllIlIllllII = lllllIllIllIllllIlIllllII;
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    static {
        AssetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl = "not set";
        EventBus.getInstance().register(PreRunTickEvent.class, p0 -> {
            if (LunarClient.getInstance() != null && !LunarClient.getInstance().llIllIIIIlIIIIIIlllIllIlI()) {
                if (!Ref.getAssetsWebsocket().isPresent() || Ref.getAssetsWebsocket().get().lIlIlIlIlIIlIIlIIllIIIIIl() == WebSocketState.DISCONNECTED) {
                    if (AssetsWebSocket.llIlllIIIllllIIlllIllIIIl == null) {
                        LunarLogger.warn("Assets Reconnect", "There was no closedConnection for a disconnected player.");
                        AssetsWebSocket.llIlllIIIllllIIlllIllIIIl = new llllIIlIIlIIlIIllIIlIIllI(15, true);
                    }
                    if (AssetsWebSocket.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl()) {
                        Ref.getLC().loginToAssetsWebsocket();
                        LunarLogger.info("Assets Reconnect", "Reconnecting to the assets server...");
                    }
                }
            }
        });
    }
}
