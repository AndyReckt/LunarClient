package com.moonsworth.lunar.client.feature.type.nameplates;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.client.event.type.hud.RenderNameEvent;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.util.NameLine;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomNameplateMod
extends Feature {
    public CustomNameplateMod() {
        super(true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderNameEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderNameEvent renderNameEvent) {
        List<String> list = this.llIlllIIIllllIIlllIllIIIl.llIIIlIllIIIIlIIIlIlIllIl().llIlllIIIllllIIlllIllIIIl().get(renderNameEvent.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getUniqueID());
        if (list != null) {
            renderNameEvent.IlIlIlllllIlIIlIlIlllIlIl().clear();
            renderNameEvent.IlIlIlllllIlIIlIlIlllIlIl().addAll(list.stream().map(NameLine::new).collect(Collectors.toCollection(LinkedList::new)));
        }
    }

    @Override
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
    }

    @Override
    public FeatureDetails llIIIIIIIllIIllIlIllIIIIl() {
        return new FeatureDetails("custom_nameplate", ImmutableList.of(ModuleCategory.llIlllIIIllllIIlllIllIIIl), new String[0]);
    }
}
 