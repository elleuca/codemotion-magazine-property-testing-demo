package me.elleuca.part1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PostalService {


    public boolean isFreeShipment(double price) {
        BigDecimal minPrice = new BigDecimal("20.00").setScale(2, RoundingMode.CEILING);

        BigDecimal currentPrice = new BigDecimal(price).setScale(2, RoundingMode.CEILING);

        int result = currentPrice.compareTo(minPrice);

        return result >=0;
    }
}
