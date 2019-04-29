package me.elleuca;

import me.elleuca.part1.PostalService;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParcelShipmentCalculatorTest {
    @Test
    public void ShipmentNotFreeForParcelPriceBelow20Euros() {
        double price = 19.99;

        PostalService postalService = new PostalService();
        boolean isFreeShipment = postalService.isFreeShipment(price);

        assertThat(isFreeShipment, is(false));
    }

    @Test
    public void ShipmentFreeForParcelPriceAbove20Euros() {
        double price = 20.01;

        PostalService postalService = new PostalService();
        boolean isFreeShipment = postalService.isFreeShipment(price);

        assertThat(isFreeShipment, is(true));
    }
}
