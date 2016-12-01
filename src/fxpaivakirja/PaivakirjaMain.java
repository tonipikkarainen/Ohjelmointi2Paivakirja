package fxpaivakirja;	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import paivakirja.Paivakirja;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

/**
 * 
 * @author tonipikkarainen
 * @version 18.1.2016
 *
 */
public class PaivakirjaMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader ldr = new FXMLLoader(getClass().getResource("PaivakirjaGUIView.fxml"));
	        final Pane root = (Pane)ldr.load();
	        final PaivakirjaGUIController paivakirjaCtrl = (PaivakirjaGUIController)ldr.getController();
	        
	        final Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getResource("paivakirja.css").toExternalForm());
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Paivakirja");
	        
	        Platform.setImplicitExit(false); 
	        
	        primaryStage.setOnCloseRequest((event) -> {
	            if ( !paivakirjaCtrl.voikoSulkea() ) event.consume();
	        });
	        
	        
	        Paivakirja paivakirja = new Paivakirja(); 
	        paivakirjaCtrl.setPaivakirja(paivakirja);
	        
	        primaryStage.show();
	        
	        /*Application.Parameters params = getParameters();
            if ( params.getRaw().size() > 0 )
                paivakirjaCtrl.lueTiedosto(params.getRaw().get(0));
            else */
            if ( !paivakirjaCtrl.avaa() ) Platform.exit();
                
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * K�ynnist�� ohjelman
	 * @param args ei k�yt�ss�
	 * 
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
