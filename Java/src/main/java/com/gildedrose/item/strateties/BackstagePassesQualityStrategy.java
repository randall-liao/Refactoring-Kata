package com.gildedrose.item.strateties;

import static com.gildedrose.item.Constants.MAX_ALLOWED_QUALITY;

/**
 * Quality strategy for "Backstage passes" items.
 *
 * Backstage passes increase in quality as the concert approaches:
 * - Increase by 1 normally
 * - Increase by 2 when there are 10 days or less
 * - Increase by 3 when there are 5 days or less
 * - Quality drops to 0 after the concert (sellIn < 0)
 *
 * The computed quality will not exceed {@link com.gildedrose.item.Constants#MAX_ALLOWED_QUALITY}.
 */
public class BackstagePassesQualityStrategy implements QualityStrategy {

    private static final int INCREASE_TWO_THRESHOLD_DAYS = 10;
    private static final int INCREASE_THREE_THRESHOLD_DAYS = 5;

    /**
     * Compute the new quality for Backstage passes based on remaining days.
     *
     * @param currentQuality the current quality value
     * @param sellIn the number of days remaining until the concert
     * @return the updated quality value (bounded by MAX_ALLOWED_QUALITY)
     */
    public int update(int currentQuality, int sellIn) {
        if (currentQuality > 0) {
            if (sellIn > INCREASE_TWO_THRESHOLD_DAYS) {
                currentQuality+=1;
            } else if (sellIn > INCREASE_THREE_THRESHOLD_DAYS) {
                currentQuality += 2;
            } else if (sellIn >= 0 ) {
                currentQuality += 3;
            } else {
                currentQuality = 0;
            }
        }
        if (currentQuality > MAX_ALLOWED_QUALITY) {
            currentQuality = MAX_ALLOWED_QUALITY;
        }
        return currentQuality;
    }
}
