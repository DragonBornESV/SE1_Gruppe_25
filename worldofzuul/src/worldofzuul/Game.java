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
        
        office = new Room("welcome to the Mayers Office! This building is the center of the city and where you start");
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
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean... try again!");
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
