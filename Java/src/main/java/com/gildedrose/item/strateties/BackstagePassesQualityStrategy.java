package com.gildedrose.item.strateties;

import static com.gildedrose.item.Constants.MAX_ALLOWED_QUALITY;

public class BackstagePassesQualityStrategy  implements  QualityStrategy
{
    public int update(int currentQuality, int sellIn) {
        if (currentQuality < MAX_ALLOWED_QUALITY && currentQuality > 0) {
            if (sellIn < 0) {
                currentQuality =0;
            } else if (sellIn <=5 ) {
                currentQuality += 3;
            } else if (sellIn <= 10) {
                currentQuality = 2;
            }
        }
        return currentQuality;
    }
}
