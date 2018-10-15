package widyanto.fauzan.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import widyanto.fauzan.tugasakhir.Adapter.ViewPagerAdapter;
import widyanto.fauzan.tugasakhir.Data.ApiService;
import widyanto.fauzan.tugasakhir.Data.DataRetrofit;
import widyanto.fauzan.tugasakhir.Model.GenreItem;
import widyanto.fauzan.tugasakhir.Model.ProducerItem;
import widyanto.fauzan.tugasakhir.Model.StudioItem;

public class AnimeDetail extends AppCompatActivity {

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
    @BindView(R.id.Loading)
    ProgressBar Loading;
    @BindView(R.id.LoadingPager)
    ProgressBar LoadingPager;
    @BindView(R.id.animeType)
    TextView animeType;


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
        int Mal_id = intent.getIntExtra("MAL_ID", 1);
        String Anime_Name = intent.getStringExtra("Anime_Name");
        getSupportActionBar().setTitle(Anime_Name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ResponseData(Mal_id);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void ResponseData(int Mal_id) {
        ApiService apiService = DataRetrofit.getData().create(ApiService.class);
        Loading.setVisibility(View.VISIBLE);
        LoadingPager.setVisibility(View.VISIBLE);
        imageAnime.setVisibility(View.GONE);
        viewPager.setVisibility(View.GONE);

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

                Loading.setVisibility(View.GONE);
                LoadingPager.setVisibility(View.GONE);
                imageAnime.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.VISIBLE);

                Picasso.get().load(animeDetail.getImageUrl()).into(imageAnime);
                animeType.setText(String.format("Type : %s", String.valueOf(animeDetail.getType())));
                animeScore.setText(String.format("Score : %s", String.valueOf(animeDetail.getScore())));
                animeRanked.setText(String.format("Ranked : %s", String.valueOf(animeDetail.getRank())));
                animePopularity.setText(String.format("Popularity : %s", String.valueOf(animeDetail.getPopularity())));
                animeMembers.setText(String.format("Members : %s", String.valueOf(decimalFormat.format(animeDetail.getMembers()))));
                animeFavorites.setText(String.format("Favorites : %s", String.valueOf(animeDetail.getFavorites())));

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

                viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments, tabTitle));
                tabLayout.setupWithViewPager(viewPager);

            }

            @Override
            public void onFailure(Call<widyanto.fauzan.tugasakhir.Model.AnimeDetail> call, Throwable t) {

            }
        });
    }
}
