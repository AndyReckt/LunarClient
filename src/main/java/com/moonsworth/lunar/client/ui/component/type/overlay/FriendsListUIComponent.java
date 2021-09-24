package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.notification.NotificationType;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.CosmeticManager;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.IconTextBoxUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.ScrollbarUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.lIlIlIIIIIIllIlIIIIllIIII;
import com.moonsworth.lunar.client.ui.component.type.setting.SmallIconUIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.profile.FriendProfile;
import com.moonsworth.lunar.client.websocket.Status;
import com.moonsworth.lunar.client.websocket.packet.WSPacketClientRequestsStatus;
import com.moonsworth.lunar.client.websocket.packet.WSPacketFriendRequest;
import com.moonsworth.lunar.client.websocket.packet.WSPacketFriendUpdate;
import org.lwjgl.opengl.GL11;

import java.util.*;

public class FriendsListUIComponent extends AbstractListUIComponent<UIComponent> {
    public FriendsListButtonUIComponent friends;
    public final List<AbstractFriendUIComponent> list = this.lIIIllIllIIllIlllIlIIlllI();
    public FriendsListButtonUIComponent requests;
    public FriendsListButtonUIComponent add;
    public FriendsListButtonUIComponent lIIlIlllIlIlIIIlllIIlIIII;
    public SmallIconUIComponent arrowDown;
    public final List<AbstractFriendUIComponent> IllllllllllIlIIIlllIlllll = this.IlllllIlIIIlIIlIIllIIlIll();
    public List<AbstractFriendUIComponent> lllllIllIlIIlIIlIIIlllIlI;
    public ScrollbarUIComponent scrollContainer;
    public IconTextBoxUIComponent searchFriend;
    public IconTextBoxUIComponent lIIIlllIIIIllllIlIIIlIIll;
    public static final Comparator<AbstractFriendUIComponent> llIIIlIllIIIIlIIIlIlIllIl = (abstractFriendUIComponent, abstractFriendUIComponent2) -> {
        FriendProfile websocketProfile = abstractFriendUIComponent.getFriend();
        FriendProfile websocketProfile2 = abstractFriendUIComponent2.getFriend();
        String string = websocketProfile.llllIIlIIlIIlIIllIIlIIllI().toLowerCase();
        String string2 = websocketProfile2.llllIIlIIlIIlIIllIIlIIllI().toLowerCase();
        if (websocketProfile.IlllllIlIIIlIIlIIllIIlIll() == websocketProfile2.IlllllIlIIIlIIlIIllIIlIll()) {
            return string.compareTo(string2);
        }
        return websocketProfile.IlllllIlIIIlIIlIIllIIlIll() ? -1 : 1;
    };

    public FriendsListUIComponent(UIComponent parent) {
        super(parent);
        this.friends.setHoverOverride(true);
        this.lllllIllIlIIlIIlIIIlllIlI = this.list;
        this.friends.onMouseClick((float f, float f2, int n) -> {
            this.IlllIIIIIIlllIlIIlllIlIIl(this.list);
            this.friends.setHoverOverride(true);
            return true;
        });
        this.requests.onMouseClick((float f, float f2, int n) -> {
            this.IlllIIIIIIlllIlIIlllIlIIl(this.IllllllllllIlIIIlllIlllll);
            this.requests.setHoverOverride(true);
            return true;
        });
        this.lIIlIlllIlIlIIIlllIIlIIII.onMouseClick((float f, float f2, int n) -> {
            Ref.getAssetsWebsocket().ifPresent(assetsWebSocket -> {
                boolean bl = !assetsWebSocket.lIllIlIIIlIIIIIIIlllIlIll();
                assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientRequestsStatus(bl));
                assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(bl);
            });
            return true;
        });
        this.arrowDown.onMouseClick((float f, float f2, int n) -> {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(new com.moonsworth.lunar.client.ui.component.type.setting.IllIllIIIllIIIlIlIlIIIIll(this) {

                @Override
                public List lIllIlIIIlIIIIIIIlllIlIll() {
                    ArrayList<lIlIlIIIIIIllIlIIIIllIIII> arrayList = new ArrayList<lIlIlIIIIIIllIlIIIIllIIII>();
                    for (Status status : Status.values()) {
                        if (status == Status.OFFLINE) continue;
                        lIlIlIIIIIIllIlIIIIllIIII lIlIlIIIIIIllIlIIIIllIIII2 = new lIlIlIIIIIIllIlIIIIllIIII(this.sumTing, status.lIlIlIlIlIIlIIlIIllIIIIIl(), FriendProfile.lIlIlIlIlIIlIIlIIllIIIIIl(status));
                        arrayList.add(lIlIlIIIIIIllIlIIIIllIIII2);
                        lIlIlIIIIIIllIlIIIIllIIII2.onMouseClick((float f3, float f4, int n) -> {
                            this.lc.llllIIlIIlIIlIIllIIlIIllI().setStatus(status);
                            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketFriendUpdate("", "", this.lc.llllIIlIIlIIlIIllIIlIIllI().llIllIlIllIlllIllIIIIllII().ordinal(), true, Bridge.getMinecraftVersion().IlIlIlllllIlIIlIlIlllIlIl()));
                            if (FriendsListUIComponent.this.mouseInside(f, f2)) {
                                FriendsListUIComponent.this.IlllIIIIIIlllIlIIlllIlIIl(true);
                            } else {
                                FriendsListUIComponent.this.lIlIlIlIlIIlIIlIIllIIIIIl((com.moonsworth.lunar.client.ui.component.type.setting.IllIllIIIllIIIlIlIlIIIIll)null);
                            }
                            return true;
                        });
                    }
                    return arrayList;
                }
            });
            this.llIllIlIllIlllIllIIIIllII().lIlIlIlIlIIlIIlIIllIIIIIl(f, f2);
            return true;
        });
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(List list) {
        this.searchFriend.setText("");
        this.friends.setHoverOverride(false);
        this.requests.setHoverOverride(false);
        this.lllllIllIlIIlIIlIIIlllIlI = list;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void llllIIlIIlIIlIIllIIlIIllI() {
        Object object;
        boolean bl;
        Object object2;
        Iterator<AbstractFriendUIComponent> iterator = this.list.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            boolean bl2 = this.lc.getPlayerHeadManager().lIlIlIlIlIIlIIlIIllIIIIIl(((AbstractFriendUIComponent)object2).getFriend().lIllIlIIIlIIIIIIIlllIlIll()) != null;
            if (bl2) continue;
            iterator.remove();
        }
        Iterator<AbstractFriendUIComponent> iterator1 = this.IllllllllllIlIIIlllIlllll.iterator();
        while (iterator1.hasNext()) {
            AbstractFriendUIComponent abstractFriendUIComponent = iterator1.next();
            boolean bl3 = this.lc.IllIIIlllIIIlIlllIlIIlIII().llIlllIIIllllIIlllIllIIIl().contains(abstractFriendUIComponent.getFriend());
            if (bl3) continue;
            iterator1.remove();
        }
        for (FriendProfile friend : this.lc.getPlayerHeadManager().llIlllIIIllllIIlllIllIIIl()) {
            bl = false;
            for (AbstractFriendUIComponent abstractFriendUIComponent : this.list) {
                if (abstractFriendUIComponent.getFriend() != friend) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            object = this.list;
            synchronized (object) {
                this.list.add(new FriendListEntryUIComponent(this, friend));
            }
        }
        for (FriendProfile friend : this.lc.IllIIIlllIIIlIlllIlIIlIII().llIlllIIIllllIIlllIllIIIl()) {
            bl = true;
            for (AbstractFriendUIComponent abstractFriendUIComponent : this.IllllllllllIlIIIlllIlllll) {
                if (abstractFriendUIComponent.getFriend().lIllIlIIIlIIIIIIIlllIlIll() != friend.lIllIlIIIlIIIIIIIlllIlIll()) continue;
                bl = false;
                break;
            }
            if (!bl) continue;
            object = this.IllllllllllIlIIIlllIlllll;
            synchronized (object) {
                this.IllllllllllIlIIIlllIlllll.add(new FriendRequestUIComponent(this, friend));
            }
        }
        for (FriendProfile websocketProfile : this.lc.IllIIIlllIIIlIlllIlIIlIII().IlIlIlllllIlIIlIlIlllIlIl()) {
            bl = true;
            for (AbstractFriendUIComponent abstractFriendUIComponent : this.IllllllllllIlIIIlllIlllll) {
                if (abstractFriendUIComponent.getFriend().lIllIlIIIlIIIIIIIlllIlIll() != websocketProfile.lIllIlIIIlIIIIIIIlllIlIll()) continue;
                bl = false;
                break;
            }
            if (!bl) continue;
            object = this.IllllllllllIlIIIlllIlllll;
            synchronized (object) {
                this.IllllllllllIlIIIlllIlllll.add(new FriendRequestUIComponent(this, websocketProfile, true));
            }
        }
        this.lIllIlIIIlIIIIIIIlllIlIll(this.list);
        this.llIlllIIIllllIIlllIllIIIl(this.IllllllllllIlIIIlllIlllll);
        float f = this.searchFriend.getY() + this.searchFriend.getHeight() + 1.0f;
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, this.list);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, this.IllllllllllIlIIIlllIlllll);
    }

    @Override
    public void IlIlIlllllIlIIlIlIlllIlIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.searchFriend.getY() + this.searchFriend.getHeight() + 1.0f, this.lllllIllIlIIlIIlIIIlllIlI);
    }

    public List<AbstractFriendUIComponent> lIIIllIllIIllIlllIlIIlllI() {
        ArrayList<AbstractFriendUIComponent> arrayList = new ArrayList<AbstractFriendUIComponent>();
        for (FriendProfile websocketProfile : Ref.getLC().getPlayerHeadManager().llIlllIIIllllIIlllIllIIIl()) {
            arrayList.add(new FriendListEntryUIComponent(this, websocketProfile));
        }
        this.lIllIlIIIlIIIIIIIlllIlIll(arrayList);
        return Collections.synchronizedList(arrayList);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(List<AbstractFriendUIComponent> list) {
        list.sort((abstractFriendUIComponent, abstractFriendUIComponent2) -> {
            FriendProfile websocketProfile = abstractFriendUIComponent.getFriend();
            FriendProfile websocketProfile2 = abstractFriendUIComponent2.getFriend();
            String string = websocketProfile.llllIIlIIlIIlIIllIIlIIllI().toLowerCase();
            String string2 = websocketProfile2.llllIIlIIlIIlIIllIIlIIllI().toLowerCase();
            if (websocketProfile.IlllllIlIIIlIIlIIllIIlIll() && !websocketProfile2.IlllllIlIIIlIIlIIllIIlIll()) {
                return -1;
            }
            if (!websocketProfile.IlllllIlIIIlIIlIIllIIlIll() && websocketProfile2.IlllllIlIIIlIIlIIllIIlIll()) {
                return 1;
            }
            if (!websocketProfile.IlllllIlIIIlIIlIIllIIlIll() && !websocketProfile2.IlllllIlIIIlIIlIIllIIlIll()) {
                if (websocketProfile.IlllllIlIIIlIIlIIllIIlIll()) {
                    return 1;
                }
                if (websocketProfile2.IlllllIlIIIlIIlIIllIIlIll()) {
                    return -1;
                }
                return string.compareTo(string2);
            }
            return string.compareTo(string2);
        });
    }

    public List<AbstractFriendUIComponent> IlllllIlIIIlIIlIIllIIlIll() {
        ArrayList<AbstractFriendUIComponent> arrayList = new ArrayList<>();
        for (FriendProfile websocketProfile : Ref.getLC().getPlayerHeadManager().llIlllIIIllllIIlllIllIIIl()) {
            arrayList.add(new FriendRequestUIComponent(this, websocketProfile));
        }
        this.llIlllIIIllllIIlllIllIIIl(arrayList);
        return Collections.synchronizedList(arrayList);
    }

    public void llIlllIIIllllIIlllIllIIIl(List<AbstractFriendUIComponent> list) {
        list.sort(llIIIlIllIIIIlIIIlIlIllIl);
    }

    @Override
    public List<UIComponent> lIllIlIIIlIIIIIIIlllIlIll() {
        ArrayList<UIComponent> arrayList = new ArrayList<>();
        this.arrowDown = new SmallIconUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/assets/arrow-down-17x17.png"));
        arrayList.add(this.arrowDown);
        this.scrollContainer = new ScrollbarUIComponent(this);
        arrayList.add(this.scrollContainer);
        this.friends = new FriendsListButtonUIComponent(this, "friends", FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
        arrayList.add(this.friends);
        this.requests = new FriendsListButtonUIComponent(this, "requests", FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
        arrayList.add(this.requests);
        this.lIIIlllIIIIllllIlIIIlIIll = new IconTextBoxUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/assets/man-user-12x12.png"), FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "addFriend", 544831865, 1081702777);
        arrayList.add(this.lIIIlllIIIIllllIlIIIlIIll);
        this.add = new FriendsListButtonUIComponent(this, "add", FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
        arrayList.add(this.add);
        this.lIIlIlllIlIlIIIlllIIlIIII = new FriendsListButtonUIComponent(this, "", FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
        arrayList.add(this.lIIlIlllIlIlIIIlllIIlIIII);
        this.searchFriend = new IconTextBoxUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/assets/magnifying-glass-12x12.png"), FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "searchFriend", 544831865, 1081702777);
        arrayList.add(this.searchFriend);
        return arrayList;
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        this.friends.setPositionAndSize(x, y + 28.0f, width / 2.0f, 16.0f);
        this.requests.setPositionAndSize(x + width / 2.0f, y + 28.0f, width / 2.0f, 16.0f);
        this.searchFriend.setPositionAndSize(x, y + 44.0f, width, 14.0f);
        this.lIIIlllIIIIllllIlIIIlIIll.setPositionAndSize(x, y + height - 36.0f, width - 28.0f, 14.0f);
        this.lIIlIlllIlIlIIIlllIIlIIII.setPositionAndSize(x, y + height - 50.0f, width, 14.0f);
        this.add.setPositionAndSize(x + width - 28.0f, y + height - 36.0f, 28.0f, 14.0f);
        this.arrowDown.setPositionAndSize(x + width - 20.0f, y + 8.0f, 14.0f, 14.0f);
        float f5 = this.searchFriend.getY() + this.searchFriend.getHeight() + 1.0f;
        this.scrollContainer.setPositionAndSize(x + width - 6.0f, f5, 4.0f, height - f5 - 64.0f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f5, this.list);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f5, this.IllllllllllIlIIIlllIlllll);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, List<AbstractFriendUIComponent> list) {
        int n = 0;
        int n2 = 20;
        for (AbstractFriendUIComponent abstractFriendUIComponent : list) {
            if (this.searchFriend.getText().length() == 0 || abstractFriendUIComponent.getFriend().llllIIlIIlIIlIIllIIlIIllI().toLowerCase().contains(this.searchFriend.getText().toLowerCase())) {
                abstractFriendUIComponent.setPositionAndSize(this.x, f + 3.0f + (float)(n * n2), this.width, n2);
                ++n;
                continue;
            }
            abstractFriendUIComponent.setPositionAndSize(0.0f, -n2, this.width, n2);
        }
    }

    @Override
    public boolean onMouseClicked(float mouseX, float mouseY, int mouseButton) {
        if (super.onMouseClicked(mouseX, mouseY, mouseButton)) {
            return true;
        }
        if (mouseY >= this.scrollContainer.getY() && mouseY < this.scrollContainer.getY() + this.scrollContainer.getHeight()) {
            for (UIComponent uIComponent : this.lllllIllIlIIlIIlIIIlllIlI) {
                if (!uIComponent.mouseInside(mouseX, mouseY - this.scrollContainer.getYOffset()) || !this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, mouseX, mouseY - this.scrollContainer.getYOffset()) || !uIComponent.onMouseClicked(mouseX, mouseY - this.scrollContainer.getYOffset(), mouseButton)) continue;
                return true;
            }
        }
        if (this.add.mouseInside(mouseX, mouseY) && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.add, mouseX, mouseY) && !this.lIIIlllIIIIllllIlIIIlIIll.getText().equals("")) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIlllIIIIllllIlIIIlIIll.getText());
            this.lIIIlllIIIIllllIlIIIlIIll.setText("");
        }
        if (this.add.mouseInside(mouseX, mouseY) && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.add, mouseX, mouseY) && !this.lIIIlllIIIIllllIlIIIlIIll.getText().equals("")) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIlllIIIIllllIlIIIlIIll.getText());
            this.lIIIlllIIIIllllIlIIIlIIll.setText("");
        }
        return false;
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl(float mouseX, float mouseY, int mouseButton) {
        for (UIComponent uIComponent : this.lllllIllIlIIlIIlIIIlllIlI) {
            if (uIComponent.mouseInside(mouseX, mouseY) && this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, mouseX, mouseY) || !uIComponent.IlllIIIIIIlllIlIIlllIlIIl(mouseX, mouseY, mouseButton)) continue;
            return true;
        }
        if (this.searchFriend.IlllIIIIIIlllIlIIlllIlIIl(mouseX, mouseY, mouseButton)) {
            return true;
        }
        if (this.lIIIlllIIIIllllIlIIIlIIll.IlllIIIIIIlllIlIIlllIlIIl(mouseX, mouseY, mouseButton)) {
            return true;
        }
        return super.IlllIIIIIIlllIlIIlllIlIIl(mouseX, mouseY, mouseButton);
    }

    @Override
    public void onUpdateScreen() {
        super.onUpdateScreen();
        this.friends.lIlIlIlIlIIlIIlIIllIIIIIl(this.get("friends", this.lc.getPlayerHeadManager().llIlllIIIllllIIlllIllIIIl().size()));
        this.requests.lIlIlIlIlIIlIIlIIllIIIIIl(this.get("requests", this.lc.IllIIIlllIIIlIlllIlIIlIII().IlIlIlllllIlIIlIlIlllIlIl().size() + this.lc.IllIIIlllIIIlIlllIlIIlIII().llIlllIIIllllIIlllIllIIIl().size()));
        Ref.getAssetsWebsocket().ifPresent(assetsWebSocket -> this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.get("friendRequests") + ": " + (!assetsWebSocket.lIllIlIIIlIIIIIIIlllIlIll() ? this.get("disabled") : this.get("enabled"))));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, -820175587);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + this.width - 1.0f, this.y, 0.5f, this.height, 0x20E2E2E2);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 28.0f, this.width, 1.0f, 0x20E2E2E2);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 57.5f, this.width, 1.0f, 0x20929292);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 27.0f + this.friends.getHeight(), this.width, 1.0f, 0x20E2E2E2);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.friends.getX() + this.friends.getWidth() - 0.5f, this.y + 28.0f, 1.0f, this.friends.getHeight(), 0x20E2E2E2);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, 28.0f, 0x22000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + this.height - 36.0f, this.width, 0.5f, 0x20E2E2E2);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + this.height - 22.5f, this.width, 0.5f, 0x20E2E2E2);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + this.lIIIlllIIIIllllIlIIIlIIll.getWidth(), this.y + this.height - 36.0f, 0.5f, 14.0f, 0x20E2E2E2);
        if (FontRegistry.lllllIllIllIllllIlIllllII().IlllIIIIIIlllIlIIlllIlIIl(this.lc.llllIIlIIlIIlIIllIIlIIllI().llIlllIIIllllIIlllIllIIIl()) > 82) {
            FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(this.lc.llllIIlIIlIIlIIllIIlIIllI().llIllIlIllIlllIllIIIIllII().lIlIlIlIlIIlIIlIIllIIIIIl(), this.x + 26.0f, this.y + 14.0f, -1342177281);
            FontRegistry.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.lc.llllIIlIIlIIlIIllIIlIIllI().llIlllIIIllllIIlllIllIIIl(), this.x + 26.0f, this.y + 8.0f, this.lc.llllIIlIIlIIlIIllIIlIIllI().lIlIlIlIlIIlIIlIIllIIIIIl());
        } else {
            FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(this.lc.llllIIlIIlIIlIIllIIlIIllI().llIllIlIllIlllIllIIIIllII().lIlIlIlIlIIlIIlIIllIIIIIl(), this.x + 26.0f, this.y + 15.5f, -1342177281);
            FontRegistry.lllllIllIllIllllIlIllllII().lIlIlIlIlIIlIIlIIllIIIIIl(this.lc.llllIIlIIlIIlIIllIIlIIllI().llIlllIIIllllIIlllIllIIIl(), this.x + 26.0f, this.y + 7.0f, this.lc.llllIIlIIlIIlIIllIIlIIllI().lIlIlIlIlIIlIIlIIllIIIIIl());
        }
        LunarClient.getInstance().getPlayerHeadManager().drawPlayerHead(this.x + 8.0f, this.y + 8.0f, this.lc.llllIIlIIlIIlIIllIIlIIllI().lIllIlIIIlIIIIIIIlllIlIll(), this.lc.llllIIlIIlIIlIIllIIlIIllI().lIlIlIlIlIIlIIlIIllIIIIIl(), 1.0f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.3f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(CosmeticManager.lIllIlIIIlIIIIIIIlllIlIll, this.x + this.width / 2.0f - 35.0f, this.y + this.height - 18.5f, 16.0f, 15.0f);
        FontRegistry.IlIlIlllllIlIIlIlIlllIlIl().IlllIIIIIIlllIlIIlllIlIIl("Lunar Client", this.x + this.width / 2.0f + 6.0f, this.y + this.height - 15.5f, -8487298);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable(3089);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)this.x, (int)(this.y + 59.0f), (int)(this.x + this.width), (int)(this.y + this.height - 36.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.height);
        this.scrollContainer.setContentHeight(3 + this.lllllIllIlIIlIIlIIIlllIlI.size() * 20);
        this.scrollContainer.onDraw(mouseX, mouseY, bl);
        boolean bl2 = bl && !this.scrollContainer.lIIIllIllIIllIlllIlIIlllI() && !this.scrollContainer.mouseInside(mouseX, mouseY);
        List list = this.lllllIllIlIIlIIlIIIlllIlI == this.list ? this.list : this.IllllllllllIlIIIlllIlllll;
        synchronized (list) {
            ArrayList<UIComponent> arrayList = new ArrayList<>(this.lllllIllIlIIlIIlIIIlllIlI);
            for (UIComponent uIComponent : arrayList) {
                boolean bl3;
                boolean bl4 = uIComponent.getY() + uIComponent.getHeight() + this.scrollContainer.getYOffset() < this.scrollContainer.getY();
                boolean bl5 = bl3 = uIComponent.getY() + this.scrollContainer.getYOffset() > this.scrollContainer.getY() + this.scrollContainer.getHeight();
                if (bl4 || bl3) continue;
                uIComponent.drawComponent(mouseX, mouseY - this.scrollContainer.getYOffset(), bl2 && this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, mouseX, mouseY - this.scrollContainer.getYOffset()));
            }
        }
        this.scrollContainer.llllIIlIIlIIlIIllIIlIIllI(mouseX, mouseY, bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.scrollContainer, mouseX, mouseY - this.scrollContainer.getYOffset()));
        GL11.glDisable(3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        super.drawComponent(mouseX, mouseY, bl);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        super.onKeyTyped(c, keyType);
        if (keyType == KeyType.KEY_RETURN && this.lIIIlllIIIIllllIlIIIlIIll.isTyping() && !this.lIIIlllIIIIllllIlIIIlIIll.getText().equals("")) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIlllIIIIllllIlIIIlIIll.getText());
            this.lIIIlllIIIIllllIlIIIlIIll.setText("");
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        if (string.matches("([a-zA-Z0-9_]+)") && string.length() <= 16) {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketFriendRequest("", string));
        } else {
            this.lc.IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(NotificationType.ERROR, this.get("incorrectUsername"));
        }
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        super.handleMouseScrollDelta(n);
        this.scrollContainer.handleMouseScrollDelta(n);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }

    public ScrollbarUIComponent getScrollBar() {
        return this.scrollContainer;
    }
}
