package com.cyberspeed.symbol;

class StandardSymbol extends AbstractSymbol {
    private final double rewardMultiplier;

    private StandardSymbol(String name, double rewardMultiplier) {
        super(name);
        this.rewardMultiplier = rewardMultiplier;
    }

    static StandardSymbol of(String name, double rewardMultiplier) {
        return new StandardSymbol(name, rewardMultiplier);
    }

    public double getRewardMultiplier() {
        return rewardMultiplier;
    }

    @Override
    public boolean isBonus() {
        return false;
    }
}
