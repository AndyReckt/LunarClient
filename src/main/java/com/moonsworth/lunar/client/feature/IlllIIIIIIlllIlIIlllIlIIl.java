package com.moonsworth.lunar.client.feature;

import com.google.common.base.Preconditions;
import com.lunarclient.bukkitapi.nethandler.client.obj.ServerRule;

public abstract class IlllIIIIIIlllIlIIlllIlIIl extends lIlIlIlIlIIlIIlIIllIIIIIl {
    public ServerRule IlIlIlllllIlIIlIlIlllIlIl;

    public IlllIIIIIIlllIlIIlllIlIIl(ServerRule serverRule, boolean bl) {
        super(serverRule, bl);
        this.IlIlIlllllIlIIlIlIlllIlIl = Preconditions.checkNotNull(serverRule, "Server Rule cannot be null");
    }

    public ServerRule lIlIlIIIIIIllIlIIIIllIIII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }
}