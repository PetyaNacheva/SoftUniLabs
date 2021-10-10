package onlineShop.models.products.computers;

import onlineShop.models.products.computers.BaseComputer;

public class DesktopComputer extends BaseComputer {
    public  static final int DEFAULT_PERFORMANCE = 15;
    public DesktopComputer(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, DEFAULT_PERFORMANCE);
    }
}
