package com.cyberspeed.symbol;

class MissBonusSymbol extends AbstractSymbol implements BonusSymbol {

    private MissBonusSymbol(String name) {
        super(name);
    }

    static MissBonusSymbol of(String name) {
        return new MissBonusSymbol(name);
    }

    @Override
    public double increaseFinalReward(double finalReward) {
        return finalReward ;
    }

    @Override
    public boolean isMiss() {
        return true;
    }

    @Override
    public boolean isBonus() {
        return true;
    }
}
