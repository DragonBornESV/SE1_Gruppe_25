package worldofzuul;

public class Game 
{
    private Parser parser;
    private Inventory inv;
    private Room currentRoom;
    boolean adTheRecyclingStation = true;
        

    public Game() 
    {
        createRooms();
        inv = new Inventory();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;
        
        int[] itemsOutside = new int[]{1,1,1,1,1,1,1,1,1,1};
        
        outside = new Room("outside the main entrance of the university",itemsOutside);
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
        System.out.println("  _________________________________________________________________________________________________________\n" +
" /  _____________________________________________________________________________________________________  \\\n" +
"/  /                                                                                                     \\  \\\n" +
"|  |         _______  __    __       ___________________   ___       __   __   __   __       ___         |  |\n" +
"|  |        /   ____||  |  |  |     /   ________    ____| /   \\     |  | |  \\ |  | |  |     /   \\        |  |\n" +
"|  |       |   (     |  |  |  |    |   (        |  |     /  ^  \\    |  | |   \\|  | |  |    /  ^  \\       |  |\n" +
"|  |        \\   \\    |  |  |  |     \\   \\       |  |    /  /_\\  \\   |  | |  . `  | |  |   /  /_\\  \\      |  |\n" +
"|  |     ____)   |   |  \\__/  |  ____)   |      |  |   /  _____  \\  |  | |  |\\   | |  |  /  _____  \\     |  |\n" +
"|  |    |_______/     \\______/  |_______/       |__|  /__/     \\__\\ |  | |__| \\__| |__| /__/     \\__\\    |  |\n" +
"|  |                                                               _|  |_                                |  |\n" +
"|  |                                                              |      |                               |  |\n" +
"|  |                                                              |      |                               |  |\n" +
"|  |                                                              |      |                               |  |\n" +
"|  |                                                              |      |                               |  |\n" +
"|  |                                                             _|      |_                              |  |\n" +
"|  |                                                            |          |                             |  |\n" +
"|  |                                                            |          |                             |  |\n" +
"|  |                                                 _          |          |                             |  |\n" +
"|  |                                                | |         |          |                             |  |\n" +
"|  |                                                | |  /|    _|          |_                            |  |\n" +
"|  |                                                | | / |   |              |                           |  |\n" +
"|  |                                                | |/  |   |              |    ___________            |  |\n" +
"|  |                                                |     |   |              |   |           |           |  |\n" +
"|  |                                                |     |   |              |   |           |           |  |\n" +
"|  |                                                /     |   |              |   |           |           |  |\n" +
"|  |                                               |      |   |              |   |           |           |  |\n" +
"|  |                                 __________    |      |  _|              |_  |           |           |  |\n" +
"|  |                                |          |   |      | |                  | |           |           |  |\n" +
"|  |                                |          |   |      | |                  | |           |           |  |\n" +
"|  |                               _|          |   |      | |                  | |           |  _______  |  |\n" +
"|  |                              |            |   |      | |                  | |           | |       | |  |\n" +
"|  |                              |            |   |      | |                  | |           | |       | |  |\n" +
"|  |                              |            |   |      | |                  | |           | |       | |  |\n" +
"|  |                  __________  |            |_  |      | |                  | |           | |       | |  |\n" +
"|  |                 |          | |              | |      | |                  | |           | |       | |  |\n" +
"|  |   ______________|          | |              | |      | |                  | |           | |       | |  |\n" +
"|  |  |                         | |              | |      | |                  | |           | |       | |  |\n" +
"|  |__|                         |_|              |_|      |_|                  |_|           |_|       |_|  |\n" +
"|                                                                                                           |\n" +
"|                                                                                                           |\n" +
"|                                                                                                           |\n" +
"|                                                                                                           |\n" +
"\\                                                                                                           /\n" +
" \\_________________________________________________________________________________________________________/");
        System.out.println(" ");
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
        else if (commandWord == CommandWord.PICKUP) {
            inv.pickUpItem(command.getSecondWord(), currentRoom);
        }
        else if (commandWord == CommandWord.DROP) {
            inv.dropItem(command.getSecondWord(), currentRoom);
        }
        else if (commandWord == CommandWord.SALVAGE) {
            if (adTheRecyclingStation){
                inv.salvageMaterials(command.getSecondWord());
            }else{
                System.out.println("To salvage, go to the recyclingstation");
            }
        }
        else if (commandWord == CommandWord.PRINT) {
            if ("items".equals(command.getSecondWord())) {
                inv.printItems();
            } 
            else if ("materials".equals(command.getSecondWord())) {
                inv.printMaterials();
            }
            else if ("map".equals(command.getSecondWord())){
                printMap();
            }else {
                System.out.println("Remember to type materials, items or "
                        + "parameters when using this command...");
            }  
        }
        else if(commandWord == CommandWord.SEARCH){
            inv.searchForItems(currentRoom);
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
    
    public void printMap(){
        System.out.println("                     _______________________     _______________________     _______________________\n" +
"                    |                       |   |                       |   |                       |\n" +
"                    |   Recycling Station   |   | Non-sustainable House |   |    Police Station     |\n" +
"                    |___   __               |   |                       |   |_________// \\\\_________|\n" +
"                    |   | |__|         /|\\  |   |_________ ___ _________|   |________//_*_\\\\________|\n" +
"                    |___| |__|        |/_\\| |   |   |__|  /,  \\  |__|   |   || || || ||   || || || ||\n" +
"                    |___|_____________|___|_|   |_________|___|_________|   ||_||_||_||___||_||_||_||\n" +
"                              |   |                       |   |                       |   |\n" +
" _____________       _________|___|_________     _________|___|_________     _________|___|_________     _______________\n" +
"|  _________  |     |_|_|_|_|_|_|_|_|_|_|_|_|   |_|_|_|_|_|_|_|_|_|_|_|_|   |_|BUS _|_|_|_|_|_|_|_|_|   |     _| |_     |\n" +
"| |         | |     |_|_|_|_|_|_|_|_|_|_|_|_|   |_|_|_|_|_|_|_|_|_|_|_|_|   |_|STOP_|_|_|_|_|_|_|_|_|   | B  /    _\\    |\n" +
"| | Hospital| |_    |_|_|                   |   |                       |   |                   |_|_|   | A | (| |_     |\n" +
"| |_________| | |___|_|_| North West Corner |___|      North Street     |___| North East Corner |_|_|___| N  \\_    \\    |\n" +
"|_____________| |   |_|_|        _  _  _  _ |   | _  _  _  _  _  _  _  _|   | _  _  _  _        |_|_|   | K  __| |) |   |\n" +
"|       _     | |___|_|_|       |           |___|                       |___|           |       |_|_|___|    \\_   _/    |\n" +
"|     _| |_   |_|   |_|_|                   |   |                       |   |                   |_|_|   |______|_|______|\n" +
"|    |_   _|    |   |_|_|       |        _ _|   |_ _ _ _ _ _ _ _ _ _ _ _|   |_ _        |       |_|_|   |    _______    |\n" +
"|      |_|      |   |_|_|               |_|_|   |_|_|_|_|_|_|_|_|_|_|_|_|   |_|_|               |_|_|   |   |_|_|_|_|   |\n" +
"|_______________|   |_|_|_______|_______|_|_|   |_|_|_|_|_|_|_|_|_|_|_|_|   |_|_|_______|_______|_|_|   |_______________|\n" +
"                              |   |                                                   |   |\n" +
" _______________     _________|___|_________                                 _________|___|_________        _     ______\n" +
"|  ___________  |   |_|_|               |_|_|      ________/|\\_______       |_|_|               |_|_|      /|\\   /|  (( |\n" +
"| |  _        | |   |_|_|       |       |_|_|     /|      | | |      |\\     |_|_|       |       |_|_|    _/ | \\_/ |  )) |\n" +
"| | (_)       | |   |_|_|               |_|_|    / |Mayors| | |Office| \\    |_|_|               |_|_|   |   |     | |_| |\n" +
"| |  |Park    | |___|_|_|  West Street  |_|_|___|  |______| | |______|  |___|_|_|  East Street  |_|_|___| Clothing| | | |\n" +
"| |        _  | |   |_|_|               |_|_|   | /       / | \\       \\ |   |_|_|               |_|_|   | Factory | | | |\n" +
"| |    _  (_) | |___|_|_|       |       |_|_|___|/_______/ / \\ \\_______\\|___|_|_|       |       |_|_|___|   |     |_|_|_|\n" +
"| |   (_)  |  | |   |_|_|               |_|_|   |_______| / + \\ |_______|   |_|_|               |_|_|   |  / \\   / ___  |\n" +
"| |    |      | |   |_|_|       |       |_|_|    ||_||_||/__|__\\||_||_||    |_|_|       |       |_|_|   |_/   \\_/ |_|_| |\n" +
"| |___________| |   |_|_|               |_|_|    ||_||_||_|| ||_||_||_||    |_|_|               |_|_|   |         |_|_| |\n" +
"|_______________|   |_|_|_______|_______|_|_|   |_________||_||_________|   |_|_|_______|_______|_|_|   |_______________|\n" +
"                              |   |                       |   |                       |   |\n" +
"   ___________       _________|___|_________     _________|___|_________     _________|___|_________     _______________\n" +
"  /           \\     |_|_|       |       |_|_|   |_|_|_|_|_|_|_|_|_|_|_|_|   |_|_|       |       |_|_|   /_________  \\   |\n" +
" /|           |\\    |_|_|               |_|_|   |_|_|_|_|_|_|_|_|_|_|_|_|   |_|_|               |_|_|   |________| | |  |\n" +
"| |           | |   |_|_|       |           |   |                       |   |           |       |_|_|   |        |/_\\|  |\n" +
"| Old Decaying  |___|_|_| South West Corner |___|     South Street      |___| South East Corner |_|_|___|        |___|  |\n" +
"| | Building  | |   |_|_|       |_  _  _  _ |   | _  _  _  _  _  _  _  _|   | _  _  _  _|       |_|_|   |               |\n" +
"| |___________| |___|_|_|                   |___|                       |___|                   |_|_|___|  Waterplant   |\n" +
"| /    ___    \\ |   |_|_|                   |   |                       |   |                   |_|_|   |_____     ___  |\n" +
"|/    |_|_|    \\|   |_|_|_ _ _ _ _ _ _ _ _ _|   |_ _ _ _ _ _ _ _ _ _ _ _|   |_ _ _ _ _ _ _ _ _ _|_|_|   |  _  |   |   | |\n" +
"|     |_|_|     |   |_|_|_|_|_|_|_|_|_|_|_|_|   |_|_|_|_|_|_|_|_|_|_|_|_|   |_|_|_|_|_|_|_|_|_|_|_|_|   | |_| |   |___| |\n" +
"|_______________|   |_|_|_|_|_|_|_|_|_|_|_|_|   |_|_|_|_|_|_|_|_|_|_|_|_|   |_|_|_|_|_|_|_|_|_|_|_|_|   |_____|___|___|_|\n" +
"                              |   |                       |   |                       |   |\n" +
"                     _________|___|_________             _|___|_                      |___|\n" +
"                    |  ___________________  |    _______|  ___  |_______     ________/|   |\\________\n" +
"                    | |  Clothing Store   | |   |  _____|_______|_____  |   |_________|___|_________|\n" +
"                    | |    /__/ & /| /|   | |   | |    Supermarket    | |   |  _    _School _    _  |\n" +
"                    | |___/__/___/_|/_|___| |   | |___________________| |   |_/_\\__/_\\_____/_\\__/_\\_|\n" +
"                    |_______________________|   |_______________________|   | |_|  |_|  _  |_|  |_| |\n" +
"                    |_|___________________|_|   |_______________________|   |__________|_|__________|");
        System.out.println(" ");
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
