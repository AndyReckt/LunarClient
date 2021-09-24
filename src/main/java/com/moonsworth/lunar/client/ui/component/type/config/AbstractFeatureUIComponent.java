package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.ui.component.UIComponent;

public abstract class AbstractFeatureUIComponent extends UIComponent {
    public final Feature feature;

    public AbstractFeatureUIComponent(UIComponent parent, Feature feature) {
        super(parent);
        this.feature = feature;
    }

    public Feature getFeature() {
        return this.feature;
    }
}