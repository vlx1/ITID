import sun.security.jgss.spnego.NegTokenInit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Viktor on 14.11.2016.
 */
public class Tokenizer implements TokenizerObservable {
    private Map<String, TokenHandler> handlers;

    private static final String PUNCT = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n\t ";

    public Tokenizer() {
        handlers = new HashMap<String, TokenHandler>();
    }
    public void addTokenHandler(TokenHandler handler) {
        handlers.put(handler.getName(), handler);
    };
    public void removeTokenHandler(String handlerName) {
        handlers.remove(handlerName);
    };
    public void notifyHandlers(Token token){
        Set<Map.Entry<String,TokenHandler>> entries = handlers.entrySet();

        for(Map.Entry<String, TokenHandler> entry : entries)
        {
            TokenHandler currentHandler = entry.getValue();
            currentHandler.handleToken(token);
        }
    };
    public void tokenize(String text) {
        char[] textAsCharArray = text.toCharArray();
        StringBuilder token = new StringBuilder();
        boolean onWord = false;
        boolean onNumber = false;
        char currentChar = 0;
        int begin = 0;

        for (int i = 0; i < textAsCharArray.length; i++) {
            currentChar = textAsCharArray[i];

            if (Character.isLetter(currentChar)) {
                if (!onWord) {

                    if(onNumber) {
                        notifyHandlers(new Number(begin, i - 1, token.toString(), Integer.parseInt(token.toString())));
                        token.delete(0, token.length());
                    }
                    begin = i;
                }
                token.append(currentChar);
                onWord = true;
                onNumber = false;
                if (textAsCharArray.length-1==i)
                    notifyHandlers(new Word(begin, i, token.toString()));
            } else if (onWord) {
                onWord = false;
                notifyHandlers(new Word(begin, i - 1, token.toString()));
                token.delete(0, token.length());
                i=i-1;
                continue;
            }
            if (Character.isDigit(currentChar)) {
                if (!onNumber) {
                    begin = i;
                    //onNumber = true;
                }
                onNumber = true;
                onWord = false;
                token.append(currentChar);
                if (textAsCharArray.length-1==i)
                    notifyHandlers(new Number(begin, i, token.toString(), Integer.parseInt(token.toString())));

            } else if (onNumber) {
                onNumber = false;
                notifyHandlers(new Number(begin, i - 1, token.toString(), Integer.parseInt(token.toString())));
                token.delete(0, token.length());
                i=i-1;
                continue;
            }
            if (!Character.isLetter(currentChar) && !Character.isDigit(currentChar)) {
                notifyHandlers(new Separator(i, i, String.valueOf(currentChar)));
                token.delete(0, token.length());

            }
        }

    }
}
