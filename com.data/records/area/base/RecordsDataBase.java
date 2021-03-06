package records.area.base;

import dynamic.area.Pack;
import dynamic.area.Product;
import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;
import records.area.head.DataBaseAccess;
import records.area.head.TransactionsRecords;
import records.area.stockroom.StockRecords;
import records.area.transactions.TransactionRecords;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class RecordsDataBase implements DataBaseAccess {

     private final TransactionsRecords salesRecords;
    private final TransactionsRecords purchasesRecords;
     private final StockRecords stockRecords;



    public RecordsDataBase(String stockDirectory,String salesDirectory,String purchasesDirectory ) throws IOException, ClassNotFoundException {
        salesRecords = new TransactionRecords(salesDirectory);
        purchasesRecords = new TransactionRecords(purchasesDirectory);
        stockRecords = new StockRecords(stockDirectory);
    }

    @Override
    public void storeNewProductStock(ProductStock ps) throws IOException {
         stockRecords.storeNewPS(ps);
    }

    @Override
    public void updateStock(ProductStock ps) throws IOException {
         stockRecords.update(ps);
    }

    @Override
    public void updateStock(Pack p) throws IOException, ClassNotFoundException {
         stockRecords.update(p);
    }

    @Override
    public ProductStock searchStock(Product p) throws IOException, ClassNotFoundException {
        return stockRecords.retrieve(p);
    }

    @Override
    public void storeNewSale(Order o) throws IOException {
         salesRecords.storeTransaction(o);
    }

    @Override
    public List<Order> searchSales(LocalDate orderingDate) throws IOException, ClassNotFoundException {
        return salesRecords.retrieve(orderingDate);
    }

    @Override
    public List<Order> searchSales(String clientName) throws IOException, ClassNotFoundException {
        return salesRecords.retrieve(clientName);
    }

    @Override
    public void storeNewPurchase(Order o) throws IOException, ClassNotFoundException {
         purchasesRecords.storeTransaction(o);
        for (Pack p: o
             ) {updateStock(p);
        }
    }

    @Override
    public List<Order> searchPurchases(LocalDate orderingDate) throws IOException, ClassNotFoundException {
        return purchasesRecords.retrieve(orderingDate);
    }

    @Override
    public List<Order> searchPurchases(String clientName) throws IOException, ClassNotFoundException {
        return purchasesRecords.retrieve(clientName);
    }

    @Override
    public Map<Product, ProductStock> retrieveAllStock() throws IOException, ClassNotFoundException {
        return stockRecords.retrieveAll();
    }

    @Override
    public List<Order> retrieveAllSales() throws IOException, ClassNotFoundException {
        return salesRecords.retrieveAll();
    }

    @Override
    public List<Order> retrieveAllPurchases() throws IOException, ClassNotFoundException {
        return purchasesRecords.retrieveAll();
    }
}
