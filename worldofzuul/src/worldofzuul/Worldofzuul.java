package worldofzuul;

public class Worldofzuul {

    public static void main(String[] args) {
        Game run = new Game();
        
        run.play();
        
        String[] s = new String[]{  "Det er lort!", 
                                    "Det er godt"};
        int[] i = new int[]{100,20};
        
        Say dialog1 = new Say("Hvad er bæredygtighed?", s, i);
        Say dialog2 = new Say("Hej", s, i);
        
        new NPC(new Say[]{dialog1,dialog2},"Arh, ved du hvad? Jeg tror jeg"
                + " prøver det der!").runDialog();
        
        }
    
    }
