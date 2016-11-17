package hendlers;

import observer.TokenHandler;
import tokens.Separator;
import tokens.Token;

/**
 * Created by Viktor on 14.11.2016.
 */
public class TokenHandlerSeparatorImpl implements TokenHandler {
    public void handleToken(Token token) {
        if (token.getClass().getName().equals(Separator.class.getName())) {
            System.out.println("from: "  + getName() + " I'm separator! " + token);
        }
    }

    public String getName() {
        return "SeparatorHandler";
    }
}
