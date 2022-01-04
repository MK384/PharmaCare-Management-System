package dynamic.area.head;
import dynamic.area.Pack;
import dynamic.area.Product;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public interface Order extends Iterable<Pack>, Serializable {


    void setClient( String client );

    String getClient();

    void setOrderingDate(Date orderingDate);

    Date getOrderingDate();

    void addItem(Product product, int quantity );

    void addItem( Pack pack );

    void setDiscount( double discountFactor );

    double getDiscount();

     List<Pack> getItemList();

    int itemsNum();


}
