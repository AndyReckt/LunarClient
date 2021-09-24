package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.google.common.collect.Iterables;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDraggableUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.ScrollbarUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.SmallIconUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.TextboxWithIcon;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;
import com.moonsworth.lunar.client.websocket.ConsoleLine;
import com.moonsworth.lunar.client.websocket.packet.WSPacketConsole;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class ConsoleUIComponent extends AbstractDraggableUIComponent {
    public static float lIlIlIlIlIIlIIlIIllIIIIIl = 500.0f;
    public llIIlIlIIIllIlIlIlIIlIIll sendButton;
    public TextboxWithIcon lIllIlIIIlIIIIIIIlllIlIll;
    public SmallIconUIComponent IIlIllIlllllllIIlIIIllIIl;
    public ScrollbarUIComponent lIIlIlllIlIlIIIlllIIlIIII;
    public FriendsUIScreen friendsScreen;
    public static List<String> IllllllllllIlIIIlllIlllll = new ArrayList();
    public int asasas = Integer.MAX_VALUE;
    public static final ResourceLocationBridge IllIIIlllIIIlIlllIlIIlIII = Bridge.getInstance().initResourceLocation("lunar", "icons/console.png");

    public ConsoleUIComponent(FriendsUIScreen friendsUIScreen) {
        super(null);
        this.friendsScreen = friendsUIScreen;
        this.lIIlIlllIlIlIIIlllIIlIIII = new ScrollbarUIComponent(this);
        this.sendButton = new llIIlIlIIIllIlIlIlIIlIIll(this, "SEND");
        this.IIlIllIlllllllIIlIIIllIIl = new SmallIconUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/exit-17x17-small.png"));
        this.lIllIlIIIlIIIIIIIlllIlIll = new TextboxWithIcon(this, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "commandPlaceholder", 0x20FFFFFF, 0x40FFFFFF);
        this.sendButton.onMouseClick((float f, float f2, int n) -> {
            if (this.lIllIlIIIlIIIIIIIlllIlIll.getText().length() > 0) {
                if (this.lIllIlIIIlIIIIIIIlllIlIll.getText().equals("cls") || this.lIllIlIIIlIIIIIIIlllIlIll.getText().equals("clear")) {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.getText(), false);
                    LunarClient.getInstance().IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl().clear();
                    this.lIllIlIIIlIIIIIIIlllIlIll.setText("");
                } else {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.getText(), true);
                    this.lIllIlIIIlIIIIIIIlllIlIll.setText("");
                }
                return true;
            }
            return false;
        });
        this.IIlIllIlllllllIIlIIIllIIl.onMouseClick((float f, float f2, int n) -> {
            if (friendsUIScreen.IllIllIIIllIIIlIlIlIIIIll() != null) {
                friendsUIScreen.lllIIIIIlllIIlIllIIlIIIlI();
                return true;
            }
            return false;
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string, boolean bl) {
        if (bl) {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketConsole(string));
            LunarClient.getInstance().IllIllIIIllIIIlIlIlIIIIll().addLine(EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "> " + this.lIllIlIIIlIIIIIIIlllIlIll.getText());
        }
        if (IllllllllllIlIIIlllIlllll.isEmpty() || !Iterables.getLast(IllllllllllIlIIIlllIlllll).equals(string)) {
            IllllllllllIlIIIlllIlllll.add(string);
            if (IllllllllllIlIIIlllIlllll.size() > 120) {
                IllllllllllIlIIIlllIlllll.remove(0);
            }
        }
    }

    @Override
    public void onUpdateScreen() {
        this.lIllIlIIIlIIIIIIIlllIlIll.onUpdateScreen();
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll.isTyping()) {
            if (this.lIllIlIIIlIIIIIIIlllIlIll.getText().length() > 0 && keyType == KeyType.KEY_RETURN) {
                if (this.lIllIlIIIlIIIIIIIlllIlIll.getText().equals("cls") || this.lIllIlIIIlIIIIIIIlllIlIll.getText().equals("clear")) {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.getText(), false);
                    LunarClient.getInstance().IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl().clear();
                    this.lIllIlIIIlIIIIIIIlllIlIll.setText("");
                } else {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.getText(), true);
                    this.lIllIlIIIlIIIIIIIlllIlIll.setText("");
                }
            } else {
                if (!IllllllllllIlIIIlllIlllll.isEmpty()) {
                    if (keyType == KeyType.KEY_UP) {
                        if (this.asasas == Integer.MAX_VALUE) {
                            this.asasas = IllllllllllIlIIIlllIlllll.size() - 1;
                            this.lIllIlIIIlIIIIIIIlllIlIll.setText(IllllllllllIlIIIlllIlllll.get(this.asasas));
                        } else {
                            --this.asasas;
                            if (this.asasas < 0) {
                                this.asasas = 0;
                            }
                            this.lIllIlIIIlIIIIIIIlllIlIll.setText(IllllllllllIlIIIlllIlllll.get(this.asasas));
                        }
                        return;
                    }
                    if (keyType == KeyType.KEY_DOWN && this.asasas != Integer.MAX_VALUE) {
                        ++this.asasas;
                        if (this.asasas == IllllllllllIlIIIlllIlllll.size()) {
                            this.asasas = Integer.MAX_VALUE;
                            this.lIllIlIIIlIIIIIIIlllIlIll.setText("");
                        } else {
                            this.lIllIlIIIlIIIIIIIlllIlIll.setText(IllllllllllIlIIIlllIlllll.get(this.asasas));
                        }
                        return;
                    }
                }
                this.lIllIlIIIlIIIIIIIlllIlIll.onKeyTyped(c, keyType);
            }
        }
    }

    @Override
    public boolean onMouseClicked(float mouseX, float mouseY, int mouseButton) {
        boolean bl;
        if (this.sendButton.mouseInside(mouseX, mouseY)) {
            this.sendButton.onMouseClicked(mouseX, mouseY, mouseButton);
        }
        if (this.lIllIlIIIlIIIIIIIlllIlIll.mouseInside(mouseX, mouseY)) {
            this.lIllIlIIIlIIIIIIIlllIlIll.onMouseClicked(mouseX, mouseY, mouseButton);
        }
        if (this.lIIlIlllIlIlIIIlllIIlIIII.mouseInside(mouseX, mouseY)) {
            this.lIIlIlllIlIlIIIlllIIlIIII.onMouseClicked(mouseX, mouseY, mouseButton);
        }
        if (this.IIlIllIlllllllIIlIIIllIIl.mouseInside(mouseX, mouseY)) {
            this.IIlIllIlllllllIIlIIIllIIl.onMouseClicked(mouseX, mouseY, mouseButton);
        }
        boolean bl2 = mouseX > this.x && mouseX < this.x + 24.0f && mouseY > this.y + 4.0f && mouseY < this.y + this.height - 4.0f;
        boolean bl3 = bl = !bl2 && !this.lIIlIlllIlIlIIIlllIIlIIII.mouseInside(mouseX, mouseY) && !this.lIIlIlllIlIlIIIlllIIlIIII.lIIIllIllIIllIlllIlIIlllI() && !this.sendButton.mouseInside(mouseX, mouseY) && !this.lIllIlIIIlIIIIIIIlllIlIll.mouseInside(mouseX, mouseY) && this.mouseInside(mouseX, mouseY);
        if (bl) {
            this.lIllIlIIIlIIIIIIIlllIlIll(mouseX, mouseY);
        }
        return this.onMouseClick != null && this.onMouseClick.accept(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl(float mouseX, float mouseY, int mouseButton) {
        this.sendButton.IlllIIIIIIlllIlIIlllIlIIl(mouseX, mouseY, mouseButton);
        this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(mouseX, mouseY, mouseButton);
        return this.llIIlIlIIIllIlIlIlIIlIIll != null && this.llIIlIlIIIllIlIlIlIIlIIll.accept(mouseX, mouseY, mouseButton);
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        this.lIllIlIIIlIIIIIIIlllIlIll.setPositionAndSize(x + 4.0f, y + height - 18.0f, width - 40.0f, 13.0f);
        this.sendButton.setPositionAndSize(x + width - 32.0f, y + height - 18.0f, 26.0f, 13.0f);
        this.IIlIllIlllllllIIlIIIllIIl.setPositionAndSize(x + width - 20.0f, y + 4.0f, 16.0f, 16.0f);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        super.handleMouseScrollDelta(n);
        this.lIIlIlllIlIlIIIlllIIlIIII.handleMouseScrollDelta(n);
    }

    @Override
    public void onGuiClosed() {
        this.lIllIlIIIlIIIIIIIlllIlIll.setTyping(false);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(mouseX, mouseY);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 24.0f, this.width, 0.5f, 0x20FFFFFF);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + this.height - 23.0f, this.width, 0.5f, 0x20FFFFFF);
        AbstractUIScreen.llIIIIIIIllIIllIlIllIIIIl(this.x, this.y + this.height - 22.5f, this.width, 21.5f, 5.0f, 0x45000000);
        AbstractUIScreen.llllIIlIIlIIlIIllIIlIIllI(this.x, this.y + 1.0f, this.width, 23.0f, 5.0f, 0x25000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x - 1.0f, this.y, this.width + 2.0f, this.height, 4.0f, 0x40000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 3.0f, 0x20FFFFFF);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 5.0f, Integer.MIN_VALUE);
        this.sendButton.drawComponent(mouseX, mouseY, bl);
        this.lIllIlIIIlIIIIIIIlllIlIll.drawComponent(mouseX, mouseY, bl);
        this.IIlIllIlllllllIIlIIIllIIl.drawComponent(mouseX, mouseY, bl);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.6862745f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(IllIIIlllIIIlIlllIlIIlIII, 6.0f, this.x + 6.0f, this.y + 6.0f);
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl("Admin Console", this.x + 25.0f, this.y + 7.0f, -1342177281);
        float f3 = this.y + this.height - 35.0f;
        float f4 = 8.5f;
        LCFontRenderer lCFontRenderer = FontRegistry.llIIlIlIIIllIlIlIlIIlIIll();
        boolean bl2 = bl && mouseX > this.x + 26.0f && mouseX < this.x + this.x + this.width - 2.0f && mouseY > this.y + 26.0f && mouseY < this.y + this.height - 24.0f;
        this.lIIlIlllIlIlIIIlllIIlIIII.setPositionAndSize(this.x + this.width - 5.0f, this.y + 26.0f, 3.0f, this.height - 50.0f);
        this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl(mouseX, mouseY, bl2);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable(3089);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x + 4.0f), (int)(this.y + 26.0f), (int)(this.x + this.width - 2.0f), (int)(this.y + this.height - 24.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.friendsScreen.lllllIllIlIIlIIlIIIlllIlI());
        int n = 0;
        try {
            for (int i = this.lc.IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl().size() - 1; i >= 0; --i) {
                ConsoleLine consoleLine2 = (ConsoleLine)this.lc.IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl().toArray()[i];
                for (int j = consoleLine2.lIllIlIIIlIIIIIIIlllIlIll().size() - 1; j >= 0; --j) {
                    String string = (String) consoleLine2.lIllIlIIIlIIIIIIIlllIlIll().get(j);
                    lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(string, this.x + 6.0f, f3 - (float)n * f4, -4671304);
                    ++n;
                }
            }
        } catch (Exception exception) {
            // empty catch block
        }
        GL11.glDisable(3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        this.lIIlIlllIlIlIIIlllIIlIIII.setContentHeight((float)n * f4 + 4.0f);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll(mouseX, mouseY, bl2);
    }
}
