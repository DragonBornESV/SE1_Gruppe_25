package worldofzuul;

import java.util.Arrays;
import java.util.Scanner;

/**This class contains dialog elements used by the NPC class. 
 * 
 * The class contains a message from the NPC, the available responses and the
 * different persuasion points given by each response. The class also handles
 * the printing of dialog and the choosing of responses.
 */
public class Say {
    String npcText;
    String[] responses;
    int[] persuasionPoints;
    
    
    /**The constructor for instantiating an instans of the Say class.
     * 
     * @param npcText           The initial message from the NPC.
     * @param responses         A string-array of available responses.
     * @param persuasionPoints  The points available, when choosing the responses above.
     */
    Say(String npcText, String[] responses, int[] persuasionPoints) {
        this.npcText = npcText;
        this.responses = responses;
        this.persuasionPoints = persuasionPoints;
    }
    
    /**Prints the message from the NPC and displays the available responses and
     * the corresponding numbers. It then prompts the player to choose an
     * response. It then returns the points gained from the response.
     * 
     * @return the points gained from the chosen response.
     */
    public int print() {
        
        //Prints the NPCs message
        System.out.println(npcText);
        
        //Prints the available responses and the corresponding numbers.
        for (int i = 0; i < responses.length; i++) {
            System.out.println("[" + (i+1) + "] " + responses[i]);
        }
        
        //Prints the prompt message
        System.out.println("Enter the corresponding number for your answer: ");
        
        //The player loops until they give a valid answer.
        while (true) {
            
            //An instans of the Scanner class is created an set to System.in
            Scanner number = new Scanner(System.in);
            System.out.print("> ");
            
            try {
                int input = number.nextInt() - 1;   //We substract one so it resembles an index
                
                if (input < persuasionPoints.length && input >= 0) {
                    //Returns1 because of a valid answer.
                    number.close();
                    return persuasionPoints[input];
                    
                } else {
                    System.out.println("Enter a valid number...");
                }
                
            } catch (java.util.InputMismatchException e) {
                System.out.println("Enter a number...");
                continue;
            }
            
            number.close();
        }
    }
}
