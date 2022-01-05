import dynamic.area.Pack;
import dynamic.area.head.ProductStock;
import dynamic.area.head.orderImp;

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
        System.out.println("|       Client Name     ||   Order Date   ||       Items Num        || Discount ||   Note   |");
        System.out.println("======================================================================================================================================");

    }
    private static void tracePack(Pack p){

        System.out.println("|" + StockTracer.centerText(PRODUCT_NAME_SPACE,p.getProduct().getName()) + "|");
        System.out.println("|"+ StockTracer.centerText(QUANTITY_SPACE,String.valueOf(p.getQuantity())) + "|" );
        System.out.println("|"  + StockTracer.centerText(PROVIDER_SPACE,p.getProvider()) + "|"  );
        System.out.println("|"  + StockTracer.centerText(LOAD_DATE_SPACE,p.getLoadDate().toLocaleString()) + "|");
        System.out.println("|"  + StockTracer.centerText(EXP_DATE_SPACE,p.getExpDate().toLocaleString().substring(0,11)) + "|");

    }

}
