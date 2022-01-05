package head;

import dynamic.area.Pack;
import dynamic.area.Product;
import dynamic.area.StockData;
import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;
import dynamic.area.head.orderImp;

import java.util.List;

public interface UIManager {

    public Order makePurchase ();
    public Order makeSell();
    public void listAllStockRoom(List<Pack> p);
    public void getProductDetails(Product p);

}
