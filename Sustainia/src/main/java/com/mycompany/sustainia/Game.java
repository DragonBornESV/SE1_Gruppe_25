package com.mycompany.sustainia;

public class Game {
    int currentRoomNr = 1;
    
    Room streets = new Room("Streets");
    Room townHall = new Room("Town Hall");
    Room nonsustainableHouse = new Room("NSH");
    Room policeStation = new Room("Police Station");
    Room bank = new Room("Bank");
    Room clothingFactory = new Room("Colothing Factory");
    Room school = new Room("School");
    Room park = new Room("Park");
    Room recyclingStation = new Room("Recycling Station");
        
    Room currentRoom = bank;
    
    HitBox testBox = new HitBox(546*4, 527*4, 32*4, 22*4);
    HitBox[] hitboxArray = {testBox};
    
 // private Inventory inv;
        
    public static String name;
    
    public Game() 
    {
        Parameter.createParameters();
  //    inv = new Inventory();
    }


    private void createRooms(){
        
        /** Rooms are created and named.
         *  Rooms are assigned an intro which describes where the player are at.
         *  Rooms are also assigned an exit command.
         */
        
    /*    
        int[] mayorItems = new int[]{0,0,0,0,2,0,0,0,0,0};
        int[] houseItems = new int[]{5,1,4,40,1,5,10,40,100,4};
        int[] policeItems = new int[]{0,1,0,5,8,0,0,0,50,40};
        int[] bankItems = new int[]{0,0,0,0,10,0,0,0,30,0};
        int[] factoryItems = new int[]{0,0,70,100,5,0,0,0,0,0};
        int[] waterPlantItems = new int[]{0,0,0,0,3,0,0,0,10,0};
        int[] schoolItems = new int[]{0,2,0,0,50,0,10,60,120,0};
        int[] supermarketItems = new int[]{100,10,30,90,9,50,100,0,200,40};
        int[] storeItems = new int[]{0,0,10,300,5,10,0,0,0,0};
        int[] buildingItems = new int[]{100,5,0,10,0,0,30,20,40,20};
        int[] parkItems = new int[]{0,0,0,0,0,0,25,70,50,0};
        int[] hospitalItems = new int[]{0,0,0,50,30,20,0,10,60,0};
    
    */
    }
    
    
    public int collisionDetectionX(int dx){
        for (int i = 0; i < hitboxArray.length; i++) {
            if (hitboxArray[i].collisionLeft){
            dx = 1;
            } else {
                dx = dx;
            }
            if (hitboxArray[i].collisionRight){
                dx = -1;
            } else {
                dx = dx;
            }
        }
        return dx;
    }
    
    public int collisionDetectionY(int dy){
        for (int i = 0; i < hitboxArray.length; i++) {
            if (hitboxArray[i].collisionTop){
            dy = 1;
            } else {
                dy = dy;
            }
            if (hitboxArray[i].collisionBottom){
                dy = -1;
            } else {
                dy = dy;
            }
        }
        return dy;
    }
    
    public void collisionWithObjects(int x, int y){
        if (currentRoom.equals(streets)){
            testBox.collisionWithObject(x, y);
        } else {
            return;
        }
    }
    
    
    public void play(){
        createRooms();
    }
        
}
