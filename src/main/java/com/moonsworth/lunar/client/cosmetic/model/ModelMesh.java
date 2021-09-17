package com.moonsworth.lunar.client.cosmetic.model;

import mchorse.emoticons.skin_n_bones.api.bobj.BOBJLoader;

import java.util.ArrayList;
import java.util.List;

public class ModelMesh {
    public float lIlIlIlIlIIlIIlIIllIIIIIl;
    public float IlllIIIIIIlllIlIIlllIlIIl;
    public float lIllIlIIIlIIIIIIIlllIlIll;
    public float llIlllIIIllllIIlllIllIIIl;
    public float llllIIlIIlIIlIIllIIlIIllI;
    public float IlIlIlllllIlIIlIlIlllIlIl;
    public BOBJLoader.BOBJData llIIIIIIIllIIllIlIllIIIIl;
    public List lIIIllIllIIllIlllIlIIlllI;

    public ModelMesh(BOBJLoader.BOBJData bOBJData) {
        this.llIIIIIIIllIIllIlIllIIIIl = bOBJData;
        this.lIIIllIllIIllIlllIlIIlllI = new ArrayList();
        this.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        BOBJLoader.loadMeshes(this.llIIIIIIIllIIllIlIllIIIIl).values().forEach(compiledData -> this.lIIIllIllIIllIlllIlIIlllI.add(new Model(this, (BOBJLoader.CompiledData)compiledData)));
    }

    public void IlllIIIIIIlllIlIIlllIlIIl() {
        this.lIIIllIllIIllIlllIlIIlllI.forEach(Model::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2, MatrixStackBridge matrixStackBridge, int n) {
        this.lIIIllIllIIllIlllIlIIlllI.forEach(model -> model.lIlIlIlIlIIlIIlIIllIIIIIl(lIllIlIIIlIIIIIIIlllIlIll2, matrixStackBridge.llIlllIIIllllIIlllIllIIIl(), n));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n, int n2) {
        this.lIIIllIllIIllIlllIlIIlllI.forEach(model -> model.lIlIlIlIlIIlIIlIIllIIIIIl(n, n2));
    }
}
 