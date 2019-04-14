package me.elleuca;

public class PostalService {
    public boolean isFreeShipment(int price) {
        return price >= 20;
    }
}
