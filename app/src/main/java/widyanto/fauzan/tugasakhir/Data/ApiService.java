package widyanto.fauzan.tugasakhir.Data;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;
import widyanto.fauzan.tugasakhir.Model.AnimeDetail;
import widyanto.fauzan.tugasakhir.Model.TopAnime;

public interface ApiService {

    @GET("/v3/top/anime/1")
    Call<TopAnime> getAllAnime();

    @GET("/anime/{Mal_id}")
    Call<AnimeDetail> getAnimeDetail(@Path("Mal_id") String[] MalId);
}
