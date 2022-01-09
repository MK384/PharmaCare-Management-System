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
    public List<Pack> purchase(Order order) throws IOException, ClassNotFoundException {

        for (Pack p : order)
            stockDAO.update(p.getProduct(), p);
        stockDAO.addPurchaseOrder(order);
        baseDAO.storeNewPurchase(order);
        return order.getItemList();
    }

    @Override
    public List<Pack> sell(Order order) throws IOException {
        List<Pack> packList = new ArrayList<>();
        for (Pack p : order) {
            List<Pack> packList1 = stockDAO.extractQuantity(p.getProduct(), p.getQuantity());
            packList1.get(0).setDiscount(p.getDiscount());
            packList.addAll(packList1);
            baseDAO.updateStock(stockDAO.search(p.getProduct()));
        }
        baseDAO.storeNewSale(order);
        return packList;
    }

    @Override
    public boolean isAvailable(Product p, int quantity) {
        return stockDAO.isAvailable(p,quantity);
    }

    @Override
    public List<ProductStock> retrieveAllStock() {
        return stockDAO.retrieveAllStock();
    }

    @Override
    public List<Order> searchSales(LocalDate date)  {
        List<Order> AllList =  stockDAO.salesHistory();
        List<Order> required =  new ArrayList<>();
        for (Order o: AllList
             ) {
            if (o.getOrderingDate().equals(date))
               required.add(o);
        }
        return required;
    }

    @Override
    public List<Order> searchSales(String client) throws IOException, ClassNotFoundException {
        return baseDAO.searchSales(client);
    }

    @Override
    public List<Order> searchSales(LocalDate date, String client) throws IOException, ClassNotFoundException {
        List<Order> list = new LinkedList<>();
        for(Order o: baseDAO.searchSales(client)) {
            if (o.getOrderingDate().equals(date))
                list.add(o);
        }
        return list;
    }

    @Override
    public List<Order> searchPurchase(LocalDate date) {
        List<Order> AllList =  stockDAO.purchasesHistory();
        List<Order> required =  new ArrayList<>();
        for (Order o: AllList
        ) {
            if (o.getOrderingDate().equals(date))
                required.add(o);
        }
        return required;
    }

    @Override
    public List<Order> searchPurchase(String client) throws IOException, ClassNotFoundException {
        return baseDAO.searchPurchases(client);
    }

    @Override
    public List<Order> searchPurchase(LocalDate date, String client) throws IOException, ClassNotFoundException {
        List<Order> list = new LinkedList<>();
        for(Order o: baseDAO.searchPurchases(client)) {
            if (o.getOrderingDate().equals(date))
                list.add(o);
        }
        return list;
    }
}
