package me.elleuca.part2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountService {

    public boolean canHaveDiscount(double price) {
        final BigDecimal DISCOUNT_THRESHOLD = new BigDecimal("50.00").setScale(2, RoundingMode.UNNECESSARY);

        BigDecimal currentPrice = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);

        int comparison = currentPrice.compareTo(DISCOUNT_THRESHOLD);

        return comparison >= 0;
    }

}
