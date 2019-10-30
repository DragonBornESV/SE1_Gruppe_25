package worldofzuul;

public class Inventory {
    
    public int pickUpItem = 3;
    
    public int computer = 6000;
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
        
        if (aluminum > 0) {
            System.out.println("├-------------┼-----------┤");
              System.out.print("│  Aluminum   │  ");
            System.out.printf("%7d", aluminum);
            System.out.println("  │");
        }  
        if (cloth > 0) {
            System.out.println("├-------------┼-----------┤");
              System.out.print("│  Cloth      │  ");
            System.out.printf("%7d", cloth);
            System.out.println("  │");
        }
        if (compost > 0) {
            System.out.println("├-------------┼-----------┤");
              System.out.print("│  Compost    │  ");
            System.out.printf("%7d", compost);
            System.out.println("  │");
        }
        if (concrete > 0) {
            System.out.println("├-------------┼-----------┤");
              System.out.print("│  Concrete   │  ");
            System.out.printf("%7d", concrete);
            System.out.println("  │");
        }
        if (copper > 0) {
            System.out.println("├-------------┼-----------┤");
              System.out.print("│  Copper     │  ");
            System.out.printf("%7d", copper);
            System.out.println("  │");
        }
        if (glass > 0) {
            System.out.println("├-------------┼-----------┤");
              System.out.print("│  Glass      │  ");
            System.out.printf("%7d", glass);
            System.out.println("  │");
        }
        if (iron > 0) {
            System.out.println("├-------------┼-----------┤");
              System.out.print("│  Iron       │  ");
            System.out.printf("%7d", iron);
            System.out.println("  │");
        }
        if (paper > 0) {
            System.out.println("├-------------┼-----------┤");
              System.out.print("│  Paper      │  ");
            System.out.printf("%7d", paper);
            System.out.println("  │");
        }
        if (plastic > 0) {
            System.out.println("├-------------┼-----------┤");
              System.out.print("│  Plastic    │  ");
            System.out.printf("%7d", plastic);
            System.out.println("  │");
        }
        if (rubber > 0) {
            System.out.println("├-------------┼-----------┤");
              System.out.print("│  Rubber     │  ");
            System.out.printf("%7d", rubber);
            System.out.println("  │");
        }
        System.out.println("└-------------┴-----------┘");
        System.out.println(" ");
    }
    
}
