package com.moonsworth.lunar.client.feature.staff;

import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.network.NetHandlerConnectionStateUpdateEvent;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.staff.type.XrayMod;
import com.moonsworth.lunar.client.ref.Ref;

public abstract class AbstractStaffMod extends ConfigurableFeature {
    public final StaffModType type;
    public boolean IlIlIlllllIlIIlIlIlllIlIl = true;

    public AbstractStaffMod(StaffModType staffModType) {
        super(false);
        this.type = staffModType;
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
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.type.lIlIlIlIlIIlIIlIIllIIIIIl(), f, f2, f3, f4);
    }

    public StaffModType IlIllIIlIIlIIIllIllllIIll() {
        return this.type;
    }

    public boolean lIllllIllIIlIIlIIIlIIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public void setState(boolean bl) {
        this.IlIlIlllllIlIIlIlIlllIlIl = bl;
    }

    static {
        EventBus.getInstance().register(NetHandlerConnectionStateUpdateEvent.class, netHandlerConnectionStateUpdateEvent -> Ref.getLC().IIlIllIlllllllIIlIIIllIIl().llIlllIIIllllIIlllIllIIIl().forEach(abstractStaffModManager -> {
            if (abstractStaffModManager instanceof XrayMod) {
                ((XrayMod)abstractStaffModManager).IlIlIlllllIlIIlIlIlllIlIl(false);
                if (Ref.getWorld() != null) {
                    Ref.getMinecraft().bridge$getRenderGlobal().bridge$reloadChunks();
                }
            }
            // lol
            abstractStaffModManager.setState(false);
        }));
    }
}
