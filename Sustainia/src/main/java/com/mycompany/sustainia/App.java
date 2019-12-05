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
import java.io.IOException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

// import java.awt.event.KeyEvent;

/**
 * JavaFX App
 */
public class App extends Application {
    World wo = new World();
    Game game = new Game();
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
    private ImageView rooms;
    private ImageView streetTop;
    private ImageView character;
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    @Override
    public void start(Stage stage) throws FileNotFoundException, IOException {
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
        
        
        PrimaryController pc = new PrimaryController();
        //Creating a scene object 
        Scene scene = new Scene(loadFXML("primary"), 900, 600);
        
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
                    case A: goWest  = false; break;
                }
            }
        });
        
        //Setting title to the Stage 
        stage.setTitle("Moving Image Test");
        stage.setResizable(false);
        
        //Adding scene to the stage        
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();
        
        characterAnimation();
        drawRoom(game.currentRoom);
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
        
        dx = game.collisionDetectionX(dx);
        dy = game.collisionDetectionY(dy);
        
        wo.gameX += dx;
        wo.gameY += dy;
        
        this.rooms.setX(wo.gameX);
        this.rooms.setY(wo.gameY);
        this.streetTop.setX(wo.gameX);
        this.streetTop.setY(wo.gameY);
        
        // The games cordinants are needet to position the collision
        game.collisionWithObjects(wo.gameX, wo.gameY);
        
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
    private void drawRoom(Room currentRoom){
        if (currentRoom.equals(game.streets)){
            wo.gameX = -400*4;
            wo.gameY = -500*4;
            this.rooms.setFitWidth(1120*4);
            this.rooms.setFitHeight(770*4);
            rooms.setViewport(new Rectangle2D(0, 0, 1120*4, 770*4));
        } else if (currentRoom.equals(game.townHall)){
            wo.gameX = -128*4+300-64;
            wo.gameY = -200*4+300-64;
            this.rooms.setFitWidth(256*4);
            this.rooms.setFitHeight(209*4);
            rooms.setViewport(new Rectangle2D(0, 770*4, 256*4, 209*4));
        } else if (currentRoom.equals(game.nonsustainableHouse)){
            rooms.setViewport(new Rectangle2D(256*4, 770*4, 256*4, 209*4));
        }
    }
    
    public static void runApp(String[] args) {
        launch();
    }

}