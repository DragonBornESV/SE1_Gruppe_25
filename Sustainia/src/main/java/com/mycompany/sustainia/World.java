package com.mycompany.sustainia;

public class World {
    /*
     * Because of the sudo 3d overhead prespective the horizontal and vertical movementspeed is not the same.
     * Because you view the game ad a 45 degree angle, the horizontal movmentspeed will alwayes equal sqrt((Vspeed^2)*2)) 
     */
    int gameScreenWidth = 600;
    int gameScreenHeight = 600;
    int gameX = -483*4;
    int gameY = -537*4;
    
    int characterWidth = 32*4;
    int characterHeight = 32*4;
    int characterMovementSpeedV = 4;
    int characterMovementSpeedH = 6;
    
    int characterX = (gameScreenWidth/2)-characterWidth/2;
    int characterY = (gameScreenHeight/2)-characterHeight/2;
    
}
