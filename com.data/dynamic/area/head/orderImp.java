package dynamic.area.head;

import dynamic.area.Pack;
import dynamic.area.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;

public class orderImp implements Order{

    List<Pack> itemsList = new ArrayList<>();
    String client;
    Date orderingDate;
    double discount , totalCost;


    public orderImp (String client ,Date orderingDate) {
        this.client=client;
        this.orderingDate=orderingDate;
    }


    public double getTotalCost() {
        int total = 0;
        for (Pack p : itemsList){
            total+=p.getPrice();
        }
        return total;
    }



    @Override
    public void setClient(String client) {
        this.client=client;
    }

    @Override
    public String getClient() {
        return client;
    }

    @Override
    public void setOrderingDate(Date orderingDate) {
        this.orderingDate=orderingDate;
    }

    @Override
    public Date getOrderingDate() {
        return orderingDate;
    }

    @Override
    public void addItem(Product product, int quantity) {
        Pack makePack = new Pack(product,quantity);
        addItem(makePack);
    }

    @Override
    public void addItem(Pack pack) {
        if (itemsList.isEmpty()){
            itemsList.set(0, pack);
        }
        else {
            itemsList.add(pack);
        }

    }

    @Override
    public void setDiscount(double discountFactor) {
        this.discount = (double) discountFactor*(this.totalCost);
        this.totalCost-=this.discount;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public Iterator<Pack> itemSet() {
        return itemsList.iterator();
    }

    @Override
    public int itemsNum() {
        return itemsList.size();
    }

    @Override
    public Iterator<Pack> iterator() {
        return null;
    }
}

