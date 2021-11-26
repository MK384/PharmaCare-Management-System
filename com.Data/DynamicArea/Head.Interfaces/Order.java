package DynamicArea.Head.Interfaces;

import java.util.Date;
import java.util.Iterator;

public interface Order {
    void setClient( String client );
    String getClient();
    void setOrderingDate();
    Date getOrderingDate();
    void addItem( Product product, int quantity );
    void addItem( Pack pack );
    void makeDiscount( double discountFactor );
    double getDiscount();
    Iterator<Pack> itemSet();
    int itemsNum();


}
