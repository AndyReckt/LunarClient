package com.moonsworth.lunar.client.feature.type.worldedit.bp;

import java.util.ArrayList;
import java.util.List;

public class lIlIlIlIlIIlIIlIIllIIIIIl implements WorldEditActionEventInterface {
    public List<com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl> lIlIlIlIlIIlIIlIIllIIIIIl = new ArrayList();

    public WorldEditActionEventInterface lIlIlIlIlIIlIIlIIllIIIIIl(double var1, double var3, double var5) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.add(new com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var3, var5));
        return this;
    }

    public WorldEditActionEventInterface lIlIlIlIlIIlIIlIIllIIIIIl(double var1, double var3) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.add(new com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl(var1, -1.0D, var3));
        return this;
    }

    public WorldEditActionEventInterface lIlIlIlIlIIlIIlIIllIIIIIl(int var1, double var2, double var4, double var6) {
        if (var1 >= this.lIlIlIlIlIIlIIlIIllIIIIIl.size()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.add(new com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var4, var6));
        } else {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.set(var1, new com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var4, var6));
        }

        return this;
    }

    public List<com.moonsworth.lunar.client.feature.type.worldedit.br.lIlIlIlIlIIlIIlIIllIIIIIl> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}