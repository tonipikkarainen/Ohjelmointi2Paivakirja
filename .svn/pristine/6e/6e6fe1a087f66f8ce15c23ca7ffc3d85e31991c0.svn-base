package kanta;




/**
 * Tehd‰‰n mm. p‰iv‰m‰‰r‰n tarkistusta
 * @author tonipikkarainen
 * @version 23.2.2016
 *
 */
public class Arpominen {
    
    /**
     * Arvotaan satunnainen luku rajojen v‰list‰ 
     * @param ala alaraja
     * @param yla yl‰raja
     * @return satunnainen kokonaisluku
     */
    public static int rand(int ala, int yla){
        double skaalaus=(yla-ala)*Math.random()+ala;
        return (int)Math.round(skaalaus);
    }
    
    /**
     * Arvotaan p‰iv‰m‰‰r‰
     * @return p‰iv‰m‰‰r‰ merkkijonona
     */
    public static String arvoPvm(){
        String arvottuPvm = String.format("%02d", rand(1,28)) + "."
                + String.format("%02d", rand(1,12))+ "."
                + String.format("%04d", rand(1950,2016));
       return arvottuPvm;
   
    }

    /**
     * Kokeilup‰‰ohjelma
     * @param args ei k‰ytˆss‰ 
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
