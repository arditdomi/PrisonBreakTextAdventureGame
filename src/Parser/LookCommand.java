package Parser;

import Game.Player;

public class LookCommand implements VerbCommand {

    @Override
    public String exec(Player player,String[] input) {
        String output = "You see";
       return output + ":" + player.look();
    }

}
