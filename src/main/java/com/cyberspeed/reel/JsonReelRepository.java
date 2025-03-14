package com.cyberspeed.reel;

import com.cyberspeed.symbol.Symbol;
import com.cyberspeed.symbol.SymbolRepository;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class JsonReelRepository implements ReelRepository {
    private final List<Reel> reels;

    private JsonReelRepository(List<Reel> reels) {
        this.reels = reels;
    }

    public static JsonReelRepository from(JSONObject jsonObject, SymbolRepository symbolRepository) {
        List<Reel> reels = new ArrayList<>();
        int numberOfColumns = jsonObject.getInt("columns");
        int numberOfRows = jsonObject.getInt("rows");
        List<List<Map<Symbol, Integer>>> columnsProbabilities = new ArrayList<>(Collections.nCopies(numberOfColumns,
                new ArrayList<>(Collections.nCopies(numberOfRows, new HashMap<>()))));
        JSONArray jsonArray = jsonObject.getJSONArray("standard_symbols");
        jsonArray.forEach(jsonElement -> {
            JSONObject object = (JSONObject) jsonElement;
            Map<Symbol, Integer> probabilities = columnsProbabilities.get(object.getInt("column"))
                    .get(object.getInt("row"));
            for (String key : object.keySet()) {
                Symbol symbol = symbolRepository.getSymbol(key);
                probabilities.put(symbol, object.getInt(symbol.getName()));
            }

        });
        columnsProbabilities.forEach(maps -> reels.add(WeightedReel.of(maps)));
        return new JsonReelRepository(reels);
    }


    @Override
    public List<Reel> getReels() {
        return Collections.unmodifiableList(reels);
    }
}
