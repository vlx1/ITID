import observer.TokenHandler;
import tokens.Token;

/**
 * Created by Viktor on 14.11.2016.
 */
public class TokenHandlerStandardOutputImpl implements TokenHandler {
    public void handleToken(Token token) {
        System.out.println("from: " + getName() + " " + token);
    }

    public String getName() {
        return "StandardIOHandler";
    }
}
