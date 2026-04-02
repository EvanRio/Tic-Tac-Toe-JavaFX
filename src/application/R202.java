package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class R202 extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("R202.fxml"));
		Scene scene = new Scene(root,600,750); //Defini la taille par defaut de la page
		primaryStage.setResizable(false); //Bloque le fait de pouvoir redimensioner la page
		primaryStage.setTitle("Tic-Tac-Toe"); //Titre de la page
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		}
}
