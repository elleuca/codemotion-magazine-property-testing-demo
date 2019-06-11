package me.elleuca.part2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests {@link DiscountService#canHaveDiscount(double)} method
 * with parametrized JUnit execution.
 *
 * This still provides pre-chosen values as input on any execution.
 */
@RunWith(Parameterized.class)
public class DiscountServiceParametrizedTest {

    private double price;
    private boolean hasDiscount;

    public DiscountServiceParametrizedTest(double price, boolean hasDiscount) {
        this.price = price;
        this.hasDiscount = hasDiscount;
    }

    @Test
    public void testDiscountForFuelingPrice() {

        DiscountService discountService = new DiscountService();
        boolean hasDiscount = discountService.canHaveDiscount(this.price);

        assertThat(hasDiscount, is(this.hasDiscount));
    }

    @Parameterized.Parameters(name = "If price is {0}, has discount should be {1} ")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5, false},
                {49, false},
                {49.99, false},
                {50, true},
                {50.00, true},
                {50.01, true},
                {51, true},
                {Integer.MAX_VALUE, true}
        });
    }

}