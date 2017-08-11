package challenge.github.alc.com.bakingapp.networkUtills;

import java.io.IOException;
import java.lang.annotation.Annotation;

import challenge.github.alc.com.bakingapp.pojo.APIError;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by Gino Osahon on 10/08/2017.
 */
public class ErrorUtils {

    public static APIError parseError(Response<?> response) {

        Converter<ResponseBody, APIError> converter =
                iRecipe.retrofit()
                        .responseBodyConverter(APIError.class, new Annotation[0]);

        APIError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new APIError();
        }

        return error;
    }
}
