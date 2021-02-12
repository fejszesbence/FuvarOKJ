package fuvar;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Fuvar {
    
    private int taxiAzon;
    private String indulas;
    private int idotartam;
    private double tavolsag, viteldij, borravalo;
    private String fizmod;

    public Fuvar(String sor) throws ParseException {
        NumberFormat formatum = NumberFormat.getInstance(Locale.getDefault());
        String[] darabok = sor.split(";");
        this.taxiAzon = Integer.parseInt(darabok[0]);
        this.indulas = darabok[1];
        this.idotartam = Integer.parseInt(darabok[2]);
        this.tavolsag = formatum.parse(darabok[3]).doubleValue();
        this.viteldij = formatum.parse(darabok[4]).doubleValue();
        this.borravalo = formatum.parse(darabok[5]).doubleValue();
        this.fizmod = darabok[6];
    }
    
    
    
}
