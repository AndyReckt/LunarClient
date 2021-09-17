package com.moonsworth.lunar.client.ui.screen.type.emotes;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.IIlIllIlIIllIIlIlIllllllI;
import com.moonsworth.lunar.client.ui.component.type.setting.llIllIlIllIlllIllIIIIllII;
import com.moonsworth.lunar.client.ui.component.type.setting.lllllIllIlIIlIIlIIIlllIlI;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EmotesUIScreen extends AbstractUIScreen {
    public final List lIlIlIlIlIIlIIlIIllIIIIIl = new ArrayList();
    public final List IlllIIIIIIlllIlIIlllIlIIl = new ArrayList();
    public List llIIIlllIIlllIllllIlIllIl = new CopyOnWriteArrayList();
    public List lllllIllIllIllllIlIllllII = new CopyOnWriteArrayList();
    public lllllIllIlIIlIIlIIIlllIlI lllIIIIIlllIIlIllIIlIIIlI;
    public llIllIlIllIlllIllIIIIllII lIlIIIIIIlIIIllllIllIIlII;
    public IIlIllIlIIllIIlIlIllllllI lIllIlIIIlIIIIIIIlllIlIll;
    public final GuiScreenBridge llIlIIIllIIlIllIllIllllIl;
    public MutablePair llIlllIIIllllIIlllIllIIIl = new MutablePair();

    public EmotesUIScreen() {
        this.llIlIIIllIIlIllIllIllllIl = Ref.llIIIlllIIlllIllllIlIllIl() == EmotesRadialMenuUIScreen.class ? null : Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen();
        Iterator iterator = Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIIIllIllIIllIlllIlIIlllI().iterator();
        while (iterator.hasNext()) {
            int n2 = (Integer)iterator.next();
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.contains(n2)) continue;
            this.lIlIlIlIlIIlIIlIIllIIIIIl.add(n2);
        }
        this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(this.llIlIIIllIIlIllIllIllllIl);
            return true;
        });
        this.lIlIIIIIIlIIIllllIllIIlII.lIllIlIIIlIIIIIIIlllIlIll(new ColorEase(0x20FFFFFF, 1358901296));
    }

    @Override
    public List llIIlIlIIIllIlIlIlIIlIIll() {
        this.lllIIIIIlllIIlIllIIlIIIlI = new lllllIllIlIIlIIlIIIlllIlI(null, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "searchPlaceholder", 0x20FFFFFF, 0x35FFFFFF);
        this.lIlIIIIIIlIIIllllIllIIlII = new llIllIlIllIlllIllIIIIllII(null, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/mainmenu/exit-17x17.png"));
        return ImmutableList.of(this.lllIIIIIlllIIlIllIIlIIIlI, this.lIlIIIIIIlIIIllllIllIIlII);
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        Object object;
        this.llIIIlllIIlllIllllIlIllIl.clear();
        this.lllllIllIllIllllIlIllllII.clear();
        this.IlllIIIIIIlllIlIIlllIlIIl.clear();
        this.IlllIIIIIIlllIlIIlllIlIIl.addAll(Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().llIIIIIIIllIIllIlIllIIIIl().stream().filter(n -> !this.lIlIlIlIlIIlIIlIIllIIIIIl.contains(n)).filter(n -> {
            AbstractEmote abstractEmote = Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((int)n);
            return abstractEmote != null && abstractEmote.llIlllIIIllllIIlllIllIIIl().toLowerCase().contains(this.lllIIIIIlllIIlIllIIlIIIlI.llllIIlIIlIIlIIllIIlIIllI().toLowerCase());
        }).sorted((n, n2) -> Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((int)n).llIlllIIIllllIIlllIllIIIl().compareToIgnoreCase(Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((int)n2).llIlllIIIllllIIlllIllIIIl())).collect(Collectors.toList()));
        this.lIllIlIIIlIIIIIIIlllIlIll = new IIlIllIlIIllIIlIlIllllllI(null);
        int n3 = 0;
        for (Object object2 : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            object = Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((Integer)object2);
            if (object == null) continue;
            Object object3 = new EmoteUIComponent(this, null, (AbstractEmote)object, n3++, true);
            this.llIIIlllIIlllIllllIlIllIl.add(object3);
            MutablePair mutablePair = this.lIlIlIlIlIIlIIlIIllIIIIIl((EmoteUIComponent)object3);
            ((UIComponent)object3).lIlIlIlIlIIlIIlIIllIIIIIl(((Float)mutablePair.getKey()).floatValue(), ((Float)mutablePair.getValue()).floatValue(), 40.0f, 40.0f);
        }
        n3 = 0;
        int n4 = 0;
        for (Object object3 : this.IlllIIIIIIlllIlIIlllIlIIl) {
            object = new EmoteUIComponent(this, null, Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((Integer)object3), n3, false);
            this.lllllIllIllIllllIlIllllII.add(object);
            ((UIComponent)object).lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0f - 90.0f - 65.0f + (float)(n3++ * 40), this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f + (float)(n4 * 40), 40.0f, 40.0f);
            if (n3 != 3) continue;
            n3 = 0;
            ++n4;
        }
        this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0f - 90.0f - 65.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f - 17.0f, 132.0f, 12.0f);
        this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl = this::llIIIlllIIlllIllllIlIllIl;
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0f - 29.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f, 6.0f, 120.0f);
        float f = 345.0f;
        float f2 = 175.0f;
        float f3 = this.IllllllllllIlIIIlllIlllll() / 2.0f - f / 2.0f;
        float f4 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - f2 / 2.0f;
        this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(f3 + f - 24.0f, f4 + 8.0f, 16.0f, 16.0f);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl("");
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f);
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        boolean bl;
        boolean bl2;
        float f3 = 345.0f;
        float f4 = 175.0f;
        float f5 = this.IllllllllllIlIIIlllIlllll() / 2.0f - f3 / 2.0f;
        float f6 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - f4 / 2.0f;
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f5 - 1.0f, f6, f3 + 2.0f, f4, 4.0f, 1612586526);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f5, f6 + 1.0f, f3, f4 - 2.0f, 3.25f, 1075715614);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(f5, f6 + 1.0f, f3, f4 - 2.0f, 5.0f, -1306912744);
        String string = this.get("available", new Object[0]);
        FontRegistry.llIIIlllIIlllIllllIlIllIl().IlllIIIIIIlllIlIIlllIlIIl(string, this.IllllllllllIlIIIlllIlllll() / 2.0f - 90.0f - 65.0f + 60.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + 68.0f, 0x40FFFFFF);
        string = this.get("equipped", new Object[0]);
        FontRegistry.llIIIlllIIlllIllllIlIllIl().IlllIIIIIIlllIlIIlllIlIIl(string, this.IllllllllllIlIIIlllIlllll() / 2.0f + 78.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + 68.0f, 0x40FFFFFF);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.IllllllllllIlIIIlllIlllll() / 2.0f - 15.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f - 17.0f, 0.5f, 152.0f, 1088611042);
        this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2, true);
        this.lIllIlIIIlIIIIIIIlllIlIll.IlIlIlllllIlIIlIlIlllIlIl(this.IlllIIIIIIlllIlIIlllIlIIl.size() / 3 * 40);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable((int)3089);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)this.IllllllllllIlIIIlllIlllll() / 2 - 90 - 66, (int)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f) - 1, (int)this.IllllllllllIlIIIlllIlllll() / 2 - 90 + 90, (int)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f + this.lIllIlIIIlIIIIIIIlllIlIll.IllIllIIIllIIIlIlIlIIIIll() + 3.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.lllllIllIlIIlIIlIIIlllIlI());
        boolean bl3 = EmotesUIScreen.IlllIIIIIIlllIlIIlllIlIIl((int)f, (int)f2, (int)this.IllllllllllIlIIIlllIlllll() / 2 - 105 - 45, (int)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f) - 1, (int)this.IllllllllllIlIIIlllIlllll() / 2 - 90 + 90, (int)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f + this.lIllIlIIIlIIIIIIIlllIlIll.IllIllIIIllIIIlIlIlIIIIll() + 1.0f));
        for (EmoteUIComponent emoteUIComponent : this.lllllIllIllIllllIlIllllII) {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.contains(emoteUIComponent.llIlllIIIllllIIlllIllIIIl())) continue;
            bl2 = emoteUIComponent.lIlIIIIIIlIIIllllIllIIlII() + emoteUIComponent.IllIllIIIllIIIlIlIlIIIIll() + this.lIllIlIIIlIIIIIIIlllIlIll.lIllIlIIIlIIIIIIIlllIlIll() < this.lIllIlIIIlIIIIIIIlllIlIll.lIlIIIIIIlIIIllllIllIIlII() + 3.0f;
            boolean bl4 = bl = emoteUIComponent.lIlIIIIIIlIIIllllIllIIlII() + this.lIllIlIIIlIIIIIIIlllIlIll.lIllIlIIIlIIIIIIIlllIlIll() > this.lIllIlIIIlIIIIIIIlllIlIll.lIlIIIIIIlIIIllllIllIIlII() + this.lIllIlIIIlIIIIIIIlllIlIll.IllIllIIIllIIIlIlIlIIIIll() - 3.0f;
            if (bl2 || bl) continue;
            emoteUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.lIllIlIIIlIIIIIIIlllIlIll.lIllIlIIIlIIIIIIIlllIlIll(), bl3 && !this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2));
        }
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, true);
        GL11.glDisable((int)3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI(f, f2, true);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        for (EmoteUIComponent emoteUIComponent : this.llIIIlllIIlllIllllIlIllIl) {
            emoteUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, true);
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        for (EmoteUIComponent emoteUIComponent : this.llIIIlllIIlllIllllIlIllIl) {
            if (!emoteUIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) continue;
            EmotesUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of(this.get("unequipEmote", emoteUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl())), (int)f, (int)f2);
        }
        if (bl3) {
            for (EmoteUIComponent emoteUIComponent : this.lllllIllIllIllllIlIllllII) {
                bl2 = emoteUIComponent.lIlIIIIIIlIIIllllIllIIlII() + emoteUIComponent.IllIllIIIllIIIlIlIlIIIIll() + this.lIllIlIIIlIIIIIIIlllIlIll.lIllIlIIIlIIIIIIIlllIlIll() < this.lIllIlIIIlIIIIIIIlllIlIll.lIlIIIIIIlIIIllllIllIIlII() + 3.0f;
                boolean bl5 = bl = emoteUIComponent.lIlIIIIIIlIIIllllIllIIlII() + this.lIllIlIIIlIIIIIIIlllIlIll.lIllIlIIIlIIIIIIIlllIlIll() > this.lIllIlIIIlIIIIIIIlllIlIll.lIlIIIIIIlIIIllllIllIIlII() + this.lIllIlIIIlIIIIIIIlllIlIll.IllIllIIIllIIIlIlIlIIIIll() - 3.0f;
                if (bl2 || bl || !emoteUIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.lIllIlIIIlIIIIIIIlllIlIll.lIllIlIIIlIIIIIIIlllIlIll())) continue;
                EmotesUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of(this.get("equipEmote", emoteUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl())), (int)f, (int)f2);
            }
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl(f, f2));
    }

    public MutablePair lIlIlIlIlIIlIIlIIllIIIIIl(EmoteUIComponent emoteUIComponent) {
        this.llIlllIIIllllIIlllIllIIIl.setLeft(Float.valueOf(this.IllllllllllIlIIIlllIlllll() / 2.0f + (float)(emoteUIComponent.llllIIlIIlIIlIIllIIlIIllI() % 4 * 40) - 5.0f));
        this.llIlllIIIllllIIlllIllIIIl.setRight(Float.valueOf(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + (float)(emoteUIComponent.llllIIlIIlIIlIIllIIlIIllI() < 4 ? -40 : 0)));
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n)) {
            return;
        }
        if (this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        }
        boolean bl = EmotesUIScreen.IlllIIIIIIlllIlIIlllIlIIl((int)f, (int)f2, (int)this.IllllllllllIlIIIlllIlllll() / 2 - 105 - 45, (int)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f) - 1, (int)this.IllllllllllIlIIIlllIlllll() / 2 - 90 + 90, (int)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f + this.lIllIlIIIlIIIIIIIlllIlIll.IllIllIIIllIIIlIlIlIIIIll() + 1.0f));
        for (EmoteUIComponent emoteUIComponent : this.llIIIlllIIlllIllllIlIllIl) {
            if (!emoteUIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2) || !emoteUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n)) continue;
            return;
        }
        if (bl) {
            for (EmoteUIComponent emoteUIComponent : this.lllllIllIllIllllIlIllllII) {
                if (!emoteUIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.lIllIlIIIlIIIIIIIlllIlIll.lIllIlIIIlIIIIIIIlllIlIll()) || !emoteUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n)) continue;
                return;
            }
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
        this.lIllIlIIIlIIIIIIIlllIlIll.lIllIlIIIlIIIIIIIlllIlIll(f, f2, n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(char c, KeyType keyType) {
    }

    @Override
    public void lIlIIIIIIlIIIllllIllIIlII() {
        Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().IlllIIIIIIlllIlIIlllIlIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl);
        Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().IlIlIlllllIlIIlIlIlllIlIl();
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    @Override
    public String getLanguagePath() {
        return super.getLanguagePath() + ".emotes";
    }
}
 