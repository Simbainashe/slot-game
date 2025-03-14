package com.cyberspeed.slot;

import com.cyberspeed.symbol.Symbol;

public class SymbolPosition {
   private final  Position position;
    private final Symbol symbol;

    private SymbolPosition(Position position, Symbol symbol) {
        this.position = position;
        this.symbol = symbol;
    }

    public static SymbolPosition of(Position position, Symbol symbol) {
        return new SymbolPosition(position, symbol);
    }

    public Position getPosition() {
        return position;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "SymbolPosition{" +
                "position=" + position +
                ", symbol=" + symbol +
                '}';
    }
}
