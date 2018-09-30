package widyanto.fauzan.tugasakhir.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import widyanto.fauzan.tugasakhir.Adapter.RecyclerAdapter;
import widyanto.fauzan.tugasakhir.Data.ApiService;
import widyanto.fauzan.tugasakhir.Data.DataRetrofit;
import widyanto.fauzan.tugasakhir.Model.ResultItem;
import widyanto.fauzan.tugasakhir.Model.SearchAnime;
import widyanto.fauzan.tugasakhir.Model.TopAnime;
import widyanto.fauzan.tugasakhir.Model.TopAnimeItem;
import widyanto.fauzan.tugasakhir.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter layoutAdapter;
    private RecyclerView recyclerView;
    private String query;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_search, container, false);

            recyclerView = view.findViewById(R.id.recyclerView);
            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);

            ApiService apiService = DataRetrofit.getData().create(ApiService.class);

            apiService.getSearchResult(query)
                    .enqueue(new Callback<TopAnime>() {
                        @Override
                        public void onResponse(Call<SearchAnime> call, Response<SearchAnime> response) {
                            List<ResultItem> Items = response.body().getResult();
                            //Log.d("GET_API", String.valueOf(Items.size()));
                            layoutAdapter = new RecyclerAdapter(Items);
                            recyclerView.setAdapter(layoutAdapter);
                        }

                        @Override
                        public void onFailure(Call<TopAnime> call, Throwable t) {

                        }
                    });
            return view;
        }
    }

}
