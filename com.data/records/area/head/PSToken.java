package records.area.head;

import dynamic.area.head.ProductStock;
import records.area.handelers.Tokenizer;

public class PSToken implements Token {


    String plain;
    String label;

    public PSToken(String plain, String label) {
        this.plain = plain;
        this.label = label;
    }

    public PSToken(ProductStock ps) {
        plain = Tokenizer.makePlain(ps, "null");
        label = null;

    }

    public PSToken(ProductStock ps, String label) {
        plain = Tokenizer.makePlain(ps, label);
        this.label = label;
    }

    public PSToken() {
        label = null;
        plain = null;
    }

    /**
     * @return String label of the token.
     */
    @Override
    public String getLabel() {
        return label;
    }

    /**
     * set the label of the token
     *
     * @param label
     */
    @Override
    public void setLabel(String label) {
        this.label = label;
        plain = Tokenizer.changeLabel(plain, label);

    }

    /**
     * @return String the plain form of the token.
     */
    @Override
    public String toString() {
        return this.plain;
    }

    public ProductStock toPS() {return Tokenizer.retrievePS(this.plain);}
}
