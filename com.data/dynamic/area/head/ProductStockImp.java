package dynamic.area.head;

import dynamic.area.Pack;
import dynamic.area.Product;

import java.time.LocalDate;
import java.util.*;

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
    public String getPartPlace() {
        return product.getPartPlace();
    }

    @Override
    public void setProduct(Product p) {
        this.product = p;
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
        for (int i=0;i<packages.size();i++){
            if (!packages.get(i).removeQuantity(q)){
                returnList.add(packages.get(i));
            }
            else {
                Pack rest = packages.get(i);
                returnList.add(rest);
                break;
            }

        }
        return returnList;
    }
    @Override
    public LocalDate getNearestExpDate(){
        Collections.sort(packages);
        return  packages.get(packages.size()-1).getExpDate();
    }

    @Override
    public Iterator<Pack> iterator() {
        return packages.iterator();
    }

}