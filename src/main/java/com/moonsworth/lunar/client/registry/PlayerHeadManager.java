package com.moonsworth.lunar.client.registry;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.ThreadDownloadImageDataBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;
import com.moonsworth.lunar.client.websocket.FriendProfile;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class PlayerHeadManager
extends ItemSetLoader<FriendProfile> {
    public static final Map lIlIlIlIlIIlIIlIIllIIIIIl = new HashMap();
    public final Map IlllIIIIIIlllIlIIlllIlIIl = new ConcurrentHashMap();

    @Override
    public Set lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new HashSet();
    }

    public FriendProfile lIlIlIlIlIIlIIlIIllIIIIIl(UUID uUID) {
        for (FriendProfile profile : this.llIlllIIIllllIIlllIllIIIl()) {
            if (!profile.lIllIlIIIlIIIIIIIlllIlIll().equals(uUID)) continue;
            return profile;
        }
        return null;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(UUID uUID) {
        for (FriendProfile profile : this.llIlllIIIllllIIlllIllIIIl()) {
            if (!profile.lIllIlIIIlIIIIIIIlllIlIll().equals(uUID)) continue;
            return true;
        }
        return false;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(FriendProfile profile) {
        this.llIlllIIIllllIIlllIllIIIl().add(profile);
        this.IlIlIlllllIlIIlIlIlllIlIl();
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(UUID uUID) {
        this.llIlllIIIllllIIlllIllIIIl().removeIf(profile -> profile.lIllIlIIIlIIIIIIIlllIlIll().equals(uUID));
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientFriendRemove(uUID.toString()));
        this.IlIlIlllllIlIIlIlIlllIlIl();
    }

    public int llIlllIIIllllIIlllIllIIIl(UUID uUID) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        FriendProfile profile = this.lIlIlIlIlIIlIIlIIllIIIIIl(uUID);
        if (profile != null && this.IlllIIIIIIlllIlIIlllIlIIl.containsKey(profile)) {
            int n = 0;
            for (lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2 : (List)this.IlllIIIIIIlllIlIIlllIlIIl.get(profile)) {
                if (lIllIlIIIlIIIIIIIlllIlIll2.IlIlIlllllIlIIlIlIlllIlIl()) continue;
                ++n;
            }
            atomicInteger.addAndGet(n);
        }
        return atomicInteger.get();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(UUID uUID, String string) {
        FriendProfile profile = this.lIlIlIlIlIIlIIlIIllIIIIIl(uUID);
        if (profile != null) {
            this.IlllIIIIIIlllIlIIlllIlIIl.putIfAbsent(profile, new CopyOnWriteArrayList());
            if (((List)this.IlllIIIIIIlllIlIIlllIlIIl.get(profile)).size() > 200) {
                ((List)this.IlllIIIIIIlllIlIIlllIlIIl.get(profile)).remove(0);
            }
            LunarClient.IIllIlIllIlIllIllIllIllII().IIIlIIIIIIllIIIIllIIIIlII().llIlllIIIllllIIlllIllIIIl(profile.llIlllIIIllllIIlllIllIIIl(), string);
            ((List)this.IlllIIIIIIlllIlIIlllIlIIl.get(profile)).add(0, new lIllIlIIIlIIIIIIIlllIlIll(profile, string));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(FriendProfile profile, UUID uUID, String string) {
        FriendProfile profile2 = this.lIlIlIlIlIIlIIlIIllIIIIIl(uUID);
        if (profile2 != null) {
            this.IlllIIIIIIlllIlIIlllIlIIl.putIfAbsent(profile2, new CopyOnWriteArrayList());
            lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2 = new lIllIlIIIlIIIIIIIlllIlIll(profile, string);
            ((List)this.IlllIIIIIIlllIlIIlllIlIIl.get(profile2)).add(0, lIllIlIIIlIIIIIIIlllIlIll2);
            lIllIlIIIlIIIIIIIlllIlIll2.lIlIlIlIlIIlIIlIIllIIIIIl();
        }
        this.IlIlIlllllIlIIlIlIlllIlIl();
    }

    public List IlllIIIIIIlllIlIIlllIlIIl(FriendProfile profile) {
        return (List)this.IlllIIIIIIlllIlIIlllIlIIl.get(profile);
    }

    public void llllIIlIIlIIlIIllIIlIIllI() {
        this.llIlllIIIllllIIlllIllIIIl().clear();
        this.IlIlIlllllIlIIlIlIlllIlIl();
    }

    public void IlIlIlllllIlIIlIlIlllIlIl() {
        FriendsUIScreen.llIIIIIIIllIIllIlIllIIIIl().IlllllIlIIIlIIlIIllIIlIll();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, FriendProfile profile) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, profile.lIllIlIIIlIIIIIIIlllIlIll(), profile.lIlIlIlIlIIlIIlIIllIIIIIl(), 1.0f);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, UUID uUID, int n, float f3) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, f3);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(PlayerHeadManager.lIlIlIlIlIIlIIlIIllIIIIIl(uUID.toString()), 6.0f, f + 1.0f, f2 + 1.0f);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f + 1.0f, f2 + 1.0f, 12.0f, 12.0f, 4.0f, n);
    }

    public static ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        if (!lIlIlIlIlIIlIIlIIllIIIIIl.containsKey(string)) {
            ThreadDownloadImageDataBridge threadDownloadImageDataBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initThreadDownloadImageData(null, "https://minotar.net/helm/" + string + "/32.png", Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "steve.png"));
            ResourceLocationBridge resourceLocationBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "download/heads/" + string + ".png");
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getTextureManager().bridge$loadTexture(resourceLocationBridge, threadDownloadImageDataBridge);
            lIlIlIlIlIIlIIlIIllIIIIIl.put(string, resourceLocationBridge);
            return resourceLocationBridge;
        }
        return (ResourceLocationBridge)lIlIlIlIlIIlIIlIIllIIIIIl.get(string);
    }
}