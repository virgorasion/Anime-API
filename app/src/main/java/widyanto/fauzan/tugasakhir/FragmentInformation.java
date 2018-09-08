package widyanto.fauzan.tugasakhir;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import widyanto.fauzan.tugasakhir.Adapter.AnimeDetailAdapter;
import widyanto.fauzan.tugasakhir.Model.AnimeDetail;

public class FragmentInformation extends Fragment {

    private AnimeDetailAdapter animeDetailAdapter;
    private List<AnimeDetail> animeDetailList;

    public FragmentInformation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(animeDetailAdapter);
        return view;
    }
}
