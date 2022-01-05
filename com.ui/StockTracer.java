import dynamic.area.head.ProductStock;

import java.util.List;

public class StockTracer {

    private final static int NAME_SPACE = "       Product Name     ".length();
    private final static int ID_SPACE = "   Product  ID   ".length();
    private final static int TYPE_SPACE = "       Type        ".length();
    private final static int QUANTITY_SPACE = " Available Quantity ".length();
    private final static int PLACE_SPACE = "   Stock Place   ".length();
    private final static int DATE_SPACE = "     Nearest Exp.Date    ".length();

    private static void traceStockRoomHeader() {
        System.out.println("");
        System.out.println("");
        System.out.println("                                                           |[ ٍٍStockroom ]|                                                            ");
        System.out.println("======================================================================================================================================");
        System.out.println("|       Product Name     ||   Product  ID   ||       Type        || Available Quantity ||   Stock Place   ||     Nearest Exp.Date    |");
        System.out.println("======================================================================================================================================");
    }

    private static void tracePlainProduct(ProductStock p) {
        System.out.print("|" + centerText(NAME_SPACE, p.getProduct().getName()) + "|");
        System.out.print("|" + centerText(ID_SPACE, String.valueOf(p.getProduct().getID())) + "|");
        System.out.print("|" + centerText(TYPE_SPACE, p.getProduct().getClass().getSimpleName()) + "|");
        System.out.print("|" + centerText(QUANTITY_SPACE, String.valueOf(p.totalQuantity())) + "|");
        System.out.print("|" + centerText(PLACE_SPACE, p.getPartPlace()) + "|");
        System.out.println("|" + centerText(DATE_SPACE, p.getNearestExpDate().toLocaleString().substring(0, 11)) + "|");

    }

    private static void traceStockRoomFooter() {
        System.out.println("======================================================================================================================================");
        System.out.println("");

    }

    public static void main(String[] args) {

    }


    public static String centerText(int spaces, String text) {
        StringBuilder centeredText = new StringBuilder();
        int align = (spaces - text.length()) / 2;
        centeredText.append(" ".repeat(Math.max(0, align + 1)));
        centeredText.append(text);
        centeredText.append(" ".repeat(Math.max(0, align)));

        while (centeredText.length() > spaces) {
            centeredText = new StringBuilder(centeredText.substring(1));
        }

        return centeredText.toString();
    }

    public static void traceEmptyStockRoom() {
        StockTracer.traceStockRoomHeader();
        System.out.println("|          Empty         ||      Empty      ||       Empty       ||        Empty       ||      Empty      ||          Empty          |");
        StockTracer.traceStockRoomFooter();
    }

    public static void traceStockRoom(List<ProductStock> list) {
        if (list.isEmpty())
            StockTracer.traceEmptyStockRoom();
        else {
            StockTracer.traceStockRoomHeader();
            for (ProductStock ps : list) {
                StockTracer.tracePlainProduct(ps);
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            }
            StockTracer.traceStockRoomFooter();
        }
    }
}
