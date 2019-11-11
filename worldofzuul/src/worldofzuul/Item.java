package worldofzuul;

public class Item {
    String name;
    Material[] materials = new Material[10];
    int[] materialCount = new int[10];
    int count;
    double weight;
    int temp = 0; 

    public Item(String name, Material[] materials, int[] materialCount, int count){
        
        this.name = name;
        this.materials = materials;
        this.materialCount = materialCount;
        this.count = count;
        for (int j = 0; j < materialCount.length; j++){
             temp += materialCount[j];
        }
        weight = temp/10;
    }
}