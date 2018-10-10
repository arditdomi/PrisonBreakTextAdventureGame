package Parser;

import Game.Player;


public class PocketCommand implements VerbCommand {
    public String exec(Player player,String[] input){
        String output ="You have in pockets";
        if(player.getPocketTools().size()>=1) {
            for (int i = 0; i < player.getPocketTools().size(); i++)
                output +=  ", "+ player.getPocketTools().get(i).getToolName() ;
        }
        else output = "You have nothing in pockets";
        return output;
    }
}
