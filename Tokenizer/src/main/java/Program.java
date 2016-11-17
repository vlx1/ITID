import hendlers.TokenHandlerNumberImpl;
import hendlers.TokenHandlerSeparatorImpl;
import hendlers.TokenHandlerWordImpl;
import observer.TokenizerObservable;

/**
 * Created by Viktor on 14.11.2016.
 */
public class Program {
    public static void main(String[] args) {
        String text = "*saffsa*()&21840..80jfsa78f798*";
        //String text = "80jsadsa3232";
        //String text = "jfsa78ds87";
        TokenizerObservable tokenizer = new Tokenizer();
        tokenizer.addTokenHandler(new TokenHandlerNumberImpl());
        //tokenizer.addTokenHandler(new TokenHandlerStandardOutputImpl());
        tokenizer.addTokenHandler(new TokenHandlerWordImpl());
        tokenizer.addTokenHandler(new TokenHandlerSeparatorImpl());

        tokenizer.tokenize(text);
    }
}
