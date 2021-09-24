package com.moonsworth.lunar.client.feature.staff.type;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.block.BlockBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.staff.AbstractStaffMod;
import com.moonsworth.lunar.client.feature.staff.StaffModType;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;
import com.moonsworth.lunar.client.setting.NumberSetting;

import java.util.List;

public class XrayMod
    extends AbstractStaffMod {
    public List<BlockBridge> llllIIlIIlIIlIIllIIlIIllI = Ref.getMinecraft().bridge$xrayBlocks();
    public LunarKeybindSetting IlIlIlllllIlIIlIlIlllIlIl;
    public boolean llIIIIIIIllIIllIlIllIIIIl = false;
    public NumberSetting lIIIllIllIIllIlllIlIIlllI;

    public XrayMod() {
        super(StaffModType.lIlIlIlIlIIlIIlIIllIIIIIl);
        this.IlIlIlllllIlIIlIlIlllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (!this.lIllllIllIIlIIlIIIlIIIlII()) {
                return;
            }
            this.llIIIIIIIllIIllIlIllIIIIl = !this.llIIIIIIIllIIllIlIllIIIIl;
            Ref.getMinecraft().bridge$getRenderGlobal().bridge$reloadChunks();
        });
    }

    @Override
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        this.IlIlIlllllIlIIlIlIlllIlIl = new LunarKeybindSetting(this, "xrayToggle", KeyType.KEY_X, false);
        this.lIIIllIllIIllIlllIlIIlllI = new NumberSetting("opacity", 120, 1, 255, 0, () -> Bridge.getMinecraftVersion() != MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl);
        return ImmutableList.of(this.IlIlIlllllIlIIlIlIlllIlIl, this.lIIIllIllIIllIlllIlIIlllI);
    }

    @Override
    public FeatureDetails initDetails() {
        return new FeatureDetails("staff.XRAY", ImmutableList.of());
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(BlockBridge blockBridge, boolean bl) {
        return this.IlllIIIIIIlllIlIIlllIlIIl() && this.llIIIIIIIllIIllIlIllIIIIl ? this.llllIIlIIlIIlIIllIIlIIllI.contains(blockBridge) : bl;
    }

    public List lIlIlIIIIIIllIlIIIIllIIII() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public boolean lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(boolean bl) {
        this.llIIIIIIIllIIllIlIllIIIIl = bl;
    }

    public NumberSetting IlIIlIIlIIlIIllIIIllIIllI() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }
}
