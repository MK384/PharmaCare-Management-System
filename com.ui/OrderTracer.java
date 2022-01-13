import dynamic.area.Pack;
import dynamic.area.head.Order;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderTracer {

    private final static int ORDER_DATE = "                                ".length();
    private final static int DISCOUNT = "                  L.E  ".length();
    private final static int ITEMS_NUM = "                                     ".length();
    private final static int TOTAL_CASH = "                                                    L.E  ".length();
    private final static int CLIENT_NAME = "                            ".length();

    private final static int PRODUCT_NAME_SPACE = "       Product Name     ".length();
    private final static int EXP_DATE_SPACE = "        Expire Date      ".length();
    private final static int LOAD_DATE_SPACE = "        Loading Date        ".length();
    private final static int AMOUNT_COST_SPACE = "      Amount Cost      ".length();
    private final static int QUANTITY_SPACE = "      Quantity      ".length();

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("E, dd MMM yyyy");

    private static void traceOrderHeader(Order o){
        System.out.println("");
        System.out.println("");
        System.out.println("                                                    |[ Order Details ]|");
        System.out.println("==================================================================================================================================");
        System.out.println("|                                                                                                                                |\n" +
                "=========================================================={Order}=================================================================");
        System.out.print("| Client Name : "+StockTracer.centerText(CLIENT_NAME,o.getClient())+"|");
        System.out.print("| Order Date : "+StockTracer.centerText(ORDER_DATE,o.getOrderingDate().format(DATE_FORMATTER))+"|");
        System.out.println("| Discount : "+StockTracer.centerText(DISCOUNT,(o.getTotalDiscount())+"  L.E  ")+"|");
        System.out.print("| Items Num : "+StockTracer.centerText(ITEMS_NUM,String.valueOf(o.itemsNum()))+"|");
        System.out.println("| TOTAL PAID CASH : "+StockTracer.centerText(TOTAL_CASH,(o.getTotalCost()+"  L.E  "))+"|");
        System.out.println("========================================================{Details}=================================================================");
        System.out.println("|       Product Name     ||      Quantity      ||      Amount Cost      ||        Loading Date        ||        Expire Date      |");
        System.out.println("==================================================================================================================================");


    }
    private static void tracePack(Pack p){

        System.out.print("|" + StockTracer.centerText(PRODUCT_NAME_SPACE,p.getProduct().getName()) + "|");
        System.out.print("|"+ StockTracer.centerText(QUANTITY_SPACE,String.valueOf(p.getQuantity())) + "|" );
        System.out.print("|"  + StockTracer.centerText(AMOUNT_COST_SPACE,String.valueOf( p.getCost())) + "|"  );
        System.out.print("|"  + StockTracer.centerText(LOAD_DATE_SPACE,p.getLoadDate().format(DATE_FORMATTER)) + "|");
        System.out.println("|"  + StockTracer.centerText(EXP_DATE_SPACE,p.getExpDate().format(DATE_FORMATTER)) + "|");

    }
    private static void traceOrderFooter() {
        System.out.println("==================================================================================================================================");
        System.out.println("");

    }
    public static void traceEmptyOrder(LocalDate orderDate , String client) {
        System.out.println("\n" +
                "                                                         |[ Order Details ]|\n" +
                "==================================================================================================================================\n" +
                "|                                                                                                                                |\n" +
                "============================================================={Order}==============================================================\n" +
                "| Client Name :  "+ StockTracer.centerText("        empty field      ".length(),client) +"  || Order Date :            "+ orderDate.format(DATE_FORMATTER) +"           || Discount :           0.0          |\n" +
                "| Items Num :                   0                  || TOTAL PAID CASH :                            0.0                           |\n" +
                "========================================================{Details}=================================================================\n" +
                "|       Product Name     ||      Quantity      ||     Merchant Name     ||        Loading Date        ||        Expire Date      |\n" +
                "==================================================================================================================================\n" +
                "|          Empty         ||         Empty      ||          Empty        ||             Empty          ||           Empty         |\n" +
                "==================================================================================================================================");
    }
    public static void traceOrder(Order o) {
        if (o.getItemList().isEmpty())
            traceEmptyOrder(o.getOrderingDate(),o.getClient());
        else {
            OrderTracer.traceOrderHeader(o);
            for (Pack p : o.getItemList()) {
                OrderTracer.tracePack(p);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
            }
           OrderTracer.traceOrderFooter();
        }

}
    public static void orderNotCompletePanel()
    {
        System.out.println("");
        System.out.println("""
                ================================================================================
                |                Order Cannot complete due to insufficient supplies            |
                ================================================================================""".indent(28));
    }

    public static void orderDonePanel()
    {
        System.out.println("");
        System.out.println("""
                ================================================================================
                |                          Order Completed Successfully                        |
                ================================================================================""".indent(28));
    }



}
