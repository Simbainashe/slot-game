package com.cyberspeed.symbol;

class ExtraBonusSymbol extends AbstractSymbol implements BonusSymbol {
    private final double extraBonus;

    private ExtraBonusSymbol(String name, double extraBonus) {
        super(name);
        this.extraBonus = extraBonus;
    }

    static ExtraBonusSymbol of(String name, double extraBonus) {
        return new ExtraBonusSymbol(name, extraBonus);
    }

    @Override
    public double increaseFinalReward(double finalReward) {
        return finalReward + extraBonus;
    }

    @Override
    public boolean isBonus() {
        return true;
    }
}
