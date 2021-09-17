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
    public T IlllIIIIIIlllIlIIlllIlIIl;
    public String lIllIlIIIlIIIIIIIlllIlIll;
    public BooleanSupplier llIlllIIIllllIIlllIllIIIl;
    public List<Consumer<T>> llllIIlIIlIIlIIllIIlIIllI = new CopyOnWriteArrayList<>();
    public T IlIlIlllllIlIIlIlIlllIlIl;

    public AbstractSetting(String name, T value) {
        this.lIllIlIIIlIIIIIIIlllIlIll = name;
        this.value = this.IlllIIIIIIlllIlIIlllIlIIl = value;
        this.llIlllIIIllllIIlllIllIIIl = () -> false;
    }

    public AbstractSetting(String name, T value, BooleanSupplier booleanSupplier) {
        this.lIllIlIIIlIIIIIIIlllIlIll = name;
        this.value = this.IlllIIIIIIlllIlIIlllIlIIl = value;
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
            for (Consumer consumer : this.llllIIlIIlIIlIIllIIlIIllI) {
                consumer.accept(newValue);
            }
            if (Ref.llIIIIIIIllIIllIlIllIIIIl() != null) {
                //Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl(this);
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
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        if (this.value.equals(this.IlllIIIIIIlllIlIIlllIlIIl)) {
            return;
        }
        jsonObject.addProperty(this.lIllIlIIIlIIIIIIIlllIlIll, this.value.toString());
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        if (!jsonObject.has(this.lIllIlIIIlIIIIIIIlllIlIll) || jsonObject.get(this.lIllIlIIIlIIIIIIIlllIlIll).isJsonNull()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl);
            return;
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject.get(this.lIllIlIIIlIIIIIIIlllIlIll).getAsString());
    }

    public void d_() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl);
    }

    public abstract AbstractDescritiveSettingUIComponent lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent var1);

    @Override
    public String getLanguagePath() {
        return "settings";
    }

    public String f_() {
        return this.get(this.lIllIlIIIlIIIIIIIlllIlIll);
    }

    public T IllIllIIIllIIIlIlIlIIIIll() {
        return this.value;
    }

    public T IIlIllIlllllllIIlIIIllIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public String lIIlIlllIlIlIIIlllIIlIIII() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public BooleanSupplier llIllIlIllIlllIllIIIIllII() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(BooleanSupplier booleanSupplier) {
        this.llIlllIIIllllIIlllIllIIIl = booleanSupplier;
    }

}
