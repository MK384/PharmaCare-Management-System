package records.area.head;

import dynamic.area.head.Order;
import records.area.handelers.Tokenizer;

public class OrderToken implements Token {


    String label;
    String plain;

    public OrderToken(String label, String plain) {
        this.label = label;
        this.plain = plain;
    }

    public OrderToken(Order order) {
        plain = Tokenizer.makePlain(order, "null");
        label = null;
    }

    public OrderToken(Order order, String label) {
        this.label = label;
        plain = Tokenizer.makePlain(order, label);
    }

    public OrderToken() {
    }

    /**
     * @return String label of the token.
     */
    @Override
    public String getLabel() {
        return this.label;
    }

    /**
     * set the label of the token
     *
     * @param label
     */
    @Override
    public void setLabel(String label) {
        this.label = label;
        this.plain = Tokenizer.changeLabel(plain, label);
    }

    /**
     * @return String the plain form of the token.
     */
    @Override
    public String toString() {
        return this.plain;
    }

    public Order toOrder() {return Tokenizer.retrieveOrder(this.plain);}
}
