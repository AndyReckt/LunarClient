package com.moonsworth.lunar.client.feature.type.itemtacker;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.event.type.world.WorldLoadEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class ItemTrackerMod extends DraggableHudMod {
    public ItemTrackerMod.lIlIlIlIlIIlIIlIIllIIIIIl[] lllIIIIIlllIIlIllIIlIIIlI;
    public Map<String, Long> lIlIIIIIIlIIIllllIllIIlII = new ConcurrentHashMap<>();
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;
    public long IIlIllIlllllllIIlIIIllIIl;

    public ItemTrackerMod() {
        super(false, HudModPosition.MIDDLE_LEFT);
        this.IlllIIIIIIlllIlIIlllIlIIl(90.0F, 25.0F);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(WorldLoadEvent.class, (var1) -> {
            this.IIlIllIlllllllIIlIIIllIIl = System.currentTimeMillis();
        });
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(10.0F, 75.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        Ref.getFontRenderer().bridge$drawString("§7[§a+§7]§a 1 §fCobblestone", var2, var3, -16711936, this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
        Ref.getFontRenderer().bridge$drawString("§7[§c-§7]§c 1 §fCobblestone", var2, var3 + 10.0F, -65536, this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent renderGameOverlayEvent, float f, float f2) {
        int n;
        if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl().booleanValue() && !Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().isSkyBlock()) {
            return;
        }
        if (this.lllIIIIIlllIIlIllIIlIIIlI == null) {
            this.lllIIIIIlllIIlIllIIlIIIlI = this.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getPlayer().bridge$getInventory().bridge$getMainInventory());
            return;
        }
        lIlIlIlIlIIlIIlIIllIIIIIl[] lIlIlIlIlIIlIIlIIllIIIIIlArray = this.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getPlayer().bridge$getInventory().bridge$getMainInventory());
        for (n = 0; n < lIlIlIlIlIIlIIlIIllIIIIIlArray.length; ++n) {
            int n2;
            if (this.lllIIIIIlllIIlIllIIlIIIlI[n] != null && lIlIlIlIlIIlIIlIIllIIIIIlArray[n] != null && this.lllIIIIIlllIIlIllIIlIIIlI[n].equals(lIlIlIlIlIIlIIlIIllIIIIIlArray[n])) continue;
            int n3 = (lIlIlIlIlIIlIIlIIllIIIIIlArray[n] == null ? 0 : lIlIlIlIlIIlIIlIIllIIIIIlArray[n].IlllIIIIIIlllIlIIlllIlIIl()) - (this.lllIIIIIlllIIlIllIIlIIIlI[n] == null ? 0 : this.lllIIIIIlllIIlIllIIlIIIlI[n].IlllIIIIIIlllIlIIlllIlIIl());
            boolean bl = false;
            if (n3 == 0) continue;
            if (n3 < 0) {
                for (Map.Entry entry : this.lIlIIIIIIlIIIllllIllIIlII.entrySet()) {
                    if (System.currentTimeMillis() - (Long)entry.getValue() >= TimeUnit.SECONDS.toMillis(2L) || !((String)entry.getKey()).toLowerCase().endsWith(this.lllIIIIIlllIIlIllIIlIIIlI[n].lIlIlIlIlIIlIIlIIllIIIIIl().toLowerCase()) || !((String)entry.getKey()).contains("-") || this.lllIIIIIlllIIlIllIIlIIIlI[n].lIlIlIlIlIIlIIlIIllIIIIIl().isEmpty()) continue;
                    n2 = Integer.parseInt(((String)entry.getKey()).split(" ")[1]) + Math.abs(n3);
                    this.lIlIIIIIIlIIIllllIllIIlII.remove(entry.getKey());
                    this.lIlIIIIIIlIIIllllIllIIlII.put("§7[§c-§7]§c " + n2 + " " + this.lllIIIIIlllIIlIllIIlIIIlI[n].lIlIlIlIlIIlIIlIIllIIIIIl(), System.currentTimeMillis());
                    bl = true;
                    break;
                }
                if (bl || this.lllIIIIIlllIIlIllIIlIIIlI[n].lIlIlIlIlIIlIIlIIllIIIIIl().isEmpty()) continue;
                this.lIlIIIIIIlIIIllllIllIIlII.put("§7[§c-§7]§c " + Math.abs(n3) + " " + this.lllIIIIIlllIIlIllIIlIIIlI[n].lIlIlIlIlIIlIIlIIllIIIIIl(), System.currentTimeMillis());
                continue;
            }
            for (Map.Entry entry : this.lIlIIIIIIlIIIllllIllIIlII.entrySet()) {
                if (System.currentTimeMillis() - (Long)entry.getValue() >= TimeUnit.SECONDS.toMillis(2L) || !((String)entry.getKey()).toLowerCase().endsWith(lIlIlIlIlIIlIIlIIllIIIIIlArray[n].lIlIlIlIlIIlIIlIIllIIIIIl().toLowerCase()) || !((String)entry.getKey()).contains("+") || lIlIlIlIlIIlIIlIIllIIIIIlArray[n].lIlIlIlIlIIlIIlIIllIIIIIl().isEmpty()) continue;
                n2 = Integer.parseInt(((String)entry.getKey()).split(" ")[1]) + Math.abs(n3);
                this.lIlIIIIIIlIIIllllIllIIlII.remove(entry.getKey());
                this.lIlIIIIIIlIIIllllIllIIlII.put("§7[§a+§7]§a " + n2 + " " + lIlIlIlIlIIlIIlIIllIIIIIlArray[n].lIlIlIlIlIIlIIlIIllIIIIIl(), System.currentTimeMillis());
                bl = true;
                break;
            }
            if (bl || lIlIlIlIlIIlIIlIIllIIIIIlArray[n].lIlIlIlIlIIlIIlIIllIIIIIl().isEmpty()) continue;
            this.lIlIIIIIIlIIIllllIllIIlII.put("§7[§a+§7]§a " + Math.abs(n3) + " " + lIlIlIlIlIIlIIlIIllIIIIIlArray[n].lIlIlIlIlIIlIIlIIllIIIIIl(), System.currentTimeMillis());
        }
        this.lllIIIIIlllIIlIllIIlIIIlI = lIlIlIlIlIIlIIlIIllIIIIIlArray;
        n = 0;
        if (this.lIlIIIIIIlIIIllllIllIIlII.size() >= 4) {
            this.lIlIIIIIIlIIIllllIllIIlII.clear();
            return;
        }
        for (Map.Entry entry : this.lIlIIIIIIlIIIllllIllIIlII.entrySet()) {
            if (((String)entry.getKey()).split(" ").length < 2) continue;
            boolean bl = false;
            for (Map.Entry entry2 : this.lIlIIIIIIlIIIllllIllIIlII.entrySet()) {
                if (((String)entry2.getKey()).split(" ").length < 2 || Math.abs((Long)entry.getValue() - (Long)entry2.getValue()) >= 1000L || ((String)entry2.getKey()).split(" ")[0].equalsIgnoreCase(((String)entry.getKey()).split(" ")[0]) || ((String)entry2.getKey()).split(" ").length <= 2 || ((String)entry.getKey()).split(" ").length <= 2 || !((String)entry2.getKey()).split(" ")[2].equalsIgnoreCase(((String)entry.getKey()).split(" ")[2])) continue;
                this.lIlIIIIIIlIIIllllIllIIlII.remove(entry.getKey());
                this.lIlIIIIIIlIIIllllIllIIlII.remove(entry2.getKey());
                bl = true;
                break;
            }
            if (bl) continue;
            if ((Long)entry.getValue() - this.IIlIllIlllllllIIlIIIllIIl <= TimeUnit.SECONDS.toMillis(2L)) {
                this.lIlIIIIIIlIIIllllIllIIlII.remove(entry.getKey());
                continue;
            }
            if (System.currentTimeMillis() - (Long)entry.getValue() >= TimeUnit.SECONDS.toMillis(2L)) {
                this.lIlIIIIIIlIIIllllIllIIlII.remove(entry.getKey());
                continue;
            }
            Ref.getFontRenderer().bridge$drawString((String)entry.getKey(), f, f2 + (float)n, ((String)entry.getKey()).contains("-") ? -65536 : -16711936, this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
            if (this.lIlIIIIIllIIlIIlIIlIlIIlI().name().toLowerCase().contains("bottom_")) {
                n -= 10;
                continue;
            }
            n += 10;
        }
    }
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("shadow", false), this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("skyblockOnly", false));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Item Tracker", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("itemTrackerChild", ImmutableList.of(ModuleCategory.ALL));
    }

    public ItemTrackerMod.lIlIlIlIlIIlIIlIIllIIIIIl[] lIlIlIlIlIIlIIlIIllIIIIIl(List var1) {
        ItemTrackerMod.lIlIlIlIlIIlIIlIIllIIIIIl[] var2 = new ItemTrackerMod.lIlIlIlIlIIlIIlIIllIIIIIl[var1.size()];

        for(int var3 = 0; var3 < var1.size(); ++var3) {
            if (var1.get(var3) != null) {
                var2[var3] = new ItemTrackerMod.lIlIlIlIlIIlIIlIIllIIIIIl((ItemStackBridge)var1.get(var3));
            }
        }

        return var2;
    }

    public static class lIlIlIlIlIIlIIlIIllIIIIIl {
        public String lIlIlIlIlIIlIIlIIllIIIIIl;
        public int IlllIIIIIIlllIlIIlllIlIIl;

        public lIlIlIlIlIIlIIlIIllIIIIIl(ItemStackBridge var1) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = var1.bridge$getDisplayName();
            this.IlllIIIIIIlllIlIIlllIlIIl = var1.bridge$getStackSize();
        }

        public boolean equals(Object var1) {
            if (var1 == this) {
                return true;
            } else if (!(var1 instanceof ItemTrackerMod.lIlIlIlIlIIlIIlIIllIIIIIl)) {
                return false;
            } else {
                ItemTrackerMod.lIlIlIlIlIIlIIlIIllIIIIIl var2 = (ItemTrackerMod.lIlIlIlIlIIlIIlIIllIIIIIl)var1;
                if (!var2.lIlIlIlIlIIlIIlIIllIIIIIl(this)) {
                    return false;
                } else if (this.IlllIIIIIIlllIlIIlllIlIIl() != var2.IlllIIIIIIlllIlIIlllIlIIl()) {
                    return false;
                } else {
                    String var3 = this.lIlIlIlIlIIlIIlIIllIIIIIl();
                    String var4 = var2.lIlIlIlIlIIlIIlIIllIIIIIl();
                    if (var3 == null) {
                        return var4 == null;
                    } else return var3.equals(var4);
                }
            }
        }

        public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object var1) {
            return var1 instanceof ItemTrackerMod.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public int hashCode() {
            boolean var1 = true;
            byte var2 = 1;
            int var4 = var2 * 59 + this.IlllIIIIIIlllIlIIlllIlIIl();
            String var3 = this.lIlIlIlIlIIlIIlIIllIIIIIl();
            var4 = var4 * 59 + (var3 == null ? 43 : var3.hashCode());
            return var4;
        }

        public lIlIlIlIlIIlIIlIIllIIIIIl(String var1, int var2) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
            this.IlllIIIIIIlllIlIIlllIlIIl = var2;
        }

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public int IlllIIIIIIlllIlIIlllIlIIl() {
            return this.IlllIIIIIIlllIlIIlllIlIIl;
        }
    }
}
