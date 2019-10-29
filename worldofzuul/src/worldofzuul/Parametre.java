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
public class Parametre {
    private float score;
    private static ArrayList<Parametre> list = new ArrayList<>();
    
    public Parametre() {
    this.score = 0;
    list.add(this);
}
            
    public Parametre(float score){
        this.score = score;
        list.add(this);
    }
    
    public float getScore(){
        return this.score;
    }
    
    public void addScore(float add){
        this.score += add;
    }
    
    public void subScore(float sub){
        this.score -= sub;
    }
    
    public void progressBar(){
        
    }
    public void getAverage(){
        
    }
    public static void getMainScore(){ //viser progressbar for Main Score/Parameter (metoden ikke færdig endnu)
        float value = 0;
        
        for (Parametre score : list){
            value += score.getScore();
        }
        
        System.out.println(value/list.size());
    }
}
