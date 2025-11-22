package com.gildedrose.item.strateties;

import static com.gildedrose.item.Constants.MAX_ALLOWED_QUALITY;

public class BackstagePassesQualityStrategy implements QualityStrategy {

    private static final int INCREASE_TWO_THRESHOLD_DAYS = 10;
    private static final int INCREASE_THREE_THRESHOLD_DAYS = 5;
    private static final int CONCERT_DATE = 0;

    public int update(int currentQuality, int sellIn) {
        if (currentQuality > 0) {
            if (sellIn < CONCERT_DATE) {
                currentQuality = 0;
            } else if (sellIn <= INCREASE_THREE_THRESHOLD_DAYS) {
                currentQuality += 3;
            } else if (sellIn <= INCREASE_TWO_THRESHOLD_DAYS) {
                currentQuality += 2;
            }
        }
        if (currentQuality > MAX_ALLOWED_QUALITY) {
            currentQuality = MAX_ALLOWED_QUALITY;
        }
        return currentQuality;
    }
}
