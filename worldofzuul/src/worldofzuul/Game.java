package worldofzuul;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        

    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room office, street1, street2, street3, street4, corner1, corner2, 
                corner3, corner4, library, busStation, bank, gasStation, house, 
                school, supermarket, clothingStore, oldDecayingBuilding, park, 
                hospital, recyclingStation;
        
        office = new Room("Welcome to the Mayers Office!");
        street1 = new Room("you are outside the main entrance of the Mayers Office. Infront of you are the library.");
        street2 = new Room("you are outside the side entrance of the Mayers Office. Infront of you are the gas station.");
        street3 = new Room("you are outside the back entrance of the Mayers Office. Infront of you are the supermarket.");
        street4 = new Room("you are outside the side entrance of the Mayers Office. Infront of you are the park");
        corner1 = new Room("you are standing by the bus station and the bank.");
        corner2 = new Room("you are standing by the house and the school.");
        corner3 = new Room("you are standing by the clothing store and the old decaying building.");
        corner4 = new Room("you are standing by the bus station and the bank.");
        library = new Room("in the library.");
        busStation = new Room("at the bus station.");
        bank = new Room("in the bank.");
        gasStation = new Room("at the gas station.");
        house = new Room("in the house.");
        school = new Room("in school.");
        supermarket = new Room("in the supermarket.");
        clothingStore = new Room("in a clothing store.");
        oldDecayingBuilding = new Room("in an old building.");
        park = new Room("in the park.");
        hospital = new Room("in the hospital.");
        recyclingStation = new Room("on the recycling station.");
        
        Office.setExit("north", street1);
        Office.setExit("east", street2);
        Office.setExit("south", street3);
        Office.setExit("west", street4);
        
        street1.setExit("north", library);
        street1.setExit("east", corner1);
        street1.setExit("south", office);
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
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the City of Sustainia!");
        System.out.println("Sustainia is a new, incredibly awesome adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean... try again");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
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
