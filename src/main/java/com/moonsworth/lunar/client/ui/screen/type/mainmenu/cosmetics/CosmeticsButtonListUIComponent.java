package com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.cosmetic.CloakCosmetic;
import com.moonsworth.lunar.client.cosmetic.Cosmetic;
import com.moonsworth.lunar.client.cosmetic.CosmeticType;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.ease.ExponentialEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.component.AbstractCosmeticUIComponent;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.component.CloakCosmeticUIComponent;
import com.moonsworth.lunar.client.util.ColorUtil;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class CosmeticsButtonListUIComponent
extends AbstractListUIComponent {
    public CosmeticType IlllIIIIIIlllIlIIlllIlIIl;
    public boolean lIllIlIIIlIIIIIIIlllIlIll;
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl;
    public CosmeticsButtonListUIComponent IIlIllIlllllllIIlIIIllIIl;
    public ColorEase lIIlIlllIlIlIIIlllIIlIIII = new ColorEase(0x50FFFFFF, -1342177281);
    public ExponentialEase llIllIlIllIlllIllIIIIllII = new ExponentialEase(350L);
    public ExponentialEase IllllllllllIlIIIlllIlllll = new ExponentialEase(350L);
    public float lllllIllIlIIlIIlIIIlllIlI = 20.0f;
    public final List<CosmeticsButtonListUIComponent> IllIIIlllIIIlIlllIlIIlIII = new ArrayList();

    public CosmeticsButtonListUIComponent(UIComponent uIComponent, CosmeticType cosmeticType) {
        this(uIComponent, null, cosmeticType);
    }

    public CosmeticsButtonListUIComponent(UIComponent uIComponent, CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent, CosmeticType cosmeticType) {
        super(uIComponent);
        this.IlllIIIIIIlllIlIIlllIlIIl = cosmeticType;
        this.IIlIllIlllllllIIlIIIllIIl = cosmeticsButtonListUIComponent;
        for (CosmeticType cosmeticType2 : CosmeticType.values()) {
            if (cosmeticType2.lIllIlIIIlIIIIIIIlllIlIll() != cosmeticType) continue;
            CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent2 = new CosmeticsButtonListUIComponent(uIComponent, this, cosmeticType2);
            this.IllIIIlllIIIlIlllIlIIlIII.add(cosmeticsButtonListUIComponent2);
            cosmeticsButtonListUIComponent2.lIlIlIlIlIIlIIlIIllIIIIIl(14.0f);
            cosmeticsButtonListUIComponent2.lIlIlIlIlIIlIIlIIllIIIIIl = true;
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                if (this.IllllllllllIlIIIlllIlllll.lIIIllIllIIllIlllIlIIlllI() || this.llIllIlIllIlllIllIIIIllII.lIIIllIllIIllIlllIlIIlllI()) {
                    return false;
                }
                boolean bl = false;
                for (CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent : this.IllIIIlllIIIlIlllIlIIlIII) {
                    if (!cosmeticsButtonListUIComponent.lIllIlIIIlIIIIIIIlllIlIll) continue;
                    bl = true;
                    break;
                }
                for (CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent : this.IllIIIlllIIIlIlllIlIIlIII) {
                    if (!cosmeticsButtonListUIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) continue;
                    return cosmeticsButtonListUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
                }
                if (!this.lIllIlIIIlIIIIIIIlllIlIll) {
                    CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent = ((CosmeticsListUIComponent)uIComponent).llIIlIlIIIllIlIlIlIIlIIll();
                    ((CosmeticsListUIComponent)uIComponent).lIlIlIlIlIIlIIlIIllIIIIIl(this);
                    cosmeticsButtonListUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                    this.lIllIlIIIlIIIIIIIlllIlIll = true;
                    if (!bl) {
                        this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll();
                    }
                    return true;
                }
            }
            return false;
        });
        this.save();
    }

    @Override
    public List lIllIlIIIlIIIIIIIlllIlIll() {
        return new ArrayList();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        float f3 = 26.0f;
        if (this.lIllIlIIIlIIIIIIIlllIlIll && !this.IllIIIlllIIIlIlllIlIIlIII.isEmpty() && this.llIllIlIllIlllIllIIIIllII.lIIIllIllIIllIlllIlIIlllI()) {
            f3 += (float)this.IllIIIlllIIIlIlllIlIIlIII.size() * 18.0f * this.llIllIlIllIlllIllIIIIllII.IlllllIlIIIlIIlIIllIIlIll();
        } else if (!this.lIllIlIIIlIIIIIIIlllIlIll && !this.IllIIIlllIIIlIlllIlIIlIII.isEmpty() && this.IllllllllllIlIIIlllIlllll.lIIIllIllIIllIlllIlIIlllI()) {
            f3 = 26.0f + (float)this.IllIIIlllIIIlIlllIlIIlIII.size() * 18.0f - (float)this.IllIIIlllIIIlIlllIlIIlIII.size() * 18.0f * this.IllllllllllIlIIIlllIlllll.IlllllIlIIIlIIlIIllIIlIll();
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, 26.0f, f3);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        int n = 0;
        for (CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent : this.IllIIIlllIIIlIlllIlIIlIII) {
            cosmeticsButtonListUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f + 6.0f, f2 + 28.0f + (float)n * 16.0f, 14.0f, 14.0f);
            ++n;
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        if (this.IIlIllIlllllllIIlIIIllIIl != null) {
            this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            if (((CosmeticsListUIComponent)this.lIIIllIllIIllIlllIlIIlllI).llIIlIlIIIllIlIlIlIIlIIll() != this.IIlIllIlllllllIIlIIIllIIl && !this.IIlIllIlllllllIIlIIIllIIl.IllIIIlllIIIlIlllIlIIlIII.contains(((CosmeticsListUIComponent)this.lIIIllIllIIllIlllIlIIlllI).llIIlIlIIIllIlIlIlIIlIIll())) {
                this.IIlIllIlllllllIIlIIIllIIl.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll();
            }
        }
        if (!bl && this.lIllIlIIIlIIIIIIIlllIlIll && !this.IllIIIlllIIIlIlllIlIIlIII.contains(((CosmeticsListUIComponent)this.lIIIllIllIIllIlllIlIIlllI).llIIlIlIIIllIlIlIlIIlIIll())) {
            this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll();
        }
        this.lIllIlIIIlIIIIIIIlllIlIll = bl;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        if (!this.lIlIlIlIlIIlIIlIIllIIIIIl && !this.IllIIIlllIIIlIlllIlIIlIII.isEmpty() && (this.llIllIlIllIlllIllIIIIllII.lIIIllIllIIllIlllIlIIlllI() || this.IllllllllllIlIIIlllIlllll.lIIIllIllIIllIlllIlIIlllI())) {
            if (!this.IllIIIlllIIIlIlllIlIIlIII.isEmpty()) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y);
            }
            this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIllIllIIllIlllIlIIlllI.lllIIIIIlllIIlIllIIlIIIlI(), this.lIIIllIllIIllIlllIlIIlllI.lIlIIIIIIlIIIllllIllIIlII(), this.lIIIllIllIIllIlllIlIIlllI.llIlIIIllIIlIllIllIllllIl(), this.lIIIllIllIIllIlllIlIIlllI.IllIllIIIllIIIlIlIlIIIIll());
        }
        int n = this.lIllIlIIIlIIIIIIIlllIlIll ? (int) this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl() : this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && bl);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(n), ColorUtil.lIllIlIIIlIIIIIIIlllIlIll(n), ColorUtil.llllIIlIIlIIlIIllIIlIIllI(n), ColorUtil.llIIIIIIIllIIllIlIllIIIIl(n));
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.llIlllIIIllllIIlllIllIIIl(), this.x + this.width / 2.0f - this.lllllIllIlIIlIIlIIIlllIlI / 2.0f, this.y + (!this.lIlIlIlIlIIlIIlIIllIIIIIl ? 13.0f - this.lllllIllIlIIlIIlIIIlllIlI / 2.0f : 0.0f), this.lllllIllIlIIlIIlIIIlllIlI, this.lllllIllIlIIlIIlIIIlllIlI);
        if (((CosmeticsListUIComponent)this.lIIIllIllIIllIlllIlIIlllI).lIIlIlllIlIlIIIlllIIlIIII().indexOf(this) != ((CosmeticsListUIComponent)this.lIIIllIllIIllIlllIlIIlllI).lIIlIlllIlIlIIIlllIIlIIII().size() - 1 && !this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x + 5.0f, this.y + this.height + 3.0f - 0.5f, this.x + this.width - 5.0f, this.y + this.height + 3.0f, 0x50FFFFFF);
        }
        if ((this.lIllIlIIIlIIIIIIIlllIlIll || this.IllllllllllIlIIIlllIlllll.lIIIllIllIIllIlllIlIIlllI()) && !this.IllIIIlllIIIlIlllIlIIlIII.isEmpty() || this.IllIIIlllIIIlIlllIlIIlIII.contains(((CosmeticsListUIComponent)this.lIIIllIllIIllIlllIlIIlllI).llIIlIlIIIllIlIlIlIIlIIll())) {
            float f3 = this.y + 25.0f;
            float f4 = this.height - 28.0f;
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            GL11.glEnable((int)3089);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)this.x, (int)(this.y + 24.0f), (int)(this.x + this.width), (int)(this.y + this.height), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)((CosmeticsListUIComponent)this.lIIIllIllIIllIlllIlIIlllI).lIIIllIllIIllIlllIlIIlllI().lllllIllIlIIlIIlIIIlllIlI());
            for (CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent : this.IllIIIlllIIIlIlllIlIIlIII) {
                cosmeticsButtonListUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
            }
            GL11.glDisable((int)3089);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        }
    }

    public void save() {
        ArrayList<Cosmetic> arrayList = new ArrayList<Cosmetic>();
        for (Cosmetic cosmetic3 : LunarClient.IIllIlIllIlIllIllIllIllII().IIlIllIlIIllIIlIlIllllllI().llIlllIIIllllIIlllIllIIIl()) {
            if (cosmetic3.lIllIlIIIlIIIIIIIlllIlIll() != this.IlllIIIIIIlllIlIIlllIlIIl) continue;
            arrayList.add(cosmetic3);
        }
        arrayList.sort((cosmetic, cosmetic2) -> cosmetic.IlllIIIIIIlllIlIIlllIlIIl().compareToIgnoreCase(cosmetic2.IlllIIIIIIlllIlIIlllIlIIl()));
        for (Cosmetic cosmetic3 : arrayList) {
            AbstractCosmeticUIComponent abstractCosmeticUIComponent = this.lIlIlIlIlIIlIIlIIllIIIIIl(cosmetic3);
            if (abstractCosmeticUIComponent == null) continue;
            this.llIlIIIllIIlIllIllIllllIl.add(abstractCosmeticUIComponent);
        }
    }

    public AbstractCosmeticUIComponent lIlIlIlIlIIlIIlIIllIIIIIl(Cosmetic cosmetic) {
        switch (this.IlllIIIIIIlllIlIIlllIlIIl) {
            case CLOAK: {
                return new CloakCosmeticUIComponent(null, (CloakCosmetic)cosmetic);
            }
            case WINGS: {
                return new llllIIlIIlIIlIIllIIlIIllI(null, (WingsCosmeticTypeWithRenderf)cosmetic);
            }
            case HAT: 
            case MASK: 
            case BANDANNA: 
            case BODYWEAR: {
                return new llIlllIIIllllIIlllIllIIIl(null, cosmetic);
            }
        }
        return null;
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
        super.IlllIIIIIIlllIlIIlllIlIIl();
        for (CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent : this.IllIIIlllIIIlIlllIlIIlIII) {
            cosmeticsButtonListUIComponent.IlllIIIIIIlllIlIIlllIlIIl();
        }
    }

    public CosmeticType llllIIlIIlIIlIIllIIlIIllI() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.lllllIllIlIIlIIlIIIlllIlI = f;
    }

    public List llIIIIIIIllIIllIlIllIIIIl() {
        return this.IllIIIlllIIIlIlllIlIIlIII;
    }
}
 