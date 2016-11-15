/**
 * Created by Viktor on 14.11.2016.
 */
public class Number extends Token {
    private int value;

    public Number(){
        super();
    }

    public Number(int begin, int end, String text, int value)
    {
        super(begin, end, text);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
