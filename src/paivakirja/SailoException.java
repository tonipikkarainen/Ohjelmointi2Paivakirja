
package paivakirja;

/**
 * @author tonipikkarainen
 * @version 23.2.2016
 *
 */
public class SailoException extends Exception {
    private static final long serialVersionUID = 1L;
    
    
    /**
     * Poikkeuksen muodostaja
     * @param viesti viesti, joka halutaan n‰ytt‰‰
     */
    public SailoException(String viesti){
        super(viesti);
    }

}
