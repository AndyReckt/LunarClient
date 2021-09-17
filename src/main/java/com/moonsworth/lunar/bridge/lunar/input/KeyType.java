package com.moonsworth.lunar.bridge.lunar.input;

import java.util.Arrays;

public enum KeyType {
    lIlIlIlIlIIlIIlIIllIIIIIl("KEY_NONE", 0),
    IlllIIIIIIlllIlIIlllIlIIl("KEY_0", 1),
    lIllIlIIIlIIIIIIIlllIlIll("KEY_1", 2),
    llIlllIIIllllIIlllIllIIIl("KEY_2", 3),
    llllIIlIIlIIlIIllIIlIIllI("KEY_3", 4),
    IlIlIlllllIlIIlIlIlllIlIl("KEY_4", 5),
    llIIIIIIIllIIllIlIllIIIIl("KEY_5", 6),
    lIIIllIllIIllIlllIlIIlllI("KEY_6", 7),
    IlllllIlIIIlIIlIIllIIlIll("KEY_7", 8),
    llIIlIlIIIllIlIlIlIIlIIll("KEY_8", 9),
    llIIIlllIIlllIllllIlIllIl("KEY_9", 10),
    lllllIllIllIllllIlIllllII("KEY_A", 11),
    lllIIIIIlllIIlIllIIlIIIlI("KEY_B", 12),
    lIlIIIIIIlIIIllllIllIIlII("KEY_C", 13),
    llIlIIIllIIlIllIllIllllIl("KEY_D", 14),
    IllIllIIIllIIIlIlIlIIIIll("KEY_E", 15),
    IIlIllIlllllllIIlIIIllIIl("KEY_F", 16),
    lIIlIlllIlIlIIIlllIIlIIII("KEY_G", 17),
    llIllIlIllIlllIllIIIIllII("KEY_H", 18),
    IllllllllllIlIIIlllIlllll("KEY_I", 19),
    lllllIllIlIIlIIlIIIlllIlI("KEY_J", 20),
    IllIIIlllIIIlIlllIlIIlIII("KEY_K", 21),
    IIlIllIlIIllIIlIlIllllllI("KEY_L", 22),
    lIIIlllIIIIllllIlIIIlIIll("KEY_M", 23),
    llIIIlIllIIIIlIIIlIlIllIl("KEY_N", 24),
    llllIlIllllIlIlIIIllIlIlI("KEY_O", 25),
    IlIllIIlIIlIIIllIllllIIll("KEY_P", 26),
    lIllllIllIIlIIlIIIlIIIlII("KEY_Q", 27),
    lIlIlIIIIIIllIlIIIIllIIII("KEY_R", 28),
    lIIlIIIIIIlIIlIIllIlIIlII("KEY_S", 29),
    IlIIlIIlIIlIIllIIIllIIllI("KEY_T", 30),
    IIlIlIIIllIIllllIllllIlIl("KEY_U", 31),
    lllllIIIIlIlllIllIIIlIIlI("KEY_V", 32),
    IIlllIllIlIllIllIIllIlIIl("KEY_W", 33),
    lIlIIlIlllIIlIIIlIlIlIllI("KEY_X", 34),
    lIIlllIIIIIlllIIIlIlIlllI("KEY_Y", 35),
    IIIlIIIIIIllIIIIllIIIIlII("KEY_Z", 36),
    IlIIIlIlIlIlIlIllIIllIIlI("KEY_RSHIFT", 37),
    IlIlIllIIllllIllllllIIlIl("KEY_LSHIFT", 38),
    lIIlIIlllIIIIlIlllIIIIlll("KEY_FUNCTION", 39),
    llIllIIIIlIIIIIIlllIllIlI("KEY_LCONTROL", 40),
    lIlIIIIIllIIlIIlIIlIlIIlI("KEY_RCONTROL", 41),
    IIllIlIllIlIllIllIllIllII("KEY_LCOMMAND", 42),
    IlIlllIlIlllIllIIIIIIlllI("KEY_RCOMMAND", 43),
    llllIlIlIIIllllIIlIllIlII("KEY_LWINDOWS", 44),
    llIIIllllIIIllIIIIlIlIlll("KEY_RWINDOWS", 45),
    IIIIIIIIIIIIIIIllllIIlIIl("KEY_CLEAR", 46),
    llIIIIllIlIIlIlIIlllIllIl("KEY_LMENU", 47),
    IIIIlIllIllIlIIIIIlIlIlIl("KEY_RMENU", 48),
    IlIlIlIlIIIlIIlIIlllIllIl("KEY_RETURN", 49),
    lIIIlIllllIIlIIlIIlIIIIlI("KEY_ESCAPE", 50),
    lllllIlIllIlIlllIIIlIIlIl("KEY_GRAVE", 51),
    IllIlIIllIIlllIIllIlIlIII("KEY_TAB", 52),
    IlIlllIIIIIllIIllIllIIlll("KEY_UP", 53),
    IllllIIllllIllIIIIlllllII("KEY_BACK", 54),
    IIllllIIlllIlIIlIIlllIlII("KEY_LEFT", 55),
    IllIlIIlllIIlIIllIIIIIIIl("KEY_RIGHT", 56),
    IllIllIllIIlIlllIIlllIIll("KEY_HOME", 57),
    IlIIIIlllIllllIlIlIllIlII("KEY_PGUP", 58),
    lIlIIIlIIlIIIlIIIlllIlIII("KEY_PGDOWN", 59),
    IlIllIIlIIlIlIIlIIlIllIll("KEY_PG", 60),
    lIlllllIIlllIllIIlIIlIlll("KEY_END", 61),
    lIIlIIllIlIIlIIllIIIIlIIl("KEY_DELETE", 62),
    IllIIlllIllIlllllIlIllIll("KEY_F1", 63),
    IIIlIlIllIlIlIIIIIlIllIII("KEY_F2", 64),
    IIlllIllIIlllllIllllllIII("KEY_F3", 65),
    IlIlIIllllllIIlIIllIIllIl("KEY_F4", 66),
    IIllIIlIIIlIlIlIlIIllIllI("KEY_F5", 67),
    llIllllIlIIlIIIIllIllIIll("KEY_F6", 68),
    lIllIllIllIIIlllIIIlllllI("KEY_F7", 69),
    IlIIlllIIllIIlIlIlIlIIlll("KEY_F8", 70),
    IlllIIIlIllIIIlIIllllllIl("KEY_F9", 71),
    lllIIIIllIllIlIIlllIIllII("KEY_F10", 72),
    IlllllIlIlIlIIIIIllllIlIl("KEY_F11", 73),
    lIIllllIllIllllllllIlllII("KEY_F12", 74),
    lIlIIllIIIlIIIlIIIlIIlIll("KEY_DOWN", 75),
    llllIIlIllllllIIllIllIlII("KEY_SPACE", 76),
    IIlIIIlIlIlIlIllIlIlIIlll("KEY_MOUSE1", 77),
    IIIIlIIlIIIIllIlIlIIIlIlI("KEY_MOUSE2", 78),
    lIIIlIlIlIIlIllIIIIlllIlI("KEY_MOUSE3", 79),
    IIllIlIIllIIlIIllllIIllII("KEY_MOUSE4", 80),
    lIIIIIlIIIlIIIlIIlIIIIIlI("KEY_MOUSE5", 81),
    lIlllIlllIIIllIIIIIlIIllI("KEY_MINUS", 82),
    IIIIlIIIIIllllIlllllllIIl("KEY_EQUALS", 83),
    lIIlllIIIIlIIIIllIIlllllI("KEY_LBRACKET", 84),
    lIIIIllIIIllllllllIIlllIl("KEY_RBRACKET", 85),
    IIIIlIIlIIIlllllIlllIIlII("KEY_SEMICOLON", 86),
    IlIlIIlIllllIllIIlIlIllII("KEY_APOSTROPHE", 87),
    IIIIlllIlIIlllllIIllIIIII("KEY_BACKSLASH", 88),
    lIIIllIIIlIlIlIIlIIlllIlI("KEY_COMMA", 89),
    llIIlIIIllllIIIllIIIIIIll("KEY_PERIOD", 90),
    llIIlllIllIIIlIlIlllIlIII("KEY_SLASH", 91),
    IIIllIlIllIIllIlIlllIllIl("KEY_MULTIPLY", 92),
    IIIlIIIlIIIlIlllIIIlIlIIl("KEY_CAPITAL", 93),
    IlllIIlIIIllllIIlIlIlIIII("KEY_NUMLOCK", 94),
    IlIIIllIlIlIlIIllIlIIlIII("KEY_SCROLL", 95),
    IIIIIIIIIIIIIIIIlIllIlllI("KEY_PRINTSC", 96),
    lIlllIIIIllIIIIIllIIllIIl("KEY_NUMPAD7", 97),
    IlIIlIlIlIlIIlIlIIIIlIIll("KEY_NUMPAD8", 98),
    lIIllIIIIllllIlIIIIlIlIIl("KEY_NUMPAD9", 99),
    IlIIIIIIIIlIIllllIlIllllI("KEY_SUBTRACT", 100),
    IIlllIIIIIIIIIIllllIlIIlI("KEY_NUMPAD4", 101),
    lIllIIIIlllIlllIIIlIllIIl("KEY_NUMPAD5", 102),
    lIIlIIIlIIIlIlllIllIlIIll("KEY_NUMPAD6", 103),
    IIllIllllIIlllIlIIIIIIlll("KEY_ADD", 104),
    lIIIlIlIlIIlIllIIllIlllIl("KEY_NUMPAD1", 105),
    lIIllIlllIIIlIlllIIIIIlIl("KEY_NUMPAD2", 106),
    lIlIlIIlIIIlIllIllIIlIIIl("KEY_NUMPAD3", 107),
    lIIIlllIlIlIIIlIIIlIlIIII("KEY_NUMPAD0", 108),
    lIlIlllIllIlIIIIllllIIllI("KEY_DECIMAL", 109),
    IIllllIlllIIllIllIIIlllll("KEY_F13", 110),
    lIlIIllIIIlllIllIllIIIlIl("KEY_F14", 111),
    llIIllIIlllIIIIlIIIIIIllI("KEY_F15", 112),
    IIIlIIllIlIIIllIlIIIIIIlI("KEY_F16", 113),
    IlIlllllIIIIlllIlIIlIIIll("KEY_F17", 114),
    llllIIlIIIlIlllIIllllIlIl("KEY_F18", 115),
    IlIIIIIIIIIlllIIllllIlIll("KEY_F19", 116),
    IlIIIIIlIIllIIlIllllllllI("KEY_NUMPADEQUALS", 117),
    IIllIIIIIIlIlIIlllllIIIIl("KEY_NUMPADENTER", 118),
    lllIlIIIllllllIIllIlIlllI("KEY_DIVIDE", 119),
    lIlIIIllIIllIIllIlllIIlIl("KEY_PAUSE", 120),
    lIlllIllIlIIIIIlIllllIlll("KEY_INSERT", 121);

    // todo remap above and replace with this#name()
    String nameProxy;

    KeyType(final String s, final int n) {
        this.nameProxy = s;
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        String name;
        if (!nameProxy.contains("_")) {
            name = nameProxy;
        }
        else {
            name = nameProxy.split("_")[1];
        }
        String s = name.replace("MENU", "ALT");
        if (s.contains("META")) {
            if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                s = s.replace("META", "COMMAND");
            }
            else {
                s = s.replace("META", "WINDOWS");
            }
        }
        return s.toUpperCase();
    }

    // todo
    public KeyType valueOfPassThrough(String a) {
        return Arrays.stream(values()).filter(v -> v.nameProxy.equals(a)).findFirst().get();
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.name().startsWith("KEY_MOUSE");
    }
}