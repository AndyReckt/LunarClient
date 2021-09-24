package com.moonsworth.lunar.client.event.handler;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.EventWithResult;
import com.moonsworth.lunar.client.event.type.hud.RenderCrosshairEvent;
import com.moonsworth.lunar.client.event.type.network.NetHandlerConnectionStateUpdateEvent;
import com.moonsworth.lunar.client.profile.Profile;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.FriendStatusUtil;

public class StatusUpdateEventListener implements EventHandler {
    public StatusUpdateEventListener() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, netHandlerConnectionStateUpdateEvent -> new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            FriendStatusUtil.lIlIlIlIlIIlIIlIIllIIIIIl();
            if (Ref.getMinecraft().bridge$getCurrentServerData() != null) {
                String string = Ref.getMinecraft().bridge$getCurrentServerData().bridge$serverIP().toLowerCase();
                if (FriendStatusUtil.IlllIIIIIIlllIlIIlllIlIIl() != null) {
                    string = FriendStatusUtil.IlllIIIIIIlllIlIIlllIlIIl();
                }
                string = string.toLowerCase();
                Profile profile = null;
                for (Profile profile2 : LunarClient.getInstance().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl()) {
                    if (profile2.getServer().equals("")) continue;
                    if (Ref.getMinecraft().bridge$getCurrentServerData().bridge$serverIP().toLowerCase().endsWith("hypixel.net") && profile2.getServer().toLowerCase().endsWith("hypixel.net")) {
                        profile = profile2;
                        continue;
                    }
                    if (!string.endsWith(profile2.getServer().toLowerCase())) continue;
                    LunarClient.getInstance().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl(profile2);
                    return;
                }
                if (profile != null) {
                    LunarClient.getInstance().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl(profile);
                }
            }
        }).start());
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderCrosshairEvent.class, renderCrosshairEvent -> {
            if (Ref.getMinecraft().bridge$getGameSettings().bridge$getThirdPersonView() != 0 && !Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllIIIlllIIIlIlllIlIIlIII().llIlllIIIllllIIlllIllIIIl().booleanValue()) {
                renderCrosshairEvent.lIlIlIlIlIIlIIlIIllIIIIIl(EventWithResult.EventStateResult.DENY);
            }
        });
    }
}