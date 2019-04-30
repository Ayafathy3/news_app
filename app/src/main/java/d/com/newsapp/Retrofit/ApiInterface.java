package d.com.newsapp.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers("Cache-Control: public, max-age=640000, s-maxage=640000 , max-stale=2419200")
    @GET("https://newsapi.org/v2/top-headlines?country=eg&apiKey=10cf3320943a4423bb3d1a7d5c216052")
    Call<MainContent> getMainNews();

    @Headers("Cache-Control: public, max-age=640000, s-maxage=640000 , max-stale=2419200")
    @GET("https://newsapi.org/v2/top-headlines")
    Call<MainContent> getNewsContent( @Query("country") String country, @Query("category") String cat, @Query("apiKey") String apiKey );
}
