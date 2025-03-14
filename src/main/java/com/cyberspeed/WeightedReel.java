package com.cyberspeed;

import com.cyberspeed.symbol.Symbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class WeightedReel implements Reel {
    private final List<List<Symbol>> positionsSymbols = new ArrayList<>();

    public WeightedReel(List<Map<Symbol, Integer>> reelPositionsSymbolProbabilities) {
        for (Map<Symbol, Integer> symbolProbability : reelPositionsSymbolProbabilities) {
            List<Symbol> positionSymbols = new ArrayList<>();
            for (Map.Entry<Symbol, Integer> symbolProbabilityEntry : symbolProbability.entrySet()) {
               for (int i = 0; i < symbolProbabilityEntry.getValue(); i++) {
                   positionSymbols.add(symbolProbabilityEntry.getKey());
               }
            }
            this.positionsSymbols.add(positionSymbols);
        }

    }

    @Override
    public ReelResult spin() {
        List<Symbol> landedSymbols = new ArrayList<>();
        for (List<Symbol> positionSymbols : this.positionsSymbols) {
            landedSymbols.add(positionSymbols.get((int) (Math.random() * positionSymbols.size())));
        }
        return ReelResult.of(Collections.unmodifiableList(landedSymbols));
    }
}
