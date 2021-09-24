package com.moonsworth.lunar.bridge.minecraft.scoreboard;

import java.util.Collection;

/**
 * @author Decencies
 * @since 10/07/2021 14:16
 */
public interface ScoreboardBridge {
    ScorePlayerTeamBridge bridge$getPlayersTeam(String var1);

    ScoreObjectiveBridge bridge$getObjectiveInDisplaySlot(int var1);

    Collection<ScoreBridge> bridge$getSortedScores(ScoreObjectiveBridge var1);

    ScoreBridge bridge$getValueFromObjective(String var1, ScoreObjectiveBridge var2);
}

