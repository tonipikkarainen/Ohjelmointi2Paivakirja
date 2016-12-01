package paivakirja;
// Generated by ComTest BEGIN
import java.io.File;
import static org.junit.Assert.*;
import org.junit.*;
import paivakirja.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2016.04.14 13:38:36 // Generated by ComTest
 *
 */
public class TransliitoksetTest {



  // Generated by ComTest BEGIN
  /** testAnna57 */
  @Test
  public void testAnna57() {    // Transliitokset: 57
    Transliitokset transliitokset =new Transliitokset(); 
    Transliitos liitos1 = new Transliitos(); 
    Transliitos liitos2 = new Transliitos(); 
    liitos1.vastaaMalli(); 
    liitos2.vastaaMalli(); 
    transliitokset.lisaa(liitos1); 
    transliitokset.lisaa(liitos2); 
    assertEquals("From: Transliitokset line: 66", 2, transliitokset.getLukumaara()); 
    transliitokset.lisaa(liitos1); 
    assertEquals("From: Transliitokset line: 69", 3, transliitokset.getLukumaara()); 
    assertEquals("From: Transliitokset line: 70", liitos1, transliitokset.anna(0)); 
    assertEquals("From: Transliitokset line: 71", liitos2, transliitokset.anna(1)); 
    try {
    assertEquals("From: Transliitokset line: 73", liitos1, transliitokset.anna(3)); 
    fail("Transliitokset: 73 Did not throw IndexOutOfBoundsException");
    } catch(IndexOutOfBoundsException _e_){ _e_.getMessage(); }
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** 
   * testHaeTransliitokset106 
   * @throws SailoException when error
   */
  @Test
  public void testHaeTransliitokset106() throws SailoException {    // Transliitokset: 106
    Transliitokset liitostesti = new Transliitokset(); 
    Transliitos l1 = new Transliitos(); 
    Transliitos l2 = new Transliitos(); 
    l1.setHarjoitusId(3); 
    l2.setHarjoitusId(5); 
    l1.setTransId(1); 
    l2.setTransId(2); 
    String hakemisto = "pvkliitostesti"; 
    String tnimi = hakemisto+"/transliitokset"; 
    File dir = new File(hakemisto); 
    File tiedosto = new File(tnimi+".dat"); 
    dir.mkdir(); 
    tiedosto.delete(); 
    try {
    liitostesti.haeTransliitokset(tnimi); 
    fail("Transliitokset: 123 Did not throw SailoException");
    } catch(SailoException _e_){ _e_.getMessage(); }
    liitostesti.lisaa(l1); 
    liitostesti.lisaa(l2); 
    liitostesti.tallenna(); 
    liitostesti = new Transliitokset(); 
    liitostesti.haeTransliitokset(tnimi); 
    assertEquals("From: Transliitokset line: 130", true, liitostesti.anna(0).toString().equals(l1.toString())); 
    assertEquals("From: Transliitokset line: 131", true, liitostesti.anna(1).toString().equals(l2.toString())); 
    assertEquals("From: Transliitokset line: 133", true, tiedosto.delete()); 
    assertEquals("From: Transliitokset line: 134", true, dir.delete()); 
  } // Generated by ComTest END
}