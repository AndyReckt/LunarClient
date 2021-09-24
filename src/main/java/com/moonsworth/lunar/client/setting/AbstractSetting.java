package com.moonsworth.lunar.client.setting;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Decencies
 * @since 10/07/2021 14:04
 */
public abstract class AbstractSetting<T> implements I18nBridge, Json {

    public T value;
    public T defaultValue;
    public String name;
    public BooleanSupplier llIlllIIIllllIIlllIllIIIl;
    public List<Consumer<T>> llllIIlIIlIIlIIllIIlIIllI = new CopyOnWriteArrayList<>();
    public T IlIlIlllllIlIIlIlIlllIlIl;

    public AbstractSetting(String name, T value) {
        this.name = name;
        this.value = this.defaultValue = value;
        this.llIlllIIIllllIIlllIllIIIl = () -> false;
    }

    public AbstractSetting(String name, T value, BooleanSupplier booleanSupplier) {
        this.name = name;
        this.value = this.defaultValue = value;
        this.llIlllIIIllllIIlllIllIIIl = booleanSupplier;
    }

    public AbstractSetting<T> lIlIlIlIlIIlIIlIIllIIIIIl(Consumer<T> consumer) {
        this.llllIIlIIlIIlIIllIIlIIllI.add(consumer);
        consumer.accept(this.value);
        return this;
    }

    public AbstractSetting<T> IlllIIIIIIlllIlIIlllIlIIl(Consumer<T> consumer) {
        this.llllIIlIIlIIlIIllIIlIIllI.add(consumer);
        return this;
    }

    public abstract void lIlIlIlIlIIlIIlIIllIIIIIl(String var1);

    public void lIlIlIlIlIIlIIlIIllIIIIIl(T object, Predicate<T> predicate) {
        if (predicate.test(this.value)) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(object);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(T newValue) {
        if (!Objects.equals(this.value, newValue)) {
            this.value = newValue;
            for (Consumer<T> consumer : this.llllIIlIIlIIlIIllIIlIIllI) {
                consumer.accept(newValue);
            }
            if (Ref.getWorld() != null) {
                Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl(this);
            }
        }
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(T object) {
        Object object2 = this.llIlllIIIllllIIlllIllIIIl();
        this.IlIlIlllllIlIIlIlIlllIlIl = object;
        return object2 != this.llIlllIIIllllIIlllIllIIIl();
    }

    public T llIlllIIIllllIIlllIllIIIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl != null ? this.IlIlIlllllIlIIlIlIlllIlIl : this.value;
    }

    @Override
    public void write(JsonObject jsonObject) {
        if (this.value.equals(this.defaultValue)) {
            return;
        }
        jsonObject.addProperty(this.name, this.value.toString());
    }

    @Override
    public void read(JsonObject jsonObject) {
        if (!jsonObject.has(this.name) || jsonObject.get(this.name).isJsonNull()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.defaultValue);
            return;
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject.get(this.name).getAsString());
    }

    public void d_() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.defaultValue);
    }

    public abstract AbstractDescritiveSettingUIComponent getUIComponent(UIComponent var1);

    @Override
    public String getLanguagePath() {
        return "settings";
    }

    public String f_() {
        return this.get(this.name);
    }

    public T IllIllIIIllIIIlIlIlIIIIll() {
        return this.value;
    }

    public T IIlIllIlllllllIIlIIIllIIl() {
        return this.defaultValue;
    }

    public String lIIlIlllIlIlIIIlllIIlIIII() {
        return this.name;
    }

    public BooleanSupplier llIllIlIllIlllIllIIIIllII() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(BooleanSupplier booleanSupplier) {
        this.llIlllIIIllllIIlllIllIIIl = booleanSupplier;
    }

}
