package project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainPage extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Form");
        LoginForm loginform = new LoginForm(primaryStage);
        ATM atm = new ATM();
        HomeScreen homescreen = new HomeScreen(primaryStage,atm);
        NumPad num = new NumPad(primaryStage,atm);
      
        
        loginform.prepareScene();
        homescreen.prepareScene();
        num.prepareScene();
        
        loginform.setHome(homescreen);
        homescreen.setLogin(loginform);
        
        num.setHome(homescreen);
        homescreen.setNum(num);
        
        primaryStage.setScene(loginform.getScene());
        primaryStage.show();
    }
    
}
