package implementationChange;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Price> prices = new ArrayList<>();

    public void add(Price price) {
        this.prices.add(price);
    }

    public Price calculateTotalPrice(){
        return new Price(prices.stream().mapToInt(price -> price.getPrice()).sum());
    }

    public boolean hasDiscount() {
        return calculateTotalPrice().getPrice() >= 100;
    }

    public int numberOfProducts() {
        return prices.size();
    }
}
