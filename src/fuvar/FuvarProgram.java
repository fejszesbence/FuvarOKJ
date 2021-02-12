package fuvar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FuvarProgram {

    public static void main(String[] args) throws IOException, ParseException {
        
        List<String> sorok = Files.readAllLines(Paths.get("fuvar.csv"));
        ArrayList<Fuvar> fuvarok = new ArrayList<>();
        for (int i = 1; i < sorok.size(); i++) {
            fuvarok.add(new Fuvar(sorok.get(i)));
        }
        System.out.printf("3. feladat: %d fuvar\n", fuvarok.size());
        
        
        
        int fuvarSzam = 0;
        double bevetel = 0;
        
        for (int i = 0; i < fuvarok.size(); i++) {
            Fuvar f = fuvarok.get(i);
            if (f.getTaxiAzon() == 6185) {
                bevetel += f.getViteldij();
                bevetel += f.getBorravalo();
                fuvarSzam++;
            }
        }
        System.out.printf("4. feladat: %d fuvar alatt: %.2f$\n", fuvarSzam, bevetel);
        
        
        
        
        
    }
    
}
