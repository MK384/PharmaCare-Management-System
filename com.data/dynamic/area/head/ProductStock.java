package dynamic.area.head;

import dynamic.area.Pack;
import dynamic.area.Product;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * this interface for an instances variables which hold all information about an existed product in the inventory.
 */

/**
 *
 * comments (for implementors) >>
 *
 * - this interface extends Iterable >> so it's concrete class must have iterator() method returns an iterator of Packs.
 *
 * - the list which holds all the Packs is itself iterable, that can make it easier for the implementation process.
 */


public interface ProductStock extends Iterable<Pack>, Serializable {


     Product getProduct();

     String getPartPlace();

    void setProduct(Product p);

    void setPartPlace (String partPlace);

     void addPack(Pack pack);

     void removePack(Pack pack);

     boolean isEmpty();

     int size();

     int totalQuantity();

    public LocalDate getNearestExpDate();

     List<Pack> extract(int q);

}
