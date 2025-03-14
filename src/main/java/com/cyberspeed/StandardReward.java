package com.cyberspeed;

import java.util.List;

public class StandardReward {
    private final  double reward;
    private final WinCombination winCombination;

    private final List<SymbolPosition> rewardPositions;

    private StandardReward(double reward, WinCombination winCombination, List<SymbolPosition> rewardPositions) {
        this.reward = reward;
        this.winCombination = winCombination;
        this.rewardPositions = rewardPositions;
    }

    public static StandardReward of(double reward, WinCombination winCombination, List<SymbolPosition> rewardPositions) {
        return new StandardReward(reward, winCombination, rewardPositions);
    }

    public double getReward() {
        return reward;
    }

    public WinCombination getWinCombination() {
        return winCombination;
    }

    public List<SymbolPosition> getRewardPositions() {
        return rewardPositions;
    }

    @Override
    public String toString() {
        return "StandardReward{" +
                "reward=" + reward +
                ", winCombination=" + winCombination +
                ", rewardPositions=" + rewardPositions +
                '}';
    }
}
