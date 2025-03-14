package com.cyberspeed.symbol;

class RewardMultiplierBonusSymbol implements BonusSymbol {
    private final String name;
    private final double rewardMultiplier;

    private RewardMultiplierBonusSymbol(String name, double rewardMultiplier) {
        this.name = name;
        this.rewardMultiplier = rewardMultiplier;
    }

    static RewardMultiplierBonusSymbol of(String name, double rewardMultiplier) {
        return new RewardMultiplierBonusSymbol(name, rewardMultiplier);
    }

    @Override
    public double apply(double finalReward) {
        return finalReward * rewardMultiplier;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isBonus() {
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
