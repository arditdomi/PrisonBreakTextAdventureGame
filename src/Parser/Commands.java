package Parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;


public class Commands {

    HashMap<String, VerbCommand> hmap = new HashMap<String, VerbCommand>();

    public Commands() throws IOException {
        this.initializeCommands();
    }

    public String inputToString(String[] input){
        String instance = input[0];
            for (int i=1;i<input.length;i++)
                instance +=   " " + input[i];
        return instance;
    }

    public void initializeCommands() throws FileNotFoundException, IOException {

        VerbCommand command;

        command = new LookCommand();
        this.hmap.put("look", command);

        command = new MoveCommand();
        this.hmap.put("enter", command);
        this.hmap.put("go", command);

        command = new ExitCommand();
        this.hmap.put("exit", command);

        command = new PickCommand();
        this.hmap.put("pick", command);
        this.hmap.put("take",command);
        this.hmap.put("get",command);

        command = new DropCommand();
        this.hmap.put("drop", command);

        command = new StealCommand();
        this.hmap.put("steal",command);

        command = new ShowTimeCommand();
        this.hmap.put("time",command);

        command = new PocketCommand();
        this.hmap.put("pockets",command);
        this.hmap.put("pocket",command);
        this.hmap.put("bag",command);

        command = new DigCommand();
        this.hmap.put("dig",command);

        command = new SleepCommand();
        this.hmap.put("sleep",command);
    }

    public VerbCommand getInstance(String playerInput){
        return hmap.get(playerInput);
    }

}


