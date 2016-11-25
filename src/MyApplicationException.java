import java.io.IOException;

/**
 * Created by Klaudia on 04.11.2016.
 */
public class MyApplicationException extends RuntimeException{
    public MyApplicationException(IOException e) {
        super(e);
    }
}
