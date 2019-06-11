package me.elleuca.part2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * Tests {@link DiscountService#canHaveDiscount(double)} method
 * with simple - and naive - unit testing
 */
public class DiscountServiceTest {
    @Test
    public void noDiscountForFuelingPriceBelow50Euros() {
        double price = 49.99;

        DiscountService discountService = new DiscountService();
        boolean hasDiscount = discountService.canHaveDiscount(price);

        assertThat(hasDiscount, is(false));
    }

    @Test
    public void hasDiscountForFuelingPriceAbove50Euros() {
        double price = 50.01;

        DiscountService discountService = new DiscountService();
        boolean hasDiscount = discountService.canHaveDiscount(price);

        assertThat(hasDiscount, is(true));
    }

}