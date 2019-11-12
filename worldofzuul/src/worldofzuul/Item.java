package worldofzuul;
/*
 * This class createss our objekt/datatype item.
 * Item consists of a name in form of a string,
 * a list of materials in form of a material array,
 * the amount(count) of each materials in form of an integer array,
 * the amount(count) of the item
 * and the weight of the item in form of a double. 
 */
public class Item {
    String name;
    Material[] materials = new Material[10];
    int[] materialCount = new int[10];
    int count;
    double weight;
    int temp = 0;   // This is a temporary variable used to calculate the weight.

    public Item(String name, Material[] materials, int[] materialCount, int count){
        
        this.name = name;
        this.materials = materials;
        this.materialCount = materialCount;
        this.count = count;
        // We take each value from the integer array materialCount and add them together one at a time. 
        for (int j = 0; j < materialCount.length; j++){
             temp += materialCount[j];
        }
        weight = temp*0.1;
    }
}
