package dynamic.area.head;

import dynamic.area.Pack;
import dynamic.area.Product;

import java.util.*;

public class ProductStockImp implements ProductStock,Comparable<Pack> {

    List<Pack> packages = new ArrayList<>();
    String partPlace;
    Product product;


    public ProductStockImp(Pack p) {
        packages.add(p);
    }

    public ProductStockImp(Product p) {
        Pack pack1 = new Pack(p);
        packages.add(pack1);
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
    public Iterator<Pack> iterator() {
        return packages.iterator();
    }


    private Stack<Pack> orderPacks = new Stack<>();

    @Override
    public int compareTo(Pack o) {
        for (Pack p : packages) {
            if (p.getExpDate().compareTo(o.getExpDate()) > 0) {
                orderPacks.push(p);
            } else orderPacks.push(o);

        }
        return 0;
    }
}