package com.cyberspeed;

import com.cyberspeed.symbol.Symbol;

public class SymbolPosition {
    private final int rowIndex;
    private final int columnIndex;
    private final Symbol symbol;

    private SymbolPosition(int rowIndex, int columnIndex, Symbol symbol) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.symbol = symbol;
    }

    public static SymbolPosition of(int rowIndex, int columnIndex, Symbol symbol) {
        return new SymbolPosition(rowIndex, columnIndex, symbol);
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "SymbolPosition{" +
                "rowIndex=" + rowIndex +
                ", columnIndex=" + columnIndex +
                ", symbol=" + symbol +
                '}';
    }
}
