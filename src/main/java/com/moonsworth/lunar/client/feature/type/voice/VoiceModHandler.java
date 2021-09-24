package com.moonsworth.lunar.client.feature.type.voice;

import com.moonsworth.lunar.client.profile.FriendProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class VoiceModHandler {
    public final UUID lIlIlIlIlIIlIIlIIllIIIIIl;
    public final String IlllIIIIIIlllIlIIlllIlIIl;
    public final Map<UUID, FriendProfile> lIllIlIIIlIIIIIIIlllIlIll = new ConcurrentHashMap();
    public final List<UUID> llIlllIIIllllIIlllIllIIIl = new ArrayList<>();

    public VoiceModHandler(UUID uUID, String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = uUID;
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
    }

    public FriendProfile lIlIlIlIlIIlIIlIIllIIIIIl(UUID uUID, String string) {
        FriendProfile profile = null;
        if (!this.llIlllIIIllllIIlllIllIIIl(uUID)) {
            profile = new FriendProfile(uUID);
            this.lIllIlIIIlIIIIIIIlllIlIll.put(uUID, profile);
            profile.lIlIlIlIlIIlIIlIIllIIIIIl(string);
        }
        return profile;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(UUID uUID) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll(uUID)) {
            this.IlllIIIIIIlllIlIIlllIlIIl(uUID);
        }
        this.lIllIlIIIlIIIIIIIlllIlIll.remove(uUID);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(UUID uUID, String string) {
        if (this.llIlllIIIllllIIlllIllIIIl(uUID)) {
            this.llIlllIIIllllIIlllIllIIIl.add(uUID);
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(UUID uUID) {
        this.llIlllIIIllllIIlllIllIIIl.removeIf(uUID2 -> uUID2.equals(uUID));
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll(UUID uUID) {
        for (UUID uUID2 : this.llIlllIIIllllIIlllIllIIIl) {
            if (!uUID2.equals(uUID)) continue;
            return true;
        }
        return false;
    }

    public boolean llIlllIIIllllIIlllIllIIIl(UUID uUID) {
        return this.lIllIlIIIlIIIIIIIlllIlIll.containsKey(uUID);
    }

    public UUID lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public Map lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }
}
