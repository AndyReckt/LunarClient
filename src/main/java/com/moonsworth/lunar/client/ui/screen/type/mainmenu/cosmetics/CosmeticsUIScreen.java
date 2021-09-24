package com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumPlayerModelPartsBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.cosmetic.CloakCosmetic;
import com.moonsworth.lunar.client.cosmetic.Cosmetic;
import com.moonsworth.lunar.client.cosmetic.type.HatCosmeticType;
import com.moonsworth.lunar.client.cosmetic.type.WingsCosmeticTypeWithRenderf;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.overlay.llIIlIlIIIllIlIlIlIIlIIll;
import com.moonsworth.lunar.client.ui.component.type.setting.DefaultButtonUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.ScrollbarUIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.BaseMainMenuUIScreen;
import com.moonsworth.lunar.client.util.BrowserUtil;
import com.moonsworth.lunar.client.websocket.WebSocketState;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class CosmeticsUIScreen extends BaseMainMenuUIScreen {
    public static EntityPlayerSPBridge player;
    public final float IllIllIIIllIIIlIlIlIIIIll = 310.0f;
    public final float IIlIllIlllllllIIlIIIllIIl = 130.0f;
    public final DefaultButtonUIComponent cloaks;
    public final DefaultButtonUIComponent wings;
    public final DefaultButtonUIComponent hats;
    public final DefaultButtonUIComponent back;
    public final com.moonsworth.lunar.client.ui.component.type.overlay.llIIlIlIIIllIlIlIlIIlIIll shop;
    public List<AbstractCosmeticUIComponent> cloaksList;
    public List<AbstractCosmeticUIComponent> wingsList;
    public List<AbstractCosmeticUIComponent> hatsList;
    public List<AbstractCosmeticUIComponent> selectedList;
    public ScrollbarUIComponent scrollbar = new ScrollbarUIComponent(null);
    public int lIllllIllIIlIIlIIIlIIIlII = 32;
    public int lIlIlIIIIIIllIlIIIIllIIII = 20;
    public int lIIlIIIIIIlIIlIIllIlIIlII = 7;
    public boolean IlIIlIIlIIlIIllIIIllIIllI;
    public float IIlIlIIIllIIllllIllllIlIl = 0.0f;

    public CosmeticsUIScreen() {
        this.cosmetics.lIlIlIlIlIIlIIlIIllIIIIIl(true);
        this.cloaksList = new ArrayList<>();
        this.wingsList = new ArrayList<>();
        this.hatsList = new ArrayList<>();
        this.selectedList = this.cloaksList;
        this.cloaks = new DefaultButtonUIComponent(null, this.get("cloaks"), FontRegistry.llllIIlIIlIIlIIllIIlIIllI);
        this.components.add(this.cloaks);
        this.wings = new DefaultButtonUIComponent(null, this.get("wings"), FontRegistry.llllIIlIIlIIlIIllIIlIIllI);
        this.components.add(this.wings);
        this.hats = new DefaultButtonUIComponent(null, this.get("hats"), FontRegistry.llllIIlIIlIIlIIllIIlIIllI);
        this.components.add(this.hats);
        this.back = new DefaultButtonUIComponent(null, this.get("back"), FontRegistry.llllIIlIIlIIlIIllIIlIIllI);
        this.components.add(this.back);
        this.shop = new llIIlIlIIIllIlIlIlIIlIIll(null, this.get("shop"), FontRegistry.llllIIlIIlIIlIIllIIlIIllI);
        this.components.add(this.shop);
        this.shop.setEase(new ColorEase(-5238511, -4504765));
        this.shop.IlllIIIIIIlllIlIIlllIlIIl(-4504765);
        this.cloaks.lIlIlIlIlIIlIIlIIllIIIIIl(true);
        this.cloaks.onMouseClick((float f, float f2, int n) -> {
            this.hats.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            this.cloaks.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            this.wings.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            this.selectedList = this.cloaksList;
            this.lIllllIllIIlIIlIIIlIIIlII = 32;
            this.lIlIlIIIIIIllIlIIIIllIIII = 20;
            this.lIIlIIIIIIlIIlIIllIlIIlII = 7;
            this.llIIIlllIIlllIllllIlIllIl();
            return true;
        });
        this.wings.onMouseClick((float f, float f2, int n) -> {
            this.hats.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            this.cloaks.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            this.wings.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            this.selectedList = this.wingsList;
            this.lIllllIllIIlIIlIIIlIIIlII = 32;
            this.lIlIlIIIIIIllIlIIIIllIIII = 20;
            this.lIIlIIIIIIlIIlIIllIlIIlII = 7;
            this.llIIIlllIIlllIllllIlIllIl();
            return true;
        });
        this.hats.onMouseClick((float f, float f2, int n) -> {
            this.cloaks.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            this.wings.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            this.hats.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            this.lIIlIIIIIIlIIlIIllIlIIlII = 4;
            this.lIllllIllIIlIIlIIIlIIIlII = 40;
            this.lIlIlIIIIIIllIlIIIIllIIII = 40;
            this.selectedList = this.hatsList;
            this.llIIIlllIIlllIllllIlIllIl();
            return true;
        });
        this.back.onMouseClick((float f, float f2, int n) -> {
            Ref.getMinecraft().bridge$displayScreen(null);
            return true;
        });
        this.shop.onMouseClick((float f, float f2, int n) -> {
            String string = "https://store.lunarclient.com/";
            if (this.wings.llIlllIIIllllIIlllIllIIIl()) {
                string = "https://store.lunarclient.com/category/wings";
            }
            return BrowserUtil.lIlIlIlIlIIlIIlIIllIIIIIl(string);
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.cloaksList, CloakCosmetic.class);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.wingsList, WingsCosmeticTypeWithRenderf.class);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.hatsList, HatCosmeticType.class);
        if (player == null) {
            CosmeticsUIScreen.silly();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(List<AbstractCosmeticUIComponent> list, Class<? extends Cosmetic> clazz) {
        ArrayList<Cosmetic> arrayList = new ArrayList<>();
        for (Cosmetic cosmetic3 : LunarClient.getInstance().IIlIllIlIIllIIlIlIllllllI().llIlllIIIllllIIlllIllIIIl()) {
            if (cosmetic3.getClass() != clazz) continue;
            arrayList.add(cosmetic3);
        }
        arrayList.sort((cosmetic, cosmetic2) -> cosmetic.IlllIIIIIIlllIlIIlllIlIIl().compareToIgnoreCase(cosmetic2.IlllIIIIIIlllIlIIlllIlIIl()));
        if (clazz == HatCosmeticType.class) {
            arrayList.sort((cosmetic, cosmetic2) -> {
                String string = cosmetic.llllIIlIIlIIlIIllIIlIIllI().bridge$getPath().toLowerCase();
                String string2 = cosmetic2.llllIIlIIlIIlIIllIIlIIllI().bridge$getPath().toLowerCase();
                if (cosmetic == cosmetic2) {
                    return 0;
                }
                if (cosmetic.IlllIIIIIIlllIlIIlllIlIIl().equalsIgnoreCase(cosmetic2.IlllIIIIIIlllIlIIlllIlIIl())) {
                    return 0;
                }
                if (!string.contains("bandanna") && string2.contains("bandanna") || !string.contains("mask") && string2.contains("mask")) {
                    return -1;
                }
                if (string.contains("bandanna") && !string2.contains("bandanna") || string.contains("mask") && !string2.contains("mask")) {
                    return 1;
                }
                return cosmetic.IlllIIIIIIlllIlIIlllIlIIl().compareToIgnoreCase(cosmetic2.IlllIIIIIIlllIlIIlllIlIIl());
            });
        }
        for (Cosmetic cosmetic3 : arrayList) {
            AbstractCosmeticUIComponent abstractCosmeticUIComponent = this.lIlIlIlIlIIlIIlIIllIIIIIl(cosmetic3);
            if (abstractCosmeticUIComponent == null) continue;
            list.add(abstractCosmeticUIComponent);
            abstractCosmeticUIComponent.onMouseClick((float f, float f2, int n) -> {
                float f3 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 65.0f;
                float f4 = f3 + 34.0f;
                float f5 = f3 + 34.0f + 75.0f;
                float f6 = f2 + this.scrollbar.getYOffset();
                if (f6 < f4 || f6 > f5) {
                    return false;
                }
                if (cosmetic3.llIIIIIIIllIIllIlIllIIIIl()) {
                    cosmetic3.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                } else {
                    for (Cosmetic cosmetic2 : LunarClient.getInstance().IIlIllIlIIllIIlIlIllllllI().llIlllIIIllllIIlllIllIIIl()) {
                        if (cosmetic2 == cosmetic3 || cosmetic2.lIllIlIIIlIIIIIIIlllIlIll() != cosmetic3.lIllIlIIIlIIIIIIIlllIlIll()) continue;
                        cosmetic2.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                    }
                    cosmetic3.lIlIlIlIlIIlIIlIIllIIIIIl(true);
                }
                LunarClient.getInstance().IIlIllIlIIllIIlIlIllllllI().llllIIlIIlIIlIIllIIlIIllI();
                return true;
            });
        }
    }

    public AbstractCosmeticUIComponent lIlIlIlIlIIlIIlIIllIIIIIl(Cosmetic cosmetic) {
        switch (cosmetic.lIllIlIIIlIIIIIIIlllIlIll()) {
        case CLOAK: {
            return new CloakCosmeticUIComponent(null, (CloakCosmetic)cosmetic);
        }
        case WINGS: {
            return new WingsCosmeticUIComponent(null, (WingsCosmeticTypeWithRenderf)cosmetic);
        }
        case HAT: {
            return new HatCosmeticUIComponent(null, cosmetic);
        }
        }
        return null;
    }

    public static void silly() {
        MinecraftBridge minecraftBridge = Ref.getMinecraft();
        player = Bridge.getInstance().initDummyPlayer();
        player.bridge$setDimension(0);
        player.bridge$setMovementInput(Bridge.getInstance().initMovementInput(minecraftBridge.bridge$getGameSettings()));
        minecraftBridge.bridge$getRenderManager().bridge$setTextureManager(minecraftBridge.bridge$getTextureManager());
        minecraftBridge.bridge$getRenderManager().bridge$setLivingEntity(player);
        minecraftBridge.bridge$getRenderManager().bridge$setOptions(minecraftBridge.bridge$getGameSettings());
        player.bridge$setPosX(0.0);
        player.bridge$setPreviousPosX(0.0);
        player.bridge$setPosZ(0.0);
        player.bridge$setPreviousPosZ(0.0);
        player.bridge$setPosY(0.0);
        player.bridge$setPreviousPosY(0.0);
        player.bridge$setDimension(0);
        player.bridge$preparePlayerToSpawn();
        if (Bridge.getMinecraftVersion().ordinal() >= MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl.ordinal()) {
            byte by = 0;
            for (Object e : Ref.getMinecraft().bridge$getGameSettings().bridge$getModelParts()) {
                if (!(e instanceof EnumPlayerModelPartsBridge)) continue;
                by = (byte)(by | ((EnumPlayerModelPartsBridge)e).bridge$getMask());
            }
            player.bridge$getDataWatcher().bridge$updateObject(10, by);
        }
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        super.llIIIlllIIlllIllllIlIllIl();
        float f = this.IllllllllllIlIIIlllIlllll() / 2.0f - 155.0f;
        float f2 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 65.0f;
        this.cloaks.setPositionAndSize(f + 20.0f, f2 + 10.0f, 45.0f, 15.0f);
        this.wings.setPositionAndSize(f + 70.0f, f2 + 10.0f, 45.0f, 15.0f);
        this.hats.setPositionAndSize(f + 120.0f, f2 + 10.0f, 45.0f, 15.0f);
        this.back.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() / 2.0f - 40.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + 65.0f + 10.0f, 35.0f, 15.0f);
        this.shop.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() / 2.0f + 5.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + 65.0f + 10.0f, 35.0f, 15.0f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.cloaksList, f, f2);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.wingsList, f, f2);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.hatsList, f, f2);
        LunarClient.getInstance().IIlIllIlIIllIIlIlIllllllI().IlIlIlllllIlIIlIlIlllIlIl();
        this.scrollbar.setPositionAndSize(f + 310.0f - 115.0f, f2 + 34.0f, 3.0f, this.lIllllIllIIlIIlIIIlIIIlII * 2 + 10);
        float f3 = (float)this.selectedList.size() / (float)this.lIIlIIIIIIlIIlIIllIlIIlII;
        float f4 = this.selectedList.size() % this.lIIlIIIIIIlIIlIIllIlIIlII;
        this.scrollbar.setContentHeight((f3 + (f4 > 0.0f ? 1.0f : 0.0f)) * (float)(this.lIllllIllIIlIIlIIIlIIIlII + 5));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(List<AbstractCosmeticUIComponent> list, float f, float f2) {
        int n = 0;
        int n2 = 0;
        for (AbstractCosmeticUIComponent abstractCosmeticUIComponent : list) {
            if (n == this.lIIlIIIIIIlIIlIIllIlIIlII) {
                n = 0;
                ++n2;
            }
            abstractCosmeticUIComponent.IlllIIIIIIlllIlIIlllIlIIl(n2 + n);
            abstractCosmeticUIComponent.setPositionAndSize(f + 20.0f + (float)(n * (this.lIlIlIIIIIIllIlIIIIllIIII + 5)), f2 + 36.0f + (float)(n2 * (this.lIllllIllIIlIIlIIIlIIIlII + 5)), this.lIlIlIIIIIIllIlIIIIllIIII, this.lIllllIllIIlIIlIIIlIIIlII);
            ++n;
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        for (UIComponent uIComponent : this.selectedList) {
            if (!uIComponent.mouseInside(f, f2 - this.scrollbar.getYOffset()) || !this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f, f2) || !uIComponent.onMouseClicked(f, f2 - this.scrollbar.getYOffset(), n)) continue;
            CosmeticsUIScreen.IIlIllIlllllllIIlIIIllIIl();
            return;
        }
        if (this.scrollbar.mouseInside(f, f2)) {
            this.scrollbar.onMouseClicked(f, f2, n);
            CosmeticsUIScreen.IIlIllIlllllllIIlIIIllIIl();
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        super.IlllIIIIIIlllIlIIlllIlIIl(n);
        this.scrollbar.handleMouseScrollDelta(n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(char c, KeyType keyType) {
    }

    @Override
    public void lIlIIIIIIlIIIllllIllIIlII() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2);
        float f3 = this.IllllllllllIlIIIlllIlllll() / 2.0f - 155.0f;
        float f4 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 65.0f;
        FontRegistry.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.get("ownedCosmetics", this.selectedList.size()), f3 + 170.0f, f4 + 10.0f + (float)FontRegistry.IlllIIIIIIlllIlIIlllIlIIl.getHeight() / 2.0f, -1);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f3, f4, 310.0f, 130.0f, 5.0f, 0x20000000, 0x20FFFFFF, 0x30000000);
        if (!Ref.getAssetsWebsocket().isPresent() || Ref.getAssetsWebsocket().get().lIlIlIlIlIIlIIlIIllIIIIIl() != WebSocketState.READY) {
            FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl(this.get("failedCosmeticConnection"), this.IllllllllllIlIIIlllIlllll() / 2.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 10.0f, -1);
            FontRegistry.llIlIIIllIIlIllIllIllllIl().IlllIIIIIIlllIlIIlllIlIIl(this.get("failedCosmeticConnectionRetry"), this.IllllllllllIlIIIlllIlllll() / 2.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 5.0f + (float)FontRegistry.IllIllIIIllIIIlIlIlIIIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.get("failedCosmeticConnection")), -1);
            return;
        }
        float f5 = f3 + 310.0f - 50.0f - f;
        float f6 = f4 + 30.0f - f2;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable(3089);
        CosmeticsUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(f3 + 1.0f), (int)(f4 + 2.0f), (int)(f3 + 310.0f - 1.0f), (int)(f4 + 130.0f - 2.0f), (float)((int)((float)CosmeticsUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * CosmeticsUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.lllllIllIlIIlIIlIIIlllIlI());
        GL11.glDisable(3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f3 + 310.0f - 58.0f, f4 + 36.0f, f5, f6, f, f2);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        GL11.glEnable(3089);
        CosmeticsUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(f3 + 20.0f), (int)(f4 + 34.0f), (int)(f3 + 20.0f + 190.0f), (int)(f4 + 34.0f + 75.0f + (float)(this.lIllllIllIIlIIlIIIlIIIlII / 2)), (float)((int)((float)CosmeticsUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * CosmeticsUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.lllllIllIlIIlIIlIIIlllIlI());
        this.scrollbar.onDraw(f, f2, true);
        for (UIComponent component : this.selectedList) {
            boolean bl2 = component.getY() + component.getHeight() + this.scrollbar.getYOffset() < this.scrollbar.getY();
            boolean bl = component.getY() + this.scrollbar.getYOffset() > this.scrollbar.getY() + this.scrollbar.getHeight();
            if (!(component.getX() >= f3 + 20.0f) || bl2 || bl) continue;
            component.drawComponent(f, f2 - this.scrollbar.getYOffset(), !this.scrollbar.lIIIllIllIIllIlllIlIIlllI());
        }
        this.scrollbar.llllIIlIIlIIlIIllIIlIIllI(f, f2, true);
        GL11.glDisable(3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6) {
        boolean bl = f5 > f - 30.0f && f5 < f + 30.0f && f6 > f2 - 20.0f && f6 < f2 + 65.0f;
        if (this.IlIIlIIlIIlIIllIIIllIIllI && !Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
            this.IlIIlIIlIIlIIllIIIllIIllI = false;
        } else if (!this.IlIIlIIlIIlIIllIIIllIIllI && Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
            this.IlIIlIIlIIlIIllIIIllIIllI = bl;
        }
        if (this.IlIIlIIlIIlIIllIIIllIIllI) {
            float f7 = f5 - f;
            if (f7 > 0.0f && f7 > 50.0f) {
                f7 = 50.0f;
            } else if (f7 < 0.0f && f7 < -50.0f) {
                f7 = -50.0f;
            }
            this.IIlIlIIIllIIllllIllllIlIl += f7 / 5.0f;
        }
        String string = this.get("noActive");
        for (AbstractCosmeticUIComponent abstractCosmeticUIComponent : this.selectedList) {
            if (!abstractCosmeticUIComponent.lIllIlIIIlIIIIIIIlllIlIll()) continue;
            string = abstractCosmeticUIComponent.llIlllIIIllllIIlllIllIIIl();
            break;
        }
        FontRegistry.llIIIlllIIlllIllllIlIllIl().IlllIIIIIIlllIlIIlllIlIIl(string, f, f2 + 70.0f, 0x40FFFFFF);
        FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().IlllIIIIIIlllIlIIlllIlIIl(this.get("hint"), f, f2 + 80.0f, 0x40FFFFFF);
        if (bl && !this.IlIIlIIlIIlIIllIIIllIIllI) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(0.6f, 1.0f, 0.6f, 1.0f);
        } else {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
        }
        float f8 = 40.0f;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableColorMaterial();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(f, f2, 50.0f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(-f8, f8, f8);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(180.0f, 0.0f, 0.0f, 1.0f);
        float f9 = player.bridge$getRenderYawOffset();
        float f10 = (float) player.bridge$getRotationYaw();
        float f11 = (float) player.bridge$getRotationPitch();
        float f12 = player.bridge$getPrevRotationYawHead();
        float f13 = player.bridge$getRotationYawHead();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(135.0f, 0.0f, 1.0f, 0.0f);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableStandardItemLighting();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(-((float)Math.atan(f4 / 40.0f)) * 20.0f, 1.0f, 0.0f, 0.0f);
        player.bridge$setRenderYawOffset((float)Math.atan(f3 / 40.0f) * 20.0f - this.IIlIlIIIllIIllllIllllIlIl);
        player.bridge$setRotationYaw((float)Math.atan(f3 / 40.0f) * 40.0f - this.IIlIlIIIllIIllllIllllIlIl);
        player.bridge$setRotationPitch(player.bridge$getRotationPitch() - (double)((float)Math.atan(f4 / 40.0f) * 20.0f));
        player.bridge$setRotationYawHead((float) player.bridge$getRotationYaw());
        player.bridge$setPrevRotationYawHead((float) player.bridge$getRotationYaw());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0f, 0.0f, 0.0f);
        RenderManagerBridge renderManagerBridge = Ref.getMinecraft().bridge$getRenderManager();
        renderManagerBridge.bridge$setPlayerViewY(180.0f);
        renderManagerBridge.bridge$setRenderShadow(false);
        renderManagerBridge.bridge$renderEntityWithPosYaw(player, 0.0, -1.5, 0.0, 0.0f, 1.0f);
        renderManagerBridge.bridge$setRenderShadow(true);
        player.bridge$setRenderYawOffset(f9);
        player.bridge$setRotationYaw(f10);
        player.bridge$setRotationPitch(f11);
        player.bridge$setPrevRotationYawHead(f12);
        player.bridge$setRotationYawHead(f13);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$disableStandardItemLighting();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableRescaleNormal();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$setActiveTexture(Bridge.lIlIIIIIIlIIIllllIllIIlII().bridge$lightmapTexUnit());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$setActiveTexture(Bridge.lIlIIIIIIlIIIllllIllIIlII().bridge$defaultTexUnit());
    }

    public static EntityPlayerSPBridge lIIIllIllIIllIlllIlIIlllI() {
        if (player == null) {
            CosmeticsUIScreen.silly();
        }
        return player;
    }

    @Override
    public String getLanguagePath() {
        return super.getLanguagePath() + ".cosmetics";
    }
}
