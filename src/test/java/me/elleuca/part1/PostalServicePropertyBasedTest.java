package me.elleuca.part1;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests the {@link PostalService#isFreeShipment(int)} method
 * with property based testing.
 */
@RunWith(JUnitQuickcheck.class)
public class PostalServicePropertyBasedTest {

    @Property(trials = 400)
    public void ShipmentNotFreeForParcelPriceBelow20Euros(@InRange(minInt = 0, maxInt = 19) int price) {
        PostalService postalService = new PostalService();
        boolean isFreeShipment = postalService.isFreeShipment(price);

        assertThat(isFreeShipment, is(false));
    }

    @Property(trials = 400)
    public void ShipmentIsFreeForParcelPriceAbove20Euros(@InRange(minInt = 20, maxInt = 4000) int price) {
        PostalService postalService = new PostalService();
        boolean isFreeShipment = postalService.isFreeShipment(price);

        assertThat(isFreeShipment, is(true));
    }

}
