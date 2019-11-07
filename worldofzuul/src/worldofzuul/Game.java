package worldofzuul;

import static worldofzuul.Parameter.mainScore;
import static worldofzuul.Parameter.parameterList;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    public static String name;

    public Game() 
    {
        parser = new Parser();
        Parameter.createParameters();
    }


    private void createRooms()
    {
        
        //Setting up the NPC for the outside room
        //responses are shortend to r, responsesPoints are shortend to rp 
        //and dialog are shortend to d.
        //MAYOR
        String[] rMayor = new String[]{
                "Yes, i do", "No, i don´t"};
        
        int[] rpMayor = new int[]{25,25};
        Say dMayor1 = new Say("Hello " + Game.name+ "\nI´m Mayor Mcclane and welcome to my city!\nSustainia doesn´t exceed our goal of creating a sustainiable city, so i need your help!"
                + "\n\nDo you know what sustainability means?", rMayor, rpMayor, parser);
        
        String[] rMayor2 = new String[]{
                "Yes, i will", "No, i dont care"};
        
        int[] rpMayor2 = new int[]{30,0};
        Say dMayor2 = new Say("You have to walk around Sustainia and visit the different sights.\nTalk to the people that you meet and learn more about the city and sustainiability."
                + "\n\nDo you want to help me make Sustainia sustainiable?\nand learn more about sustainiability?"
                + "", rMayor2, rpMayor2, parser);
        
        String[] rMayor3 = new String[]{
                "Ok..."};
        
        int[] rpMayor3 = new int[]{0};
        Say dMayor3 = new Say("Then you are of no use for our city. Goodbye!", rMayor3, rpMayor3, parser);
        
        //We take all the dialog and use when calling the constructor of the 
        //NPC class. 
        NPC mayorNpc = new NPC("The Mayor",new Say[]{dMayor1,dMayor2,dMayor3},"Alright " 
                + Game.name + "!\nLet´s get started!","City Security",-300);
        
        //New NPC - Build in the same way as above^^   
        //BUSDRIVER
        String[] rBusDriver1 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        
        int[] rpBusDriver1 = new int[]{30,30};
        Say dBusDriver1 = new Say("Hello!" + Game.name + "\nHvad er bæredygtighed?", rBusDriver1, rpBusDriver1, parser);
        
        String[] rBusDriver2 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpBusDriver2 = new int[]{30,30};
        Say dBusDriver2 = new Say("Ok, men hvad skal jeg gøre for at hjælpe til?"
                + "", rBusDriver2, rpBusDriver2, parser);
        
        NPC busDriverNpc = new NPC("the officer",new Say[]{dBusDriver1,dBusDriver2},"Arh, ved du hvad " + Game.name + "? Jeg tror jeg"
                + " prøver det der!");
        
        //OFFICER      
        String[] rOfficer1 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpOfficer1 = new int[]{30,30};
        Say dOfficer1 = new Say("Hvad er bæredygtighed?", rOfficer1, rpOfficer1, parser);
        
        String[] rOfficer2 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpOfficer2 = new int[]{30,30};
        Say dOfficer2 = new Say("Ok, men hvad skal jeg gøre for at hjælpe til?"
                + "", rOfficer2, rpOfficer2, parser);
        
        NPC officerNpc = new NPC("the officer",new Say[]{dOfficer1,dOfficer2},"Arh, ved du hvad " + Game.name + "? Jeg tror jeg"
                + " prøver det der!");
       
        // BANK MANAGER
        String[] rBankManager1 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpBankManager1 = new int[]{30,30};
        Say dBankManager1 = new Say("Hvad er bæredygtighed?", rBankManager1, rpBankManager1, parser);
        
        String[] rBankManager2 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpBankManager2 = new int[]{30,30};
        Say dBankManager2 = new Say("Ok, men hvad skal jeg gøre for at hjælpe til?"
                + "", rBankManager2, rpBankManager2, parser);
        
        NPC bankManagerNpc = new NPC("the officer",new Say[]{dBankManager1,dBankManager2},"Arh, ved du hvad " + Game.name + "? Jeg tror jeg"
                + " prøver det der!");
                
        //TEACHER
        String[] rTeacher1 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpTeacher1 = new int[]{30,30};
        Say dTeacher1 = new Say("Hvad er bæredygtighed?", rTeacher1, rpTeacher1, parser);
        
        String[] rTeacher2 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpTeacher2 = new int[]{30,30};
        Say dTeacher2 = new Say("Ok, men hvad skal jeg gøre for at hjælpe til?"
                + "", rTeacher2, rpTeacher2, parser);
        
        NPC teacherNpc = new NPC("the officer",new Say[]{dTeacher1,dTeacher2},"Arh, ved du hvad " + Game.name + "? Jeg tror jeg"
                + " prøver det der!");
                
        //STORE CLERK
        String[] rStoreClerk1 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpStoreClerk1 = new int[]{30,30};
        Say dStoreClerk1 = new Say("Hvad er bæredygtighed?", rStoreClerk1, rpStoreClerk1, parser);
        
        String[] rStoreClerk2 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpStoreClerk2 = new int[]{30,30};
        Say dStoreClerk2 = new Say("Ok, men hvad skal jeg gøre for at hjælpe til?"
                + "", rStoreClerk2, rpStoreClerk2, parser);
        
        NPC storeClerkNpc = new NPC("the officer",new Say[]{dStoreClerk1,dStoreClerk2},"Arh, ved du hvad " + Game.name + "? Jeg tror jeg"
                + " prøver det der!");
                
        //TRASH CHILD
        String[] rTrashChild1 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpTrashChild1 = new int[]{30,30};
        Say dTrashChild1 = new Say("Hvad er bæredygtighed?", rTrashChild1, rpTrashChild1, parser);
        
        String[] rTrashChild2 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpTrashChild2 = new int[]{30,30};
        Say dTrashChild2 = new Say("Ok, men hvad skal jeg gøre for at hjælpe til?"
                + "", rStoreClerk2, rpStoreClerk2, parser);
        
        NPC trashChildNpc = new NPC("the officer",new Say[]{dTrashChild1,dTrashChild2},"Arh, ved du hvad " + Game.name + "? Jeg tror jeg"
                + " prøver det der!");
                
        //NURSE
        String[] rNurse1 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpNurse1 = new int[]{30,30};
        Say dNurse1 = new Say("Hvad er bæredygtighed?", rNurse1, rpNurse1, parser);
        
        String[] rNurse2 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpNurse2 = new int[]{30,30};
        Say dNurse2 = new Say("Ok, men hvad skal jeg gøre for at hjælpe til?"
                + "", rNurse2, rpNurse2, parser);
        
        NPC nurseNpc = new NPC("the officer",new Say[]{dNurse1,dNurse2},"Arh, ved du hvad " + Game.name + "? Jeg tror jeg"
                + " prøver det der!");
                
        //SANITATION WORKER
        String[] rSanitationWorker1 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpSanitationWorker1 = new int[]{30,30};
        Say dSanitationWorker1 = new Say("Hvad er bæredygtighed?", rSanitationWorker1, rpSanitationWorker1, parser);
        
        String[] rSanitationWorker2 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpSanitationWorker2 = new int[]{30,30};
        Say dSanitationWorker2 = new Say("Ok, men hvad skal jeg gøre for at hjælpe til?"
                + "", rSanitationWorker2, rpSanitationWorker2, parser);
        
        NPC sanitationWorkerNpc = new NPC("the officer",new Say[]{dSanitationWorker1,dSanitationWorker2},"Arh, ved du hvad " + Game.name + "? Jeg tror jeg"
                + " prøver det der!");
                        
        //CASHIER
        String[] rCashier1 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpCashier1 = new int[]{30,30};
        Say dCashier1 = new Say("Hvad er bæredygtighed?", rCashier1, rpCashier1, parser);
        
        String[] rCashier2 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpCashier2 = new int[]{30,30};
        Say dCashier2 = new Say("Ok, men hvad skal jeg gøre for at hjælpe til?"
                + "", rCashier2, rpCashier2, parser);
        
        NPC cashierNpc = new NPC("the officer",new Say[]{dCashier1,dCashier2},"Arh, ved du hvad " + Game.name + "? Jeg tror jeg"
                + " prøver det der!");
                        
        //FACTORY WORKER
        String[] rFactoryWorker1 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpFactoryWorker1 = new int[]{30,30};
        Say dFactoryWorker1 = new Say("Hvad er bæredygtighed?", rFactoryWorker1, rpFactoryWorker1, parser);
        
        String[] rFactoryWorker2 = new String[]{
                "Du kan samle affald op, gå ind for "
                + "bæredygtige materialer fra \n\tnærområdet. Der er en masse!", 
            
                "Ikke så meget... Du burde hellere bare lade være."};
        int[] rpFactoryWorker2 = new int[]{30,30};
        Say dFactoryWorker2 = new Say("Ok, men hvad skal jeg gøre for at hjælpe til?"
                + "", rFactoryWorker2, rpFactoryWorker2, parser);
        
        NPC factoryWorkerNpc = new NPC("the officer",new Say[]{dFactoryWorker1,dFactoryWorker2},"Arh, ved du hvad " + Game.name + "? Jeg tror jeg"
                + " prøver det der!");
        
        Room office, street1, street2, street3, street4, corner1, corner2, 
                corner3, corner4, nonsustainableHouse, policeStation, bank, clothingFactory, waterPlant, 
                school, supermarket, clothingStore, oldDecayingBuilding, park, 
                hospital, recyclingStation;
        
        /** Rooms are created and named.
         *  Rooms are assigned an intro which describes where the player are at.
         *  Rooms are also assigned an exit command.
         */
        
        office = new Room("welcome to the Mayors Office!\nThis building is the center of the city and where you start", mayorNpc);
        street1 = new Room("standing on North Street.\nInfront of you are the library and behind you are the Mayors office");
        street2 = new Room("standing on East Street outside the eastside entrance of the Mayors office.\nTo your right are the gas station");
        street3 = new Room("standing on South Street outside the main entrance of the Mayors office.\nInfront you are the supermarket");
        street4 = new Room("standing on West Street outside the westside entrance of the Mayors office.\nTo your left are the park");
        corner1 = new Room("standing on the northeast corner and there are a busstop.\nInfront of you are the police station and to your right are the bank", busDriverNpc);
        corner2 = new Room("standing on the southeast corner.\nTo your right are your house and behind you are the school");
        corner3 = new Room("standing on the southwest corner.\nBehind you are the clothing store and to your left are the old decaying building");
        corner4 = new Room("standing on the northwest corner.\nTo your left are the hospital and infront of you are the recycling station");
        nonsustainableHouse = new Room("in your house which are nonsustainable");
        policeStation = new Room("at the police station", officerNpc);
        bank = new Room("in the bank", bankManagerNpc);
        clothingFactory = new Room("at the clothing factory", factoryWorkerNpc);
        waterPlant = new Room("at the water plant");
        school = new Room("in the school", teacherNpc);
        supermarket = new Room("in the supermarket", cashierNpc);
        clothingStore = new Room("in the clothing store", storeClerkNpc);
        oldDecayingBuilding = new Room("in an old decaying building");
        park = new Room("in the park", trashChildNpc);
        hospital = new Room("in the hospital", nurseNpc);
        recyclingStation = new Room("at the recycling station", sanitationWorkerNpc);
        
        office.setExit("east", street2);
        office.setExit("south", street3);
        office.setExit("west", street4);
        
        street1.setExit("north", nonsustainableHouse);
        street1.setExit("east", corner1);
        street1.setExit("west", corner4);
        
        corner1.setExit("north", policeStation);
        corner1.setExit("east", bank);
        corner1.setExit("south", street2);
        corner1.setExit("west", street1);
        
        street2.setExit("north", corner1);
        street2.setExit("east", clothingFactory);
        street2.setExit("south", corner2);
        street2.setExit("west", office);
        
        corner2.setExit("north", street2);
        corner2.setExit("east", waterPlant);
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
        
        nonsustainableHouse.setExit("south", street1);
        
        policeStation.setExit("south", corner1);
        
        bank.setExit("west", corner1);
        
        clothingFactory.setExit("west", street2);
        
        waterPlant.setExit("west", corner2);
        
        school.setExit("north", corner2);
        
        supermarket.setExit("north", street3);
        
        clothingStore.setExit("north", corner3);
        
        oldDecayingBuilding.setExit("east", corner3);
        
        park.setExit("east", street4);
        
        hospital.setExit("east", corner4);
        
        recyclingStation.setExit("south",corner4);
        
        currentRoom = office;  
    }
    
    public void play() {            
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            
            if (mainScore.mainScore.getAverage() <= 0) {
                System.out.println("You lost the game noob.");
                Parameter.printScore();
                finished = true;
            }
            
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
                //Starts the conversation with the NPC
                currentRoom.getNPC().runDialog(currentRoom.getNPC().getNpcName());
                
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
        else if (commandWord == CommandWord.SCORE){
            Parameter.printScore();
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
                System.out.println("\nHello " + name);
                
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