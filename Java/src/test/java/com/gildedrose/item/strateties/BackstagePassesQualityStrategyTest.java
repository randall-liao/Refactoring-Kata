package com.gildedrose.item.strateties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.gildedrose.item.Constants.MAX_ALLOWED_QUALITY;
import static org.junit.jupiter.api.Assertions.*;

class BackstagePassesQualityStrategyTest {

    private BackstagePassesQualityStrategy backstagePass;

    @BeforeEach
    void setUp() {
        backstagePass = new BackstagePassesQualityStrategy();
    }

    @Test
    void test_pass_drop_to_zero_when_expired(){
        // arrange
        int expectedResult = 0;
        int currentQuality = 3;
        int sellIn = -1;
        // act
        int actualResult = backstagePass.update(currentQuality, sellIn);
        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_pass_drop_to_zero_with_max_quality() {
        // arrange
        int expectedResult = 0;
        int sellIn = -1;
        // act
        int actualResult = backstagePass.update(MAX_ALLOWED_QUALITY, sellIn);
        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_pass_not_exceed_max() {
        // arrange
        int currentQuality = MAX_ALLOWED_QUALITY - 1;
        int sellIn = 4;
        // act
        int actualResult = backstagePass.update(currentQuality, sellIn);
        // assert
        assertEquals(MAX_ALLOWED_QUALITY, actualResult);
    }

    @Test
    void test_quality_increase_two_within_ten() {
        // arrange
        int expectedResult = 7;
        int currentQuality = 5;
        int sellIn = 8;
        // act
        int actualResult = backstagePass.update(currentQuality, sellIn);
        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_quality_increase_two_lower_boundary_value() {
        // arrange
        int expectedResult = 10;
        int currentQuality = 8;
        int sellIn = 6;
        // act
        int actualResult = backstagePass.update(currentQuality, sellIn);
        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_quality_increase_two_upper_boundary_value() {
        // arrange
        int expectedResult = 10;
        int currentQuality = 8;
        int sellIn = 10;
        // act
        int actualResult = backstagePass.update(currentQuality, sellIn);
        // assert
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
        "10, 7, 5", // upper boundary case
        "10, 7, 0",  // lower boundary case
        "10, 7, 3"
    })
    void test_quality_increase_three_cases(int expectedResult, int currentQuality, int sellIn) {
        int actualResult = backstagePass.update(currentQuality, sellIn);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_quality_increase_one_boundary() {
        // arrange
        int expectedResult = 10;
        int currentQuality = 9;
        int sellIn = 11;
        // act
        int actualResult = backstagePass.update(currentQuality, sellIn);
        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_quality_increase_one() {
        // arrange
        int expectedResult = 10;
        int currentQuality = 9;
        int sellIn = 24;
        // act
        int actualResult = backstagePass.update(currentQuality, sellIn);
        // assert
        assertEquals(expectedResult, actualResult);
    }

}
