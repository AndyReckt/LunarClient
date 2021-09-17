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
import com.moonsworth.lunar.client.setting.AbstractFeatureSetting;
import com.moonsworth.lunar.client.setting.BindableSetting;
import com.moonsworth.lunar.client.setting.KeyBind;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;
import com.moonsworth.lunar.client.websocket.assets.AbstractWebSocketPacket;

import java.util.Iterator;
import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 14:07
 */
public class Ref {
    public static MinecraftBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return Bridge.llllIIlIIlIIlIIllIIlIIllI();
    }

    public static LunarClient IlllIIIIIIlllIlIIlllIlIIl() {
        return LunarClient.IIllIlIllIlIllIllIllIllII();
    }

    public static Optional getAssetsWebsocket() {
        return Optional.ofNullable(Ref.IlllIIIIIIlllIlIIlllIlIIl().IlllllIlIIIlIIlIIllIIlIll());
    }

    public static boolean llIlllIIIllllIIlllIllIIIl() {
        return Ref.getAssetsWebsocket().isPresent() && ((AssetsWebSocket) Ref.getAssetsWebsocket().get()).IlllIIIIIIlllIlIIlllIlIIl();
    }

    public static boolean llllIIlIIlIIlIIllIIlIIllI() {
        return Ref.lIlIlIlIlIIlIIlIIllIIIIIl(UsedEnum.ALL);
    }

    public static boolean lIlIlIlIlIIlIIlIIllIIIIIl(UsedEnum lIlIlIlIlIIlIIlIIllIIIIIl2) {
        return Ref.IlllIIIIIIlllIlIIlllIlIIl() != null && Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI() != null && Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IlllllIlIIIlIIlIIllIIlIll().llIlllIIIllllIIlllIllIIIl() && ((Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl()).equals(UsedEnum.ALL) || (Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl()).equals(lIlIlIlIlIIlIIlIIllIIIIIl2));
    }

    public static EntityPlayerSPBridge IlIlIlllllIlIIlIlIlllIlIl() {
        return Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getPlayer();
    }

    public static WorldClientBridge llIIIIIIIllIIllIlIllIIIIl() {
        return Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getWorld();
    }

    public static NetHandlerPlayClientBridge lIIIllIllIIllIlllIlIIlllI() {
        return Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getNetHandler();
    }

    public static FontRendererBridge IlllllIlIIIlIIlIIllIIlIll() {
        return Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getFontRenderer();
    }

    public static SkyblockWrapperBridge llIIlIlIIIllIlIlIlIIlIIll() {
        return Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractWebSocketPacket abstractWebSocketPacket) {
        Ref.getAssetsWebsocket().ifPresent(assetsWebSocket -> assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(abstractWebSocketPacket));
    }

    public static Class llIIIlllIIlllIllllIlIllIl() {
        return Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen() == null ? null : (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge ? (((WrappedGuiScreenBridge) Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen()).getCustomScreen() instanceof MainMenuUIWrapper ? ((MainMenuUIWrapper) ((WrappedGuiScreenBridge) Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen()).getCustomScreen()).llIIIIIIIllIIllIlIllIIIIl().getClass() : ((WrappedGuiScreenBridge) Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen()).getCustomScreen().getClass()) : Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen().getClass());
    }

    public static RenderManagerBridge lllllIllIllIllllIlIllllII() {
        return Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getRenderManager();
    }

    public static long lllIIIIIlllIIlIllIIlIIIlI() {
        return System.nanoTime() / 1000000L;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String string, boolean bl) {
        if (Ref.IlIlIlllllIlIIlIlIlllIlIl() == null) {
            return;
        }
        ChatComponentTextBridge chatComponentTextBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initChatText(string);
        System.out.println(string);
        if (bl) {
            ChatComponentTextBridge chatComponentTextBridge2 = Bridge.llIlllIIIllllIIlllIllIIIl().initChatText(EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "[" + EnumChatColor.lllllIllIllIllllIlIllllII + "LC" + EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "] ");
            chatComponentTextBridge2.bridge$appendSibling(chatComponentTextBridge);
            chatComponentTextBridge = chatComponentTextBridge2;
        }
        Ref.IlIlIlllllIlIIlIlIlllIlIl().bridge$addChatMessage(chatComponentTextBridge);
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl(string, true);
    }

    public static boolean lIlIIIIIIlIIIllllIllIIlII() {
        return Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentServerData() != null && "lunar".equals(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentServerData().getLunarServer());
    }

    public static void llIlIIIllIIlIllIllIllllIl() {
        int n;
        if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings() == null) {
            return;
        }
        LunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl.forEach(lunarKeybindSetting -> lunarKeybindSetting.llIIIIIIIllIIllIlIllIIIIl().clear());
        BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.keySet().forEach(bindableSetting -> bindableSetting.llIIIIIIIllIIllIlIllIIIIl().clear());
        for (KeyBindingBridge object2 : Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$getKeyBindings()) {
            object2.bridge$getClashesWith().clear();
        }
        for (LunarKeybindSetting lunarKeybindSetting2 : LunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl) {
            if (!lunarKeybindSetting2.llllIIlIIlIIlIIllIIlIIllI()) continue;
            n = 1;
            for (AbstractFeatureSetting abstractFeatureSetting : LunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!((LunarKeybindSetting) abstractFeatureSetting).llllIIlIIlIIlIIllIIlIIllI() || ((KeyBind) abstractFeatureSetting.llIlllIIIllllIIlllIllIIIl()).llIlllIIIllllIIlllIllIIIl() == KeyType.lIlIlIlIlIIlIIlIIllIIIIIl || lunarKeybindSetting2 == abstractFeatureSetting || !lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().equals(abstractFeatureSetting.llIlllIIIllllIIlllIllIIIl()))
                    continue;
                n = 0;
                abstractFeatureSetting.lIllIlIIIlIIIIIIIlllIlIll(false);
                abstractFeatureSetting.llIIIIIIIllIIllIlIllIIIIl().add(lunarKeybindSetting2.f_());
            }
            for (AbstractFeatureSetting abstractFeatureSetting : BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.keySet()) {
                if (abstractFeatureSetting.llIlllIIIllllIIlllIllIIIl().equals(KeyType.lIlIlIlIlIIlIIlIIllIIIIIl.name()) || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() || !abstractFeatureSetting.llIlllIIIllllIIlllIllIIIl().equals(lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().name()))
                    continue;
                abstractFeatureSetting.lIllIlIIIlIIIIIIIlllIlIll(false);
                n = 0;
                abstractFeatureSetting.llIIIIIIIllIIllIlIllIIIIl().add(lunarKeybindSetting2.f_());
            }
            for (KeyBindingBridge keyBindingBridge : Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$getKeyBindings()) {
                if (keyBindingBridge.bridge$getCategory().equals("replaymod.title") || keyBindingBridge.bridge$getKey() == KeyType.lIlIlIlIlIIlIIlIIllIIIIIl || BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.containsValue(keyBindingBridge) || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() || !keyBindingBridge.bridge$getKey().equals(lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl()))
                    continue;
                n = 0;
                keyBindingBridge.bridge$getClashesWith().add(lunarKeybindSetting2.f_());
            }
            lunarKeybindSetting2.lIllIlIIIlIIIIIIIlllIlIll(n != 0);
        }
        for (BindableSetting bindableSetting2 : BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.keySet()) {
            n = 1;
            for (BindableSetting bindableSetting3 : BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.keySet()) {
                if (bindableSetting3.llIlllIIIllllIIlllIllIIIl().equals(KeyType.lIlIlIlIlIIlIIlIIllIIIIIl.name()) || bindableSetting2 == bindableSetting3 || !bindableSetting2.llIlllIIIllllIIlllIllIIIl().equals(bindableSetting3.llIlllIIIllllIIlllIllIIIl()))
                    continue;
                n = 0;
                bindableSetting3.lIllIlIIIlIIIIIIIlllIlIll(false);
                bindableSetting3.llIIIIIIIllIIllIlIllIIIIl().add(bindableSetting2.f_());
            }
            for (LunarKeybindSetting lunarKeybindSetting2 : LunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!lunarKeybindSetting2.llllIIlIIlIIlIIllIIlIIllI() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl() == KeyType.lIlIlIlIlIIlIIlIIllIIIIIl || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() || lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() || !lunarKeybindSetting2.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().name().equals(bindableSetting2.llIlllIIIllllIIlllIllIIIl()))
                    continue;
                n = 0;
                lunarKeybindSetting2.lIllIlIIIlIIIIIIIlllIlIll(false);
                lunarKeybindSetting2.llIIIIIIIllIIllIlIllIIIIl().add(bindableSetting2.f_());
            }
            for (KeyBindingBridge keyBindingBridge : Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$getKeyBindings()) {
                if (keyBindingBridge.bridge$getCategory().equals("replaymod.title") || keyBindingBridge.bridge$getKey() == KeyType.lIlIlIlIlIIlIIlIIllIIIIIl || BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.containsValue(keyBindingBridge) || !keyBindingBridge.bridge$getKey().name().equals(bindableSetting2.llIlllIIIllllIIlllIllIIIl()))
                    continue;
                n = 0;
                keyBindingBridge.bridge$getClashesWith().add(bindableSetting2.f_());
            }
            bindableSetting2.lIllIlIIIlIIIIIIIlllIlIll(n != 0);
        }
        for (KeyBindingBridge keyBindingBridge : Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$getKeyBindings()) {
            if (keyBindingBridge.bridge$getCategory().equals("replaymod.title") || BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.containsValue(keyBindingBridge))
                continue;
            for (BindableSetting bindableSetting4 : BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.keySet()) {
                if (bindableSetting4.llIlllIIIllllIIlllIllIIIl().equals(KeyType.lIlIlIlIlIIlIIlIIllIIIIIl.name()) || !keyBindingBridge.bridge$getKey().name().equals(bindableSetting4.llIlllIIIllllIIlllIllIIIl()))
                    continue;
                bindableSetting4.lIllIlIIIlIIIIIIIlllIlIll(false);
                bindableSetting4.llIIIIIIIllIIllIlIllIIIIl().add(keyBindingBridge.bridge$getKeyDescription());
            }
            for (LunarKeybindSetting lunarKeybindSetting3 : LunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!lunarKeybindSetting3.llllIIlIIlIIlIIllIIlIIllI() || lunarKeybindSetting3.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl() == KeyType.lIlIlIlIlIIlIIlIIllIIIIIl || lunarKeybindSetting3.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() || lunarKeybindSetting3.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() || lunarKeybindSetting3.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() || lunarKeybindSetting3.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl() != keyBindingBridge.bridge$getKey())
                    continue;
                lunarKeybindSetting3.lIllIlIIIlIIIIIIIlllIlIll(false);
                lunarKeybindSetting3.llIIIIIIIllIIllIlIllIIIIl().add(keyBindingBridge.bridge$getKeyDescription());
            }
            for (KeyBindingBridge iterator : Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$getKeyBindings()) {
                if (iterator.bridge$getKey() == KeyType.lIlIlIlIlIIlIIlIIllIIIIIl || iterator.bridge$getCategory().equals("replaymod.title") || BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.containsValue(iterator) || iterator.bridge$getKeyDescription().equals(keyBindingBridge.bridge$getKeyDescription()) || !iterator.bridge$getKey().name().equals(keyBindingBridge.bridge$getKey().name()))
                    continue;
                iterator.bridge$getClashesWith().add(keyBindingBridge.bridge$getKeyDescription());
            }
        }
    }
}