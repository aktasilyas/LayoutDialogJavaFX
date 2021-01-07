package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label nameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private JFXButton addoneButton;

    @FXML
    private AnchorPane blackPane;

    @FXML
    private AnchorPane addPane;

    @FXML
    private JFXTextField nameText;

    @FXML
    private JFXTextField emailText;

    @FXML
    private JFXTextField phoneText;

    @FXML
    private JFXButton addLayoutButton;

    @FXML
    void initialize() {
       
               blackPane.setVisible(false);
               fadeTransition(.1, blackPane, 1, 0);
               scaleTransition(.1, addPane, -1, -1);

         addoneButton.setOnAction(e->{
        	 blackPane.setVisible(true);
             fadeTransition(.5, blackPane, 0, 0.3);
             scaleTransition(.5, addPane, 1, 1);
         });
         
         addLayoutButton.setOnAction(e->{
        	 
        	 
        	 blackPane.setVisible(false);
             fadeTransition(.5, blackPane, 5, 0);
            ScaleTransition scaleTransition= scaleTransition(.5, addPane, -1, -1);
            scaleTransition.setOnFinished(e1->{
            	 nameLabel.setText("Name\t"+nameText.getText());
            	 emailLabel.setText("Email\t"+emailText.getText());
            	 phoneLabel.setText("Phone\t"+phoneText.getText());
            });
         });
    }
    
    public FadeTransition fadeTransition(double duration,Node node,double from,double to) {
    	FadeTransition fadeTransition=new FadeTransition(Duration.seconds(duration),node);
    	fadeTransition.setFromValue(from);
    	fadeTransition.setToValue(to);
    	fadeTransition.play();
    	return fadeTransition;
    }
    
    public ScaleTransition scaleTransition(double duration,Node node,double byX,double byY) {
    	ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(duration),node);
    	scaleTransition.setByX(byX);
    	scaleTransition.setByY(byY);
    	scaleTransition.play();
    	return scaleTransition;
    			
    }
    
}
