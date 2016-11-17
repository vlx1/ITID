import hendlers.TokenHandlerNumberImpl;
import hendlers.TokenHandlerSeparatorImpl;
import hendlers.TokenHandlerWordImpl;
import observer.TokenizerObservable;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Viktor on 17.11.2016.
 */
public class TestTokenizer {

    private final static String text = "John3/19/25Adams";

    private TokenizerObservable testingTokenizer;

    @Before
    public void setUp()
    {
        testingTokenizer = new Tokenizer();
        testingTokenizer.addTokenHandler(new TokenHandlerNumberImpl());
        //tokenizer.addTokenHandler(new TokenHandlerStandardOutputImpl());
        testingTokenizer.addTokenHandler(new TokenHandlerWordImpl());
        testingTokenizer.addTokenHandler(new TokenHandlerSeparatorImpl());
    }

    @Test
    public void testTokenizer() {

    }


}
