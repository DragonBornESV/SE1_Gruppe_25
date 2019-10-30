package worldofzuul;

public class Inventory {
    
    public int pickUpItem = 3;
    
    public int computer = 3;
    public int axe = 1;
    public int hammer = 1;
    
    public int iron = 5;
    public int plastic = 5;
    public int aluminum = 5;
    public int copper = 5;
    public int rubber = 5;
    public int paper = 5;
    public int cloth = 5;
    public int glass = 5;
    public int compost = 5;
    public int concrete = 5;
    
    public Inventory(){
        updateInventory();
        printInventory();
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
        
    public void printInventory() {
        System.out.println("┌-------------┬-----------┐");
        System.out.println("│ ITEM        │  COUNT    │");
        
        if (computer > 0){
            System.out.println("├-------------┼-----------┤");
            System.out.println("│  Computer   │  " + computer + "  │");
        }
        if (axe > 0){
            System.out.println("├-------------┼-----------┤");
            System.out.println("│  Axe        │  " + axe + "  │");
        }
        if (hammer > 0) {
            System.out.println("├-------------┼-----------┤");
            System.out.println("│  Hammer     │  " + hammer + "  │");
        }
        
        System.out.println("└-------------┴-----------┘");
        
    }
    
}
