package worldofzuul;

public class Worldofzuul {
    /* Startpunkt*/
    public static void main(String[] args) {
        Game run = new Game();
        Parameter.createParameters();
        Parameter.printScore();
        Parameter.mapAddScore("City Equality", 10);
        Parameter.mapAddScore("City Security", -10);
        Parameter.printScore();
        //run.play();

    }
    
}
