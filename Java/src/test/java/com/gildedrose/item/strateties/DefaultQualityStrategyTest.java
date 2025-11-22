package com.gildedrose.item.strateties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DefaultQualityStrategyTest {

    private DefaultQualityStrategy defaultQualityStrategy;

    @BeforeEach
    void setUp() {
        defaultQualityStrategy = new DefaultQualityStrategy();
    }

    @Test
    void test_default_decrease() {
        // arrange
        int expectedResult = 5;
        int currentQuality = 6;
        int sellIn = 23;
        // act
        int actualResult = defaultQualityStrategy.update(currentQuality, sellIn);
        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_default_decrease_lower_boundary() {
        // arrange
        int expectedResult = 5;
        int currentQuality = 6;
        int sellIn = 0;
        // act
        int actualResult = defaultQualityStrategy.update(currentQuality, sellIn);
        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_expired_decrease_upper_boundary() {
        // arrange
        int expectedResult = 4;
        int currentQuality = 6;
        int sellIn = -1;
        // act
        int actualResult = defaultQualityStrategy.update(currentQuality, sellIn);
        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_expired_decrease() {
        // arrange
        int expectedResult = 4;
        int currentQuality = 6;
        int sellIn = -5;
        // act
        int actualResult = defaultQualityStrategy.update(currentQuality, sellIn);
        // assert
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 5",
        "0, 0, -4",
        "0, 0, 0"
    })
    void test_quality_always_greater_than_zero(int expectedResult, int currentQuality, int sellIn) {
        // act
        int actualResult = defaultQualityStrategy.update(currentQuality, sellIn);
        // assert
        assertEquals(expectedResult, actualResult);
    }

}
