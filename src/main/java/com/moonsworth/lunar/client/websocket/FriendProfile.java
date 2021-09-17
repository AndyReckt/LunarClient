package com.moonsworth.lunar.client.websocket;

import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.bridge.minecraft.util.Vec3Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;

import java.util.Objects;
import java.util.UUID;

public class FriendProfile {
    public final UUID lIllIlIIIlIIIIIIIlllIlIll;
    public String llIlllIIIllllIIlllIllIIIl;
    public String llllIIlIIlIIlIIllIIlIIllI;
    public String IlIlIlllllIlIIlIlIlllIlIl;
    public String llIIIIIIIllIIllIlIllIIIIl;
    public MinecraftVersion lIIIllIllIIllIlllIlIIlllI;
    public boolean IlllllIlIIIlIIlIIllIIlIll;
    public long llIIlIlIIIllIlIlIlIIlIIll;
    public int llIIIlllIIlllIllllIlIllIl = 0xFFFFFF;
    public long lIlIlIlIlIIlIIlIIllIIIIIl;
    public int IlllIIIIIIlllIlIIlllIlIIl = 100;
    public int lllllIllIllIllllIlIllllII = -1;
    public Vec3Bridge lllIIIIIlllIIlIllIIlIIIlI;
    public double lIlIIIIIIlIIIllllIllIIlII = -1.0;
    public long llIlIIIllIIlIllIllIllllIl;
    public long IllIllIIIllIIIlIlIlIIIIll;
    public Status IIlIllIlllllllIIlIIIllIIl = Status.lIlIlIlIlIIlIIlIIllIIIIIl;

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        int n = FriendProfile.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlIllIlllllllIIlIIIllIIl);
        return n;
    }

    public static int lIlIlIlIlIIlIIlIIllIIIIIl(Status status) {
        int n;
        if (status == null) {
            return -4210753;
        }
        switch (status) {
            case IlllIIIIIIlllIlIIlllIlIIl: {
                n = -5991424;
                break;
            }
            case lIllIlIIIlIIIIIIIlllIlIll: {
                n = -904879;
                break;
            }
            case llIlllIIIllllIIlllIllIIIl: {
                n = -4210753;
                break;
            }
            default: {
                n = -12209557;
            }
        }
        return n;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.llIlllIIIllllIIlllIllIIIl = string;
        this.llllIIlIIlIIlIIllIIlIIllI = EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(string);
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        String string;
        if (this.IlllllIlIIIlIIlIIllIIlIll) {
            if (this.llIIIIIIIllIIllIlIllIIIIl != null && !Objects.equals(this.llIIIIIIIllIIllIlIllIIIIl, "")) {
                string = (Object)((Object)EnumChatColor.lIIlIlllIlIlIIIlllIIlIIII) + "In-game:" + (Object)((Object)EnumChatColor.IllIIIlllIIIlIlllIlIIlIII) + " " + this.llIIIIIIIllIIllIlIllIIIIl;
            } else {
                switch (this.IIlIllIlllllllIIlIIIllIIl) {
                    case IlllIIIIIIlllIlIIlllIlIIl: {
                        string = "Away";
                        break;
                    }
                    case lIllIlIIIlIIIIIIIlllIlIll: {
                        string = "Busy";
                        break;
                    }
                    default: {
                        string = "In-Menus";
                        break;
                    }
                }
            }
        } else {
            long l = System.currentTimeMillis() - this.llIIlIlIIIllIlIlIlIIlIIll;
            long l2 = 1000L;
            long l3 = l2 * 60L;
            long l4 = l3 * 60L;
            long l5 = l4 * 24L;
            long l6 = l / l5;
            long l7 = (l %= l5) / l4;
            long l8 = (l %= l4) / l3;
            string = l6 > 0L ? "Offline for " + l6 + (l6 == 1L ? " day" : " days") : (l7 > 0L ? "Offline for " + l7 + (l7 == 1L ? " hour" : " hours") : "Offline for " + l8 + (l8 == 1L ? " minute" : " minutes"));
        }
        return string;
    }

    public UUID lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public String llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public String llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public String IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public String llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public MinecraftVersion lIIIllIllIIllIlllIlIIlllI() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public boolean IlllllIlIIIlIIlIIllIIlIll() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public long llIIlIlIIIllIlIlIlIIlIIll() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public int llIIIlllIIlllIllllIlIllIl() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public long lllllIllIllIllllIlIllllII() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public int lllIIIIIlllIIlIllIIlIIIlI() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public int lIlIIIIIIlIIIllllIllIIlII() {
        return this.lllllIllIllIllllIlIllllII;
    }

    public Vec3Bridge llIlIIIllIIlIllIllIllllIl() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public double IllIllIIIllIIIlIlIlIIIIll() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public long IIlIllIlllllllIIlIIIllIIl() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public long lIIlIlllIlIlIIIlllIIlIIII() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public Status llIllIlIllIlllIllIIIIllII() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public FriendProfile(UUID uUID) {
        this.lIllIlIIIlIIIIIIIlllIlIll = uUID;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(String string) {
        this.IlIlIlllllIlIIlIlIlllIlIl = string;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(String string) {
        this.llIIIIIIIllIIllIlIllIIIIl = string;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(MinecraftVersion minecraftVersion) {
        this.lIIIllIllIIllIlllIlIIlllI = minecraftVersion;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.IlllllIlIIIlIIlIIllIIlIll = bl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(long l) {
        this.llIIlIlIIIllIlIlIlIIlIIll = l;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.llIIIlllIIlllIllllIlIllIl = n;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.lllllIllIllIllllIlIllllII = n;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Vec3Bridge vec3Bridge) {
        this.lllIIIIIlllIIlIllIIlIIIlI = vec3Bridge;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(double d) {
        this.lIlIIIIIIlIIIllllIllIIlII = d;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(long l) {
        this.llIlIIIllIIlIllIllIllllIl = l;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(long l) {
        this.IllIllIIIllIIIlIlIlIIIIll = l;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(Status status) {
        this.IIlIllIlllllllIIlIIIllIIl = status;
    }
}
 