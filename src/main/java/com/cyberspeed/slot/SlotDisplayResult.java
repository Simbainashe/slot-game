package com.cyberspeed.slot;

import com.cyberspeed.reel.ReelResult;

import java.util.List;

public class SlotDisplayResult {
    private final List<ReelResult> reelResults;

    private SlotDisplayResult(List<ReelResult> reelResults) {
        this.reelResults = reelResults;
    }

    public static SlotDisplayResult of(List<ReelResult> reelResults) {
        return new SlotDisplayResult(reelResults);
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
