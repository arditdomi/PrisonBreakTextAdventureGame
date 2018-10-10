package Parser;

import Game.Player;

public class ExitCommand implements VerbCommand {

    @Override
    public String exec(Player player,String[] input) {
        String output;
        if("cell".equals(player.getRoom().getRoomName())) {
            boolean exited = player.exitCell();
            if (exited == true)
                output = player.lookTerritory();
            else output = "You cant exit cell at this time";
        }
        else output = player.exitRoom();
        return output;
    }
}
