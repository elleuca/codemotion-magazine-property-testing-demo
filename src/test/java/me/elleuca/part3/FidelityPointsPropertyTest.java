package me.elleuca.part3;

import com.pholser.junit.quickcheck.Mode;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import me.elleuca.part3.generators.InBonusRange;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assume.assumeThat;

/**
 * Tests {@link FidelityPoints#redeemBonus} method with
 * property-based testing using custom generators.
 *
 * A {@link me.elleuca.part3.generators.FidelityPointsGenerator} to create valid and random inputs
 * within the given range of bonus points per product list.
 *
 */
@RunWith(JUnitQuickcheck.class)
public class FidelityPointsPropertyTest {

    @Property(mode = Mode.EXHAUSTIVE)
    public void noFidelityPointsIfYouBoughtLessThan3SpecialProducts(@InBonusRange(minBonus = 0, maxBonus = 3) FidelityPoints fidelityPoints) {
        assumeThat(fidelityPoints.bonusPoints(), lessThan(FidelityPoints.BONUS_PRODUCTS_THRESHOLD));

        assertThat(fidelityPoints.redeemBonus(), is(false));
    }

    @Property(trials = 200)
    public void earnFidelityPointsIfYouBoughtMoreThan3SpecialProducts(@InBonusRange(minBonus = 4, maxBonus = 40) FidelityPoints fidelityPoints) {
        assumeThat(fidelityPoints.bonusPoints(), greaterThan(FidelityPoints.BONUS_PRODUCTS_THRESHOLD));

        assertThat(fidelityPoints.redeemBonus(), is(true));
    }

}
