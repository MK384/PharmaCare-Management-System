package access.head;

import dynamic.area.Pack;
import dynamic.area.Product;
import dynamic.area.StockData;
import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;
import records.area.base.RecordsDataBase;
import records.area.head.DataBaseAccess;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class DataAccessObject implements DataManager {

    StockData stockDAO;
    DataBaseAccess baseDAO;

    public DataAccessObject() throws IOException, ClassNotFoundException {
        baseDAO = new RecordsDataBase();
        stockDAO = new StockData(baseDAO.retrieveAllStock(), baseDAO.retrieveAllSales(), baseDAO.retrieveAllPurchases());
    }

    public DataAccessObject(String stockDirectory, String salesDirectory, String purchasesDirectory) throws IOException, ClassNotFoundException {

        baseDAO = new RecordsDataBase(stockDirectory, salesDirectory, purchasesDirectory);
        stockDAO = new StockData(baseDAO.retrieveAllStock(), baseDAO.retrieveAllSales(), baseDAO.retrieveAllPurchases());
    }


    @Override
    public ProductStock getProductStock(Product p) {
        return stockDAO.search(p);
    }

    @Override
    public List<Pack> purchase(Order order) {

        for (Pack p : order)
            stockDAO.update(p.getProduct(), p);
        return order.getItemList();
    }

    @Override
    public List<Pack> sell(Order order) {
        List<Pack> total = new LinkedList<>();

        for (Pack p : order)
            total.addAll(stockDAO.extractQuantity(p.getProduct(), p.getQuantity()));

        return total;
    }

    @Override
    public boolean isAvailable(Product p, int quantity) {
        return stockDAO.isAvailable(p,quantity);
    }

    @Override
    public List<ProductStock> retrieveAllStock() throws IOException, ClassNotFoundException {
        return stockDAO.retrieveAllStock();
    }

    @Override
    public List<Order> searchSales(LocalDate date) throws IOException, ClassNotFoundException {
        return baseDAO.searchSales(date);
    }

    @Override
    public List<Order> searchSales(String client) throws IOException, ClassNotFoundException {
        return baseDAO.searchSales(client);
    }

    @Override
    public List<Order> searchSales(Date date, String client) throws IOException, ClassNotFoundException {
        List<Order> list = new LinkedList<>();
        for(Order o: baseDAO.searchSales(client)) {
            if (o.getOrderingDate().equals(date))
                list.add(o);
        }
        return list;
    }

    @Override
    public List<Order> searchPurchase(LocalDate date) throws IOException, ClassNotFoundException {
        return baseDAO.searchPurchases(date);
    }

    @Override
    public List<Order> searchPurchase(String client) throws IOException, ClassNotFoundException {
        return baseDAO.searchPurchases(client);
    }

    @Override
    public List<Order> searchPurchase(Date date, String client) throws IOException, ClassNotFoundException {
        List<Order> list = new LinkedList<>();
        for(Order o: baseDAO.searchPurchases(client)) {
            if (o.getOrderingDate().equals(date))
                list.add(o);
        }
        return list;
    }
}
