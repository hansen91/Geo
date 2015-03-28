package bakalarka.durnek.geo.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bakalarka.durnek.geo.classes.Kontinent;
import bakalarka.durnek.geo.R;


public class KontinentDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Kontinent kontinent;

    public static KontinentDetailFragment newInstance(Kontinent kontinent){
        KontinentDetailFragment f = new KontinentDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("kontinent", (android.os.Parcelable)kontinent);
        f.setArguments(args);
        return f;
    }


    public KontinentDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            kontinent = (Kontinent) getArguments().getParcelable("kontinent");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_kontinent_detail, container, false);
        ((TextView) v.findViewById(R.id.nazov)).setText(kontinent.getNazov());
        ((TextView) v.findViewById(R.id.pocStatov)).setText(kontinent.getPocetStatov());
        ((TextView) v.findViewById(R.id.pocUzemi)).setText(kontinent.getPocetUzemi());
        ((TextView) v.findViewById(R.id.rozloha)).setText((int) kontinent.getRozloha());
        ((TextView) v.findViewById(R.id.populacia)).setText((int) kontinent.getPopulacia());

        return v;
    }

}
