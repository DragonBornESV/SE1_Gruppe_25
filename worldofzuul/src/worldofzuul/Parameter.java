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
    
    public static void mapAddScore(String name, float add){
        Parameter p = parameterList.get(name);
        p.addScore(add);
        parameterList.put(name, p);
        
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
    
    public float getAverage(){
        return (this.score/this.attempts)*100;      
    }
    
    public void setAverage(float average){
        this.average = average;
    }
    
    /**
    * Prints out the score to the console and uses progressBar() to illustrate.
    * printScore() also creates a mainScore object to show the main score of the game.
    */
    public static void printScore(){ //viser progressbar for Main Score/Parameter
        float value = 0;
        System.out.println("|-------------------------------------------------|");
        
        for (Map.Entry<String, Parameter> entry : parameterList.entrySet()){
            System.out.println(entry.getKey() + ":   \t\t" + entry.getValue().progressBar() + " " + Math.round(entry.getValue().getAverage()) + "%");
        }
        
        for (Map.Entry<String, Parameter> entry : parameterList.entrySet()){
            value += entry.getValue().getAverage();
        }
        
        System.out.println("|-------------------------------------------------|");
        float main = value/7;
        Parameter mainScore = new Parameter();
        mainScore.setAverage(main);
        System.out.println(mainScore.getName() + ":\t\t" + mainScore.progressBar() + " " + Math.round(main) + "%");
    }
}
