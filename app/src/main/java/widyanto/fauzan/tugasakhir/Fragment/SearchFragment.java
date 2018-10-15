package widyanto.fauzan.tugasakhir.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import widyanto.fauzan.tugasakhir.Adapter.SearchAdapter;
import widyanto.fauzan.tugasakhir.Data.ApiService;
import widyanto.fauzan.tugasakhir.Data.DataRetrofit;
import widyanto.fauzan.tugasakhir.Model.ResultItem;
import widyanto.fauzan.tugasakhir.Model.SearchAnime;
import widyanto.fauzan.tugasakhir.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    @BindView(R.id.Loading)
    ProgressBar Loading;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.Refresh)
    SwipeRefreshLayout Refresh;
    private RecyclerView.Adapter layoutAdapter;
    private Boolean load;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        final String query = getArguments() != null ? getArguments().getString("query") : null;
        load = getArguments() != null && getArguments().getBoolean("loading", false);
        recyclerView = view.findViewById(R.id.recyclerView);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ResponseData(query, load);
        Refresh.setColorSchemeColors(
                Color.parseColor("#3F51B5"),
                Color.parseColor("#C90000"),
                Color.parseColor("#FFC800"),
                Color.parseColor("#0FB700"));
        Refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ResponseData(query, false);
            }
        });

        return view;
    }

    private void ResponseData(String query, final Boolean loading) {
        ApiService apiService = DataRetrofit.getData().create(ApiService.class);
        if (loading) {
            recyclerView.setVisibility(View.GONE);
            Loading.setVisibility(View.VISIBLE);
        }
        try {
            apiService.getSearchResult(query)
                    .enqueue(new Callback<SearchAnime>() {
                        @Override
                        public void onResponse(Call<SearchAnime> call, Response<SearchAnime> response) {
                            List<ResultItem> resultItems = response.body().getResult();
                            
                            Refresh.setRefreshing(false);
                            
                            if (loading){
                                recyclerView.setVisibility(View.VISIBLE);
                                Loading.setVisibility(View.GONE);
                            }
                            
                            if (resultItems != null){
                                layoutAdapter = new SearchAdapter(resultItems);
                                recyclerView.setAdapter(layoutAdapter);   
                            }else{
                                Toast.makeText(getActivity(), "Failed Get Dat !", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<SearchAnime> call, Throwable t) {
                            Toast.makeText(getActivity(), "Low Connection !", Toast.LENGTH_SHORT).show();
                            Refresh.setRefreshing(false);
                        }
                    });
        } catch (Exception e) {

        }
    }
}
