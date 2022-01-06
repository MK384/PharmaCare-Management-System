import dynamic.area.Cosmetics;
import dynamic.area.MedicalDrug;
import dynamic.area.MedicalEquipment;
import dynamic.area.Product;

public class ProductFactory {

    public static Product generateProduct(char c){

        Product p;
        return switch (c) {
            case 'c', 'C' -> new Cosmetics();
            case 'm', 'M' -> new MedicalDrug();
            case 'e', 'E' -> new MedicalEquipment();
            default -> null;
        };
    }

}
