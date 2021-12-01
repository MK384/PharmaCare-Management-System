package records.area.head;

import dynamic.area.head.Order;
import records.area.handelers.Tokenizer;

public class OrderToken implements Token {

    String label;
    String plain;

    public OrderToken(String plain, String label) {
        this.label = label;
        this.plain = plain;
    }

    public OrderToken(String plain) {
        this.plain = plain;
        this.label = null;
    }

    public OrderToken() {
        this.label = null;
        this.plain = null;
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

}
