package com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.base;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.bridge.minecraft.util.EnumPlayerModelPartsBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.cosmetic.Cosmetic;
import com.moonsworth.lunar.client.cosmetic.CosmeticType;
import com.moonsworth.lunar.client.cosmetic.type.HatCosmetic;
import com.moonsworth.lunar.client.cosmetic.type.HatCosmeticType;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.ScrollbarUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.SmallIconUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.TextboxWithIcon;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.event.MouseEventCallback;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.AbstractCosmeticUIComponent;
import com.moonsworth.lunar.client.util.BrowserUtil;
import com.moonsworth.lunar.client.util.LanguageParser;
import com.moonsworth.lunar.client.websocket.WebSocketState;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CosmeticsListUIComponent extends AbstractListUIComponent<CosmeticsButtonListUIComponent> {
    public static EntityPlayerSPBridge lIlIlIlIlIIlIIlIIllIIIIIl = CosmeticsListUIComponent.llllIIlIIlIIlIIllIIlIIllI();
    public final CosmeticsUIScreenBase base;
    public final TextboxWithIcon search;
    public CosmeticsButtonListUIComponent IIlIllIlllllllIIlIIIllIIl;
    public SmallIconUIComponent back;
    public SmallIconUIComponent cart;
    public final ScrollbarUIComponent scrollbar = new ScrollbarUIComponent(null);
    public int lllllIllIlIIlIIlIIIlllIlI = 5;
    public MouseEventCallback IllIIIlllIIIlIlllIlIIlIII;
    public boolean IIlIllIlIIllIIlIlIllllllI;
    public float lIIIlllIIIIllllIlIIIlIIll = -180.0f;
    public float llIIIlIllIIIIlIIIlIlIllIl = 0.0f;
    public float llllIlIllllIlIlIIIllIlIlI = 0.0f;

    public CosmeticsListUIComponent(CosmeticsUIScreenBase base) {
        super(null);
        this.base = base;
        this.IIlIllIlllllllIIlIIIllIIl = this.components.get(0);
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(true);
        this.IllIIIlllIIIlIlllIlIIlIII = this.onMouseClick;
        this.back = new SmallIconUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/cosmetics/back-40x40.png"));
        this.back.lIllIlIIIlIIIIIIIlllIlIll(new ColorEase(0x20FFFFFF, 1358901296));
        this.cart = new SmallIconUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/cosmetics/cart-40x40.png"));
        this.cart.lIllIlIIIlIIIIIIIlllIlIll(true);
        this.cart.IlllIIIIIIlllIlIIlllIlIIl(false);
        this.cart.lIlIlIlIlIIlIIlIIllIIIIIl(2.5f);
        this.cart.lIlIlIlIlIIlIIlIIllIIIIIl(new ColorEase(-2133114816, -2408384));
        this.search = new TextboxWithIcon(this, Bridge.getInstance().initResourceLocation("lunar", "icons/assets/magnifying-glass-12x12.png"), FontRegistry.llllIIlIIlIIlIIllIIlIIllI, "searchPlaceholder", 0x20FFFFFF, 0x35FFFFFF);
        this.onMouseRelease((f, f2, n) -> {
            if (this.back.mouseInside(f, f2)) {
                Ref.getMinecraft().bridge$displayScreen(this.base.llIIIIIIIllIIllIlIllIIIIl());
                return true;
            }
            return false;
        });
        this.onMouseClick((float f, float f2, int n) -> {
            if (!Ref.getAssetsWebsocket().isPresent() || Ref.getAssetsWebsocket().get().lIlIlIlIlIIlIIlIIllIIIIIl() != WebSocketState.READY) {
                return false;
            }
            for (AbstractCosmeticUIComponent abstractCosmeticUIComponent : this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII()) {
                boolean bl;
                boolean bl2 = abstractCosmeticUIComponent.getY() + abstractCosmeticUIComponent.getHeight() + this.scrollbar.getYOffset() < this.scrollbar.getY();
                boolean bl3 = bl = abstractCosmeticUIComponent.getY() + this.scrollbar.getYOffset() > this.scrollbar.getY() + this.scrollbar.getHeight();
                if (!(abstractCosmeticUIComponent.getX() >= this.x + 20.0f) || !(f2 > this.y + 38.0f) || !(f2 < this.y + this.height - 20.0f) || bl2 || bl || !abstractCosmeticUIComponent.mouseInside(f, f2 - this.scrollbar.getYOffset())) continue;
                Cosmetic cosmetic = abstractCosmeticUIComponent.getCosmetic();
                if (cosmetic.llIIIIIIIllIIllIlIllIIIIl()) {
                    cosmetic.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                } else {
                    for (Cosmetic cosmetic2 : LunarClient.getInstance().IIlIllIlIIllIIlIlIllllllI().llIlllIIIllllIIlllIllIIIl()) {
                        if (cosmetic2 == cosmetic) continue;
                        if (cosmetic2 instanceof HatCosmeticType && cosmetic instanceof HatCosmeticType) {
                            HatCosmetic hatCosmetic = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(cosmetic.llllIIlIIlIIlIIllIIlIIllI());
                            HatCosmetic hatCosmetic2 = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(cosmetic2.llllIIlIIlIIlIIllIIlIIllI());
                            if (hatCosmetic != null && hatCosmetic2 != null && (hatCosmetic.lIlIlIlIlIIlIIlIIllIIIIIl(hatCosmetic2) || hatCosmetic2.lIlIlIlIlIIlIIlIIllIIIIIl(hatCosmetic)) && (hatCosmetic.llIllIlIllIlllIllIIIIllII() == HatCosmetic.Type.HAT && hatCosmetic2.llIllIlIllIlllIllIIIIllII() == HatCosmetic.Type.HAT || hatCosmetic.llIllIlIllIlllIllIIIIllII() != hatCosmetic2.llIllIlIllIlllIllIIIIllII())) continue;
                            cosmetic2.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                            continue;
                        }
                        if (cosmetic2.lIllIlIIIlIIIIIIIlllIlIll() != cosmetic.lIllIlIIIlIIIIIIIlllIlIll()) continue;
                        cosmetic2.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                    }
                    cosmetic.lIlIlIlIlIIlIIlIIllIIIIIl(true);
                }
                LunarClient.getInstance().IIlIllIlIIllIIlIlIllllllI().llllIIlIIlIIlIIllIIlIIllI();
                Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getMinecraft().bridge$getSession().bridge$getProfile().getId(), lIlIlIlIlIIlIIlIIllIIIIIl.bridge$getGameProfile().getId());
                return true;
            }
            if (this.cart.mouseInside(f, f2)) {
                StringBuilder stringBuilder = new StringBuilder("https://store.lunarclient.com/");
                if (this.IIlIllIlllllllIIlIIIllIIl != null) {
                    stringBuilder.append("category/").append(this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI().llIIIIIIIllIIllIlIllIIIIl());
                }
                return BrowserUtil.lIlIlIlIlIIlIIlIIllIIIIIl(stringBuilder.toString());
            }
            if (this.scrollbar.mouseInside(f, f2)) {
                this.scrollbar.onMouseClicked(f, f2, n);
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
            }
            if (this.IllIIIlllIIIlIlllIlIIlIII.accept(f, f2, n)) {
                return true;
            }
            if (this.search.mouseInside(f, f2)) {
                return this.search.onMouseClicked(f, f2, n);
            }
            return false;
        });
        this.search.lIlIlIlIlIIlIIlIIllIIIIIl = this::IllllllllllIlIIIlllIlllll;
        this.IlllIIIIIIlllIlIIlllIlIIl(this.search::IlllIIIIIIlllIlIIlllIlIIl);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        super.onKeyTyped(c, keyType);
        this.search.setTyping(true);
        this.search.onKeyTyped(c, keyType);
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
    public void handleMouseScrollDelta(int n) {
        super.handleMouseScrollDelta(n);
        this.scrollbar.handleMouseScrollDelta(n);
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        Object object2;
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x - 1.0f, this.y, this.width + 2.0f, this.height, 4.0f, 1612586526);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 3.25f, 1075715614);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 5.0f, -1306912744);
        AbstractUIScreen.IlIlIlllllIlIIlIlIlllIlIl(this.x, this.y + 1.0f, 40.0f, this.height - 2.0f, 5.0f, 0x36000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 40.5f, this.y + 1.0f, 0.5f, this.height - 2.0f, 0x20FFFFFF);
        float f3 = this.x + this.width - this.width / 5.0f;
        float f4 = this.y;
        float f5 = f3 - mouseX;
        float f6 = f4 + 80.0f - mouseY;
        // todo remove false
        if (false && !Ref.getAssetsWebsocket().isPresent()) {
            FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl("Invalid login...", this.x + (this.width - 100.0f) / 2.0f, this.y + this.height / 2.0f - 10.0f, -1);
        } else if (false && Ref.getAssetsWebsocket().get().lIlIlIlIlIIlIIlIIllIIIIIl() != WebSocketState.READY) {
            FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl("Connecting...", this.x + (this.width - 100.0f) / 2.0f, this.y + this.height / 2.0f - 10.0f, -1);
        } else {
            this.search.drawComponent(mouseX, mouseY, bl);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            GL11.glEnable(3089);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x + 20.0f), (int)(this.y + 38.0f), (int)(this.x + this.width), (int)(this.y + this.height - 20.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.base.lllllIllIlIIlIIlIIIlllIlI());
            this.scrollbar.onDraw(mouseX, mouseY, true);
            if (this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII().isEmpty()) {
                String string = this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI().lIlIlIlIlIIlIIlIIllIIIIIl().contains("_") ? this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI().lIlIlIlIlIIlIIlIIllIIIIIl().split("_")[1] : this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI().lIlIlIlIlIIlIIlIIllIIIIIl();
                FontRegistry.llIllIlIllIlllIllIIIIllII().IlllIIIIIIlllIlIIlllIlIIl("You don't own any " + string + (string.endsWith("s") ? "" : "s"), this.x + 175.0f, this.y + this.height / 2.0f - 10.0f, -1342177281);
            } else {
                for (UIComponent component : this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII()) {
                    boolean bl2;
                    boolean bl3 = component.getY() + component.getHeight() + this.scrollbar.getYOffset() < this.scrollbar.getY();
                    boolean bl4 = bl2 = component.getY() + this.scrollbar.getYOffset() > this.scrollbar.getY() + this.scrollbar.getHeight();
                    if (!(component.getX() >= this.x + 20.0f) || bl3 || bl2) continue;
                    component.drawComponent(mouseX, mouseY - this.scrollbar.getYOffset(), !this.scrollbar.lIIIllIllIIllIlllIlIIlllI());
                }
            }
            this.scrollbar.llllIIlIIlIIlIIllIIlIIllI(mouseX, mouseY, true);
            GL11.glDisable(3089);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        }
        if (this.IIlIllIlIIllIIlIlIllllllI) {
            float f7 = mouseX - f3 + (f3 - this.llIIIlIllIIIIlIIIlIlIllIl);
            this.lIIIlllIIIIllllIlIIIlIIll = this.llllIlIllllIlIlIIIllIlIlI + f7;
        }
        float f8 = Bridge.getMinecraftVersion().lIlIlIlIlIIlIIlIIllIIIIIl() ? 180.0f : 0.0f;
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawEntityOnScreen(f3, this.y + this.height - 55.0f, 100.0f, this.lIIIlllIIIIllllIlIIIlIIll - f8, f5, f6, lIlIlIlIlIIlIIlIIllIIIIIl);
        object2 = "None";
        for (AbstractCosmeticUIComponent abstractCosmeticUIComponent : this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII()) {
            if (!abstractCosmeticUIComponent.lIllIlIIIlIIIIIIIlllIlIll()) continue;
            object2 = abstractCosmeticUIComponent.llIlllIIIllllIIlllIllIIIl();
            break;
        }
        FontRegistry.llIIIlllIIlllIllllIlIllIl().IlllIIIIIIlllIlIIlllIlIIl(((String)object2).toUpperCase(), f3, this.y + this.height - 30.0f, 0x40FFFFFF);
        FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().IlllIIIIIIlllIlIIlllIlIIl(this.base.get("hint"), f3, this.y + this.height - 40.0f, 0x40FFFFFF);
        this.back.drawComponent(mouseX, mouseY, bl && this.back.mouseInside(mouseX, mouseY));
        this.cart.drawComponent(mouseX, mouseY, bl && this.cart.mouseInside(mouseX, mouseY));
        super.drawComponent(mouseX, mouseY, bl);
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        float f5 = x + 40.0f;
        float f6 = y;
        if (Ref.getWorld() == null && lIlIlIlIlIIlIIlIIllIIIIIl != null) {
            this.mc.bridge$getRenderManager().bridge$prepare(lIlIlIlIlIIlIIlIIllIIIIIl.bridge$getWorld(), lIlIlIlIlIIlIIlIIllIIIIIl);
        }
        LunarClient.getInstance().IIlIllIlIIllIIlIlIllllllI().IlIlIlllllIlIIlIlIlllIlIl();
        this.scrollbar.setPositionAndSize(f5 + 245.0f, y + 38.0f, 3.0f, height - 58.0f);
        this.back.setPositionAndSize(x + 7.0f, y + height - 26.0f - 7.0f, 26.0f, 26.0f);
        this.cart.setPositionAndSize(x + 7.0f, y + height - 66.0f, 26.0f, 26.0f);
        int n = 0;
        for (CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent : this.components) {
            cosmeticsButtonListUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(x + 7.0f, y + height / 2.0f - (float)this.components.size() * 32.0f / 2.0f + (float)n);
            n = (int)((float)n + (cosmeticsButtonListUIComponent.getHeight() + 4.0f));
        }
        this.IllllllllllIlIIIlllIlllll();
        this.search.setPositionAndSize(x + 60.0f, y + 15.0f, 220.0f, 18.0f);
    }

    public void IllllllllllIlIIIlllIlllll() {
        float f = this.x + 40.0f;
        float f2 = this.y;
        HashMap<Long, Object> hashMap = new HashMap<Long, Object>();
        if (!this.search.getText().isEmpty() && this.IIlIllIlllllllIIlIIIllIIl != null) {
            for (AbstractCosmeticUIComponent object : this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII()) {
                long l = object.getCosmetic().lIlIlIlIlIIlIIlIIllIIIIIl();
                if (hashMap.containsKey(l)) continue;
                String object2 = EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(object.getCosmetic().IlllIIIIIIlllIlIIlllIlIIl().toLowerCase());
                String string = LanguageParser.normalize(search.getText());
                for (String string2 : object2.split(" ")) {
                    if (!LanguageParser.normalize(string2).toLowerCase().startsWith(string.toLowerCase())) continue;
                    hashMap.put(object.getCosmetic().lIlIlIlIlIIlIIlIIllIIIIIl(), object);
                }
            }
        }
        int n = 0;
        for (CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent : this.components) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(hashMap, cosmeticsButtonListUIComponent, f, f2);
            for (Object object2 : cosmeticsButtonListUIComponent.llIIIIIIIllIIllIlIllIIIIl()) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(hashMap, (CosmeticsButtonListUIComponent)object2, f, f2);
            }
            n = (int)((float)n + (cosmeticsButtonListUIComponent.getHeight() + 4.0f));
        }
        float f3 = (float)(this.search.getText().isEmpty() ? this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII().size() : hashMap.size()) / (float)this.lllllIllIlIIlIIlIIIlllIlI;
        this.scrollbar.setContentHeight((float)(Math.ceil(f3) * (double)(this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI().IlIlIlllllIlIIlIlIlllIlIl() + 5)) - 5.0f);
    }

    public static EntityPlayerSPBridge llllIIlIIlIIlIIllIIlIIllI() {
        MinecraftBridge minecraftBridge = Ref.getMinecraft();
        EntityPlayerSPBridge entityPlayerSPBridge = Bridge.getInstance().initDummyPlayer();
        entityPlayerSPBridge.bridge$setDimension(0);
        entityPlayerSPBridge.bridge$setMovementInput(Bridge.getInstance().initMovementInput(minecraftBridge.bridge$getGameSettings()));
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
        if (Bridge.getMinecraftVersion().ordinal() >= MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl.ordinal()) {
            byte by = 0;
            for (Object e : Ref.getMinecraft().bridge$getGameSettings().bridge$getModelParts()) {
                if (!(e instanceof EnumPlayerModelPartsBridge)) continue;
                by = (byte)(by | ((EnumPlayerModelPartsBridge)e).bridge$getMask());
            }
            entityPlayerSPBridge.bridge$getDataWatcher().bridge$updateObject(10, by);
        }
        minecraftBridge.bridge$getRenderManager().bridge$prepare(entityPlayerSPBridge.bridge$getWorld(), entityPlayerSPBridge);
        Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getMinecraft().bridge$getSession().bridge$getProfile().getId(), entityPlayerSPBridge.bridge$getGameProfile().getId());
        return entityPlayerSPBridge;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Map map, CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent, float f, float f2) {
        int n = 0;
        int n2 = 0;
        for (AbstractCosmeticUIComponent abstractCosmeticUIComponent : cosmeticsButtonListUIComponent.lIIlIlllIlIlIIIlllIIlIIII()) {
            HatCosmetic hatCosmetic;
            if (!this.search.getText().isEmpty() && !map.containsKey(abstractCosmeticUIComponent.getCosmetic().lIlIlIlIlIIlIIlIIllIIIIIl())) {
                abstractCosmeticUIComponent.setPositionAndSize(f - 20.0f - abstractCosmeticUIComponent.getWidth(), f2, abstractCosmeticUIComponent.getWidth(), abstractCosmeticUIComponent.getHeight());
                continue;
            }
            if (abstractCosmeticUIComponent.getCosmetic() instanceof HatCosmeticType && (hatCosmetic = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(abstractCosmeticUIComponent.getCosmetic().llllIIlIIlIIlIIllIIlIIllI())) == null) continue;
            if (n == this.lllllIllIlIIlIIlIIIlllIlI) {
                n = 0;
                ++n2;
            }
            abstractCosmeticUIComponent.IlllIIIIIIlllIlIIlllIlIIl(n2 + n);
            abstractCosmeticUIComponent.setPositionAndSize(f + 20.0f + (float)(n * (cosmeticsButtonListUIComponent.llllIIlIIlIIlIIllIIlIIllI().llllIIlIIlIIlIIllIIlIIllI() + 5)), f2 + 38.0f + (float)(n2 * (cosmeticsButtonListUIComponent.llllIIlIIlIIlIIllIIlIIllI().IlIlIlllllIlIIlIlIlllIlIl() + 5)), cosmeticsButtonListUIComponent.llllIIlIIlIIlIIllIIlIIllI().llllIIlIIlIIlIIllIIlIIllI(), cosmeticsButtonListUIComponent.llllIIlIIlIIlIIllIIlIIllI().IlIlIlllllIlIIlIlIlllIlIl());
            ++n;
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(CosmeticsButtonListUIComponent cosmeticsButtonListUIComponent) {
        if (this.IIlIllIlllllllIIlIIIllIIl != null) {
            this.IIlIllIlllllllIIlIIIllIIl.lIIlIlllIlIlIIIlllIIlIIII().forEach(AbstractCosmeticUIComponent::setEase);
        }
        this.IIlIllIlllllllIIlIIIllIIl = cosmeticsButtonListUIComponent;
        this.search.setText("");
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
    public boolean onMouseReleased(float mouseX, float mouseY, int mouseButton) {
        if (this.IIlIllIlIIllIIlIlIllllllI) {
            this.IIlIllIlIIllIIlIlIllllllI = false;
            this.llllIlIllllIlIlIIIllIlIlI = this.lIIIlllIIIIllllIlIIIlIIll;
        }
        return super.onMouseReleased(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean onMouseClicked(float mouseX, float mouseY, int mouseButton) {
        float f3 = this.x + this.width - this.width / 5.0f;
        float f4 = this.y;
        boolean bl = mouseX > f3 - 60.0f && mouseX < f3 + 60.0f && mouseY > f4 + 40.0f && mouseY < f4 + this.height - 70.0f;
        if (!this.IIlIllIlIIllIIlIlIllllllI && bl && Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
            this.IIlIllIlIIllIIlIlIllllllI = true;
            this.llllIlIllllIlIlIIIllIlIlI = this.lIIIlllIIIIllllIlIIIlIIll;
            this.llIIIlIllIIIIlIIIlIlIllIl = mouseX;
        }
        if (mouseButton == 1 && this.search.mouseInside(mouseX, mouseY)) {
            this.search.setText("");
            this.search.setTyping(true);
            this.IllllllllllIlIIIlllIlllll();
            return true;
        }
        return super.onMouseClicked(mouseX, mouseY, mouseButton);
    }

    public static EntityPlayerSPBridge llIIIIIIIllIIllIlIllIIIIl() {
        return lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerSPBridge entityPlayerSPBridge) {
        lIlIlIlIlIIlIIlIIllIIIIIl = entityPlayerSPBridge;
    }

    public CosmeticsUIScreenBase lIIIllIllIIllIlllIlIIlllI() {
        return this.base;
    }

    public TextboxWithIcon IlllllIlIIIlIIlIIllIIlIll() {
        return this.search;
    }

    public CosmeticsButtonListUIComponent llIIlIlIIIllIlIlIlIIlIIll() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }
}
