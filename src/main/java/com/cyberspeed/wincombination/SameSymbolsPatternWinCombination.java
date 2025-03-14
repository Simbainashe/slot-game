package com.cyberspeed.wincombination;

import com.cyberspeed.slot.Position;
import com.cyberspeed.slot.SlotDisplayResult;
import com.cyberspeed.slot.StandardReward;

import java.util.List;
import java.util.Optional;

public class SameSymbolsPatternWinCombination implements WinCombination {
    private final List<List<Position>> patterns;
    private final  double rewardMultiplier;

    private SameSymbolsPatternWinCombination(List<List<Position>> patterns, double rewardMultiplier) {
        this.patterns = patterns;
        this.rewardMultiplier = rewardMultiplier;
    }

    public static SameSymbolsPatternWinCombination of(List<List<Position>> patterns, double rewardMultiplier) {
        return new SameSymbolsPatternWinCombination(patterns, rewardMultiplier);
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
