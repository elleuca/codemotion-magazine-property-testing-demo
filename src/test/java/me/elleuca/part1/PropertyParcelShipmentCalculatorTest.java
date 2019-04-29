package me.elleuca;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import me.elleuca.part1.PostalService;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitQuickcheck.class)
public class PropertyParcelShipmentCalculatorTest {

    @Property(trials = 400)
    public void ShipmentNotFreeForParcelPriceBelow20Euros(@InRange(minDouble = 19.00, maxDouble = 19.999) double price) {
        PostalService postalService = new PostalService();
        boolean isFreeShipment = postalService.isFreeShipment(price);

        assertThat(isFreeShipment, is(false));
    }

    @Property(trials = 400)
    public void ShipmentFreeForParcelPriceAbove20Euros(@InRange(minDouble = 20.0, maxDouble = 1.0E10) double price) {
        PostalService postalService = new PostalService();
        boolean isFreeShipment = postalService.isFreeShipment(price);

        assertThat(isFreeShipment, is(true));
    }



}
