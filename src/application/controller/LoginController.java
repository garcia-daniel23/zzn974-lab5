package application.controller;

import javafx.scene.control.TextField;
import application.model.UserProfile;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * 
 * @author Daniel Garcia
 * Controller that handles what happens when the user has a valid or invalid login
 */
public class LoginController implements EventHandler<ActionEvent>  {

	@FXML
	private AnchorPane rootPane;
	
	@FXML
	public TextField user;
	
	@FXML
	public TextField pass;
	
	@FXML
	/**
	 * Method that handles the event of when the button is clicked
	 */
	public void handle(ActionEvent event) {
		if( UserProfile.authenticate(user.getText(),pass.getText())!= null)
		{
			try {
			Stage primaryStage = new Stage();
			
						Parent root = FXMLLoader.load(getClass().getResource("/Recipe.fxml"));
						primaryStage.setScene(new Scene(root));
						primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
			System.out.println(user.getText());
			System.out.println(pass.getText());
		}
		else
		{
			 try {
			        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Restricted.fxml"));
			                Parent root1 = (Parent) fxmlLoader.load();
			                Stage stage = new Stage();
			                stage.setScene(new Scene(root1));  
			                stage.show();
			        } catch(Exception e) {
			           e.printStackTrace();
			          }
		}
		
	}

	
}
