package widyanto.fauzan.tugasakhir.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import widyanto.fauzan.tugasakhir.Model.Aired;
import widyanto.fauzan.tugasakhir.Model.AnimeDetail;
import widyanto.fauzan.tugasakhir.Model.GenreItem;
import widyanto.fauzan.tugasakhir.Model.ProducerItem;
import widyanto.fauzan.tugasakhir.Model.StudioItem;
import widyanto.fauzan.tugasakhir.R;

public class AnimeDetailAdapter extends RecyclerView.Adapter<AnimeDetailAdapter.AnimeDetailHolder> {

    private List<AnimeDetail> animeDetailList;
    private List<Aired> airedList;
    private List<GenreItem> genreItemList;
    private List<ProducerItem> producerItemList;
    private List<StudioItem> studioItemList;

    public AnimeDetailAdapter(List<AnimeDetail> animeDetailList, List<GenreItem> genreItemList, List<ProducerItem> producerItemList, List<StudioItem> studioItemList) {
        this.animeDetailList = animeDetailList;
        this.genreItemList = genreItemList;
        this.producerItemList = producerItemList;
        this.studioItemList = studioItemList;
    }

    @NonNull
    @Override
    public AnimeDetailHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.anime_item_detail, viewGroup, false);
        return new AnimeDetailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeDetailHolder animeDetailHolder, int i) {
        final AnimeDetail animeDetail = animeDetailList.get(i);

        StringBuilder producerName = new StringBuilder();
        if (animeDetail.getProducer() != null){
            for (ProducerItem producer : animeDetail.getProducer()){
                producerName.append(producer.getName()).append(", ");
            }
        }

        StringBuilder studioName = new StringBuilder();
        if (animeDetail.getProducer() != null){
            for (StudioItem studioItem : animeDetail.getStudio()){
                if (animeDetail.getStudio().size() > 1){
                    studioName.append(studioItem.getName()).append(", ");
                }else {
                    studioName.append(studioItem.getName());
                }
            }
        }

        StringBuilder genresName = new StringBuilder();
                if (animeDetail.getGenre() != null){
                    for (GenreItem genreItem : animeDetail.getGenre()){
                        genresName.append(genreItem.getName()).append(", ");
                    }
                }


        animeDetailHolder.typeAnimeDetail.setText(String.format("Type : %s", animeDetail.getType()));
        animeDetailHolder.episodAnimeDetail.setText(String.format("Episodes : %d", animeDetail.getEpisodes()));
        animeDetailHolder.statusAnimeDetail.setText(String.format("Status : %s", animeDetail.getStatus()));
        animeDetailHolder.priemierAnimeDetail.setText(String.format("Premiered : %s", animeDetail.getPremiered()));
        animeDetailHolder.broadcastAnimeDetail.setText(String.format("Broadcast : %s", animeDetail.getBroadcast()));
        animeDetailHolder.producersAnimeDetail.setText(String.format("Producers : %s", producerName.toString()));
        animeDetailHolder.studiosAnimeDetail.setText(String.format("Studios : %s", studioName.toString()));
        animeDetailHolder.sourceAnimeDetail.setText(String.format("Source : %s", animeDetail.getSource()));
        animeDetailHolder.genresAnimeDetail.setText(String.format("Genres : %s", genresName.toString()));
        animeDetailHolder.durationAnimeDetail.setText(String.format("Duration : %s", animeDetail.getDuration()));
        animeDetailHolder.ratingAnieDetail.setText(String.format("Rating : %s", animeDetail.getRating()));
    }

    @Override
    public int getItemCount() {
        return animeDetailList.size();
    }

    public class AnimeDetailHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.typeAnimeDetail)
        TextView typeAnimeDetail;
        @BindView(R.id.episodAnimeDetail)
        TextView episodAnimeDetail;
        @BindView(R.id.statusAnimeDetail)
        TextView statusAnimeDetail;
        @BindView(R.id.priemierAnimeDetail)
        TextView priemierAnimeDetail;
        @BindView(R.id.broadcastAnimeDetail)
        TextView broadcastAnimeDetail;
        @BindView(R.id.producersAnimeDetail)
        TextView producersAnimeDetail;
        @BindView(R.id.studiosAnimeDetail)
        TextView studiosAnimeDetail;
        @BindView(R.id.sourceAnimeDetail)
        TextView sourceAnimeDetail;
        @BindView(R.id.genresAnimeDetail)
        TextView genresAnimeDetail;
        @BindView(R.id.durationAnimeDetail)
        TextView durationAnimeDetail;
        @BindView(R.id.ratingAnieDetail)
        TextView ratingAnieDetail;

        public AnimeDetailHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
