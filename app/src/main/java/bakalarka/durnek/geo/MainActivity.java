package bakalarka.durnek.geo;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import bakalarka.durnek.geo.activities.KontinentActivity;
import bakalarka.durnek.geo.activities.KontinentDetailActivity;
import bakalarka.durnek.geo.classes.Kontinent;
import bakalarka.durnek.geo.fragments.KontinentDetailFragment;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    Context context = this;
    private boolean mDualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (findViewById(R.id.kontinent_detail_container) == null)
            mDualPane = false; //Portrait ||
        else
            mDualPane = true; //Landscape |  |




        Button vyucba = (Button)findViewById(R.id.btnVyucba);
        vyucba.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){


                //Toast.makeText(context,"Vyucba kliknuta",Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(context,KontinentActivity.class);
                startActivity(myIntent);


            }
        });



        Button kviz = (Button)findViewById(R.id.btnKviz);
        kviz.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });

        Button pexeso = (Button)findViewById(R.id.btnPexeso);
        pexeso.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });

        Button koniec = (Button)findViewById(R.id.btnKoniec);
        koniec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ukonciGeografiu();
            }
        });
    }

    public void spustiVyucbu(){
        Toast.makeText(this, "Vyucba kliknuta", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(this,KontinentActivity.class);
        startActivity(myIntent);
    }

    public void ukonciGeografiu(){
        this.finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onKontinentSelected(Kontinent kontinent) {
        if (mDualPane) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.kontinent_detail_container, KontinentDetailFragment.newInstance(kontinent));
            transaction.commit();
        } else {
            Intent intent = new Intent(this, KontinentDetailActivity.class);
            intent.putExtra("kontinent", kontinent);
            startActivity(intent);

        }
    }

    @Override
    public void onClick(View v) {

    }
}
