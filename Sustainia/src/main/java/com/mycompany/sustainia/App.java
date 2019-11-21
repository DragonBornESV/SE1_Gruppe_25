package com.mycompany.sustainia;

// Standert javaFX imports
import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
// import javafx.scene.input.KeyCode;

// Specific to image loading imports
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// for key presses

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

// import java.awt.event.KeyEvent;

/**
 * JavaFX App
 */
public class App extends Application {
    World wo = new World();
  //  Collision col = new Collision(wo);
    
    int cW = 320;
    int cH = 320;
    boolean goNorth = false;
    boolean goSouth = false;
    boolean goEast  = false;
    boolean goWest  = false;
    boolean moving  = false;
    int facing = 0;
    int at = 0;
    private ImageView street;
    private ImageView character;
    
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        // Creates a new image, from the selected parth on computer
        FileInputStream inputStreets = new FileInputStream("img\\street.png");
        Image streetsImage = new Image(inputStreets,11200,7700,true,false);
        FileInputStream inputCharacter = new FileInputStream("img\\ch.png");
        Image characterImage = new Image(inputCharacter,1280,1280,true,false);
        
        
        
        //Setting the image view
        this.street = new ImageView(streetsImage);
        this.character = new ImageView(characterImage);
        character.setViewport(new Rectangle2D(0, 0, cW, cH));
        
        //Setting the position of the image 
        this.street.setX(wo.gameX);
        this.street.setY(wo.gameY);
        
        this.character.setX(wo.characterX);
        this.character.setY(wo.characterY);
        
        //setting the fit height and width of the image view 
        this.street.setFitWidth(1120*4);
        this.street.setFitHeight(770*4);
        
        this.character.setFitWidth(cW*0.1*4);
        this.character.setFitHeight(cH*0.1*4);
        
        //Setting the preserve ratio of the image view 
        this.street.setPreserveRatio(true);
        this.character.setPreserveRatio(true);
        
        //Creating a Group object  
        Group root = new Group(this.street, this.character);
        
        //Creating a scene object 
        Scene scene = new Scene(root, wo.gameScreenWidth, wo.gameScreenHeight);
        
// KEYS pressed
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                switch(e.getCode()){
                    case UP:    goNorth = true; break;
                    case DOWN:  goSouth = true; break;
                    case RIGHT: goEast  = true; break;
                    case LEFT:  goWest  = true; break;
                }
            }
        });

// KEYS pressed        
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                switch(e.getCode()){
                    case UP:    goNorth = false; break;
                    case DOWN:  goSouth = false; break;
                    case RIGHT: goEast  = false; break;
                    case LEFT:  goWest  = false; break;
                }
            }
        });
        
        //Setting title to the Stage 
        stage.setTitle("Moving Image Test");
        
        //Adding scene to the stage        
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();
        
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;
                
                if      (goNorth) {dy += wo.characterMovementSpeedV; facing = 0; moving = true;}
                else if (goSouth) {dy -= wo.characterMovementSpeedV; facing = 1; moving = true;}
                else if (goEast)  {dx -= wo.characterMovementSpeedH; facing = 2; moving = true;}
                else if (goWest)  {dx += wo.characterMovementSpeedH; facing = 3; moving = true;}
                else    { moving = false;}
                
                if (moving) at ++;
                
                moveCharacter(moving, goNorth, goSouth, goEast, goWest, dx, dy, at, facing);
                
                //col.collisionDetection();
                //col.collisionInStreets();
            }
        };
        
        timer.start();
    }
    
    private void moveCharacter (boolean moving, boolean goNorth, boolean goSouth, boolean goEast, boolean goWest, int dx, int dy, int at, int facing){
        wo.gameX += dx;
        wo.gameY += dy;
        
        this.street.setX(wo.gameX);
        this.street.setY(wo.gameY);
        
        
        
        // character_animation
        if (moving) {
            if (goNorth){
                character.setViewport(new Rectangle2D(cW*(int)((at/10)%4), cH*3, cW, cH));
            }
            else if (goSouth){
                character.setViewport(new Rectangle2D(cW*(int)((at/10)%4), cH*0, cW, cH));
            }
            else if (goEast){
                character.setViewport(new Rectangle2D(cW*(int)((at/10)%4), cH*2, cW, cH));
            }
            else if (goWest){
                character.setViewport(new Rectangle2D(cW*(int)((at/10)%4), cH*1, cW, cH));
            }
        } else {
            if (facing == 0){
                character.setViewport(new Rectangle2D(0, cH*3, cW, cH));
            }
            else if (facing == 1){
                character.setViewport(new Rectangle2D(0, cH*0, cW, cH));
            }
            else if (facing == 2){
                character.setViewport(new Rectangle2D(0, cH*2, cW, cH));
            }
            else if (facing == 3){
                character.setViewport(new Rectangle2D(0, cH*1, cW, cH));
            }
        }
        
    }
    

    public static void runApp(String[] args) {
        launch();
    }

}