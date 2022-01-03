package dynamic.area.head;

import dynamic.area.Pack;
import dynamic.area.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductStockImp implements ProductStock {

    List<Pack> packages = new ArrayList<>();
    String partPlace;
    Product product;




    @Override
    public Product getProduct() {
        return null;
    }

    @Override
    public String getPartPlace() {
        return null;
    }

    @Override
    public void setProduct(Product p) {

    }

    @Override
    public void setPartPlace(String partPlace) {

    }

    @Override
    public void addPack(Pack pack) {

    }

    @Override
    public void removePack(Pack pack) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int totalQuantity() {
        return 0;
    }

    @Override
    public List<Pack> extract(int q) {
        return null;
    }

    @Override
    public Iterator<Pack> iterator() {
        return null;
    }
}
