package widyanto.fauzan.tugasakhir.Data;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Query;
import widyanto.fauzan.tugasakhir.Model.AnimeDetail;
import widyanto.fauzan.tugasakhir.Model.SearchAnime;
import widyanto.fauzan.tugasakhir.Model.TopAnime;

public interface ApiService {

    @GET("/v3/top/anime/{page}")
    Call<TopAnime> getAllAnime(@Path("page") int page);

    @GET("/v3/top/anime/1/airing")
    Call<TopAnime> getTopAiring();

    @GET("/v3/top/anime/1/movie")
    Call<TopAnime> getTopMovie();

    @GET("/v3/top/anime/1/ova")
    Call<TopAnime> getTopOva();

    @GET("/v3/top/anime/1/special")
    Call<TopAnime> getTopSpecial();

    @GET("/v3/top/anime/1/tv")
    Call<TopAnime> getTopTv();

    @GET("/v3/top/anime/1/upcoming")
    Call<TopAnime> getTopUpcoming();

    @GET("/search/anime")
    Call<SearchAnime> getSearchResult(@Query("q") String query);

    @GET("/anime/{Mal_id}")
    Call<AnimeDetail> getAnimeDetail(@Path("Mal_id") int MalId);


}
