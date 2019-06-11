package me.elleuca.part1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests the {@link PostalService#isFreeShipment(double)} method
 * using parametrized JUnit execution.
 *
 * This allows to check more relevant (but "static") input values
 */
@RunWith(Parameterized.class)
public class ParametrizedParcelShipmentCalculatorTest {

    private double price;
    private boolean isFreeShipment;

    public ParametrizedParcelShipmentCalculatorTest(double price, boolean isFreeShipment) {
        this.price = price;
        this.isFreeShipment = isFreeShipment;
    }

    @Test
    public void ShipmentParcelOnPriceTest() {
        PostalService postalService = new PostalService();
        boolean actualFree = postalService.isFreeShipment(this.price);

        assertThat(actualFree, is(this.isFreeShipment));
    }

    @Parameterized.Parameters(name = "If price is {0}, free shipment should be {1} ")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5, false},
                {19, false},
                {19.99, false},
                {20, true},
                {20.00, true},
                {20.01, true},
                {21, true},
                {Integer.MAX_VALUE, true}
        });
    }
}
