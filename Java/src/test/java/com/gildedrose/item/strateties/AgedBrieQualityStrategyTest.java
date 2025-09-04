package com.gildedrose.item.strateties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.gildedrose.item.Constants.MAX_ALLOWED_QUALITY;
import static org.junit.jupiter.api.Assertions.*;

class AgedBrieQualityStrategyTest {

    private final AgedBrieQualityStrategy agedBrieQualityStrategy = AgedBrieQualityStrategy.INSTANCE;

    @Test
    void update_aged_brie_quality() {
        int currentQuality = 5;
        int expectedQualityAfterUpdate = 6;
        int sellIn = 1;

        int result = this.agedBrieQualityStrategy.update(currentQuality, sellIn);

        assertEquals(expectedQualityAfterUpdate, result);
    }

    @Test
    void update_aged_brie_quality_at_max_allowed_quality() {
        int currentQuality = MAX_ALLOWED_QUALITY;
        int expectedQualityAfterUpdate = MAX_ALLOWED_QUALITY;
        int sellIn = 1;

        int result = this.agedBrieQualityStrategy.update(currentQuality, sellIn);

        assertEquals(expectedQualityAfterUpdate, result);
    }

    @Test
    void update_aged_brie_quality_at_boundary_max_allowed_quality() {
        int currentQuality = MAX_ALLOWED_QUALITY - 1;
        int expectedQualityAfterUpdate = MAX_ALLOWED_QUALITY;
        int sellIn = 1;

        int result = this.agedBrieQualityStrategy.update(currentQuality, sellIn);

        assertEquals(expectedQualityAfterUpdate, result);
    }

    @Test
    void update_aged_brie_quality_at_zero_quality() {
        int currentQuality = 0;
        int expectedQualityAfterUpdate = 1;
        int sellIn = 1;

        int result = this.agedBrieQualityStrategy.update(currentQuality, sellIn);

        assertEquals(expectedQualityAfterUpdate, result);
    }


}
