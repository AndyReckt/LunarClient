package com.moonsworth.lunar.client.feature.staff;

import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.network.NetHandlerConnectionStateUpdateEvent;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.staff.type.XrayMod;
import com.moonsworth.lunar.client.ref.Ref;

public abstract class AbstractStaffModManager
extends ConfigurableFeature {
    public final StaffModType llllIIlIIlIIlIIllIIlIIllI;
    public boolean IlIlIlllllIlIIlIlIlllIlIl = false;

    public AbstractStaffModManager(StaffModType staffModType) {
        super(false);
        this.llllIIlIIlIIlIIllIIlIIllI = staffModType;
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        if (!this.IlIlIlllllIlIIlIlIlllIlIl) {
            super.IlllIIIIIIlllIlIIlllIlIIl(false);
            return;
        }
        super.IlllIIIIIIlllIlIIlllIlIIl(bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.llllIIlIIlIIlIIllIIlIIllI.lIlIlIlIlIIlIIlIIllIIIIIl(), f, f2, f3, f4);
    }

    public StaffModType IlIllIIlIIlIIIllIllllIIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public boolean lIllllIllIIlIIlIIIlIIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(boolean bl) {
        this.IlIlIlllllIlIIlIlIlllIlIl = bl;
    }

    static {
        EventBus.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, netHandlerConnectionStateUpdateEvent -> Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlllllllIIlIIIllIIl().llIlllIIIllllIIlllIllIIIl().forEach(abstractStaffModManager -> {
            if (abstractStaffModManager instanceof XrayMod) {
                ((XrayMod)abstractStaffModManager).IlIlIlllllIlIIlIlIlllIlIl(false);
                if (Ref.llIIIIIIIllIIllIlIllIIIIl() != null) {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getRenderGlobal().bridge$reloadChunks();
                }
            }
            // lol
            ((XrayMod)abstractStaffModManager).llllIIlIIlIIlIIllIIlIIllI(false);
        }));
    }
}
 