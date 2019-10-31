package worldofzuul;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        

    public Game() 
    {
        parser = new Parser();
        createRooms();
    }


    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;
        
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
        NPC npc = new NPC(new Say[]{dialog1,dialog2},"Arh, ved du hvad? Jeg tror jeg"
                + " prøver det der!");
        
        outside = new Room("outside the main entrance of the university", npc);
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;
    }

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
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
                currentRoom.getNPC().runDialog();
            } else {
                System.out.println("There is no one to talk to...");
            }
        }
        else if (commandWord == CommandWord.SAY) {
            System.out.println("You need to start a conversation with someone"
                    + " before you can say anything.\n"
                    + "If in doubt type 'help'");
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
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
