package widyanto.fauzan.tugasakhir.Data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataRetrofit {

    private final static String Base_url = "https://api.jikan.moe/";
    private static Retrofit retrofit;

    public static Retrofit getData(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
