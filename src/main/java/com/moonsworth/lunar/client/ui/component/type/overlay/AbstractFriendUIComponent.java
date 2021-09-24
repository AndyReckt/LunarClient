package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.profile.FriendProfile;
import lombok.Getter;

@Getter
public abstract class AbstractFriendUIComponent extends UIComponent {
    protected final FriendProfile friend;

    public AbstractFriendUIComponent(UIComponent parent, FriendProfile friend) {
        super(parent);
        this.friend = friend;
    }

}