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
    HitBox testBox = new HitBox(546*4, 527*4, 32*4, 22*4);
  //  Collision col = new Collision(wo);
    
    int cW = 320;
    int cH = 320;
    boolean goNorth = false;
    boolean goSouth = false;
    boolean goEast  = false;
    boolean goWest  = false;
    boolean moving  = false;
    int facing = 0;
    int animationTimer = 0;
    private ImageView street;
    private ImageView streetTop;
    private ImageView character;
    
    
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        // Creates a new image, from the selected parth on computer
        FileInputStream inputStreets = new FileInputStream("img\\street.png");
        Image streetsImage = new Image(inputStreets,1120*4,770*4,true,false);
        FileInputStream inputCharacter = new FileInputStream("img\\ch.png");
        Image characterImage = new Image(inputCharacter,1280,1280,true,false);
        FileInputStream inputStreetsTop = new FileInputStream("img\\street_top.png");
        Image streetsTopImage = new Image(inputStreetsTop,1120*4,770*4,true,false);
        
        
        //Setting the image view
        this.street = new ImageView(streetsImage);
        this.character = new ImageView(characterImage);
        character.setViewport(new Rectangle2D(0, 0, cW, cH));
        this.streetTop = new ImageView(streetsTopImage);
        
        //Setting the position of the image 
        this.street.setX(wo.gameX);
        this.street.setY(wo.gameY);
        
        this.character.setX(wo.characterX);
        this.character.setY(wo.characterY);
        
        this.streetTop.setX(wo.gameX);
        this.streetTop.setY(wo.gameY);
        
        //setting the fit height and width of the image view 
        this.street.setFitWidth(1120*4);
        this.street.setFitHeight(770*4);
        
        this.character.setFitWidth(cW*0.1*4);
        this.character.setFitHeight(cH*0.1*4);
        
        this.streetTop.setFitWidth(1120*4);
        this.streetTop.setFitHeight(770*4);
        
        //Setting the preserve ratio of the image view 
        this.street.setPreserveRatio(true);
        this.character.setPreserveRatio(true);
        this.streetTop.setPreserveRatio(true);
        
        //Creating a Group object  
        Group root = new Group(this.street, this.character, this.streetTop);
        
        //Creating a scene object 
        Scene scene = new Scene(root, wo.gameScreenWidth, wo.gameScreenHeight);
        
// KEYS pressed
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                switch(e.getCode()){
                    case W: goNorth = true; break;
                    case S: goSouth = true; break;
                    case D: goEast  = true; break;
                    case A: goWest  = true; break;
                }
            }
        });

// KEYS pressed        
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                switch(e.getCode()){
                    case W: goNorth = false; break;
                    case S: goSouth = false; break;
                    case D: goEast  = false; break;
                    case A:  goWest  = false; break;
                }
            }
        });
        
        //Setting title to the Stage 
        stage.setTitle("Moving Image Test");
        
        //Adding scene to the stage        
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();
        
        characterAnimation();
    }
    
    private void characterAnimation() {
        AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    int dx = 0, dy = 0;

                    if      (goNorth) {dy += wo.characterMovementSpeedV; facing = 0; moving = true;}
                    else if (goSouth) {dy -= wo.characterMovementSpeedV; facing = 1; moving = true;}
                    else if (goEast)  {dx -= wo.characterMovementSpeedH; facing = 2; moving = true;}
                    else if (goWest)  {dx += wo.characterMovementSpeedH; facing = 3; moving = true;}
                    else    { moving = false;}

                    if (moving) animationTimer ++;

                    moveCharacter(moving, goNorth, goSouth, goEast, goWest, dx, dy, animationTimer, facing);

                }
            };

            timer.start();
    }
    
    private void moveCharacter (boolean moving, boolean goNorth, boolean goSouth, boolean goEast, boolean goWest, int dx, int dy, int at, int facing){
        
        dx = testBox.collisionDetectionX(dx);
        dy = testBox.collisionDetectionY(dy);
        
        wo.gameX += dx;
        wo.gameY += dy;
        
        this.street.setX(wo.gameX);
        this.street.setY(wo.gameY);
        this.streetTop.setX(wo.gameX);
        this.streetTop.setY(wo.gameY);
        
        testBox.collisionWithObject(wo.gameX, wo.gameY);
        
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