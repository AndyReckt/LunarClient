package com.moonsworth.lunar.client.registry;

import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;
import com.moonsworth.lunar.client.websocket.FriendProfile;

import java.util.*;

public class UUIDFriendSetLoader
extends ItemSetLoader<FriendProfile> {
    public List<FriendProfile> lIlIlIlIlIIlIIlIIllIIIIIl = new ArrayList<>();

    @Override
    public Set<FriendProfile> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new HashSet<>();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(UUID uUID) {
        this.llIlllIIIllllIIlllIllIIIl().removeIf(profile -> profile.lIllIlIIIlIIIIIIIlllIlIll().equals(uUID));
        this.IlIlIlllllIlIIlIlIlllIlIl().removeIf(profile -> profile.lIllIlIIIlIIIIIIIlllIlIll().equals(uUID));
        this.llIIIIIIIllIIllIlIllIIIIl();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(UUID uUID, String string) {
        FriendProfile profile = new FriendProfile(uUID);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.add(profile);
        profile.lIlIlIlIlIIlIIlIIllIIIIIl(string);
        this.llIIIIIIIllIIllIlIllIIIIl();
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(UUID uUID, String string) {
        FriendProfile profile = new FriendProfile(uUID);
        this.llIlllIIIllllIIlllIllIIIl().add(profile);
        profile.lIlIlIlIlIIlIIlIIllIIIIIl(string);
        this.llIIIIIIIllIIllIlIllIIIIl();
    }

    public void llllIIlIIlIIlIIllIIlIIllI() {
        this.llIlllIIIllllIIlllIllIIIl().clear();
        this.llIIIIIIIllIIllIlIllIIIIl();
    }

    public void llIIIIIIIllIIllIlIllIIIIl() {
        FriendsUIScreen.llIIIIIIIllIIllIlIllIIIIl().IlllllIlIIIlIIlIIllIIlIll();
    }

    public List<FriendProfile> IlIlIlllllIlIIlIlIlllIlIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
 