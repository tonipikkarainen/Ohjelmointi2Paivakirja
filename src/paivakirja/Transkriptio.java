package paivakirja;

import java.io.OutputStream;
import java.io.PrintStream;

import fi.jyu.mit.ohj2.Mjonot;

/**
 * Luokka yhden transkription luomista varten.
 * @author tonipikkarainen
 * @version 29.2.2016
 *
 */
public class Transkriptio {
    private int idNumero;
    private String kappale;
    private String artisti;
    private static int seuraavaId=1;


    /**
     * Kertoo ensimm�isen k�ytt�j�lle n�ytett�v�n kent�n
     * @return eka kentt�
     */
    public int ensimmainenKentta(){
        return 1;
    }


    /**
     * Kertoo kuinka monta kentt�� on
     * @return kenttien m��r�
     */
    public int kenttia(){
        return 3;
    }


    /**
     * Asettaa kappaleen
     * @param s kappale
     */
    public void setKappale(String s){
        kappale = s;
    }


    /**
     * Asettaa artistin
     * @param s artisti
     */
    public void setArtisti(String s){
        artisti = s;
    }


    /**
     * Kertoo tietyn kent�n sis�ll�n
     * @param i indeksi
     * @return kent�n sis�lt�
     */
    public String anna(int i) {
        switch (i){
        case 0:
            return ""+idNumero;
        case 1:
            return ""+kappale;
        case 2: 
            return ""+artisti;
        default:
            return "ei l�ydy";
        }
    }


    /**
     * Antaa indeksi� vastaavan kent�n
     * @param k indeksi
     * @return palauttaa kent�n nimen
     */
    public String getKentta(int k) {
        switch (k){
        case 0:
            return "id numero";
        case 1:
            return "kappale";
        case 2: 
            return "artisti";
        default:
            return "ei l�ydy";
        }
    }


    /**
     * Annetaan testitiedot mit� vastataan
     */
    public void vastaaBad(){
        kappale = "Bad Mama "+String.format("%04d",kanta.Arpominen.rand(0, 1000));
        artisti = "Teemu Viinikainen";
    }


    /**
     * Palauttaa kappaleen nimen
     * @return kappaleen nimi
     */
    public String getKappale(){
        return kappale;
    }


    /**
     * Tulostus
     * @param os mihin tulostetaan
     */
    public void tulosta(OutputStream os){
        tulosta(new PrintStream(os));
    }


    /**
     * Tulostetaan transkription tiedot
     * @param out mihin tulostetaan
     */
    public void tulosta(PrintStream out){
        out.println(String.format("%03d", idNumero));
        out.println(" "+kappale);
        out.println(" "+artisti);       
    }


    /**
     * Selvitet��n id
     * @return id kokonaislukuna
     */
    public int getIdNumero(){
        return idNumero;
    }


    /**
     * Rekist�id��n transkriptio, kasvatetaan id:t�
     * @return idNumero (kokonaisluku)
     * @example
     * <pre name="test">
     * Transkriptio badmama1 = new Transkriptio();
     * badmama1.getIdNumero() === 0;
     * badmama1.rekisteroi();
     * Transkriptio badmama2 = new Transkriptio();
     * badmama2 .rekisteroi();
     * int a = badmama1.getIdNumero();
     * int b = badmama2 .getIdNumero();
     * b - a === 1;
     * badmama1.asetaKentat("  4|Eye of the Tiger|Rocky  ");
     * badmama1.toString().equals("4|Eye of the Tiger|Rocky") === true;
     * </pre>
     */
    public int rekisteroi() {
        if(idNumero > 0) return idNumero;
        idNumero = seuraavaId;
        seuraavaId++;
        return idNumero;
    }


    /**
     * Muutetaan transkriptio merkkijonoksi.
     */
    @Override
    public String toString(){
        String rivi = idNumero +"|" +kappale +"|" +
                artisti;

        return rivi;
    }


    /**
     * Asetetaan tiedot
     * @param rivi tietorivi joka on luettu tiedostosta
     */
    public void asetaKentat(String rivi) {
        String vaihto = rivi.trim();
        StringBuilder tiedot = new StringBuilder(vaihto); //????
        setIdNumero(Mjonot.erota(tiedot, '|', getIdNumero()));
        kappale = Mjonot.erota(tiedot, '|');
        artisti= Mjonot.erota(tiedot, '|');   
    }


    /**
     * Asettaa idnumeron
     * @param id idnumero
     */
    private void setIdNumero(int id) {
        idNumero = id;
        if (idNumero >= seuraavaId) seuraavaId= idNumero + 1;

    }


    /**
     * Kokeilu p��ohjelma
     * @param args ei k�yt�ss�
     */
    public static void main(String[] args) {
        Transkriptio badmama1 = new Transkriptio();
        Transkriptio badmama2 = new Transkriptio();

        badmama1.vastaaBad();
        badmama2.vastaaBad();

        badmama1.rekisteroi();
        badmama2.rekisteroi();

        badmama1.tulosta(System.out);
        badmama2.tulosta(System.out);

    }

}
