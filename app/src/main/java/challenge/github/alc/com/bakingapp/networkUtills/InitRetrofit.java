package challenge.github.alc.com.bakingapp.networkUtills;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gino Osahon on 04/08/2017.
 */
public class InitRetrofit {

    public InitRetrofit(){

    }

    static String API_BASE_URL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/";
    static OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
    static Gson gson = new GsonBuilder().create();

    static Retrofit.Builder builder =
            new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson));


    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder
                .client(httpClientBuilder.build()
                ).build();
        return retrofit.create(serviceClass);
    }


    public static Retrofit retrofit() { // For Error Handing when non-OK response is received from Server
        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        OkHttpClient client = httpClient;
        return builder.client(client).build();
    }
}
