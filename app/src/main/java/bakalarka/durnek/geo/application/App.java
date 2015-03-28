package bakalarka.durnek.geo.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by Lukas on 5. 3. 2015.
 */
public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    /**
     * Vráti aplikačný kontext
     * @return
     */
    public static Context getContext(){
        return mContext;
    }
}
