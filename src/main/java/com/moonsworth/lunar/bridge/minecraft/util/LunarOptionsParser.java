package com.moonsworth.lunar.bridge.minecraft.util;

import com.google.common.primitives.Ints;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class LunarOptionsParser {
    public static final KeyVersionPair lIlIlIlIlIIlIIlIIllIIIIIl;
    public static final Map IlllIIIIIIlllIlIIlllIlIIl;
    public static final Map lIllIlIIIlIIIIIIIlllIlIll;
    public static final Map llIlllIIIllllIIlllIllIIIl;
    public static JsonObject llllIIlIIlIIlIIllIIlIIllI;

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(File var0) {
        try {
            File var1 = new File(var0, "optionsLC.txt");
            if (!var1.exists()) {
                return;
            }

            JsonParser var2 = new JsonParser();
            JsonElement var3 = var2.parse(new FileReader(var1));
            if (var3.isJsonObject()) {
                llllIIlIIlIIlIIllIIlIIllI = var3.getAsJsonObject();
                LunarLogger.debug("Loaded File: Options");
            }
        } catch (Exception var4) {
            LunarLogger.error("Couldn't load file [" + var4.getMessage() + "]");
            var4.printStackTrace();
        }

    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl() {
        try {
            File var0 = new File(Ref.getMinecraft().bridge$getMcDataDir(), "optionsLC.txt");
            if (!var0.exists() && !var0.createNewFile()) {
                LunarLogger.warn("Saving", "Failed to create save file!");
                return;
            }

            FileWriter var1 = new FileWriter(var0);
            Throwable var2 = null;

            try {
                LunarClient.GSON.toJson(llllIIlIIlIIlIIllIIlIIllI, var1);
                LunarLogger.debug("Saved File: Options");
            } catch (Throwable var12) {
                var2 = var12;
                throw var12;
            } finally {
                if (var1 != null) {
                    if (var2 != null) {
                        try {
                            var1.close();
                        } catch (Throwable var11) {
                            var2.addSuppressed(var11);
                        }
                    } else {
                        var1.close();
                    }
                }

            }
        } catch (IOException var14) {
            var14.printStackTrace();
        }

    }

    public static String[] lIlIlIlIlIIlIIlIIllIIIIIl(String var0, String var1) {
        if (llllIIlIIlIIlIIllIIlIIllI.has(var0) && !llllIIlIIlIIlIIllIIlIIllI.get(var0).isJsonNull()) {
            var1 = llllIIlIIlIIlIIllIIlIIllI.get(var0).getAsString();
        }

        if (var0.startsWith("chatOpacity")) {
            return new String[] {var0, Math.max(0.4D, lIlIlIlIlIIlIIlIIllIIIIIl(var1)) + ""};
        } else {
            return var0.startsWith("key_") && Ints.tryParse(var1) != null ? new String[] {var0, IlllIIIIIIlllIlIIlllIlIIl(Ints.tryParse(var1))} : new String[] {var0, var1};
        }
    }

    public static String[] lIlIlIlIlIIlIIlIIllIIIIIl(String[] var0) {
        String var1 = var0[0];
        String var2 = var0.length >= 2 ? var0[1] : "";
        if (llllIIlIIlIIlIIllIIlIIllI.has(var1) && !llllIIlIIlIIlIIllIIlIIllI.get(var1).isJsonNull()) {
            var2 = IlllIIIIIIlllIlIIlllIlIIl().get(var1).getAsString();
        }

        if (var1.startsWith("chatOpacity")) {
            return new String[] {var1, Math.max(0.4D, lIlIlIlIlIIlIIlIIllIIIIIl(var2)) + ""};
        } else {
            return var1.startsWith("key_") && Ints.tryParse(var2) == null ? new String[] {var1, llIlllIIIllllIIlllIllIIIl(var2) + ""} : new String[] {var1, var2};
        }
    }

    public static float lIlIlIlIlIIlIIlIIllIIIIIl(String var0) {
        return var0.equals("true") ? 1.0F : (var0.equals("false") ? 0.0F : Float.parseFloat(var0));
    }

    public static void IlllIIIIIIlllIlIIlllIlIIl(String var0) {
        String[] var1 = var0.split(":");
        String var2 = var1[0];
        String var3 = var1.length >= 2 ? var1[1] : "";
        llllIIlIIlIIlIIllIIlIIllI.addProperty(var2, var3);
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String var0, KeyType var1, int var2) {
        KeyVersionPair var3 = new KeyVersionPair(var0, var1, var2);
        IlllIIIIIIlllIlIIlllIlIIl.put(var0, var3);
        lIllIlIIIlIIIIIIIlllIlIll.put(var2, var3);
        llIlllIIIllllIIlllIllIIIl.put(var1, var3);
    }

    public static KeyType lIllIlIIIlIIIIIIIlllIlIll(String var0) {
        return ((KeyVersionPair)IlllIIIIIIlllIlIIlllIlIIl.getOrDefault(var0, lIlIlIlIlIIlIIlIIllIIIIIl)).IlllIIIIIIlllIlIIlllIlIIl();
    }

    public static KeyType lIlIlIlIlIIlIIlIIllIIIIIl(int var0) {
        return ((KeyVersionPair)lIllIlIIIlIIIIIIIlllIlIll.getOrDefault(var0, lIlIlIlIlIIlIIlIIllIIIIIl)).IlllIIIIIIlllIlIIlllIlIIl();
    }

    public static String lIlIlIlIlIIlIIlIIllIIIIIl(KeyType var0) {
        return ((KeyVersionPair)llIlllIIIllllIIlllIllIIIl.getOrDefault(var0, lIlIlIlIlIIlIIlIIllIIIIIl)).lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    public static String IlllIIIIIIlllIlIIlllIlIIl(int var0) {
        return ((KeyVersionPair)lIllIlIIIlIIIIIIIlllIlIll.getOrDefault(var0, lIlIlIlIlIIlIIlIIllIIIIIl)).lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    public static int IlllIIIIIIlllIlIIlllIlIIl(KeyType var0) {
        return ((KeyVersionPair)llIlllIIIllllIIlllIllIIIl.getOrDefault(var0, lIlIlIlIlIIlIIlIIllIIIIIl)).lIllIlIIIlIIIIIIIlllIlIll();
    }

    public static int llIlllIIIllllIIlllIllIIIl(String var0) {
        return ((KeyVersionPair)IlllIIIIIIlllIlIIlllIlIIl.getOrDefault(var0, lIlIlIlIlIIlIIlIIllIIIIIl)).lIllIlIIIlIIIIIIIlllIlIll();
    }

    public LunarOptionsParser() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static JsonObject IlllIIIIIIlllIlIIlllIlIIl() {
        return llllIIlIIlIIlIIllIIlIIllI;
    }

    static {
        lIlIlIlIlIIlIIlIIllIIIIIl = new KeyVersionPair("key.keyboard.unknown", KeyType.KEY_NONE, 0);
        IlllIIIIIIlllIlIIlllIlIIl = new HashMap();
        lIllIlIIIlIIIIIIIlllIlIll = new HashMap();
        llIlllIIIllllIIlllIllIIIl = new HashMap();
        llllIIlIIlIIlIIllIIlIIllI = new JsonObject();
        lIlIlIlIlIIlIIlIIllIIIIIl("key.mouse.left", KeyType.KEY_MOUSE1, -100);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.mouse.right", KeyType.KEY_MOUSE2, -99);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.mouse.middle", KeyType.KEY_MOUSE3, -98);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.mouse.4", KeyType.KEY_MOUSE4, -97);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.mouse.5", KeyType.KEY_MOUSE5, -96);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.0", KeyType.KEY_0, 11);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.1", KeyType.KEY_1, 2);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.2", KeyType.KEY_2, 3);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.3", KeyType.KEY_3, 4);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.4", KeyType.KEY_4, 5);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.5", KeyType.KEY_5, 6);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.6", KeyType.KEY_6, 7);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.7", KeyType.KEY_7, 8);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.8", KeyType.KEY_8, 9);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.9", KeyType.KEY_9, 10);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.a", KeyType.KEY_A, 30);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.b", KeyType.KEY_B, 48);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.c", KeyType.KEY_C, 46);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.d", KeyType.KEY_D, 32);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.e", KeyType.KEY_E, 18);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f", KeyType.KEY_F, 33);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.g", KeyType.KEY_G, 34);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.h", KeyType.KEY_H, 35);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.i", KeyType.KEY_I, 23);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.j", KeyType.KEY_J, 36);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.k", KeyType.KEY_K, 37);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.l", KeyType.KEY_L, 38);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.m", KeyType.KEY_M, 50);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.n", KeyType.KEY_N, 49);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.o", KeyType.KEY_O, 24);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.p", KeyType.KEY_P, 25);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.q", KeyType.KEY_Q, 16);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.r", KeyType.KEY_R, 19);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.s", KeyType.KEY_S, 31);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.t", KeyType.KEY_T, 20);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.u", KeyType.KEY_U, 22);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.v", KeyType.KEY_V, 47);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.w", KeyType.KEY_W, 17);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.x", KeyType.KEY_X, 45);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.y", KeyType.KEY_Y, 21);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.z", KeyType.KEY_Z, 44);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f1", KeyType.KEY_F1, 59);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f2", KeyType.KEY_F2, 60);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f3", KeyType.KEY_F3, 61);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f4", KeyType.KEY_F4, 62);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f5", KeyType.KEY_F5, 63);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f6", KeyType.KEY_F6, 64);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f7", KeyType.KEY_F7, 65);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f8", KeyType.KEY_F8, 66);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f9", KeyType.KEY_F9, 67);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f10", KeyType.KEY_F10, 68);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f11", KeyType.KEY_F11, 87);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f12", KeyType.KEY_F12, 88);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f13", KeyType.KEY_F13, 100);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f14", KeyType.KEY_F14, 101);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f15", KeyType.KEY_F15, 102);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f16", KeyType.KEY_F16, 103);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f17", KeyType.KEY_F17, 104);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f18", KeyType.KEY_F18, 105);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.f19", KeyType.KEY_F19, 113);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.num.lock", KeyType.KEY_NUMLOCK, 69);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.0", KeyType.KEY_NUMPAD0, 82);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.1", KeyType.KEY_NUMPAD1, 79);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.2", KeyType.KEY_NUMPAD2, 80);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.3", KeyType.KEY_NUMPAD3, 81);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.4", KeyType.KEY_NUMPAD4, 75);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.5", KeyType.KEY_NUMPAD5, 76);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.6", KeyType.KEY_NUMPAD6, 77);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.7", KeyType.KEY_NUMPAD7, 71);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.8", KeyType.KEY_NUMPAD8, 72);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.9", KeyType.KEY_NUMPAD9, 73);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.add", KeyType.KEY_ADD, 78);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.decimal", KeyType.KEY_DECIMAL, 83);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.enter", KeyType.KEY_NUMPADENTER, 156);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.equal", KeyType.KEY_NUMPADEQUALS, 141);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.multiply", KeyType.KEY_MULTIPLY, 55);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.divide", KeyType.KEY_DIVIDE, 181);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.keypad.subtract", KeyType.KEY_SUBTRACT, 74);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.down", KeyType.KEY_DOWN, 208);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.left", KeyType.KEY_LEFT, 203);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.right", KeyType.KEY_RIGHT, 205);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.up", KeyType.KEY_UP, 200);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.apostrophe", KeyType.KEY_APOSTROPHE, 40);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.backslash", KeyType.KEY_BACKSLASH, 43);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.comma", KeyType.KEY_COMMA, 51);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.equal", KeyType.KEY_EQUALS, 13);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.grave.accent", KeyType.KEY_GRAVE, 41);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.left.bracket", KeyType.KEY_LBRACKET, 26);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.minus", KeyType.KEY_MINUS, 12);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.period", KeyType.KEY_PERIOD, 52);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.right.bracket", KeyType.KEY_RBRACKET, 27);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.semicolon", KeyType.KEY_SEMICOLON, 39);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.slash", KeyType.KEY_SLASH, 53);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.space", KeyType.KEY_SPACE, 57);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.tab", KeyType.KEY_TAB, 15);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.left.alt", KeyType.KEY_LMENU, 56);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.left.control", KeyType.KEY_LCONTROL, 29);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.left.shift", KeyType.KEY_LSHIFT, 42);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.right.alt", KeyType.KEY_RMENU, 184);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.right.control", KeyType.KEY_RCONTROL, 157);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.right.shift", KeyType.KEY_RSHIFT, 54);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.enter", KeyType.KEY_RETURN, 28);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.escape", KeyType.KEY_ESCAPE, 1);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.backspace", KeyType.KEY_BACK, 14);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.delete", KeyType.KEY_DELETE, 211);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.end", KeyType.KEY_END, 207);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.home", KeyType.KEY_HOME, 199);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.insert", KeyType.KEY_INSERT, 210);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.caps.lock", KeyType.KEY_CAPITAL, 58);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.pause", KeyType.KEY_PAUSE, 197);
        lIlIlIlIlIIlIIlIIllIIIIIl("key.keyboard.scroll.lock", KeyType.KEY_SCROLL, 70);
    }
}
