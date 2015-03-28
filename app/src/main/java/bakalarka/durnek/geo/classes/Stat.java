package bakalarka.durnek.geo.classes;

/**
 * Created by Lukas on 12. 3. 2015.
 */
public class Stat {
    public String nazov;
    public String hlMesto;
    public long rozloha;
    public long populacia;
    public String[] mesta;
    public String[] jazyky;
    public String[] mena;

    public Stat(String nazov,String hlMesto,long rozloha,long populacia,String[] mesta,
                String[] jazyky, String[] mena){
        super();
        this.nazov = nazov;
        this.hlMesto = hlMesto;
        this.rozloha = rozloha;
        this.populacia = populacia;
        this.mesta = mesta;
        this.jazyky = jazyky;
        this.mena = mena;
    }

    public Stat(String nazov){
        this.nazov = nazov;
    }
}
