import dynamic.area.Pack;
import dynamic.area.head.ProductStock;
import dynamic.area.head.orderImp;

import java.util.List;

public class OrderTracer {

    private final static int ORDER_DATE = "                                ".length();
    private final static int DISCOUNT = "                         ".length();
    private final static int ITEMS_NUM = "                                     ".length();
    private final static int TOTAL_CASH = "                                                           ".length();
    private final static int CLIENT_NAME = "                            ".length();

    private final static int PRODUCT_NAME_SPACE = "       Product Name     ".length();
    private final static int EXP_DATE_SPACE = "            Expire Date          ".length();
    private final static int LOAD_DATE_SPACE = "           Loading Date          ".length();
    private final static int PROVIDER_SPACE = "    Merchant name    ".length();
    private final static int QUANTITY_SPACE = "      Quantity      ".length();



    private static void traceOrderHeader(orderImp o){
        System.out.println("");
        System.out.println("");
        System.out.println("                                                           |[ Order Details ]|                                                            ");
        System.out.println("======================================================================================================================================");
        System.out.println("=========================================================={Order}=================================================================");
        System.out.print("| Client Name : "+StockTracer.centerText(CLIENT_NAME,o.getClient())+"|");
        System.out.print("| Order Date : "+StockTracer.centerText(ORDER_DATE,o.getOrderingDate().toString())+"|");
        System.out.print("| Discount : "+StockTracer.centerText(DISCOUNT,String.valueOf(o.getDiscount()))+"|");
        System.out.println("| Items Num : "+StockTracer.centerText(ITEMS_NUM,String.valueOf(o.itemsNum()))+"|");
        System.out.print("| TOTAL PAID CASH : "+StockTracer.centerText(TOTAL_CASH,String.valueOf(o.getTotalCost()))+"|");
        System.out.println("========================================================{Details}=================================================================");
        System.out.println("|       Product Name     ||      Quantity      ||     Merchant Name     ||        Loading Date        ||        Expire Date      |");
        System.out.println("==================================================================================================================================");
        System.out.println("======================================================================================================================================");

    }
    private static void tracePack(Pack p){

        System.out.println("|" + StockTracer.centerText(PRODUCT_NAME_SPACE,p.getProduct().getName()) + "|");
        System.out.println("|"+ StockTracer.centerText(QUANTITY_SPACE,String.valueOf(p.getQuantity())) + "|" );
        System.out.println("|"  + StockTracer.centerText(PROVIDER_SPACE,p.getProvider()) + "|"  );
        System.out.println("|"  + StockTracer.centerText(LOAD_DATE_SPACE,p.getLoadDate().toLocaleString()) + "|");
        System.out.println("|"  + StockTracer.centerText(EXP_DATE_SPACE,p.getExpDate().toLocaleString().substring(0,11)) + "|");

    }
    private static void traceOrderFooter() {
        System.out.println("======================================================================================================================================");
        System.out.println("");

    }
    public static void traceEmptyOrderRoom() {
        OrderTracer.traceOrderHeader();
        System.out.println("|          Empty         ||      Empty      ||       Empty       ||        Empty       ||      Empty      ||          Empty          |");
        OrderTracer.traceOrderFooter();
    }
    public static void traceOrderRoom(orderImp o) {
        if (o.getItemList().isEmpty())
            StockTracer.traceEmptyStockRoom();
        else {
            OrderTracer.traceOrderHeader();
            for (Pack p : o.getItemList()) {
                OrderTracer.tracePack(p);
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            }
           OrderTracer.traceOrderFooter();
        }

}}
