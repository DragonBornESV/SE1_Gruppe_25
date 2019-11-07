package worldofzuul;

import java.util.HashMap;
import java.util.Map;

/** This class contains the logic and output of the parameters that the game uses 
 * to value progress in during the game.
 *
 * The class uses parameters as objects and uses methods to change these the values
 * of these objects to reflect the score of the game.
 */

/**
 *
 * @author Thang og Thao
 */

public class Parameter {
    private String name;
    private float score;
    public static Map<String, Parameter> parameterList = new HashMap<>();
    private float attempts;
    private float average;
    public static Parameter mainScore = new Parameter();
    
    /**
     * 
     * @param name      The name of the parameter to value the game.
     * attempts  The number of attempts that the user has taken.
     * score     The score that the user is valued from, and base value is set to 20.
     * average   The score converted to percentage as an average to display the score.
     */
    
    public Parameter(String name) {
    this.name = name;
    this.attempts = 100;
    this.score = 20;
    this.average = (score/attempts)*100;
    parameterList.put(this.name, this);
    }
    public Parameter(){
        this.name = "City Sustainability";
        this.average = 0;
        
    }
    public String getName(){
        return this.name;
    }
    
    public float getScore(){
        return this.score;
    }
    
    public void addScore(float add){
        this.score += add;
        this.average = (score/attempts)*100;
    }
    
    
    public static void createParameters(){
        Parameter p1 = new Parameter("City Equality");
        Parameter p2 = new Parameter("City Green Energy");
        Parameter p3 = new Parameter("City Clean Water");
        Parameter p4 = new Parameter("Sustainable Housing");
        Parameter p5 = new Parameter("City Clean Air");
        Parameter p6 = new Parameter("City Cleanliness");
        Parameter p7 = new Parameter("City Security");
    }
    
    /**
     * How to add score to a specific parameter, and checking if it's a null value.
     * 
     * @param name Name of parameter to add score value to.
     * @param add Score value to add to the parameter.
     */
    public static void mapAddScore(String name, float add){
        if (name != null) {
            Parameter p = parameterList.get(name);
            p.addScore(add);
            p.attempts++;
            parameterList.put(name, p);
            
            if (parameterList.get(name).getScore() >= 100) {
                System.out.println("Congratulations you won the game!");
                Parameter.printScore();   
            }
        }
    }
    
    /**
     * Returns a string that can be printed out by another method to show progress 
     * in the console. Progress is shown by the bar per 10 percent and as the exact percentage later.
     */
    public String progressBar(){ 
        if (this.average < 10){
            return "[          ]";
        } else if (this.average <= 10) {
            return "[=         ]";
        } else if (this.average <=20) {
            return "[==        ]";
        } else if (this.average <= 30){
            return "[===       ]";
        } else if (this.average <= 40) {
            return "[====      ]";
        } else if (this.average <= 50) {
            return "[=====     ]";
        } else if (this.average <= 60) {
            return "[======    ]";
        } else if (this.average <= 70) {
            return "[=======   ]";
        } else if (this.average <= 80) {
            return "[========  ]";
        } else if (this.average <= 90) {
            return "[========= ]";
        } else {
            return "[==========]";
        }
    }
    
    public float getMainAverage(){
        float value = 0;
        
        for (Map.Entry<String, Parameter> entry : parameterList.entrySet()){
            value += entry.getValue().getScore();
        }   
        
        return value/parameterList.size();
    }
    
    public float getAverage(){
        return (this.getScore()/this.attempts)*100;
    }
    
    /**
    * Prints out the score to the console and uses progressBar() to illustrate.
    * printScore() also creates a mainScore object to show the main score of the game.
    */
    public static void printScore(){ //viser progressbar for Main Score/Parameter
        System.out.println("|-------------------------------------------------|");
        
        for (Map.Entry<String, Parameter> entry : parameterList.entrySet()){
            System.out.println(entry.getKey() + ":   \t\t" + entry.getValue().progressBar() + " " + Math.round(entry.getValue().getAverage()) + "%");
        }
        
        System.out.println("|-------------------------------------------------|");
        System.out.println(mainScore.getName() + ":\t\t" + mainScore.progressBar() + " " + Math.round(mainScore.getMainAverage()) + "%");
    }
}
