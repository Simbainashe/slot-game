package com.cyberspeed.wincombination;

import com.cyberspeed.slot.Position;
import com.cyberspeed.slot.SlotDisplayResult;
import com.cyberspeed.slot.StandardReward;

import java.util.List;
import java.util.Optional;

public class SameSymbolsPatternWinCombination implements WinCombination {
    private final List<List<Position>> patterns;
    private final  double rewardMultiplier;
    private final String name;


    private SameSymbolsPatternWinCombination(List<List<Position>> patterns, double rewardMultiplier, String name) {
        this.patterns = patterns;
        this.rewardMultiplier = rewardMultiplier;
        this.name = name;
    }

    public static SameSymbolsPatternWinCombination of(List<List<Position>> patterns, double rewardMultiplier,
                                                      String name) {
        return new SameSymbolsPatternWinCombination(patterns, rewardMultiplier, name);
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
