package worldofzuul;

public class Inventory {
    
    public int pickUpItem = 3;
    
    public int computer = 0;
    public int Axe = 0;
    public int hammer = 0;
    
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
    
}
