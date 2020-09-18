package implementationChange;

import java.util.List;

public class ShoppingCart {
    private int price;

    private List<Integer> prices;


    public void add(int price) {
        this.price = price;
    }

    public void add(Integer price){
        this.prices.add(price);
    }

    public int calculateTotalPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return price >= 100;
    }

    public int numberOfProducts() {
        return 1;
    }
}
