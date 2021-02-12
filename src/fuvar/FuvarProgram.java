package fuvar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        
        
        
        HashMap<String, Integer> fizmodok = new HashMap<>();
        for (int i = 0; i < fuvarok.size(); i++) {
            Fuvar f = fuvarok.get(i);
            String kulcs = f.getFizmod();
            if (fizmodok.containsKey(kulcs)) {
                int ertek = fizmodok.get(kulcs);
                fizmodok.put(kulcs, ++ertek);
            }
            else {
                fizmodok.put(kulcs, 1);
            }
        }
        System.out.println("5. feladat:");
        for (Map.Entry<String, Integer> entry : fizmodok.entrySet()) {
            String kulcs = entry.getKey();
            Integer ertek = entry.getValue();
            System.out.printf("\t%s: %d fuvar\n", kulcs, ertek);
            
        }
        
        
        double kilometerek = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            kilometerek += (fuvarok.get(i).getTavolsag() * 1.6);
        }
        System.out.printf("6. feladat: %.2fkm\n", kilometerek);
        
        
        
        
        int index = 0;
        for (int i = 1; i < fuvarok.size(); i++) {
            if (fuvarok.get(index).getIdotartam() < fuvarok.get(i).getIdotartam()) {
                index = i;
            }
        }
        Fuvar f = fuvarok.get(index);
        String fIdo = String.format("Fuvar hossza: %d másodperc", f.getIdotartam());
        String fAzon = String.format("Taxi azonosító: %d", f.getTaxiAzon());
        String fTav = String.format("Megtett távolság: %.1f km", f.getTavolsag());
        String fDij = String.format("Viteldíj: %.2f$", f.getViteldij());
        System.out.println("7. feladat: Leghosszabb fuvar:");
        System.out.printf("\t%s\n", fIdo);
        System.out.printf("\t%s\n", fAzon);
        System.out.printf("\t%s\n", fTav);
        System.out.printf("\t%s\n", fDij);
        
        
        
    }
    
}
