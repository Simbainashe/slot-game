package com.cyberspeed.symbol;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonSymbolRepository implements SymbolRepository {
    private final Map<String, Symbol> symbols = new HashMap<>();

    private JsonSymbolRepository(JSONObject jsonObject) {
        this.readSymbols(jsonObject.getJSONObject("symbols"));
    }

    public static JsonSymbolRepository from(JSONObject jsonObject) {
        return new JsonSymbolRepository(jsonObject);
    }

    protected void readSymbols(JSONObject symbolsJsonObject) {
        symbolsJsonObject.keySet().forEach(key -> {
            symbols.put(key, this.createSymbol(key, symbolsJsonObject.getJSONObject(key)));
        });
    }

    private Symbol createSymbol(String symbolName, JSONObject jsonObject) {
        String symbolType = jsonObject.getString("type");
        if (symbolType.equals("standard")) {
            return StandardSymbol.of(symbolName, jsonObject.getDouble("reward_multiplier"));
        }

        String impact = jsonObject.getString("impact");

        if (impact.equals("multiply_reward")) {
            return FinalRewardMultiplierBonusSymbol.of(symbolName, jsonObject.getDouble("reward_multiplier"));
        } else if (impact.equals("extra_bonus")) {
            return ExtraBonusSymbol.of(symbolName, jsonObject.getDouble("extra"));
        } else {
            return MissBonusSymbol.of(symbolName);
        }
    }

    @Override
    public Symbol getSymbol(String name) {
        return symbols.get(name);
    }
}
