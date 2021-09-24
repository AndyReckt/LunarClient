package com.moonsworth.lunar.client.profile;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;

/**
 * @author Decencies
 * @since 10/07/2021 12:43
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Profile {
    public ResourceLocationBridge icon;
    public String name;
    public String displayName;
    public boolean isDefault;
    public boolean active;
    public String iconName;
    public String server;
    public File file;

    public Profile(String name, String displayName, boolean isDefault, boolean active, String iconName) {
        this(Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().llIlllIIIllllIIlllIllIIIl(), name, displayName, isDefault, active, iconName);
    }

    public Profile(Profile profile, String name, String displayName, boolean isDefault, boolean active, String iconName) {
        this.name = name;
        this.displayName = displayName;
        this.isDefault = isDefault;
        this.active = active;
        this.iconName = iconName;
        this.icon = null;
        this.server = "";
        if (!iconName.equalsIgnoreCase("")) {
            this.icon = Bridge.getInstance().initResourceLocation("lunar", "icons/profiles/" + iconName + ".png");
        }
        this.file = new File(Ref.getLC().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + name);
        if (!this.file.exists()) {
            if (!active && !ProfileLoader.DEFAULT_PROFILES.contains(name)) {
                Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl(profile);
            }
            if (!this.file.mkdirs()) {
                LunarLogger.info("Can't make directory for " + name + " profile.");
            }
        }
    }

    public Profile(Profile profile, String name, boolean isDefault, boolean active) {
        this(profile, name, name, isDefault, active, "");
    }

    public Profile(String name, boolean isDefault, boolean active) {
        this(name, name, isDefault, active, "");
    }

    public void setIcon(String string) {
        this.iconName = string;
        if (string.equalsIgnoreCase("")) {
            this.icon = null;
            return;
        }
        this.icon = Bridge.getInstance().initResourceLocation("lunar", "icons/profiles/" + string + ".png");
    }

    public boolean isInstance(Object object) {
        return object instanceof Profile;
    }
}