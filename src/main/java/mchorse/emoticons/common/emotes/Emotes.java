/*
 * Decompiled with CFR 0.150.
 */
package mchorse.emoticons.common.emotes;

import java.util.HashMap;
import java.util.Map;
import mchorse.emoticons.common.emotes.CryingEmote;
import mchorse.emoticons.common.emotes.DisgustedEmote;
import mchorse.emoticons.common.emotes.Emote;
import mchorse.emoticons.common.emotes.PopcornEmote;
import mchorse.emoticons.common.emotes.PureSaltEmote;
import mchorse.emoticons.common.emotes.RockPaperScissorsEmote;
import mchorse.emoticons.common.emotes.SneezeEmote;
import mchorse.emoticons.common.emotes.StarPowerEmote;
import mchorse.mclib.utils.Time;

public class Emotes {
    public static final Map EMOTES = new HashMap();

    public static boolean has(String string) {
        if (string.contains(":")) {
            string = string.split(":")[0];
        }
        return EMOTES.containsKey(string);
    }

    public static Emote get(String string) {
        if (string != null && string.contains(":")) {
            String[] arrstring = string.split(":");
            Emote emote = (Emote)EMOTES.get(arrstring[0]);
            return emote == null ? null : emote.getDynamicEmote(arrstring[1]);
        }
        Emote emote = (Emote)EMOTES.get(string);
        return emote == null ? null : emote.getDynamicEmote();
    }

    public static void register() {
        Emotes.register(new Emote("best_mates", 11, true));
        Emotes.register(new Emote("boneless", 40, true));
        Emotes.register(new Emote("default", 139, true));
        Emotes.register(new Emote("disco_fever", 175, true));
        Emotes.register(new Emote("electro_shuffle", 169, true));
        Emotes.register(new Emote("floss", 32, true));
        Emotes.register(new Emote("fresh", 101, true));
        Emotes.register(new Emote("gangnam_style", 18, true));
        Emotes.register(new Emote("hype", 68, true));
        Emotes.register(new Emote("infinite_dab", 19, true));
        Emotes.register(new Emote("orange_justice", 130, true));
        Emotes.register(new Emote("skibidi", 16, true));
        Emotes.register(new Emote("squat_kick", 232, true));
        Emotes.register(new StarPowerEmote("star_power", 160, true));
        Emotes.register(new Emote("l_dance", 16, true));
        Emotes.register(new Emote("tidy", 104, true));
        Emotes.register(new Emote("free_flow", 158, true));
        Emotes.register(new Emote("shimmer", 156, true));
        Emotes.register(new Emote("get_funky", 172, true));
        Emotes.register(new Emote("gun_lean", 144, true));
        Emotes.register(new Emote("boy", 29, false));
        Emotes.register(new Emote("bow", 43, false));
        Emotes.register(new Emote("calculated", 33, false));
        Emotes.register(new Emote("chicken", 19, true));
        Emotes.register(new Emote("clapping", 15, true));
        Emotes.register(new Emote("club", 20, true));
        Emotes.register(new Emote("confused", 140, false));
        Emotes.register(new CryingEmote("crying", 27, true));
        Emotes.register(new Emote("dab", 23, false));
        Emotes.register(new Emote("facepalm", 104, false));
        Emotes.register(new Emote("fist", 53, false));
        Emotes.register(new Emote("laughing", 15, true));
        Emotes.register(new Emote("no", 30, false));
        Emotes.register(new Emote("pointing", 33, false));
        Emotes.register(new PopcornEmote("popcorn", 102, true));
        Emotes.register(new PureSaltEmote("pure_salt", 104, false));
        Emotes.register(new RockPaperScissorsEmote("rock_paper_scissors", 60, false));
        Emotes.register(new Emote("salute", 50, false));
        Emotes.register(new Emote("shrug", 50, false));
        Emotes.register(new Emote("t_pose", 80, true));
        Emotes.register(new Emote("thinking", 100, true));
        Emotes.register(new Emote("twerk", 14, true){

            @Override
            public boolean renderCape() {
                return false;
            }

            @Override
            public boolean stopOnMove() {
                return true;
            }
        });
        Emotes.register(new Emote("wave", 40, false));
        Emotes.register(new Emote("yes", 23, false));
        Emotes.register(new Emote("bitchslap", Time.toTicks(100), false));
        Emotes.register(new Emote("bongo_cat", Time.toTicks(238), false));
        Emotes.register(new Emote("breathtaking", Time.toTicks(154), false));
        Emotes.register(new DisgustedEmote("disgusted", Time.toTicks(200), false));
        Emotes.register(new Emote("exhausted", Time.toTicks(330), true));
        Emotes.register(new Emote("punch", Time.toTicks(58), false));
        Emotes.register(new SneezeEmote("sneeze", Time.toTicks(200), false));
        Emotes.register(new Emote("threatening", Time.toTicks(70), false));
        Emotes.register(new Emote("woah", Time.toTicks(66), false));
        Emotes.register(new Emote("naruto_run", Time.toTicks(30), true));
        Emotes.register(new Emote("moonwalk", Time.toTicks(40), false));
        Emotes.register(new Emote("whip_and_nae_nae", Time.toTicks(235), false));
        Emotes.register(new Emote("hands_up", Time.toTicks(98), false));
        Emotes.register(new Emote("renegade", Time.toTicks(399), false));
        Emotes.register(new Emote("toosie_slide", Time.toTicks(285), true));
    }

    public static void register(Emote emote) {
        EMOTES.put(emote.name, emote);
    }
}

