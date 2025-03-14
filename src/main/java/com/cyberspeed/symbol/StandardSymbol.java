package com.cyberspeed;

class StandardSymbol implements Symbol {
    private final String name;

    private StandardSymbol(String name) {
        this.name = name;
    }

    static StandardSymbol of(String name) {
        return new StandardSymbol(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isBonus() {
        return false;
    }
}
