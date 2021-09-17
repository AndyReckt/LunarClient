package com.moonsworth.lunar.client.profile;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.json.file.ItemLoader;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Decencies
 * @since 10/07/2021 23:02
 */
public class ProfileLoader
        implements ItemLoader {
    public static final ImmutableList<String> lIlIlIlIlIIlIIlIIllIIIIIl = ImmutableList.of("Arena PvP", "Hypixel Skyblock", "UHC");
    public static final ImmutableList<String> IlllIIIIIIlllIlIIlllIlIIl = ImmutableList.of("controls.json", "general.json", "mods.json", "performance.json");
    public List<Profile> lIllIlIIIlIIIIIIIlllIlIll = new LinkedList<>();
    public Profile llIlllIIIllllIIlllIllIIIl;
    public long llllIIlIIlIIlIIllIIlIIllI;

    public List<Profile> lIlIlIlIlIIlIIlIIllIIIIIl() {
        LinkedList<Profile> linkedList = new LinkedList<>(this.lIllIlIIIlIIIIIIIlllIlIll);
        linkedList.sort((profile, profile2) -> profile.llIlllIIIllllIIlllIllIIIl() ? 1 : (profile2.llIlllIIIllllIIlllIllIIIl() ? -1 : 0));
        return linkedList;
    }

    public Profile llIlllIIIllllIIlllIllIIIl() {
        for (Profile profile : this.lIllIlIIIlIIIIIIIlllIlIll) {
            if (!profile.llIlllIIIllllIIlllIllIIIl()) continue;
            return profile;
        }
        return null;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Profile profile) {
        if (this.llIlllIIIllllIIlllIllIIIl.equals(profile)) {
            LunarLogger.lIllIlIIIlIIIIIIIlllIlIll((Object)"Profile", "We are attempt to switch to the current loaded profile.");
            return;
        }
        this.llllIIlIIlIIlIIllIIlIIllI = System.currentTimeMillis();
        Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().lIllIlIIIlIIIIIIIlllIlIll();
        Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().save();
        this.lIllIlIIIlIIIIIIIlllIlIll(profile);
        Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().b_();
        Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().load();
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(Profile profile) {
        this.lIllIlIIIlIIIIIIIlllIlIll.remove(profile);
        try {
            FileUtils.deleteDirectory(profile.lIIIllIllIIllIlllIlIIlllI());
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public Profile lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        Profile profile = new Profile(this.llllIIlIIlIIlIIllIIlIIllI(), string, false, false);
        this.lIllIlIIIlIIIIIIIlllIlIll.add(profile);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(profile);
        return profile;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(Profile profile) {
        this.llIlllIIIllllIIlllIllIIIl.IlllIIIIIIlllIlIIlllIlIIl(false);
        profile.IlllIIIIIIlllIlIIlllIlIIl(true);
        this.llIlllIIIllllIIlllIllIIIl = profile;
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        JsonArray var1 = new JsonArray();

        for (Profile var3 : this.lIllIlIIIlIIIIIIIlllIlIll) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("name", var3.IlllIIIIIIlllIlIIlllIlIIl());
            var4.addProperty("displayName", var3.lIllIlIIIlIIIIIIIlllIlIll());
            var4.addProperty("default", var3.llIlllIIIllllIIlllIllIIIl());
            var4.addProperty("active", var3.llllIIlIIlIIlIIllIIlIIllI());
            var4.addProperty("iconName", var3.IlIlIlllllIlIIlIlIlllIlIl());
            var4.addProperty("server", var3.llIIIIIIIllIIllIlIllIIIIl());
            var1.add(var4);
        }

        File var17 = new File(Ref.IlllIIIIIIlllIlIIlllIlIIl().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + "profile_manager.json");

        try {
            if (!var17.exists() && !var17.createNewFile()) {
                return;
            }

            FileWriter var18 = new FileWriter(var17);
            Throwable var19 = null;

            try {
                LunarClient.llIIlIlIIIllIlIlIlIIlIIll.toJson(var1, var18);
            } catch (Throwable var14) {
                var19 = var14;
                throw var14;
            } finally {
                if (var18 != null) {
                    if (var19 != null) {
                        try {
                            var18.close();
                        } catch (Throwable var13) {
                            var19.addSuppressed(var13);
                        }
                    } else {
                        var18.close();
                    }
                }

            }
        } catch (Exception var16) {
            LunarLogger.llIlllIIIllllIIlllIllIIIl("Couldn't save to file [%s]", var16.getMessage());
        }

    }
    @Override
    public void b_() {
        File file = new File(Ref.IlllIIIIIIlllIlIIlllIlIIl().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + "profile_manager.json");
        if (!file.exists()) {
            this.llIlllIIIllllIIlllIllIIIl = new Profile("Default", true, true);
            this.lIllIlIIIlIIIIIIIlllIlIll.add(this.llIlllIIIllllIIlllIllIIIl);
            for (String string : lIlIlIlIlIIlIIlIIllIIIIIl) {
                Profile profile = new Profile(string, false, false);
                switch (string) {
                    case "Arena PvP": {
                        profile.lIlIlIlIlIIlIIlIIllIIIIIl("crossed-swords");
                        break;
                    }
                    case "Hypixel Skyblock": {
                        profile.lIlIlIlIlIIlIIlIIllIIIIIl("hypixel");
                        break;
                    }
                    case "UHC": {
                        profile.lIlIlIlIlIIlIIlIIllIIIIIl("apple");
                    }
                }
                for (String string2 : IlllIIIIIIlllIlIIlllIlIIl) {
                    try {
                        InputStream inputStream = this.getClass().getResourceAsStream("/assets/profiles/" + string + "/" + string2);
                        byte[] byArray = new byte[inputStream.available()];
                        inputStream.read(byArray);
                        File file2 = new File(profile.lIIIllIllIIllIlllIlIIlllI() + File.separator + string2);
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        fileOutputStream.write(byArray);
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
                this.lIllIlIIIlIIIIIIIlllIlIll.add(profile);
            }
            return;
        }
        try {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse((Reader)new FileReader(file));
            if (jsonElement.isJsonArray()) {
                for (JsonElement jsonElement2 : jsonElement.getAsJsonArray()) {
                    JsonObject jsonObject = jsonElement2.getAsJsonObject();
                    String string = jsonObject.has("iconName") && !jsonObject.get("iconName").isJsonNull() ? jsonObject.get("iconName").getAsString() : "";
                    String string3 = jsonObject.has("server") && !jsonObject.get("server").isJsonNull() ? jsonObject.get("server").getAsString() : "";
                    Profile profile = new Profile(jsonObject.get("name").getAsString(), jsonObject.get("displayName").getAsString(), jsonObject.get("default").getAsBoolean(), jsonObject.get("active").getAsBoolean(), string);
                    profile.llIlllIIIllllIIlllIllIIIl(string3);
                    this.lIllIlIIIlIIIIIIIlllIlIll.add(profile);
                    if (!profile.llllIIlIIlIIlIIllIIlIIllI()) continue;
                    this.llIlllIIIllllIIlllIllIIIl = profile;
                }
            }
        }
        catch (Exception exception) {
            LunarLogger.llIlllIIIllllIIlllIllIIIl((Object)("Couldn't load file [" + exception.getMessage() + "]"), new Object[0]);
        }
        if (this.llIlllIIIllllIIlllIllIIIl == null) {
            this.llIlllIIIllllIIlllIllIIIl = new Profile("Default", true, true);
            this.lIllIlIIIlIIIIIIIlllIlIll.add(this.llIlllIIIllllIIlllIllIIIl);
        }
    }

    public Profile llllIIlIIlIIlIIllIIlIIllI() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public long IlIlIlllllIlIIlIlIlllIlIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }
}