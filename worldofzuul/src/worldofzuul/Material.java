package worldofzuul;

public class Material {
    String name = "Name";
    double value = 0;
    double weight = 0.1;
    int count;
    
    public Material(String matName, double matValue, double matWeight, int count){
        name = matName;
        value = matValue;
        weight = matWeight;
        this.count = count;
    }
    
}
