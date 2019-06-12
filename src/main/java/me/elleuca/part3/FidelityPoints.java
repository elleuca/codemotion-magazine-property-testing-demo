package me.elleuca.part3;

import java.util.List;
import java.util.UUID;

/**
 * Manages fidelity points from a list of {@link Product}.
 */
public class FidelityPoints {

    public static final int BONUS_PRODUCTS_THRESHOLD = 3;
    private static final int MIN_CART_SIZE_FOR_BONUS  = BONUS_PRODUCTS_THRESHOLD + 2;

    private final List<Product> products;
    private final UUID uuid;

    public FidelityPoints(UUID uuid, List<Product> products) {
        this.uuid = uuid;
        this.products = products;
    }

    /**
     * Verify if {@link Product} list can redeem the bonus form current total bonus points
     *
     * @return true if fidelity point can be redeemed
     */
    public boolean redeemBonus() {
        return ((bonusPoints() > BONUS_PRODUCTS_THRESHOLD) && (products.size() > MIN_CART_SIZE_FOR_BONUS ));
    }

    /**
     * Count bonus points in {@link Product} list
     *
     * @return total bonus points
     */
    public int bonusPoints() {
        return products.stream().map(Product::getBonus).mapToInt(Integer::intValue).sum();
    }

    public int productsCount() {
        return products.size();
    }

}
