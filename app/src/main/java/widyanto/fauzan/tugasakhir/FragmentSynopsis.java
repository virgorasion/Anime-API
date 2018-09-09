package widyanto.fauzan.tugasakhir;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentSynopsis extends Fragment {

    private String dataSynopsis;
    private TextView synopsis;

    public FragmentSynopsis() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_synopsis, container, false);
        synopsis = view.findViewById(R.id.synopsisAnime);
        synopsis.setText(getSynopsis());
        return view;
    }

    public String getSynopsis() {
        return dataSynopsis;
    }

    public void setSynopsis(String dataSynopsis) {
        this.dataSynopsis = dataSynopsis;
    }
}
