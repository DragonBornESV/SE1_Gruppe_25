/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sustainia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Theis Agerskov Tengs
 */
public class PrimaryController {
    int cW = 320;
    int cH = 320;
    private ImageView rooms;
    private ImageView streetTop;
    private ImageView character;
    World wo = new World();
    Game game = new Game();

    @FXML
    public AnchorPane gamePane;
    @FXML
    public AnchorPane menuPane;
    @FXML
    private Button btn;
    @FXML
    public SplitPane wholeScene;
    
    /*public PrimaryController(){
        this.gamePane = new AnchorPane();
        this.menuPane = new AnchorPane();
        this.wholeScene = new SplitPane();
        this.btn = new Button();
        
        menuPane.getChildren().add(btn);
        
        wholeScene.getItems().addAll(gamePane, menuPane);
    }
*/
           
    public void PrimaryController() throws FileNotFoundException, IOException {
        // Creates a new image, from the selected parth on computer
        FileInputStream inputCharacter = new FileInputStream("img\\ch.png");
        Image characterImage = new Image(inputCharacter,1280,1280,true,false);
        
        // Streets
        FileInputStream inputRooms = new FileInputStream("img\\rooms.png");
        Image roomsImage = new Image(inputRooms,1120*4,1188*4,true,false);
        FileInputStream inputStreetsTop = new FileInputStream("img\\street_top.png");
        Image streetsTopImage = new Image(inputStreetsTop,1120*4,770*4,true,false);
        
        
        //Setting the image view
        this.rooms = new ImageView(roomsImage);
        rooms.setViewport(new Rectangle2D(0, 0, 1120*4, 770*4));
        this.character = new ImageView(characterImage);
        character.setViewport(new Rectangle2D(0, 0, cW, cH));
        this.streetTop = new ImageView(streetsTopImage);
        
        //Setting the position of the image 
        this.rooms.setX(wo.gameX);
        this.rooms.setY(wo.gameY);
        
        this.character.setX(wo.characterX);
        this.character.setY(wo.characterY);
        
        this.streetTop.setX(wo.gameX);
        this.streetTop.setY(wo.gameY);
        
        //setting the fit height and width of the image view 
        this.rooms.setFitWidth(1120*4);
        this.rooms.setFitHeight(1188*4);
        
        this.character.setFitWidth(cW*0.1*4);
        this.character.setFitHeight(cH*0.1*4);
        
        this.streetTop.setFitWidth(1120*4);
        this.streetTop.setFitHeight(770*4);
        
        //Setting the preserve ratio of the image view 
        this.rooms.setPreserveRatio(true);
        this.character.setPreserveRatio(true);
        this.streetTop.setPreserveRatio(true);
        
        
        //Creating a Group object  
        Group root = new Group(this.rooms, this.character, this.streetTop);
        
        gamePane.getChildren().add(root);
    }    

    @FXML
    private void print(ActionEvent event) {
        System.out.println("Hello World!");
        
    }
    
    
    
}
