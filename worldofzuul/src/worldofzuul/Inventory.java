package worldofzuul;

public class Inventory {
    

 
//Here the materials are constructed. In the following order given a name, value, weight and quantity.
 
    Material aluminum = new Material("Aluminum ", 0.81, 0.1, 1);
    Material cloth    = new Material("Cloth    ", 2.10, 0.1, 1);
    Material compost  = new Material("Compost  ", 0.37, 0.1, 1);
    Material concrete = new Material("Concrete ", 2.42, 0.1, 1);
    Material copper   = new Material("Copper   ", 3.50, 0.1, 1);
    Material glass    = new Material("Glass    ", 0.60, 0.1, 1);
    Material iron     = new Material("Iron     ", 0.38, 0.1, 1);
    Material oakWood  = new Material("Oak Wood ", 2.70, 0.1, 1);
    Material paper    = new Material("Paper    ", 1.75, 0.1, 1);
    Material plastic  = new Material("Plastic  ", 2.10, 0.1, 1);
    Material rubber   = new Material("Rubber   ", 1.00, 0.1, 1);
    
// An array is created, which contains one of each material. it is used to print the materials.
    Material[] materialArray = {aluminum, cloth, compost, concrete, copper, glass, iron, paper, plastic, rubber}; 
    
    
    Material[] computerMaterialArray = {copper, plastic, aluminum, iron};
    int[] computerMaterialcountArray = {22, 34, 11, 45};
    Item computer = new Item("Computer ", computerMaterialArray, computerMaterialcountArray, 1);
    
    Material[] axeMaterialArray = {iron, aluminum};
    int[] axeMaterialcountArray = {56, 6};
    Item axe = new Item("Axe ", axeMaterialArray, axeMaterialcountArray, 1);
    
    
    
    public int hammer = 1;
    
    
    public int pickUpItem = 3;
    
    public Inventory(){
        updateInventory();
        printItems();
        printMaterials();
    }
    
    public void updateInventory() {
        if (pickUpItem == 1) {
            System.out.println("Pick Up");
        } else if (pickUpItem == 2) {
            System.out.println("Put away");
        } else {
            System.out.println("do nothing");
        }
    }
        
    public void printItems() {
        System.out.println("┌-------------┬-----------┐");
        System.out.println("│  ITEM       │    COUNT  │");
        
        if (computer > 0){
            System.out.println("├-------------┼-----------┤");
            System.out.print("│  Computer   │  ");
                    
            System.out.printf("%7d", computer);
            System.out.println("  │");
        }
        if (axe > 0){
            System.out.println("├-------------┼-----------┤");
            System.out.print("│  Axe        │  ");
            System.out.printf("%7d", axe);
            System.out.println("  │");
        }
        if (hammer > 0) {
            System.out.println("├-------------┼-----------┤");
            System.out.print("│  Hammer     │  ");
            System.out.printf("%7d", hammer);
            System.out.println("  │");
        }
        System.out.println("└-------------┴-----------┘");
        System.out.println(" ");
        }
    
    public void printMaterials(){
        System.out.println("┌-------------┬-----------┐");
        System.out.println("│  MATERIAL   │    COUNT  │");
        
        for (int i = 0; i < 10; i++){
       
            if (materialArray[i].count > 0) {
                System.out.println("├-------------┼-----------┤");
                  System.out.print("│  ");
                  System.out.print(materialArray[i].name);
                System.out.print("  │  ");
                System.out.printf("%7d", materialArray[i].count);
                System.out.println("  │");
            }
        }

        System.out.println("└-------------┴-----------┘");
        System.out.println(" ");
    }
    
}
