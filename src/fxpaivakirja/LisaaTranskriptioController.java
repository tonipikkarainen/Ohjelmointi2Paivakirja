package fxpaivakirja;


import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import fi.jyu.mit.fxgui.StringGrid;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import paivakirja.Harjoitus;
import paivakirja.Paivakirja;
import paivakirja.Transkriptio;
import paivakirja.Transliitos;

/**
 * Kysyt��n transkriptio ja luodaan t�t� varten dialogi.
 * 
 * @author Toni Pikkarainen
 * @version 12.2.2016
 */
public class LisaaTranskriptioController implements ModalControllerInterface<Harjoitus>, Initializable {

    //@FXML private ListChooser chooserTranskriptiot;
    @FXML private ScrollPane panelTranskriptio;
    @FXML private StringGrid<Transkriptio> tableTranskriptio;

    @FXML private TextField textKappale;
    @FXML private TextField textArtisti;

    @FXML private Label labelVirhe;

    //private String vastaus = null;

    @Override
    public void initialize(URL url, ResourceBundle bundle){
        alusta();
    }

    @FXML private void handleOK() {
        //vastaus = textKappale.getText()+" "+textArtisti.getText();
        ModalController.closeStage(labelVirhe);
    }


    /*@FXML private void handleOKuusi() {
        //vastaus = "Palautetaan valinta"; // t�h�n sitten se mik� on valittu listasta
        ModalController.closeStage(labelVirhe);
    }*/


    @FXML private void handleLisaaValittu() {
        liitaValittu();
    }

    @FXML private void handleLisaa() {
        uusiTranskriptio();
    }


    //===========================================================================================    
    // T�st� eteenp�in ei k�ytt�liittym��n suoraan liittyv�� koodia  
    private Harjoitus harjoitusKohdalla;
    private Transkriptio transkriptioKohdalla;
    //private TextArea areaTranskriptio = new TextArea();
    //private ListView<Transkriptio> listTranskriptiot = new ListView<Transkriptio>();
    //private ObservableList<Transkriptio> listdataTranskriptiot = FXCollections.observableArrayList();

    private Transkriptio aputranskriptio = new Transkriptio();
    private static Paivakirja paivakirja;

    @Override
    public Harjoitus getResult() {
        return null;
    }


    @Override
    public void setDefault(Harjoitus oletus) {
        harjoitusKohdalla = oletus;
        naytaTranskriptioKaikki();
        //naytaTranskriptio();
        //naytaVirhe("Ei osata viel� tehd� kunnolla");
    }


    /**
     * Mit� tehd��n kun dialogi on n�ytetty
     */
    @Override
    public void handleShown() {
        textKappale.requestFocus();
    }


    /**
     * Luokka jolla hoidetaan miten transkriptio
     * n�kyy listassa
     * @author tonipikkarainen
     * @version 15.3.2016
     *
     */
    public static class CellTranskriptio extends ListCell<Transkriptio>{
        @Override protected void updateItem(Transkriptio item, boolean empty){
            super.updateItem(item, empty);
            setText(empty ? "" :item.getKappale());
        }
    }


    /**
     * Laitetaan panelHarjoitus-kohtaan tekstialue nimelt�
     * areaHarjoitus.
     */
    private void alusta(){

        int eka = aputranskriptio.ensimmainenKentta();
        int lkm = aputranskriptio.kenttia();
        
        String[] otsikot = new String[lkm-eka];
        for ( int i=0 , k=eka ; k < lkm ; i++,k++){
            otsikot[i] = aputranskriptio.getKentta(k);
        }
        tableTranskriptio.initTable(otsikot);
        tableTranskriptio.setEditable(false);
        tableTranskriptio.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            ilmoitaValittu();
        });
        //ScrollPane parent =(ScrollPane)chooserTranskriptiot.getParent();
        /*panelTranskriptio.setContent(listTranskriptiot);
        listTranskriptiot.setCellFactory(p -> new CellTranskriptio());

        listTranskriptiot.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            ilmoitaValittu();
        });*/

        /*panelTranskriptio.setContent(areaTranskriptio);
        areaTranskriptio.setFont(new Font ("Courier New", 12));*/

        /*listTranskriptiot.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            naytaTranskriptio();
        });*/
    }

    /**
     * Vaihdetaan transkriptioksi, jonka kohdalla ollaan oikea
     * transkriptio
     */
    private void ilmoitaValittu(){
        transkriptioKohdalla = tableTranskriptio.getObject();
    }

    
    /**
     * Tehd��n uusi transliitos valitun transkription
     * ja harjoituksen(jonka kohdalla ollaan) v�lille.
     */
    private void liitaValittu(){
        if (transkriptioKohdalla == null) return;

        uusiTransliitos(harjoitusKohdalla.getIdNumero(), transkriptioKohdalla.getIdNumero());
    }


    /**
     * N�ytet��n virheteksti
     * @param virhe teksti joka n�ytet��n
     */
    @SuppressWarnings("unused")
    private void naytaVirhe(String virhe){
        if(virhe == null || virhe.isEmpty()){
            labelVirhe.setText("");
            return;
        }
        labelVirhe.setText(virhe);   
    }


    /**
     * N�ytet��n parametrina sy�tetyn harjoitukseen liittyv�t transkriptiot tiedot muokkaus-
     * ikkunassa.
     */
    private void naytaTranskriptioKaikki(){
       
        tableTranskriptio.clear();

        for(Transkriptio trans : paivakirja.getAlkiot()){
            //listdataTranskriptiot.add(trans);
            naytaTranskriptio(trans);
        }
     
        //listTranskriptiot.setItems(listdataTranskriptiot);
    }


    /**
     * N�ytt�� transkription
     * @param naytettava t�m� n�ytet��n
     */
    private void naytaTranskriptio(Transkriptio naytettava){
        if(harjoitusKohdalla == null) return;
        if(naytettava == null) return;
        //listdataTranskriptiot.add(naytettava);
        int kenttia = naytettava.kenttia();
        String[] rivi = new String[kenttia - naytettava.ensimmainenKentta()];
        for ( int i=0 , k=naytettava.ensimmainenKentta() ; k < kenttia ; i++,k++){
            rivi[i] = naytettava.anna(k);
        }
        
        tableTranskriptio.add(naytettava,rivi);
    }

    /**
     * Lis�t��n uusi transkriptio
     */
    protected void uusiTranskriptio(){
        if( textKappale.getText().equals("")) return;
        Transkriptio uusi = new Transkriptio();
        //uusi.vastaaBad();//TODO aukaise dialogi
        uusi.setKappale(textKappale.getText());
        uusi.setArtisti(textArtisti.getText());
        
        uusi.rekisteroi(); //TODO rekister�i vasta kun hyv�ksyt��n
        paivakirja.lisaa(uusi);
        

        uusiTransliitos(harjoitusKohdalla.getIdNumero(), uusi.getIdNumero());

        naytaTranskriptio(uusi);

       
    }

    /**
     * Lis�t��n uusi transkription ja harjoituksen v�linen liitos.
     * @param harjIdNumero liitokseen tuleva harjoituksen id
     * @param transIdNumero liitokseen tuleva transkription id
     */
    private void uusiTransliitos(int harjIdNumero, int transIdNumero) {
        Transliitos uusi = new Transliitos();
        uusi.setHarjoitusId(harjIdNumero);
        uusi.setTransId(transIdNumero);

        paivakirja.lisaa(uusi);


    }


    /**
     * Luodaan nimenkysymisdialogi ja palautetaan siihen kirjoitettu nimi tai null
     * @param modalityStage mille ollaan modaalisia
     * @param oletus harjoituskohdalla
     * @param p p�iv�kirja joka tuodaan
     * @return null jos painetaan poistu, muuten p�iv�kirja muutoksineen
     */
    public static Harjoitus kysyTranskriptio(Stage modalityStage,Harjoitus oletus, Paivakirja p) {
        if(oletus == null) return null;
        paivakirja = p;

        return  ModalController.showModal(
                LisaaTranskriptioController.class.getResource("LisaaTranskriptioView.fxml"),
                "Paivakirja",modalityStage,oletus);
    }
}