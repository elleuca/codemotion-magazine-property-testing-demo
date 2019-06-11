package me.elleuca.part3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assume.assumeThat;

/**
 * Test {@link FidelityPoints#redeemBonus} method with
 * simple unit tests.
 *
 * The {@link #generateCartWithSpecialProductCount(int)} helper methods
 * create a *simple* list of products that can match the expected behavior.
 *
 */
public class FidelityPointsTest {

    /**
     * Generates a list of N+2 {@link Product} where N is the number of
     * products with 1 bonus point for each and remaining 2 items has no
     * bonus points.
     *
     * @param productsWithBonusCount how many products with 1 bonus point for each in list
     * @return list of products
     */
    private static List<Product> generateCartWithSpecialProductCount(int productsWithBonusCount) {
        List<Product> products = new ArrayList<>();
        int counter = productsWithBonusCount;

        for (int i = 0; i < productsWithBonusCount + 2; i++) {
            int bonus = counter > 0 ? 1 : 0;
            products.add(new Product(UUID.randomUUID(), "Name", bonus));
            counter--;
        }
        return products;
    }

    /**
     * Verify we cannot redeem the bonus if we are under the bonus threshold
     */
    @Test
    public void noFidelityPointsIfYouBoughtLessThan3SpecialProducts() {
        FidelityPoints fidelityPoints = new FidelityPoints(UUID.randomUUID(), generateCartWithSpecialProductCount(2));
        assumeThat(fidelityPoints.bonusPoints(), lessThan(FidelityPoints.BONUS_PRODUCTS_THRESHOLD));

        assertThat(fidelityPoints.redeemBonus(), is(false));
    }

    /**
     * Verify we can redeem the bonus if we are above the bonus threshold
     */
    @Test
    public void earnFidelityPointsIfYouBoughtMoreThan3SpecialProducts() {
        FidelityPoints fidelityPoints = new FidelityPoints(UUID.randomUUID(), generateCartWithSpecialProductCount(4));
        assumeThat(fidelityPoints.bonusPoints(), greaterThan(FidelityPoints.BONUS_PRODUCTS_THRESHOLD));

        assertThat(fidelityPoints.redeemBonus(), is(true));
    }

}
