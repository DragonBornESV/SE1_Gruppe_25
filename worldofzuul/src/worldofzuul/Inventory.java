package worldofzuul;

public class Inventory {
    // We create variables for our starting inventory stats.
    double money = 0;           // The amount of money the player is carrying.
    double carrying = 0;        // The current weight the player is carrying.
    int carryingCapacity = 100; // The total amount of weight the player is able to carry.

    
// Here the materials are constructed. In the following order given a name, value, weight and quantity.
    Material aluminum = new Material("Aluminum", 0.81, 0.1, 0);
    Material cloth    = new Material("Cloth   ", 2.10, 0.1, 0);
    Material compost  = new Material("Compost ", 0.37, 0.1, 0);
    Material concrete = new Material("Concrete", 2.42, 0.1, 0);
    Material copper   = new Material("Copper  ", 3.50, 0.1, 0);
    Material glass    = new Material("Glass   ", 0.60, 0.1, 0);
    Material iron     = new Material("Iron    ", 0.38, 0.1, 0);
    Material oakWood  = new Material("Oak Wood", 2.70, 0.1, 0);
    Material paper    = new Material("Paper   ", 1.75, 0.1, 0);
    Material plastic  = new Material("Plastic ", 2.10, 0.1, 0);
    Material rubber   = new Material("Rubber  ", 1.00, 0.1, 0);
    
// Here the items are constructed using the item datatype.
// Aluminum Can
    Material[] aluminumCanMaterialArray = {aluminum};
    int[] aluminumCanMaterialcountArray = {1};
    Item aluminumCan   = new Item("Aluminum_Can", aluminumCanMaterialArray, aluminumCanMaterialcountArray, 0);    
// Axe
    Material[] axeMaterialArray = {iron, aluminum};
    int[] axeMaterialcountArray = {56, 6};
    Item axe           = new Item("Axe", axeMaterialArray, axeMaterialcountArray, 0);
// Cardboard Box
    Material[] cardboardBoxMaterialArray = {paper};
    int[] cardboardBoxMaterialCount = {1};
    Item cardboardBox  = new Item("Cardboard_Box", cardboardBoxMaterialArray, cardboardBoxMaterialCount, 0);
// Clothes
    Material[] clothesMaterialArray = {cloth};
    int[] clothesMaterialCount = {5};
    Item clothes       = new Item("Clothes", clothesMaterialArray, clothesMaterialCount, 0);
// Computer
    Material[] computerMaterialArray = {copper, plastic, aluminum, iron};
    int[] computerMaterialcountArray = {22, 34, 11, 45};
    Item computer      = new Item("Computer", computerMaterialArray, computerMaterialcountArray, 0);
// Glass Bottle
    Material[] glassBottleMaterialArray = {glass};
    int[] glassBottleMaterialCount = {4};
    Item glassBottle   = new Item("Glass_Bottle", glassBottleMaterialArray, glassBottleMaterialCount, 0);
// Iron Can
    Material[] ironCanMaterialArray = {iron};
    int[] ironCanMaterialcountArray = {1};
    Item ironCan       = new Item("Iron_Can", ironCanMaterialArray, ironCanMaterialcountArray, 0); 
// Organic Waste
    Material[] organicWasteMaterialArray = {compost};
    int[] organicWasteMaterialCount = {10};
    Item organicWaste  = new Item("Organic_Waste", organicWasteMaterialArray, organicWasteMaterialCount, 0);
// Plastic Bottle
    Material[] plasticBottleMaterialArray = {plastic};
    int[] plasticBottleMaterialCount = {1};
    Item plasticBottle = new Item("Plastic_Bottle", plasticBottleMaterialArray, plasticBottleMaterialCount, 0);
// Tire
    Material[] tireMaterialArray = {rubber, iron};
    int[] tireMaterialcountArray = {160, 40};
    Item tire          = new Item("Tire", tireMaterialArray, tireMaterialcountArray, 0);

    
// An array is created, which contains one of each material. it is used to print the materials.
    Material[] materialArray = {aluminum, cloth, compost, concrete, copper, glass, iron, paper, oakWood, plastic, rubber}; 
    
// An array is created, which contains one of each item. it is used to print the items.    
    Item[] itemsArray = {aluminumCan, axe, cardboardBox, clothes, computer, glassBottle, ironCan, organicWaste, plasticBottle, tire};
 
    
// This method is called when creating a new inventory in the class Game. 
    public Inventory(){
        updateInventory();
    }
    
   
/* 
 * The method updateInventory() is used to update the money value and the carry value.
 * The method is called whenever an item is removed or placed in the inventory
 */  
  public void updateInventory() {
        double temp = 0;         // The first temporary variable is used to calculate the amount of weight the player is carrying.
        double temp2 = 0;        // The second temporary variable is used to calculate the total material value the player is carrying.
      
  // This for loop loops through the item array and takes the weight value and multiplies it with the item count value.      
      for (int i = 0; i < itemsArray.length; i++){                
            temp += itemsArray[i].weight*itemsArray[i].count;
        }
 // This for loop loops through the material array and takes the value of each material and multiplies it with the material count value.
      for (int j = 0; j < materialArray.length; j++){
            temp2 += materialArray[j].value*materialArray[j].count;
        }
        carrying = temp;
        money = temp2;
        
    }

    
/* 
 * This method is called when the user search command is used.
 * The method prints out a table of the names, count and weight of all the items in the current room.
 */
    public void searchForItems(Room currentRoom){
        System.out.println("┌------------------┬-----------┬-----------┐");
        System.out.println("│   ITEMS IN ROOM  │    COUNT  │   WEIGHT  │");
        
 // The for loop loops through the itemsArray[] and if the count value of an item in the current room is above 0, the item iss printed.        for (int i = 0; i < itemsArray.length; i++){                
            if (currentRoom.getItemsInRoom()[i] > 0){
                System.out.println("├------------------┼-----------┼-----------┤");
                System.out.print("│  ");
                System.out.printf("%14s", itemsArray[i].name);
                System.out.print("  │  ");
                System.out.printf("%7d", currentRoom.getItemsInRoom()[i]);
                System.out.print("  │  ");
                System.out.printf("%7.2f", itemsArray[i].weight);
                System.out.println("  │");
            }
        }
        System.out.println("└------------------┴-----------┴-----------┘");
        System.out.println(" "); 
    }
    

/*
 * This method is called when the user pickup <itemName> command is used.
 * If you have enough room in your inventory, and the selected item is in the room you can pick it up.
 */
    public void pickUpItem(String itemName, Room currentRoom) {
        int index; //This is a temporary variable used to search through the currentRoom.getItemsInRoom()[] array.
        updateInventory();
        //We find the index number for the item entered with the command.
        for (int i = 0; i < itemsArray.length; i++) {
            //We check if the name is valid with the item with the index
            if (itemsArray[i].name.equals(itemName)) {
                index = i;  //Saves the index if the name is valid
                //Checks if there is any items to pick up?
                if (currentRoom.getItemsInRoom()[index] > 0) {
                    if (currentRoom.getItemsInRoom()[index] + carrying < carryingCapacity) {
                        itemsArray[index].count++;  //Adds the item to your inventory
                        currentRoom.getItemsInRoom()[index]--; //Removes one item from the room.
                        System.out.println("You picked up " + itemsArray[index].name);
                        updateInventory();
                        return;
                    } else {
                        System.out.println("You can't carry anymore.");
                    }
                } else {
                    System.out.println("You can't pick up that item.");
                    System.out.println(" "); 
                }
            }
        }
        System.out.println("We can't indentify the item name...");
        System.out.println(" "); 
    }


/*
 * This method is called when the user drop <itemName> command is used.
 * If you have the selected item in your inventory you can drop it and it gets added to the rooms currentRoom.getItemsInRoom()[] array.
 */
    public void dropItem(String itemName, Room currentRoom) {
        int index;
        updateInventory();
        //We find the index number for the item entered with the command.
        for (int i = 0; i < itemsArray.length; i++) {
            //Checks if the name is valid
            if (itemsArray[i].name.equals(itemName)) {
                index = i;  //Saves the index
                //Checks if there is an items in the inventory to drop
                if (itemsArray[index].count > 0) {
                    itemsArray[index].count--;  //Removes the item to your inventory
                    currentRoom.getItemsInRoom()[index]++; //Adds the item to the room.
                    System.out.println("You dropped " + itemsArray[index].name);
                    updateInventory();
                    return;
                } else {
                    System.out.println("You don't have that item on you.");
                    System.out.println(" "); 
                }
            }
        }
        System.out.println("We can't indentify the item name...");
        System.out.println(" "); 
    }
    
    
/* 
 * This method is called when the user print items command is used.    
 * This loop prints all the items the player has (If the player has 0 of an item, it isn't printed).
 */
    public void printItems() {
        System.out.println("┌------------------┬-----------┬-----------┐");
        System.out.println("│            ITEM  │    COUNT  │   WEIGHT  │");
        for (int i = 0; i < itemsArray.length; i++){
            if (itemsArray[i].count > 0){
                System.out.println("├------------------┼-----------┼-----------┤");
                System.out.print("│  ");
                System.out.printf("%14s", itemsArray[i].name);
                System.out.print("  │  ");
                System.out.printf("%7d", itemsArray[i].count);
                System.out.print("  │  ");
                System.out.printf("%7.2f", itemsArray[i].weight*itemsArray[i].count);
                System.out.println("  │");
            }
        }
        System.out.println("└------------------┴-----------┴-----------┘");
        System.out.println(" ");
        System.out.println("┌-------------┬------------┬------------┐");
        System.out.println("│    MONEY    │  CARRYING  │  CAPACITY  │");
        System.out.println("├-------------┼------------┼------------┤");
        System.out.print("│  ");
        System.out.printf("%9.2f", money);
        System.out.print("  │  ");
        System.out.printf("%8.2f", carrying);
        System.out.print("  │  ");
        System.out.printf("%8d", carryingCapacity);
        System.out.println("  │");
        System.out.println("└-------------┴------------┴------------┘");
        System.out.println(" "); 
        }
    

/*
 * This method is called when the user print materials command is used.
 * This loop prints all the materials the player has (even if the player has 0 of a material).
 */
    public void printMaterials(){
        System.out.println("┌------------┬-----------┬-------------┬-------------┐");
        System.out.println("│  MATERIAL  │   COUNT   │    WEIGHT   │    VALUE    │");
        
        for (int i = 0; i < materialArray.length; i++){
            if (materialArray[i].count > 0) {
                System.out.println("├------------┼-----------┼-------------┼-------------┤");
                  System.out.print("│  ");
                  System.out.print(materialArray[i].name);
                System.out.print("  │  ");
                System.out.printf("%7d", materialArray[i].count);
                System.out.print("  │  ");
                System.out.printf("%9.2f", materialArray[i].weight*materialArray[i].count);
                System.out.print("  │  ");
                System.out.printf("%9.2f", materialArray[i].value*materialArray[i].count);
                System.out.println("  │");
            }
        }
        System.out.println("└------------┴-----------┴-------------┴-------------┘");
        System.out.println(" ");
    }


/*
 * This method is called when the user salvage <itemName> command is used.
 * The selected item is removed from the inventory and the materials the item consists of is added to the inventory.
 */
    public void salvageMaterials(String itemName){
        int index;
        updateInventory();
        //We find the index number for the item entered with the command.
        for (int i = 0; i < itemsArray.length; i++) {
            //Checks if the name is valid
            if (itemsArray[i].name.equals(itemName)) {
                index = i;  //Saves the index
                //Checks if there is an items in the inventory to drop
                if (itemsArray[index].count > 0) {
                    for (int j = 0; j < itemsArray[index].materials.length; j++){
                        itemsArray[index].materials[j].count += itemsArray[index].materialCount[j];
                    }
                    itemsArray[index].count--;  //Removes the item to your inventory
                    System.out.println("You salvaged materials from: " + itemsArray[index].name);
                    
                    updateInventory();
                    return;
                } else {
                    System.out.println("You don't have that item on you.");
                    System.out.println(" "); 
                }
            }
        }
        System.out.println("We can't indentify the item name...");
        System.out.println(" "); 
    } 
    
}
