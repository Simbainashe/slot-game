package com.cyberspeed;

import java.util.List;

public class SlotDisplayResult {
    private final List<ReelResult> reelResults;

    public SlotDisplayResult(List<ReelResult> reelResults) {
        this.reelResults = reelResults;
    }

    public List<ReelResult> getReelResults() {
        return reelResults;
    }

    @Override
    public String toString() {
        return "SlotDisplayResult{" +
                "reelResults=" + reelResults +
                '}';
    }
}
