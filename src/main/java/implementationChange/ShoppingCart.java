package implementationChange;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int price;
    private List<Integer> prices = new ArrayList<>();


    public void add(int price) {
        this.price = price;
        this.prices.add(price);
    }

    public int calculateTotalPrice() {
        return price;
    }

    public Integer calculateTotalPrices(){
        return prices.stream().mapToInt(price -> price).sum();
    }

    public boolean hasDiscount() {
        return calculateTotalPrices() >= 100;
    }

    public int numberOfProducts() {
        return 1;
    }
}
