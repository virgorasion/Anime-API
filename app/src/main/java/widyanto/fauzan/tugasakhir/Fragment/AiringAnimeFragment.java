package widyanto.fauzan.tugasakhir.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import widyanto.fauzan.tugasakhir.Adapter.RecyclerAdapter;
import widyanto.fauzan.tugasakhir.Adapter.SearchAdapter;
import widyanto.fauzan.tugasakhir.Data.ApiService;
import widyanto.fauzan.tugasakhir.Data.DataRetrofit;
import widyanto.fauzan.tugasakhir.Model.TopAnime;
import widyanto.fauzan.tugasakhir.Model.TopAnimeItem;
import widyanto.fauzan.tugasakhir.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AiringAnimeFragment extends Fragment {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter layoutAdapter;
    private RecyclerView recyclerView;
    private ProgressBar Loading;
    private SwipeRefreshLayout Refresh;

    public AiringAnimeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_airing_anime, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        Loading = view.findViewById(R.id.Loading);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        Refresh = view.findViewById(R.id.Refresh);
        ResponseData(false);
        Refresh.setColorSchemeColors(
                Color.parseColor("#3F51B5"),
                Color.parseColor("#C90000"),
                Color.parseColor("#FFC800"),
                Color.parseColor("#0FB700")
        );
        Refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ResponseData(false);
            }
        });
        return view;
    }

    private void ResponseData(final Boolean loading){
        ApiService apiService = DataRetrofit.getData().create(ApiService.class);
        try {
            apiService.getTopAiring()
                    .enqueue(new Callback<TopAnime>() {
                        @Override
                        public void onResponse(Call<TopAnime> call, Response<TopAnime> response) {
                            List<TopAnimeItem> Items = response.body().getTop();
                            //Log.d("GET_API", String.valueOf(Items.size()));

                            Refresh.setRefreshing(false);
                            recyclerView.setVisibility(View.VISIBLE);
                            Loading.setVisibility(View.GONE);

                            if (Items != null){
                                layoutAdapter = new RecyclerAdapter(Items);
                                recyclerView.setAdapter(layoutAdapter);
                            }else{
                                Toast.makeText(getActivity(), "Failed Get Dat !", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<TopAnime> call, Throwable t) {
                            Toast.makeText(getActivity(), "Low Connection !", Toast.LENGTH_SHORT).show();
                            Refresh.setRefreshing(false);
                        }
                    });
        }catch (Exception e){

        }
    }
}
