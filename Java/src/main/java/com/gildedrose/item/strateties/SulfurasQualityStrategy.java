package com.gildedrose.item.strateties;

/**
 * Quality strategy for the legendary item "Sulfuras".
 *
 * "Sulfuras" never changes in quality and never needs to be sold. This strategy
 * therefore returns the incoming quality unchanged.
 */
public class SulfurasQualityStrategy implements QualityStrategy {


    /**
     * Return the quality unchanged for Sulfuras.
     *
     * @param currentQuality the current quality value (Sulfuras typically has quality 80)
     * @param sellIn the number of days remaining to sell the item (ignored)
     * @return the same quality value passed in
     */
    public int update(int currentQuality, int sellIn) {
        return currentQuality;
    }
}
