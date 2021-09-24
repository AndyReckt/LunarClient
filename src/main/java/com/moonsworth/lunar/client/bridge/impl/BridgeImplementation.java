package com.moonsworth.lunar.client.bridge.impl;

import com.google.common.collect.ImmutableList;

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
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.IBridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.bridge.impl.type.blocks.BlocksImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.border.LunarWorldBorder;
import com.moonsworth.lunar.client.bridge.impl.type.glstatemanager.RendererLivingEntityImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.gui.WrappedGuiScreen;
import com.moonsworth.lunar.client.bridge.impl.type.network.NetHandlerPlayClientWrapper;
import com.moonsworth.lunar.client.bridge.impl.type.otherutil.CryptManagerImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.glcontext.GLContextImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.glstatemanager.GlStateManagerImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.glstatemanager.OpenGlHelperImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.items.ItemsImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.keyboard.KeyboardImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.mouse.MouseImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.otherutil.EnchantmentHelperImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.otherutil.MathHelperImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.otherutil.ModelCloakImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.player.BossStatusImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.player.DummyPlayerWrapper;
import com.moonsworth.lunar.client.bridge.impl.type.potion.PotionImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.render.DroppedItemRendererImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.texture.CustomTextureHolderImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.texture.TextureUtilImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.texture.TickingTextureImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.texture.UploadableTextureImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.util.ClipboardImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.util.CosmeticImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.util.RenderUtilImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.util.TesselatorImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.vertex.DefaultVertexFormatsImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.worldwrapper.WorldClientWrapper;

import io.netty.buffer.ByteBuf;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.OldServerPinger;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.*;

import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nullable;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.util.List;

public class BridgeImplementation implements IBridge {
    public void enable() {
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new TextureUtilImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new CryptManagerImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new KeyboardImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new MouseImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new GLContextImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new GlStateManagerImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new RenderUtilImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new OpenGlHelperImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new ItemsImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new BlocksImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new PotionImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new MathHelperImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new DefaultVertexFormatsImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new EnchantmentHelperImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new ClipboardImplementation());
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new DroppedItemRendererImplementation());
    }

    public void lateInit() {
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new RendererLivingEntityImplementation(Minecraft.getMinecraft().getRenderManager(), null, 0.0F));
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new CosmeticImplementation());
    }

    public MinecraftVersion getMinecraftVersion() {
        return MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public ResourceLocationBridge initResourceLocation(String var1, String var2) {
        return (ResourceLocationBridge)(new ResourceLocation(var1, var2));
    }

    public ResourceLocationBridge initResourceLocation(String var1) {
        return (ResourceLocationBridge)(new ResourceLocation(var1));
    }

    public KeyBindingBridge initKeyBinding(String var1, int var2, String var3) {
        KeyBinding var4 = new KeyBinding(var1, var2, var3);
        Minecraft.getMinecraft().gameSettings.keyBindings = ArrayUtils.add(Minecraft.getMinecraft().gameSettings.keyBindings, var4);
        return (KeyBindingBridge)var4;
    }

    public ChatComponentTextBridge initChatText(String var1) {
        return (ChatComponentTextBridge)(new ChatComponentText(var1));
    }

    public ThreadDownloadImageDataBridge initThreadDownloadImageData(File var1, String var2, ResourceLocationBridge var3) {
        return (ThreadDownloadImageDataBridge)(new ThreadDownloadImageData(var1, var2, (ResourceLocation)var3, null));
    }

    public SessionBridge initSession(String var1, String var2, String var3, String var4) {
        return (SessionBridge)(new Session(var1, var2, var3, var4));
    }

    public WrappedGuiScreenBridge initCustomScreen(CustomScreen var1) {
        return new WrappedGuiScreen(var1);
    }

    public TessellatorBridge initTessellator() {
        return (TessellatorBridge) Tessellator.getInstance();
    }

    public LoadableTickingTexture initAsyncTexture(ResourceLocationBridge var1) {
        return (LoadableTickingTexture)Bridge.lIllIlIIIlIIIIIIIlllIlIll()
               .flatMap((var1x) -> var1x.initAsyncTexture(var1))
               .orElseGet(() -> new UploadableTextureImplementation(var1));
    }

    public DynamicTextureBridge initDynamicTexture(int var1, int var2) {
        return (DynamicTextureBridge)(new DynamicTexture(var1, var2));
    }

    public DynamicTextureBridge initDynamicTexture(BufferedImage var1) {
        return (DynamicTextureBridge)(new DynamicTexture(var1));
    }

    public GuiSelectWorldBridge initGuiSelectWorld(@Nullable GuiScreenBridge var1) {
        return (GuiSelectWorldBridge)(new GuiSelectWorld((GuiScreen)var1));
    }

    public GuiMultiplayerBridge initGuiMultiplayer(@Nullable GuiScreenBridge var1) {
        return (GuiMultiplayerBridge)(new GuiMultiplayer((GuiScreen)var1));
    }

    public GuiOptionsBridge initGuiOptions(@Nullable GuiScreenBridge var1) {
        return (GuiOptionsBridge)(new GuiOptions((GuiScreen)var1, Minecraft.getMinecraft().gameSettings));
    }

    public GuiLanguageBridge initLanguage(@Nullable GuiScreenBridge var1) {
        return (GuiLanguageBridge)(new GuiLanguage((GuiScreen)var1, Minecraft.getMinecraft().gameSettings, Minecraft.getMinecraft().getLanguageManager()));
    }

    public GuiScreenBridge initRealms(@Nullable GuiScreenBridge var1) {
        throw new UnsupportedOperationException("Realms is only available on the latest version!");
    }

    public GuiConfirmOpenLinkBridge initOpenLink(@Nullable GuiScreenBridge var1, String var2, URI var3, int var4, boolean var5) {
        return (GuiConfirmOpenLinkBridge)(new GuiConfirmOpenLink((GuiScreen)var1, var2, var4, var5));
    }

    public ClickEventBridge initChatClickEvent(ClickEventAction var1, String var2) {
        ClickEvent.Action var3 = null;
        switch(var1) {
        case OPEN_FILE:
            var3 = ClickEvent.Action.OPEN_FILE;
            break;
        case RUN_COMMAND:
            var3 = ClickEvent.Action.RUN_COMMAND;
        }

        return (ClickEventBridge)(new ClickEvent(var3, var2));
    }

    public HoverEventBridge initChatHoverEvent(HoverEventAction var1, IChatComponentBridge var2) {
        HoverEvent.Action var3 = null;
        switch(var1) {
        case SHOW_TEXT:
            var3 = HoverEvent.Action.SHOW_TEXT;
        default:
            return (HoverEventBridge)(new HoverEvent(var3, (IChatComponent)var2));
        }
    }

    public ItemStackBridge initItemStack(ItemBridge var1) {
        return (ItemStackBridge)(new ItemStack((Item)var1));
    }

    public ItemStackBridge initItemStack(BlockBridge var1) {
        return (ItemStackBridge)(new ItemStack((Block) var1));
    }

    public ItemStackBridge initEmptyItemStack() {
        return (ItemStackBridge)(new ItemStack(Blocks.air));
    }

    public List<BossStatusBridge> getBossStatus() {
        return ImmutableList.of(new BossStatusImplementation());
    }

    public PacketBufferBridge initPacketBuffer(ByteBuf var1) {
        return (PacketBufferBridge)(new PacketBuffer(var1));
    }

    public C17PacketCustomPayloadBridge initCustomPayload(String var1, PacketBufferBridge var2) {
        return (C17PacketCustomPayloadBridge)(new C17PacketCustomPayload(var1, (PacketBuffer)var2));
    }

    public Vec3Bridge initVec3d(double var1, double var3, double var5) {
        return (Vec3Bridge)(new Vec3(var1, var3, var5));
    }

    public BlockBridge bridge$getBlockFromItem(ItemBridge var1) {
        return (BlockBridge)Block.getBlockFromItem((Item)var1);
    }

    public ScoreboardBridge initScoreboard() {
        return (ScoreboardBridge)(new Scoreboard());
    }

    public ScoreObjectiveBridge initDummyScoreObjective(ScoreboardBridge var1, String var2) {
        return (ScoreObjectiveBridge)(new ScoreObjective((Scoreboard)var1, var2, IScoreObjectiveCriteria.DUMMY));
    }

    public AxisAlignedBBBridge initAABB(double var1, int var3, double var4, double var6, int var8, double var9) {
        return (AxisAlignedBBBridge)(new AxisAlignedBB(var1, var3, var4, var6, var8, var9));
    }

    public LunarBorder initLCBorder(String var1, String var2, int var3) {
        return new LunarWorldBorder(var1, var2, var3);
    }

    public AbstractTextureBridge initCustomTexture(CustomTextureBridge var1) {
        return new CustomTextureHolderImplementation(var1);
    }

    public AbstractTextureBridge initTickingTexture(TickingTexture var1) {
        return new TickingTextureImplementation(var1);
    }

    public EntityPlayerSPBridge initDummyPlayer() {
        NetHandlerPlayClientWrapper var1 = new NetHandlerPlayClientWrapper(Minecraft.getMinecraft());
        return (EntityPlayerSPBridge)(new DummyPlayerWrapper(Minecraft.getMinecraft(), new WorldClientWrapper(var1), var1, new StatFileWriter()));
    }

    public MovementInputBridge initMovementInput(GameSettingsBridge var1) {
        return (MovementInputBridge)(new MovementInputFromOptions((GameSettings)var1));
    }

    public ServerDataBridge initServerData(String var1, String var2, boolean var3) {
        return (ServerDataBridge)(new ServerData(var1, var2, var3));
    }

    public GeometryTessellator getGeometryTessellator() {
        return TesselatorImplementation.paepeppsehahahaeeppsssesp();
    }

    public ModelCloak initModelCloak(int var1) {
        return ModelCloakImplementation.createDefault(22, 17);
    }

    public ModelCloak initModelCloak(int var1, int var2, int var3) {
        return ModelCloakImplementation.createDefault(var2, var3);
    }

    public OldServerPingerBridge initOldServerPinger() {
        return (OldServerPingerBridge)(new OldServerPinger());
    }
}
