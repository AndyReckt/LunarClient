package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.websocket.FriendProfile;

public abstract class AbstractFriendUIComponent
extends UIComponent {
    public final FriendProfile lIlIlIlIlIIlIIlIIllIIIIIl;

    public AbstractFriendUIComponent(UIComponent uIComponent, FriendProfile websocketProfile) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = websocketProfile;
    }

    public FriendProfile lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}