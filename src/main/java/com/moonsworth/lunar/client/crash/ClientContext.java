package com.moonsworth.lunar.client.crash;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.List;

public final class ClientContext {

    @SerializedName(value="minecraft_version")
    public final String lIlIlIlIlIIlIIlIIllIIIIIl;
    @SerializedName(value="launcher_version")
    public final String IlllIIIIIIlllIlIIlllIlIIl;
    @SerializedName(value="branch")
    public final String lIllIlIIIlIIIIIIIlllIlIll;
    @SerializedName(value="git_commit")
    public final String llIlllIIIllllIIlllIllIIIl;
    @SerializedName(value="cpu")
    public final String llllIIlIIlIIlIIllIIlIIllI;
    @SerializedName(value="gpu")
    public final String IlIlIlllllIlIIlIlIlllIlIl;
    @SerializedName(value="os")
    public final String llIIIIIIIllIIllIlIllIIIIl;
    @SerializedName(value="connected_server")
    public final String lIIIllIllIIllIlllIlIIlllI;
    @SerializedName(value="architecture")
    public final String IlllllIlIIIlIIlIIllIIlIll;
    @SerializedName(value="java_version")
    public final String llIIlIlIIIllIlIlIlIIlIIll;
    @SerializedName(value="total_memory_mb")
    public final int llIIIlllIIlllIllllIlIllIl;
    @SerializedName(value="free_memory_mb")
    public final int lllllIllIllIllllIlIllllII;
    @SerializedName(value="max_memory_mb")
    public final int lllIIIIIlllIIlIllIIlIIIlI;
    @SerializedName(value="fps")
    public final int lIlIIIIIIlIIIllllIllIIlII;
    @SerializedName(value="last_opened_menus")
    public final Collection llIlIIIllIIlIllIllIllllIl;
    @SerializedName(value="opened_packs")
    public final List IllIllIIIllIIIlIlIlIIIIll;

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public String lIllIlIIIlIIIIIIIlllIlIll() {
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

    public String lIIIllIllIIllIlllIlIIlllI() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public String IlllllIlIIIlIIlIIllIIlIll() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public String llIIlIlIIIllIlIlIlIIlIIll() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public int llIIIlllIIlllIllllIlIllIl() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public int lllllIllIllIllllIlIllllII() {
        return this.lllllIllIllIllllIlIllllII;
    }

    public int lllIIIIIlllIIlIllIIlIIIlI() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public int lIlIIIIIIlIIIllllIllIIlII() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public Collection llIlIIIllIIlIllIllIllllIl() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public List IllIllIIIllIIIlIlIlIIIIll() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public ClientContext(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, int n, int n2, int n3, int n4, Collection collection, List list) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.IlllIIIIIIlllIlIIlllIlIIl = string2;
        this.lIllIlIIIlIIIIIIIlllIlIll = string3;
        this.llIlllIIIllllIIlllIllIIIl = string4;
        this.llllIIlIIlIIlIIllIIlIIllI = string5;
        this.IlIlIlllllIlIIlIlIlllIlIl = string6;
        this.llIIIIIIIllIIllIlIllIIIIl = string7;
        this.lIIIllIllIIllIlllIlIIlllI = string8;
        this.IlllllIlIIIlIIlIIllIIlIll = string9;
        this.llIIlIlIIIllIlIlIlIIlIIll = string10;
        this.llIIIlllIIlllIllllIlIllIl = n;
        this.lllllIllIllIllllIlIllllII = n2;
        this.lllIIIIIlllIIlIllIIlIIIlI = n3;
        this.lIlIIIIIIlIIIllllIllIIlII = n4;
        this.llIlIIIllIIlIllIllIllllIl = collection;
        this.IllIllIIIllIIIlIlIlIIIIll = list;
    }
}
