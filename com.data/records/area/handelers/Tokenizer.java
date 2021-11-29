package records.area.handelers;

import dynamic.area.*;
import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;
import dynamic.area.head.orderImp;

import java.util.Date;

public class Tokenizer {


    private static String toField(String s, String var) {
        return "[" + s + '@' + var + "]";
    }

    private static String appendLabel(String label, String s) {
        return '#' + label + '#' + ' ' + s;
    }

    private static String[] varsInFields(String text) {
        String[] fields = text.split("\\[");
        for (int i = 1; i < fields.length; i++)
            fields[i] = fields[i].substring(fields[i].indexOf('@') + 1, fields[i].indexOf(']'));
        return fields;
    }

    private static String[] valsInFields(String text) {
        String[] fields = text.split("\\[");
        for (int i = 1; i < fields.length; i++)
            fields[i] = fields[i].substring(0, fields[i].indexOf('@'));
        return fields;
    }

    private static String[] packsInFields(String text){
        // text = {[][][]&[][][]&[][][]}

        String packsPlain = text.substring(text.indexOf('{')+1,text.indexOf('}'));
        return packsPlain.split("&");
    }

    public static Product retrieveProduct(String plain) {

        String[] vars = Tokenizer.varsInFields(plain);
        String[] vals = Tokenizer.valsInFields(plain);
        Product p = ProductFactory.generateProduct(vals[3], vars[3]);

        assert p != null;
        p.setName(vals[1]);
        p.setID(Integer.parseInt(vals[2]));

        return p;
    }

    public static Pack retrievePack(String plain) {
        Pack pack;

        int isProduced = plain.indexOf('<');
        if (isProduced >= 0)
            pack = new Pack(retrieveProduct(plain.substring(isProduced + 1, plain.indexOf('>'))));
        else
            pack = new Pack(null);

        String[] vals = Tokenizer.valsInFields(plain.substring('['));

        pack.setQuantity(Integer.parseInt(vals[1]));
        pack.setExpDate(new Date(vals[2]));
        pack.setLoadDate(new Date(vals[3]));
        pack.setProvider(vals[4]);
        pack.setPrice(Double.parseDouble(vals[5]));

        return pack;
    }

    public static ProductStock retrievePS (String plain){


        //  Must have an implementation of ProductStock first !! //


        return null;
    }

    public static Order retrieveOrder (String plain){

        String[] vals = Tokenizer.valsInFields(plain.substring(plain.indexOf('['),plain.indexOf('{')));
        Order order = new orderImp(vals[1],new Date(vals[2]));
        order.setDiscount(Double.parseDouble(vals[3]));

        String []packs = Tokenizer.packsInFields(plain.substring(plain.indexOf('{')));

        for (String s: packs)
            order.addItem(retrievePack(s));

        return order;
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
    public static String makePlain(Pack p, boolean addProduct) {

        return addProduct ? ('<' + makePlain(p.getProduct()) + '>'

                + toField(Integer.toString(p.getQuantity()), "quantity")
                + toField(p.getExpDate().toLocaleString(), "expDate")
                + toField(p.getLoadDate().toLocaleString(), "loadDate")
                + toField(p.getProvider(), "provider")
                + toField(Double.toString(p.getPrice()), "price"))
                :
                (toField(Integer.toString(p.getQuantity()), "quantity")
                        + toField(p.getExpDate().toLocaleString(), "expDate")
                        + toField(p.getLoadDate().toLocaleString(), "loadDate")
                        + toField(p.getProvider(), "provider")
                        + toField(Double.toString(p.getPrice()), "price"));

    }

    // plain with label appended
    public static String makePlain(Pack p, String label) {
        return appendLabel(makePlain(p, true), label);
    }

    public static String makePlain(ProductStock ps, String label) {

        StringBuilder sb = new StringBuilder();
        sb.append('<').append(makePlain(ps.getProduct())).append('>');
        sb.append(toField(ps.getPartPlace(), "partPlace"));

        sb.append("{");
        for (Pack p : ps) {
            // don't append Product with every pack as it first referenced
            sb.append(makePlain(p, false));
            sb.append('&'); // states another pack
        }
        // deletes the last &
        sb.deleteCharAt(sb.lastIndexOf("&"));
        sb.append("}");

        return appendLabel(label, sb.toString());
    }

    public static String makePlain(Order order, String label) {

        StringBuilder sb = new StringBuilder();

        sb.append(toField(order.getClient(), "client"));
        sb.append(toField(order.getOrderingDate().toLocaleString(), "orderDate"));
        sb.append(toField(Double.toString(order.getDiscount()), "discount"));

        sb.append("{");
        for (Pack p : order) {
            sb.append(makePlain(p, true));
            sb.append('&');
        }
        // deletes the last &
        sb.deleteCharAt(sb.lastIndexOf("&"));
        sb.append("}");

        return appendLabel(label, sb.toString());
    }

    public static String changeLabel(String plain , String newLabel)
    {
        return Tokenizer.appendLabel(newLabel,plain.substring(plain.indexOf('#',plain.indexOf('#')+1)));
    }

    private static class ProductFactory {

        static Product generateProduct(String val, String var) {

            Product p;

            switch (var) {
                case "size": {
                    p = new MedicalEquipment();
                    ((MedicalEquipment) p).setSize(val);
                    break;
                }
                case "category": {
                    p = new MedicalDrug();
                    ((MedicalDrug) p).setCategory(val);
                    break;
                }
                case "type": {
                    p = new Cosmetics();
                    ((Cosmetics) p).setType(val);
                    break;
                }
                default:
                    return null;
            }
            return p;
        }
    }
}

