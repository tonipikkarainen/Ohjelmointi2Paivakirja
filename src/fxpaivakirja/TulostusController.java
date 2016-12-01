package fxpaivakirja;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * @author tonipikkarainen
 * @version 14.4.2016
 *
 */
public class TulostusController implements ModalControllerInterface<String>,Initializable{


    @FXML private TextArea tekstiKentta;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public String getResult() {
        // TODO Auto-generated method stub
        return null;
    }

    
    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void setDefault(String oletus) {
        tekstiKentta.setText(oletus);
        
    }
    
    
    /**
     * @return alue johon tulostetaan
     */
    public TextArea getTextArea() {
        return tekstiKentta;
    }

 
    /**
     * Avataan tulostusikkuna
     * @param tulostus mitä tulostetaan
     * @return tulostuskontrolleri
     */
    public static TulostusController tulosta(String tulostus) {
        TulostusController tulostusCtrl = 
        (TulostusController) ModalController.showModeless(TulostusController.class.getResource("TulostusView.fxml"),
                "Tulostus", tulostus);
        return tulostusCtrl;
    }
   
}
