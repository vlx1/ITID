/**
 * Created by Viktor on 14.11.2016.
 */
public class TokenHandlerNumberImpl implements TokenHandler {
    public void handleToken(Token token){
        if (token.getClass().getName().equals(Number.class.getName())){
            System.out.println("from: " + getName() + " I'm on number! " + token);
        }
    };
    public String getName(){
        return "NumberHandler";
    };
}
