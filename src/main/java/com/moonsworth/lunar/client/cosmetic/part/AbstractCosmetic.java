package com.moonsworth.lunar.client.cosmetic.part;

import com.google.common.base.Preconditions;
import com.moonsworth.lunar.bridge.minecraft.client.resources.SimpleResourceBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.CosmeticRotationHelper;

import java.util.*;

public abstract class AbstractCosmetic
implements lIllIlIIIlIIIIIIIlllIlIll,
com.moonsworth.lunar.client.cosmetic.iface.lIllIlIIIlIIIIIIIlllIlIll {
    public static final String lIlIlIlIlIIlIIlIIllIIIIIl = "cosmetics/%s/%s/%s";
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public boolean lIllIlIIIlIIIIIIIlllIlIll = false;
    public boolean llIlllIIIllllIIlllIllIIIl = false;
    public boolean llllIIlIIlIIlIIllIIlIIllI = false;
    public boolean IlllllIlIIIlIIlIIllIIlIll = false;
    public Map llIIlIlIIIllIlIlIlIIlIIll = new HashMap();
    public ResourceLocationBridge IlIlIlllllIlIIlIlIlllIlIl;
    public ResourceLocationBridge llIIIIIIIllIIllIlIllIIIIl;
    public ModelMesh lIIIllIllIIllIlllIlIIlllI;
    @Nullable
    public AnimationTickingTexture llIIIlllIIlllIllllIlIllIl;
    public BodySection lllllIllIllIllllIlIllllII;
    public BodyPart lllIIIIIlllIIlIllIIlIIIlI = BodyPart.HEAD;
    public List<CosmeticRotationHelper> lIlIIIIIIlIIIllllIllIIlII = new ArrayList();

    public AbstractCosmetic(String string, BodyPart bodyPart, BodySection bodySection, boolean bl, CosmeticRotationHelper... cosmeticRotationHelperArray) {
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
        this.lIllIlIIIlIIIIIIIlllIlIll = bl;
        this.lllIIIIIlllIIlIllIIlIIIlI = bodyPart;
        this.lllllIllIllIllllIlIllllII = bodySection;
        this.IlIlIlllllIlIIlIlIlllIlIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", String.format(lIlIlIlIlIIlIIlIIllIIIIIl, bodySection.name().toLowerCase(), string, string + ".png"));
        this.llIIIIIIIllIIllIlIllIIIIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", String.format(lIlIlIlIlIIlIIlIIllIIIIIl, bodySection.name().toLowerCase(), string, string + ".obj"));
        this.lIlIIIIIIlIIIllllIllIIlII.addAll(Arrays.asList(cosmeticRotationHelperArray));
    }

    @Override
    public ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    @Override
    public ResourceLocationBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        Preconditions.checkState(!this.llllIIlIIlIIlIIllIIlIIllI, "cosmetic already loaded");
        if (this.lIIIllIllIIllIlllIlIIlllI == null) {
            SimpleResourceBridge simpleResourceBridge = Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getResourceManager().bridge$getResource(this.llIIIIIIIllIIllIlIllIIIIl);
            BOBJLoader.BOBJData bOBJData = BOBJLoader.readData(simpleResourceBridge.bridge$getInputStream());
            this.lIIIllIllIIllIlllIlIIlllI = new ModelMesh(bOBJData);
            this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl();
        }
        this.llllIIlIIlIIlIIllIIlIIllI = true;
    }

    public AnimationTickingTexture llIlllIIIllllIIlllIllIIIl() {
        if (this.llIIIIIIIllIIllIlIllIIIIl()) {
            return null;
        }
        SimpleResourceBridge simpleResourceBridge = Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getResourceManager().bridge$getResource(this.IlIlIlllllIlIIlIlIlllIlIl);
        AnimationTickingTexture animationTickingTexture = new AnimationTickingTexture(this.IlIlIlllllIlIIlIlIlllIlIl, (AnimationMetadataSectionBridge)simpleResourceBridge.bridge$getMetadata("animation"));
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getTextureManager().bridge$loadTickableTexture(this.IlIlIlllllIlIIlIlIlllIlIl, Bridge.llIlllIIIllllIIlllIllIIIl().initTickingTexture(animationTickingTexture));
        this.llIIIlllIIlllIllllIlIllIl = animationTickingTexture;
        return animationTickingTexture;
    }

    public AbstractCosmetic lIlIlIlIlIIlIIlIIllIIIIIl(String ... stringArray) {
        for (String string : stringArray) {
            this.llIIlIlIIIllIlIlIlIIlIIll.put(string, true);
        }
        return this;
    }

    public AbstractCosmetic lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.llIIlIlIIIllIlIlIlIIlIIll.put(string, false);
        return this;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2) {
        if (this.llIIlIlIIIllIlIlIlIIlIIll.containsKey(lIllIlIIIlIIIIIIIlllIlIll2.IlIlIlllllIlIIlIlIlllIlIl())) {
            return (Boolean)this.llIIlIlIIIllIlIlIlIIlIIll.get(lIllIlIIIlIIIIIIIlllIlIll2.IlIlIlllllIlIIlIlIlllIlIl());
        }
        return this.llIIlIlIIIllIlIlIlIIlIIll.containsKey("any");
    }

    @Override
    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    @Override
    public String IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    @Override
    public boolean llIIIIIIIllIIllIlIllIIIIl() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    @Override
    public AbstractCosmetic lIIIllIllIIllIlllIlIIlllI() {
        this.IlllllIlIIIlIIlIIllIIlIll = true;
        return this;
    }

    @Override
    public boolean IlllllIlIIIlIIlIIllIIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    @Override
    public BodyPart llIIlIlIIIllIlIlIlIIlIIll() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    @Override
    public Collection<CosmeticRotationHelper> llIIIlllIIlllIllllIlIllIl() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    @Override
    public AbstractCosmetic lllllIllIllIllllIlIllllII() {
        this.llIlllIIIllllIIlllIllIIIl = true;
        return this;
    }

    public AnimationTickingTexture lllIIIIIlllIIlIllIIlIIIlI() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    @Override
    public ModelMesh lIlIIIIIIlIIIllllIllIIlII() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    @Override
    public void llIlIIIllIIlIllIllIllllIl() {
        if (this.IlllllIlIIIlIIlIIllIIlIll()) {
            AnimationTickingTexture animationTickingTexture = this.lllIIIIIlllIIlIllIIlIIIlI();
            if (animationTickingTexture == null) {
                try {
                    animationTickingTexture = this.llIlllIIIllllIIlllIllIIIl();
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            if (animationTickingTexture == null) {
                return;
            }
            int n = animationTickingTexture.lIlIlIlIlIIlIIlIIllIIIIIl() * animationTickingTexture.IlllIIIIIIlllIlIIlllIlIIl();
            int n2 = animationTickingTexture.IlllIIIIIIlllIlIIlllIlIIl();
            this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl(n, n2);
        }
    }
}
 