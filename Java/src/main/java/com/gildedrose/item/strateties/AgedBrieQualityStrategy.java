package com.gildedrose.item.strateties;

import static com.gildedrose.item.Constants.MAX_ALLOWED_QUALITY;

public class AgedBrieQualityStrategy implements QualityStrategy {

    public final static AgedBrieQualityStrategy INSTANCE = new AgedBrieQualityStrategy();

    private AgedBrieQualityStrategy() {
    }

    public int update(int currentQuality, int sellIn) {
        if (currentQuality < MAX_ALLOWED_QUALITY && currentQuality >= 0) {
            currentQuality++;
        }
        return currentQuality;
    }
}
