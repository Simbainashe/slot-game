package com.cyberspeed;

import java.util.Optional;

public interface WinCombination {
    String getName();

    Optional<StandardReward> evaluate(SlotDisplayResult displayResult);
}
