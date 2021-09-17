package com.moonsworth.lunar.client.server;

import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;

import java.util.List;

public class FeaturedServer {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public Long lIllIlIIIlIIIIIIIlllIlIll;
    public boolean llIlllIIIllllIIlllIllIIIl;

    public FeaturedServer(String string, String string2, Long l, List<MinecraftVersion> list) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.IlllIIIIIIlllIlIIlllIlIIl = string2;
        this.lIllIlIIIlIIIIIIIlllIlIll = l;
        this.llIlllIIIllllIIlllIllIIIl = list.contains(Bridge.IlllIIIIIIlllIlIIlllIlIIl());
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public Long lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }
}
 