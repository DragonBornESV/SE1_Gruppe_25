package worldofzuul;

public class Worldofzuul {

    public static void main(String[] args) {
        Game run = new Game();
        
        String[] s = new String[]{  "Godt klaret!", 
                                    "Prøv igen"};
        int[] i = new int[]{100,20};
        
        Say dialog1 = new Say("Hej", s, i);
        //Say dialog2 = new Say("Hej", s, i);
        
        new NPC(new Say[]{dialog1},"Succes!!").runDialog();
        
        }
    
    }
