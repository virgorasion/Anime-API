package widyanto.fauzan.tugasakhir.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import widyanto.fauzan.tugasakhir.AnimeDetail;
import widyanto.fauzan.tugasakhir.Model.TopAnimeItem;
import widyanto.fauzan.tugasakhir.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<TopAnimeItem> animeList;

    public RecyclerAdapter(List<TopAnimeItem> animeList) {
        this.animeList = animeList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.anime_item, viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder recyclerViewHolder, int i) {
        final TopAnimeItem topItem = animeList.get(i);

        DecimalFormat members = (DecimalFormat) DecimalFormat.getNumberInstance();
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();

        formatSymbols.setGroupingSeparator('.');

        members.setDecimalFormatSymbols(formatSymbols);

        Picasso.get().load(topItem.getImageUrl()).into(recyclerViewHolder.imageAnime);
        recyclerViewHolder.titleAnime.setText(topItem.getTitle());
        recyclerViewHolder.typeAnime.setText(String.format("%s (%d)", topItem.getType(), topItem.getEpisodes()));
        recyclerViewHolder.startEndAnime.setText(String.format("%s - %s", topItem.getStart_date(), topItem.getEnd_date()));
        recyclerViewHolder.membersAnime.setText(String.format("%s Members", members.format(topItem.getMembers())));
        recyclerViewHolder.scoreAnime.setText(String.valueOf(topItem.getScore()));
        recyclerViewHolder.imgScore.setImageResource(R.drawable.ic_star_score);
        
        recyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(recyclerViewHolder.itemView.getContext(), AnimeDetail.class);
                i.putExtra("MAL_ID", topItem.getMalId());
                recyclerViewHolder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageAnime)
        ImageView imageAnime;
        @BindView(R.id.titleAnime)
        TextView titleAnime;
        @BindView(R.id.typeAnime)
        TextView typeAnime;
        @BindView(R.id.startEndAnime)
        TextView startEndAnime;
        @BindView(R.id.membersAnime)
        TextView membersAnime;
        @BindView(R.id.scoreAnime)
        TextView scoreAnime;
        @BindView(R.id.imgScore)
        ImageView imgScore;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
