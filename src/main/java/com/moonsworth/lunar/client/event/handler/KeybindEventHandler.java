package com.moonsworth.lunar.client.event.handler;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.state.KeyState;
import com.moonsworth.lunar.client.event.type.input.KeyPressEvent;
import com.moonsworth.lunar.client.event.type.input.MouseActionEvent;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.AbstractFeatureSetting;
import it.unimi.dsi.fastutil.booleans.BooleanConsumer;

import java.util.ArrayList;
import java.util.List;

public class KeybindEventHandler
implements EventHandler {
    public static final List<AbstractFeatureSetting<?>> lIlIlIlIlIIlIIlIIllIIIIIl = new ArrayList();

    public KeybindEventHandler() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyPressEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(MouseActionEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractFeatureSetting abstractFeatureSetting) {
        lIlIlIlIlIIlIIlIIllIIIIIl.add(abstractFeatureSetting);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(MouseActionEvent mouseActionEvent) {
        if (mouseActionEvent.lIlIlIlIlIIlIIlIIllIIIIIl() < 0) {
            return;
        }
        for (AbstractFeatureSetting abstractFeatureSetting : lIlIlIlIlIIlIIlIIllIIIIIl) {
            KeyType keyType = KeyType.valueOf("KEY_MOUSE" + (mouseActionEvent.lIlIlIlIlIIlIIlIIllIIIIIl() + 1));
            this.lIlIlIlIlIIlIIlIIllIIIIIl(keyType, abstractFeatureSetting, mouseActionEvent.IlllIIIIIIlllIlIIlllIlIIl() == KeyState.DOWN);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(KeyPressEvent keyPressEvent) {
        for (AbstractFeatureSetting abstractFeatureSetting : lIlIlIlIlIIlIIlIIllIIIIIl) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl(), abstractFeatureSetting, keyPressEvent.IlllIIIIIIlllIlIIlllIlIIl() == KeyState.DOWN);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(KeyType keyType, AbstractFeatureSetting abstractFeatureSetting, boolean bl) {
        if (!abstractFeatureSetting.g_().equals((Object)keyType)) {
            return;
        }
        if (abstractFeatureSetting.lllIIIIIlllIIlIllIIlIIIlI() != null && !abstractFeatureSetting.lllIIIIIlllIIlIllIIlIIIlI().IlllIIIIIIlllIlIIlllIlIIl()) {
            return;
        }
        if (abstractFeatureSetting.lIIIllIllIIllIlllIlIIlllI() && Ref.llIIIlllIIlllIllllIlIllIl() != null) {
            return;
        }
        if (abstractFeatureSetting.IlllllIlIIIlIIlIIllIIlIll() && UIEventHandler.lIlIlIlIlIIlIIlIIllIIIIIl()) {
            return;
        }
        if (abstractFeatureSetting.IlllIIIIIIlllIlIIlllIlIIl() && abstractFeatureSetting.lIllIlIIIlIIIIIIIlllIlIll() && bl) {
            abstractFeatureSetting.lIlIlIlIlIIlIIlIIllIIIIIl(System.currentTimeMillis());
            abstractFeatureSetting.llIlllIIIllllIIlllIllIIIl(true);
            for (Object e : abstractFeatureSetting.lIlIIIIIIlIIIllllIllIIlII()) {
                if (!(e instanceof Runnable)) continue;
                ((Runnable)e).run();
            }
            return;
        }
        if (abstractFeatureSetting.llIIIlllIIlllIllllIlIllIl() && abstractFeatureSetting.lIllIlIIIlIIIIIIIlllIlIll() && !bl) {
            abstractFeatureSetting.llIlllIIIllllIIlllIllIIIl(false);
            if (System.currentTimeMillis() - abstractFeatureSetting.llIIlIlIIIllIlIlIlIIlIIll() <= (long)abstractFeatureSetting.lllllIllIllIllllIlIllllII()) {
                for (Object e : abstractFeatureSetting.llIlIIIllIIlIllIllIllllIl()) {
                    if (!(e instanceof BooleanConsumer)) continue;
                    ((BooleanConsumer)e).accept(true);
                }
                return;
            }
            for (Object e : abstractFeatureSetting.llIlIIIllIIlIllIllIllllIl()) {
                if (!(e instanceof BooleanConsumer)) continue;
                ((BooleanConsumer)e).accept(false);
            }
        }
    }
}