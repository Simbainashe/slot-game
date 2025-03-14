package com.cyberspeed;

import com.cyberspeed.reel.JsonReelRepository;
import com.cyberspeed.reel.ReelRepository;
import com.cyberspeed.slot.SimpleSlot;
import com.cyberspeed.slot.Slot;
import com.cyberspeed.slot.SlotResult;
import com.cyberspeed.symbol.BonusSymbol;
import com.cyberspeed.symbol.JsonSymbolRepository;
import com.cyberspeed.symbol.SymbolRepository;
import com.cyberspeed.wincombination.JsonWinCombinationRepository;
import com.cyberspeed.wincombination.WinCombinationRepository;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = getConfigFilePath(args);
        JSONObject jsonObject = readJsonFile(filePath);
        SymbolRepository symbolRepository = JsonSymbolRepository.from(jsonObject);
        WinCombinationRepository winCombinationRepository = JsonWinCombinationRepository.from(jsonObject);
        ReelRepository  reelRepository = JsonReelRepository.from(jsonObject);
        Map<BonusSymbol, Integer> bonusSymbolProbabilities = getBonusSymbolProbabilities(symbolRepository,jsonObject);
        Slot slot = SimpleSlot.of(reelRepository.getReels(), bonusSymbolProbabilities, winCombinationRepository.getWinCombinations());
        double betAmount = getBetAmount(args);
        SlotResult slotResult = slot.spin(betAmount);
        //convert slot result to json
    }

    private static Map<BonusSymbol, Integer> getBonusSymbolProbabilities(SymbolRepository symbolRepository, JSONObject jsonObject) {
        return null;
    }

    private static double getBetAmount(String[] args) {
        return 0;
    }

    private static String getConfigFilePath(String[] args) {
        // add implementation
        return null;
    }

    public static JSONObject readJsonFile(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return new JSONObject(content);
        } catch (IOException e) {
            System.err.println("Error reading config file: " + e.getMessage());
            throw new IllegalArgumentException("Error reading config file: " + e.getMessage());
        }
    }


}