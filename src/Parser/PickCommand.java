package Parser;

import Game.Player;

public class PickCommand implements VerbCommand{

    @Override
    public String exec(Player player,String[] input) {
        if (input.length<=1)
            return  "You can't pick that ";
        else
        return player.pick(input[1]);
    }
    
}
