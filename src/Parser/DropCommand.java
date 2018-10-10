package Parser;

import Game.Player;


public class DropCommand implements VerbCommand{
    public String exec(Player player,String[] input){
        String output = player.drop(input[1]);
        return output;
    }
}
