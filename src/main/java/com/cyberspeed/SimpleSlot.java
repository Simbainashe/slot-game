package com.cyberspeed;

import com.cyberspeed.symbol.BonusSymbol;

import java.util.ArrayList;
import java.util.List;

public class SimpleSlot implements Slot {
    private final List<Reel> reels;
    private final List<BonusSymbol> weightedBonusSymbols;

    public SimpleSlot(List<Reel> reels, List<BonusSymbol> weightedBonusSymbols) {
        this.reels = reels;
        this.weightedBonusSymbols = weightedBonusSymbols;
    }

    @Override
    public SlotResult spin(double bettingAmount) {
        List<ReelResult> reelResults = new ArrayList<>();
        for (Reel reel : reels) {
            reelResults.add(reel.spin());
        }
        BonusSymbol bonusSymbol = this.pickBonusSymbol();
        if (!bonusSymbol.isMiss()) {
            int row = this.pickRow(reelResults.getFirst().getSymbols().size());
            int column = this.pickColumn(reelResults.size());
            reelResults.set(column, this.replaceStandardSymbol(reelResults.get(column), row, bonusSymbol));
        }
        return null;
    }

    private ReelResult replaceStandardSymbol(ReelResult reelResult, int position, BonusSymbol bonusSymbol) {
        // create new reel result and replace symbol at index position by bonus symbol
        return null;
    }

    private int pickColumn(int size) {
        return 0;
    }

    private int pickRow(int size) {
        return 0;
    }

    private BonusSymbol pickBonusSymbol() {
        return weightedBonusSymbols.get((int) (Math.random() * weightedBonusSymbols.size()));
    }
}
