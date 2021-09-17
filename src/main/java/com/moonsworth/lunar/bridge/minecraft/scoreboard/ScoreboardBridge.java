package com.moonsworth.lunar.bridge.minecraft.scoreboard;

import java.util.Collection;

/**
 * @author Decencies
 * @since 10/07/2021 14:16
 */
public interface ScoreboardBridge {
    public ScorePlayerTeamBridge bridge$getPlayersTeam(String var1);

    public ScoreObjectiveBridge bridge$getObjectiveInDisplaySlot(int var1);

    public Collection bridge$getSortedScores(ScoreObjectiveBridge var1);

    public ScoreBridge bridge$getValueFromObjective(String var1, ScoreObjectiveBridge var2);
}

