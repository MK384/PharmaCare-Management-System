package dynamic.area.head;
import dynamic.area.Pack;
import dynamic.area.Product;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public interface Order extends Iterable<Pack>, Serializable {


    void setClient( String client );

    String getClient();

    void setOrderingDate(LocalDate orderingDate);

    LocalDate getOrderingDate();

    void addItem(Product product, int quantity );

    void addItem( Pack pack );

    double getTotalDiscount();

     List<Pack> getItemList();

    int itemsNum();

     double getTotalCost();

     void setPackList(List<Pack> packList);

}
