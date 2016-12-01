package paivakirja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Luokka huolehtii joukosta transkriptioita
 * @author tonipikkarainen
 * @version 29.2.2016
 *
 */
public class Transkriptiot implements Iterable<Transkriptio>{

    private final Collection<Transkriptio> alkiot = new ArrayList<Transkriptio>();
    private String tiedostonPerusNimi = "transkriptiot";
    /**
     * Lis‰t‰‰n transkriptio listaan
     * @param transkriptio lis‰tt‰v‰
     */
    public void lisaa(Transkriptio transkriptio){
        alkiot.add(transkriptio);
    }


    /**
     * Haetaan tallennettujen alkioiden lukum‰‰r‰
     * @return lukum‰‰r‰ kokonaislukuna
     */
    public int getLukumaara(){
        return alkiot.size();
    }


    /**
     * Palauttaa kaikki transkriptiot
     * @return kaikki transkriptiot
     */
    public List<Transkriptio> getAlkiot(){
        List<Transkriptio> kaikki = new ArrayList<Transkriptio>();
        for(Transkriptio trans : alkiot){
            kaikki.add(trans);
        }
        return kaikki;
    }


    /**
     * Haetaan tietty‰ id:t‰ vastaava transkriptio
     * @param idNumero mit‰ id:t‰ haetaan
     * @return transkriptio joka vastaa tietty‰ id:t
     */
    public Transkriptio anna(int idNumero){
        for( Transkriptio vastaa : alkiot){
            if (vastaa.getIdNumero() == idNumero) return vastaa;
        }
        return null;
    }


    /**
     * Iteraattori transkriptioiden l‰pi k‰ymiseen
     * @return iteraattori
     * @example
     * <pre name="test">
     * #PACKAGEIMPORT
     * #import java.util.*;
     * Transkriptiot trans = new Transkriptiot();
     * Transkriptio t1 = new Transkriptio(); t1.rekisteroi(); trans.lisaa(t1);
     * Transkriptio t2 = new Transkriptio(); t2.rekisteroi(); trans.lisaa(t2);
     * Transkriptio t3 = new Transkriptio(); t3.rekisteroi(); trans.lisaa(t3);
     * Transkriptio t4 = new Transkriptio(); t4.rekisteroi(); trans.lisaa(t4);
     * 
     * Iterator<Transkriptio> transi = trans.iterator();
     * transi.next() === t1;
     * transi.next() === t2;
     * transi.next() === t3;
     * transi.next() === t4;
     * 
     * int[] taulukko = {1, 2, 3, 4};
     * int i = 0;
     * 
     * for ( Transkriptio t : trans){
     *     t.getIdNumero() === taulukko[i];
     *     i++;
     *  }
     *  
     * trans.anna(1) === t1;
     * trans.anna(5) === null;
     * 
     * List<Transkriptio> kaikki = trans.getAlkiot();
     * kaikki.size() === 4;
     * 
     * </pre>
     */
    @Override
    public Iterator<Transkriptio> iterator() {
        return alkiot.iterator();
    }


    /**
     * Asetetaan tiedoston nimi
     * @param nimi tiedoston nimi
     */
    public void setTiedostonPerusNimi(String nimi) {
        tiedostonPerusNimi = nimi;

    }


    /**
     * Hakee transkriptiot tiedostosta
     * @param nimi tiedoston nimi
     * @throws SailoException Jos ei aukea
     * @example
     * <pre name="test">
     * #THROWS SailoException
     * #import java.io.File;
     * Transkriptiot transtesti = new Transkriptiot();
     * Transkriptio t1 = new Transkriptio();
     * Transkriptio t2 = new Transkriptio();
     * t1.vastaaBad();
     * t2.vastaaBad();
     * String hakemisto = "pvktranstesti";
     * String tnimi = hakemisto+"/transkriptiot";
     * File dir = new File(hakemisto);
     * File tiedosto = new File(tnimi+".dat");
     * dir.mkdir();
     * tiedosto.delete();
     * transtesti.haeTranskriptiot(tnimi); #THROWS SailoException
     * transtesti.lisaa(t1);
     * transtesti.lisaa(t2);
     * transtesti.tallenna();
     * transtesti = new Transkriptiot();
     * transtesti.haeTranskriptiot(tnimi);
     * 
     * Iterator<Transkriptio> i1 = transtesti.iterator();
     * i1.next().toString().equals(t1.toString()) === true;
     * i1.next().toString().equals(t2.toString()) === true;
     * 
     * tiedosto.delete() === true;
     * dir.delete() === true;
     * 
     * </pre>
     */
    public void haeTranskriptiot(String nimi) throws SailoException {
        setTiedostonPerusNimi(nimi);
        try(Scanner fi = new Scanner(new FileInputStream(new File(getTiedostonNimi())))){
            while(fi.hasNext()){
                String rivi = fi.nextLine();
                rivi = rivi.trim();
                Transkriptio trans = new Transkriptio();
                trans.asetaKentat(rivi);
                lisaa(trans); 
            }
        }catch (FileNotFoundException e) {
            throw new SailoException("Tiedosto ei aukea.");
        }
    }


    /**
     * Hakee tiedoston nime‰ vastaavat harjoitukset
     * @throws SailoException jos liikaa j‰seni‰
     */
    public void haeTranskriptiot() throws SailoException{
        haeTranskriptiot(getTiedostonPerusnimi());
    }


    /**
     * Palauttaa tiedoston nimen, jota k‰ytet‰‰n tallennukseen
     * @return tallennustiedoston nimi
     */
    public String getTiedostonNimi() {
        return tiedostonPerusNimi + ".dat";
    }


    /**
     * Kysyy tallennustiedoston nimen ilman p‰‰tett‰
     * @return nimi
     */
    public String getTiedostonPerusnimi(){
        return tiedostonPerusNimi;
    }


    /**
     * @throws SailoException jos ep‰onnistuu 
     */
    public void tallenna()throws SailoException {
        File tiedNimi = new File(getTiedostonNimi());
        try( PrintWriter fo = new PrintWriter(new FileWriter(tiedNimi.getCanonicalPath()))) {     
            for(Iterator<Transkriptio> i = alkiot.iterator(); i.hasNext();){
                fo.println( i.next());
            }
        }
        catch ( FileNotFoundException ex){
            System.err.println("Tiedosto ei aukea: " + ex.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }


    /**
     * kokeilup‰‰ohjelma
     * @param args ei k‰ytˆss‰
     */
    public static void main(String[] args) {
        Transkriptiot transkriptiot = new Transkriptiot();

        Transkriptio badmama1 = new Transkriptio();
        Transkriptio badmama2 = new Transkriptio();

        badmama1.vastaaBad();
        badmama2.vastaaBad();

        badmama1.rekisteroi();
        badmama2.rekisteroi();

        transkriptiot.lisaa(badmama1);
        transkriptiot.lisaa(badmama2);


        System.out.println("===== transkriptiot-testi(iteraattori) =====");
        for(Iterator<Transkriptio> i = transkriptiot.iterator(); i.hasNext();){
            Transkriptio t = i.next();
            System.out.println(t);
        }
    }

}
