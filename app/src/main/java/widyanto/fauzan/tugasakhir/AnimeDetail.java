package widyanto.fauzan.tugasakhir;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import widyanto.fauzan.tugasakhir.Adapter.AnimeDetailAdapter;
import widyanto.fauzan.tugasakhir.Adapter.ViewPagerAdapter;
import widyanto.fauzan.tugasakhir.Data.ApiService;
import widyanto.fauzan.tugasakhir.Data.DataRetrofit;
import widyanto.fauzan.tugasakhir.Model.Aired;
import widyanto.fauzan.tugasakhir.Model.GenreItem;
import widyanto.fauzan.tugasakhir.Model.ProducerItem;
import widyanto.fauzan.tugasakhir.Model.StudioItem;

public class AnimeDetail extends AppCompatActivity {

    @BindView(R.id.TitleAnime)
    TextView TitleAnime;
    @BindView(R.id.jenis)
    TextView jenis;
    @BindView(R.id.imageAnime)
    ImageView imageAnime;
    @BindView(R.id.animeScore)
    TextView animeScore;
    @BindView(R.id.animeRanked)
    TextView animeRanked;
    @BindView(R.id.animePopularity)
    TextView animePopularity;
    @BindView(R.id.animeMembers)
    TextView animeMembers;
    @BindView(R.id.animeFavorites)
    TextView animeFavorites;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private List<Fragment> fragments;
    private List<String> tabTitle;
    private RecyclerView.Adapter adapter;
    private FragmentInformation fragmentInformation;
    private FragmentSynopsis fragmentSynopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        int Mal_id = intent.getIntExtra("MAL_ID",1);

        ApiService apiService = DataRetrofit.getData().create(ApiService.class);
        apiService.getAnimeDetail(Mal_id).enqueue(new Callback<widyanto.fauzan.tugasakhir.Model.AnimeDetail>() {
            @Override
            public void onResponse(Call<widyanto.fauzan.tugasakhir.Model.AnimeDetail> call, Response<widyanto.fauzan.tugasakhir.Model.AnimeDetail> response) {
                List<widyanto.fauzan.tugasakhir.Model.AnimeDetail> animeDetailList = new ArrayList<>();
                widyanto.fauzan.tugasakhir.Model.AnimeDetail animeDetail = response.body();
                List<GenreItem> itemsGenre = animeDetail.getGenre();
                List<ProducerItem> itemsProducer = animeDetail.getProducer();
                List<StudioItem> itemsStudio = animeDetail.getStudio();
                animeDetailList.add(animeDetail);

                DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getNumberInstance();
                DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
                formatSymbols.setGroupingSeparator('.');
                decimalFormat.setDecimalFormatSymbols(formatSymbols);

                TitleAnime.setText(animeDetail.getTitle());
                Picasso.get().load(animeDetail.getImageUrl()).into(imageAnime);
                animeScore.setText(String.format("Score : %s",String.valueOf(animeDetail.getScore())));
                animeRanked.setText(String.format("Ranked : %s",String.valueOf(animeDetail.getRank())));
                animePopularity.setText(String.format("Popularity : %s",String.valueOf(animeDetail.getPopularity())));
                animeMembers.setText(String.format("Members : %s",String.valueOf(decimalFormat.format(animeDetail.getMembers()))));
                animeFavorites.setText(String.format("Favorites : %s",String.valueOf(animeDetail.getFavorites())));

                fragmentInformation = new FragmentInformation();
                fragmentInformation.setAnimeDetailList(animeDetailList);
                fragmentInformation.setGenreItemList(itemsGenre);
                fragmentInformation.setProducerItemList(itemsProducer);
                fragmentInformation.setStudioItemList(itemsStudio);

                fragmentSynopsis = new FragmentSynopsis();
                fragmentSynopsis.setSynopsis(animeDetail.getSynopsis());

                fragments = new ArrayList<>();
                fragments.add(fragmentInformation);
                fragments.add(fragmentSynopsis);

                tabTitle = new ArrayList<>();
                tabTitle.add("Information");
                tabTitle.add("Synopsis");

                viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),fragments,tabTitle));
                tabLayout.setupWithViewPager(viewPager);

            }

            @Override
            public void onFailure(Call<widyanto.fauzan.tugasakhir.Model.AnimeDetail> call, Throwable t) {

            }
        });
    }
}
