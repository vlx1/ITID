/**
 * Created by Viktor on 13.11.2016.
 */
public interface TokenizerObservable {
    void addTokenHandler(TokenHandler handler);
    void removeTokenHandler(String handlerName);
    void notifyHandlers(Token token);
    void tokenize(String text);
}
