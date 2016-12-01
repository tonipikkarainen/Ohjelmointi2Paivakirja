package kanta;

/**
 * Muutettava int luokka
 * @author tonipikkarainen
 * @version 11.3.2016
 *
 */
public class Int {

    private int arvo;
    
    /**
     * muodostaja
     * @param luku luku joka annetaan arvoksi
     * @example
     * <pre name="test">
     * Int integer = new Int(2);
     * integer.toString() === " 2";
     * </pre>
     */
    public Int (int luku){
        this.setArvo(luku);
    }

    
    @SuppressWarnings("javadoc")
    public int getArvo() {
        return arvo;
    }

    @SuppressWarnings("javadoc")
    public void setArvo(int arvo) {
        this.arvo = arvo;
    }
    
    @Override
    public String toString(){
        return String.format("%2d", this.arvo);
    }
    
    
}
