package project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;

public class NumPad{
    Scene scene;
    Stage stage;
    HomeScreen home;
    ATM atm;
    String amount ="";
    String currentStatus="";
    
    public NumPad(Stage stage,ATM atm){
        this.stage = stage;
        this.atm = atm;
    }
    public void prepareScene() {
        TextField amountLabel  = new TextField();
        Label inst = new Label("Enter amount  ");
        Button btn0 = new Button("0");
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button enter = new Button("Enter");
        Button clear = new Button("Clear");
        Button ret = new Button("Return");
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");

        
        amountLabel.setEditable(false);
        btn0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amount = amount + "0";
                amountLabel.setText(amount);
               
            }
        });
        btn1.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
                amount = amount + "1";
                amountLabel.setText(amount);
                
           }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 amount = amount + "2";
                 amountLabel.setText(amount);
                
            }
        });
        btn3.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
                amount = amount + "3";
                amountLabel.setText(amount);
               
           }
        });
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amount = amount + "4";
                amountLabel.setText(amount);
                
            }
        });
        btn5.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
                amount = amount + "5";
                amountLabel.setText(amount);
               
           }
        });
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 amount = amount + "6";
                 amountLabel.setText(amount);
                 
            }
        });
        btn7.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
                amount = amount + "7";
                amountLabel.setText(amount);
                
           }
        });
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 amount = amount + "8";
                 amountLabel.setText(amount);
                
            }
        });
        btn9.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               amount = amount + "9";
               amountLabel.setText(amount);
            
           }
        });
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountLabel.setText("You entered: "+amount);
                Double amountDouble = Double.parseDouble(amount);
                Double CurrentBalance = atm.getBalance();
                if(currentStatus.equals("withdraw")){
 
                    if( amountDouble > CurrentBalance){
                                alert.setContentText("Process UnSuccessfull the amount you chose to withdraw is greater than the balance");
                                alert.showAndWait();
                        
                    }
                    else if (amountDouble < 0){
                        alert.setContentText("Please enter a valid number");
                        alert.showAndWait();
                    }
                    else{
                        atm.withDraw(amountDouble);
                        amountLabel.setText("Withdraw Succssfull");
                    }
                }
                else if((currentStatus.equals("deposit"))){
                    if (amountDouble < 0){
                        alert.setContentText("Please enter a valid number");
                        alert.showAndWait();
                        
                    }
                    else{
                        atm.deposit(amountDouble);
                        amountLabel.setText("deposit Succssfull");
                    }
                }
                
            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(amount.length() ==0){
                    amountLabel.setText("no number entered");
                }
                else {
                amount = amount.substring(0, amount.length() - 1);
                amountLabel.setText(amount);
                }
            }
        });
        ret.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amount = "";
                amountLabel.setText("");
                currentStatus = "";
                stage.setScene(home.getScene());
            }
        });
               
        GridPane root = new GridPane();
        root.add(btn1,0,0);
        root.add(btn2,2,0);
        root.add(btn3,4,0);
        root.add(btn4,0,2);
        root.add(btn5,2,2);
        root.add(btn6,4,2);
        root.add(btn7,0,4);
        root.add(btn8,2,4);
        root.add(btn9,4,4);
        root.add(btn0,0,6);
        root.add(enter,6,2);
        root.add(clear,6,0);
        root.add(ret,6,4);
        root.add(amountLabel,8,6);
        root.add(inst,6,6);
        scene = new Scene(root, 350, 250);
    }
    
    public Scene getScene() {
        return scene;
    }
    public void setHome(HomeScreen home) {
        this.home = home;
    }
    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
}
