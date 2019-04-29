package me.elleuca;

import java.math.BigDecimal;

public class PostalService {


    public boolean isFreeShipment(double price) {
        BigDecimal minPrice = new BigDecimal("20.00").setScale(2, BigDecimal.ROUND_CEILING);

        BigDecimal currentPrice = new BigDecimal(price).setScale(2, BigDecimal.ROUND_CEILING);

        int result = currentPrice.compareTo(minPrice);

        return result >=0;
    }
}
