package worldofzuul;

/**This class keeps track of the dialog, how persuated the NPC is, where the
 * persuasion limit (trigger) lies and the final message that is shown when
 * reaching the persuasion limit.
 *
 */
public class NPC {
    final Say[] dialog;
    int persuasionValue = 0;
    final int persuasionTrigger = 50;
    final String endTriggerMessage;
    
    final String npcName;
    
    public NPC (String npcName, Say[] dialog, String endTriggerMessage) {
        this.npcName = npcName;
        this.dialog = dialog;
        this.endTriggerMessage = endTriggerMessage;
    }
    
    /**Initiates the dialog with the NPC.
     * 
     * The dialog is retrieved from the Say-array and runs through them, one by
     * one. Every iteration it returns the points given and adds them to the
     * persuasionValue attribute. It then checks if the limit (trigger) is
     * reached. If not and there is not anymore dialog, you get a fail message
     * and the dialog ends.
     * 
     */
    public void runDialog(String npcName) {
        //Iterates through the Say objects and runs the print method. The points 
        //are added as it goes along. 
        for (int i = 0; i < dialog.length; i++) {
            persuasionValue += dialog[i].print(npcName);
            
            //Checks if the player wants to leave the conversation
            if (dialog[i].wantToLeave == true) {
                return;
            }
            
            //Checks if the limit value is reached. Breaks if true.
            if (persuasionValue >= persuasionTrigger) {
                break;
            }
        }
        
        //Checks if the player succeeded. If not a fail message is printed.
        if (persuasionValue < persuasionTrigger) {
            System.out.println("");
            System.out.println("You failed to convince " + npcName + "...");
            System.out.println("The person walked away");
            System.out.println("");
            return;
        }
        
        //The succes message is printes out!
        //INDSÆT KODE TIL AT INKREMENTERE PARAMETERVÆRDIEN!
        System.out.println("");
        System.out.println("---------------------------------");
        System.out.println("");
        System.out.println(endTriggerMessage);
        System.out.println("");
        
    }
    
}
