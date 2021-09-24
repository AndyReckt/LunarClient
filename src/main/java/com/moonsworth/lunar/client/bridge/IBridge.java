package com.moonsworth.lunar.client.bridge;

import com.moonsworth.lunar.bridge.lunar.GeometryTessellator;
import com.moonsworth.lunar.bridge.lunar.LunarBorder;
import com.moonsworth.lunar.bridge.minecraft.block.BlockBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.bridge.minecraft.client.event.ClickEventAction;
import com.moonsworth.lunar.bridge.minecraft.client.event.ClickEventBridge;
import com.moonsworth.lunar.bridge.minecraft.client.event.HoverEventAction;
import com.moonsworth.lunar.bridge.minecraft.client.event.HoverEventBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.*;
import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.ServerDataBridge;
import com.moonsworth.lunar.bridge.minecraft.client.network.OldServerPingerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.bridge.minecraft.client.network.play.client.C17PacketCustomPayloadBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.TessellatorBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.ThreadDownloadImageDataBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.*;
import com.moonsworth.lunar.bridge.minecraft.client.settings.GameSettingsBridge;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.bridge.minecraft.entity.boss.BossStatusBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.scoreboard.ScoreObjectiveBridge;
import com.moonsworth.lunar.bridge.minecraft.scoreboard.ScoreboardBridge;
import com.moonsworth.lunar.bridge.minecraft.util.*;
import io.netty.buffer.ByteBuf;
import lombok.SneakyThrows;

import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

/**
 * @author Decencies
 * @since 10/07/2021 16:00
 */
public interface IBridge {
    void enable();

    void lateInit();

    MinecraftVersion getMinecraftVersion();

    ResourceLocationBridge initResourceLocation(String var1, String var2);

    ResourceLocationBridge initResourceLocation(String var1);

    KeyBindingBridge initKeyBinding(String var1, int var2, String var3);

    ChatComponentTextBridge initChatText(String var1);

    ThreadDownloadImageDataBridge initThreadDownloadImageData(File var1, String var2, ResourceLocationBridge var3);

    SessionBridge initSession(String var1, String var2, String var3, String var4);

    WrappedGuiScreenBridge initCustomScreen(CustomScreen var1);

    TessellatorBridge initTessellator();

    LoadableTickingTexture initAsyncTexture(ResourceLocationBridge var1);

    DynamicTextureBridge initDynamicTexture(int var1, int var2);

    DynamicTextureBridge initDynamicTexture(BufferedImage var1);

    PacketBufferBridge initPacketBuffer(ByteBuf var1);

    C17PacketCustomPayloadBridge initCustomPayload(String var1, PacketBufferBridge var2);

    Vec3Bridge initVec3d(double var1, double var3, double var5);

    BlockBridge bridge$getBlockFromItem(ItemBridge var1);

    OldServerPingerBridge initOldServerPinger();

    GuiSelectWorldBridge initGuiSelectWorld(@Nullable GuiScreenBridge var1);

    GuiMultiplayerBridge initGuiMultiplayer(@Nullable GuiScreenBridge var1);

    GuiOptionsBridge initGuiOptions(@Nullable GuiScreenBridge var1);

    GuiLanguageBridge initLanguage(@Nullable GuiScreenBridge var1);

    GuiScreenBridge initRealms(@Nullable GuiScreenBridge var1);

    GuiConfirmOpenLinkBridge initOpenLink(@Nullable GuiScreenBridge var1, String var2, URI var3, int var4, boolean var5);

    ClickEventBridge initChatClickEvent(ClickEventAction var1, String var2);

    HoverEventBridge initChatHoverEvent(HoverEventAction var1, IChatComponentBridge var2);

    ItemStackBridge initItemStack(ItemBridge var1);

    ItemStackBridge initItemStack(BlockBridge var1);

    ItemStackBridge initEmptyItemStack();

    List<BossStatusBridge> getBossStatus();

    ScoreboardBridge initScoreboard();

    ScoreObjectiveBridge initDummyScoreObjective(ScoreboardBridge var1, String var2);

    AxisAlignedBBBridge initAABB(double var1, int var3, double var4, double var6, int var8, double var9);

    LunarBorder initLCBorder(String var1, String var2, int var3);

    AbstractTextureBridge initCustomTexture(CustomTextureBridge var1);

    AbstractTextureBridge initTickingTexture(TickingTexture var1);

    EntityPlayerSPBridge initDummyPlayer();

    MovementInputBridge initMovementInput(GameSettingsBridge var1);

    ServerDataBridge initServerData(String var1, String var2, boolean var3);

    GeometryTessellator getGeometryTessellator();

    ModelCloak initModelCloak(int var1);

    ModelCloak initModelCloak(int var1, int var2, int var3);

    // todo idk if this is sneakythrows lol
    @SneakyThrows
default BufferedImage lIlIlIlIlIIlIIlIIllIIIIIl(InputStream inputStream) {
        return ImageIO.read(inputStream);
    }
}
