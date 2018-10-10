package Parser;

import Game.Player;

/**
 * Created by dito on 12/5/2017.
 */
public class SleepCommand implements VerbCommand{

    @Override
    public String exec(Player player, String[] input) {
        String  output = "You just wasted 2 Hours";
        player.sleep();
        return output;
    }
}
