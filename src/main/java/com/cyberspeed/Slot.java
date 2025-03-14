package com.cyberspeed;

import java.util.List;

public interface Slot {
    List<Reel> getReels();

    SlotResult spin(double bettingAmount);
}
