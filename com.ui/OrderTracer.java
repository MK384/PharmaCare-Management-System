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



    private static void traceOrderHeader(){
        System.out.println("");
        System.out.println("");
        System.out.println("                                                           |[ Order Details ]|                                                            ");
        System.out.println("======================================================================================================================================");
        System.out.println("|       Client Name     ||   Order Date   ||       Items Num        || Discount ||   Note   |");
        System.out.println("======================================================================================================================================");
    }

}
