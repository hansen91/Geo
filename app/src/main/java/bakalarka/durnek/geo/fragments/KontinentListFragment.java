package bakalarka.durnek.geo.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

import bakalarka.durnek.geo.DataBaseHelper;
import bakalarka.durnek.geo.classes.Kontinent;
import bakalarka.durnek.geo.R;


/**
 * Created by Lukas on 6. 3. 2015.
 */
public class KontinentListFragment
        extends Fragment {
    //private static Parcelable mListViewScrollPos = null;
    //private Callbacks mCallbacks = sDummyCallbacks; //prepinanie fragmentov
    DataBaseHelper dbHelper;

    ListView lvContinents;
    ListAdapter adapter;
    List<Kontinent> kontinentList;

    private OnKontinentSelectedListener mListener;

    /*
    public interface Callbacks {
        public void onItemSelected(long id);
    }

    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(long id) {
        }
    };
    */

    public static KontinentListFragment newInstance(){
        KontinentListFragment f = new KontinentListFragment();

        // Bundle args = new Bundle();
        //args.putParcelable("kontinent", (android.os.Parcelable)kontinent);
        //  f.setArguments(args);

        return f;
    }

    /**
     * Povinny bezparametricky konstruktor
     */
    public KontinentListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_kontinent, container,false);

        dbHelper = new DataBaseHelper(this.getActivity());
        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        lvContinents = (ListView)rootView.findViewById(R.id.list);
        //lvContinents.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.fragment_kontinent));

        List<String> listContinent = dbHelper.getAllContinents();

        if (listContinent != null) {
            adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                    R.layout.item_view, R.id.kontinent, listContinent);
            lvContinents.setAdapter(adapter);
        }
        return rootView;
    }
    /*
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    }*/

    @Override
    public void onAttach (Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnKontinentSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "nie je implementovany listener");
        }
    }

    // Activities containing this fragment must implement its callbacks.
     /*   if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException(
                    "Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
        */

    // setListAdapter(aAdapter);

    @Override
    public void onDetach () {
        super.onDetach();
        mListener = null;
        /*
        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sDummyCallbacks;*/
    }

    /*  @Override
       public void onListItemClick (ListView listView, View view,int position, long id){
           super.onListItemClick(listView, view, position, id);
           if (null != mListener) {
               mListener.onKontinentSelected(kontinentList.get(position));
           }
       }

   /*
   @Override
   public void onSaveInstanceState(Bundle outState) {
       super.onSaveInstanceState(outState);
       // Save the ListView position
       mListViewScrollPos = getListView().onSaveInstanceState();
   }

   public void setActivateOnItemClick(boolean b) {
       if (b)
           getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
       else
           getListView().setChoiceMode(ListView.CHOICE_MODE_NONE);

   }
   */
    public interface OnKontinentSelectedListener {

        public void onKontinentSelected(Kontinent kontinent);
    }


}
