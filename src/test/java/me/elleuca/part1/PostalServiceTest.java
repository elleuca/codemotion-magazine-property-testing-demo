package me.elleuca.part1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link PostalService#isFreeShipment(int)} method
 * with trivial - and naive - unit testing
 */
public class PostalServiceTest {

    @Test
    public void testFreeShipmentIsNotApplied() {
        int actualPrice = 5;
        PostalService service = new PostalService();

        assertFalse(service.isFreeShipment(actualPrice));
    }

    @Test
    public void testFreeShipmentIsApplied() {
        int actualPrice = 24;
        PostalService service = new PostalService();

        assertTrue(service.isFreeShipment(actualPrice));
    }
}
