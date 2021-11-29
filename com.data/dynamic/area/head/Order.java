package dynamic.area.head;
import dynamic.area.Pack;
import dynamic.area.Product;

import java.util.Date;
import java.util.Iterator;

public interface Order extends Iterable<Pack> {


    void setClient( String client );

    String getClient();

    void setOrderingDate(Date orderingDate);

    Date getOrderingDate();

    void addItem(Product product, int quantity );

    void addItem( Pack pack );

    void setDiscount( double discountFactor );

    double getDiscount();

    Iterator<Pack> itemSet();

    int itemsNum();


}
