import access.head.DataAccessObject;
import access.head.DataManager;
import dynamic.area.Pack;
import dynamic.area.Product;
import dynamic.area.head.Order;
import head.UIManager;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class MainBusiness {

    private static DataManager dataManager;
    private static UIManager uiManager;


    private static final String StockRoom_Directory = "com.data\\records/area\\filesroom\\stock";
    private static final String SalesRoom_Directory = "com.data\\records/area\\filesroom\\sales";
    private static final String Purchases_Directory = "com.data\\records/area\\filesroom\\purchases";

    public MainBusiness() {uiManager = new UiManagerImp();}

    public static void run() throws IOException, ClassNotFoundException {

        uiManager = new UiManagerImp();
        dataManager = new DataAccessObject(StockRoom_Directory,SalesRoom_Directory, Purchases_Directory);

        String[] shiftInfo = uiManager.scanShiftInfo();

        char action= uiManager.printInventoryPanel(shiftInfo[0], shiftInfo[1]);
        while (action != 'q' && action != 'Q')
            switch (action) {
                case 'p', 'P' -> {
                    makePurchaseProcess();
                    action = uiManager.printInventoryPanel(shiftInfo[0], shiftInfo[1]);
                }
                case 's', 'S' -> {
                    makeSaleProcess();
                    action = uiManager.printInventoryPanel(shiftInfo[0], shiftInfo[1]);
                }
                case 'c', 'C' -> {
                    showProductDetailsProcess(uiManager.scanProduct());
                    action = uiManager.printInventoryPanel(shiftInfo[0], shiftInfo[1]);
                }
                case 't', 'T' -> {
                    showSalesProcess(uiManager.scanOrderDate());
                    action = uiManager.printInventoryPanel(shiftInfo[0], shiftInfo[1]);
                }
                case 'd', 'D' -> {
                    showPurchasesProcess(uiManager.scanOrderDate());
                    action = uiManager.printInventoryPanel(shiftInfo[0], shiftInfo[1]);
                }
                case 'l', 'L' -> {
                    showStockRoomProcess();
                    action = uiManager.printInventoryPanel(shiftInfo[0], shiftInfo[1]);
                }
                case 'w','W' -> {
                    shiftInfo = uiManager.scanShiftInfo();
                    action = uiManager.printInventoryPanel(shiftInfo[0], shiftInfo[1]);
                }
                default -> {
                    ScannerUI.InvalidEntry();
                    action = uiManager.printInventoryPanel(shiftInfo[0], shiftInfo[1]);
                }
            }
        exitProcess();
    }

    private static void showStockRoomProcess() throws IOException, ClassNotFoundException {
        uiManager.printStockRoom(dataManager.retrieveAllStock());
    }

    private static void showProductDetailsProcess(Product p) {
        uiManager.printProductDetails(dataManager.getProductStock(p));
    }

    private static void showSalesProcess(LocalDate date) throws IOException, ClassNotFoundException {
        List<Order> orderList = dataManager.searchSales(date);
        if (orderList.isEmpty())
        { uiManager.printEmptyOrder(date,"Not Fount"); return;}
        for (Order o : orderList )
            uiManager.printOrder(o);
    }

    private static void showPurchasesProcess(LocalDate date) throws IOException, ClassNotFoundException {
        List<Order> orderList = dataManager.searchPurchase(date);
        if (orderList.isEmpty())
        { uiManager.printEmptyOrder(date,"Not Fount"); return;}
        for (Order o : orderList )
            uiManager.printOrder(o);
    }

    private static void makeSaleProcess() throws IOException {
        var order = uiManager.scanSell();
        for (Pack p : order) {
            if (!dataManager.isAvailable(p.getProduct(), p.getQuantity())) {
                OrderTracer.orderNotCompletePanel();
                return;
            }
        }
        order.setPackList(dataManager.sell(order));
        OrderTracer.orderDonePanel();
        uiManager.printOrder(order);
    }

    private static void makePurchaseProcess() throws IOException, ClassNotFoundException {
        var order = uiManager.scanPurchase();
        dataManager.purchase(order);
        OrderTracer.orderDonePanel();
        uiManager.printOrder(order);
    }

    private static void exitProcess() {
        System.out.println("");
        System.out.println("                                 =================================================================\n" +
                "                                                         | Program Ended |\n" +
                "                                 =================================================================");
    }

}
