package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private NPC npc;

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }
    
    public Room(String description, NPC npc) {
        this.description = description;
        this.npc = npc;
        exits = new HashMap<String, Room>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        String npcNotification = "";
        
        if (npc != null) {
            npcNotification = "You can talk to " + npc.getNpcName() + ".\n";
        }
        
        return "You are " + description + ".\n" + npcNotification + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public boolean hasNPC() {
        return npc != null; //Returns true if an address is assigned
    }
    
    /**
     * A get method for the npc
     * @return The address assigned to the npc attribute. If none is assigned
     * null is returned.
     */
    public NPC getNPC() {
        return npc;
    }
}

