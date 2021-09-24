package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.profile.FriendProfile;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;
import com.moonsworth.lunar.client.websocket.packet.WSPacketClientFriendRequestUpdate;

public class FriendRequestUIComponent extends AbstractFriendUIComponent {
    public ColorEase ease;
    public static final ResourceLocationBridge acceptIcon = Bridge.getInstance().initResourceLocation("lunar", "icons/assets/accept-10x10.png");
    public static final ResourceLocationBridge denyIcon = Bridge.getInstance().initResourceLocation("lunar", "icons/assets/deny-10x10.png");
    public final FriendRequestButtonUIComponent acceptButton;
    public final FriendRequestButtonUIComponent denyButton;
    public final boolean isOutbound;

    public FriendRequestUIComponent(UIComponent parent, FriendProfile friend, boolean bl) {
        super(parent, friend);
        this.isOutbound = bl;
        this.ease = new ColorEase(0, 1075649821);
        this.acceptButton = new FriendRequestButtonUIComponent(this, acceptIcon, -1891257749, -12209557);
        this.denyButton = new FriendRequestButtonUIComponent(this, denyIcon, -1879953071, -904879);
        this.acceptButton.onMouseClick((mouseX, mouseY, button) -> {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientFriendRequestUpdate(true, friend.lIllIlIIIlIIIIIIIlllIlIll().toString()));
            this.lc.IllIIIlllIIIlIlllIlIIlIII().lIlIlIlIlIIlIIlIIllIIIIIl(friend.lIllIlIIIlIIIIIIIlllIlIll());
            return true;
        });
        this.denyButton.onMouseClick((mouseX, mouseY, button) -> {
            if (bl) {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientFriendRequestUpdate(false, friend.lIllIlIIIlIIIIIIIlllIlIll().toString()));
                this.lc.IllIIIlllIIIlIlllIlIIlIII().IlIlIlllllIlIIlIlIlllIlIl().remove(friend);
                FriendsUIScreen.llIIIIIIIllIIllIlIllIIIIl().IlllllIlIIIlIIlIIllIIlIll();
                return true;
            }
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientFriendRequestUpdate(false, friend.lIllIlIIIlIIIIIIIlllIlIll().toString()));
            this.lc.IllIIIlllIIIlIlllIlIIlIII().lIlIlIlIlIIlIIlIIllIIIIIl(friend.lIllIlIIIlIIIIIIIlllIlIll());
            return true;
        });
    }

    public FriendRequestUIComponent(UIComponent parent, FriendProfile friend) {
        this(parent, friend, false);
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        this.denyButton.setPositionAndSize(x + width - 20.0f, y, 10.0f, height);
        if (this.isOutbound) {
            return;
        }
        this.acceptButton.setPositionAndSize(x + width - 30.0f, y, 10.0f, height);
    }

    @Override
    public boolean onMouseClicked(float mouseX, float mouseY, int mouseButton) {
        if (this.denyButton.mouseInside(mouseX, mouseY)) {
            this.denyButton.onMouseClicked(mouseX, mouseY, mouseButton);
        }
        if (this.isOutbound) {
            return super.onMouseClicked(mouseX, mouseY, mouseButton);
        }
        if (this.acceptButton.mouseInside(mouseX, mouseY)) {
            this.acceptButton.onMouseClicked(mouseX, mouseY, mouseButton);
        }
        return super.onMouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        LunarClient.getInstance().getPlayerHeadManager().lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 8.0f, this.y + 3.0f, this.friend);
        FontRegistry.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.friend.llIlllIIIllllIIlllIllIIIl().toUpperCase(), this.x + 28.0f, this.y + 3.5f, this.friend.lIlIlIlIlIIlIIlIIllIIIIIl());
        FontRegistry.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl("Friend Request", this.x + 28.0f, this.y + 10.5f, -4210753);
        this.denyButton.drawComponent(mouseX, mouseY, bl);
        if (this.isOutbound) {
            return;
        }
        this.acceptButton.drawComponent(mouseX, mouseY, bl);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }
}
