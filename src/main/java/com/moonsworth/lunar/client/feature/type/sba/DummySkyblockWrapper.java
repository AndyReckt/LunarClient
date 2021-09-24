package com.moonsworth.lunar.client.feature.type.sba;

import com.google.common.collect.ImmutableMap;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.sba.ActivePowerOrb;
import com.moonsworth.lunar.client.sba.SkyblockWrapperBridge;
import com.moonsworth.lunar.client.sba.lIllIlIIIlIIIIIIIlllIlIll;

import java.util.Map;

public class DummySkyblockWrapper implements SkyblockWrapperBridge {
    @Override
    public boolean isSkyBlock() {
        return false;
    }

    @Override
    public String location() {
        return this.isSkyBlock() ? "" : "TEST";
    }

    @Override
    public int getMana() {
        return 10;
    }

    @Override
    public int getMaxMana() {
        return 100;
    }

    @Override
    public int getHealth() {
        return 10;
    }

    @Override
    public int getMaxHealth() {
        return 100;
    }

    @Override
    public int getDefence() {
        return 100;
    }

    @Override
    public int magmaSpawnSeconds() {
        return 100;
    }

    @Override
    public Integer getHealthUpdate() {
        return null;
    }

    @Override
    public String getSkill() {
        return null;
    }

    @Override
    public long getSkillFadeoutTime() {
        return -1L;
    }

    @Override
    public ItemStackBridge getSkillItem() {
        return null;
    }

    @Override
    public lIllIlIIIlIIIIIIIlllIlIll[] getSlayerProgress() {
        return new lIllIlIIIlIIIIIIIlllIlIll[] {new lIllIlIIIlIIIIIIIlllIlIll() {

                @Override
                public String getPercent() {
                    return "10";
                }

                @Override
                public String getDefence() {
                    return "10";
                }

                @Override
                public ItemStackBridge getItemStack() {
                    return Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$bow());
                }
            }, new lIllIlIIIlIIIIIIIlllIlIll() {

                @Override
                public String getPercent() {
                    return "20";
                }

                @Override
                public String getDefence() {
                    return "100";
                }

                @Override
                public ItemStackBridge getItemStack() {
                    return Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$diamond_sword());
                }
            }, new lIllIlIIIlIIIIIIIlllIlIll() {

                @Override
                public String getPercent() {
                    return "100";
                }

                @Override
                public String getDefence() {
                    return "10";
                }

                @Override
                public ItemStackBridge getItemStack() {
                    return Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$potionItem());
                }
            }, new lIllIlIIIlIIIIIIIlllIlIll() {

                @Override
                public String getPercent() {
                    return "90";
                }

                @Override
                public String getDefence() {
                    return "10";
                }

                @Override
                public ItemStackBridge getItemStack() {
                    return Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$diamond_boots());
                }
            }
        };
    }

    @Override
    public ActivePowerOrb powerOrb() {
        return null;
    }

    @Override
    public int tickers() {
        return 3;
    }

    @Override
    public int getMaxTickers() {
        return 4;
    }

    @Override
    public long nextRainMaker() {
        return System.currentTimeMillis() + 5000L;
    }

    @Override
    public Integer getEndstoneProtectorStage() {
        return 10;
    }

    @Override
    public int getEndstoneZealotCount() {
        return 100;
    }

    @Override
    public boolean canDetectSkull() {
        return true;
    }

    @Override
    public long getLastDamaged() {
        return System.currentTimeMillis();
    }

    @Override
    public ItemStackBridge getWarpItem() {
        return null;
    }

    @Override
    public boolean isHoldingRod() {
        return true;
    }

    @Override
    public Map<String, Integer> getBaitsInInventory() {
        return ImmutableMap.of(
                   EnumChatColor.IllIllIIIllIIIlIlIlIIIIll + "Minnow Bait", 5,
                   EnumChatColor.IllIllIIIllIIIlIlIlIIIIll + "Fish Bait", 8
               );
    }

    @Override
    public String getFeatureTitle() {
        return "";
    }

    @Override
    public String getFeatureSubtitle() {
        return "";
    }
}