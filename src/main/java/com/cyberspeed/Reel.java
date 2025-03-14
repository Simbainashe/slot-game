package com.cyberspeed;

import com.cyberspeed.symbol.Symbol;

import java.util.List;

public interface Reel {
    List<Symbol> getSymbols();

    List<ReelResult> spin(int numberOfRows);
}
