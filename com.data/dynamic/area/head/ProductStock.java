package dynamic.area.head;

import dynamic.area.Pack;
import dynamic.area.Product;

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


public interface ProductStock extends Iterable<Pack> {


    public Product getProduct();

    public String getPartPlace();

    void setProduct(Product p);

    public void addPack(Pack pack);

    public void removePack(Pack pack);

    public boolean isEmpty();

    public int size();

    public int totalQuantity();

    public List<Pack> extract(int q);

}
