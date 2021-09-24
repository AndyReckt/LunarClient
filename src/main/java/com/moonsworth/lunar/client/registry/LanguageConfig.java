package com.moonsworth.lunar.client.registry;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.lang.LanguageType;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.client.feature.external.ThirdPartyMod;
import com.moonsworth.lunar.client.json.file.JsonFile;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.util.LanguageParser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class LanguageConfig extends ItemSetLoader<LanguageType> implements JsonFile {
    public LanguageType lIlIlIlIlIIlIIlIIllIIIIIl;
    public JsonObject IlllIIIIIIlllIlIIlllIlIIl = new JsonObject();
    public final Map<String, List<String>> lIllIlIIIlIIIIIIIlllIlIll = new HashMap<>();

    @Override
    public Set<LanguageType> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return ImmutableSet.copyOf(Arrays.asList(LanguageType.values()));
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl(I18nBridge i18nBridge, String string, Object ... objectArray) {
        String string2 = i18nBridge.getLanguagePath();
        if (!this.lIllIlIIIlIIIIIIIlllIlIll.containsKey(string2)) {
            this.lIllIlIIIlIIIIIIIlllIlIll.put(string2, new LinkedList<>(Arrays.asList(string2.split(Pattern.quote(".")))));
        }
        List<String> list = this.lIllIlIIIlIIIIIIIlllIlIll.get(string2);
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(list, string, objectArray);
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl(List<String> list, String string, Object ... objectArray) {
        String string2 = null;
        try {
            JsonObject jsonObject = this.IlllIIIIIIlllIlIIlllIlIIl;
            for (String string3 : list) {
                if (string3.equals("") || !jsonObject.has(string3)) continue;
                jsonObject = jsonObject.getAsJsonObject(string3);
            }
            string2 = LanguageParser.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject.get(string).getAsString(), objectArray);
        } catch (Exception exception) {
            // empty catch block
        }
        return string2 == null || string2.isEmpty() ? string : string2;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(LanguageType languageType) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = languageType;
        this.IlllllIlIIIlIIlIIllIIlIll();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        LanguageType languageType = LanguageType.ENGLISH;
        for (LanguageType languageType2 : LanguageType.values()) {
            if (!languageType2.lIlIlIlIlIIlIIlIIllIIIIIl().equalsIgnoreCase(string)) continue;
            languageType = languageType2;
            break;
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(languageType);
    }

    public void IlllllIlIIIlIIlIIllIIlIll() {
        LunarLogger.info("LANG", "Language set as %s (%s).", this.lIlIlIlIlIIlIIlIIllIIIIIl.name(), this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl());
        this.IlllIIIIIIlllIlIIlllIlIIl = this.IlllIIIIIIlllIlIIlllIlIIl("lang/lunar/" + this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl());
        for (ThirdPartyMod thirdPartyMod : LunarClient.getInstance().IlIlIlIlIIIlIIlIIlllIllIl().values()) {
            LunarLogger.info("LANG", "Checking language files for %s.", thirdPartyMod.lIlIlIlIlIIlIIlIIllIIIIIl());
            this.IlllIIIIIIlllIlIIlllIlIIl.add(thirdPartyMod.lIlIlIlIlIIlIIlIIllIIIIIl(), this.IlllIIIIIIlllIlIIlllIlIIl("lang/" + thirdPartyMod.lIlIlIlIlIIlIIlIIllIIIIIl() + "/" + this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl()));
        }
    }

    public JsonObject IlllIIIIIIlllIlIIlllIlIIl(String string) {
        JsonObject jsonObject;
        block6: {
            jsonObject = new JsonObject();
            try {
                InputStream inputStream = this.lIlIlIlIlIIlIIlIIllIIIIIl(string + ".json", string.toLowerCase() + ".json", string + ".lang", string.toLowerCase() + ".lang");
                if (inputStream != null) {
                    int n;
                    LunarLogger.info("LANG", "Language file found: %s.", string);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] byArray = new byte[1024];
                    while ((n = inputStream.read(byArray)) != -1) {
                        byteArrayOutputStream.write(byArray, 0, n);
                    }
                    String string2 = byteArrayOutputStream.toString("UTF-8");
                    try {
                        jsonObject = new JsonParser().parse(string2).getAsJsonObject();
                    } catch (Exception exception) {
                        jsonObject = this.lIllIlIIIlIIIIIIIlllIlIll(string2);
                    }
                    inputStream.close();
                    break block6;
                }
                LunarLogger.error("LANG", "Language file not found %s.", string);
            } catch (JsonParseException | IOException | IllegalStateException throwable) {
                throwable.printStackTrace();
            }
        }
        return jsonObject;
    }

    public JsonObject lIllIlIIIlIIIIIIIlllIlIll(String string) {
        JsonObject jsonObject = new JsonObject();
        for (String string2 : string.split("\\r?\\n")) {
            if (string2.isEmpty() || string2.startsWith("#")) continue;
            String[] stringArray = string2.split("=", 2);
            jsonObject.addProperty(stringArray[0], stringArray[1]);
        }
        return jsonObject;
    }

    public InputStream lIlIlIlIlIIlIIlIIllIIIIIl(String ... stringArray) {
        for (String string : stringArray) {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(string);
            if (inputStream == null) continue;
            return inputStream;
        }
        return null;
    }

    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "language.json";
    }

    @Override
    public void read(JsonObject jsonObject) {
    }

    @Override
    public void write(JsonObject jsonObject) {
    }

    @Override
    public void b_() {
        super.b_();
        this.load();
        this.IlllllIlIIIlIIlIIllIIlIll();
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        super.lIllIlIIIlIIIIIIIlllIlIll();
        this.save();
    }
}