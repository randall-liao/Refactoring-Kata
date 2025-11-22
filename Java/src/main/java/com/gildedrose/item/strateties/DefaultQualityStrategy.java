package com.gildedrose.item.strateties;

public class DefaultQualityStrategy implements QualityStrategy
{

    private static final int DEFAULT_QUALITY_INCREMENT = 1;
    private static final int EXPIRED_QUALITY_INCREMENT = 2;

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
