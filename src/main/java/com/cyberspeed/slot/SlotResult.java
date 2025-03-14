package com.cyberspeed.slot;

import com.cyberspeed.BonusReward;

import java.util.List;

public class SlotResult {
    private final double totalRewardAmount;
    private final SlotDisplayResult slotDisplayResult;
    private final List<StandardReward> standardRewards;
    private final BonusReward bonusReward;

    private SlotResult(double totalRewardAmount, SlotDisplayResult slotDisplayResult, List<StandardReward> standardRewards, BonusReward bonusReward) {
        this.totalRewardAmount = totalRewardAmount;
        this.slotDisplayResult = slotDisplayResult;
        this.standardRewards = standardRewards;
        this.bonusReward = bonusReward;
    }

    public static SlotResult of(double totalRewardAmount, SlotDisplayResult slotDisplayResult,
                                List<StandardReward> standardRewards, BonusReward bonusReward) {
        return new SlotResult(totalRewardAmount, slotDisplayResult, standardRewards, bonusReward);
    }

    public double getTotalRewardAmount() {
        return totalRewardAmount;
    }

    public SlotDisplayResult getSlotDisplayResult() {
        return slotDisplayResult;
    }

    public List<StandardReward> getStandardRewards() {
        return standardRewards;
    }

    public BonusReward getBonusReward() {
        return bonusReward;
    }

    @Override
    public String toString() {
        return "SlotResult{" +
                "totalRewardAmount=" + totalRewardAmount +
                ", slotDisplayResult=" + slotDisplayResult +
                ", standardRewards=" + standardRewards +
                ", bonusReward=" + bonusReward +
                '}';
    }
}
