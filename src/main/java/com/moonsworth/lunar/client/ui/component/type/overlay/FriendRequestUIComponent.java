package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.websocket.FriendProfile;

public class FriendRequestUIComponent
extends AbstractFriendUIComponent {
    public ColorEase IlllIIIIIIlllIlIIlllIlIIl;
    public static final ResourceLocationBridge lIllIlIIIlIIIIIIIlllIlIll = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/accept-10x10.png");
    public static final ResourceLocationBridge llIlIIIllIIlIllIllIllllIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/deny-10x10.png");
    public final lIllIlIIIlIIIIIIIlllIlIll IllIllIIIllIIIlIlIlIIIIll;
    public final lIllIlIIIlIIIIIIIlllIlIll IIlIllIlllllllIIlIIIllIIl;
    public final boolean lIIlIlllIlIlIIIlllIIlIIII;

    public FriendRequestUIComponent(UIComponent uIComponent, FriendProfile websocketProfile, boolean bl) {
        super(uIComponent, websocketProfile);
        this.lIIlIlllIlIlIIIlllIIlIIII = bl;
        this.IlllIIIIIIlllIlIIlllIlIIl = new ColorEase(0, 1075649821);
        this.IllIllIIIllIIIlIlIlIIIIll = new lIllIlIIIlIIIIIIIlllIlIll(this, lIllIlIIIlIIIIIIIlllIlIll, -1891257749, -12209557);
        this.IIlIllIlllllllIIlIIIllIIl = new lIllIlIIIlIIIIIIIlllIlIll(this, llIlIIIllIIlIllIllIllllIl, -1879953071, -904879);
        this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientFriendRequestUpdate(true, websocketProfile.lIllIlIIIlIIIIIIIlllIlIll().toString()));
            this.lIlIIIIIIlIIIllllIllIIlII.IllIIIlllIIIlIlllIlIIlIII().lIlIlIlIlIIlIIlIIllIIIIIl(websocketProfile.lIllIlIIIlIIIIIIIlllIlIll());
            return true;
        });
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (bl) {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientFriendRequestUpdate(false, websocketProfile.lIllIlIIIlIIIIIIIlllIlIll().toString()));
                this.lIlIIIIIIlIIIllllIllIIlII.IllIIIlllIIIlIlllIlIIlIII().IlIlIlllllIlIIlIlIlllIlIl().remove(websocketProfile);
                FriendsUIScreen.llIIIIIIIllIIllIlIllIIIIl().IlllllIlIIIlIIlIIllIIlIll();
                return true;
            }
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientFriendRequestUpdate(false, websocketProfile.lIllIlIIIlIIIIIIIlllIlIll().toString()));
            this.lIlIIIIIIlIIIllllIllIIlII.IllIIIlllIIIlIlllIlIIlIII().lIlIlIlIlIIlIIlIIllIIIIIl(websocketProfile.lIllIlIIIlIIIIIIIlllIlIll());
            return true;
        });
    }

    public FriendRequestUIComponent(UIComponent uIComponent, FriendProfile websocketProfile) {
        this(uIComponent, websocketProfile, false);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 20.0f, f2, 10.0f, f4);
        if (this.lIIlIlllIlIlIIIlllIIlIIII) {
            return;
        }
        this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 30.0f, f2, 10.0f, f4);
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        if (this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        }
        if (this.lIIlIlllIlIlIIIlllIIlIIII) {
            return super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        }
        if (this.IllIllIIIllIIIlIlIlIIIIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        }
        return super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 8.0f, this.y + 3.0f, this.lIlIlIlIlIIlIIlIIllIIIIIl);
        FontRegistry.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.llIlllIIIllllIIlllIllIIIl().toUpperCase(), this.x + 28.0f, this.y + 3.5f, this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl());
        FontRegistry.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl("Friend Request", this.x + 28.0f, this.y + 10.5f, -4210753);
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        if (this.lIIlIlllIlIlIIIlllIIlIIII) {
            return;
        }
        this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}
 