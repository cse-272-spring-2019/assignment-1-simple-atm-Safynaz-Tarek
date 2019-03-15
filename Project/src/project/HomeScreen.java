package project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HomeScreen{
    Scene scene;
    Stage stage;
    LoginForm login;
    NumPad num;
    ATM atm;
    
    
    public HomeScreen(Stage stage, ATM atm){
        this.stage = stage;
        this.atm = atm;
    }
    public void prepareScene(){
        TextField info = new TextField();
        Button balance = new Button("Current Balance");
        Button withdraw = new Button("Withdraw");
        Button deposit = new Button("Deposit");
        Button prev = new Button("Previous");
        Button next = new Button("Next");
        info.setEditable(false);
        balance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String balanceString = Double.toString(atm.inquireBalance());
                info.setText(balanceString);
            }
        });
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                num.setCurrentStatus("deposit");
                info.setText("");
                stage.setScene(num.getScene());
            }
        });
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                num.setCurrentStatus("withdraw");
                info.setText("");
                stage.setScene(num.getScene());
            }
        });
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                info.setText(atm.next());
            }
        });
        prev.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                info.setText(atm.prev());
            }
        });
        GridPane root =  new GridPane();
        root.add(info,0,0);
        root.add(balance,0,1);
        root.add(prev,0,2);
        root.add(next,0,3);
        root.add(withdraw,0,4);
        root.add(deposit,0,5);
        
        scene = new Scene(root ,250,200);
    }
    public Scene getScene(){
        return this.scene;
    }
    public void setLogin(LoginForm login) {
        this.login = login;
    }
    public void setNum(NumPad num) {
        this.num = num;
    }
}
