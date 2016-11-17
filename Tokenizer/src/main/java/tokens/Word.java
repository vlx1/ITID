package tokens;

/**
 * Created by Viktor on 14.11.2016.
 */
public class Word extends Token {

    public Word(){
        super();
    }
    public Word(int begin, int end, String text) {
        super(begin, end, text);
    }

}
