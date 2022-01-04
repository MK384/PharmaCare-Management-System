package access.head;

import dynamic.area.Pack;
import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;
import records.area.handelers.Tokenizer;
import records.area.head.OrderToken;
import records.area.head.PSToken;
import records.area.head.PackToken;
import records.area.head.Token;

/**
 * This interface is stereotype for conversion between the types of data in dynamic area and data handled in the files area..
 */
public interface TokenDTO {

    static Token toToken(Pack pack) {
        return new PackToken(Tokenizer.makePlain(pack, true));
    }

    static Token toToken(ProductStock ps, String label) {
        return new PSToken(Tokenizer.makePlain(ps, label), label);
    }

    static Token toToken(ProductStock ps) {
        return new PSToken(Tokenizer.makePlain(ps, "null"));
    }

    static Token toToken(Order order) {
        return new OrderToken(Tokenizer.makePlain(order, "null"));
    }

    static Token toToken(Order order, String label) {
        return new OrderToken(Tokenizer.makePlain(order, label), label);
    }

    static Pack toPack(Token token) {
        if (token instanceof PackToken) return Tokenizer.retrievePack(token.toString());
        else return null;
    }

    static Order toOrder(Token token) {
        if (token instanceof OrderToken) return Tokenizer.retrieveOrder(token.toString());
        else return null;
    }

    static ProductStock toPS(Token token) {
        if (token instanceof PSToken) return Tokenizer.retrievePS(token.toString());
        else return null;
    }

}
