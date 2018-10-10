package Parser;

import Game.Player;

public class MoveCommand implements VerbCommand {

    @Override
    public String exec(Player player,String[] input) {
        String output;
        output = player.move(input);
        return output;
    }

}
