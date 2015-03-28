package bakalarka.durnek.geo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import bakalarka.durnek.geo.classes.Kontinent;
import bakalarka.durnek.geo.R;

/**
 * Created by Lukas on 6. 3. 2015.
 */
public class KontinentAdapter extends ArrayAdapter<Kontinent> {

    private class ViewHolder{
        TextView nazov;
    }

    List<Kontinent> listCont;
    Context appContext;

    public KontinentAdapter(Context context, int resource, List<Kontinent> objects) {
        super(context, resource, objects);
        listCont = objects;
        this.appContext = context;
    }



    @Override
    public int getCount() {
        return listCont.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            v = inflater.inflate(R.layout.item_view, null);
            holder = new ViewHolder();

            holder.nazov = (TextView) v.findViewById(R.id.kontinent);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.nazov.setText(listCont.get(position).getNazov());

        return v;
    }






}
