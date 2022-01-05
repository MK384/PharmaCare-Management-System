package head;

import dynamic.area.Pack;
import dynamic.area.Product;
import dynamic.area.StockData;
import dynamic.area.head.ProductStock;
import dynamic.area.head.orderImp;

import java.util.List;

public interface UIManager {

    public orderImp makePurchase ();
    public orderImp makeSell();
    public StockData listAllStockRoom(List<Pack> p);
    public ProductStock getProductDetails(Product p);

}
