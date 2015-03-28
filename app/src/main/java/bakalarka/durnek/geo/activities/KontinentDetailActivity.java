package bakalarka.durnek.geo.activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import bakalarka.durnek.geo.classes.Kontinent;
import bakalarka.durnek.geo.fragments.KontinentDetailFragment;
import bakalarka.durnek.geo.R;

public class KontinentDetailActivity extends FragmentActivity {
    public Kontinent kont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontinent_detail);
        //Vytiahnutie dat(Kontinent) z prijateho intentu
        Intent i = getIntent();
        kont = (Kontinent) i.getParcelableExtra("kontinent");

        //Vytvorenie noveho fragmentu
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, KontinentDetailFragment.newInstance(kont));
        transaction.commit();

    }
}

