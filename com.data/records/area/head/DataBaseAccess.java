
package records.area.head;

import dynamic.area.Pack;
import dynamic.area.Product;
import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;
import records.area.stockroom.StockFile;
import records.area.transactions.TransFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface DataBaseAccess {

    void storeNewProductStock(ProductStock ps) throws IOException;

    void updateStock(ProductStock ps) throws IOException;

    void updateStock(Pack p) throws IOException, ClassNotFoundException;

    ProductStock searchStock (Product p) throws IOException, ClassNotFoundException;

    void storeNewSale(Order o) throws IOException;

    List<Order> searchSales(LocalDate orderingDate) throws IOException, ClassNotFoundException;

    List<Order> searchSales(String clientName) throws IOException, ClassNotFoundException;

    void storeNewPurchase (Order o) throws IOException, ClassNotFoundException;

    List<Order> searchPurchases(LocalDate orderingDate) throws IOException, ClassNotFoundException;

    List<Order> searchPurchases(String clientName) throws IOException, ClassNotFoundException;

    Map<Product , ProductStock> retrieveAllStock () throws IOException, ClassNotFoundException;

    List<Order> retrieveAllSales() throws IOException, ClassNotFoundException;

    List<Order> retrieveAllPurchases() throws IOException, ClassNotFoundException;


}
