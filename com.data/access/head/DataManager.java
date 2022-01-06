package access.head;

import dynamic.area.Pack;
import dynamic.area.Product;
import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DataManager {


    ProductStock getProductStock(Product p);

    List<Pack> purchase(Order order);

    List<Pack> sell(Order order);

    boolean isAvailable(Product p, int quantity);

    List<ProductStock> retrieveAllStock() throws IOException, ClassNotFoundException;

    List<Order> searchSales(LocalDate date) throws IOException, ClassNotFoundException;

    List<Order> searchSales(String client) throws IOException, ClassNotFoundException;

    List<Order> searchSales(Date date , String client) throws IOException, ClassNotFoundException;

    List<Order> searchPurchase(LocalDate date) throws IOException, ClassNotFoundException;

    List<Order> searchPurchase(String client) throws IOException, ClassNotFoundException;

    List<Order> searchPurchase(Date date , String client) throws IOException, ClassNotFoundException;

}
