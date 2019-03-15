package project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginForm {
    Scene scene;
    LoginAuth auth;
    HomeScreen home;
    Stage stage;
    
    public LoginForm(Stage stage){
        this.stage = stage;
    }
    public void setHome(HomeScreen home) {
        this.home = home;
    }

    public void prepareScene() {
        
        auth = new LoginAuth();
        Button submit = new Button("Submit");
        PasswordField passwordField = new PasswordField();
        Label passwordLabel = new Label("Password: ");
        Label validationLabel = new Label();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String password = passwordField.getText();
                boolean valid = auth.validate(Integer.parseInt(password));
                if(valid){
                validationLabel.setText("Welcome ");
                stage.setScene(home.getScene());
                }
                else{
                alert.setContentText("Wrong password");
                alert.showAndWait();
                }
            }
        });
        
        GridPane root = new GridPane();
        
        root.add(passwordLabel,0,1 );
        root.add(passwordField,1,1 );
        root.add(submit,1,2 );
        root.add(validationLabel,1,3 );
        
        scene = new Scene(root, 300, 150);
       
    }
    public Scene getScene(){
        return this.scene;
    }
}
