package com.mycompany.sustainia;

public class Game {
    private Room currentRoom;
 // private Inventory inv;
        
    public static String name;
    
    public Game() 
    {
        Parameter.createParameters();
  //    inv = new Inventory();
    }


    private void createRooms()
    {
        Room office, streets, nonsustainableHouse, policeStation, bank, clothingFactory, waterPlant, 
                school, supermarket, clothingStore, oldDecayingBuilding, park, 
                hospital, recyclingStation;
        
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
        
        office = new Room();
        nonsustainableHouse = new Room();
        policeStation = new Room();
        bank = new Room();
        clothingFactory = new Room();
        waterPlant = new Room();
        school = new Room();
        supermarket = new Room();
        clothingStore = new Room();
        oldDecayingBuilding = new Room();
        park = new Room();
        hospital = new Room();
        recyclingStation = new Room();
        
        currentRoom = office;
    }
    public void createStreets();
    
    streets = new Room();
        streetsHitbox1 = new HitBox();
        HitBox testBox = new HitBox(546*4, 527*4, 32*4, 22*4);
    
}
