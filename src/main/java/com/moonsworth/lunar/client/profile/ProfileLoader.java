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
import java.util.LinkedList;
import java.util.List;

/**
 * @author Decencies
 * @since 10/07/2021 23:02
 */
public class ProfileLoader implements ItemLoader {
    public static final ImmutableList<String> DEFAULT_PROFILES = ImmutableList.of("Arena PvP", "Hypixel Skyblock", "UHC");
    public static final ImmutableList<String> CONFIG_FILES = ImmutableList.of("controls.json", "general.json", "mods.json", "performance.json");
    public List<Profile> profiles = new LinkedList<>();
    public Profile selectedProfile;
    public long switchTime;

    public List<Profile> lIlIlIlIlIIlIIlIIllIIIIIl() {
        LinkedList<Profile> linkedList = new LinkedList<>(this.profiles);
        linkedList.sort((profile, profile2) -> profile.isDefault() ? 1 : (profile2.isDefault() ? -1 : 0));
        return linkedList;
    }

    public Profile llIlllIIIllllIIlllIllIIIl() {
        for (Profile profile : this.profiles) {
            if (!profile.isDefault()) continue;
            return profile;
        }
        return null;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Profile profile) {
        if (this.selectedProfile.equals(profile)) {
            LunarLogger.warn("Profile", "We are attempt to switch to the current loaded profile.");
            return;
        }
        this.switchTime = System.currentTimeMillis();
        Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().lIllIlIIIlIIIIIIIlllIlIll();
        Ref.getLC().lllllIllIllIllllIlIllllII().save();
        this.switchTo(profile);
        Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().b_();
        Ref.getLC().lllllIllIllIllllIlIllllII().load();
    }

    public void remove(Profile profile) {
        this.profiles.remove(profile);
        try {
            FileUtils.deleteDirectory(profile.getFile());
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public Profile add(String string) {
        Profile profile = new Profile(this.getSelectedProfile(), string, false, false);
        this.profiles.add(profile);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(profile);
        return profile;
    }

    public void switchTo(Profile profile) {
        this.selectedProfile.setActive(false);
        profile.setActive(true);
        this.selectedProfile = profile;
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        JsonArray profileArray = new JsonArray();

        for (Profile profile : this.profiles) {
            JsonObject profileObject = new JsonObject();
            profileObject.addProperty("name", profile.getName());
            profileObject.addProperty("displayName", profile.getDisplayName());
            profileObject.addProperty("default", profile.isDefault());
            profileObject.addProperty("active", profile.isActive());
            profileObject.addProperty("iconName", profile.getIconName());
            profileObject.addProperty("server", profile.getServer());
            profileArray.add(profileObject);
        }

        File file = new File(Ref.getLC().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + "profile_manager.json");

        try {
            if (!file.exists() && !file.createNewFile()) {
                return;
            }
            try (FileWriter var18 = new FileWriter(file)) {
                LunarClient.GSON.toJson(profileArray, var18);
            }
        } catch (Exception var16) {
            LunarLogger.error("Couldn't save to file [%s]", var16.getMessage());
        }

    }

    @Override
    public void b_() {
        File file = new File(Ref.getLC().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + "profile_manager.json");
        if (!file.exists()) {
            this.selectedProfile = new Profile("Default", true, true);
            this.profiles.add(this.selectedProfile);
            for (String profileName : DEFAULT_PROFILES) {
                Profile profile = new Profile(profileName, false, false);
                switch (profileName) {
                    case "Arena PvP": {
                        profile.setIcon("crossed-swords");
                        break;
                    }
                    case "Hypixel Skyblock": {
                        profile.setIcon("hypixel");
                        break;
                    }
                    case "UHC": {
                        profile.setIcon("apple");
                    }
                }
                for (String string2 : CONFIG_FILES) {
                    try {
                        InputStream inputStream = this.getClass().getResourceAsStream("/assets/profiles/" + profileName + "/" + string2);
                        byte[] byArray = new byte[inputStream.available()];
                        inputStream.read(byArray);
                        File file2 = new File(profile.getFile() + File.separator + string2);
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        fileOutputStream.write(byArray);
                    } catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
                this.profiles.add(profile);
            }
            return;
        }
        try {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(new FileReader(file));
            if (jsonElement.isJsonArray()) {
                for (JsonElement jsonElement2 : jsonElement.getAsJsonArray()) {
                    JsonObject jsonObject = jsonElement2.getAsJsonObject();
                    String iconName = jsonObject.has("iconName") && !jsonObject.get("iconName").isJsonNull() ? jsonObject.get("iconName").getAsString() : "";
                    String server = jsonObject.has("server") && !jsonObject.get("server").isJsonNull() ? jsonObject.get("server").getAsString() : "";
                    Profile profile = new Profile(jsonObject.get("name").getAsString(), jsonObject.get("displayName").getAsString(), jsonObject.get("default").getAsBoolean(), jsonObject.get("active").getAsBoolean(), iconName);
                    profile.setServer(server);
                    this.profiles.add(profile);
                    if (!profile.isActive()) continue;
                    this.selectedProfile = profile;
                }
            }
        } catch (Exception exception) {
            LunarLogger.error("Couldn't load file [" + exception.getMessage() + "]");
        }
        if (this.selectedProfile == null) {
            this.selectedProfile = new Profile("Default", true, true);
            this.profiles.add(this.selectedProfile);
        }
    }

    public Profile getSelectedProfile() {
        return this.selectedProfile;
    }

    public long getSwitchTime() {
        return this.switchTime;
    }
}