package com.cyberspeed;

import java.util.List;

public class Reward {
    private final  double reward;

    private final List<SymbolPosition> rewardPositions;

    private final boolean bonus;

    private Reward(double reward, List<SymbolPosition> rewardPositions, boolean bonus) {
        this.reward = reward;
        this.rewardPositions = rewardPositions;
        this.bonus = bonus;
    }

    public static Reward of(double reward, List<SymbolPosition> rewardPositions, boolean bonus) {
        return new Reward(reward, rewardPositions, bonus);
    }

    public double getReward() {
        return reward;
    }

    public List<SymbolPosition> getRewardPositions() {
        return rewardPositions;
    }

    public boolean isBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "reward=" + reward +
                ", rewardPositions=" + rewardPositions +
                ", bonus=" + bonus +
                '}';
    }
}
