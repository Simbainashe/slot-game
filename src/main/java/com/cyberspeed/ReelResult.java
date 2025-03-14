package com.cyberspeed;

import com.cyberspeed.symbol.Symbol;

import java.util.List;

public class ReelResult {
   private final int stopPosition;
   private final List<Symbol> symbols;

    private ReelResult(int stopPosition, List<Symbol> symbols) {
        this.stopPosition = stopPosition;
        this.symbols = symbols;
    }

    public static ReelResult of(int stopPosition, List<Symbol> symbols) {
        return new ReelResult(stopPosition, symbols);
    }

    public int getStopPosition() {
        return stopPosition;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    @Override
    public String toString() {
        return "ReelResult{" +
                "stopPosition=" + stopPosition +
                ", symbols=" + symbols +
                '}';
    }
}
