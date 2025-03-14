package com.cyberspeed;

import com.cyberspeed.symbol.JsonSymbolRepository;
import com.cyberspeed.symbol.SymbolRepository;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String filePath = getConfigFilePath(args);
        JSONObject jsonObject = readJsonFile(filePath);
        SymbolRepository symbolRepository = JsonSymbolRepository.from(jsonObject);
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