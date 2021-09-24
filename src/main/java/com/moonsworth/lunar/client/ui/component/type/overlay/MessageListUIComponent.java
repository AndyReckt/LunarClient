package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractDraggableListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.ScrollbarUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.SmallIconUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.TextboxWithIcon;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.UIScreenCloseException;
import com.moonsworth.lunar.client.profile.FriendProfile;
import com.moonsworth.lunar.client.websocket.packet.WSPacketMessage;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MessageListUIComponent extends AbstractDraggableListUIComponent implements UIScreenCloseException {
    public llIIlIlIIIllIlIlIlIIlIIll sendButton;
    public SmallIconUIComponent exit;
    public TextboxWithIcon searchBox;
    public FriendProfile selectedFriend;
    public static float lIlIlIlIlIIlIIlIIllIIIIIl = 180.0f;
    public ScrollbarUIComponent lllllIllIlIIlIIlIIIlllIlI;
    public ScrollbarUIComponent IllIIIlllIIIlIlllIlIIlIII;
    public AbstractUIScreen IIlIllIlIIllIIlIlIllllllI;
    public long lIIIlllIIIIllllIlIIIlIIll;

    public MessageListUIComponent(AbstractUIScreen abstractUIScreen) {
        super(null);
        this.IIlIllIlIIllIIlIlIllllllI = abstractUIScreen;
        this.lllllIllIlIIlIIlIIIlllIlI = new ScrollbarUIComponent(this);
        this.IllIIIlllIIIlIlllIlIIlIII = new ScrollbarUIComponent(this);
        this.sendButton = new llIIlIlIIIllIlIlIlIIlIIll(this, "SEND");
        this.exit = new SmallIconUIComponent(null, Bridge.getInstance().initResourceLocation("lunar", "icons/exit-17x17-small.png"));
        this.searchBox = new TextboxWithIcon(this, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "sendPlaceholder", 0x20FFFFFF, 0x40FFFFFF);
        this.sendButton.onMouseClick((float f, float f2, int n) -> {
            if (System.currentTimeMillis() - this.lIIIlllIIIIllllIlIIIlIIll < TimeUnit.SECONDS.toMillis(2L)) {
                this.sendButton.setHoverOverride(false);
                return false;
            }
            if (this.selectedFriend != null && this.searchBox.getText().length() >= 1) {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketMessage(this.selectedFriend.lIllIlIIIlIIIIIIIlllIlIll().toString(), this.searchBox.getText()));
                LunarClient.getInstance().getPlayerHeadManager().lIlIlIlIlIIlIIlIIllIIIIIl(LunarClient.getInstance().llllIIlIIlIIlIIllIIlIIllI(), this.selectedFriend.lIllIlIIIlIIIIIIIlllIlIll(), this.searchBox.getText());
                this.searchBox.setText("");
                this.lIIIlllIIIIllllIlIIIlIIll = System.currentTimeMillis();
                return true;
            }
            return false;
        });
        this.exit.onMouseClick((float f, float f2, int n) -> {
            if (this.selectedFriend != null) {
                this.list.removeIf(uIComponent -> uIComponent instanceof FriendUIComponent && ((FriendUIComponent)uIComponent).lIllIlIIIlIIIIIIIlllIlIll() == this.selectedFriend);
                this.selectedFriend = null;
                for (UIComponent uIComponent2 : this.list) {
                    if (!(uIComponent2 instanceof FriendUIComponent)) continue;
                    this.selectedFriend = ((FriendUIComponent)uIComponent2).lIllIlIIIlIIIIIIIlllIlIll();
                    break;
                }
                if (this.selectedFriend == null) {
                    abstractUIScreen.llIIIlIllIIIIlIIIlIlIllIl().removeIf(uIComponent -> uIComponent == this);
                }
            }
            return true;
        });
    }

    @Override
    public void onUpdateScreen() {
        super.onUpdateScreen();
        this.searchBox.onUpdateScreen();
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        if (this.searchBox.isTyping() && keyType == KeyType.KEY_RETURN) {
            if (this.selectedFriend != null && this.searchBox.getText().length() >= 1) {
                if (System.currentTimeMillis() - this.lIIIlllIIIIllllIlIIIlIIll < TimeUnit.SECONDS.toMillis(2L)) {
                    this.sendButton.setHoverOverride(false);
                    return;
                }
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketMessage(this.selectedFriend.lIllIlIIIlIIIIIIIlllIlIll().toString(), this.searchBox.getText()));
                LunarClient.getInstance().getPlayerHeadManager().lIlIlIlIlIIlIIlIIllIIIIIl(LunarClient.getInstance().llllIIlIIlIIlIIllIIlIIllI(), this.selectedFriend.lIllIlIIIlIIIIIIIlllIlIll(), this.searchBox.getText());
                this.searchBox.setText("");
                this.lIIIlllIIIIllllIlIIIlIIll = System.currentTimeMillis();
            }
        } else {
            this.searchBox.onKeyTyped(c, keyType);
        }
        super.onKeyTyped(c, keyType);
    }

    @Override
    public boolean onMouseClicked(float mouseX, float mouseY, int mouseButton) {
        boolean bl;
        if (this.sendButton.mouseInside(mouseX, mouseY)) {
            this.sendButton.onMouseClicked(mouseX, mouseY, mouseButton);
        }
        if (this.exit.mouseInside(mouseX, mouseY)) {
            this.exit.onMouseClicked(mouseX, mouseY, mouseButton);
        }
        if (this.searchBox.mouseInside(mouseX, mouseY)) {
            this.searchBox.onMouseClicked(mouseX, mouseY, mouseButton);
        }
        if (this.lllllIllIlIIlIIlIIIlllIlI.mouseInside(mouseX, mouseY)) {
            this.lllllIllIlIIlIIlIIIlllIlI.onMouseClicked(mouseX, mouseY, mouseButton);
        }
        boolean bl2 = mouseX > this.x && mouseX < this.x + 24.0f && mouseY > this.y + 4.0f && mouseY < this.y + this.height - 4.0f;
        boolean bl3 = bl = !bl2 && !this.lllllIllIlIIlIIlIIIlllIlI.mouseInside(mouseX, mouseY) && !this.lllllIllIlIIlIIlIIIlllIlI.lIIIllIllIIllIlllIlIIlllI() && !this.sendButton.mouseInside(mouseX, mouseY) && !this.searchBox.mouseInside(mouseX, mouseY) && this.mouseInside(mouseX, mouseY);
        if (bl) {
            this.lIllIlIIIlIIIIIIIlllIlIll(mouseX, mouseY);
        }
        return this.onMouseClick != null && this.onMouseClick.accept(mouseX, mouseY - this.IllIIIlllIIIlIlllIlIIlIII.getYOffset(), mouseButton);
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl(float mouseX, float mouseY, int mouseButton) {
        this.sendButton.IlllIIIIIIlllIlIIlllIlIIl(mouseX, mouseY, mouseButton);
        this.exit.IlllIIIIIIlllIlIIlllIlIIl(mouseX, mouseY, mouseButton);
        this.searchBox.IlllIIIIIIlllIlIIlllIlIIl(mouseX, mouseY, mouseButton);
        return this.llIIlIlIIIllIlIlIlIIlIIll != null && this.llIIlIlIIIllIlIlIlIIlIIll.accept(mouseX, mouseY, mouseButton);
    }

    @Override
    public List<UIComponent> lIllIlIIIlIIIIIIIlllIlIll() {
        return new ArrayList<>();
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        this.searchBox.setPositionAndSize(x + 30.0f, y + height - 18.0f, width - 66.0f, 13.0f);
        this.sendButton.setPositionAndSize(x + width - 32.0f, y + height - 18.0f, 26.0f, 13.0f);
        this.exit.setPositionAndSize(x + width - 20.0f, y + 6.0f, 14.0f, 13.0f);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        this.searchBox.setTyping(false);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        super.handleMouseScrollDelta(n);
        this.lllllIllIlIIlIIlIIIlllIlI.handleMouseScrollDelta(n);
        this.IllIIIlllIIIlIlllIlIIlIII.handleMouseScrollDelta(n);
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(mouseX, mouseY);
        boolean bl2 = bl && mouseX > this.x && mouseX < this.x + 24.0f && mouseY > this.y + 4.0f && mouseY < this.y + this.height - 4.0f;
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 26.0f, this.y + 24.0f, this.width - 26.0f, 0.5f, 0x20FFFFFF);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 26.0f, this.y + this.height - 23.0f, this.width - 26.0f, 0.5f, 0x20FFFFFF);
        AbstractUIScreen.llIIIIIIIllIIllIlIllIIIIl(this.x + 26.0f, this.y + this.height - 22.5f, this.width - 26.0f, 21.5f, 5.0f, 0x45000000);
        AbstractUIScreen.IlIlIlllllIlIIlIlIlllIlIl(this.x, this.y + 1.0f, 25.0f, this.height - 2.0f, 5.0f, 0x40FFFFFF);
        AbstractUIScreen.llllIIlIIlIIlIIllIIlIIllI(this.x + 26.0f, this.y + 1.0f, this.width - 26.0f, 23.0f, 5.0f, 0x25000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x - 1.0f, this.y, this.width + 2.0f, this.height, 4.0f, 0x40000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 3.25f, 0x20FFFFFF);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 5.0f, Integer.MIN_VALUE);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 25.0f, this.y + 1.0f, 1.0f, this.height - 2.0f, 0x40FFFFFF);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable(3089);
        this.IllIIIlllIIIlIlllIlIIlIII.setPositionAndSize(this.x + 24.0f, this.y + 4.0f, 3.0f, this.height - 8.0f);
        this.IllIIIlllIIIlIlllIlIIlIII.onDraw(mouseX, mouseY, bl2);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(0, (int)(this.y + 4.0f), (int)(this.x + 24.0f), (int)(this.y + this.height - 4.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.IIlIllIlIIllIIlIlIllllllI.lllllIllIlIIlIIlIIIlllIlI());
        int n = 0;
        for (UIComponent object : this.list) {
            if (!(object instanceof FriendUIComponent)) continue;
            object.setPositionAndSize(this.x + 6.0f, this.y + 6.0f + (float)n * 18.0f, 12.0f, 12.0f);
            ++n;
        }
        int n2 = 0;
        for (UIComponent uIComponent : this.llllIIlIIlIIlIIllIIlIIllI()) {
            if (!(uIComponent instanceof FriendUIComponent)) continue;
            ++n2;
        }
        super.drawComponent(mouseX, mouseY - this.IllIIIlllIIIlIlllIlIIlIII.getYOffset(), bl);
        this.IllIIIlllIIIlIlllIlIIlIII.setContentHeight((float)n2 * 18.0f);
        this.IllIIIlllIIIlIlllIlIIlIII.llllIIlIIlIIlIIllIIlIIllI(mouseX, mouseY, bl2 && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllllIllIlIIlIIlIIIlllIlI, mouseX, mouseY - this.lllllIllIlIIlIIlIIIlllIlI.getYOffset()));
        GL11.glDisable(3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        if (System.currentTimeMillis() - this.lIIIlllIIIIllllIlIIIlIIll >= TimeUnit.SECONDS.toMillis(2L)) {
            this.sendButton.setHoverOverride(true);
        }
        this.sendButton.drawComponent(mouseX, mouseY, bl);
        this.exit.drawComponent(mouseX, mouseY, bl);
        this.searchBox.drawComponent(mouseX, mouseY, bl);
        LunarClient.getInstance().getPlayerHeadManager().drawPlayerHead(this.x + 36.0f, this.y + 6.0f, this.selectedFriend.lIllIlIIIlIIIIIIIlllIlIll(), this.selectedFriend.lIlIlIlIlIIlIIlIIllIIIIIl(), 1.0f);
        FontRegistry.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.selectedFriend.llllIIlIIlIIlIIllIIlIIllI().toUpperCase(), this.x + 55.0f, this.y + 6.0f, this.selectedFriend.lIlIlIlIlIIlIIlIIllIIIIIl());
        FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl(this.selectedFriend.IlllIIIIIIlllIlIIlllIlIIl(), this.x + 55.0f, this.y + 13.0f, 0x60FFFFFF);
        float f3 = this.y + this.height - 33.0f;
        float f4 = 8.5f;
        LCFontRenderer lCFontRenderer = FontRegistry.llIIlIlIIIllIlIlIlIIlIIll();
        boolean bl3 = bl && mouseX > this.x + 26.0f && mouseX < this.x + this.x + this.width - 2.0f && mouseY > this.y + 26.0f && mouseY < this.y + this.height - 24.0f;
        this.lllllIllIlIIlIIlIIIlllIlI.setPositionAndSize(this.x + this.width - 5.0f, this.y + 26.0f, 3.0f, this.height - 50.0f);
        this.lllllIllIlIIlIIlIIIlllIlI.llIlllIIIllllIIlllIllIIIl(mouseX, mouseY, bl3);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable(3089);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x + 30.0f), (int)(this.y + 26.0f), (int)(this.x + this.width - 2.0f), (int)(this.y + this.height - 24.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.IIlIllIlIIllIIlIlIllllllI.lllllIllIlIIlIIlIIIlllIlI());
        int n3 = 0;
        List<com.moonsworth.lunar.client.websocket.lIllIlIIIlIIIIIIIlllIlIll> list = this.lc.getPlayerHeadManager().IlllIIIIIIlllIlIIlllIlIIl(this.selectedFriend);
        if (list != null) {
            for (com.moonsworth.lunar.client.websocket.lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2 : list) {
                lIllIlIIIlIIIIIIIlllIlIll2.lIlIlIlIlIIlIIlIIllIIIIIl();
                for (int i = lIllIlIIIlIIIIIIIlllIlIll2.llllIIlIIlIIlIIllIIlIIllI().size() - 1; i >= 0; --i) {
                    String string = lIllIlIIIlIIIIIIIlllIlIll2.llllIIlIIlIIlIIllIIlIIllI().get(i);
                    if (i == 0) {
                        String string2 = lIllIlIIIlIIIIIIIlllIlIll2.IlllIIIIIIlllIlIIlllIlIIl();
                        lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(string2, this.x + 30.0f, f3 - (float)n3 * f4, 1625481954);
                        float f5 = lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(string2) + 2;
                        String string3 = lIllIlIIIlIIIIIIIlllIlIll2.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl();
                        int n4 = lIllIlIIIlIIIIIIIlllIlIll2.lIllIlIIIlIIIIIIIlllIlIll() == this.lc.llllIIlIIlIIlIIllIIlIIllI() ? -12346181 : lIllIlIIIlIIIIIIIlllIlIll2.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl();
                        lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(string3, this.x + 30.0f + f5, f3 - (float)n3 * f4, n4);
                        float f6 = lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(string3);
                        lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(": " + string, this.x + 30.0f + f5 + f6, f3 - (float)n3 * f4, -4671304);
                    } else {
                        lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(string), this.x + 30.0f, f3 - (float)n3 * f4, -4671304);
                    }
                    ++n3;
                }
            }
        }
        GL11.glDisable(3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        this.lllllIllIlIIlIIlIIIlllIlI.setContentHeight((float)n3 * f4);
        this.lllllIllIlIIlIIlIIIlllIlI.lIllIlIIIlIIIIIIIlllIlIll(mouseX, mouseY, bl3 && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllllIllIlIIlIIlIIIlllIlI, mouseX, mouseY - this.lllllIllIlIIlIIlIIIlllIlI.getYOffset()));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(FriendProfile friend) {
        if (!this.IlllIIIIIIlllIlIIlllIlIIl(friend)) {
            FriendUIComponent friendUIComponent = new FriendUIComponent(this, friend);
            this.list.add(friendUIComponent);
            friendUIComponent.onMouseClick((float f, float f2, int n) -> {
                this.selectedFriend = friend;
                return true;
            });
            this.selectedFriend = friend;
        } else {
            this.selectedFriend = friend;
        }
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(FriendProfile websocketProfile) {
        for (UIComponent uIComponent : this.list) {
            if (!(uIComponent instanceof FriendUIComponent) || !((FriendUIComponent)uIComponent).lIllIlIIIlIIIIIIIlllIlIll().lIllIlIIIlIIIIIIIlllIlIll().equals(websocketProfile.lIllIlIIIlIIIIIIIlllIlIll())) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean shouldCancel() {
        return this.searchBox.shouldCancel();
    }
}
