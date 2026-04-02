package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;

public class R202Controller {
	private Boolean PlayerTour = true; 	//Pour savoir au tour de quel joueur (true = X et false = O)
    private String joueurActuel; //Pour definir le jour actuel
    private int valeurCoup; //Valeur du coup en fonction du joueur qui joue
    private int nombreDeCoups = 0; //Compteur pour detecter le match nul
    private String pseudoJoueur1 = "Player 1(X)"; //Pour definir pseudo joueur 1
    private String pseudoJoueur2 = "Player 2(O)"; //Pour definir pseudo joueur 2
    private int scoreJoueur1 = 0; //Score joueur 1
    private int scoreJoueur2 = 0; //Score joueur 2
	
    @FXML private GridPane jeuGridPane; 
	@FXML private MenuItem rulesMenuItem; //Menu item du menu bar pour afficher les regles de l'appliation
	@FXML private MenuItem quitMenuItem; //Menu item du menu bar pour quitter l'appliation
	@FXML private Label aQuiLeTourLabel; //Label du texte de a qui est le tour
	@FXML private Button renameButton; 	//Boutton pour changer pseudo du joueur 1
	@FXML private Button rename2Button; //Boutton pour changer pseudo du joueur 2
	@FXML private TextField renameTextField; //Boutton pour changer pseudo du joueur 1
	@FXML private TextField rename2TextField; //Boutton pour changer pseudo du joueur 2
	
	private int[] lignes = new int[3]; // Compteurs pour les lignes
	private int[] colonnes = new int[3]; // Compteurs pour les lignes
	private int diagonale1 = 0; // Ccompteur 1er diagonale 
	private int diagonale2 = 0; // Compteur deuxieme diagonale

	
	@FXML
    public void handleButtonAction(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        
        // Place que si la case est vide
        if (clickedButton.getText() == null || clickedButton.getText().isEmpty()) {
            
            Integer row = GridPane.getRowIndex(clickedButton);
            Integer col = GridPane.getColumnIndex(clickedButton);
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;

            // Systeme de placement de X et O et ajout valeur
            if (PlayerTour) {
                clickedButton.setText("X");
                aQuiLeTourLabel.setText(pseudoJoueur2 + ", it's your turn");
                valeurCoup = 1;
                joueurActuel = pseudoJoueur1;
                PlayerTour = false;
            } else {
                clickedButton.setText("O");
                aQuiLeTourLabel.setText(pseudoJoueur1 + ", it's your turn");
                valeurCoup = -1;
                joueurActuel = pseudoJoueur2;
                PlayerTour = true;
            }

            // Mise a jour des compteurs des colonnes ligne ect
            nombreDeCoups++;
            lignes[r] += valeurCoup;
            colonnes[c] += valeurCoup;
            if (r == c) diagonale1 += valeurCoup;
            if (r + c == 2) diagonale2 += valeurCoup;

            // Verification si il y a une victoire
            if (Math.abs(lignes[r]) == 3 || Math.abs(colonnes[c]) == 3 || 
                Math.abs(diagonale1) == 3 || Math.abs(diagonale2) == 3) {
            	
            	colorierGagnant(clickedButton.getText()); //appel methode coloriage ligne gagnante
            	
            	//Pour le tableau des score
            	if (joueurActuel.equals(pseudoJoueur1)) {
                    scoreJoueur1++;
                } else {
                    scoreJoueur2++;
                }
            	
                AlerteVictoire(joueurActuel + " has won!");
            } 
            // Verification si ya un match nul 
            else if (nombreDeCoups == 9) {
                AlerteVictoire("It's a draw!");
            }
        }
    }
		
	//Fenetre non modale pour la victoire
	@FXML
    private void AlerteVictoire(String message) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(message);
        
     // On affiche le score actuel des deux joueurs
        alert.setContentText("--- Results Table ---\n" + 
                "[" + scoreJoueur1 + "] victories | " + pseudoJoueur1 + "\n" +
                "[" + scoreJoueur2 + "] victories | " + pseudoJoueur2 + "\n" +
                "------------------------------\n\n" +
        		"Would you like to start a new game?");
        
        ButtonType replayButton = new ButtonType("Replay");
        ButtonType leaveButton = new ButtonType("Leave");
        
        alert.getButtonTypes().setAll(replayButton, leaveButton);

        // On récupère la réponse
        alert.showAndWait().ifPresent(reponse -> {
            if (reponse == replayButton) {
                resetGame(); // On relance
            } else if (reponse == leaveButton) {
                System.exit(0); // On quitte
            }
        });
    }
	
	//Fenetres non modale pour afficher les regles
	@FXML
	private void showAlert() {
	    Alert alert = new Alert(AlertType.NONE);
	    alert.setTitle("Rules of the game");
	    alert.setHeaderText("Tic-Tac-Toe Rules");
	    alert.setContentText(
	    	    "Tic-Tac-Toe is played by two players on a 3x3 grid.\n\n" +
	    	    "Players take turns placing their symbol (X or O).\n" +
	    	    "The goal is to align three identical symbols.\n\n" +
	    	    "The alignment can be horizontal, vertical, or diagonal.\n\n" +
	    	    "If all squares are filled and no player has won, the game is a draw."
	    	);
	    alert.getButtonTypes().setAll(ButtonType.OK);
	    alert.initModality(Modality.NONE);
	    alert.showAndWait();
	}
    	
	//Action pour fermer le jeux
	@FXML
	public void handleCloseMenuAction(ActionEvent event) {
	    System.exit(0);
	}
	
	//Action pour renomer le joueur 1
	@FXML
    public void handleButtonActionRename1(ActionEvent event) {
		pseudoJoueur1 = renameTextField.getText() + " (X)";
		
		//Pour renomer le label en fonction de a qui le tour
		if (PlayerTour == true) {
            aQuiLeTourLabel.setText(pseudoJoueur1 + ", it's your turn");
        } else {
            aQuiLeTourLabel.setText(pseudoJoueur2 + ", it's your turn");
        }
	}
	
	//Action pour renomer le joueur 2
	@FXML
    public void handleButtonActionRename2(ActionEvent event) {
		pseudoJoueur2 = rename2TextField.getText()+ " (0)";
		
		//Pour renomer le label en fonction de a qui le tour
		if (PlayerTour == false) {
            aQuiLeTourLabel.setText(pseudoJoueur2 + ", it's your turn");
        } else {
            aQuiLeTourLabel.setText(pseudoJoueur1 + ", it's your turn");
        }
	}
	
	//Action pour reload le jeux
	@FXML
	public void handleButtonActionReset(ActionEvent event) {
		resetGame();
		renameTextField.setText("Player 1"); //Remet field pseudo du joueur 1 a Player 1
		rename2TextField.setText("Player 2"); //Remet field pseudo du joueur 2 a Player 2
		pseudoJoueur1 = "Player 1(X)"; //Remet le pseudo du joueur 1 a Player 1(X)
		pseudoJoueur2 = "Player 2(O)"; //Remet le pseudo du joueur 2 a Player 2(X)
		aQuiLeTourLabel.setText("Player 1(X), it's your turn"); //Remet le le texte label initiale a valeur initiale
		scoreJoueur1 = 0; //Remet le score du joueur 1 a 0
		scoreJoueur2 = 0; //Remet le score du joueur 2 a 0
		
		//Nettoyer couleur et etat des button
		for (javafx.scene.Node node : jeuGridPane.getChildren()) {
			if (node instanceof Button) {
				Button btn = (Button) node;
			    btn.setText("");
			    btn.setStyle(null);
			    btn.setStyle("-fx-background-radius: 10"); //Remet le style arrondi des boutons
			}
		}
	}
	
	//Fenetres pour definir a qui de jouer en premier
	@FXML
	public void handleMenuActionFirstPlayer(ActionEvent event) {
	    Alert alert = new Alert(AlertType.CONFIRMATION);
	    alert.setTitle("Starting Player");
	    alert.setHeaderText("Who should start the game?");

	    //Creation des 3 boutons
	    ButtonType joueur1Button = new ButtonType(pseudoJoueur1);
	    ButtonType joueur2Button = new ButtonType(pseudoJoueur2);
	    ButtonType randomButton = new ButtonType("Random");
	    alert.getButtonTypes().setAll(joueur1Button, joueur2Button, randomButton, ButtonType.CANCEL);

	    //Gere les clics
	    alert.showAndWait().ifPresent(reponse -> {
	        if (reponse == joueur1Button) {
	            PlayerTour = true;
	            aQuiLeTourLabel.setText(pseudoJoueur1 + ", it's your turn");
	        } 
	        else if (reponse == joueur2Button) {
	            PlayerTour = false;
	            aQuiLeTourLabel.setText(pseudoJoueur2 + ", it's your turn");
	        } 
	        else if (reponse == randomButton) {
	            //Random button
	            Random random = new Random();
	            int choix = random.nextInt(2);
	            
	            if (choix == 0) {
	                PlayerTour = true;
	                aQuiLeTourLabel.setText(pseudoJoueur1 + ", it's your turn");
	            } else {
	                PlayerTour = false;
	                aQuiLeTourLabel.setText(pseudoJoueur2 + ", it's your turn");
	            }
	        }
	    });
	}
	
	//Pour reset le jeux compteur ect
	private void resetGame() {
		//Nettoyer couleur et etat des button
		for (javafx.scene.Node node : jeuGridPane.getChildren()) {
	        if (node instanceof Button) {
	            Button btn = (Button) node;
	            btn.setText("");
	            btn.setStyle(null); 
	            btn.setStyle("-fx-background-radius: 10");
	        }
	    }
		
        //Remettre les variables de calcul a zero
        nombreDeCoups = 0;
        diagonale1 = 0;
        diagonale2 = 0;
        for (int i = 0; i < 3; i++) {
            lignes[i] = 0;
            colonnes[i] = 0;
        }

        //Remettre le premier joueur (X)
        PlayerTour = true;
        aQuiLeTourLabel.setText(pseudoJoueur1 + ", it's your turn");

        //Vider le texte de tous les boutons dans le GridPane
        for (javafx.scene.Node node : jeuGridPane.getChildren()) {
            if (node instanceof Button) {
                ((Button) node).setText("");
            }
        }
    }
	
	//Methode pour colorier le cas gagnant
	private void colorierGagnant(String s) {
	    //Grille temporaire pour test les position
	    Button[][] b = new Button[3][3];
	    
	    for (javafx.scene.Node node : jeuGridPane.getChildren()) {
	        if (node instanceof Button) {
	            Integer r = GridPane.getRowIndex(node);
	            Integer c = GridPane.getColumnIndex(node);
	            b[r == null ? 0 : r][c == null ? 0 : c] = (Button) node;
	        }
	    }
	    
	    //Definit couleur du cas gagnant
	    String styleVert = "-fx-background-color: #03EA68; -fx-background-radius: 10";

	    // On regarde quel cas a gagner
	    for (int i = 0; i < 3; i++) {
	        //Test Lignes
	        if (s.equals(b[i][0].getText()) && s.equals(b[i][1].getText()) && s.equals(b[i][2].getText())) {
	            b[i][0].setStyle(styleVert); b[i][1].setStyle(styleVert); b[i][2].setStyle(styleVert);
	        }
	        //Test Colonnes
	        if (s.equals(b[0][i].getText()) && s.equals(b[1][i].getText()) && s.equals(b[2][i].getText())) {
	            b[0][i].setStyle(styleVert); b[1][i].setStyle(styleVert); b[2][i].setStyle(styleVert);
	        }
	    }
	    // TestDiagonales
	    if (s.equals(b[0][0].getText()) && s.equals(b[1][1].getText()) && s.equals(b[2][2].getText())) {
	        b[0][0].setStyle(styleVert); b[1][1].setStyle(styleVert); b[2][2].setStyle(styleVert);
	    }
	    if (s.equals(b[0][2].getText()) && s.equals(b[1][1].getText()) && s.equals(b[2][0].getText())) {
	        b[0][2].setStyle(styleVert); b[1][1].setStyle(styleVert); b[2][0].setStyle(styleVert);
	    }
	}
	
	
	
	

}

