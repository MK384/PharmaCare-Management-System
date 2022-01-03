
package records.area.head;

import dynamic.area.Pack;
import dynamic.area.Product;
import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;
import records.area.stockroom.StockFile;
import records.area.transactions.TransFile;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DataBaseAccess {

    StockFile storeNewProductStock(ProductStock ps) throws IOException;

    StockFile updateStock(ProductStock ps) throws IOException;

    StockFile updateStock(Pack p) throws IOException, ClassNotFoundException;

    ProductStock searchStock (Product p) throws IOException, ClassNotFoundException;

    TransFile storeNewSale(Order o) throws IOException;

    List<Order> searchSales(Date orderingDate) throws IOException, ClassNotFoundException;

    List<Order> searchSales(String clientName) throws IOException, ClassNotFoundException;

    TransFile storeNewPurchase (Order o) throws IOException;

    List<Order> searchPurchases(Date orderingDate) throws IOException, ClassNotFoundException;

    List<Order> searchPurchases(String clientName) throws IOException, ClassNotFoundException;

    Map<Product , ProductStock> retrieveAllStock () throws IOException, ClassNotFoundException;

    List<Order> retrieveAllSales() throws IOException, ClassNotFoundException;

    List<Order> retrieveAllPurchases() throws IOException, ClassNotFoundException;


}
