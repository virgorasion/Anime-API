package widyanto.fauzan.tugasakhir.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import widyanto.fauzan.tugasakhir.Adapter.RecyclerAdapter;
import widyanto.fauzan.tugasakhir.Adapter.SearchAdapter;
import widyanto.fauzan.tugasakhir.Data.ApiService;
import widyanto.fauzan.tugasakhir.Data.DataRetrofit;
import widyanto.fauzan.tugasakhir.Model.ResultItem;
import widyanto.fauzan.tugasakhir.Model.SearchAnime;
import widyanto.fauzan.tugasakhir.Model.TopAnime;
import widyanto.fauzan.tugasakhir.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private RecyclerView.Adapter layoutAdapter;
    private RecyclerView recyclerView;
    private Boolean load;
    private ProgressBar loading;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        final String query = getArguments() != null ? getArguments().getString("query") : null;
        load = getArguments() != null && getArguments().getBoolean("loading", false);
        recyclerView = view.findViewById(R.id.recyclerView);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ApiService apiService = DataRetrofit.getData().create(ApiService.class);
        apiService.getSearchResult(query)
                .enqueue(new Callback<SearchAnime>() {
                    @Override
                    public void onResponse(Call<SearchAnime> call, Response<SearchAnime> response) {
                        List<ResultItem> resultItems = response.body().getResult();
                        layoutAdapter = new SearchAdapter(resultItems);
                        recyclerView.setAdapter(layoutAdapter);
                    }

                    @Override
                    public void onFailure(Call<SearchAnime> call, Throwable t) {

                    }
                });

        return view;
    }
}
