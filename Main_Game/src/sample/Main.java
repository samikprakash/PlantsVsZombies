package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("new hello world");
        Button button = new Button("click me now");
        button.setOnAction(new ClickEvent());
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);
        Scene scene = new Scene(stackPane,1000,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
<<<<<<< HEAD
    public void f2(){
        System.out.println("ohno");
    }
=======
    public void f1(){
        System.out.println("kya yeh chal gaya?");
    }

>>>>>>> 2698332a0dd5aa6e51e45dddd5e5cfb0ac5efccb

    public static void main(String[] args) {
        launch(args);
    }
}
class ClickEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("it works!!!");
    }
}
