package records.area.head;

import dynamic.area.Pack;
import records.area.handelers.Tokenizer;

public class PackToken implements Token {


    private final String plain;

    public PackToken(String plain) {
        this.plain = plain;

    }
    //---------------------------------------------//
    /**
     * not supported!!
     */

    @Override
    public String getLabel() {
        return null;
    }

    /**
     * not supported!!
     */
    @Override
    public void setLabel(String label) {
    }

    /**
     * @return String the plain form of the token.
     */
    @Override
    public String toString() {
        return this.plain;
    }


}
