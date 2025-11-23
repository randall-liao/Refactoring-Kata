package com.gildedrose.item.strateties;

/**
 * Default quality strategy for normal items.
 *
 * Normal items decrease in quality by 1 each day before the sell-by date, and by 2
 * each day after the sell-by date has passed. Quality never goes negative; callers
 * should ensure they pass the current quality value and this strategy will only
 * reduce it when appropriate.
 */
public class DefaultQualityStrategy implements QualityStrategy
{

    private static final int DEFAULT_QUALITY_INCREMENT = 1;
    private static final int EXPIRED_QUALITY_INCREMENT = 2;

    /**
     * Reduce the quality of a normal item by the appropriate amount depending on sellIn.
     *
     * @param currentQuality the current quality value
     * @param sellIn the number of days remaining to sell the item; when negative, the item is expired
     * @return the updated quality value (never increased by this strategy)
     */
    public int update(int currentQuality, int sellIn) {
        if (currentQuality > 0) {
            if (sellIn < 0) {
                currentQuality -= EXPIRED_QUALITY_INCREMENT;
            } else {
                currentQuality -= DEFAULT_QUALITY_INCREMENT;
            }
        }
        return currentQuality;
    }
}
