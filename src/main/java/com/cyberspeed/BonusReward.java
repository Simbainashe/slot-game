package com.cyberspeed;

import com.cyberspeed.slot.SymbolPosition;

public class BonusReward {
    private final  double reward;

    private final SymbolPosition bonusSymbolPosition;

    private BonusReward(double reward, SymbolPosition bonusSymbolPosition) {
        this.reward = reward;
        this.bonusSymbolPosition = bonusSymbolPosition;
    }

    public static BonusReward of(double reward, SymbolPosition bonusSymbolPosition) {
        return new BonusReward(reward, bonusSymbolPosition);
    }

    public double getReward() {
        return reward;
    }

    public SymbolPosition getBonusSymbolPosition() {
        return bonusSymbolPosition;
    }

    @Override
    public String toString() {
        return "BonusReward{" +
                "reward=" + reward +
                ", bonusSymbolPosition=" + bonusSymbolPosition +
                '}';
    }
}
