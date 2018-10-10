package Parser;

import Game.Player;
import Game.Time;

/**
 * Created by dito on 9/5/2017.
 */
public class ShowTimeCommand implements VerbCommand{
    public String exec(Player player,String[] input){
        String output;
        Time time = new Time();
        time.setTime(0,0,0);
        time.calcTime(player.getOverallTime());
        output = time.getDays() + " days, " + time.getHours() + " hours";
        return output;
    }
}
