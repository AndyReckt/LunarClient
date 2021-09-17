package com.moonsworth.lunar.client.event.handler;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.EventWithResult;
import com.moonsworth.lunar.client.event.type.hud.RenderCrosshairEvent;
import com.moonsworth.lunar.client.event.type.network.NetHandlerConnectionStateUpdateEvent;
import com.moonsworth.lunar.client.profile.Profile;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.FriendStatusUtil;

public class StatusUpdateEventListener
implements EventHandler {
    public StatusUpdateEventListener() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, netHandlerConnectionStateUpdateEvent -> new Thread(() -> {
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            FriendStatusUtil.lIlIlIlIlIIlIIlIIllIIIIIl();
            if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentServerData() != null) {
                String string = Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentServerData().bridge$serverIP().toLowerCase();
                if (FriendStatusUtil.IlllIIIIIIlllIlIIlllIlIIl() != null) {
                    string = FriendStatusUtil.IlllIIIIIIlllIlIIlllIlIIl();
                }
                string = string.toLowerCase();
                Profile profile = null;
                for (Profile profile2 : LunarClient.IIllIlIllIlIllIllIllIllII().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl()) {
                    if (profile2.llIIIIIIIllIIllIlIllIIIIl().equals("")) continue;
                    if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentServerData().bridge$serverIP().toLowerCase().endsWith("hypixel.net") && profile2.llIIIIIIIllIIllIlIllIIIIl().toLowerCase().endsWith("hypixel.net")) {
                        profile = profile2;
                        continue;
                    }
                    if (!string.endsWith(profile2.llIIIIIIIllIIllIlIllIIIIl().toLowerCase())) continue;
                    LunarClient.IIllIlIllIlIllIllIllIllII().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl(profile2);
                    return;
                }
                if (profile != null) {
                    LunarClient.IIllIlIllIlIllIllIllIllII().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl(profile);
                }
            }
        }).start());
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderCrosshairEvent.class, renderCrosshairEvent -> {
            if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$getThirdPersonView() != 0 && !((Boolean)Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllIIIlllIIIlIlllIlIIlIII().llIlllIIIllllIIlllIllIIIl()).booleanValue()) {
                renderCrosshairEvent.lIlIlIlIlIIlIIlIIllIIIIIl(EventWithResult.EventStateResult.IlllIIIIIIlllIlIIlllIlIIl);
            }
        });
    }
}