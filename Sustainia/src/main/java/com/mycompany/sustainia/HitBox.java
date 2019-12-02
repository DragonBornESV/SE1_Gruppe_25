package com.mycompany.sustainia;

public class HitBox {
    
    int topLeftX;
    int topLeftY;
    int width;
    int height;
    
    World wo = new World();
   
    int[] characterHitbox = {wo.characterX +24, wo.characterY, wo.characterX + wo.characterWidth -24, wo.characterY + wo.characterHeight};
    
    boolean collisionTop;
    boolean collisionBottom;
    boolean collisionLeft;
    boolean collisionRight;
    
    public HitBox(int topLeftX, int topLeftY, int width, int height){
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.width = width;
        this.height = height;
    }
    
    
    public void collisionWithObject(int x, int y){
        if ((characterHitbox[0] > topLeftX + x && characterHitbox[0] < topLeftX + width + x) || (characterHitbox[2] > topLeftX + x && characterHitbox[2] < topLeftX + width + x)){
            if (characterHitbox[3] > topLeftY + y && characterHitbox[3] < topLeftY + y + 24){
                collisionTop = true;
            } else {
                collisionTop = false;
            }
            if (characterHitbox[3] -24 < topLeftY + height + y && characterHitbox[3] > topLeftY + height + y - 24) {
                collisionBottom = true;
            } else {
                collisionBottom = false;
            }
        } else {
            collisionTop = false;
            collisionBottom = false;
            }
        if ((characterHitbox[3] > topLeftY + y && characterHitbox[3] < topLeftY + height + y) || (characterHitbox[1] < topLeftY + y && characterHitbox[1] > topLeftY + height + y)){
            if (characterHitbox[2] > topLeftX + x && characterHitbox[2] < topLeftX + x + 24){
                collisionLeft = true;
            } else {
                collisionLeft = false;
            }
            if (characterHitbox[0] < topLeftX + width + x && characterHitbox[0] > topLeftX + width + x - 24){
                collisionRight = true;
            } else {
                collisionRight = false;
            }
        } else {
            collisionLeft = false;
            collisionRight = false;
        }
        
        System.out.println(topLeftX+x);
        System.out.println(characterHitbox[2]);
        System.out.println(collisionTop);
    }
}
