package worldofzuul;

public class Inventory {
    
    double money = 0;
    double carrying = 0;
    int carryingCapacity = 100;
    int[] roomItems = new int[2];
    
    int[] currentRoomItems = {0,3};
    
//Here the materials are constructed. In the following order given a name, value, weight and quantity.
 
    Material aluminum = new Material("Aluminum", 0.81, 0.1, 1);
    Material cloth    = new Material("Cloth   ", 2.10, 0.1, 1);
    Material compost  = new Material("Compost ", 0.37, 0.1, 1);
    Material concrete = new Material("Concrete", 2.42, 0.1, 1);
    Material copper   = new Material("Copper  ", 3.50, 0.1, 1);
    Material glass    = new Material("Glass   ", 0.60, 0.1, 1);
    Material iron     = new Material("Iron    ", 0.38, 0.1, 1);
    Material oakWood  = new Material("Oak Wood", 2.70, 0.1, 1);
    Material paper    = new Material("Paper   ", 1.75, 0.1, 1);
    Material plastic  = new Material("Plastic ", 2.10, 0.1, 1);
    Material rubber   = new Material("Rubber  ", 1.00, 0.1, 1);
    

// Aluminum Can
    Material[] aluminumCanMaterialArray = {aluminum};
    int[] aluminumCanMaterialcountArray = {1};
    Item aluminumCan   = new Item("Aluminum Can ", aluminumCanMaterialArray, aluminumCanMaterialcountArray, 0);    
// Axe
    Material[] axeMaterialArray = {iron, aluminum};
    int[] axeMaterialcountArray = {56, 6};
    Item axe           = new Item("Axe          ", axeMaterialArray, axeMaterialcountArray, 0);
// Cardboard Box
    Material[] cardboardBoxMaterialArray = {paper};
    int[] cardboardBoxMaterialCount = {1};
    Item cardboardBox  = new Item("Cardboard Box", cardboardBoxMaterialArray, cardboardBoxMaterialCount, 0);
// Clothes
    Material[] clothesMaterialArray = {cloth};
    int[] clothesMaterialCount = {5};
    Item clothes       = new Item("Clothes      ", clothesMaterialArray, clothesMaterialCount, 0);
// Computer
    Material[] computerMaterialArray = {copper, plastic, aluminum, iron};
    int[] computerMaterialcountArray = {22, 34, 11, 45};
    Item computer      = new Item("Computer     ", computerMaterialArray, computerMaterialcountArray, 0);
// Glass Bottle
    Material[] glassBottleMaterialArray = {glass};
    int[] glassBottleMaterialCount = {4};
    Item glassBottle   = new Item("Glass Bottle ", glassBottleMaterialArray, glassBottleMaterialCount, 0);
// Iron Can
    Material[] ironCanMaterialArray = {iron};
    int[] ironCanMaterialcountArray = {1};
    Item ironCan       = new Item("Iron Can     ", ironCanMaterialArray, ironCanMaterialcountArray, 0); 
// Organic Waste
    Material[] organicWasteMaterialArray = {compost};
    int[] organicWasteMaterialCount = {10};
    Item organicWaste  = new Item("Organic Waste", organicWasteMaterialArray, organicWasteMaterialCount, 0);
// Plastic Bottle
    Material[] plasticBottleMaterialArray = {plastic};
    int[] plasticBottleMaterialCount = {1};
    Item plasticBottle = new Item("Plastic Bottle", plasticBottleMaterialArray, plasticBottleMaterialCount, 0);
// Tire
    Material[] tireMaterialArray = {rubber, iron};
    int[] tireMaterialcountArray = {160, 40};
    Item tire          = new Item("Tire           ", tireMaterialArray, tireMaterialcountArray, 0);

    

// An array is created, which contains one of each material. it is used to print the materials.
    Material[] materialArray = {aluminum, cloth, compost, concrete, copper, glass, iron, paper, oakWood, plastic, rubber}; 
    
    Item[] itemsArray = {aluminumCan, axe, cardboardBox, clothes, computer, glassBottle, ironCan, organicWaste, plasticBottle, tire};
    
    int pickUpItem = 3;
    
    
    public Inventory(){
        updateInventory();
    }
    
   
// 
    public void updateInventory() {
        roomItems = currentRoomItems;
        double temp = 0;
        double temp2 = 0;
        for (int i = 0; i < itemsArray.length; i++){
            temp += itemsArray[i].weight*itemsArray[i].count;
        }
        for (int j = 0; j < materialArray.length; j++){
            temp2 += materialArray[j].value*materialArray[j].count;
        }
        carrying = temp/10;
        money = temp2;
        if (pickUpItem == 1) {
            System.out.println("Pick Up");
        } else if (pickUpItem == 2) {
            System.out.println("Put away");
        } else {
            System.out.println("do nothing");
        }
    }
    
    
    //public void pickUpItem() {
        
   // }
    
    
// This loop prints all the items the player has (If the player has 0 of an item, it isn't printed).    
    public void printItems() {
        System.out.println("┌------------------┬-----------┬-----------┐");
        System.out.println("│  ITEM            │    COUNT  │   WEIGHT  │");
        for (int i = 0; i < itemsArray.length; i++){
            if (itemsArray[i].count > 0){
                System.out.println("├------------------┼-----------┼-----------┤");
                System.out.print("│  ");
                System.out.print(itemsArray[i].name);
                System.out.print("  │  ");
                System.out.printf("%7d", itemsArray[i].count);
                System.out.print("  │  ");
                System.out.printf("%7.2f", itemsArray[i].weight*itemsArray[i].count/10);
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
    
    // This loop prints all the materials the player has (even if the player has 0 of a material).
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
    //public void 
    
}
