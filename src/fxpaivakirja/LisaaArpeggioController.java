package fxpaivakirja;


import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Kysyt��n arpeggion nimi ja luodaan t�t� varten dialogi.
 * 
 * @author Toni Pikkarainen
 * @version 16.2.2016
 */
public class LisaaArpeggioController implements ModalControllerInterface<String> {
    
    @FXML private TextField textKappale;
    @FXML private TextField textTyyli;
    @FXML private TextField textSavelet;
    private String vastaus = null;

    
    @FXML private void handleOK() {
        vastaus = textKappale.getText()+" "+textTyyli.getText()+" "+textSavelet.getText();
        ModalController.closeStage(textKappale);
    }

    
    @FXML private void handleOKuusi() {
        vastaus = "Palautetaan valinta"; // t�h�n sitten se mik� on valittu listasta
        ModalController.closeStage(textKappale);
    }

    
    @FXML private void handleCancel() {
        ModalController.closeStage(textKappale);
    }


    @Override
    public String getResult() {
        return vastaus;
    }

    
    @Override
    public void setDefault(String oletus) {
        textKappale.setText(oletus);
    }

    
    /**
     * Mit� tehd��n kun dialogi on n�ytetty
     */
    @Override
    public void handleShown() {
        textKappale.requestFocus();
    }
    
    
    /**
     * Luodaan nimenkysymisdialogi ja palautetaan siihen kirjoitettu nimi tai null
     * @param modalityStage mille ollaan modaalisia, null = sovellukselle
     * @return null jos painetaan Cancel, muuten kirjoitettu nimi
     */
    public static String kysyArpeggio(Stage modalityStage) {
        return ModalController.showModal(
                PaivakirjanNimiController.class.getResource("LisaaArpeggioView.fxml"),
                "Paivakirja", modalityStage, "");
    }
}