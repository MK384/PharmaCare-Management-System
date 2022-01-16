import dynamic.area.Product;
import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;
import head.UIManager;

import java.time.LocalDate;
import java.util.List;

public class UiManagerImp implements UIManager {


    @Override
    public String[] scanDirectories() {
        return ScannerUI.scanDirectories();
    }

    @Override
    public Order scanPurchase() {
        return ScannerUI.makePurchase();
    }

    @Override
    public Order scanSell() {
        return ScannerUI.makeSale();
    }

    @Override
    public void printStockRoom(List<ProductStock> list) {
        StockTracer.traceStockRoom(list);
    }

    @Override
    public void printProductDetails(ProductStock p) {
        if (p == null)
            ProductTracer.notFoundProduct();
        assert p != null;
        ProductTracer.traceProductStock(p);
    }

    @Override
    public void printEmptyStockRoom() {
        StockTracer.traceEmptyStockRoom();
    }

    @Override
    public void printEmptyOrder(LocalDate orderDate, String client) {
        OrderTracer.traceEmptyOrder(orderDate,client);
    }

    @Override
    public void printOrder(Order o) {
        OrderTracer.traceOrder(o);
    }

    @Override
    public char printInventoryPanel(String cashier, String shiftCode) {
        return ScannerUI.mainPanelInWhite(cashier, shiftCode);
    }

    @Override
    public String[] scanShiftInfo() {
        return ScannerUI.shiftRegister();
    }

    @Override
    public Product scanProduct() {
        return ScannerUI.searchInStock();
    }

    @Override
    public LocalDate scanOrderDate() {
        return ScannerUI.searchForTransaction();
    }
}
