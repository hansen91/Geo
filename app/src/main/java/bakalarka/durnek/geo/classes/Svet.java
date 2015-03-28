package bakalarka.durnek.geo.classes;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import bakalarka.durnek.geo.DataBaseHelper;
import bakalarka.durnek.geo.application.App;

/**
 * Created by Lukas on 13. 3. 2015.
 */
public class Svet {
    private ArrayList<Kontinent> kontinenty;
    private DataBaseHelper db;

    private static Svet instance = new Svet();

    public Svet(){
        db = new DataBaseHelper(App.getContext());
    }

    public List<Kontinent> getKontinenty() {
        ArrayList<Kontinent> list = new ArrayList<Kontinent>(6);

        Cursor kont = (Cursor) db.getAllContinents();

        if(kont.moveToFirst()){

        }

        return kontinenty;
    }
}

