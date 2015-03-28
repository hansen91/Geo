package bakalarka.durnek.geo.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import bakalarka.durnek.geo.classes.Kontinent;
import bakalarka.durnek.geo.fragments.KontinentDetailFragment;
import bakalarka.durnek.geo.fragments.KontinentListFragment;
import bakalarka.durnek.geo.R;

/**
 * Created by Lukas on 28. 3. 2015.
 */
public class KontinentActivity extends Activity implements KontinentListFragment.OnKontinentSelectedListener{
    private static final String VYBRANY_KONTINENT = "vybrany_kontinent";
    private boolean mDualPane;
    private long vybranyKontinent = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontinent);

        if (findViewById(R.id.kontinent_detail_container) == null)
            mDualPane = false; //Portrait ||
        else
            mDualPane = true; //Landscape |  |

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.kontajner, KontinentListFragment.newInstance());
        transaction.commit();
    }

    @Override
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        /*switch (item.getItemId()) {
            case 1 : R.id.oprograme:
                Intent i1 = new Intent(this, OPrograme.class);
                startActivity(i1);
                return true;

        }*/

        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

   /* public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putLong(VYBRANY_KONTINENT, vybranyKontinent);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null)
            vybranyKontinent = savedInstanceState.getLong(VYBRANY_KONTINENT);
    }*/
}
