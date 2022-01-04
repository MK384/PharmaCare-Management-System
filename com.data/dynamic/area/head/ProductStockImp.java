package dynamic.area.head;

import dynamic.area.Pack;
import dynamic.area.Product;

import java.util.*;

public class ProductStockImp implements ProductStock {

    List<Pack> packages;
    String partPlace;
    Product product;


    public ProductStockImp(Pack p) {
        product = p.getProduct();
        packages = new ArrayList<>();
        packages.add(p);
        partPlace = "Not Found";
    }

    public ProductStockImp(Product p) {
        product = p;
        packages = new ArrayList<>();
        partPlace = "Not Found";
    }


    @Override
    public Product getProduct() {
        return this.product;
    }

    @Override
    public String getPartPlace() {
        return this.partPlace;
    }

    @Override
    public void setProduct(Product p) {
        this.product = p;
    }

    @Override
    public void setPartPlace(String partPlace) {
        this.partPlace = partPlace;
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
    public Date getNearestExpDate(){
        Collections.sort(packages);
        return packages.get(packages.size()-1).getExpDate();
    }

    @Override
    public Iterator<Pack> iterator() {
        return packages.iterator();
    }

}