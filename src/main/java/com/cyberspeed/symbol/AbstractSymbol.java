package com.cyberspeed.symbol;

import java.util.Objects;

abstract class AbstractSymbol implements Symbol {
     private  final String name;

     AbstractSymbol(String name) {
         this.name = name;
     }

     @Override
     public String getName() {
         return name;
     }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractSymbol that = (AbstractSymbol) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
