package fxpaivakirja;


import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import paivakirja.Harjoitus;

/**
 * Kysyt��n tiedot ja luodaan t�t� varten dialogi.
 * 
 * @author Toni Pikkarainen
 * @version 16.2.2016
 */
public class MuokkausController implements ModalControllerInterface<Harjoitus>,Initializable {

    @FXML private TextField textTiedot;
    @FXML private BorderPane panelHarjoitus;
    @FXML private Label labelVirhe;
    @FXML private GridPane gridHarjoitus;


    @Override
    public void initialize(URL url, ResourceBundle bundle){
        alusta();
    }


    @FXML private void handleOK() {
        if( harjoitusKohdalla.getPvm().trim().equals("")) {
            naytaVirhe("pvm ei saa olla tyhj�");
            return;
        }
        ModalController.closeStage(labelVirhe);
    }


    @FXML private void handleCancel() {
        harjoitusKohdalla = null;
        ModalController.closeStage(labelVirhe);
    }

    //===========================================================================================    
    // T�st� eteenp�in ei k�ytt�liittym��n suoraan liittyv�� koodia   

    //private TextArea areaHarjoitus = new TextArea();
    private Harjoitus harjoitusKohdalla;
    private static Harjoitus apuharjoitus = new Harjoitus();
    private TextField[] tekstikentat;


    @Override
    public Harjoitus getResult() {
        return harjoitusKohdalla;
    }


    /**
     * Laitetaan parametrina tullut harjoitus
     * harjoitusKohdalla muuttujaan. Menn��n
     * seuraavaan aliohjelmaan.
     */
    @Override
    public void setDefault(Harjoitus oletus) {
        harjoitusKohdalla = oletus;
        //naytaHarjoitus();
        naytaHarjoitus(tekstikentat, harjoitusKohdalla);
        naytaVirhe("");
    }


    /**
     * N�ytet��n virheteksti
     * @param virhe teksti joka n�ytet��n
     */
    private void naytaVirhe(String virhe){
        if(virhe == null || virhe.isEmpty()){
            labelVirhe.setText("");
            //labelVirhe.getStyleClass().removeAll("virhe"); TODO: miksi ei styleclass toimi?
            return;
        }
        labelVirhe.setText(virhe);
        //labelVirhe.getStyleClass().add("virhe");
        //labelVirhe.getStyleClass().add("kukkuu");
    }


    /**
     * Mit� tehd��n kun dialogi on n�ytetty
     */
    @Override
    public void handleShown() {
        //textTiedot.requestFocus();
        tekstikentat[1].requestFocus();
    }


    /**
     * Laitetaan panelHarjoitus-kohtaan tekstialue nimelt�
     * areaHarjoitus.
     */
    private void alusta(){
        //panelHarjoitus.setCenter(areaHarjoitus);
        //areaHarjoitus.setFont(new Font ("Courier New", 12));
        tekstikentat = luoKentat(gridHarjoitus); 

        for (TextField kentta : tekstikentat)
            if ( kentta != null )
                kentta.setOnKeyReleased( e -> kasitteleMuutosHarjoitukseen((TextField)(e.getSource())));
    }


    /**
     * Luo tekstikentti� tarvittavan m��r�n
     * @param tableHarjoitus Taulukko johon luodaan kent�t
     * @return taulukollinen tekstikentti�
     */
    public static TextField[] luoKentat(GridPane tableHarjoitus) {
        tableHarjoitus.getChildren().clear();

        TextField[] tekstit = new TextField[apuharjoitus.getKenttia()];
        for(int i = 0, k=apuharjoitus.ensimmainenKentta(); k < apuharjoitus.getKenttia(); k++, i++){
            Label label = new Label(apuharjoitus.getKentta(k));
            tableHarjoitus.add(label, 0, i);
            TextField teksti = new TextField();

            tekstit[k] = teksti;

            teksti.setId(""+k);

            /*final int fink = k;
            teksti.setOnKeyReleased( e -> kasitteleMuutosHarjoitukseen(fink,(TextField)(e.getSource())));
             */
            tableHarjoitus.add(teksti, 1,i);
        }
        return tekstit;

    }


    /**
     * K�sitell��n harjoituksen tietoihin tehty muutos
     * @param text kentt� johon muutos tehd��n
     */
    protected void kasitteleMuutosHarjoitukseen(TextField text) {
        if (harjoitusKohdalla == null ) return;
        String sijoitus = text.getText();
        int k = Integer.parseInt(text.getId());
        String virhe = null;
        virhe = harjoitusKohdalla.aseta(k, sijoitus);
        if(virhe == null){
            Dialogs.setToolTipText(text,"");
            //tekstikentat[k].getStyleClass().removeAll("virhe");
            naytaVirhe(virhe);
        }
        else{
            //tekstikentat[k].getStyleClass().add("virhe");
            Dialogs.setToolTipText(text,virhe);
            naytaVirhe(virhe);
        }

    }


    /**
     * Asettaan tekstikenttiin harjoituksen tiedot
     * @param teksti kentt�
     * @param harjoitus t�m�n tiedot laitetaan
     */
    public static void naytaHarjoitus(TextField[] teksti,
            Harjoitus harjoitus) {
        if(harjoitus == null) return;
        for ( int i = apuharjoitus.ensimmainenKentta();i < apuharjoitus.getKenttia();i++){
            teksti[i].setText(harjoitus.anna(i));
        }
    }


    /**
     * Luodaan tietojenkysymisdialogi
     * @param modalityStage mille ollaan modaalisia, null = sovellukselle
     * @param oletus oletus tiedot
     * @return null jos painetaan Cancel, muuten tiedot
     */
    public static Harjoitus kysyTiedot(Stage modalityStage, Harjoitus oletus) {
        return ModalController.showModal(
                MuokkausController.class.getResource("MuokkausView.fxml"),
                "Paivakirja", modalityStage, oletus);
    }

}