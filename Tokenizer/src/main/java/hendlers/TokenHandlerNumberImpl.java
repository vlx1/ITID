package hendlers;

import observer.TokenHandler;
import tokens.Token;

/**
 * Created by Viktor on 14.11.2016.
 */
public class TokenHandlerNumberImpl implements TokenHandler {
    public void handleToken(Token token){
        /*
        String tokenclass = token.getClass().getName();
        String numberclass = tokens.Number.class.getName();
        */
        if (token.getClass().getName().equals(tokens.Number.class.getName())){
            System.out.println("from: " + getName() + " I'm on number! " + token);
        }
    };
    public String getName(){
        return "NumberHandler";
    };
}
