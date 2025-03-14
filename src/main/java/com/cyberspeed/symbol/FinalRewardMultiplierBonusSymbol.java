package com.cyberspeed.symbol;

class FinalRewardMultiplierBonusSymbol extends AbstractSymbol implements BonusSymbol {
    private final double rewardMultiplier;

    private FinalRewardMultiplierBonusSymbol(String name, double rewardMultiplier) {
       super(name);
        this.rewardMultiplier = rewardMultiplier;
    }

    static FinalRewardMultiplierBonusSymbol of(String name, double rewardMultiplier) {
        return new FinalRewardMultiplierBonusSymbol(name, rewardMultiplier);
    }

    @Override
    public double increaseFinalReward(double finalReward) {
        return finalReward * rewardMultiplier;
    }

    @Override
    public boolean isBonus() {
        return true;
    }

}
