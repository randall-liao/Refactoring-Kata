package com.gildedrose.item.strateties;

/**
 * Contract for strategies that compute the new quality for an item during an update.
 *
 * Implementations encapsulate item-specific rules (for example: Aged Brie, Sulfuras,
 * Backstage passes, or default items).
 */
public interface QualityStrategy {

    /**
     * Compute the updated quality for an item.
     *
     * @param currentQuality the current quality of the item
     * @param sellIn the number of days remaining to sell the item (may affect the rule)
     * @return the new quality value after applying the strategy's rules
     */
    int update(int currentQuality, int sellIn);

}
