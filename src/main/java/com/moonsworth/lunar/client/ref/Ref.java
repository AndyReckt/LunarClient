package com.moonsworth.lunar.client.ref;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.FontRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.WorldClientBridge;
import com.moonsworth.lunar.bridge.minecraft.client.network.NetHandlerPlayClientBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ChatComponentTextBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.UsedEnum;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.sba.SkyblockWrapperBridge;
import com.moonsworth.lunar.client.setting.BindableSetting;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuUIWrapper;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;
import com.moonsworth.lunar.client.websocket.packet.AbstractWebSocketPacket;

import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 14:07
 */
public class Ref {
    public static MinecraftBridge getMinecraft() {
        return Bridge.llllIIlIIlIIlIIllIIlIIllI();
    }

    public static LunarClient getLC() {
        return LunarClient.getInstance();
    }

    public static Optional<AssetsWebSocket> getAssetsWebsocket() {
        return Optional.ofNullable(Ref.getLC().IlllllIlIIIlIIlIIllIIlIll());
    }

    public static boolean isConnectedToWebSocket() {
        return Ref.getAssetsWebsocket().isPresent() && Ref.getAssetsWebsocket().get().IlllIIIIIIlllIlIIlllIlIIl();
    }

    public static boolean isGlobalDebug() {
        return Ref.lIlIlIlIlIIlIIlIIllIIIIIl(UsedEnum.ALL);
    }

    public static boolean lIlIlIlIlIIlIIlIIllIIIIIl(UsedEnum lIlIlIlIlIIlIIlIIllIIIIIl2) {
        return Ref.getLC() != null && Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI() != null && Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IlllllIlIIIlIIlIIllIIlIll().llIlllIIIllllIIlllIllIIIl() && ((Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl()).equals(UsedEnum.ALL) || (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl()).equals(lIlIlIlIlIIlIIlIIllIIIIIl2));
    }

    public static EntityPlayerSPBridge getPlayer() {
        return Ref.getMinecraft().bridge$getPlayer();
    }

    public static WorldClientBridge getWorld() {
        return Ref.getMinecraft().bridge$getWorld();
    }

    public static NetHandlerPlayClientBridge getNetHandler() {
        return Ref.getMinecraft().bridge$getNetHandler();
    }

    public static FontRendererBridge getFontRenderer() {
        return Ref.getMinecraft().bridge$getFontRenderer();
    }

    public static SkyblockWrapperBridge llIIlIlIIIllIlIlIlIIlIIll() {
        return Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractWebSocketPacket abstractWebSocketPacket) {
        Ref.getAssetsWebsocket().ifPresent(assetsWebSocket -> assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(abstractWebSocketPacket));
    }

    public static Class<?> llIIIlllIIlllIllllIlIllIl() {
        return Ref.getMinecraft().bridge$getCurrentScreen() == null ? null : (Ref.getMinecraft().bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge ? (((WrappedGuiScreenBridge) Ref.getMinecraft().bridge$getCurrentScreen()).getCustomScreen() instanceof MainMenuUIWrapper ? ((MainMenuUIWrapper) ((WrappedGuiScreenBridge) Ref.getMinecraft().bridge$getCurrentScreen()).getCustomScreen()).bruh().getClass() : ((WrappedGuiScreenBridge) Ref.getMinecraft().bridge$getCurrentScreen()).getCustomScreen().getClass()) : Ref.getMinecraft().bridge$getCurrentScreen().getClass());
    }

    public static RenderManagerBridge getRenderManager() {
        return Ref.getMinecraft().bridge$getRenderManager();
    }

    public static long lllIIIIIlllIIlIllIIlIIIlI() {
        return System.nanoTime() / 1000000L;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String string, boolean bl) {
        if (Ref.getPlayer() == null) {
            return;
        }
        ChatComponentTextBridge chatComponentTextBridge = Bridge.getInstance().initChatText(string);
        System.out.println(string);
        if (bl) {
            ChatComponentTextBridge chatComponentTextBridge2 = Bridge.getInstance().initChatText(EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "[" + EnumChatColor.lllllIllIllIllllIlIllllII + "LC" + EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "] ");
            chatComponentTextBridge2.bridge$appendSibling(chatComponentTextBridge);
            chatComponentTextBridge = chatComponentTextBridge2;
        }
        Ref.getPlayer().bridge$addChatMessage(chatComponentTextBridge);
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl(string, true);
    }

    public static boolean lIlIIIIIIlIIIllllIllIIlII() {
        return Ref.getMinecraft().bridge$getCurrentServerData() != null && "lunar".equals(Ref.getMinecraft().bridge$getCurrentServerData().getLunarServer());
    }

    public static void llIlIIIllIIlIllIllIllllIl() {
        int n;
        if (Ref.getMinecraft().bridge$getGameSettings() == null) {
            return;
        }
        LunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl.forEach(lunarKeybindSetting -> lunarKeybindSetting.llIIIIIIIllIIllIlIllIIIIl().clear());
        BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.keySet().forEach(bindableSetting -> bindableSetting.llIIIIIIIllIIllIlIllIIIIl().clear());
        for (KeyBindingBridge object2 : Ref.getMinecraft().bridge$getGameSettings().bridge$getKeyBindings()) {
            object2.bridge$getClashesWith().clear();
        }
        for (LunarKeybindSetting lunarKeybindSetting2 : LunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl) {
            if (!lunarKeybindSetting2.llllIIlIIlIIlIIllIIlIIllI()) continue;
            n = 1;
            for (LunarKeybindSetting abstractFeatureSetting : LunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!abstractFeatureSetting.llllIIlIIlIIlIIllIIlIIllI() || abstractFeatureSetting.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl() == KeyType.KEY_NONE || lunarKeybindSetting2 == abstractFeatureSetting || !lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().equals(abstractFeatureSetting.llIlllIIIllllIIlllIllIIIl()))
                    continue;
                n = 0;
                abstractFeatureSetting.lIllIlIIIlIIIIIIIlllIlIll(false);
                abstractFeatureSetting.llIIIIIIIllIIllIlIllIIIIl().add(lunarKeybindSetting2.f_());
            }
            for (BindableSetting abstractFeatureSetting : BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.keySet()) {
                if (abstractFeatureSetting.llIlllIIIllllIIlllIllIIIl().equals(KeyType.KEY_NONE.name()) || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() || !abstractFeatureSetting.llIlllIIIllllIIlllIllIIIl().equals(lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().name()))
                    continue;
                abstractFeatureSetting.lIllIlIIIlIIIIIIIlllIlIll(false);
                n = 0;
                abstractFeatureSetting.llIIIIIIIllIIllIlIllIIIIl().add(lunarKeybindSetting2.f_());
            }
            for (KeyBindingBridge keyBindingBridge : Ref.getMinecraft().bridge$getGameSettings().bridge$getKeyBindings()) {
                if (keyBindingBridge.bridge$getCategory().equals("replaymod.title") || keyBindingBridge.bridge$getKey() == KeyType.KEY_NONE || BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.containsValue(keyBindingBridge) || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() || !keyBindingBridge.bridge$getKey().equals(lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl()))
                    continue;
                n = 0;
                keyBindingBridge.bridge$getClashesWith().add(lunarKeybindSetting2.f_());
            }
            lunarKeybindSetting2.lIllIlIIIlIIIIIIIlllIlIll(n != 0);
        }
        for (BindableSetting bindableSetting2 : BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.keySet()) {
            n = 1;
            for (BindableSetting bindableSetting3 : BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.keySet()) {
                if (bindableSetting3.llIlllIIIllllIIlllIllIIIl().equals(KeyType.KEY_NONE.name()) || bindableSetting2 == bindableSetting3 || !bindableSetting2.llIlllIIIllllIIlllIllIIIl().equals(bindableSetting3.llIlllIIIllllIIlllIllIIIl()))
                    continue;
                n = 0;
                bindableSetting3.lIllIlIIIlIIIIIIIlllIlIll(false);
                bindableSetting3.llIIIIIIIllIIllIlIllIIIIl().add(bindableSetting2.f_());
            }
            for (LunarKeybindSetting lunarKeybindSetting2 : LunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!lunarKeybindSetting2.llllIIlIIlIIlIIllIIlIIllI() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl() == KeyType.KEY_NONE || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() || !lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().name().equals(bindableSetting2.llIlllIIIllllIIlllIllIIIl()))
                    continue;
                n = 0;
                lunarKeybindSetting2.lIllIlIIIlIIIIIIIlllIlIll(false);
                lunarKeybindSetting2.llIIIIIIIllIIllIlIllIIIIl().add(bindableSetting2.f_());
            }
            for (KeyBindingBridge keyBindingBridge : Ref.getMinecraft().bridge$getGameSettings().bridge$getKeyBindings()) {
                if (keyBindingBridge.bridge$getCategory().equals("replaymod.title") || keyBindingBridge.bridge$getKey() == KeyType.KEY_NONE || BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.containsValue(keyBindingBridge) || !keyBindingBridge.bridge$getKey().name().equals(bindableSetting2.llIlllIIIllllIIlllIllIIIl()))
                    continue;
                n = 0;
                keyBindingBridge.bridge$getClashesWith().add(bindableSetting2.f_());
            }
            bindableSetting2.lIllIlIIIlIIIIIIIlllIlIll(n != 0);
        }
        for (KeyBindingBridge keyBindingBridge : Ref.getMinecraft().bridge$getGameSettings().bridge$getKeyBindings()) {
            if (keyBindingBridge.bridge$getCategory().equals("replaymod.title") || BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.containsValue(keyBindingBridge))
                continue;
            for (BindableSetting bindableSetting4 : BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.keySet()) {
                if (bindableSetting4.llIlllIIIllllIIlllIllIIIl().equals(KeyType.KEY_NONE.name()) || !keyBindingBridge.bridge$getKey().name().equals(bindableSetting4.llIlllIIIllllIIlllIllIIIl()))
                    continue;
                bindableSetting4.lIllIlIIIlIIIIIIIlllIlIll(false);
                bindableSetting4.llIIIIIIIllIIllIlIllIIIIl().add(keyBindingBridge.bridge$getKeyDescription());
            }
            for (LunarKeybindSetting lunarKeybindSetting3 : LunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!lunarKeybindSetting3.llllIIlIIlIIlIIllIIlIIllI() || lunarKeybindSetting3.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl() == KeyType.KEY_NONE || lunarKeybindSetting3.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() || lunarKeybindSetting3.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() || lunarKeybindSetting3.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() || lunarKeybindSetting3.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl() != keyBindingBridge.bridge$getKey())
                    continue;
                lunarKeybindSetting3.lIllIlIIIlIIIIIIIlllIlIll(false);
                lunarKeybindSetting3.llIIIIIIIllIIllIlIllIIIIl().add(keyBindingBridge.bridge$getKeyDescription());
            }
            for (KeyBindingBridge iterator : Ref.getMinecraft().bridge$getGameSettings().bridge$getKeyBindings()) {
                if (iterator.bridge$getKey() == KeyType.KEY_NONE || iterator.bridge$getCategory().equals("replaymod.title") || BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.containsValue(iterator) || iterator.bridge$getKeyDescription().equals(keyBindingBridge.bridge$getKeyDescription()) || !iterator.bridge$getKey().name().equals(keyBindingBridge.bridge$getKey().name()))
                    continue;
                iterator.bridge$getClashesWith().add(keyBindingBridge.bridge$getKeyDescription());
            }
        }
    }
}