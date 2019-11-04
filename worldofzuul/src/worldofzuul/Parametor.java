/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.ArrayList;

/**
 *
 * @author Thang og Thao
 */
public class Parametor {
    private String name;
    private float score;
    private static ArrayList<Parametor> list = new ArrayList<>();
    private float attempts;
    private float average;
    
    public Parametor(String name) {
    this.name = name;
    this.attempts = 100;
    this.score = 20;
    this.average = (score/attempts)*100;
    list.add(this);
}
            
    public Parametor(float score){
        this.score = score;
        list.add(this);
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
    
    public void subScore(float sub){
        this.score -= sub;
        this.average = (score/attempts)*100;
    }
    
    public void getPercentage(){
        System.out.println(this.average);
    }
    
    public String progressBar(){ 
        //laver progress som en sout der printer noget
        //lignende "(===    )" for at vise progress. Kan derefter kaldes fra getMainScore.
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
    public void printScore(){ //viser progressbar for Main Score/Parameter
        float value = 0;
        
        for (Parametor score : list){
            System.out.println("");
            System.out.println(score.getName()+ " | "+score.progressBar()+ " " + score.getAverage() + "%");
        }
        
        for (Parametor score : list){
            value += score.getAverage();
        }
        
        float main = value/list.size();
        Parametor mainScore = new Parametor("main");
        list.remove(mainScore);
        mainScore.subScore(20);
        mainScore.addScore(main);
         System.out.println(mainScore.getName()+ " | "+mainScore.progressBar()+ " " + mainScore.getAverage() + "%");  
//      
    }
}
