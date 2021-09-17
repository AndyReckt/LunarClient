package com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;

public class CosmeticsListUIComponent
extends AbstractListUIComponent {
    public static EntityPlayerSPBridge lIlIlIlIlIIlIIlIIllIIIIIl = CosmeticsListUIComponent.llllIIlIIlIIlIIllIIlIIllI();
    public final CosmeticsUIScreenBase IlllIIIIIIlllIlIIlllIlIIl;
    public final lllllIllIlIIlIIlIIIlllIlI lIllIlIIIlIIIIIIIlllIlIll;
    public CosmeticsButtonListUIComponent IIlIllIlllllllIIlIIIllIIl;
    public llIllIlIllIlllIllIIIIllII lIIlIlllIlIlIIIlllIIlIIII;
    public llIllIlIllIlllIllIIIIllII llIllIlIllIlllIllIIIIllII;
    public final IIlIllIlIIllIIlIlIllllllI IllllllllllIlIIIlllIlllll = new IIlIllIlIIllIIlIlIllllllI(null);
    public int lllllIllIlIIlIIlIIIlllIlI = 5;
    public MouseEventCallback IllIIIlllIIIlIlllIlIIlIII;
    public boolean IIlIllIlIIllIIlIlIllllllI;
    public float lIIIlllIIIIllllIlIIIlIIll = -180.0f;
    public float llIIIlIllIIIIlIIIlIlIllIl = 0.0f;
    public float llllIlIllllIlIlIIIllIlIlI = 0.0f;

    public CosmeticsListUIComponent(CosmeticsUIScreenBase cosmeticsUIScreenBase) {
        super(null);
        this.IlllIIIIIIlllIlIIlllIlIIl = cosmeticsUIScreenBase;
        this.IIlIllIlllllllIIlIIIllIIl = (CosmeticsButtonListUIComponent)this.llIlIIIllIIlIllIllIllllIl.get(0);
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(true);
        this.IllIIIlllIIIlIlllIlIIlIII = this.IlllllIlIIIlIIlIIllIIlIll;
        this.lIIlIlllIlIlIIIlllIIlIIII = new llIllIlIllIlllIllIIIIllII(this, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/cosmetics/back-40x40.png"));
        this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll(new ColorEase(0x20FFFFFF, 1358901296));
        this.llIllIlIllIlllIllIIIIllII = new llIllIlIllIlllIllIIIIllII(this, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/cosmetics/cart-40x40.png"));
        this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll(true);
        this.llIllIlIllIlllIllIIIIllII.IlllIIIIIIlllIlIIlllIlIIl(false);
        this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(2.5f);
        this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(new ColorEase(-2133114816, -2408384));
        this.lIllIlIIIlIIIIIIIlllIlIll = new lllllIllIlIIlIIlIIIlllIlI(this, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/magnifying-glass-12x12.png"), FontRegistry.llllIIlIIlIIlIIllIIlIIllI, "searchPlaceholder", 0x20FFFFFF, 0x35FFFFFF);
        this.lIllIlIIIlIIIIIIIlllIlIll((f, f2, n) -> {
            if (this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(this.IlllIIIIIIlllIlIIlllIlIIl.llIIIIIIIllIIllIlIllIIIIl());
                return true;
            }
            return false;
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (!Ref.getAssetsWebsocket().isPresent() || ((AssetsWebSocket)Ref.getAssetsWebsocket().get()).lIlIlIlIlIIlIIlIIllIIIIIl() != WebSocketState.READY) {
                return false;
            }
            for (AbstractCosmeticUIComponent abstractCosmeticUIComponent : this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII()) {
                boolean bl;
                boolean bl2 = abstractCosmeticUIComponent.lIlIIIIIIlIIIllllIllIIlII() + abstractCosmeticUIComponent.IllIllIIIllIIIlIlIlIIIIll() + this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll() < this.IllllllllllIlIIIlllIlllll.lIlIIIIIIlIIIllllIllIIlII();
                boolean bl3 = bl = abstractCosmeticUIComponent.lIlIIIIIIlIIIllllIllIIlII() + this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll() > this.IllllllllllIlIIIlllIlllll.lIlIIIIIIlIIIllllIllIIlII() + this.IllllllllllIlIIIlllIlllll.IllIllIIIllIIIlIlIlIIIIll();
                if (!(abstractCosmeticUIComponent.lllIIIIIlllIIlIllIIlIIIlI() >= this.x + 20.0f) || !(f2 > this.y + 38.0f) || !(f2 < this.y + this.height - 20.0f) || bl2 || bl || !abstractCosmeticUIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll())) continue;
                Cosmetic cosmetic = abstractCosmeticUIComponent.llIIIIIIIllIIllIlIllIIIIl();
                if (cosmetic.llIIIIIIIllIIllIlIllIIIIl()) {
                    cosmetic.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                } else {
                    for (Cosmetic cosmetic2 : LunarClient.IIllIlIllIlIllIllIllIllII().IIlIllIlIIllIIlIlIllllllI().llIlllIIIllllIIlllIllIIIl()) {
                        if (cosmetic2 == cosmetic) continue;
                        if (cosmetic2 instanceof HatCosmeticType && cosmetic instanceof HatCosmeticType) {
                            HatCosmetic hatCosmetic = Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(cosmetic.llllIIlIIlIIlIIllIIlIIllI());
                            HatCosmetic hatCosmetic2 = Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(cosmetic2.llllIIlIIlIIlIIllIIlIIllI());
                            if (hatCosmetic != null && hatCosmetic2 != null && (hatCosmetic.lIlIlIlIlIIlIIlIIllIIIIIl(hatCosmetic2) || hatCosmetic2.lIlIlIlIlIIlIIlIIllIIIIIl(hatCosmetic)) && (hatCosmetic.llIllIlIllIlllIllIIIIllII() == HatCosmetic.Type.HAT && hatCosmetic2.llIllIlIllIlllIllIIIIllII() == HatCosmetic.Type.HAT || hatCosmetic.llIllIlIllIlllIllIIIIllII() != hatCosmetic2.llIllIlIllIlllIllIIIIllII())) continue;
                            cosmetic2.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                            continue;
                        }
                        if (cosmetic2.lIllIlIIIlIIIIIIIlllIlIll() != cosmetic.lIllIlIIIlIIIIIIIlllIlIll()) continue;
                        cosmetic2.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                    }
                    cosmetic.lIlIlIlIlIIlIIlIIllIIIIIl(true);
                }
                LunarClient.IIllIlIllIlIllIllIllIllII().IIlIllIlIIllIIlIlIllllllI().llllIIlIIlIIlIIllIIlIIllI();
                Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSession().bridge$getProfile().getId(), lIlIlIlIlIIlIIlIIllIIIIIl.bridge$getGameProfile().getId());
                return true;
            }
            if (this.llIllIlIllIlllIllIIIIllII.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                StringBuilder stringBuilder = new StringBuilder("https://store.lunarclient.com/");
                if (this.IIlIllIlllllllIIlIIIllIIl != null) {
                    stringBuilder.append("category/").append(this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI().llIIIIIIIllIIllIlIllIIIIl());
                }
                return BrowserUtil.lIlIlIlIlIIlIIlIIllIIIIIl(stringBuilder.toString());
            }
            if (this.IllllllllllIlIIIlllIlllll.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
            }
            if (this.IllIIIlllIIIlIlllIlIIlIII.accept(f, f2, n)) {
                return true;
            }
            if (this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            return false;
        });
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl = this::IllllllllllIlIIIlllIlllll;
        this.IlllIIIIIIlllIlIIlllIlIIl(this.lIllIlIIIlIIIIIIIlllIlIll::IlllIIIIIIlllIlIIlllIlIIl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(true);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
    }

    @Override
    public List lIllIlIIIlIIIIIIIlllIlIll() {
        ArrayList<CosmeticsButtonListUIComponent> arrayList = new ArrayList<CosmeticsButtonListUIComponent>();
        for (CosmeticType cosmeticType : CosmeticType.values()) {
            if (cosmeticType.lIllIlIIIlIIIIIIIlllIlIll() != null) continue;
            arrayList.add(new CosmeticsButtonListUIComponent(this, cosmeticType));
        }
        return arrayList;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        Object object2;
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x - 1.0f, this.y, this.width + 2.0f, this.height, 4.0f, 1612586526);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 3.25f, 1075715614);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 5.0f, -1306912744);
        AbstractUIScreen.IlIlIlllllIlIIlIlIlllIlIl(this.x, this.y + 1.0f, 40.0f, this.height - 2.0f, 5.0f, 0x36000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 40.5f, this.y + 1.0f, 0.5f, this.height - 2.0f, 0x20FFFFFF);
        float f3 = this.x + this.width - this.width / 5.0f;
        float f4 = this.y;
        float f5 = f3 - f;
        float f6 = f4 + 80.0f - f2;
        if (!Ref.getAssetsWebsocket().isPresent()) {
            FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl("Invalid login...", this.x + (this.width - 100.0f) / 2.0f, this.y + this.height / 2.0f - 10.0f, -1);
        } else if (((AssetsWebSocket)Ref.getAssetsWebsocket().get()).lIlIlIlIlIIlIIlIIllIIIIIl() != WebSocketState.READY) {
            FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl("Connecting...", this.x + (this.width - 100.0f) / 2.0f, this.y + this.height / 2.0f - 10.0f, -1);
        } else {
            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            GL11.glEnable((int)3089);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x + 20.0f), (int)(this.y + 38.0f), (int)(this.x + this.width), (int)(this.y + this.height - 20.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.IlllIIIIIIlllIlIIlllIlIIl.lllllIllIlIIlIIlIIIlllIlI());
            this.IllllllllllIlIIIlllIlllll.IlllIIIIIIlllIlIIlllIlIIl(f, f2, true);
            if (this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII().isEmpty()) {
                String string = this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI().lIlIlIlIlIIlIIlIIllIIIIIl().contains("_") ? this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI().lIlIlIlIlIIlIIlIIllIIIIIl().split("_")[1] : this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI().lIlIlIlIlIIlIIlIIllIIIIIl();
                FontRegistry.llIllIlIllIlllIllIIIIllII().IlllIIIIIIlllIlIIlllIlIIl("You don't own any " + (String)string + (string.endsWith("s") ? "" : "s"), this.x + 175.0f, this.y + this.height / 2.0f - 10.0f, -1342177281);
            } else {
                for (Object object2 : this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII()) {
                    boolean bl2;
                    boolean bl3 = ((UIComponent)object2).lIlIIIIIIlIIIllllIllIIlII() + ((UIComponent)object2).IllIllIIIllIIIlIlIlIIIIll() + this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll() < this.IllllllllllIlIIIlllIlllll.lIlIIIIIIlIIIllllIllIIlII();
                    boolean bl4 = bl2 = ((UIComponent)object2).lIlIIIIIIlIIIllllIllIIlII() + this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll() > this.IllllllllllIlIIIlllIlllll.lIlIIIIIIlIIIllllIllIIlII() + this.IllllllllllIlIIIlllIlllll.IllIllIIIllIIIlIlIlIIIIll();
                    if (!(((UIComponent)object2).lllIIIIIlllIIlIllIIlIIIlI() >= this.x + 20.0f) || bl3 || bl2) continue;
                    ((UIComponent)object2).lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll(), !this.IllllllllllIlIIIlllIlllll.lIIIllIllIIllIlllIlIIlllI());
                }
            }
            this.IllllllllllIlIIIlllIlllll.llllIIlIIlIIlIIllIIlIIllI(f, f2, true);
            GL11.glDisable((int)3089);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        }
        if (this.IIlIllIlIIllIIlIlIllllllI) {
            float f7 = f - f3 + (f3 - this.llIIIlIllIIIIlIIIlIlIllIl);
            this.lIIIlllIIIIllllIlIIIlIIll = this.llllIlIllllIlIlIIIllIlIlI + f7;
        }
        float f8 = Bridge.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIlIlIIlIIlIIllIIIIIl() ? 180.0f : 0.0f;
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawEntityOnScreen(f3, this.y + this.height - 55.0f, 100.0f, this.lIIIlllIIIIllllIlIIIlIIll - f8, f5, f6, lIlIlIlIlIIlIIlIIllIIIIIl);
        object2 = "None";
        for (AbstractCosmeticUIComponent abstractCosmeticUIComponent : this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII()) {
            if (!abstractCosmeticUIComponent.lIllIlIIIlIIIIIIIlllIlIll()) continue;
            object2 = abstractCosmeticUIComponent.llIlllIIIllllIIlllIllIIIl();
            break;
        }
        FontRegistry.llIIIlllIIlllIllllIlIllIl().IlllIIIIIIlllIlIIlllIlIIl(((String)object2).toUpperCase(), f3, this.y + this.height - 30.0f, 0x40FFFFFF);
        FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().IlllIIIIIIlllIlIIlllIlIIl(this.IlllIIIIIIlllIlIIlllIlIIl.get("hint", new Object[0]), f3, this.y + this.height - 40.0f, 0x40FFFFFF);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl && this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2));
        this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl && this.llIllIlIllIlllIllIIIIllII.IlllIIIIIIlllIlIIlllIlIIl(f, f2));
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        float f5 = f + 40.0f;
        float f6 = f2;
        if (Ref.llIIIIIIIllIIllIlIllIIIIl() == null && lIlIlIlIlIIlIIlIIllIIIIIl != null) {
            this.lllIIIIIlllIIlIllIIlIIIlI.bridge$getRenderManager().bridge$prepare(lIlIlIlIlIIlIIlIIllIIIIIl.bridge$getWorld(), lIlIlIlIlIIlIIlIIllIIIIIl);
        }
        LunarClient.IIllIlIllIlIllIllIllIllII().IIlIllIlIIllIIlIlIllllllI().IlIlIlllllIlIIlIlIlllIlIl();
        this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(f5 + 245.0f, f2 + 38.0f, 3.0f, f4 - 58.0f);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(f + 7.0f, f2 + f4 - 26.0f - 7.0f, 26.0f, 26.0f);
        this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(f + 7.0f, f2 + f4 - 66.0f, 26.0f, 26.0f);
        int n = 0;
        for (CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent : this.llIlIIIllIIlIllIllIllllIl) {
            cosmeticsButtonListUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f + 7.0f, f2 + f4 / 2.0f - (float)this.llIlIIIllIIlIllIllIllllIl.size() * 32.0f / 2.0f + (float)n);
            n = (int)((float)n + (cosmeticsButtonListUIComponent.IllIllIIIllIIIlIlIlIIIIll() + 4.0f));
        }
        this.IllllllllllIlIIIlllIlllll();
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f + 60.0f, f2 + 15.0f, 220.0f, 18.0f);
    }

    public void IllllllllllIlIIIlllIlllll() {
        float f = this.x + 40.0f;
        float f2 = this.y;
        HashMap<Long, Object> hashMap = new HashMap<Long, Object>();
        if (!this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI().isEmpty() && this.IIlIllIlllllllIIlIIIllIIl != null) {
            for (Object object : this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII()) {
                String[] stringArray;
                long l = ((AbstractCosmeticUIComponent)object).llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl();
                if (hashMap.containsKey(l)) continue;
                Object object2 = EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(((AbstractCosmeticUIComponent)object).llIIIIIIIllIIllIlIllIIIIl().IlllIIIIIIlllIlIIlllIlIIl().toLowerCase());
                String string = this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI();
                string = LanguageParser.lIlIlIlIlIIlIIlIIllIIIIIl(string);
                for (String string2 : stringArray = ((String)object2).split(" ")) {
                    if (!(string2 = LanguageParser.lIlIlIlIlIIlIIlIIllIIIIIl(string2)).toLowerCase().startsWith(string.toLowerCase())) continue;
                    hashMap.put(((AbstractCosmeticUIComponent)object).llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(), object);
                }
            }
        }
        int n = 0;
        for (CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent : this.llIlIIIllIIlIllIllIllllIl) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(hashMap, cosmeticsButtonListUIComponent, f, f2);
            for (Object object2 : cosmeticsButtonListUIComponent.llIIIIIIIllIIllIlIllIIIIl()) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(hashMap, (CosmeticsButtonListUIComponent)object2, f, f2);
            }
            n = (int)((float)n + (cosmeticsButtonListUIComponent.IllIllIIIllIIIlIlIlIIIIll() + 4.0f));
        }
        float f3 = (float)(this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI().isEmpty() ? this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII().size() : hashMap.size()) / (float)this.lllllIllIlIIlIIlIIIlllIlI;
        this.IllllllllllIlIIIlllIlllll.IlIlIlllllIlIIlIlIlllIlIl((float)(Math.ceil(f3) * (double)(this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI().IlIlIlllllIlIIlIlIlllIlIl() + 5)) - 5.0f);
    }

    public static EntityPlayerSPBridge llllIIlIIlIIlIIllIIlIIllI() {
        MinecraftBridge minecraftBridge = Ref.lIlIlIlIlIIlIIlIIllIIIIIl();
        EntityPlayerSPBridge entityPlayerSPBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initDummyPlayer();
        entityPlayerSPBridge.bridge$setDimension(0);
        entityPlayerSPBridge.bridge$setMovementInput(Bridge.llIlllIIIllllIIlllIllIIIl().initMovementInput(minecraftBridge.bridge$getGameSettings()));
        minecraftBridge.bridge$getRenderManager().bridge$setTextureManager(minecraftBridge.bridge$getTextureManager());
        minecraftBridge.bridge$getRenderManager().bridge$setLivingEntity(entityPlayerSPBridge);
        minecraftBridge.bridge$getRenderManager().bridge$setOptions(minecraftBridge.bridge$getGameSettings());
        entityPlayerSPBridge.bridge$setPosX(0.0);
        entityPlayerSPBridge.bridge$setPreviousPosX(0.0);
        entityPlayerSPBridge.bridge$setPosZ(0.0);
        entityPlayerSPBridge.bridge$setPreviousPosZ(0.0);
        entityPlayerSPBridge.bridge$setPosY(0.0);
        entityPlayerSPBridge.bridge$setPreviousPosY(0.0);
        entityPlayerSPBridge.bridge$setDimension(0);
        entityPlayerSPBridge.bridge$preparePlayerToSpawn();
        if (Bridge.IlllIIIIIIlllIlIIlllIlIIl().ordinal() >= MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl.ordinal()) {
            byte by = 0;
            for (Object e : Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$getModelParts()) {
                if (!(e instanceof EnumPlayerModelPartsBridge)) continue;
                by = (byte)(by | ((EnumPlayerModelPartsBridge)e).bridge$getMask());
            }
            entityPlayerSPBridge.bridge$getDataWatcher().bridge$updateObject(10, by);
        }
        minecraftBridge.bridge$getRenderManager().bridge$prepare(entityPlayerSPBridge.bridge$getWorld(), entityPlayerSPBridge);
        Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSession().bridge$getProfile().getId(), entityPlayerSPBridge.bridge$getGameProfile().getId());
        return entityPlayerSPBridge;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Map map, CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent, float f, float f2) {
        int n = 0;
        int n2 = 0;
        for (AbstractCosmeticUIComponent abstractCosmeticUIComponent : cosmeticsButtonListUIComponent.lIIlIlllIlIlIIIlllIIlIIII()) {
            HatCosmetic hatCosmetic;
            if (!this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI().isEmpty() && !map.containsKey(abstractCosmeticUIComponent.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl())) {
                abstractCosmeticUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f - 20.0f - abstractCosmeticUIComponent.llIlIIIllIIlIllIllIllllIl(), f2, abstractCosmeticUIComponent.llIlIIIllIIlIllIllIllllIl(), abstractCosmeticUIComponent.IllIllIIIllIIIlIlIlIIIIll());
                continue;
            }
            if (abstractCosmeticUIComponent.llIIIIIIIllIIllIlIllIIIIl() instanceof HatCosmeticType && (hatCosmetic = Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(abstractCosmeticUIComponent.llIIIIIIIllIIllIlIllIIIIl().llllIIlIIlIIlIIllIIlIIllI())) == null) continue;
            if (n == this.lllllIllIlIIlIIlIIIlllIlI) {
                n = 0;
                ++n2;
            }
            abstractCosmeticUIComponent.IlllIIIIIIlllIlIIlllIlIIl(n2 + n);
            abstractCosmeticUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f + 20.0f + (float)(n * (cosmeticsButtonListUIComponent.llllIIlIIlIIlIIllIIlIIllI().llllIIlIIlIIlIIllIIlIIllI() + 5)), f2 + 38.0f + (float)(n2 * (cosmeticsButtonListUIComponent.llllIIlIIlIIlIIllIIlIIllI().IlIlIlllllIlIIlIlIlllIlIl() + 5)), cosmeticsButtonListUIComponent.llllIIlIIlIIlIIllIIlIIllI().llllIIlIIlIIlIIllIIlIIllI(), cosmeticsButtonListUIComponent.llllIIlIIlIIlIIllIIlIIllI().IlIlIlllllIlIIlIlIlllIlIl());
            ++n;
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent) {
        if (this.IIlIllIlllllllIIlIIIllIIl != null) {
            this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII().forEach(AbstractCosmeticUIComponent::llllIIlIIlIIlIIllIIlIIllI);
        }
        this.IIlIllIlllllllIIlIIIllIIl = cosmeticsButtonListUIComponent;
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl("");
        switch (cosmeticsButtonListUIComponent.llllIIlIIlIIlIIllIIlIIllI()) {
            case CLOAK: 
            case WINGS: {
                this.lIIIlllIIIIllllIlIIIlIIll = -180.0f;
                break;
            }
            default: {
                this.lIIIlllIIIIllllIlIIIlIIll = 0.0f;
            }
        }
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll(float f, float f2, int n) {
        if (this.IIlIllIlIIllIIlIlIllllllI) {
            this.IIlIllIlIIllIIlIlIllllllI = false;
            this.llllIlIllllIlIlIIIllIlIlI = this.lIIIlllIIIIllllIlIIIlIIll;
        }
        return super.lIllIlIIIlIIIIIIIlllIlIll(f, f2, n);
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        boolean bl;
        float f3 = this.x + this.width - this.width / 5.0f;
        float f4 = this.y;
        boolean bl2 = bl = f > f3 - 60.0f && f < f3 + 60.0f && f2 > f4 + 40.0f && f2 < f4 + this.height - 70.0f;
        if (!this.IIlIllIlIIllIIlIlIllllllI && bl && Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
            this.IIlIllIlIIllIIlIlIllllllI = true;
            this.llllIlIllllIlIlIIIllIlIlI = this.lIIIlllIIIIllllIlIIIlIIll;
            this.llIIIlIllIIIIlIIIlIlIllIl = f;
        }
        if (n == 1 && this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl("");
            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            this.IllllllllllIlIIIlllIlllll();
            return true;
        }
        return super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
    }

    public static EntityPlayerSPBridge llIIIIIIIllIIllIlIllIIIIl() {
        return lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerSPBridge entityPlayerSPBridge) {
        lIlIlIlIlIIlIIlIIllIIIIIl = entityPlayerSPBridge;
    }

    public CosmeticsUIScreenBase lIIIllIllIIllIlllIlIIlllI() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public lllllIllIlIIlIIlIIIlllIlI IlllllIlIIIlIIlIIllIIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public CosmeticsButtonListUIComponent llIIlIlIIIllIlIlIlIIlIIll() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }
}
 