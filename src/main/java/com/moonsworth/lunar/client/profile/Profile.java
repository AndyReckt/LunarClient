package com.moonsworth.lunar.client.profile;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;

import java.io.File;

/**
 * @author Decencies
 * @since 10/07/2021 12:43
 */
public class Profile {
    public ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl = null;
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public String lIllIlIIIlIIIIIIIlllIlIll;
    public boolean llIlllIIIllllIIlllIllIIIl;
    public boolean llllIIlIIlIIlIIllIIlIIllI;
    public String IlIlIlllllIlIIlIlIlllIlIl;
    public String llIIIIIIIllIIllIlIllIIIIl;
    public File lIIIllIllIIllIlllIlIIlllI;

    public Profile(String string, String string2, boolean bl, boolean bl2, String string3) {
        this(Ref.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIIIIIIllIlIIIIllIIII().llIlllIIIllllIIlllIllIIIl(), string, string2, bl, bl2, string3);
    }

    public Profile(Profile profile, String string, String string2, boolean bl, boolean bl2, String string3) {
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
        this.lIllIlIIIlIIIIIIIlllIlIll = string2;
        this.llIlllIIIllllIIlllIllIIIl = bl;
        this.llllIIlIIlIIlIIllIIlIIllI = bl2;
        this.IlIlIlllllIlIIlIlIlllIlIl = string3;
        this.lIlIlIlIlIIlIIlIIllIIIIIl = null;
        this.llIIIIIIIllIIllIlIllIIIIl = "";
        if (!string3.equalsIgnoreCase("")) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/profiles/" + string3 + ".png");
        }
        this.lIIIllIllIIllIlllIlIIlllI = new File(Ref.IlllIIIIIIlllIlIIlllIlIIl().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + string);
        if (!this.lIIIllIllIIllIlllIlIIlllI.exists()) {
            if (!bl2 && !ProfileLoader.lIlIlIlIlIIlIIlIIllIIIIIl.contains(string)) {
                Ref.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl(profile);
            }
            if (!this.lIIIllIllIIllIlllIlIIlllI.mkdirs()) {
                LunarLogger.IlllIIIIIIlllIlIIlllIlIIl((Object)("Can't make directory for " + string + " profile."), new Object[0]);
            }
        }
    }

    public Profile(Profile profile, String string, boolean bl, boolean bl2) {
        this(profile, string, string, bl, bl2, "");
    }

    public Profile(String string, boolean bl, boolean bl2) {
        this(string, string, bl, bl2, "");
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.IlIlIlllllIlIIlIlIlllIlIl = string;
        if (string.equalsIgnoreCase("")) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = null;
            return;
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/profiles/" + string + ".png");
    }

    public ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public String lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public String IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public String llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public File lIIIllIllIIllIlllIlIIlllI() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = resourceLocationBridge;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(String string) {
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(String string) {
        this.lIllIlIIIlIIIIIIIlllIlIll = string;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.llIlllIIIllllIIlllIllIIIl = bl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        this.llllIIlIIlIIlIIllIIlIIllI = bl;
    }

    public void llIlllIIIllllIIlllIllIIIl(String string) {
        this.llIIIIIIIllIIllIlIllIIIIl = string;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(File file) {
        this.lIIIllIllIIllIlllIlIIlllI = file;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile)object;
        if (!profile.lIlIlIlIlIIlIIlIIllIIIIIl(this)) {
            return false;
        }
        if (this.llIlllIIIllllIIlllIllIIIl() != profile.llIlllIIIllllIIlllIllIIIl()) {
            return false;
        }
        if (this.llllIIlIIlIIlIIllIIlIIllI() != profile.llllIIlIIlIIlIIllIIlIIllI()) {
            return false;
        }
        ResourceLocationBridge resourceLocationBridge = this.lIlIlIlIlIIlIIlIIllIIIIIl();
        ResourceLocationBridge resourceLocationBridge2 = profile.lIlIlIlIlIIlIIlIIllIIIIIl();
        if (resourceLocationBridge == null ? resourceLocationBridge2 != null : !resourceLocationBridge.equals(resourceLocationBridge2)) {
            return false;
        }
        String string = this.IlllIIIIIIlllIlIIlllIlIIl();
        String string2 = profile.IlllIIIIIIlllIlIIlllIlIIl();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.lIllIlIIIlIIIIIIIlllIlIll();
        String string4 = profile.lIllIlIIIlIIIIIIIlllIlIll();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        String string5 = this.IlIlIlllllIlIIlIlIlllIlIl();
        String string6 = profile.IlIlIlllllIlIIlIlIlllIlIl();
        if (string5 == null ? string6 != null : !string5.equals(string6)) {
            return false;
        }
        String string7 = this.llIIIIIIIllIIllIlIllIIIIl();
        String string8 = profile.llIIIIIIIllIIllIlIllIIIIl();
        if (string7 == null ? string8 != null : !string7.equals(string8)) {
            return false;
        }
        File file = this.lIIIllIllIIllIlllIlIIlllI();
        File file2 = profile.lIIIllIllIIllIlllIlIIlllI();
        return !(file == null ? file2 != null : !((Object)file).equals(file2));
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object object) {
        return object instanceof Profile;
    }

    public int hashCode() {
        int n = 59;
        int n2 = 1;
        n2 = n2 * 59 + (this.llIlllIIIllllIIlllIllIIIl() ? 79 : 97);
        n2 = n2 * 59 + (this.llllIIlIIlIIlIIllIIlIIllI() ? 79 : 97);
        ResourceLocationBridge resourceLocationBridge = this.lIlIlIlIlIIlIIlIIllIIIIIl();
        n2 = n2 * 59 + (resourceLocationBridge == null ? 43 : resourceLocationBridge.hashCode());
        String string = this.IlllIIIIIIlllIlIIlllIlIIl();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.lIllIlIIIlIIIIIIIlllIlIll();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        String string3 = this.IlIlIlllllIlIIlIlIlllIlIl();
        n2 = n2 * 59 + (string3 == null ? 43 : string3.hashCode());
        String string4 = this.llIIIIIIIllIIllIlIllIIIIl();
        n2 = n2 * 59 + (string4 == null ? 43 : string4.hashCode());
        File file = this.lIIIllIllIIllIlllIlIIlllI();
        n2 = n2 * 59 + (file == null ? 43 : ((Object)file).hashCode());
        return n2;
    }

    public String toString() {
        return "Profile(icon=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", name=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", displayName=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ", defaultProfile=" + this.llIlllIIIllllIIlllIllIIIl() + ", active=" + this.llllIIlIIlIIlIIllIIlIIllI() + ", iconName=" + this.IlIlIlllllIlIIlIlIlllIlIl() + ", server=" + this.llIIIIIIIllIIllIlIllIIIIl() + ", file=" + this.lIIIllIllIIllIlllIlIIlllI() + ")";
    }
}