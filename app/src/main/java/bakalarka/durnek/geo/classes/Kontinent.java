package bakalarka.durnek.geo.classes;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Lukas on 12. 3. 2015.
 */
public class Kontinent implements Parcelable {
    private int _id;
    private String nazov;
    private int pocStatov;
    private int pocUzemi;
    private long rozloha;
    private long populacia;

    public Kontinent(int id, String nazov, int pocStatov,int pocUzemi, long rozloha, long populacia){
        this._id = id;
        this.nazov = nazov;
        this.pocStatov = pocStatov;
        this.pocUzemi = pocUzemi;
        this.rozloha = rozloha;
        this.populacia = populacia;
    }

    public Kontinent(String nazov, int pocStatov, int pocUzemi, long rozloha, long populacia){
        this.nazov = nazov;
        this.pocStatov = pocStatov;
        this.pocUzemi = pocUzemi;
        this.rozloha = rozloha;
        this.populacia = populacia;
    }

    /**
     * načítanie dát z Parcelabla objektu
     * @param in
     */
    public Kontinent(Parcel in){
        nazov = in.readString();
        pocStatov = in.readInt();
        pocUzemi = in.readInt();
        rozloha = in.readLong();
        populacia = in.readLong();
    }

    public Kontinent(){

    }

    public String getNazov() {
        return nazov;
    }

    public int getPocetStatov() {
        return pocStatov;
    }

    public int getPocetUzemi(){ return pocUzemi; }

    public long getRozloha() {
        return rozloha;
    }

    public long getPopulacia() {
        return populacia;
    }

    public int getId() {
        return _id;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nazov);
        dest.writeInt(pocStatov);
        dest.writeInt(pocUzemi);
        dest.writeLong(rozloha);
        dest.writeLong(populacia);
    }

    public static final Parcelable.Creator<Kontinent> CREATOR
            = new Parcelable.Creator<Kontinent>(){
        public Kontinent createFromParcel(Parcel in) { return new Kontinent(in); }
        public Kontinent[] newArray(int size) { return new Kontinent[6]; }
    };
}
