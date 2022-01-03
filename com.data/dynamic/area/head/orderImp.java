package dynamic.area.head;

import dynamic.area.Pack;
import dynamic.area.Product;

import java.util.*;

public class orderImp implements Order {

    List<Pack> itemsList = new ArrayList<>();
    String client;
    Date orderingDate;
    double discount = 0.0;


    public orderImp(String client, Date orderingDate) {
        this.client = client;
        this.orderingDate = orderingDate;
    }

    public double getNetCost() {
        int totalCost = 0;
        for (Pack p : itemsList) {
            totalCost += p.getPrice() * p.getQuantity();
        }
        return totalCost;
    }

    public double getTotalCost() {
        return getNetCost() - getDiscount();
    }

    @Override
    public String getClient() {
        return client;
    }

    @Override
    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public Date getOrderingDate() {
        return orderingDate;
    }

    @Override
    public void setOrderingDate(Date orderingDate) {
        this.orderingDate = orderingDate;
    }

    @Override
    public void addItem(Product product, int quantity) {
        Pack makePack = new Pack(product, quantity);
        addItem(makePack);
    }

    @Override
    public void addItem(Pack pack) {
       itemsList.add(pack);
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public void setDiscount(double discountFactor) {
        this.discount = discountFactor * getTotalCost();
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
        return itemsList.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof orderImp)) return false;
        orderImp packs = (orderImp) o;
        return Double.compare(packs.discount, discount) == 0 && Objects.equals(itemsList, packs.itemsList) && client.equals(packs.client) && Objects.equals(orderingDate, packs.orderingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemsList, client, orderingDate, discount);
    }
}

