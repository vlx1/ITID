package observer;

import tokens.Token;

/**
 * Created by Viktor on 14.11.2016.
 */
public interface TokenHandler {
    void handleToken(Token token);
    String getName();
}
