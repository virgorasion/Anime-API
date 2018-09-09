package widyanto.fauzan.tugasakhir;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import widyanto.fauzan.tugasakhir.Adapter.AnimeDetailAdapter;
import widyanto.fauzan.tugasakhir.Model.Aired;
import widyanto.fauzan.tugasakhir.Model.AnimeDetail;
import widyanto.fauzan.tugasakhir.Model.GenreItem;
import widyanto.fauzan.tugasakhir.Model.ProducerItem;
import widyanto.fauzan.tugasakhir.Model.StudioItem;

public class FragmentInformation extends Fragment {

    private AnimeDetailAdapter animeDetailAdapter;
    private List<AnimeDetail> animeDetailList;
    private List<Aired> airedList;
    private List<GenreItem> genreItemList;
    private List<ProducerItem> producerItemList;
    private List<StudioItem> studioItemList;

    public FragmentInformation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        animeDetailAdapter = new AnimeDetailAdapter(getAnimeDetailList(),getGenreItemList(),getProducerItemList(),getStudioItemList());
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(animeDetailAdapter);
        return view;
    }

    public List<AnimeDetail> getAnimeDetailList() {
        return animeDetailList;
    }

    public void setAnimeDetailList(List<AnimeDetail> animeDetailList) {
        this.animeDetailList = animeDetailList;
    }

    public List<Aired> getAiredList() {
        return airedList;
    }

    public void setAiredList(List<Aired> airedList) {
        this.airedList = airedList;
    }

    public List<GenreItem> getGenreItemList() {
        return genreItemList;
    }

    public void setGenreItemList(List<GenreItem> genreItemList) {
        this.genreItemList = genreItemList;
    }

    public List<ProducerItem> getProducerItemList() {
        return producerItemList;
    }

    public void setProducerItemList(List<ProducerItem> producerItemList) {
        this.producerItemList = producerItemList;
    }

    public List<StudioItem> getStudioItemList() {
        return studioItemList;
    }

    public void setStudioItemList(List<StudioItem> studioItemList) {
        this.studioItemList = studioItemList;
    }
}
