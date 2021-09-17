package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;
import com.moonsworth.lunar.client.websocket.FriendProfile;

import java.util.List;

public class llIIIIIIIllIIllIlIllIIIIl
extends AbstractFriendUIComponent {
    public static final ResourceLocationBridge IlllIIIIIIlllIlIIlllIlIIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/logo-22x22.png");
    public ColorEase lIllIlIIIlIIIIIIIlllIlIll = new ColorEase(0, 1075649821);
    public static final ResourceLocationBridge llIlIIIllIIlIllIllIllllIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/unread-19x19.png");

    public llIIIIIIIllIIllIlIllIIIIl(UIComponent uIComponent, FriendProfile websocketProfile) {
        super(uIComponent, websocketProfile);
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (n == 1) {
                if (uIComponent instanceof AbstractListUIComponent) {
                    ((AbstractListUIComponent)uIComponent).lIlIlIlIlIIlIIlIIllIIIIIl(this.llllIIlIIlIIlIIllIIlIIllI());
                    ((AbstractListUIComponent)uIComponent).llIllIlIllIlllIllIIIIllII().lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + ((FriendsListUIComponent)uIComponent).llIIIIIIIllIIllIlIllIIIIl().lIllIlIIIlIIIIIIIlllIlIll());
                    return true;
                }
            } else if (n == 0) {
                this.llIlllIIIllllIIlllIllIIIl();
            }
            return false;
        });
    }

    public IllIllIIIllIIIlIlIlIIIIll llllIIlIIlIIlIIllIIlIIllI() {
        IllIllIIIllIIIlIlIlIIIIll illIllIIIllIIIlIlIlIIIIll = new IllIllIIIllIIIlIlIlIIIIll(this){

            @Override
            public List lIllIlIIIlIIIIIIIlllIlIll() {
                ArrayList<lIlIlIIIIIIllIlIIIIllIIII> arrayList = new ArrayList<lIlIlIIIIIIllIlIIIIllIIII>();
                lIlIlIIIIIIllIlIIIIllIIII lIlIlIIIIIIllIlIIIIllIIII2 = new lIlIlIIIIIIllIlIIIIllIIII(this.IllIllIIIllIIIlIlIlIIIIll, "sendMessage");
                arrayList.add(lIlIlIIIIIIllIlIIIIllIIII2);
                lIlIlIIIIIIllIlIIIIllIIII2.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
                    llIIIIIIIllIIllIlIllIIIIl.this.llIlllIIIllllIIlllIllIIIl();
                    if (((AbstractListUIComponent)llIIIIIIIllIIllIlIllIIIIl.this.lIIIllIllIIllIlllIlIIlllI).IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                        ((AbstractListUIComponent)llIIIIIIIllIIllIlIllIIIIl.this.lIIIllIllIIllIlllIlIIlllI).IlllIIIIIIlllIlIIlllIlIIl(true);
                    } else {
                        ((AbstractListUIComponent)llIIIIIIIllIIllIlIllIIIIl.this.lIIIllIllIIllIlllIlIIlllI).lIlIlIlIlIIlIIlIIllIIIIIl((IllIllIIIllIIIlIlIlIIIIll)null);
                    }
                    return true;
                });
                lIlIlIIIIIIllIlIIIIllIIII lIlIlIIIIIIllIlIIIIllIIII3 = new lIlIlIIIIIIllIlIIIIllIIII(this.IllIllIIIllIIIlIlIlIIIIll, "removeFriend");
                arrayList.add(lIlIlIIIIIIllIlIIIIllIIII3);
                lIlIlIIIIIIllIlIIIIllIIII3.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
                    WebsocketProfile websocketProfile = (WebsocketProfile)this.llllIIlIIlIIlIIllIIlIIllI();
                    LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIlIIlIIlIIIlllIlI().lIllIlIIIlIIIIIIIlllIlIll(websocketProfile.lIllIlIIIlIIIIIIIlllIlIll());
                    if (((AbstractListUIComponent)llIIIIIIIllIIllIlIllIIIIl.this.lIIIllIllIIllIlllIlIIlllI).IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                        ((AbstractListUIComponent)llIIIIIIIllIIllIlIllIIIIl.this.lIIIllIllIIllIlllIlIIlllI).IlllIIIIIIlllIlIIlllIlIIl(true);
                    } else {
                        ((AbstractListUIComponent)llIIIIIIIllIIllIlIllIIIIl.this.lIIIllIllIIllIlllIlIIlllI).lIlIlIlIlIIlIIlIIllIIIIIl((IllIllIIIllIIIlIlIlIIIIll)null);
                    }
                    return true;
                });
                return arrayList;
            }
        };
        illIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl);
        return illIllIIIllIIIlIlIlIIIIll;
    }

    public void llIlllIIIllllIIlllIllIIIl() {
        FriendsUIScreen.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        int n;
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) ? 1612520733 : 0);
        LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 8.0f, this.y + 3.0f, this.lIlIlIlIlIIlIIlIIllIIIIIl);
        FontRegistry.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.llllIIlIIlIIlIIllIIlIIllI().toUpperCase(), this.x + 28.0f, this.y + 3.5f, this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl());
        FontRegistry.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(), this.x + 28.0f, this.y + 10.5f, -4210753);
        MinecraftVersion minecraftVersion = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIIIllIllIIllIlllIlIIlllI();
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllllIlIIIlIIlIIllIIlIll() && minecraftVersion != null) {
            float f3 = FontRegistry.IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl(minecraftVersion.IlIlIlllllIlIIlIlIlllIlIl());
            FontRegistry.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(minecraftVersion.IlIlIlllllIlIIlIlIlllIlIl(), this.x + this.width - f3 - 4.0f - (float)(((FriendsListUIComponent)this.lIIIllIllIIllIlllIlIIlllI).llIIIIIIIllIIllIlIllIIIIl().llIlllIIIllllIIlllIllIIIl() ? 4 : 0), this.y + 10.5f, -2134917185);
        }
        if ((n = this.lIlIIIIIIlIIIllllIllIIlII.lllllIllIlIIlIIlIIIlllIlI().llIlllIIIllllIIlllIllIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll())) > 0) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(llIlIIIllIIlIllIllIllllIl, 5.0f, this.x + this.width - 22.0f, this.y + 5.0f);
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().IlllIIIIIIlllIlIIlllIlIIl(n + "", this.x + this.width - 17.0f, this.y + 6.5f, -1);
        } else if (this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIIlllIIlllIllllIlIllIl() != 0xFFFFFF) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIIlllIIlllIllllIlIllIl()), ColorUtil.lIllIlIIIlIIIIIIIlllIlIll(this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIIlllIIlllIllllIlIllIl()), ColorUtil.llllIIlIIlIIlIIllIIlIIllI(this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIIlllIIlllIllllIlIllIl()), 1.0f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(IlllIIIIIIlllIlIIlllIlIIl, 5.5f, this.x + this.width - 22.0f, this.y + 5.0f);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}
 