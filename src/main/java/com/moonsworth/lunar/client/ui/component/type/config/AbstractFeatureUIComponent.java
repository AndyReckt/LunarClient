package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.ui.component.UIComponent;

public abstract class AbstractFeatureUIComponent
extends UIComponent {
    public final Feature lIlIlIlIlIIlIIlIIllIIIIIl;

    public AbstractFeatureUIComponent(UIComponent uIComponent, Feature feature) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = feature;
    }

    public Feature lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}