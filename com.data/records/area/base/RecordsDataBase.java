package records.area.base;

import dynamic.area.Pack;
import dynamic.area.Product;
import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;
import records.area.head.DataBaseAccess;
import records.area.head.TransactionsRecords;
import records.area.stockroom.StockFile;
import records.area.stockroom.StockRecords;
import records.area.transactions.TransFile;
import records.area.transactions.TransactionRecords;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class RecordsDataBase implements DataBaseAccess {

     private final TransactionsRecords salesRecords;
    private final TransactionsRecords purchasesRecords;
     private final StockRecords stockRecords;

    private static final String DEFAULT_STOCK_PATH = "C:\\Users\\moham\\Documents";
    private static final String DEFAULT_SALES_PATH = "C:\\Users\\moham\\Documents";
    private static final String DEFAULT_PURCHASES_PATH = "C:\\Users\\moham\\Documents";

    public RecordsDataBase() {
        salesRecords = new TransactionRecords(DEFAULT_SALES_PATH);
        purchasesRecords = new TransactionRecords(DEFAULT_PURCHASES_PATH);
        stockRecords = new StockRecords(DEFAULT_STOCK_PATH);
    }

    public RecordsDataBase(String stockDirectory,String salesDirectory,String purchasesDirectory ){
        salesRecords = new TransactionRecords(salesDirectory);
        purchasesRecords = new TransactionRecords(purchasesDirectory);
        stockRecords = new StockRecords(stockDirectory);
    }

    @Override
    public StockFile storeNewProductStock(ProductStock ps) throws IOException {
        return stockRecords.storePS(ps);
    }

    @Override
    public StockFile updateStock(ProductStock ps) throws IOException {
        return stockRecords.update(ps);
    }

    @Override
    public StockFile updateStock(Pack p) throws IOException, ClassNotFoundException {
        return stockRecords.update(p);
    }

    @Override
    public ProductStock searchStock(Product p) throws IOException, ClassNotFoundException {
        return stockRecords.retrieve(p);
    }

    @Override
    public TransFile storeNewSale(Order o) throws IOException {
        return salesRecords.storeTransaction(o);
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
    public TransFile storeNewPurchase(Order o) throws IOException {
        return purchasesRecords.storeTransaction(o);
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
