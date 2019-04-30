package d.com.newsapp.Retrofit;

import android.content.Context;

import java.io.File;

import d.com.newsapp.Utils.NetworkUtils;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static final String BASE_URL = "https://newsapi.org/v2/top-headlines/";
    private static Retrofit retrofit = null;
    private static OkHttpClient client;
    private static Cache cache;
    private static Context mContext;

    public static Retrofit getRetrofit( Context context ) {
        mContext = context;
        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        client = new OkHttpClient.Builder()
                .cache(cache)
                .addNetworkInterceptor(NetworkUtils.REWRITE_CACHE_CONTROL_INTERCEPTOR(context))
                .build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }

        return retrofit;
    }
}
