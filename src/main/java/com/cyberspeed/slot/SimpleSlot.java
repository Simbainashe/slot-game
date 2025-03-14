package com.cyberspeed.slot;

import com.cyberspeed.BonusReward;
import com.cyberspeed.reel.Reel;
import com.cyberspeed.reel.ReelResult;
import com.cyberspeed.symbol.BonusSymbol;
import com.cyberspeed.symbol.Symbol;
import com.cyberspeed.wincombination.WinCombination;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleSlot implements Slot {
    private final List<Reel> reels;
    private final List<BonusSymbol> weightedBonusSymbols;
    private final List<WinCombination> winCombinations;

    private SimpleSlot(List<Reel> reels, List<BonusSymbol> weightedBonusSymbols, List<WinCombination> winCombinations) {
        this.reels = reels;
        this.weightedBonusSymbols = weightedBonusSymbols;
        this.winCombinations = winCombinations;
    }

    public static SimpleSlot of(List<Reel> reels, Map<BonusSymbol, Integer> bonusSymbolsProbabilities,
                                List<WinCombination> winCombinations) {
        List<BonusSymbol> weightedBonusSymbols = new ArrayList<>();
        for (BonusSymbol bonusSymbol : bonusSymbolsProbabilities.keySet()) {
            for (int i = 0; i < bonusSymbolsProbabilities.get(bonusSymbol); i++) {
                weightedBonusSymbols.add(bonusSymbol);
            }
        }
        return new SimpleSlot(reels, weightedBonusSymbols, winCombinations);
    }

    @Override
    public SlotResult spin(double bettingAmount) {
        BonusSymbol bonusSymbol = this.pickBonusSymbol();
        SlotDisplayResult slotDisplayResult = this.spin(bonusSymbol);
        List<StandardReward> standardRewards = new ArrayList<>();
        winCombinations.forEach(winCombination -> winCombination.evaluate(slotDisplayResult)
                .ifPresent(standardRewards::add));
        double totalRewards = standardRewards.stream()
                .map(StandardReward::getReward)
                .reduce(0.0, Double::sum) * bettingAmount;
        BonusReward bonusReward = bonusSymbol.isMiss() ? null : this.awardBonusReward(bonusSymbol, totalRewards, slotDisplayResult);
        if (bonusReward != null) {
            totalRewards += bonusReward.getReward();
        }
        return SlotResult.of(totalRewards,slotDisplayResult,standardRewards,bonusReward);
    }

    private SlotDisplayResult spin(BonusSymbol bonusSymbol) {
        List<ReelResult> reelResults = new ArrayList<>();
        for (Reel reel : reels) {
            reelResults.add(reel.spin());
        }
        int row = this.pickRow(reelResults.getFirst().getSymbols().size());
        int column = this.pickColumn(reelResults.size());
        reelResults.set(column, this.replaceStandardSymbol(reelResults.get(column), row, bonusSymbol));
        return SlotDisplayResult.of(reelResults);
    }

    private ReelResult replaceStandardSymbol(ReelResult reelResult, int position, BonusSymbol bonusSymbol) {
        List<Symbol> symbols = new ArrayList<>(reelResult.getSymbols());
        symbols.set(position, bonusSymbol);
        return ReelResult.of(symbols);
    }

    private int pickColumn(int numberOfColumns) {
        return (int) (Math.random() * numberOfColumns);
    }

    private int pickRow(int numberOfRows) {
        return (int) (Math.random() * numberOfRows);
    }

    private BonusSymbol pickBonusSymbol() {
        return weightedBonusSymbols.get((int) (Math.random() * weightedBonusSymbols.size()));
    }

    private BonusReward awardBonusReward(BonusSymbol bonusSymbol, double totalStandardRewards,
                                         SlotDisplayResult slotDisplayResult ) {
        double bonusReward = bonusSymbol.calculateBonusReward(totalStandardRewards);

        return BonusReward.of(bonusReward, this.createBonusPosition(bonusSymbol,slotDisplayResult));
    }

    private SymbolPosition createBonusPosition(BonusSymbol bonusSymbol, SlotDisplayResult slotDisplayResult) {
        for (int column = 0; column < reels.size(); column++) {
            List<Symbol> reelSymbols = slotDisplayResult.getReelResults().get(column).getSymbols();
            for (int row = 0; row < reelSymbols.size(); row++) {
                if (reelSymbols.get(row).equals(bonusSymbol)) {
                    return SymbolPosition.of(Position.of(row,column) ,bonusSymbol);
                }
            }
        }
        throw new IllegalStateException();
    }
}
