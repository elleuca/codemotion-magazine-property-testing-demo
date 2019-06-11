package me.elleuca.part3;

import java.util.UUID;

/**
 * A product in your shop/cart/..
 *
 * Each product has unique identifier, name and fidelity point
 */
public class Product {
    private UUID uuid;
    private String name;
    private int bonus;


    public Product(UUID uuid, String name, int bonus) {
        this.uuid = uuid;
        this.name = name;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}
