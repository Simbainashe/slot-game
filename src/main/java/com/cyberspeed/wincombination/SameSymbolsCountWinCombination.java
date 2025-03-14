package com.cyberspeed.wincombination;

import com.cyberspeed.slot.SlotDisplayResult;
import com.cyberspeed.slot.StandardReward;

import java.util.Optional;

class SameSymbolsCountWinCombination implements WinCombination {
    private final int count;
    private final  double rewardMultiplier;
    private final String name;

    private SameSymbolsCountWinCombination(int count, double rewardMultiplier, String name) {
        this.count = count;
        this.rewardMultiplier = rewardMultiplier;
        this.name = name;
    }

    public static SameSymbolsCountWinCombination of(int count, double rewardMultiplier, String name) {
        return new SameSymbolsCountWinCombination(count, rewardMultiplier, name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Optional<StandardReward> evaluate(SlotDisplayResult displayResult) {
        return Optional.empty();
    }
}
