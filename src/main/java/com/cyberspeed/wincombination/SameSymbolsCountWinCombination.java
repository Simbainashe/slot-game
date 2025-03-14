package com.cyberspeed.wincombination;

import com.cyberspeed.slot.SlotDisplayResult;
import com.cyberspeed.slot.StandardReward;

import java.util.Optional;

class SameSymbolsCountWinCombination implements WinCombination {
    private final int count;
    private final  double rewardMultiplier;

    private SameSymbolsCountWinCombination(int count, double rewardMultiplier) {
        this.count = count;
        this.rewardMultiplier = rewardMultiplier;
    }

    public static SameSymbolsCountWinCombination of(int count, double rewardMultiplier) {
        return new SameSymbolsCountWinCombination(count, rewardMultiplier);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public Optional<StandardReward> evaluate(SlotDisplayResult displayResult) {
        return Optional.empty();
    }
}
