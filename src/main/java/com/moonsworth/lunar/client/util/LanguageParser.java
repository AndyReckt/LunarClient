package com.moonsworth.lunar.client.util;

import com.moonsworth.lunar.bridge.lunar.lang.IlllIIIIIIlllIlIIlllIlIIl;

import java.text.Normalizer;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LanguageParser {
    public static final Pattern lIlIlIlIlIIlIIlIIllIIIIIl = Pattern.compile("(?<raw>[$%](?<id>\\d+)?(?<i18n>\\$[sdf])?(\\{(?<name>[a-zA-Z0-9]+)})?)");

    public static String lIlIlIlIlIIlIIlIIllIIIIIl(String string, Object ... objectArray) {
        String string2 = string;
        if (string2.contains("$")) {
            Matcher matcher = lIlIlIlIlIIlIIlIIllIIIIIl.matcher(string2);
            while (matcher.find()) {
                int n;
                boolean bl;
                String string3 = matcher.group("raw");
                String string4 = matcher.group("id");
                String string5 = matcher.group("name");
                String string6 = matcher.group("i18n");
                boolean bl2 = string6 != null;
                boolean bl3 = bl = string5 != null;
                if (bl) {
                    string2 = string2.replace(string3, Objects.requireNonNull(IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(string5)));
                    continue;
                }
                if (bl2) {
                    n = new Integer(string4) - 1;
                    string2 = string2.replace(string3, objectArray[n].toString());
                    continue;
                }
                n = new Integer(string4);
                string2 = string2.replace(string3, objectArray[n].toString());
            }
        }
        return string2;
    }

    public static String lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        return Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("[^A-Za-z0-9.]", "");
    }

    public LanguageParser() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
 