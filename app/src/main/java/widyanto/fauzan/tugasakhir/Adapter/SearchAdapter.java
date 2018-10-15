package widyanto.fauzan.tugasakhir.Adapter;

import android.content.Context;
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
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import widyanto.fauzan.tugasakhir.AnimeDetail;
import widyanto.fauzan.tugasakhir.Model.ResultItem;
import widyanto.fauzan.tugasakhir.Model.SearchAnime;
import widyanto.fauzan.tugasakhir.R;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {

    private List<ResultItem> resultItems;

    public SearchAdapter(List<ResultItem> resultItems) {
        this.resultItems = resultItems;
    }

    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_anime, viewGroup, false);
        return new SearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchHolder searchHolder, int i) {
        final ResultItem resultItem = resultItems.get(i);

        DecimalFormat members = (DecimalFormat) DecimalFormat.getNumberInstance();
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();

        formatSymbols.setGroupingSeparator('.');

        members.setDecimalFormatSymbols(formatSymbols);


        Picasso.get().load(resultItem.getImageUrl()).into(searchHolder.imageAnime);
        searchHolder.titleAnime.setText(String.valueOf(resultItem.getTitle()));
        searchHolder.typeAnime.setText(String.format("%s (%d)", resultItem.getType(), resultItem.getEpisodes()));
        searchHolder.membersAnime.setText(String.format("%s Members", members.format(resultItem.getMembers())));
        searchHolder.scoreAnime.setText(String.valueOf(resultItem.getScore()));

        searchHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(searchHolder.itemView.getContext(), AnimeDetail.class);
                i.putExtra("MAL_ID", resultItem.getMalId());
                searchHolder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultItems.size();
    }

    public class SearchHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imageAnime)
        ImageView imageAnime;
        @BindView(R.id.titleAnime)
        TextView titleAnime;
        @BindView(R.id.typeAnime)
        TextView typeAnime;
        @BindView(R.id.membersAnime)
        TextView membersAnime;
        @BindView(R.id.scoreAnime)
        TextView scoreAnime;
        @BindView(R.id.imgScore)
        ImageView imgScore;

        public SearchHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
