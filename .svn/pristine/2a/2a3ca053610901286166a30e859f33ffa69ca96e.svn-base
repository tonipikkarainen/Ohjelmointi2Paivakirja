package paivakirja;

import java.io.OutputStream;
import java.io.PrintStream;

import fi.jyu.mit.ohj2.Mjonot;


/**
 * Luokka yksittäisille harjoituksille. 
 * Annetaan harjoitukselle esim. id-numero.
 * @author tonipikkarainen
 * @version 23.2.2016
 *
 */
public class Harjoitus implements Cloneable, Comparable<Harjoitus> {

    private int idNumero;
    private String pvm = "";
    private String soinnut = "";
    private String saveltapailu = "";
    private String tekniikka = "";
    private int kesto_min;
    private int p;
    private int k;
    private int v;
    private static final int KPITUUDET[][] = {
            // 1  2  3  4  5  6  7  8  9 10 11 12
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }
    };

    private static int seuraavaId=1;


    /**
     * Kertoo mistä kentästä alkaen halutaan
     * näyttää käyttäjälle.
     * @return ensimmäinen kenttä
     */
    public int ensimmainenKentta(){
        return 1;
    }


    /**
     * Antaa kenttien määrän
     * @return kenttien määrä.
     */
    public int getKenttia() {

        return 6;
    }


    private static int karkausvuosi(int vv) {
        if ( vv % 400 == 0 ) return 1;
        if ( vv % 100 == 0 ) return 0;
        if ( vv % 4 == 0 ) return 1;
        return 0;
    }


    /**
     * Tulostus
     * @param os mihin tulostetaan
     */
    public void tulosta(OutputStream os){
        tulosta(new PrintStream(os));
    }


    /**
     * Tulostetaan harjoituksen tiedot
     * @param out mihin tulostetaan
     */
    public void tulosta(PrintStream out){
        out.println(String.format("%03d", idNumero));
        out.println(pvm);
        out.println(" "+soinnut);
        out.println(" "+saveltapailu);
        out.println(" "+tekniikka);
        out.println(" "+
                String.format("%03d", kesto_min));       
    }


    /**
     * Selvitetään id
     * @return id kokonaislukuna
     */
    public int getIdNumero(){
        return idNumero;
    }


    /**
     * Asettaa idnumeron
     * @param id asetetaan idnumero
     */
    public void setIdNumero(int id){
        idNumero = id;
        if (idNumero >= seuraavaId) seuraavaId= idNumero + 1;
    }


    /**
     * Rekistöidään harjoitus, kasvatetaan id:tä
     * @return idNumero (kokonaisluku)
     * @example
     * <pre name="test">
     * #import paivakirja.*;
     * Harjoitus harj1 = new Harjoitus();
     * harj1.getIdNumero() === 0;
     * harj1.rekisteroi();
     * Harjoitus harj2 = new Harjoitus();
     * harj2.rekisteroi();
     * int a = harj1.getIdNumero();
     * int b = harj2.getIdNumero();
     * b - a === 1;
     * harj1.asetaKentat("  3|1.1.2013|sointu|test|testi|110  ");
     * harj1.toString().equals("3|1.1.2013|sointu|test|testi|110") === true;
     * </pre>
     */
    public int rekisteroi() {
        if(idNumero > 0) return idNumero;
        idNumero = seuraavaId;
        this.pvmParse();
        seuraavaId++;
        return idNumero;
    }


    /**
     * Haetaan päivämäärä
     * @return päivämäärä stringinä
     */
    public String getPvm() {
        return pvm;
    }


    /**
     * Ekaa harjoitusta vastaavat tiedot
     */
    public void vastaaEkaHarj(){
        soinnut = "Billie´s Bounce";
        saveltapailu = "";
        tekniikka = "pikkaus";
        kesto_min = kanta.Arpominen.rand(30,180);
        pvm = " "+kanta.Arpominen.arvoPvm();

    }


    /**
     * Muutetaan harjoitus merkkijonoksi.
     */
    @Override
    public String toString(){
        String rivi = idNumero +"|" +pvm +"|" +
                soinnut + "|" + saveltapailu + "|"+
                tekniikka +"|" +kesto_min ;

        return rivi;
    }


    /**
     * Asettaa keston
     * @param kesto kesto
     */
    public void setKesto(int kesto){
        kesto_min = kesto;
    }


    /**
     * Kysyy keston
     * @return kesto (min)
     */
    public int getKesto(){
        return kesto_min;
    }


    /**
     * Asetetaan tiedot tietyn rivin mukaiseksi
     * @param rivi tuotu rivi
     */
    public void asetaKentat(String rivi) {
        String vaihto = rivi;
        //vaihto.replaceAll("t", "");
        vaihto.trim();
        StringBuilder tiedot = new StringBuilder(vaihto); //????

        setIdNumero(Mjonot.erota(tiedot, '|', getIdNumero()));
        pvm = Mjonot.erota(tiedot, '|');
        soinnut= Mjonot.erota(tiedot, '|');
        saveltapailu= Mjonot.erota(tiedot, '|');
        tekniikka = Mjonot.erota(tiedot, '|');
        setKesto(Mjonot.erota(tiedot, '|', getKesto()));//????

        this.pvmParse();
    }


    /**
     * Antaa indeksiä vastaavan kentän
     * @param k1 indeksi
     * @return palauttaa kentän nimen
     */
    public String getKentta(int k1) {
        switch (k1){
        case 0:
            return "id numero";
        case 1:
            return "päivämäärä";
        case 2: 
            return "soinnut";
        case 3:
            return "säveltapailu";
        case 4:
            return "tekniikka";
        case 5:
            return "kesto";
        default:
            return "ei löydy";
        }
    }


    /**
     * Antaa tiettyä indeksiä vastaavan tiedon
     * @param i indeksi
     * @return harjoituksen sisältö haetun kentän osalta
     */
    public String anna(int i) {
        switch (i){
        case 0:
            return ""+idNumero;
        case 1:
            return ""+pvm;
        case 2: 
            return ""+soinnut;
        case 3:
            return ""+saveltapailu;
        case 4:
            return ""+tekniikka;
        case 5:
            return ""+kesto_min;
        default:
            return "ei löydy";
        }
    }


    /**
     * Asettaa tiedot tiettyihin kenttiin
     * @param i kentän indeksi
     * @param text tieto
     * @return null jos kaikki ok
     */
    public String aseta(int i, String text) {
        String trimmattu = text.trim();

        switch (i){
        case 0:
            return null;
        case 1:
            if (onkoPvm(trimmattu)){
                pvm = trimmattu;
                return null;
            }
            return "Ei oikea päivämäärä";    

        case 2: 
            soinnut = trimmattu;
            return null;
        case 3:
            saveltapailu = trimmattu;
            return null;
        case 4:
            tekniikka = trimmattu;
            return null;
        case 5:
            setKesto(Mjonot.erota(new StringBuilder(trimmattu), ' ', getKesto()));
            return null;
        default:
            return null;
        }
    }


    /**
     * Tarkistaa onko päivämäärä hyväksyttävä
     * @param syote syötetty päivämäärä
     * @return true jos hyväksytään
     */
    private boolean onkoPvm(String syote) {
        if(syote.matches(".*[^0123456789\\.].*")) return false;
        StringBuilder sb = new StringBuilder(syote);
        int pv = Mjonot.erota(sb, '.', 0);
        int kk = Mjonot.erota(sb, '.', 0);
        int vv = Mjonot.erota(sb, ' ', 0);
        if ( vv <= 0 )return false;

        if(0>=kk || kk>12) return false;
        if(0 >= pv || pv > KPITUUDET[karkausvuosi(vv)][kk-1]) return false;

        return true;
    }


    /**
     * Tämän avulla voidaan lajitella päivämäärän mukaan.
     */
    @Override
    public int compareTo(Harjoitus h) {

        if(this.getVv() < h.getVv()) return -1;
        if(this.getVv() > h.getVv()) return 1;

        if(this.getKk() < h.getKk()) return -1;
        if(this.getKk() > h.getKk()) return 1;

        if(this.getPv() < h.getPv()) return -1;
        if(this.getPv() > h.getPv()) return 1;

        return 0;

    }


    /**
     * Asetetaan päivä, kuukausi ja vuosi jotka
     * saadaan päivämäärästä.
     */
    protected final void pvmParse() {
        StringBuilder sb = new StringBuilder(pvm);
        p = Mjonot.erota(sb, '.', 0);
        k = Mjonot.erota(sb, '.', 0);
        v = Mjonot.erota(sb, ' ', 0);
    }


    /**
     * @return päivän arvo
     */
    public int getPv() {
        return p;
    }


    /**
     * @return kuukauden arvo
     */
    public int getKk() {
        return k;
    }


    /**
     * @return vuoden arvo
     */
    public int getVv() {
        return v;
    }


    /**
     * Palauttaa kloonin
     */
    @Override
    public Harjoitus clone() throws CloneNotSupportedException{
        Harjoitus uusi;
        uusi = (Harjoitus)super.clone();
        return uusi;
    }


    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Harjoitus harj1 = new Harjoitus();
        Harjoitus harj2 = new Harjoitus();

        harj1.rekisteroi();
        harj2.rekisteroi();

        harj1.vastaaEkaHarj();
        harj2.vastaaEkaHarj();

        harj1.tulosta(System.out);
        harj2.tulosta(System.out);

    }

}
