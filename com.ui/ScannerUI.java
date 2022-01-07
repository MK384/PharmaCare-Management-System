import dynamic.area.Pack;
import dynamic.area.Product;
import dynamic.area.head.Order;
import dynamic.area.head.OrderImp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerUI {

    private final static Scanner input = new Scanner(System.in);

    private static final DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static final int order_date_length = "                                                           ".length();

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
        System.out.print("| Purchases Directory : ");
        String purchaseskDir = input.nextLine();
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        return new String[]{stockDir, saleskDir, purchaseskDir};
    }

    private static String scanPurchaseHeader() {

        System.out.println("");
        System.out.println("");
        System.out.print("================================================================================\n" +
                "|                              [ Make Purchase ]                               |\n" +
                "================================================================================\n" +
                "|   Merchant Name  :      ");
        String Merchant_Name = input.nextLine();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|   Order date     :"+StockTracer.centerText(order_date_length,LocalDate.now().toString())+"|");
        System.out.println("================================================================================\n" +
                "|                                                                              |");
        return Merchant_Name;
    }

    private static String scanSaleHeader() {
        System.out.print("================================================================================\n" +
                "|                                [ Make Sale ]                                 |\n" +
                "================================================================================\n" +
                "|           Client Name :    ");
        String client = input.nextLine();
        System.out.println("================================================================================\n" +
                "|                                                                              |");
        return client;
    }

    private static List<Pack> scanPurchasedProducts(int Num) {

        List<Pack> packList = new ArrayList<>();

        try {
            System.out.println("================================{Product" + StockTracer.centerText("    ".length(), String.valueOf(Num)) + "}===================================");
            System.out.print("| Product Name :       ");
            String Product_Name = input.nextLine();
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("| Product ID :       ");
            int ID = Integer.parseInt(input.nextLine());
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("| Type [C: cosmetics | M: MedicalDrug | E: Equipment] :    ");
            char type = input.nextLine().charAt(0);
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("| Quantity :       ");
            int quantity = Integer.parseInt(input.nextLine());
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("| Price :       ");
            double price = Double.parseDouble(input.nextLine());
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("| Discount :       ");
            double discount = Double.parseDouble(input.nextLine());
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("| Part Place :       ");
            String partPlace = input.nextLine();
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("| Exp. Date [dd-mm-yyyy] :       ");
            LocalDate expDate = LocalDate.parse(input.nextLine(), myFormatter);

            System.out.print("================================================================================\n" +
                    "| Another Product [Y: Yes | N: No]    :         ");
            char action = input.nextLine().charAt(0);
            System.out.println("--------------------------------------------------------------------------------");

            Product p = ProductFactory.generateProduct(type);
            assert p != null;
            p.setName(Product_Name);
            p.setID(ID);
            Pack pack = new Pack(p);
            pack.setQuantity(quantity);
            pack.setExpDate(expDate);
            pack.setLoadDate(LocalDate.now());
            pack.setPrice(price);

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

    private static List<Pack> scanSoldProducts(int Num) {

        List<Pack> packList = new ArrayList<>();
        try {
            System.out.println("================================{Product" + StockTracer.centerText("    ".length(), String.valueOf(Num)) + "}===================================");
            System.out.print("| Product Name :       ");
            String Product_Name = input.nextLine();
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("| Product ID :       ");
            int ID = Integer.parseInt(input.nextLine());
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("| Type [C: cosmetics | M: MedicalDrug | E: Equipment] :    ");
            char type = input.nextLine().charAt(0);
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("| Quantity :       ");
            int quantity = Integer.parseInt(input.nextLine());
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("| Discount :       ");
            double discount = Double.parseDouble(input.nextLine());
            System.out.println("--------------------------------------------------------------------------------");

            System.out.print("================================================================================\n" +
                    "| Another Product [Y: Yes | N: No]    :         ");
            char action = input.nextLine().charAt(0);
            System.out.println("--------------------------------------------------------------------------------");


            Product p = ProductFactory.generateProduct(type);
            assert p != null;
            p.setName(Product_Name);
            p.setID(ID);
            Pack pack = new Pack(p);
            pack.setQuantity(quantity);

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
        System.out.print("                             [  Invalid Entries  ]\n" +
                "================================================================================\n" +
                "|          Try Again [Y: Yes | N: No]  :      ");
        char answer = input.nextLine().charAt(0);
        System.out.println("--------------------------------------------------------------------------------");
        return answer;
    }



    public static Order makePurchase(){

        String merchant = scanPurchaseHeader();
        List<Pack> packList = scanPurchasedProducts(1);
        Order order = new OrderImp(merchant,LocalDate.now());

        for (Pack pack: packList)
            order.addItem(pack);

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
        System.out.print("================================================================================\n" +
                "|  Enter Product Name or ID :       ");
        String id_name = input.nextLine();
        try {

            p.setID(Integer.parseInt(id_name));
        }
        catch (Exception e)
        {
            p.setName(id_name);
        }
        System.out.println("--------------------------------------------------------------------------------");
        return p;
    }

    public static char inventoryPanel(){
        char choice = 'n';
        try {
            System.out.println("");
            System.out.println("");
            System.out.print("================================================================================\n" +
                    "|                           |[ INVENTORY PANEL ]|                              |\n" +
                    "--------------------------------------------------------------------------------\n" +
                    "|                         {Select Action To perform}                           |\n" +
                    "--------------------------------------------------------------------------------\n" +
                    "|  - Purchase Items [P]         - Sell Items [S]        - Search in Stock [C]  |\n" +
                    "|  - Search Sells Transaction [T]          - Search Purchased Transaction [D]  |\n" +
                    "|  - List whole Stock Room [L]                                    -  Exit [Q]  |\n" +
                    "--------------------------------------------------------------------------------\n" +
                    "|  Enter Selection  :           ");
             choice = input.nextLine().charAt(0);
            System.out.println("================================================================================");
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
                case 'Y' : choice = inventoryPanel();
            }

        }
        return choice;
    }


    public static LocalDate searchForTransaction(){

        try {
            System.out.print("                          |[ Search Transactions ]| \n" +
                    "================================================================================\n" +
                    "|  Enter Date of Transaction [dd-mm-yyyy] :  ");
            LocalDate transactionDate = LocalDate.parse(input.nextLine(), myFormatter);
            System.out.println("--------------------------------------------------------------------------------");
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




}
