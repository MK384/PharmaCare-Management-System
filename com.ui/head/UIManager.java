package head;

import dynamic.area.Product;
import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;

import java.time.LocalDate;
import java.util.List;

public interface UIManager {

    String[] scanDirectories();

    Order scanPurchase();

    Order scanSell();

    Product scanProduct();

    LocalDate scanOrderDate();

    void printStockRoom(List<ProductStock> p);

    void printProductDetails(ProductStock p);

    void printEmptyStockRoom();

    void printEmptyOrder(LocalDate orderDate, String client);

    void printOrder(Order o);

    char printInventoryPanel(String cashier, String shiftCode);

    String[] scanShiftInfo();

}
