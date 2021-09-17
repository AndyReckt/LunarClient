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
    public void enable();

    public void lateInit();

    public MinecraftVersion getMinecraftVersion();

    public ResourceLocationBridge initResourceLocation(String var1, String var2);

    public ResourceLocationBridge initResourceLocation(String var1);

    public KeyBindingBridge initKeyBinding(String var1, int var2, String var3);

    public ChatComponentTextBridge initChatText(String var1);

    public ThreadDownloadImageDataBridge initThreadDownloadImageData(File var1, String var2, ResourceLocationBridge var3);

    public SessionBridge initSession(String var1, String var2, String var3, String var4);

    public WrappedGuiScreenBridge initCustomScreen(CustomScreen var1);

    public TessellatorBridge initTessellator();

    public LoadableTickingTexture initAsyncTexture(ResourceLocationBridge var1);

    public DynamicTextureBridge initDynamicTexture(int var1, int var2);

    public DynamicTextureBridge initDynamicTexture(BufferedImage var1);

    public PacketBufferBridge initPacketBuffer(ByteBuf var1);

    public C17PacketCustomPayloadBridge initCustomPayload(String var1, PacketBufferBridge var2);

    public Vec3Bridge initVec3d(double var1, double var3, double var5);

    public BlockBridge bridge$getBlockFromItem(ItemBridge var1);

    public OldServerPingerBridge initOldServerPinger();

    public GuiSelectWorldBridge initGuiSelectWorld(@Nullable GuiScreenBridge var1);

    public GuiMultiplayerBridge initGuiMultiplayer(@Nullable GuiScreenBridge var1);

    public GuiOptionsBridge initGuiOptions(@Nullable GuiScreenBridge var1);

    public GuiLanguageBridge initLanguage(@Nullable GuiScreenBridge var1);

    public GuiScreenBridge initRealms(@Nullable GuiScreenBridge var1);

    public GuiConfirmOpenLinkBridge initOpenLink(@Nullable GuiScreenBridge var1, String var2, URI var3, int var4, boolean var5);

    public ClickEventBridge initChatClickEvent(ClickEventAction var1, String var2);

    public HoverEventBridge initChatHoverEvent(HoverEventAction var1, IChatComponentBridge var2);

    public ItemStackBridge initItemStack(ItemBridge var1);

    public ItemStackBridge initItemStack(BlockBridge var1);

    public ItemStackBridge initEmptyItemStack();

    public List getBossStatus();

    public ScoreboardBridge initScoreboard();

    public ScoreObjectiveBridge initDummyScoreObjective(ScoreboardBridge var1, String var2);

    public AxisAlignedBBBridge initAABB(double var1, int var3, double var4, double var6, int var8, double var9);

    public LunarBorder initLCBorder(String var1, String var2, int var3);

    public AbstractTextureBridge initCustomTexture(CustomTextureBridge var1);

    public AbstractTextureBridge initTickingTexture(TickingTexture var1);

    public EntityPlayerSPBridge initDummyPlayer();

    public MovementInputBridge initMovementInput(GameSettingsBridge var1);

    public ServerDataBridge initServerData(String var1, String var2, boolean var3);

    public GeometryTessellator getGeometryTessellator();

    public ModelCloak initModelCloak(int var1);

    public ModelCloak initModelCloak(int var1, int var2, int var3);

    // todo idk if this is sneakythrows lol
    @SneakyThrows
    default public BufferedImage lIlIlIlIlIIlIIlIIllIIIIIl(InputStream inputStream) {
        return ImageIO.read(inputStream);
    }
}
