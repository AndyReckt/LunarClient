package com.moonsworth.lunar.bridge.minecraft.client.multiplayer;

import com.moonsworth.lunar.bridge.minecraft.scoreboard.ScoreboardBridge;
import com.moonsworth.lunar.bridge.minecraft.world.WorldBridge;

/**
 * @author Decencies
 * @since 10/07/2021 14:16
 */
public interface WorldClientBridge extends WorldBridge {
    public ScoreboardBridge bridge$getScoreboard();
}
