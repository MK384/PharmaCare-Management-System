import dynamic.area.Pack;
import dynamic.area.head.ProductStock;

import javax.swing.table.TableRowSorter;

public class ProductTracer {

    private final static int NAME_SPACE = "                    ".length();
    private final static int ID_SPACE = "                   ".length();
    private final static int TYPE_SPACE = "                    ".length();
    private final static int PRICE_SPACE = "                  ".length();
    private final static int QUANTITY_SPACE = "     Quantity    ".length();
    private final static int PLACE_SPACE = "                                           ".length();
    private final static int EXP_DATE_SPACE = "            Expire Date          ".length();
    private final static int LOAD_DATE_SPACE = "           Loading Date          ".length();
    private final static int PROVIDER_SPACE = "    Merchant name    ".length();

    private final static int PACK_SPACE = "   Pack Num.    ".length();


    public static void traceHeader(ProductStock p){

        System.out.println("");
        System.out.println("");
        System.out.println("                                                    |[ Product Details ]|");
        System.out.println("==================================================================================================================================");
        System.out.print("|  Product Name :"+StockTracer.centerText(NAME_SPACE,p.getProduct().getName())+"|");
        System.out.print("|  Product ID :"+StockTracer.centerText(ID_SPACE,String.valueOf(p.getProduct().getID()))+"|");
        System.out.print("| Type :"+StockTracer.centerText(TYPE_SPACE, p.getProduct().getClass().getSimpleName())+"|");
        System.out.println("| Price :"+StockTracer.centerText(PRICE_SPACE,String.valueOf(p.getProduct().getPrice()))+"|");

        System.out.print("| Place in Stock :"+StockTracer.centerText(PLACE_SPACE,p.getPartPlace())+"|");
        System.out.println("| Notes :                                                          |");

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                                                |");
        System.out.println("========================================================={ Details }==============================================================");

        System.out.println("|   Pack Num.    ||     Quantity    ||    Merchant name    ||            Loading Date           ||         Expire Date           |");
        System.out.println("==================================================================================================================================");
        int i = 1;
        for (Pack pack: p) {
            tracePack(pack,i);
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
            i++;
        }
        System.out.println("==================================================================================================================================");
    }


    private static void tracePack(Pack p , int i){

        System.out.println("|" + StockTracer.centerText(PACK_SPACE,String.valueOf(i)) + "|");
        System.out.println("|"+ StockTracer.centerText(QUANTITY_SPACE,String.valueOf(p.getQuantity())) + "|" );
        System.out.println("|"  + StockTracer.centerText(PROVIDER_SPACE,p.getProvider()) + "|"  );
        System.out.println("|"  + StockTracer.centerText(LOAD_DATE_SPACE,p.getLoadDate().toLocaleString()) + "|");
        System.out.println("|"  + StockTracer.centerText(EXP_DATE_SPACE,p.getExpDate().toLocaleString().substring(0,11)) + "|");

    }























}
