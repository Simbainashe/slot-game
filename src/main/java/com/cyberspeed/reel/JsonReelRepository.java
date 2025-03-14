package com.cyberspeed.reel;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonReelRepository implements ReelRepository {
    private final List<Reel> reels;

    private JsonReelRepository(List<Reel> reels) {
        this.reels = reels;
    }

    public static JsonReelRepository from(JSONObject jsonObject) {
        List<Reel> reels = new ArrayList<>();

        return new JsonReelRepository(reels);
    }

    @Override
    public List<Reel> getReels() {
        return List.of();
    }
}
