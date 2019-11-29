package sample;

import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Level1 extends Level implements Initializable {

    public Level1 (){
        int number_of_Zombies= 3;

        for(int i=0; i< number_of_Zombies; i++){
            arrayList_Zombie.add( new Zombie());
        }
        number_Tracks= 1;

        level_Number =1;

        for(int j=0 ; j<number_Tracks; j++){
            array_Lawnmower.add(new LawnMower());
        }

        plants_Available.add( new ProjectileShooter());


    }

    @FXML
    private ImageView zombie1;
    @FXML
    private ImageView peashooter_card,progressbarhead, progressbar2,  peaOfPlacedPlant1, peaOfPlacedPlant2, peaOfPlacedPlant3, peaOfPlacedPlant4, peaOfPlacedPlant5, peaOfPlacedPlant6, peaOfPlacedPlant7, peaOfPlacedPlant8, peaOfPlacedPlant9, onexzero, twoxzero, threexzero, fourxzero, fivexzero, sixxzero, sevenxzero, eightxzero, ninexzero;

    @FXML
    public void handleDragDetected(MouseEvent event) throws FileNotFoundException{
        Dragboard db = peashooter_card.startDragAndDrop((TransferMode.ANY));
        ClipboardContent cb = new ClipboardContent();
        FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\plant_gifs\\peashooter.gif");
        Image peashooter_img = new Image(inputstream);
        cb.putImage(peashooter_img);
        db.setContent(cb);
        event.consume();
    }
    // for lawn
    @FXML
    public void handleDragOver(DragEvent event){
        if(event.getDragboard().hasImage()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }
    //for lawn
    @FXML
    public void handleDragDrop1(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        onexzero.setImage(peashooter_img);
        plantAttack(onexzero);
    }
    @FXML
    public void handleDragDrop2(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        twoxzero.setImage(peashooter_img);
        plantAttack(twoxzero);
    }
    @FXML
    public void handleDragDrop3(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        threexzero.setImage(peashooter_img);
        plantAttack(threexzero);
    }
    @FXML
    public void handleDragDrop4(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        fourxzero.setImage(peashooter_img);
        plantAttack(fourxzero);
    }
    @FXML
    public void handleDragDrop5(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        fivexzero.setImage(peashooter_img);
        plantAttack(fivexzero);
    }
    @FXML
    public void handleDragDrop6(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        sixxzero.setImage(peashooter_img);
        plantAttack(sixxzero);
    }
    @FXML
    public void handleDragDrop7(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        sevenxzero.setImage(peashooter_img);
        plantAttack(sevenxzero);
    }@FXML
    public void handleDragDrop8(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        eightxzero.setImage(peashooter_img);
        plantAttack(eightxzero);
    }@FXML
    public void handleDragDrop9(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        ninexzero.setImage(peashooter_img);
        plantAttack(ninexzero);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        zombiemove();
        progressbar();
    }
    public void progressbar(){
        TranslateTransition translationElement = new TranslateTransition(Duration.seconds(30), progressbarhead);
        translationElement.setCycleCount(1);
        translationElement.setFromX(progressbarhead.getX() );
        translationElement.setToX( progressbarhead.getX()-160);

        translationElement.play();
    }
    public void zombiemove() {
        TranslateTransition translationElement = new TranslateTransition(Duration.seconds(30), zombie1);
        translationElement.setFromX(zombie1.getX() );
        translationElement.setToX( zombie1.getX()-400 );
        translationElement.setCycleCount(1);
        translationElement.play();
        // to make the the image invisible
        translationElement.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                zombie1.setVisible(false);
            }
        });




    }
    public void plantAttack(ImageView placeHolderPlant) throws FileNotFoundException{
        double posX= placeHolderPlant.getLayoutX()+placeHolderPlant.getFitWidth();
        double posY = placeHolderPlant.getLayoutY();
        System.out.println(posX);
        System.out.println(posY);
        String number = placeHolderPlant.getId();
        double amount = 0;
        ImageView peaOfPlacedPlant = null;
        if(number.substring(0,2).equals("on")){
            peaOfPlacedPlant = peaOfPlacedPlant1;

        }
        else if(number.substring(0,2).equals("tw")){
            peaOfPlacedPlant = peaOfPlacedPlant2;
            amount =45;
        }
        else if(number.substring(0,2).equals("th")) {
            peaOfPlacedPlant = peaOfPlacedPlant3;
            amount = 90;
        }
        else if(number.substring(0,2).equals("fo")){
            peaOfPlacedPlant = peaOfPlacedPlant4;
            amount = 180;
        }
        else if(number.substring(0,2).equals("fi")){
            peaOfPlacedPlant = peaOfPlacedPlant5;
            amount = 225;
        }
        else if(number.substring(0,2).equals("si")){
            peaOfPlacedPlant = peaOfPlacedPlant6;
            amount = 270;
        }
        else if(number.substring(0,2).equals("se")){
            peaOfPlacedPlant = peaOfPlacedPlant7;
            amount = 315;
        }else if(number.substring(0,2).equals("ei")){
            peaOfPlacedPlant = peaOfPlacedPlant8;
            amount = 360;
        }
        else if(number.substring(0,2).equals("ni")){
            peaOfPlacedPlant = peaOfPlacedPlant9;
            amount = 380;
        }



        peaOfPlacedPlant.setLayoutX(posX);
        peaOfPlacedPlant.setLayoutY(posY);

        peaOfPlacedPlant.setVisible(true);
        System.out.println("pea");
        TranslateTransition translationElement = new TranslateTransition(Duration.seconds(10-(amount/100)*2), peaOfPlacedPlant);
        translationElement.setFromX(peaOfPlacedPlant.getX() );
        translationElement.setCycleCount(TranslateTransition.INDEFINITE);
        translationElement.setAutoReverse(false);
        translationElement.setToX( peaOfPlacedPlant.getX()+400- amount );

        translationElement.play();


    }
    @FXML
    public void quitButtonPressed(ActionEvent event){
        System.exit(0);
    }

    @FXML
    public void saveGameButtonPressed(ActionEvent event){    }
}