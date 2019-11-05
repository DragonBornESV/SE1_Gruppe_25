package worldofzuul;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    public static String name;

    public Game() 
    {
        parser = new Parser();
    }


    private void createRooms()
    {
        
        //Setting up the NPC for the outside room
        String[] responses1 = new String[]{
                "Det er lort!", 
                
                "Det er godt"};
        
        int[] responsePoints1 = new int[]{30,30};
        Say dialog1 = new Say("Hvad er bæredygtighed?", responses1, responsePoints1, parser);
        
        String[] responses2 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        
        int[] responsePoints2 = new int[]{30,0};
        Say dialog2 = new Say("Ok, men hvad skal jeg gøre for at hjælpe til?"
                + "", responses2, responsePoints2, parser);
        
        //We take all the dialog and use when calling the constructor of the 
        //NPC class. 
        NPC npc = new NPC("the bus driver",new Say[]{dialog1,dialog2},"Arh, ved du hvad " + Game.name + "? Jeg tror jeg"
                + " prøver det der!");
        
        
        Room office, street1, street2, street3, street4, corner1, corner2, 
                corner3, corner4, library, busStation, bank, gasStation, house, 
                school, supermarket, clothingStore, oldDecayingBuilding, park, 
                hospital, recyclingStation;
        
        /** Rooms are created and named.
         *  Rooms are assigned an intro which describes where the player are at.
         *  Rooms are also assigned an exit command.
         */
        
        office = new Room("welcome to the Mayers Office! This building is the center of the city and where you start", npc);
        street1 = new Room("standing on North Street. Infront of you are the library and behind you are the Mayers office");
        street2 = new Room("standing on East Street outside the eastside entrance of the Mayers office. To your right are the gas station");
        street3 = new Room("standing on South Street outside the main entrance of the Mayers office. Infront you are the supermarket");
        street4 = new Room("standing on West Street outside the westside entrance of the Mayers office. To your left are the park");
        corner1 = new Room("standing on the northeast corner. Infront of you are the bus station and to your right are the bank");
        corner2 = new Room("standing on the southeast corner. To your right are your house and behind you are the school");
        corner3 = new Room("standing on the southwest corner. Behind you are the clothing store and to your left are the old decaying building");
        corner4 = new Room("standing on the northwest corner. To your left are the hospital and infront of you are the recycling station");
        library = new Room("in the library");
        busStation = new Room("at the bus station");
        bank = new Room("in the bank");
        gasStation = new Room("at the gas station");
        house = new Room("in your house");
        school = new Room("in the school");
        supermarket = new Room("in the supermarket");
        clothingStore = new Room("in the clothing store");
        oldDecayingBuilding = new Room("in an old decaying building");
        park = new Room("in the park");
        hospital = new Room("in the hospital");
        recyclingStation = new Room("at the recycling station");
        
        office.setExit("east", street2);
        office.setExit("south", street3);
        office.setExit("west", street4);
        
        street1.setExit("north", library);
        street1.setExit("east", corner1);
        street1.setExit("west", corner4);
        
        corner1.setExit("north", busStation);
        corner1.setExit("east", bank);
        corner1.setExit("south", street2);
        corner1.setExit("west", street1);
        
        street2.setExit("north", corner1);
        street2.setExit("east", gasStation);
        street2.setExit("south", corner2);
        street2.setExit("west", office);
        
        corner2.setExit("north", street2);
        corner2.setExit("east", house);
        corner2.setExit("south", school);
        corner2.setExit("west", street3);
        
        street3.setExit("north", office);
        street3.setExit("east", corner2);
        street3.setExit("south", supermarket);
        street3.setExit("west", corner3);
        
        corner3.setExit("north", street4);
        corner3.setExit("east", street3);
        corner3.setExit("south", clothingStore);
        corner3.setExit("west", oldDecayingBuilding);
        
        street4.setExit("north", corner4);
        street4.setExit("east", office);
        street4.setExit("south", corner3);
        street4.setExit("west", park);
        
        corner4.setExit("north", recyclingStation);
        corner4.setExit("east", street1);
        corner4.setExit("south", street4);
        corner4.setExit("west", hospital);
        
        library.setExit("south", street1);
        
        busStation.setExit("south", corner1);
        
        bank.setExit("west", corner1);
        
        gasStation.setExit("west", street2);
        
        house.setExit("west", corner2);
        
        school.setExit("north", corner2);
        
        supermarket.setExit("north", street3);
        
        clothingStore.setExit("north", corner3);
        
        oldDecayingBuilding.setExit("east", corner3);
        
        park.setExit("east", street4);
        
        hospital.setExit("east", corner4);
        
        recyclingStation.setExit("south",corner4);
        
        currentRoom = office;  
    }
    
    public void play() 
    {            
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Goodbye.");
    }
    
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the City of Sustainia!");
        System.out.println("Sustainia is a new, incredibly awesome adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println("Please enter your name by writing '" + CommandWord.NAME + "' + your name");
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        
        
        
        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean... try again!");
            return false;
        }
        
        //If the name command is entered.
        //This statement is placed before the others, so the player is restricted
        //until they enter their name.
        if (commandWord == CommandWord.NAME) {
            nameCharacter(command);
            return false;
        }
        
        //Stops the player from using the other commands before they have chosen
        //a name for the character.
        if (name == null) {
            System.out.println("You need to enter your name...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.TALK) {
            if (currentRoom.hasNPC()) {
                currentRoom.getNPC().runDialog(currentRoom.getNPC().npcName);
            } else {
                System.out.println("There is no one to talk to...");
            }
        }
        else if (commandWord == CommandWord.SAY) {
            System.out.println("You need to start a conversation with someone"
                    + " before you can say anything.\n"
                    + "If in doubt type '" + CommandWord.HELP + "'");
        }
        else if (commandWord == CommandWord.LEAVE) {
            System.out.println("This command is used to leave a conversation.");
            System.out.println("If you want to quit the game, use '" + CommandWord.QUIT + "'");
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void nameCharacter(Command command) {
        //Checks if the player doesn't have a name.
        if (name == null) {
            if (command.hasSecondWord()) {
                name = command.getSecondWord();
                System.out.println("Hello " + name);
                
                createRooms();
                
                System.out.println(currentRoom.getLongDescription());
            } else {
                System.out.println("Remember to enter your desired name as well...");
            }
        } else {    //If they already have a name.
            System.out.println("You have already named your character...");
            return;
        }
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around the streets of Sustainia.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}