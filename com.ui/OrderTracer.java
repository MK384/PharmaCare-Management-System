public class OrderTracer {

    private final static int ORDER_DATE = "       Order Date       ".length();
    private final static int DISCOUNT = "       Discount       ".length();
    private final static int ITEMS_NUM = "       Items Number       ".length();
    private final static int NOTE = "       Note       ".length();
    private final static int CLIENT_NAME = "       Client Name       ".length();

    private static void traceOrderHeader(){
        System.out.println("");
        System.out.println("");
        System.out.println("                                                           |[ Order Details ]|                                                            ");
        System.out.println("======================================================================================================================================");
        System.out.println("|       Client Name     ||   Order Date   ||       Items Num        || Discount ||   Note   |");
        System.out.println("======================================================================================================================================");
    }

}
