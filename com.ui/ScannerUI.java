import dynamic.area.Pack;
import dynamic.area.Product;
import dynamic.area.head.Order;
import dynamic.area.head.OrderImp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerUI {

    private final static Scanner input = new Scanner(System.in);

    private static final DateTimeFormatter DATE_ENTERED_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("E, dd MMM yyyy");

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("hh:mm:ss a");


    private static final int order_date_length = "                                  ".length();
    //====================================================================================================================

    public static final int cashier_spaces = "                                     ".length();
    public static final int time_space = "                                    ".length();
    public static final int code_space = "                                 ".length();
    public static final int date_space = "                                     ".length();

    //====================================================================================================================

    public static String[] scanDirectories() {


        System.out.println("\n\n========================================================================================================================");
        System.out.println(
                "|                                              [  Enter Directories ]                                                  |\n" +
                        "========================================================================================================================"
        );
        System.out.print("| StockRoom Directory :  ");
        String stockDir = input.nextLine();
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        //   System.out.println("|");
        System.out.print("| SalesRoom Directory :  ");
        String saleskDir = input.nextLine();
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.print("| Purchases Directory :  ");
        String purchaseskDir = input.nextLine();
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        return new String[]{stockDir, saleskDir, purchaseskDir};
    }

    private static String scanPurchaseHeader() {

        System.out.println("");
        System.out.print("                            ================================================================================\n" +
                "                            |                              [ Make Purchase ]                               |\n" +
                "                            ================================================================================\n" +
                "                            |   Merchant Name  :     ");
        String Merchant_Name = input.nextLine();
        System.out.println("                            --------------------------------------------------------------------------------");
        System.out.println("                            |   Order date     :"+StockTracer.centerText(order_date_length,LocalDate.now().toString())+"                         |");
        System.out.println("                            ================================================================================\n" +
                "                            |                                                                              |");
        return Merchant_Name;
    }

    private static String scanSaleHeader() {
        System.out.print("                            ================================================================================\n" +
                "                            |                                [ Make Sale ]                                 |\n" +
                "                            ================================================================================\n" +
                "                            |           Client Name :    ");
        String client = input.nextLine();
        System.out.print("================================================================================\n".indent(28) +
                "|                                                                              |".indent(28));
        return client;
    }

    private static List<Pack> scanPurchasedProducts(int Num) {

        List<Pack> packList = new ArrayList<>();

        try {
            System.out.println(drawSpace(28)+"================================{Product" + StockTracer.centerText("    ".length(), String.valueOf(Num)) + "}===================================");
            System.out.print(drawSpace(28)+"| Product Name :       ");
            String Product_Name = input.nextLine();
            System.out.println(drawSpace(28)+"--------------------------------------------------------------------------------");
            System.out.print(drawSpace(28)+"| Product ID :       ");
            int ID = Integer.parseInt(input.nextLine());
            System.out.println(drawSpace(28)+"--------------------------------------------------------------------------------");
            System.out.print(drawSpace(28)+"| Type [C: cosmetics | M: MedicalDrug | E: Equipment] :    ");
            char type = input.nextLine().charAt(0);
            System.out.println(drawSpace(28)+"--------------------------------------------------------------------------------");
            System.out.print(drawSpace(28)+"| Quantity :       ");
            int quantity = Integer.parseInt(input.nextLine());
            System.out.println(drawSpace(28)+"--------------------------------------------------------------------------------");
            System.out.print(drawSpace(28)+"| Price :       ");
            double price = Double.parseDouble(input.nextLine());
            System.out.println(drawSpace(28)+"--------------------------------------------------------------------------------");
            System.out.print(drawSpace(28)+"| Discount :       ");
            double discount = Double.parseDouble(input.nextLine());
            System.out.println(drawSpace(28)+"--------------------------------------------------------------------------------");
            System.out.print(drawSpace(28)+"| Part Place :       ");
            String partPlace = input.nextLine();
            System.out.println(drawSpace(28)+"--------------------------------------------------------------------------------");
            System.out.print(drawSpace(28)+"| Exp. Date [dd-mm-yyyy] :       ");
            LocalDate expDate = LocalDate.parse(input.nextLine(), DATE_ENTERED_FORMATTER);

            System.out.print(drawSpace(28)+"================================================================================\n" +
                    drawSpace(28)+"| Another Product [Y: Yes | N: No]    :         ");
            char action = input.nextLine().charAt(0);
            System.out.println(drawSpace(28)+"--------------------------------------------------------------------------------");

            Product p = ProductFactory.generateProduct(type);
            assert p != null;
            p.setName(Product_Name);
            p.setID(ID);
            p.setPrice(price);
            p.setPartPlace(partPlace);
            Pack pack = new Pack(p);
            pack.setQuantity(quantity);
            pack.setExpDate(expDate);
            pack.setLoadDate(LocalDate.now());
            pack.setDiscount(discount);

            packList.add(pack);

            switch (action) {
                case 'n':
                case 'N':
                    return packList;
                case 'y':
                case 'Y': {
                    packList.addAll(scanPurchasedProducts(Num + 1));
                    return packList;
                }
            }
        } catch (Exception e) {

            char answer = invalidEntries();
            switch (answer) {

                case 'y':
                case 'Y':
                    return scanPurchasedProducts(Num);
                case 'n':
                case 'N':
                    return packList;
            }
        }
        return packList;
    }

    private static List<Pack> scanSoldProducts(int Num) {

        List<Pack> packList = new ArrayList<>();
        try {
            System.out.println(drawSpace(28)+"================================{Product" + StockTracer.centerText("    ".length(), String.valueOf(Num)) + "}===================================");
            System.out.print(drawSpace(28)+"| Product Name :       ");
            String Product_Name = input.nextLine();
            System.out.print("--------------------------------------------------------------------------------".indent(28));
            System.out.print(drawSpace(28)+"| Product ID :       ");
            int ID = Integer.parseInt(input.nextLine());
            System.out.print("--------------------------------------------------------------------------------".indent(28));
            System.out.print(drawSpace(28)+"| Type [C: cosmetics | M: MedicalDrug | E: Equipment] :    ");
            char type = input.nextLine().charAt(0);
            System.out.print("--------------------------------------------------------------------------------".indent(28));
            System.out.print(drawSpace(28)+"| Quantity :       ");
            int quantity = Integer.parseInt(input.nextLine());
            System.out.print("--------------------------------------------------------------------------------".indent(28));
            System.out.print(drawSpace(28)+"| Discount :       ");
            double discount = Double.parseDouble(input.nextLine());
            System.out.print("--------------------------------------------------------------------------------".indent(28));

            System.out.print("================================================================================\n".indent(28) +
                    drawSpace(28)+"| Another Product [Y: Yes | N: No]    :         ");
            char action = input.nextLine().charAt(0);
            System.out.print("--------------------------------------------------------------------------------".indent(28));


            Product p = ProductFactory.generateProduct(type);
            assert p != null;
            p.setName(Product_Name);
            p.setID(ID);
            Pack pack = new Pack(p);
            pack.setQuantity(quantity);
            pack.setDiscount(discount);
            pack.setLoadDate(LocalDate.now());

            packList.add(pack);

            switch (action) {
                case 'n':
                case 'N':
                    return packList;
                case 'y':
                case 'Y': {
                    packList.addAll(scanSoldProducts(Num + 1));
                    return packList;
                }
            }
        } catch (Exception e) {

            char answer = invalidEntries();
            switch (answer) {

                case 'y':
                case 'Y':
                   return scanSoldProducts(Num);
                case 'n':
                case 'N':
                    return packList;
            }
        }
        return packList;
    }

    private static char invalidEntries() {
        System.out.println("");
        System.out.print("         =============================================[  Invalid Entries  ]==============================================\n" +
                "         |          Try Again [Y: Yes | N: No]  :        ");
        char answer = input.nextLine().charAt(0);
        System.out.println("         ----------------------------------------------------------------------------------------------------------------");
        return answer;
    }

    public static Order makePurchase(){

        String merchant = scanPurchaseHeader();
        List<Pack> packList = scanPurchasedProducts(1);
        Order order = new OrderImp(merchant,LocalDate.now());

        for (Pack pack: packList)
        {
            pack.setProvider(merchant);
            order.addItem(pack);}

        return order;

    }

    public static Order makeSale(){

        String client = scanSaleHeader();
        List<Pack> packList = scanSoldProducts(1);
        Order order = new OrderImp(client,LocalDate.now());

        for (Pack pack: packList)
            order.addItem(pack);

        return order;

    }

    public static Product searchInStock(){

        Product p = new Product();
        System.out.print("         ================================================================================================================\n" +
                "         |  Enter Product ID :    ");
        String id_name = input.nextLine();
        System.out.println("         ----------------------------------------------------------------------------------------------------------------");

        try {
            int id = Integer.parseInt(id_name);
            p.setID(id);
        }
        catch (Exception e)
        {
            char choice = invalidEntries();
            switch (choice){
                case 'n','N' -> {return null;}
                case 'y','Y' -> {return searchInStock();}
            }

        }
        return p;
    }

    public static char mainPanel(String cashier, String shiftCode){
        char choice = 'n';
        try {
            System.out.println("");
            System.out.println("");
            System.out.print("                                              =================================\n" +
                    "                                              |[ PharmaCare Management Panel ]|\n" +
                    "         ================================================================================================================\n" +
                    "         |       Cashier :  "+StockTracer.centerText(cashier_spaces,cashier)+"    Time Now :   "+StockTracer.centerText(time_space, LocalTime.now().format(TIME_FORMATTER))+"  |\n" +
                    "         ----------------------------------------------------------------------------------------------------------------\n" +
                    "         |       Shift Code : "+StockTracer.centerText(code_space,shiftCode)+"      Date  :      "+StockTracer.centerText(date_space,LocalDate.now().format(DATE_FORMATTER))+" |\n" +
                    "         --------------------------------------{ Select an Operation To Perform }----------------------------------------\n" +
                    "         |  - Purchase Items [P]                       - Sell Items [S]                   - List All in Stock Room [L]  |\n" +
                    "         |  - Search in Sales  [T]                     - Search in Stock Room [C]            - Search in Purchases [D]  |\n" +
                    "         |  - Change work Shift [W]                    -  Exit [Q]                                                      |\n" +
                    "         ----------------------------------------------------------------------------------------------------------------\n" +
                    "         |  Enter Selection  :      ");
             choice = input.nextLine().charAt(0);
            System.out.println("         ================================================================================================================");
            return choice;
        }
        catch (Exception e)
        {
            char c = invalidEntries();
            switch (c)
            {
                case 'n' :
                case 'N' : break;
                case 'y' :
                case 'Y' : choice = mainPanel(cashier,shiftCode);
            }

        }
        return choice;
    }

    public static LocalDate searchForTransaction(){

        try {
            System.out.print("         ================================================================================================================\n" +
                    "         |  Enter The Date of Transaction [dd-mm-yyyy] :     ");
            LocalDate transactionDate = LocalDate.parse(input.nextLine(), DATE_ENTERED_FORMATTER);
            System.out.println("         ----------------------------------------------------------------------------------------------------------------");
            return transactionDate;
        }
        catch (Exception e)
        {
            char c = invalidEntries();
            switch (c)
            {
                case 'n' :
                case 'N' : break;
                case 'y' :
                case 'Y' : return searchForTransaction();
            }
        }
        return null;
    }


    public static String[] shiftRegister(){

        System.out.print("\n" +
                "                                           =============================================\n" +
                "                                           |  Welcome to PharmaCare Management System  |\n" +
                "               =======================================================================================================\n" +
                "               |                                                                                                     |\n" +
                "               ----------------------------------{ Please Register to the shift }-------------------------------------\n" +
                "               | Cashier Name :     ");
        String cashierName = input.nextLine();
        System.out.println("               -------------------------------------------------------------------------------------------------------");
        System.out.print("               | Shift Code   :     ");
        String shiftCode = input.nextLine();
        System.out.println("               -------------------------------------------------------------------------------------------------------\n\n");
        return new String[]{cashierName,shiftCode};
    }

    public static void InvalidEntry() {
        System.out.println("         ==========================================[Invalid Entry .. Try Again]==========================================");
        System.out.println("         ================================================================================================================");
    }

    private static String drawSpace(int n){
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(Math.max(0, n)));
        return sb.toString();
    }

}
