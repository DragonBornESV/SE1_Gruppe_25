package worldofzuul;

public class Items {
    private String name;
    Material[] materials = new Material[10];

    public Items(String name, Material[] materials){
        
        this.name = name;
        this.materials = materials;
        
        Material iron     = new Material("Iron",     3.80,  1);
        Material plastic  = new Material("Plastic" , 21.00, 1);
        Material aluminum = new Material("Aluminum", 8.10,  1);
        Material copper   = new Material("Copper",   35.00, 1);
        Material pubber   = new Material("Rubber",   10.00, 1);
        Material paper    = new Material("Paper",    17.50, 1);
        Material cloth    = new Material("Cloth",    35.00, 1);
        Material glass    = new Material("Glass",    0.60,  1);
        Material compost  = new Material("Compost",  3.73,  1);
        Material concrete = new Material("Concrete", 24.21, 1);
        
//        Material[] axeMaterials = new Material[]{new Material("Concrete", 24.21, 1), new Material("Concrete", 24.21, 1)};
//        Item axe = new Item("Axe",axeMaterials);
        
                
    }
   
}
