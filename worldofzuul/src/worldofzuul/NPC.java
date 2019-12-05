package worldofzuul;

/**This class keeps track of the dialog, how persuated the NPC is, where the
 * persuasion limit (trigger) lies and the final message that is shown when
 * reaching the persuasion limit.
 *
 */
public class NPC {
    private final Say[] dialog;
    private int persuasionValue = 0;
    private final int persuasionTrigger = 50;
    private final String endTriggerMessage;
    private boolean pointsGiven = false;
    
    private String parameterName;   //The name of the parameter this NPC effects.
    private int points;             //The points the parameter change with.
    
    private final String npcName;
    
    /**
     * 
     * 
     * @param npcName The name of the NPC.
     * @param dialog the instances of the Say class that dictates the content of the conversation.
     * @param endTriggerMessage the end message if the person is persuated.
     * @param parameterName the parameter you want to adjust.
     * @param points the points you want to adjust the parameter with.
     */
    public NPC (String npcName, Say[] dialog, String endTriggerMessage, 
            String parameterName, int points) {
        this.npcName = npcName;
        this.dialog = dialog;
        this.endTriggerMessage = endTriggerMessage;
        this.parameterName = parameterName;
        this.points = points;
    }
    
    public NPC (String npcName, Say[] dialog, String endTriggerMessage) {
        this.npcName = npcName;
        this.dialog = dialog;
        this.endTriggerMessage = endTriggerMessage;
    }

    NPC(String the_factory_worker, Say[] say, String string, String city_Green_Energy, int i, String city_Clean_Water, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    NPC(String the_factory_worker, Say[] say, String string, String city_Green_Energy, int i, String city_Clean_Water, int i0, String city_Clean_Air, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            if (dialog[i].isWantToLeave() == true) {
                return;
            }
            
            //Checks if the limit value is reached. Breaks if true.
            if (persuasionValue >= persuasionTrigger) {
                break;
            }
        }
        
        //Checks if the player succeeded. If not a fail message is printed.
        if (persuasionValue < persuasionTrigger && !pointsGiven) {
            Parameter.mapAddScore(parameterName, -(points/2));
            System.out.println("You lost " + (points/2) + "% in '" + parameterName + "'!");
            System.out.println("");
            System.out.println("You failed to convince " + npcName + "...");
            System.out.println("Talk to the person again. "
                    + "Try to be more convincing this time...");
            System.out.println("");
            return;
        }
        
        //The succes message is printed out!
        //But only if they haven't given points yet and a parameter name is specified
        if (!pointsGiven && parameterName != null) {
            Parameter.mapAddScore(parameterName, points);
            pointsGiven = true;     //After this the player can't get anymore points from this npc.
            System.out.println("You've gained " + points + "% in '" + parameterName + "'!");
        }
        
        System.out.println("");
        System.out.println("---------------------------------");
        System.out.println("");
        System.out.println(endTriggerMessage);
        System.out.println("");
        
    }

    /**
     * @return the npcName
     */
    public String getNpcName() {
        return npcName;
    }
    
}
