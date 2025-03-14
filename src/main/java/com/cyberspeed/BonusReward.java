package com.cyberspeed;

import java.util.List;

public class StandardReward {
    private final  double reward;

    private final List<SymbolPosition> rewardPositions;

    private StandardReward(double reward, List<SymbolPosition> rewardPositions) {
        this.reward = reward;
        this.rewardPositions = rewardPositions;
    }

    public static StandardReward of(double reward, List<SymbolPosition> rewardPositions) {
        return new StandardReward(reward, rewardPositions);
    }

    public double getReward() {
        return reward;
    }

    public List<SymbolPosition> getRewardPositions() {
        return rewardPositions;
    }

    @Override
    public String toString() {
        return "StandardReward{" +
                "reward=" + reward +
                ", rewardPositions=" + rewardPositions +
                '}';
    }
}
