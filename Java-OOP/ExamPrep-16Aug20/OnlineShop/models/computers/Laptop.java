package onlineShop.models.products.computers;

import onlineShop.models.products.computers.BaseComputer;

public class Laptop extends BaseComputer {
    public  static final int DEFAULT_PERFORMANCE = 10;
    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, DEFAULT_PERFORMANCE);
    }
}
