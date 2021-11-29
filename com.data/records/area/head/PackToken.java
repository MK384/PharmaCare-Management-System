package records.area.head;

import dynamic.area.Pack;
import records.area.handelers.Tokenizer;

public class PackToken implements Token {


    private final String plain;

    public PackToken(Pack pack, String label) {


        plain = Tokenizer.makePlain(pack,label);
    }

    public PackToken(Pack pack) {

        plain = Tokenizer.makePlain(pack,true);    }

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

    public Pack toPack() {return Tokenizer.retrievePack(this.plain);}

}
