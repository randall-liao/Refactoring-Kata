package com.gildedrose.item.strateties;

import static com.gildedrose.item.Constants.MAX_ALLOWED_QUALITY;

/**
 * Quality strategy for "Aged Brie" items.
 *
 * "Aged Brie" increases in quality over time. This strategy increases the quality
 * by 1 on each update, but never allows the quality to exceed {@link
 * com.gildedrose.item.Constants#MAX_ALLOWED_QUALITY}.
 *
 * This class is implemented as a singleton and the shared instance is available via
 * {@link #INSTANCE}.
 */
public class AgedBrieQualityStrategy implements QualityStrategy {

    /** Singleton instance to avoid repeated allocations. */
    public final static AgedBrieQualityStrategy INSTANCE = new AgedBrieQualityStrategy();

    private AgedBrieQualityStrategy() {
    }

    /**
     * Increase the quality of Aged Brie by 1, respecting bounds.
     *
     * @param currentQuality the current quality value (expected >= 0)
     * @param sellIn the number of days remaining to sell the item (not used for Aged Brie)
     * @return the updated quality (incremented by 1 if below max, otherwise unchanged)
     */
    public int update(int currentQuality, int sellIn) {
        if (currentQuality < MAX_ALLOWED_QUALITY && currentQuality >= 0) {
            currentQuality++;
        }
        return currentQuality;
    }
}
