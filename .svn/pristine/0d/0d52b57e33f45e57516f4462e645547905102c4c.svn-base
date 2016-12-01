

package paivakirja;
import kanta.Int;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * huolehtii Harjoitukset ja Transkriptiot-luokkien ja Harjoitukset ja Arpeggiot-luokkien     
 * v‰lisest‰ yhteistyˆst‰ ja v‰litt‰‰ n‰it‰ tietoja pyydett‰ess‰  
 * @author tonipikkarainen
 * @version 25.2.2016
 *
 */
public class Paivakirja {
    private Harjoitukset harjoitukset = new Harjoitukset();
    private Transkriptiot transkriptiot = new Transkriptiot();
    private Transliitokset transliitokset = new Transliitokset();


    /**
     * lis‰t‰‰n harjoitus
     * @param harj lis‰tt‰v‰
     * @throws SailoException jos ei onnnistu
     * @example
     * <pre name="test">
     * #THROWS SailoException
     * #import java.util.*;
     * #import kanta.Int;
     * Paivakirja paivakirja = new Paivakirja();
     * Harjoitus harj1 = new Harjoitus(); harj1.rekisteroi();
     * Harjoitus harj2 = new Harjoitus(); harj2.rekisteroi();
     * Harjoitus harj3 = new Harjoitus(); harj3.rekisteroi();
     * paivakirja.lisaa(harj1);
     * paivakirja.getHarjoituksia() === 1;
     * paivakirja.lisaa(harj2);
     * paivakirja.lisaa(harj2);
     * paivakirja.lisaa(harj2);
     * paivakirja.getHarjoituksia() === 4;
     * paivakirja.annaHarjoitus(0) === harj1;
     * paivakirja.annaHarjoitus(6) === harj1; #THROWS IndexOutOfBoundsException
     * paivakirja.lisaa(harj1);
     * paivakirja.lisaa(harj1);
     * paivakirja.lisaa(harj1);
     * paivakirja.lisaa(harj3);
     * paivakirja.getHarjoituksia() === 8;
     * paivakirja.lisaa(harj1); 
     * 
     * Transliitos liitos1 = new Transliitos();
     * liitos1.setHarjoitusId(2); liitos1.setTransId(3);
     * Transliitos liitos2 = new Transliitos();
     * liitos2.setHarjoitusId(1); liitos2.setTransId(2);
     * Transliitos liitos3 = new Transliitos();
     * liitos3.setHarjoitusId(1); liitos3.setTransId(3);
     * paivakirja.getTransliitoksia() === 0;
     * 
     * paivakirja.lisaa(liitos1);
     * paivakirja.lisaa(liitos2);
     * paivakirja.lisaa(liitos3);
     * 
     * paivakirja.getTransliitoksia() === 3;
     * 
     * paivakirja.annaTransliitokset(3) === liitos3; #THROWS IndexOutOfBoundsException
     * paivakirja.annaTransliitokset(2) === liitos3;
     * 
     * ArrayList<Int> liittyvat = paivakirja.liittyvatLiitokset(harj1);
     * liittyvat.size() === 2;
     * liittyvat.get(0).getArvo() === 2;
     * liittyvat.get(1).getArvo() === 3;
     * 
     * </pre>
     */
    public void lisaa(Harjoitus harj)throws SailoException{
        harjoitukset.lisaa(harj);
    }


    /**
     * Palauttaa kaikki transkriptiot listassa
     * @return kaikki transkriptiot listassa
     */
    public List<Transkriptio> getAlkiot(){
        return transkriptiot.getAlkiot();
    }


    /**
     * Lis‰t‰‰n transkriptio
     * @param trans lis‰tt‰v‰
     */
    public void lisaa(Transkriptio trans){
        transkriptiot.lisaa(trans);
    }


    /**
     * Lis‰t‰‰n transliitos
     * @param trans lis‰tt‰v‰
     */
    public void lisaa(Transliitos trans){
        transliitokset.lisaa(trans);
    }


    /**
     * Harjoitusten lukum‰‰r‰
     * @return lkm kokonaislukuna
     */
    public int getHarjoituksia(){
        return harjoitukset.getLukumaara();
    }


    /**
     * transkriptioden lukum‰‰r‰
     * @return lkm kokonaislukuna
     */
    public int getTranskriptiota(){
        return transkriptiot.getLukumaara();
    }


    /**
     * transliitosten lukum‰‰r‰
     * @return lkm kokonaislukuna
     */
    public int getTransliitoksia(){
        return transliitokset.getLukumaara();
    }


    /**
     * Kysyt‰‰n tietty harjoitus
     * @param i kuinka mones harjoitus halutaan
     * @return harjoitus
     * @throws IndexOutOfBoundsException jos v‰‰r‰ indeksi
     */
    public Harjoitus annaHarjoitus(int i)throws IndexOutOfBoundsException{
        return harjoitukset.anna(i);
    }


    /**
     * Mill‰ id:ll‰ oleva halutaan
     * @param i Mill‰ id:ll‰ oleva halutaan
     * @return transkriptio
     * @example
     * <pre name="test">
     * #import java.util.*;
     * Paivakirja p = new Paivakirja();
     * Transkriptio t1 = new Transkriptio(); t1.rekisteroi(); p.lisaa(t1);
     * Transkriptio t2 = new Transkriptio(); t2.rekisteroi(); p.lisaa(t2);
     * Transkriptio t3 = new Transkriptio(); t3.rekisteroi(); p.lisaa(t3);
     * 
     * p.getTranskriptiota() === 3;
     * p.lisaa(t3);
     * p.getTranskriptiota() === 4;
     * 
     * p.annaTranskriptiot(1) === t1;
     * p.annaTranskriptiot(4) === null;
     * 
     * List<Transkriptio> kaikki = p.getAlkiot();
     * kaikki.size() === 4;
     *  </pre>
     */
    public Transkriptio annaTranskriptiot(int i){
        return transkriptiot.anna(i);
    }


    /**
     * Kysyt‰‰n tietty transliitos
     * @param i kuinka mones transliitos halutaan
     * @return transliitos
     * @throws IndexOutOfBoundsException jos v‰‰r‰ indeksi
     */
    public Transliitos annaTransliitokset(int i)throws IndexOutOfBoundsException{
        return transliitokset.anna(i);
    }


    /**
     * Antaa tiettyyn harjoitukseen liittyv‰t liitokset
     * @param harj harjoitus
     * @return liitokset listassa
     */
    public ArrayList<Int> liittyvatLiitokset ( Harjoitus harj){
        ArrayList<Int> liitokset = new ArrayList<>();
        for (int i = 0; i < this.getTransliitoksia(); i++) {
            if(this.annaTransliitokset(i).getHarjoitusId() == harj.getIdNumero()){
                liitokset.add(new Int(this.annaTransliitokset(i).getTransId()));
            }
        }
        return liitokset;    
    }


    /**
     * Tallentaa uuden harjoituksen
     */
    public void tallenna() {
        try{
            harjoitukset.tallenna();
        } catch (SailoException e){
            System.err.println(e.getMessage());
        }
        try {
            transkriptiot.tallenna();
        } catch ( SailoException e){
            System.err.println(e.getMessage());
        }
        try {
            transliitokset.tallenna();
        } catch ( SailoException e){
            System.err.println(e.getMessage());
        }

    }


    /**
     * Asettaa tiedostojen perusnimet
     * @param nimi uusi nimi
     */
    public void setTiedosto(String nimi) {
        File dir = new File(nimi);
        dir.mkdirs();
        String hakemistonNimi = "";
        if ( !nimi.isEmpty() ) hakemistonNimi = nimi +"/";
        harjoitukset.setTiedostonPerusNimi(hakemistonNimi + "harjoitukset");
        transkriptiot.setTiedostonPerusNimi(hakemistonNimi+"transkriptiot");
        transliitokset.setTiedostonPerusNimi(hakemistonNimi+"transliitokset");
    }


    /**
     * Hakee tallennettujen harjoitusten tiedot
     * @param nimi mink‰ p‰iv‰kirjan tiedostoa luetaan
     * @throws SailoException  jos liikaa j‰seni‰
     */
    public void lueTiedosto(String nimi) throws SailoException {
        harjoitukset = new Harjoitukset();
        transkriptiot = new Transkriptiot();
        transliitokset = new Transliitokset();
        setTiedosto(nimi);
        harjoitukset.haeHarjoitukset();
        transkriptiot.haeTranskriptiot();
        transliitokset.haeTransliitokset();
    }


    /**
     * Korvaa harjoituksen sit‰ vastaavalla kopiolla
     * @param kopio t‰ll‰ korvataan
     */
    public void korvaa(Harjoitus kopio) {
        harjoitukset.korvaa(kopio);

    }


    /**
     * Haetaan harjoitukset hakuehdolla
     * @param ehto hakuehto
     * @param k kentt‰ jota haetaan
     * @return harjoitukset listassa
     */
    public ArrayList<Harjoitus> etsi(String ehto, int k) {

        return harjoitukset.etsi(ehto, k);
    }


    /**
     * Poistaa harjoituksen
     * @param idNumero poistettavan idnumero
     */
    public void poistaHarjoitus(int idNumero) {
        harjoitukset.poistaHarjoitus(idNumero);

    }


    /**
     * Poistaa tietyn transliitoksen
     * @param hid poistettavan harjoitusid
     * @param tid poistettavan transid
     */
    public void poistaLiitos(int hid, int tid) {
        transliitokset.poistaLiitos(hid,tid);
    }


    /**
     * Poistaa tietyt transliitokset
     * @param hid mink‰ harjoituksen liitokset poistetaan.
     */
    public void poistaLiitos(int hid) {   
        transliitokset.poistaLiitos(hid);
    }


    /**
     * kokeilup‰‰ohjelma
     * @param args ei k‰ytˆss‰
     */
    public static void main(String[] args) {
        Paivakirja paivakirja = new Paivakirja();

        Harjoitus harj1 = new Harjoitus();
        Harjoitus harj2 = new Harjoitus();

        harj1.rekisteroi();
        harj2.rekisteroi();

        harj1.vastaaEkaHarj();
        harj2.vastaaEkaHarj();

        try{
            paivakirja.lisaa(harj1);
            paivakirja.lisaa(harj2);


            System.out.println("===== paivakirja-testi =====");
            for(int i = 0; i < paivakirja.getHarjoituksia(); i++){
                Harjoitus harjoitus = paivakirja.annaHarjoitus(i);
                System.out.println("Harjoitus numero: "+i);
                harjoitus.tulosta(System.out);

            }
        }catch(SailoException e){
            System.err.println(e.getMessage());
        }

    }


}
