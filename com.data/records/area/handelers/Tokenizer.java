package records.area.handelers;

import dynamic.area.*;
import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;

public class Tokenizer {


    private static String toField(String s, String var) {
        return "[" + s + '@' + var + "]";
    }

    private static String appendLabel(String label, String s) {
        return '#' + label + '#' + ' ' + s;
    }

    private static String makePlain(Product p) {

        String plain = toField(p.getName(), "name") + toField(Integer.toString(p.getID()), "id");
        if (p instanceof MedicalDrug)
            plain += toField(((MedicalDrug) p).getCategory(), "category");
        else if (p instanceof Cosmetics)
            plain += toField(((Cosmetics) p).getType(), "type");
        else if (p instanceof MedicalEquipment)
            plain += toField(((MedicalEquipment) p).getSize(), "size");

        return plain;
    }

    // plain without label
    public static String makePlain(Pack p) {

        return ('<' + makePlain(p.getProduct()) + '>' +
                ' ' + toField(Integer.toString(p.getQuantity()), "quantity") +
                ' ' + toField(p.getExpDate().toString(), "expDate") +
                ' ' + toField(p.getLoadDate().toString(), "loadDate") +
                ' ' + toField(p.getProvider(), "provider") +
                ' ' + toField(Double.toString(p.getPrice()), "price"));
    }

    // plain with label appended
    public static String makePlain(Pack p, String label) {
        return appendLabel(makePlain(p), label);
    }

    public static String makePlain(ProductStock ps, String label) {

        StringBuilder sb = new StringBuilder();
        sb.append('<').append(makePlain(ps.getProduct())).append('>').append(' ');
        sb.append(toField(ps.getPartPlace(), "partPlace")).append(' ');

        sb.append("{ ");
        for (Pack p : ps) {
            sb.append(makePlain(p));
            sb.append(' ');
        }
        sb.append('}');

        return appendLabel(label, sb.toString());
    }

    public static String makePlain(ProductStock ps) {
        return makePlain(ps, "PSToken");
    }


    public static String makePlain(Order order, String label) {

        StringBuilder sb = new StringBuilder();

        sb.append(toField(order.getClient(), "client")).append(' ');
        sb.append(toField(order.getOrderingDate().toString(), "orderDate")).append(' ');
        sb.append(toField(Double.toString(order.getDiscount()), "discount")).append(' ');

        sb.append("{ ");
        for (Pack p : order) {
            sb.append(makePlain(p));
            sb.append(' ');
        }
        sb.append('}');

        return appendLabel(label, sb.toString());
    }

    public static String makePlain(Order order) {
        return makePlain(order, "OToken");
    }

}

