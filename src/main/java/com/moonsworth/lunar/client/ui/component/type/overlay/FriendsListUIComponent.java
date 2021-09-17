package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.websocket.FriendProfile;
import com.moonsworth.lunar.client.websocket.Status;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class FriendsListUIComponent
extends AbstractListUIComponent {
    public lIlIlIlIlIIlIIlIIllIIIIIl lIlIlIlIlIIlIIlIIllIIIIIl;
    public final List IlllIIIIIIlllIlIIlllIlIIl = this.lIIIllIllIIllIlllIlIIlllI();
    public lIlIlIlIlIIlIIlIIllIIIIIl lIllIlIIIlIIIIIIIlllIlIll;
    public lIlIlIlIlIIlIIlIIllIIIIIl IIlIllIlllllllIIlIIIllIIl;
    public lIlIlIlIlIIlIIlIIllIIIIIl lIIlIlllIlIlIIIlllIIlIIII;
    public llIllIlIllIlllIllIIIIllII llIllIlIllIlllIllIIIIllII;
    public final List IllllllllllIlIIIlllIlllll = this.IlllllIlIIIlIIlIIllIIlIll();
    public List lllllIllIlIIlIIlIIIlllIlI;
    public IIlIllIlIIllIIlIlIllllllI IllIIIlllIIIlIlllIlIIlIII;
    public IIlIlIIIllIIllllIllllIlIl IIlIllIlIIllIIlIlIllllllI;
    public IIlIlIIIllIIllllIllllIlIl lIIIlllIIIIllllIlIIIlIIll;
    public static final Comparator llIIIlIllIIIIlIIIlIlIllIl = (abstractFriendUIComponent, abstractFriendUIComponent2) -> {
        WebsocketProfile websocketProfile = abstractFriendUIComponent.lIllIlIIIlIIIIIIIlllIlIll();
        WebsocketProfile websocketProfile2 = abstractFriendUIComponent2.lIllIlIIIlIIIIIIIlllIlIll();
        String string = websocketProfile.llllIIlIIlIIlIIllIIlIIllI().toLowerCase();
        String string2 = websocketProfile2.llllIIlIIlIIlIIllIIlIIllI().toLowerCase();
        if (websocketProfile.IlllllIlIIIlIIlIIllIIlIll() == websocketProfile2.IlllllIlIIIlIIlIIllIIlIll()) {
            return string.compareTo(string2);
        }
        return websocketProfile.IlllllIlIIIlIIlIIllIIlIll() ? -1 : 1;
    };

    public FriendsListUIComponent(UIComponent parent) {
        super(parent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(true);
        this.lllllIllIlIIlIIlIIIlllIlI = this.IlllIIIIIIlllIlIIlllIlIIl;
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            this.IlllIIIIIIlllIlIIlllIlIIl(this.IlllIIIIIIlllIlIIlllIlIIl);
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            return true;
        });
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            this.IlllIIIIIIlllIlIIlllIlIIl(this.IllllllllllIlIIIlllIlllll);
            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            return true;
        });
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            Ref.getAssetsWebsocket().ifPresent(assetsWebSocket -> {
                boolean bl = !assetsWebSocket.lIllIlIIIlIIIIIIIlllIlIll();
                assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientRequestsStatus(bl));
                assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(bl);
            });
            return true;
        });
        this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(new IllIllIIIllIIIlIlIlIIIIll(this){

                @Override
                public List lIllIlIIIlIIIIIIIlllIlIll() {
                    ArrayList<lIlIlIIIIIIllIlIIIIllIIII> arrayList = new ArrayList<lIlIlIIIIIIllIlIIIIllIIII>();
                    for (Status status : Status.values()) {
                        if (status == Status.llIlllIIIllllIIlllIllIIIl) continue;
                        lIlIlIIIIIIllIlIIIIllIIII lIlIlIIIIIIllIlIIIIllIIII2 = new lIlIlIIIIIIllIlIIIIllIIII(this.IllIllIIIllIIIlIlIlIIIIll, status.lIlIlIlIlIIlIIlIIllIIIIIl(), WebsocketProfile.lIlIlIlIlIIlIIlIIllIIIIIl(status));
                        arrayList.add(lIlIlIIIIIIllIlIIIIllIIII2);
                        lIlIlIIIIIIllIlIIIIllIIII2.lIlIlIlIlIIlIIlIIllIIIIIl((float f3, float f4, int n) -> {
                            this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI().IlllIIIIIIlllIlIIlllIlIIl(status);
                            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketFriendUpdate("", "", this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI().llIllIlIllIlllIllIIIIllII().ordinal(), true, Bridge.IlllIIIIIIlllIlIIlllIlIIl().IlIlIlllllIlIIlIlIlllIlIl()));
                            if (FriendsListUIComponent.this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                                FriendsListUIComponent.this.IlllIIIIIIlllIlIIlllIlIIl(true);
                            } else {
                                FriendsListUIComponent.this.lIlIlIlIlIIlIIlIIllIIIIIl((IllIllIIIllIIIlIlIlIIIIll)null);
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
        this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl("");
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(false);
        this.lllllIllIlIIlIIlIIIlllIlI = list;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void llllIIlIIlIIlIIllIIlIIllI() {
        Object object;
        boolean bl;
        Object object2;
        Iterator iterator = this.IlllIIIIIIlllIlIIlllIlIIl.iterator();
        while (iterator.hasNext()) {
            object2 = (AbstractFriendUIComponent)iterator.next();
            boolean bl2 = this.lIlIIIIIIlIIIllllIllIIlII.lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(((AbstractFriendUIComponent)object2).lIllIlIIIlIIIIIIIlllIlIll().lIllIlIIIlIIIIIIIlllIlIll()) != null;
            if (bl2) continue;
            iterator.remove();
        }
        object2 = this.IllllllllllIlIIIlllIlllll.iterator();
        while (object2.hasNext()) {
            AbstractFriendUIComponent abstractFriendUIComponent = (AbstractFriendUIComponent)object2.next();
            boolean bl3 = this.lIlIIIIIIlIIIllllIllIIlII.IllIIIlllIIIlIlllIlIIlIII().llIlllIIIllllIIlllIllIIIl().contains(abstractFriendUIComponent.lIllIlIIIlIIIIIIIlllIlIll());
            if (bl3) continue;
            object2.remove();
        }
        for (WebsocketProfile websocketProfile : this.lIlIIIIIIlIIIllllIllIIlII.lllllIllIlIIlIIlIIIlllIlI().llIlllIIIllllIIlllIllIIIl()) {
            bl = false;
            for (AbstractFriendUIComponent abstractFriendUIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
                if (abstractFriendUIComponent.lIllIlIIIlIIIIIIIlllIlIll() != websocketProfile) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            object = this.IlllIIIIIIlllIlIIlllIlIIl;
            synchronized (object) {
                this.IlllIIIIIIlllIlIIlllIlIIl.add(new llIIIIIIIllIIllIlIllIIIIl(this, websocketProfile));
            }
        }
        for (WebsocketProfile websocketProfile : this.lIlIIIIIIlIIIllllIllIIlII.IllIIIlllIIIlIlllIlIIlIII().llIlllIIIllllIIlllIllIIIl()) {
            bl = true;
            for (AbstractFriendUIComponent abstractFriendUIComponent : this.IllllllllllIlIIIlllIlllll) {
                if (abstractFriendUIComponent.lIllIlIIIlIIIIIIIlllIlIll().lIllIlIIIlIIIIIIIlllIlIll() != websocketProfile.lIllIlIIIlIIIIIIIlllIlIll()) continue;
                bl = false;
                break;
            }
            if (!bl) continue;
            object = this.IllllllllllIlIIIlllIlllll;
            synchronized (object) {
                this.IllllllllllIlIIIlllIlllll.add(new FriendRequestUIComponent(this, websocketProfile));
            }
        }
        for (FriendProfile websocketProfile : this.lIlIIIIIIlIIIllllIllIIlII.IllIIIlllIIIlIlllIlIIlIII().IlIlIlllllIlIIlIlIlllIlIl()) {
            bl = true;
            for (AbstractFriendUIComponent abstractFriendUIComponent : this.IllllllllllIlIIIlllIlllll) {
                if (abstractFriendUIComponent.lIllIlIIIlIIIIIIIlllIlIll().lIllIlIIIlIIIIIIIlllIlIll() != websocketProfile.lIllIlIIIlIIIIIIIlllIlIll()) continue;
                bl = false;
                break;
            }
            if (!bl) continue;
            object = this.IllllllllllIlIIIlllIlllll;
            synchronized (object) {
                this.IllllllllllIlIIIlllIlllll.add(new FriendRequestUIComponent(this, websocketProfile, true));
            }
        }
        this.lIllIlIIIlIIIIIIIlllIlIll(this.IlllIIIIIIlllIlIIlllIlIIl);
        this.llIlllIIIllllIIlllIllIIIl(this.IllllllllllIlIIIlllIlllll);
        float f = this.IIlIllIlIIllIIlIlIllllllI.lIlIIIIIIlIIIllllIllIIlII() + this.IIlIllIlIIllIIlIlIllllllI.IllIllIIIllIIIlIlIlIIIIll() + 1.0f;
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, this.IlllIIIIIIlllIlIIlllIlIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, this.IllllllllllIlIIIlllIlllll);
    }

    @Override
    public void IlIlIlllllIlIIlIlIlllIlIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlIllIlIIllIIlIlIllllllI.lIlIIIIIIlIIIllllIllIIlII() + this.IIlIllIlIIllIIlIlIllllllI.IllIllIIIllIIIlIlIlIIIIll() + 1.0f, this.lllllIllIlIIlIIlIIIlllIlI);
    }

    public List lIIIllIllIIllIlllIlIIlllI() {
        ArrayList<llIIIIIIIllIIllIlIllIIIIl> arrayList = new ArrayList<llIIIIIIIllIIllIlIllIIIIl>();
        for (FriendProfile websocketProfile : Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIlIIlIIlIIIlllIlI().llIlllIIIllllIIlllIllIIIl()) {
            arrayList.add(new llIIIIIIIllIIllIlIllIIIIl(this, websocketProfile));
        }
        this.lIllIlIIIlIIIIIIIlllIlIll(arrayList);
        return Collections.synchronizedList(arrayList);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(List list) {
        list.sort((abstractFriendUIComponent, abstractFriendUIComponent2) -> {
            FriendProfile websocketProfile = abstractFriendUIComponent.lIllIlIIIlIIIIIIIlllIlIll();
            FriendProfile websocketProfile2 = abstractFriendUIComponent2.lIllIlIIIlIIIIIIIlllIlIll();
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

    public List IlllllIlIIIlIIlIIllIIlIll() {
        ArrayList<FriendRequestUIComponent> arrayList = new ArrayList<FriendRequestUIComponent>();
        for (FriendProfile websocketProfile : Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIlIIlIIlIIIlllIlI().llIlllIIIllllIIlllIllIIIl()) {
            arrayList.add(new FriendRequestUIComponent(this, websocketProfile));
        }
        this.llIlllIIIllllIIlllIllIIIl(arrayList);
        return Collections.synchronizedList(arrayList);
    }

    public void llIlllIIIllllIIlllIllIIIl(List list) {
        list.sort(llIIIlIllIIIIlIIIlIlIllIl);
    }

    @Override
    public List lIllIlIIIlIIIIIIIlllIlIll() {
        ArrayList<UIComponent> arrayList = new ArrayList<UIComponent>();
        this.llIllIlIllIlllIllIIIIllII = new llIllIlIllIlllIllIIIIllII(this, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/arrow-down-17x17.png"));
        arrayList.add(this.llIllIlIllIlllIllIIIIllII);
        this.IllIIIlllIIIlIlllIlIIlIII = new IIlIllIlIIllIIlIlIllllllI(this);
        arrayList.add(this.IllIIIlllIIIlIlllIlIIlIII);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new lIlIlIlIlIIlIIlIIllIIIIIl(this, "friends", FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
        arrayList.add(this.lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIllIlIIIlIIIIIIIlllIlIll = new lIlIlIlIlIIlIIlIIllIIIIIl(this, "requests", FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
        arrayList.add(this.lIllIlIIIlIIIIIIIlllIlIll);
        this.lIIIlllIIIIllllIlIIIlIIll = new IIlIlIIIllIIllllIllllIlIl(this, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/man-user-12x12.png"), FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "addFriend", 544831865, 1081702777);
        arrayList.add(this.lIIIlllIIIIllllIlIIIlIIll);
        this.IIlIllIlllllllIIlIIIllIIl = new lIlIlIlIlIIlIIlIIllIIIIIl(this, "add", FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
        arrayList.add(this.IIlIllIlllllllIIlIIIllIIl);
        this.lIIlIlllIlIlIIIlllIIlIIII = new lIlIlIlIlIIlIIlIIllIIIIIl(this, "", FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
        arrayList.add(this.lIIlIlllIlIlIIIlllIIlIIII);
        this.IIlIllIlIIllIIlIlIllllllI = new IIlIlIIIllIIllllIllllIlIl(this, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/magnifying-glass-12x12.png"), FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "searchFriend", 544831865, 1081702777);
        arrayList.add(this.IIlIllIlIIllIIlIlIllllllI);
        return arrayList;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + 28.0f, f3 / 2.0f, 16.0f);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 / 2.0f, f2 + 28.0f, f3 / 2.0f, 16.0f);
        this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + 44.0f, f3, 14.0f);
        this.lIIIlllIIIIllllIlIIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + f4 - 36.0f, f3 - 28.0f, 14.0f);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + f4 - 50.0f, f3, 14.0f);
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 28.0f, f2 + f4 - 36.0f, 28.0f, 14.0f);
        this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 20.0f, f2 + 8.0f, 14.0f, 14.0f);
        float f5 = this.IIlIllIlIIllIIlIlIllllllI.lIlIIIIIIlIIIllllIllIIlII() + this.IIlIllIlIIllIIlIlIllllllI.IllIllIIIllIIIlIlIlIIIIll() + 1.0f;
        this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 6.0f, f5, 4.0f, f4 - f5 - 64.0f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f5, this.IlllIIIIIIlllIlIIlllIlIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f5, this.IllllllllllIlIIIlllIlllll);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, List list) {
        int n = 0;
        int n2 = 20;
        for (AbstractFriendUIComponent abstractFriendUIComponent : list) {
            if (this.IIlIllIlIIllIIlIlIllllllI.llllIIlIIlIIlIIllIIlIIllI().length() == 0 || abstractFriendUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llllIIlIIlIIlIIllIIlIIllI().toLowerCase().contains(this.IIlIllIlIIllIIlIlIllllllI.llllIIlIIlIIlIIllIIlIIllI().toLowerCase())) {
                abstractFriendUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, f + 3.0f + (float)(n * n2), this.width, n2);
                ++n;
                continue;
            }
            abstractFriendUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(0.0f, -n2, this.width, n2);
        }
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        if (super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n)) {
            return true;
        }
        if (f2 >= this.IllIIIlllIIIlIlllIlIIlIII.lIlIIIIIIlIIIllllIllIIlII() && f2 < this.IllIIIlllIIIlIlllIlIIlIII.lIlIIIIIIlIIIllllIllIIlII() + this.IllIIIlllIIIlIlllIlIIlIII.IllIllIIIllIIIlIlIlIIIIll()) {
            for (UIComponent uIComponent : this.lllllIllIlIIlIIlIIIlllIlI) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll()) || !this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll(), new UIComponent[0]) || !uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll(), n)) continue;
                return true;
            }
        }
        if (this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlIllIlllllllIIlIIIllIIl, f, f2, new UIComponent[0]) && !this.lIIIlllIIIIllllIlIIIlIIll.llllIIlIIlIIlIIllIIlIIllI().equals("")) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIlllIIIIllllIlIIIlIIll.llllIIlIIlIIlIIllIIlIIllI());
            this.lIIIlllIIIIllllIlIIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl("");
        }
        if (this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlIllIlllllllIIlIIIllIIl, f, f2, new UIComponent[0]) && !this.lIIIlllIIIIllllIlIIIlIIll.llllIIlIIlIIlIIllIIlIIllI().equals("")) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIlllIIIIllllIlIIIlIIll.llllIIlIIlIIlIIllIIlIIllI());
            this.lIIIlllIIIIllllIlIIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl("");
        }
        return false;
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
        for (UIComponent uIComponent : this.lllllIllIlIIlIIlIIIlllIlI) {
            if (uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f, f2, new UIComponent[0]) || !uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n)) continue;
            return true;
        }
        if (this.IIlIllIlIIllIIlIlIllllllI.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n)) {
            return true;
        }
        if (this.lIIIlllIIIIllllIlIIIlIIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n)) {
            return true;
        }
        return super.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        super.lIlIlIlIlIIlIIlIIllIIIIIl();
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.get("friends", this.lIlIIIIIIlIIIllllIllIIlII.lllllIllIlIIlIIlIIIlllIlI().llIlllIIIllllIIlllIllIIIl().size()));
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.get("requests", this.lIlIIIIIIlIIIllllIllIIlII.IllIIIlllIIIlIlllIlIIlIII().IlIlIlllllIlIIlIlIlllIlIl().size() + this.lIlIIIIIIlIIIllllIllIIlII.IllIIIlllIIIlIlllIlIIlIII().llIlllIIIllllIIlllIllIIIl().size()));
        Ref.getAssetsWebsocket().ifPresent(assetsWebSocket -> this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.get("friendRequests", new Object[0]) + ": " + (!assetsWebSocket.lIllIlIIIlIIIIIIIlllIlIll() ? this.get("disabled", new Object[0]) : this.get("enabled", new Object[0]))));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, -820175587);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + this.width - 1.0f, this.y, 0.5f, this.height, 0x20E2E2E2);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 28.0f, this.width, 1.0f, 0x20E2E2E2);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 57.5f, this.width, 1.0f, 0x20929292);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 27.0f + this.lIlIlIlIlIIlIIlIIllIIIIIl.IllIllIIIllIIIlIlIlIIIIll(), this.width, 1.0f, 0x20E2E2E2);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.lIlIlIlIlIIlIIlIIllIIIIIl.lllIIIIIlllIIlIllIIlIIIlI() + this.lIlIlIlIlIIlIIlIIllIIIIIl.llIlIIIllIIlIllIllIllllIl() - 0.5f, this.y + 28.0f, 1.0f, this.lIlIlIlIlIIlIIlIIllIIIIIl.IllIllIIIllIIIlIlIlIIIIll(), 0x20E2E2E2);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, 28.0f, 0x22000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + this.height - 36.0f, this.width, 0.5f, 0x20E2E2E2);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + this.height - 22.5f, this.width, 0.5f, 0x20E2E2E2);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + this.lIIIlllIIIIllllIlIIIlIIll.llIlIIIllIIlIllIllIllllIl(), this.y + this.height - 36.0f, 0.5f, 14.0f, 0x20E2E2E2);
        if (FontRegistry.lllllIllIllIllllIlIllllII().IlllIIIIIIlllIlIIlllIlIIl(this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI().llIlllIIIllllIIlllIllIIIl()) > 82) {
            FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI().llIllIlIllIlllIllIIIIllII().lIlIlIlIlIIlIIlIIllIIIIIl(), this.x + 26.0f, this.y + 14.0f, -1342177281);
            FontRegistry.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI().llIlllIIIllllIIlllIllIIIl(), this.x + 26.0f, this.y + 8.0f, this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI().lIlIlIlIlIIlIIlIIllIIIIIl());
        } else {
            FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI().llIllIlIllIlllIllIIIIllII().lIlIlIlIlIIlIIlIIllIIIIIl(), this.x + 26.0f, this.y + 15.5f, -1342177281);
            FontRegistry.lllllIllIllIllllIlIllllII().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI().llIlllIIIllllIIlllIllIIIl(), this.x + 26.0f, this.y + 7.0f, this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI().lIlIlIlIlIIlIIlIIllIIIIIl());
        }
        LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 8.0f, this.y + 8.0f, this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI().lIllIlIIIlIIIIIIIlllIlIll(), this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI().lIlIlIlIlIIlIIlIIllIIIIIl(), 1.0f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.3f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(CosmeticManager.lIllIlIIIlIIIIIIIlllIlIll, this.x + this.width / 2.0f - 35.0f, this.y + this.height - 18.5f, 16.0f, 15.0f);
        FontRegistry.IlIlIlllllIlIIlIlIlllIlIl().IlllIIIIIIlllIlIIlllIlIIl("Lunar Client", this.x + this.width / 2.0f + 6.0f, this.y + this.height - 15.5f, -8487298);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable((int)3089);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)this.x, (int)(this.y + 59.0f), (int)(this.x + this.width), (int)(this.y + this.height - 36.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.height);
        this.IllIIIlllIIIlIlllIlIIlIII.IlIlIlllllIlIIlIlIlllIlIl(3 + this.lllllIllIlIIlIIlIIIlllIlI.size() * 20);
        this.IllIIIlllIIIlIlllIlIIlIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2, bl);
        boolean bl2 = bl && !this.IllIIIlllIIIlIlllIlIIlIII.lIIIllIllIIllIlllIlIIlllI() && !this.IllIIIlllIIIlIlllIlIIlIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2);
        List list = this.lllllIllIlIIlIIlIIIlllIlI == this.IlllIIIIIIlllIlIIlllIlIIl ? this.IlllIIIIIIlllIlIIlllIlIIl : this.IllllllllllIlIIIlllIlllll;
        synchronized (list) {
            ArrayList<UIComponent> arrayList = new ArrayList(this.lllllIllIlIIlIIlIIIlllIlI);
            for (UIComponent uIComponent : arrayList) {
                boolean bl3;
                boolean bl4 = uIComponent.lIlIIIIIIlIIIllllIllIIlII() + uIComponent.IllIllIIIllIIIlIlIlIIIIll() + this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll() < this.IllIIIlllIIIlIlllIlIIlIII.lIlIIIIIIlIIIllllIllIIlII();
                boolean bl5 = bl3 = uIComponent.lIlIIIIIIlIIIllllIllIIlII() + this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll() > this.IllIIIlllIIIlIlllIlIIlIII.lIlIIIIIIlIIIllllIllIIlII() + this.IllIIIlllIIIlIlllIlIIlIII.IllIllIIIllIIIlIlIlIIIIll();
                if (bl4 || bl3) continue;
                uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll(), bl2 && this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll(), new UIComponent[0]));
            }
        }
        this.IllIIIlllIIIlIlllIlIIlIII.llllIIlIIlIIlIIllIIlIIllI(f, f2, bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIIIlllIIIlIlllIlIIlIII, f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll(), new UIComponent[0]));
        GL11.glDisable((int)3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
        if (keyType == KeyType.IlIlIlIlIIIlIIlIIlllIllIl && this.lIIIlllIIIIllllIlIIIlIIll.llIllIlIllIlllIllIIIIllII() && !this.lIIIlllIIIIllllIlIIIlIIll.llllIIlIIlIIlIIllIIlIIllI().equals("")) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIlllIIIIllllIlIIIlIIll.llllIIlIIlIIlIIllIIlIIllI());
            this.lIIIlllIIIIllllIlIIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl("");
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        if (string.matches("([a-zA-Z0-9_]+)") && string.length() <= 16) {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketFriendRequest("", string));
        } else {
            this.lIlIIIIIIlIIIllllIllIIlII.IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(NotificationType.ERROR, this.get("incorrectUsername", new Object[0]));
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
        super.IlllIIIIIIlllIlIIlllIlIIl();
    }

    public IIlIllIlIIllIIlIlIllllllI llIIIIIIIllIIllIlIllIIIIl() {
        return this.IllIIIlllIIIlIlllIlIIlIII;
    }
}
 