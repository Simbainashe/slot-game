package com.cyberspeed.wincombination;

import com.cyberspeed.slot.SlotDisplayResult;
import com.cyberspeed.slot.StandardReward;

import java.util.Optional;

public interface WinCombination {
    String getName();

    Optional<StandardReward> evaluate(SlotDisplayResult displayResult);
}
