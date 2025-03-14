package com.cyberspeed.wincombination;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonWinCombinationRepository implements WinCombinationRepository {
    private final List<WinCombination> winCombinations;

    private JsonWinCombinationRepository(List<WinCombination> winCombinations) {
        this.winCombinations = winCombinations;
    }

    public static JsonWinCombinationRepository from(JSONObject jsonObject) {
        List<WinCombination> winCombinations = new ArrayList<>();
        // read win combinations from jsonObject
        return new JsonWinCombinationRepository(winCombinations);
    }

    @Override
    public List<WinCombination> getWinCombinations() {
        return winCombinations;
    }


}
