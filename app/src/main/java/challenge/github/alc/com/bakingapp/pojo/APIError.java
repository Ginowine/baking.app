package challenge.github.alc.com.bakingapp.pojo;

/**
 * Created by Gino Osahon on 10/08/2017.
 */
public class APIError {

    private int statusCode;
    private String message;

    public APIError() {
    }

    public int status() {
        return statusCode;
    }

    public String message() {
        return message;
    }
}
