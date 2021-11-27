package records.area.head;

import dynamic.area.Pack;
import records.area.handelers.Tokenizer;

public class PackToken implements Token {

    private String label;

    private final String plain;

    public PackToken(Pack pack, String label) {

        this.label = label;

        plain = Tokenizer.makePlain(pack,label);
    }

    public PackToken(Pack pack) {
        this.label = null;

        plain = Tokenizer.makePlain(pack);    }

    public PackToken(String plain, String label) {
        this.label = label;
        this.plain = plain;
    }

    public PackToken(String plain) {
        this(plain , "null");
    }

//---------------------------------------------//
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
    }

    /**
     * @return String the plain form of the token.
     */
    @Override
    public String toPlain() {
        return plain;
    }

}
