package com.moonsworth.lunar.client.sba;

import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;

import java.util.Map;

public interface SkyblockWrapperBridge {
    boolean isSkyBlock();

    String location();

    int getMana();

    int getMaxMana();

    int getHealth();

    int getMaxHealth();

    int getDefence();

    int magmaSpawnSeconds();

    Integer getHealthUpdate();

    String getSkill();

    long getSkillFadeoutTime();

    ItemStackBridge getSkillItem();

    lIllIlIIIlIIIIIIIlllIlIll[] getSlayerProgress();

    ActivePowerOrb powerOrb();

    int tickers();

    int getMaxTickers();

    long nextRainMaker();

    Integer getEndstoneProtectorStage();

    int getEndstoneZealotCount();

    boolean canDetectSkull();

    long getLastDamaged();

    ItemStackBridge getWarpItem();

    boolean isHoldingRod();

    Map getBaitsInInventory();

    String getFeatureTitle();

    String getFeatureSubtitle();
}
