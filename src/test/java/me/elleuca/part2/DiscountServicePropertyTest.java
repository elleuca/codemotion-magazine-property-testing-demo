package me.elleuca.part2;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test {@link DiscountService#canHaveDiscount(double)} method
 * with property-based testing.
 *
 * Range for {@link #noDiscountForPriceBelowThreshold} was chosen
 * to highlight when the actual method implementation can fail
 */
@RunWith(JUnitQuickcheck.class)
public class DiscountServicePropertyTest {

    @Property(trials = 500)
    public void noDiscountForPriceSurelyBelowThreshold(@InRange(minDouble = 00.00, maxDouble = 49.00) double price){
        DiscountService discountService = new DiscountService();
        boolean hasDiscount = discountService.canHaveDiscount(price);

        assertThat(hasDiscount, is(false));
    }

    @Property(trials = 500)
    public void noDiscountForPriceBelowThreshold(@InRange(minDouble = 49.00, maxDouble = 49.999) double price){
        DiscountService discountService = new DiscountService();
        boolean hasDiscount = discountService.canHaveDiscount(price);

        assertThat(hasDiscount, is(false));
    }

    @Property(trials = 500)
    public void discountForPriceBelowThreshold(@InRange(minDouble = 50.00, maxDouble = 5000.00) double price){
        DiscountService discountService = new DiscountService();
        boolean hasDiscount = discountService.canHaveDiscount(price);

        assertThat(hasDiscount, is(true));
    }

}