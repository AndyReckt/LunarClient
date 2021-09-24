package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.event.MouseEventCallback;
import com.moonsworth.lunar.client.util.StringValidator;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AutoTextUIComponent extends DefaultButtonUIComponent {
    public BooleanSupplier IlllIIIIIIlllIlIIlllIlIIl = () -> false;
    public Consumer<Boolean> lIllIlIIIlIIIIIIIlllIlIll = bl -> {};
    public BooleanSupplier llIlIIIllIIlIllIllIllllIl = () -> true;
    public Supplier<String> IllIllIIIllIIIlIlIlIIIIll = () -> "";
    public Consumer<String> IIlIllIlllllllIIlIIIllIIl = string -> {};
    public String lIIlIlllIlIlIIIlllIIlIIII = "/Command";
    public MouseEventCallback llIllIlIllIlllIllIIIIllII;

    public AutoTextUIComponent(UIComponent uIComponent, String string2) {
        super(uIComponent, string2, FontRegistry.IlIlIlllllIlIIlIlIlllIlIl, false);
        this.IlllIIIIIIlllIlIIlllIlIIl(true);
        this.IlllIIIIIIlllIlIIlllIlIIl((mouseX, mouseY, button) -> {
            if (this.llIlllIIIllllIIlllIllIIIl()) {
                this.lIllIlIIIlIIIIIIIlllIlIll.accept(!this.IlllIIIIIIlllIlIIlllIlIIl.getAsBoolean());
                Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.getAsBoolean());
                this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll.get(), true);
                this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.getAsBoolean());
            }
            return true;
        });
        this.onMouseClick((mouseX, mouseY, button) -> {
            if (this.mouseInside(mouseX, mouseY) && button == 1) {
                this.lIllIlIIIlIIIIIIIlllIlIll.accept(false);
                if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl()) {
                    Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.getAsBoolean());
                }
                this.IIlIllIlllllllIIlIIIllIIl.accept(this.lIIlIlllIlIlIIIlllIIlIIII);
                this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll.get(), true);
                this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.getAsBoolean());
                return true;
            }
            if (this.mouseInside(mouseX, mouseY) && this.llIlIIIllIIlIllIllIllllIl.getAsBoolean()) {
                this.lIllIlIIIlIIIIIIIlllIlIll.accept(!this.IlllIIIIIIlllIlIIlllIlIIl.getAsBoolean());
                Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.getAsBoolean());
                this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll.get(), true);
                this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.getAsBoolean());
                if (this.llIllIlIllIlllIllIIIIllII != null) {
                    this.llIllIlIllIlllIllIIIIllII.accept(mouseX, mouseY, button);
                }
                return true;
            }
            return false;
        });
    }

    @Override
    public void onUpdateScreen() {
        if (this.llIlllIIIllllIIlllIllIIIl() && !this.IlllIIIIIIlllIlIIlllIlIIl.getAsBoolean()) {
            Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
            this.lIlIlIlIlIIlIIlIIllIIIIIl(false);
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll.get(), true);
        super.onUpdateScreen();
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        if (this.IlllIIIIIIlllIlIIlllIlIIl.getAsBoolean()) {
            if (keyType == KeyType.KEY_ESCAPE || keyType == KeyType.KEY_RETURN) {
                Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
                this.lIllIlIIIlIIIIIIIlllIlIll.accept(false);
                this.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                return;
            }
            if (keyType == KeyType.KEY_BACK && this.IllIllIIIllIIIlIlIlIIIIll.get().length() > 0) {
                this.IIlIllIlllllllIIlIIIllIIl.accept(this.IllIllIIIllIIIlIlIlIIIIll.get().substring(0, this.IllIllIIIllIIIlIlIlIIIIll.get().length() - 1));
                return;
            }
            if (StringValidator.lIlIlIlIlIIlIIlIIllIIIIIl(c) && this.IllIllIIIllIIIlIlIlIIIIll.get().length() < 30) {
                this.IIlIllIlllllllIIlIIIllIIl.accept(this.IllIllIIIllIIIlIlIlIIIIll.get() + c);
            }
        }
    }

    public BooleanSupplier llIIIIIIIllIIllIlIllIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public Consumer lIIIllIllIIllIlllIlIIlllI() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public BooleanSupplier IlllllIlIIIlIIlIIllIIlIll() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public Supplier llIIlIlIIIllIlIlIlIIlIIll() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public Consumer lIIlIlllIlIlIIIlllIIlIIII() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public String llIllIlIllIlllIllIIIIllII() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public MouseEventCallback IllllllllllIlIIIlllIlllll() {
        return this.llIllIlIllIlllIllIIIIllII;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(BooleanSupplier booleanSupplier) {
        this.IlllIIIIIIlllIlIIlllIlIIl = booleanSupplier;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Consumer<Boolean> consumer) {
        this.lIllIlIIIlIIIIIIIlllIlIll = consumer;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(BooleanSupplier booleanSupplier) {
        this.llIlIIIllIIlIllIllIllllIl = booleanSupplier;
    }

    public void setSuppiler(Supplier<String> supplier) {
        this.IllIllIIIllIIIlIlIlIIIIll = supplier;
    }

    public void setConsumer(Consumer<String> consumer) {
        this.IIlIllIlllllllIIlIIIllIIl = consumer;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(String string) {
        this.lIIlIlllIlIlIIIlllIIlIIII = string;
    }

    public void llIlllIIIllllIIlllIllIIIl(MouseEventCallback mouseEventCallback) {
        this.llIllIlIllIlllIllIIIIllII = mouseEventCallback;
    }
}
