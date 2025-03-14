package com.cyberspeed.reel;

import com.cyberspeed.symbol.Symbol;

import java.util.Collections;
import java.util.List;

public class ReelResult {
   private final List<Symbol> symbols;

    private ReelResult( List<Symbol> symbols) {
        this.symbols = Collections.unmodifiableList(symbols);
    }

    public static ReelResult of(List<Symbol> symbols) {
        return new ReelResult(symbols);
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    @Override
    public String toString() {
        return "ReelResult{" +
                ", symbols=" + symbols +
                '}';
    }
}
