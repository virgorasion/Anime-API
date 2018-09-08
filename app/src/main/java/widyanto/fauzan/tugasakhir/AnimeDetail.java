package widyanto.fauzan.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        intent.getStringArrayExtra("MAL_ID");

        fragments = new ArrayList<>();
        fragments.add(new FragmentInformation());
        fragments.add(new FragmentSynopsis());

        tabTitle = new ArrayList<>();
        tabTitle.add("Information");
        tabTitle.add("Synopsis");

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),fragments,tabTitle));
        tabLayout.setupWithViewPager(viewPager);

        ApiService apiService = DataRetrofit.getData().create(ApiService.class);
        apiService.getAnimeDetail(intent.getStringArrayExtra("MAL_ID")).enqueue(new Callback<widyanto.fauzan.tugasakhir.Model.AnimeDetail>() {
            @Override
            public void onResponse(Call<widyanto.fauzan.tugasakhir.Model.AnimeDetail> call, Response<widyanto.fauzan.tugasakhir.Model.AnimeDetail> response) {
                Aired itemsAired = response.body().getAired();
                List<GenreItem> itemsGenre = response.body().getGenre();
                List<ProducerItem> itemsProducer = response.body().getProducer();
                List<StudioItem> itemsStudio = response.body().getStudio();

                DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getNumberInstance();
                DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
                formatSymbols.setGroupingSeparator('.');
                decimalFormat.setDecimalFormatSymbols(formatSymbols);

                TitleAnime.setText(response.body().getTitleEnglish());
                Picasso.get().load(response.body().getImageUrl()).into(imageAnime);
                animeScore.setText(String.valueOf(response.body().getScore()));
                animeRanked.setText(String.valueOf(response.body().getRank()));
                animePopularity.setText(String.valueOf(response.body().getPopularity()));
                animeMembers.setText(String.valueOf(decimalFormat.format(response.body().getMembers())));
                animeFavorites.setText(String.valueOf(response.body().getFavorites()));

                adapter = new AnimeDetailAdapter(itemsGenre ,itemsProducer,itemsStudio );
            }

            @Override
            public void onFailure(Call<widyanto.fauzan.tugasakhir.Model.AnimeDetail> call, Throwable t) {

            }
        });
    }
}
