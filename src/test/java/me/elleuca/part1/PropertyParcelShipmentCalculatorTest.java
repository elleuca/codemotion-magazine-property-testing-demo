package me.elleuca.part1;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests the {@link PostalService#isFreeShipment(double)} method
 * with property based testing.
 *
 * Range for {@link #ShipmentNotFreeForParcelPriceBelow20Euros} is so
 * in order to show that this test fails when an unexpected price
 * (i.e. 19.99 < price < 20.00) is provided in input without
 * running more and more attempts :-)
 */
@RunWith(JUnitQuickcheck.class)
public class PropertyParcelShipmentCalculatorTest {

    @Property(trials = 400)
    public void ShipmentNotFreeForParcelPriceBelow20Euros(@InRange(minDouble = 19.90, maxDouble = 19.999) double price) {
        System.out.println(price);
        PostalService postalService = new PostalService();
        boolean isFreeShipment = postalService.isFreeShipment(price);

        assertThat(isFreeShipment, is(false));
    }

    @Property(trials = 400)
    public void ShipmentFreeForParcelPriceAbove20Euros(@InRange(minDouble = 20.0, maxDouble = 1.0E6) double price) {
        PostalService postalService = new PostalService();
        boolean isFreeShipment = postalService.isFreeShipment(price);

        assertThat(isFreeShipment, is(true));
    }



}
