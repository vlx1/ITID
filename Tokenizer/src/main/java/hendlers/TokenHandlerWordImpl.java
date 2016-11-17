package hendlers;

import observer.TokenHandler;
import tokens.Token;
import tokens.Word;

/**
 * Created by Viktor on 14.11.2016.
 */
public class TokenHandlerWordImpl implements TokenHandler {
    public void handleToken(Token token) {
        if ( token.getClass().getName().equals(Word.class.getName())) {
            System.out.println("from: " + " " + getName() + " I'm word! " + token);
        }
    }

    public String getName() {
        return "WordHandler";
    }
}
