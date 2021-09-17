package com.moonsworth.lunar.client.setting;

import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.NumberSettingUIComponent;

import java.util.function.BooleanSupplier;

/**
 * @author Decencies
 * @since 10/07/2021 18:00
 */
public class NumberSetting extends AbstractSetting<Number> {
    public final Number lIlIlIlIlIIlIIlIIllIIIIIl;
    public final Number IlllIIIIIIlllIlIIlllIlIIl;
    public final int lIllIlIIIlIIIIIIIlllIlIll;

    public NumberSetting(String string, Number number, Number number2, Number number3) {
        this(string, number, number2, number3, 0);
    }

    public NumberSetting(String string, Number number, Number number2, Number number3, int n) {
        this(string, number, number2, number3, n, () -> false);
    }

    public NumberSetting(String string, Number number, Number number2, Number number3, int n, BooleanSupplier booleanSupplier) {
        super(string + "_nr", number, booleanSupplier);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = number2;
        this.IlllIIIIIIlllIlIIlllIlIIl = number3;
        this.lIllIlIIIlIIIIIIIlllIlIll = n;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.setValueFrom(this.IlllIIIIIIlllIlIIlllIlIIl(Double.parseDouble(string)));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Double d) {
        this.setValueFrom(this.IlllIIIIIIlllIlIIlllIlIIl(d));
    }

    public void setValueFrom(Number number) {
        int n = ((Comparable) number).compareTo(this.lIlIlIlIlIIlIIlIIllIIIIIl);
        int n2 = ((Comparable) number).compareTo(this.IlllIIIIIIlllIlIIlllIlIIl);
        if (n >= 0 && n2 <= 0) {
            if (this.lIllIlIIIlIIIIIIIlllIlIll != 0 && number instanceof Float) {
                String string = String.valueOf((float)Math.round(number.floatValue() * (float)this.lIllIlIIIlIIIIIIIlllIlIll) / (float)this.lIllIlIIIlIIIIIIIlllIlIll);
                float f = this.IlllIIIIIIlllIlIIlllIlIIl(Double.parseDouble(string)).floatValue();
                if (!number.toString().equals(string)) {
                    super.lIlIlIlIlIIlIIlIIllIIIIIl(Float.valueOf(f));
                } else {
                    super.lIlIlIlIlIIlIIlIIllIIIIIl(number);
                }
            } else {
                super.lIlIlIlIlIIlIIlIIllIIIIIl(number);
            }
        }
    }

    public Number IlllIIIIIIlllIlIIlllIlIIl(Double d) {
        Class<?> clazz = (this.IllIllIIIllIIIlIlIlIIIIll()).getClass();
        Number number = clazz == Integer.class ? (Number)d.intValue() : clazz == Float.class ? Float.valueOf(d.floatValue()) : clazz == Byte.class ? (Number)d.byteValue() : clazz == Long.class ? (Number)d.longValue() : clazz == Short.class ? (Number)d.shortValue() : (Number)d;
        return number;
    }

    @Override
    public AbstractDescritiveSettingUIComponent lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent) {
        return new NumberSettingUIComponent(this, uIComponent);
    }

    public Number lllllIllIllIllllIlIllllII() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public Number lllIIIIIlllIIlIllIIlIIIlI() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}
