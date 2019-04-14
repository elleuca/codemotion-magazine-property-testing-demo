package me.elleuca;

public class PostalService {
    public boolean isFreeShipment(double price) {
        return price >= 20.00;
    }
}
