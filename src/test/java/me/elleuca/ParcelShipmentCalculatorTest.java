package me.elleuca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParcelShipmentCalculatorTest {
    @Test
    public void ShipmentNotFreeForParcelPriceBelow20Euros() {
        int price = 5;

        PostalService postalService = new PostalService();
        boolean isFreeShipment = postalService.isFreeShipment(price);

        assertThat(isFreeShipment, is(false));
    }

    @Test
    public void ShipmentFreeForParcelPriceAbove20Euros() {
        int price = 20;

        PostalService postalService = new PostalService();
        boolean isFreeShipment = postalService.isFreeShipment(price);

        assertThat(isFreeShipment, is(true));
    }
}
