package dynamic.area.head;

import dynamic.area.Pack;
import dynamic.area.Product;

import java.time.LocalDate;
import java.util.*;

public class OrderImp implements Order {

    List<Pack> itemsList = new ArrayList<>();
    String client;
    LocalDate orderingDate;
    double discount = 0.0;


    public OrderImp(String client, LocalDate orderingDate) {
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

    @Override
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
    public LocalDate getOrderingDate() {
        return orderingDate;
    }

    @Override
    public void setOrderingDate(LocalDate orderingDate) {
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
    public List<Pack> getItemList() {
        return itemsList;
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
        if (!(o instanceof OrderImp order)) return false;
        return Objects.equals(orderingDate, order.orderingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderingDate);
    }

    @Override
    public String toString() {
        return "orderImp{" +
                "client='" + client + '\'' +
                ", orderingDate=" + orderingDate +
                '}';
    }
}

