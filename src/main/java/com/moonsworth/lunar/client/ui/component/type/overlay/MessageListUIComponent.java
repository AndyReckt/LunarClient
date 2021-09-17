package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractDraggableListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.llIllIlIllIlllIllIIIIllII;
import com.moonsworth.lunar.client.ui.component.type.setting.lllllIllIlIIlIIlIIIlllIlI;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.BooleanCallbackSetting;
import com.moonsworth.lunar.client.websocket.FriendProfile;
import org.lwjgl.opengl.GL11;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MessageListUIComponent
extends AbstractDraggableListUIComponent
implements BooleanCallbackSetting {
    public llIIlIlIIIllIlIlIlIIlIIll IIlIllIlllllllIIlIIIllIIl;
    public llIllIlIllIlllIllIIIIllII as;
    public lllllIllIlIIlIIlIIIlllIlI asd;
    public FriendProfile IllllllllllIlIIIlllIlllll;
    public static float lIlIlIlIlIIlIIlIIllIIIIIl = 180.0f;
    public IIlIllIlIIllIIlIlIllllllI lllllIllIlIIlIIlIIIlllIlI;
    public IIlIllIlIIllIIlIlIllllllI IllIIIlllIIIlIlllIlIIlIII;
    public AbstractUIScreen IIlIllIlIIllIIlIlIllllllI;
    public long lIIIlllIIIIllllIlIIIlIIll;

    public MessageListUIComponent(AbstractUIScreen abstractUIScreen) {
        super(null);
        this.IIlIllIlIIllIIlIlIllllllI = abstractUIScreen;
        this.lllllIllIlIIlIIlIIIlllIlI = new IIlIllIlIIllIIlIlIllllllI(this);
        this.IllIIIlllIIIlIlllIlIIlIII = new IIlIllIlIIllIIlIlIllllllI(this);
        this.IIlIllIlllllllIIlIIIllIIl = new llIIlIlIIIllIlIlIlIIlIIll(this, "SEND");
        this.as = new llIllIlIllIlllIllIIIIllII(null, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/exit-17x17-small.png"));
        this.asd = new lllllIllIlIIlIIlIIIlllIlI(this, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "sendPlaceholder", 0x20FFFFFF, 0x40FFFFFF);
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (System.currentTimeMillis() - this.lIIIlllIIIIllllIlIIIlIIll < TimeUnit.SECONDS.toMillis(2L)) {
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                return false;
            }
            if (this.IllllllllllIlIIIlllIlllll != null && this.asd.llllIIlIIlIIlIIllIIlIIllI().length() >= 1) {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketMessage(this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll().toString(), this.asd.llllIIlIIlIIlIIllIIlIIllI()));
                LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(LunarClient.IIllIlIllIlIllIllIllIllII().llllIIlIIlIIlIIllIIlIIllI(), this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll(), this.asd.llllIIlIIlIIlIIllIIlIIllI());
                this.asd.lIlIlIlIlIIlIIlIIllIIIIIl("");
                this.lIIIlllIIIIllllIlIIIlIIll = System.currentTimeMillis();
                return true;
            }
            return false;
        });
        this.as.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (this.IllllllllllIlIIIlllIlllll != null) {
                this.IlllIIIIIIlllIlIIlllIlIIl.removeIf(uIComponent -> uIComponent instanceof llllIIlIIlIIlIIllIIlIIllI && ((llllIIlIIlIIlIIllIIlIIllI)uIComponent).lIllIlIIIlIIIIIIIlllIlIll() == this.IllllllllllIlIIIlllIlllll);
                this.IllllllllllIlIIIlllIlllll = null;
                for (UIComponent uIComponent2 : this.IlllIIIIIIlllIlIIlllIlIIl) {
                    if (!(uIComponent2 instanceof llllIIlIIlIIlIIllIIlIIllI)) continue;
                    this.IllllllllllIlIIIlllIlllll = ((llllIIlIIlIIlIIllIIlIIllI)uIComponent2).lIllIlIIIlIIIIIIIlllIlIll();
                    break;
                }
                if (this.IllllllllllIlIIIlllIlllll == null) {
                    abstractUIScreen.llIIIlIllIIIIlIIIlIlIllIl().removeIf(uIComponent -> uIComponent == this);
                }
            }
            return true;
        });
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        super.lIlIlIlIlIIlIIlIIllIIIIIl();
        this.asd.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        if (this.asd.llIllIlIllIlllIllIIIIllII() && keyType == KeyType.IlIlIlIlIIIlIIlIIlllIllIl) {
            if (this.IllllllllllIlIIIlllIlllll != null && this.asd.llllIIlIIlIIlIIllIIlIIllI().length() >= 1) {
                if (System.currentTimeMillis() - this.lIIIlllIIIIllllIlIIIlIIll < TimeUnit.SECONDS.toMillis(2L)) {
                    this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                    return;
                }
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketMessage(this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll().toString(), this.asd.llllIIlIIlIIlIIllIIlIIllI()));
                LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(LunarClient.IIllIlIllIlIllIllIllIllII().llllIIlIIlIIlIIllIIlIIllI(), this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll(), this.asd.llllIIlIIlIIlIIllIIlIIllI());
                this.asd.lIlIlIlIlIIlIIlIIllIIIIIl("");
                this.lIIIlllIIIIllllIlIIIlIIll = System.currentTimeMillis();
            }
        } else {
            this.asd.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
        }
        super.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        boolean bl;
        if (this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        }
        if (this.as.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.as.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        }
        if (this.asd.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.asd.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        }
        if (this.lllllIllIlIIlIIlIIIlllIlI.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.lllllIllIlIIlIIlIIIlllIlI.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        }
        boolean bl2 = f > this.x && f < this.x + 24.0f && f2 > this.y + 4.0f && f2 < this.y + this.height - 4.0f;
        boolean bl3 = bl = !bl2 && !this.lllllIllIlIIlIIlIIIlllIlI.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && !this.lllllIllIlIIlIIlIIIlllIlI.lIIIllIllIIllIlllIlIIlllI() && !this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && !this.asd.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2);
        if (bl) {
            this.lIllIlIIIlIIIIIIIlllIlIll(f, f2);
        }
        return this.IlllllIlIIIlIIlIIllIIlIll != null && this.IlllllIlIIIlIIlIIllIIlIll.accept(f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll(), n);
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
        this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
        this.as.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
        this.asd.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
        return this.llIIlIlIIIllIlIlIlIIlIIll != null && this.llIIlIlIIIllIlIlIlIIlIIll.accept(f, f2, n);
    }

    @Override
    public List lIllIlIIIlIIIIIIIlllIlIll() {
        return new ArrayList();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        this.asd.lIlIlIlIlIIlIIlIIllIIIIIl(f + 30.0f, f2 + f4 - 18.0f, f3 - 66.0f, 13.0f);
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 32.0f, f2 + f4 - 18.0f, 26.0f, 13.0f);
        this.as.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 20.0f, f2 + 6.0f, 14.0f, 13.0f);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
        super.IlllIIIIIIlllIlIIlllIlIIl();
        this.asd.lIlIlIlIlIIlIIlIIllIIIIIl(false);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        this.lllllIllIlIIlIIlIIIlllIlI.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2);
        boolean bl2 = bl && f > this.x && f < this.x + 24.0f && f2 > this.y + 4.0f && f2 < this.y + this.height - 4.0f;
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 26.0f, this.y + 24.0f, this.width - 26.0f, 0.5f, 0x20FFFFFF);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 26.0f, this.y + this.height - 23.0f, this.width - 26.0f, 0.5f, 0x20FFFFFF);
        AbstractUIScreen.llIIIIIIIllIIllIlIllIIIIl(this.x + 26.0f, this.y + this.height - 22.5f, this.width - 26.0f, 21.5f, 5.0f, 0x45000000);
        AbstractUIScreen.IlIlIlllllIlIIlIlIlllIlIl(this.x, this.y + 1.0f, 25.0f, this.height - 2.0f, 5.0f, 0x40FFFFFF);
        AbstractUIScreen.llllIIlIIlIIlIIllIIlIIllI(this.x + 26.0f, this.y + 1.0f, this.width - 26.0f, 23.0f, 5.0f, 0x25000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x - 1.0f, this.y, this.width + 2.0f, this.height, 4.0f, 0x40000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 3.25f, 0x20FFFFFF);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 5.0f, Integer.MIN_VALUE);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 25.0f, this.y + 1.0f, 1.0f, this.height - 2.0f, 0x40FFFFFF);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable((int)3089);
        this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 24.0f, this.y + 4.0f, 3.0f, this.height - 8.0f);
        this.IllIIIlllIIIlIlllIlIIlIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2, bl2);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(0, (int)(this.y + 4.0f), (int)(this.x + 24.0f), (int)(this.y + this.height - 4.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.IIlIllIlIIllIIlIlIllllllI.lllllIllIlIIlIIlIIIlllIlI());
        int n = 0;
        for (UIComponent object : this.IlllIIIIIIlllIlIIlllIlIIl) {
            if (!(object instanceof llllIIlIIlIIlIIllIIlIIllI)) continue;
            ((UIComponent)object).lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 6.0f, this.y + 6.0f + (float)n * 18.0f, 12.0f, 12.0f);
            ++n;
        }
        int n2 = 0;
        for (UIComponent uIComponent : this.llllIIlIIlIIlIIllIIlIIllI()) {
            if (!(uIComponent instanceof llllIIlIIlIIlIIllIIlIIllI)) continue;
            ++n2;
        }
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll(), bl);
        this.IllIIIlllIIIlIlllIlIIlIII.IlIlIlllllIlIIlIlIlllIlIl((float)n2 * 18.0f);
        this.IllIIIlllIIIlIlllIlIIlIII.llllIIlIIlIIlIIllIIlIIllI(f, f2, bl2 && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllllIllIlIIlIIlIIIlllIlI, f, f2 - this.lllllIllIlIIlIIlIIIlllIlI.lIllIlIIIlIIIIIIIlllIlIll(), new UIComponent[0]));
        GL11.glDisable((int)3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        if (System.currentTimeMillis() - this.lIIIlllIIIIllllIlIIIlIIll >= TimeUnit.SECONDS.toMillis(2L)) {
            this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(true);
        }
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        this.as.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        this.asd.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 36.0f, this.y + 6.0f, this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll(), this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(), 1.0f);
        FontRegistry.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll.llllIIlIIlIIlIIllIIlIIllI().toUpperCase(), this.x + 55.0f, this.y + 6.0f, this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl());
        FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll.IlllIIIIIIlllIlIIlllIlIIl(), this.x + 55.0f, this.y + 13.0f, 0x60FFFFFF);
        float f3 = this.y + this.height - 33.0f;
        float f4 = 8.5f;
        LCFontRenderer lCFontRenderer = FontRegistry.llIIlIlIIIllIlIlIlIIlIIll();
        boolean bl3 = bl && f > this.x + 26.0f && f < this.x + this.x + this.width - 2.0f && f2 > this.y + 26.0f && f2 < this.y + this.height - 24.0f;
        this.lllllIllIlIIlIIlIIIlllIlI.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.width - 5.0f, this.y + 26.0f, 3.0f, this.height - 50.0f);
        this.lllllIllIlIIlIIlIIIlllIlI.llIlllIIIllllIIlllIllIIIl(f, f2, bl3);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable((int)3089);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x + 30.0f), (int)(this.y + 26.0f), (int)(this.x + this.width - 2.0f), (int)(this.y + this.height - 24.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.IIlIllIlIIllIIlIlIllllllI.lllllIllIlIIlIIlIIIlllIlI());
        int n3 = 0;
        List list = this.lIlIIIIIIlIIIllllIllIIlII.lllllIllIlIIlIIlIIIlllIlI().IlllIIIIIIlllIlIIlllIlIIl(this.IllllllllllIlIIIlllIlllll);
        if (list != null) {
            for (lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2 : list) {
                lIllIlIIIlIIIIIIIlllIlIll2.lIlIlIlIlIIlIIlIIllIIIIIl();
                for (int i = lIllIlIIIlIIIIIIIlllIlIll2.llllIIlIIlIIlIIllIIlIIllI().size() - 1; i >= 0; --i) {
                    String string = (String)lIllIlIIIlIIIIIIIlllIlIll2.llllIIlIIlIIlIIllIIlIIllI().get(i);
                    if (i == 0) {
                        String string2 = lIllIlIIIlIIIIIIIlllIlIll2.IlllIIIIIIlllIlIIlllIlIIl();
                        lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(string2, this.x + 30.0f, f3 - (float)n3 * f4, 1625481954);
                        float f5 = lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(string2) + 2;
                        String string3 = lIllIlIIIlIIIIIIIlllIlIll2.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl();
                        int n4 = lIllIlIIIlIIIIIIIlllIlIll2.lIllIlIIIlIIIIIIIlllIlIll() == this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI() ? -12346181 : lIllIlIIIlIIIIIIIlllIlIll2.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl();
                        lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(string3, this.x + 30.0f + f5, f3 - (float)n3 * f4, n4);
                        float f6 = lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(string3);
                        lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(": " + string, this.x + 30.0f + f5 + f6, f3 - (float)n3 * f4, -4671304);
                    } else {
                        lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(string), this.x + 30.0f, f3 - (float)n3 * f4, -4671304);
                    }
                    ++n3;
                }
            }
        }
        GL11.glDisable((int)3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        this.lllllIllIlIIlIIlIIIlllIlI.IlIlIlllllIlIIlIlIlllIlIl((float)n3 * f4);
        this.lllllIllIlIIlIIlIIIlllIlI.lIllIlIIIlIIIIIIIlllIlIll(f, f2, bl3 && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllllIllIlIIlIIlIIIlllIlI, f, f2 - this.lllllIllIlIIlIIlIIIlllIlI.lIllIlIIIlIIIIIIIlllIlIll(), new UIComponent[0]));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(FriendProfile websocketProfile) {
        if (!this.IlllIIIIIIlllIlIIlllIlIIl(websocketProfile)) {
            llllIIlIIlIIlIIllIIlIIllI llllIIlIIlIIlIIllIIlIIllI2 = new llllIIlIIlIIlIIllIIlIIllI(this, websocketProfile);
            this.IlllIIIIIIlllIlIIlllIlIIl.add(llllIIlIIlIIlIIllIIlIIllI2);
            llllIIlIIlIIlIIllIIlIIllI2.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
                this.IllllllllllIlIIIlllIlllll = websocketProfile;
                return true;
            });
            this.IllllllllllIlIIIlllIlllll = websocketProfile;
        } else {
            this.IllllllllllIlIIIlllIlllll = websocketProfile;
        }
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(FriendProfile websocketProfile) {
        for (UIComponent uIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
            if (!(uIComponent instanceof llllIIlIIlIIlIIllIIlIIllI) || !((llllIIlIIlIIlIIllIIlIIllI)uIComponent).lIllIlIIIlIIIIIIIlllIlIll().lIllIlIIIlIIIIIIIlllIlIll().equals(websocketProfile.lIllIlIIIlIIIIIIIlllIlIll())) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean c_() {
        return this.asd.c_();
    }
}
 