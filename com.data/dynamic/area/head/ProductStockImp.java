package dynamic.area.head;

import dynamic.area.Pack;
import dynamic.area.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProductStockImp implements ProductStock {

    List<Pack> packages;
    Product product;


    public ProductStockImp(Pack p) {
        product = p.getProduct();
        packages = new ArrayList<>();
        packages.add(p);
    }

    public ProductStockImp(Product p) {
        product = p;
        packages = new ArrayList<>();
    }


    @Override
    public Product getProduct() {
        return this.product;
    }

    @Override
    public void setProduct(Product p) {
        this.product = p;
    }

    @Override
    public String getPartPlace() {
        return product.getPartPlace();
    }

    @Override
    public void addPack(Pack pack) {
        packages.add(pack);
    }

    @Override
    public void removePack(Pack pack) {
        packages.remove(pack);
    }

    @Override
    public boolean isEmpty() {
        return packages.isEmpty();
    }

    @Override
    public int size() {
        return packages.size();
    }

    @Override
    public int totalQuantity() {
        int totalQ = 0;
        for (Pack p : packages) {
            totalQ += p.getQuantity();
        }
        return totalQ;
    }

    public List<Pack> extract(int q) {
        List<Pack> returnList = new ArrayList<>();
        Collections.sort(packages);
        if (packages.get(0).removeQuantity(q)) {
            Pack p = new Pack(packages.get(0).getProduct());
            p.setProvider(packages.get(0).getProvider());
            p.setDiscount(0.0);
            p.setExpDate(packages.get(0).getExpDate());
            p.setLoadDate(packages.get(0).getLoadDate());
            p.setQuantity(q);
            if (packages.get(0).getQuantity() == 0)
                packages.remove(0);
            returnList.add(p);
        } else {
            int available = packages.get(0).getQuantity();
            packages.get(0).removeQuantity(available);
            Pack p = new Pack(packages.get(0).getProduct());
            p.setDiscount(0.0);
            p.setProvider(packages.get(0).getProvider());
            p.setExpDate(packages.get(0).getExpDate());
            p.setLoadDate(packages.get(0).getLoadDate());
            p.setQuantity(available);

            packages.remove(0);
            returnList.add(p);
            returnList.addAll(extract(q-available));
        }

        return returnList;
    }

    @Override
    public LocalDate getNearestExpDate() {
        Collections.sort(packages);
        return packages.get(packages.size() - 1).getExpDate();
    }

    @Override
    public Iterator<Pack> iterator() {
        return packages.iterator();
    }

}