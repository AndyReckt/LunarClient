package com.moonsworth.lunar.client.util;

import com.moonsworth.lunar.bridge.minecraft.scoreboard.ScoreObjectiveBridge;
import com.moonsworth.lunar.bridge.minecraft.scoreboard.ScorePlayerTeamBridge;
import com.moonsworth.lunar.bridge.minecraft.scoreboard.ScoreboardBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.ref.Ref;
import org.apache.commons.lang3.text.WordUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class FriendStatusUtil {
    public static final Pattern lIlIlIlIlIIlIIlIIllIIIIIl = Pattern.compile("(.+) <- (?:.+)");
    public static final Map<String, String> IPS = new HashMap<>();
    public static final Pattern COLOR_CODES;
    public static String llIlllIIIllllIIlllIllIIIl;

    public static String lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        for (Map.Entry<String, String> entry : IPS.entrySet()) {
            if (!string.endsWith(entry.getKey())) continue;
            return entry.getValue();
        }
        return string;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl() {
        if (Ref.getPlayer() == null || Ref.getMinecraft().bridge$getCurrentServerData() == null) {
            llIlllIIIllllIIlllIllIIIl = null;
            return;
        }
        if (!Ref.getMinecraft().bridge$getCurrentServerData().bridge$serverIP().toLowerCase().endsWith("hypixel.net")) {
            llIlllIIIllllIIlllIllIIIl = null;
            return;
        }
        String string = FriendStatusUtil.lIllIlIIIlIIIIIIIlllIlIll();
        if (string == null) {
            llIlllIIIllllIIlllIllIIIl = null;
            return;
        }
        llIlllIIIllllIIlllIllIIIl = WordUtils.capitalize(FriendStatusUtil.IlllIIIIIIlllIlIIlllIlIIl(string).toLowerCase(), null);
    }

    public static String IlllIIIIIIlllIlIIlllIlIIl(String string) {
        if ((string = COLOR_CODES.matcher(string).replaceAll("")).equalsIgnoreCase("skyblock co-op")) {
            return "SKYBLOCK";
        }
        return string;
    }

    public static String lIllIlIIIlIIIIIIIlllIlIll() {
        ScoreboardBridge scoreboardBridge = Ref.getMinecraft().bridge$getWorld().bridge$getScoreboard();
        ScoreObjectiveBridge scoreObjectiveBridge2 = null;
        ScorePlayerTeamBridge scorePlayerTeamBridge = scoreboardBridge.bridge$getPlayersTeam(Ref.getMinecraft().bridge$getPlayer().bridge$getName());
        if (scorePlayerTeamBridge != null) {
            int n = scorePlayerTeamBridge.bridge$getChatFormat().llllIIlIIlIIlIIllIIlIIllI();
            if (Bridge.getMinecraftVersion() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl) {
                scoreObjectiveBridge2 = scoreboardBridge.bridge$getObjectiveInDisplaySlot(1);
            } else if (n >= 0) {
                try {
                    scoreObjectiveBridge2 = scoreboardBridge.bridge$getObjectiveInDisplaySlot(3 + n);
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    // empty catch block
                }
            }
        }
        ScoreObjectiveBridge scoreObjectiveBridge = scoreObjectiveBridge2 != null ? scoreObjectiveBridge2 : scoreboardBridge.bridge$getObjectiveInDisplaySlot(1);
        if (scoreObjectiveBridge == null) {
            return null;
        }
        return scoreObjectiveBridge.bridge$getDisplayName();
    }

    public static boolean lIllIlIIIlIIIIIIIlllIlIll(String string) {
        return llIlllIIIllllIIlllIllIIIl != null && llIlllIIIllllIIlllIllIIIl.equalsIgnoreCase(string);
    }

    public static boolean lIlIlIlIlIIlIIlIIllIIIIIl(KnownServerPMC knownServerPMC) {
        if (Ref.getMinecraft().bridge$getPlayer() != null && Ref.getMinecraft().bridge$getPlayer().bridge$getClientBrand().isPresent()) {
            String string = Ref.getMinecraft().bridge$getPlayer().bridge$getClientBrand().get();
            if (Bridge.getMinecraftVersion().lIllIlIIIlIIIIIIIlllIlIll()) {
                return string.startsWith(knownServerPMC.lIlIlIlIlIIlIIlIIllIIIIIl());
            }
            Matcher matcher = lIlIlIlIlIIlIIlIIllIIIIIl.matcher(string);
            if (matcher.find()) {
                return matcher.group(1).startsWith(knownServerPMC.lIlIlIlIlIIlIIlIIllIIIIIl());
            }
        }
        return false;
    }

    public FriendStatusUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String IlllIIIIIIlllIlIIlllIlIIl() {
        return llIlllIIIllllIIlllIllIIIl;
    }

    static {
        IPS.put("hypixel.net", "Hypixel Network");
        IPS.put("lunar.gg", "Lunar Network");
        IPS.put("minemen.club", "Minemen Club");
        IPS.put("mineman.club", "Minemen Club");
        IPS.put("mineplex.com", "Mineplex Network");
        IPS.put("vipermc.net", "ViperMC Network");
        IPS.put("holypvp.net", "HolyHCF Network");
        COLOR_CODES = Pattern.compile("(?i)§[0-9A-FK-OR]");
    }
}