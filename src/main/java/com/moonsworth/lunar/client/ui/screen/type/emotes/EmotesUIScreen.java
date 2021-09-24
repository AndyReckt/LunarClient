package com.moonsworth.lunar.client.ui.screen.type.emotes;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.emote.AbstractEmote;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.ScrollbarUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.SmallIconUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.TextboxWithIcon;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import org.apache.commons.lang3.tuple.MutablePair;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class EmotesUIScreen extends AbstractUIScreen {
    public final List<Integer> lIlIlIlIlIIlIIlIIllIIIIIl = new ArrayList<>();
    public final List<Integer> IlllIIIIIIlllIlIIlllIlIIl = new ArrayList<>();
    public List<EmoteUIComponent> llIIIlllIIlllIllllIlIllIl = new CopyOnWriteArrayList<>();
    public List<EmoteUIComponent> lllllIllIllIllllIlIllllII = new CopyOnWriteArrayList<>();
    public TextboxWithIcon lllIIIIIlllIIlIllIIlIIIlI;
    public SmallIconUIComponent lIlIIIIIIlIIIllllIllIIlII;
    public ScrollbarUIComponent lIllIlIIIlIIIIIIIlllIlIll;
    public final GuiScreenBridge llIlIIIllIIlIllIllIllllIl;
    public MutablePair<Float, Float> llIlllIIIllllIIlllIllIIIl = new MutablePair<>();

    public EmotesUIScreen() {
        this.llIlIIIllIIlIllIllIllllIl = Ref.llIIIlllIIlllIllllIlIllIl() == EmotesRadialMenuUIScreen.class ? null : Ref.getMinecraft().bridge$getCurrentScreen();
        for (int n2 : Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIIIllIllIIllIlllIlIIlllI()) {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.contains(n2)) continue;
            this.lIlIlIlIlIIlIIlIIllIIIIIl.add(n2);
        }
        this.lIlIIIIIIlIIIllllIllIIlII.onMouseClick((float f, float f2, int n) -> {
            Ref.getMinecraft().bridge$displayScreen(this.llIlIIIllIIlIllIllIllllIl);
            return true;
        });
        this.lIlIIIIIIlIIIllllIllIIlII.lIllIlIIIlIIIIIIIlllIlIll(new ColorEase(0x20FFFFFF, 1358901296));
    }

    @Override
    public List<UIComponent> llIIlIlIIIllIlIlIlIIlIIll() {
        this.lllIIIIIlllIIlIllIIlIIIlI = new TextboxWithIcon(null, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "searchPlaceholder", 0x20FFFFFF, 0x35FFFFFF);
        this.lIlIIIIIIlIIIllllIllIIlII = new SmallIconUIComponent(null, Bridge.getInstance().initResourceLocation("lunar", "icons/mainmenu/exit-17x17.png"));
        return ImmutableList.of(this.lllIIIIIlllIIlIllIIlIIIlI, this.lIlIIIIIIlIIIllllIllIIlII);
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        Object object;
        this.llIIIlllIIlllIllllIlIllIl.clear();
        this.lllllIllIllIllllIlIllllII.clear();
        this.IlllIIIIIIlllIlIIlllIlIIl.clear();
        this.IlllIIIIIIlllIlIIlllIlIIl.addAll(Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().llIIIIIIIllIIllIlIllIIIIl().stream().filter(n -> !this.lIlIlIlIlIIlIIlIIllIIIIIl.contains(n)).filter(n -> {
            AbstractEmote abstractEmote = Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(n);
            return abstractEmote != null && abstractEmote.llIlllIIIllllIIlllIllIIIl().toLowerCase().contains(this.lllIIIIIlllIIlIllIIlIIIlI.getText().toLowerCase());
        }).sorted((n, n2) -> Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(n).llIlllIIIllllIIlllIllIIIl().compareToIgnoreCase(Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(n2).llIlllIIIllllIIlllIllIIIl())).collect(Collectors.toList()));
        this.lIllIlIIIlIIIIIIIlllIlIll = new ScrollbarUIComponent(null);
        int n3 = 0;
        for (Object object2 : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            object = Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((Integer)object2);
            if (object == null) continue;
            EmoteUIComponent object3 = new EmoteUIComponent(this, null, (AbstractEmote)object, n3++, true);
            this.llIIIlllIIlllIllllIlIllIl.add(object3);
            MutablePair<Float, Float> mutablePair = this.lIlIlIlIlIIlIIlIIllIIIIIl(object3);
            object3.setPositionAndSize(((Float)mutablePair.getKey()).floatValue(), ((Float)mutablePair.getValue()).floatValue(), 40.0f, 40.0f);
        }
        n3 = 0;
        int n4 = 0;
        for (Integer object3 : this.IlllIIIIIIlllIlIIlllIlIIl) {
            EmoteUIComponent emoteUIComponent = new EmoteUIComponent(this, null, Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(object3), n3, false);
            this.lllllIllIllIllllIlIllllII.add(emoteUIComponent);
            emoteUIComponent.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() / 2.0f - 90.0f - 65.0f + (float)(n3++ * 40), this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f + (float)(n4 * 40), 40.0f, 40.0f);
            if (n3 != 3) continue;
            n3 = 0;
            ++n4;
        }
        this.lllIIIIIlllIIlIllIIlIIIlI.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() / 2.0f - 90.0f - 65.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f - 17.0f, 132.0f, 12.0f);
        this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl = this::llIIIlllIIlllIllllIlIllIl;
        this.lIllIlIIIlIIIIIIIlllIlIll.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() / 2.0f - 29.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f, 6.0f, 120.0f);
        float f = 345.0f;
        float f2 = 175.0f;
        float f3 = this.IllllllllllIlIIIlllIlllll() / 2.0f - f / 2.0f;
        float f4 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - f2 / 2.0f;
        this.lIlIIIIIIlIIIllllIllIIlII.setPositionAndSize(f3 + f - 24.0f, f4 + 8.0f, 16.0f, 16.0f);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.lllIIIIIlllIIlIllIIlIIIlI.setText("");
        this.lIllIlIIIlIIIIIIIlllIlIll.setYOffset(f);
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
        this.lIllIlIIIlIIIIIIIlllIlIll.onUpdateScreen();
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
        String string = this.get("available");
        FontRegistry.llIIIlllIIlllIllllIlIllIl().IlllIIIIIIlllIlIIlllIlIIl(string, this.IllllllllllIlIIIlllIlllll() / 2.0f - 90.0f - 65.0f + 60.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + 68.0f, 0x40FFFFFF);
        string = this.get("equipped");
        FontRegistry.llIIIlllIIlllIllllIlIllIl().IlllIIIIIIlllIlIIlllIlIIl(string, this.IllllllllllIlIIIlllIlllll() / 2.0f + 78.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + 68.0f, 0x40FFFFFF);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.IllllllllllIlIIIlllIlllll() / 2.0f - 15.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f - 17.0f, 0.5f, 152.0f, 1088611042);
        this.lIllIlIIIlIIIIIIIlllIlIll.onDraw(f, f2, true);
        this.lIllIlIIIlIIIIIIIlllIlIll.setContentHeight(this.IlllIIIIIIlllIlIIlllIlIIl.size() / 3 * 40);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable(3089);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)this.IllllllllllIlIIIlllIlllll() / 2 - 90 - 66, (int)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f) - 1, (int)this.IllllllllllIlIIIlllIlllll() / 2 - 90 + 90, (int)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f + this.lIllIlIIIlIIIIIIIlllIlIll.getHeight() + 3.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.lllllIllIlIIlIIlIIIlllIlI());
        boolean bl3 = EmotesUIScreen.IlllIIIIIIlllIlIIlllIlIIl((int)f, (int)f2, (int)this.IllllllllllIlIIIlllIlllll() / 2 - 105 - 45, (int)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f) - 1, (int)this.IllllllllllIlIIIlllIlllll() / 2 - 90 + 90, (int)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f + this.lIllIlIIIlIIIIIIIlllIlIll.getHeight() + 1.0f));
        for (EmoteUIComponent emoteUIComponent : this.lllllIllIllIllllIlIllllII) {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.contains(emoteUIComponent.llIlllIIIllllIIlllIllIIIl())) continue;
            bl2 = emoteUIComponent.getY() + emoteUIComponent.getHeight() + this.lIllIlIIIlIIIIIIIlllIlIll.getYOffset() < this.lIllIlIIIlIIIIIIIlllIlIll.getY() + 3.0f;
            boolean bl4 = bl = emoteUIComponent.getY() + this.lIllIlIIIlIIIIIIIlllIlIll.getYOffset() > this.lIllIlIIIlIIIIIIIlllIlIll.getY() + this.lIllIlIIIlIIIIIIIlllIlIll.getHeight() - 3.0f;
            if (bl2 || bl) continue;
            emoteUIComponent.drawComponent(f, f2 - this.lIllIlIIIlIIIIIIIlllIlIll.getYOffset(), bl3 && !this.lIllIlIIIlIIIIIIIlllIlIll.mouseInside(f, f2));
        }
        this.lIllIlIIIlIIIIIIIlllIlIll.drawComponent(f, f2, true);
        GL11.glDisable(3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI(f, f2, true);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        for (EmoteUIComponent emoteUIComponent : this.llIIIlllIIlllIllllIlIllIl) {
            emoteUIComponent.drawComponent(f, f2, true);
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        for (EmoteUIComponent emoteUIComponent : this.llIIIlllIIlllIllllIlIllIl) {
            if (!emoteUIComponent.mouseInside(f, f2)) continue;
            EmotesUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of(this.get("unequipEmote", emoteUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl())), (int)f, (int)f2);
        }
        if (bl3) {
            for (EmoteUIComponent emoteUIComponent : this.lllllIllIllIllllIlIllllII) {
                bl2 = emoteUIComponent.getY() + emoteUIComponent.getHeight() + this.lIllIlIIIlIIIIIIIlllIlIll.getYOffset() < this.lIllIlIIIlIIIIIIIlllIlIll.getY() + 3.0f;
                boolean bl5 = bl = emoteUIComponent.getY() + this.lIllIlIIIlIIIIIIIlllIlIll.getYOffset() > this.lIllIlIIIlIIIIIIIlllIlIll.getY() + this.lIllIlIIIlIIIIIIIlllIlIll.getHeight() - 3.0f;
                if (bl2 || bl || !emoteUIComponent.mouseInside(f, f2 - this.lIllIlIIIlIIIIIIIlllIlIll.getYOffset())) continue;
                EmotesUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of(this.get("equipEmote", emoteUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl())), (int)f, (int)f2);
            }
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        this.lIlIIIIIIlIIIllllIllIIlII.drawComponent(f, f2, this.lIlIIIIIIlIIIllllIllIIlII.mouseInside(f, f2));
    }

    public MutablePair<Float, Float> lIlIlIlIlIIlIIlIIllIIIIIl(EmoteUIComponent emoteUIComponent) {
        this.llIlllIIIllllIIlllIllIIIl.setLeft(this.IllllllllllIlIIIlllIlllll() / 2.0f + (float) (emoteUIComponent.llllIIlIIlIIlIIllIIlIIllI() % 4 * 40) - 5.0f);
        this.llIlllIIIllllIIlllIllIIIl.setRight(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + (float) (emoteUIComponent.llllIIlIIlIIlIIllIIlIIllI() < 4 ? -40 : 0));
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll.mouseInside(f, f2) && this.lIllIlIIIlIIIIIIIlllIlIll.onMouseClicked(f, f2, n)) {
            return;
        }
        if (this.lIlIIIIIIlIIIllllIllIIlII.mouseInside(f, f2)) {
            this.lIlIIIIIIlIIIllllIllIIlII.onMouseClicked(f, f2, n);
        }
        boolean bl = EmotesUIScreen.IlllIIIIIIlllIlIIlllIlIIl((int)f, (int)f2, (int)this.IllllllllllIlIIIlllIlllll() / 2 - 105 - 45, (int)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f) - 1, (int)this.IllllllllllIlIIIlllIlllll() / 2 - 90 + 90, (int)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f + this.lIllIlIIIlIIIIIIIlllIlIll.getHeight() + 1.0f));
        for (EmoteUIComponent emoteUIComponent : this.llIIIlllIIlllIllllIlIllIl) {
            if (!emoteUIComponent.mouseInside(f, f2) || !emoteUIComponent.onMouseClicked(f, f2, n)) continue;
            return;
        }
        if (bl) {
            for (EmoteUIComponent emoteUIComponent : this.lllllIllIllIllllIlIllllII) {
                if (!emoteUIComponent.mouseInside(f, f2 - this.lIllIlIIIlIIIIIIIlllIlIll.getYOffset()) || !emoteUIComponent.onMouseClicked(f, f2, n)) continue;
                return;
            }
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
        this.lIllIlIIIlIIIIIIIlllIlIll.onMouseReleased(f, f2, n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.lIllIlIIIlIIIIIIIlllIlIll.handleMouseScrollDelta(n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(char c, KeyType keyType) {
    }

    @Override
    public void lIlIIIIIIlIIIllllIllIIlII() {
        Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().IlllIIIIIIlllIlIIlllIlIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl);
        Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().IlIlIlllllIlIIlIlIlllIlIl();
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    @Override
    public String getLanguagePath() {
        return super.getLanguagePath() + ".emotes";
    }
}
