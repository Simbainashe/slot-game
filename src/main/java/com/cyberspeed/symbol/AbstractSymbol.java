package com.cyberspeed.symbol;

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
 }
