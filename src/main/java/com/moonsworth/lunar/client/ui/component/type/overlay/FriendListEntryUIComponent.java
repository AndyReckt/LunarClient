package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.IllIllIIIllIIIlIlIlIIIIll;
import com.moonsworth.lunar.client.ui.component.type.setting.lIlIlIIIIIIllIlIIIIllIIII;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;
import com.moonsworth.lunar.client.profile.FriendProfile;

import java.util.ArrayList;
import java.util.List;

public class FriendListEntryUIComponent extends AbstractFriendUIComponent {
    public static final ResourceLocationBridge lunarLogo = Bridge.getInstance().initResourceLocation("lunar", "icons/assets/logo-22x22.png");
    public ColorEase ease = new ColorEase(0, 1075649821);
    public static final ResourceLocationBridge unreadLogo = Bridge.getInstance().initResourceLocation("lunar", "icons/assets/unread-19x19.png");

    public FriendListEntryUIComponent(AbstractListUIComponent<?> uIComponent, FriendProfile friend) {
        super(uIComponent, friend);
        this.onMouseClick((mouseX, mouseY, button) -> {
            if (button == 1) {
                uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(this.llllIIlIIlIIlIIllIIlIIllI());
                uIComponent.llIllIlIllIlllIllIIIIllII().lIlIlIlIlIIlIIlIIllIIIIIl(mouseX, mouseY + ((FriendsListUIComponent) uIComponent).getScrollBar().getYOffset());
                return true;
            } else if (button == 0) {
                this.llIlllIIIllllIIlllIllIIIl();
            }
            return false;
        });
    }

    //com.moonsworth.lunar.client.ui.component.type.setting.IllIllIIIllIIIlIlIlIIIIll
    public IllIllIIIllIIIlIlIlIIIIll llllIIlIIlIIlIIllIIlIIllI() {
        IllIllIIIllIIIlIlIlIIIIll illIllIIIllIIIlIlIlIIIIll = new IllIllIIIllIIIlIlIlIIIIll(this) {

            @Override
            public List lIllIlIIIlIIIIIIIlllIlIll() {
                ArrayList<lIlIlIIIIIIllIlIIIIllIIII> arrayList = new ArrayList<lIlIlIIIIIIllIlIIIIllIIII>();
                lIlIlIIIIIIllIlIIIIllIIII lIlIlIIIIIIllIlIIIIllIIII2 = new lIlIlIIIIIIllIlIIIIllIIII(this.sumTing, "sendMessage");
                arrayList.add(lIlIlIIIIIIllIlIIIIllIIII2);
                lIlIlIIIIIIllIlIIIIllIIII2.onMouseClick((float f, float f2, int n) -> {
                    FriendListEntryUIComponent.this.llIlllIIIllllIIlllIllIIIl();
                    if (FriendListEntryUIComponent.this.parent.mouseInside(f, f2)) {
                        ((AbstractListUIComponent) FriendListEntryUIComponent.this.parent).IlllIIIIIIlllIlIIlllIlIIl(true);
                    } else {
                        ((AbstractListUIComponent) FriendListEntryUIComponent.this.parent).lIlIlIlIlIIlIIlIIllIIIIIl((IllIllIIIllIIIlIlIlIIIIll) null);
                    }
                    return true;
                });
                lIlIlIIIIIIllIlIIIIllIIII lIlIlIIIIIIllIlIIIIllIIII3 = new lIlIlIIIIIIllIlIIIIllIIII(this.sumTing, "removeFriend");
                arrayList.add(lIlIlIIIIIIllIlIIIIllIIII3);
                lIlIlIIIIIIllIlIIIIllIIII3.onMouseClick((float f, float f2, int n) -> {
                    FriendProfile websocketProfile = this.llllIIlIIlIIlIIllIIlIIllI();
                    LunarClient.getInstance().getPlayerHeadManager().lIllIlIIIlIIIIIIIlllIlIll(websocketProfile.lIllIlIIIlIIIIIIIlllIlIll());
                    if (FriendListEntryUIComponent.this.parent.mouseInside(f, f2)) {
                        ((AbstractListUIComponent) FriendListEntryUIComponent.this.parent).IlllIIIIIIlllIlIIlllIlIIl(true);
                    } else {
                        ((AbstractListUIComponent) FriendListEntryUIComponent.this.parent).lIlIlIlIlIIlIIlIIllIIIIIl((IllIllIIIllIIIlIlIlIIIIll) null);
                    }
                    return true;
                });
                return arrayList;
            }
        };
        illIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.friend);
        return illIllIIIllIIIlIlIlIIIIll;
    }

    public void llIlllIIIllllIIlllIllIIIl() {
        FriendsUIScreen.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.friend);
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        int n;
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, bl && this.mouseInside(mouseX, mouseY) ? 1612520733 : 0);
        LunarClient.getInstance().getPlayerHeadManager().lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 8.0f, this.y + 3.0f, this.friend);
        FontRegistry.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.friend.llllIIlIIlIIlIIllIIlIIllI().toUpperCase(), this.x + 28.0f, this.y + 3.5f, this.friend.lIlIlIlIlIIlIIlIIllIIIIIl());
        FontRegistry.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.friend.IlllIIIIIIlllIlIIlllIlIIl(), this.x + 28.0f, this.y + 10.5f, -4210753);
        MinecraftVersion minecraftVersion = this.friend.lIIIllIllIIllIlllIlIIlllI();
        if (this.friend.IlllllIlIIIlIIlIIllIIlIll() && minecraftVersion != null) {
            float f3 = FontRegistry.IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl(minecraftVersion.IlIlIlllllIlIIlIlIlllIlIl());
            FontRegistry.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(minecraftVersion.IlIlIlllllIlIIlIlIlllIlIl(), this.x + this.width - f3 - 4.0f - (float) (((FriendsListUIComponent) this.parent).getScrollBar().llIlllIIIllllIIlllIllIIIl() ? 4 : 0), this.y + 10.5f, -2134917185);
        }
        if ((n = this.lc.getPlayerHeadManager().llIlllIIIllllIIlllIllIIIl(this.friend.lIllIlIIIlIIIIIIIlllIlIll())) > 0) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(unreadLogo, 5.0f, this.x + this.width - 22.0f, this.y + 5.0f);
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().IlllIIIIIIlllIlIIlllIlIIl(n + "", this.x + this.width - 17.0f, this.y + 6.5f, -1);
        } else if (this.friend.llIIIlllIIlllIllllIlIllIl() != 0xFFFFFF) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(this.friend.llIIIlllIIlllIllllIlIllIl()), ColorUtil.lIllIlIIIlIIIIIIIlllIlIll(this.friend.llIIIlllIIlllIllllIlIllIl()), ColorUtil.llllIIlIIlIIlIIllIIlIIllI(this.friend.llIIIlllIIlllIllllIlIllIl()), 1.0f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(lunarLogo, 5.5f, this.x + this.width - 22.0f, this.y + 5.0f);
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }
}
