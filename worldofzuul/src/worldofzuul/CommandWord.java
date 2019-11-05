package worldofzuul;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), TALK("talk"), SAY("say"), 
    LEAVE("leave"), NAME("name"), UNKNOWN("?");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
