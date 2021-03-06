package paivakirja;

import fi.jyu.mit.ohj2.Mjonot;

/**
 * Luokka transkriptioiden ja harjoitusten liitoksille
 * @author tonipikkarainen
 * @version 1.3.2016
 *
 */
public class Transliitos {

    private int harjoitusId;
    private int transId;


    /**
     * Annetaan mallitiedot
     */
    public void vastaaMalli(){
        setHarjoitusId(kanta.Arpominen.rand(1, 10));
        setTransId(kanta.Arpominen.rand(1, 10));
    }


    /**
     * Asetetaan transkriptio id
     * @param luku id numero 
     */
    public void setTransId(int luku) {
        transId = luku;
    }


    /**
     * Asetetaan harjoitus id
     * @param luku id numero
     */
    public void setHarjoitusId(int luku) {
        harjoitusId = luku;
    }


    /**
     * Kysyt��n harjoitus id numero
     * @return id kokonaislukuna
     */
    public int getHarjoitusId(){
        return harjoitusId;
    }


    /**
     * Kysyt��n transkription id
     * @return id kokonaislukuna
     */
    public int getTransId(){
        return transId;
    }


    /**
     * Tulostus system outiin.
     */
    public void tulosta(){
        System.out.println("Harjoitus id on: "+harjoitusId);
        System.out.println("Transkriptio id on: "+transId);
    }


    /**
     * Asettaa kent�t jotka luetaan tiedostosta
     * @param rivi rivi tiedostosta
     * @example
     * <pre name="test">
     * Transliitos liitos1 = new Transliitos();
     * liitos1.asetaKentat("1|2");
     * liitos1.toString().equals("1|2");
     * </pre>
     */
    public void asetaKentat(String rivi) {
        StringBuilder tiedot = new StringBuilder(rivi); //????
        setHarjoitusId(Mjonot.erota(tiedot, '|', getHarjoitusId()));
        setTransId(Mjonot.erota(tiedot, '|', getTransId()));

    }


    /**
     * Muutetaan liitos merkkijonoksi.
     */
    @Override
    public String toString(){
        String rivi = harjoitusId +"|"+ transId;

        return rivi;
    }


    /**
     * Kokeilup��ohjelma
     * @param args ei k�yt�ss�
     */
    public static void main(String[] args) {
        Transliitos liitos1 = new Transliitos();
        Transliitos liitos2 = new Transliitos();

        liitos1.vastaaMalli();
        liitos2.vastaaMalli();


        liitos1.tulosta();
        liitos2.tulosta();
    }

}
