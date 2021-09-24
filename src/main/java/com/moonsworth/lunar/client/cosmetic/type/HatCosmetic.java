package com.moonsworth.lunar.client.cosmetic.type;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.cosmetic.model.ModelMesh;
import com.moonsworth.lunar.client.cosmetic.part.AbstractCosmetic;
import com.moonsworth.lunar.client.cosmetic.part.BodyPart;
import com.moonsworth.lunar.client.cosmetic.part.BodySection;
import com.moonsworth.lunar.client.texture.AnimationTickingTexture;
import com.moonsworth.lunar.client.util.CosmeticRotationHelper;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class HatCosmetic extends AbstractCosmetic {
    public static final String IlllllIlIIIlIIlIIllIIlIll = "cosmetics/hats/%s/%s";
    public String llIIlIlIIIllIlIlIlIIlIIll;
    public boolean llIIIlllIIlllIllllIlIllIl;
    public boolean lllllIllIllIllllIlIllllII = false;
    public boolean lllIIIIIlllIIlIllIIlIIIlI = false;
    public boolean IIlIllIlllllllIIlIIIllIIl = false;
    public Map lIIlIlllIlIlIIIlllIIlIIII = new HashMap();
    public ResourceLocationBridge lIlIIIIIIlIIIllllIllIIlII;
    public ResourceLocationBridge llIlIIIllIIlIllIllIllllIl;
    public ModelMesh IllIllIIIllIIIlIlIlIIIIll;
    @Nullable
    public AnimationTickingTexture llIllIlIllIlllIllIIIIllII;
    public Type IllllllllllIlIIIlllIlllll = Type.HAT;

    public HatCosmetic(String string, ModelMesh modelMesh) {
        this(string, false);
        this.IllIllIIIllIIIlIlIlIIIIll = modelMesh;
    }

    public HatCosmetic(String string, boolean bl, CosmeticRotationHelper... cosmeticRotationHelperArray) {
        super(string, BodyPart.HEAD, BodySection.HATS, bl, cosmeticRotationHelperArray);
    }

    @Override
    public BodyPart llIIlIlIIIllIlIlIlIIlIIll() {
        return BodyPart.HEAD;
    }

    public HatCosmetic IllIllIIIllIIIlIlIlIIIIll() {
        this.lllllIllIllIllllIlIllllII = true;
        return this;
    }

    public boolean IIlIllIlllllllIIlIIIllIIl() {
        return this.lllllIllIllIllllIlIllllII;
    }

    @Override
    public boolean llIIIIIIIllIIllIlIllIIIIl() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public HatCosmetic lIIlIlllIlIlIIIlllIIlIIII() {
        this.IIlIllIlllllllIIlIIIllIIl = true;
        return this;
    }

    public Type llIllIlIllIlllIllIIIIllII() {
        return this.IllllllllllIlIIIlllIlllll;
    }

    public HatCosmetic lIlIlIlIlIIlIIlIIllIIIIIl(Type type) {
        this.IllllllllllIlIIIlllIlllll = type;
        return this;
    }

    @Override
    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return this.IIlIllIlllllllIIlIIIllIIl();
    }

    @Override
    public AbstractCosmetic lIIIllIllIIllIlllIlIIlllI() {
        return this.lIIlIlllIlIlIIIlllIIlIIII();
    }

    public enum Type {
        HAT,
        BANDANNA,
        MASK

    }
}
