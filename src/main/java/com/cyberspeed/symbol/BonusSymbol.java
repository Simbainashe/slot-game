package com.cyberspeed.symbol;

public interface BonusSymbol extends Symbol {
    double calculateBonusReward(double finalReward);

    boolean isMiss();
}
