package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.profile.FriendProfile;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

public class FriendUIComponent extends UIComponent {
    public final FriendProfile friend;
    public final ColorEase ease = new ColorEase(-2130706433, -1);

    public FriendUIComponent(UIComponent parent, FriendProfile friend) {
        super(parent);
        this.friend = friend;
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        LunarClient.getInstance().getPlayerHeadManager().drawPlayerHead(this.x, this.y, this.friend.lIllIlIIIlIIIIIIIlllIlIll(), this.friend.lIlIlIlIlIIlIIlIIllIIIIIl(), ColorUtil.llIIIIIIIllIIllIlIllIIIIl(this.ease.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY))));
        if (this.mouseInside(mouseX, mouseY)) {
            LCFontRenderer lCFontRenderer = FontRegistry.llIIIlllIIlllIllllIlIllIl();
            AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x - 9.0f - (float)lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(this.friend.llllIIlIIlIIlIIllIIlIIllI().toUpperCase()) - 6.0f, this.y + 1.0f, lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(this.friend.llllIIlIIlIIlIIllIIlIIllI().toUpperCase()) + 7, this.height, 4.0f, Integer.MIN_VALUE);
            lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(this.friend.llIlllIIIllllIIlllIllIIIl().toUpperCase(), this.x - 11.0f - (float)lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(this.friend.llllIIlIIlIIlIIllIIlIIllI().toUpperCase()), this.y + 3.0f, -1);
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }

    public FriendProfile lIllIlIIIlIIIIIIIlllIlIll() {
        return this.friend;
    }
}
