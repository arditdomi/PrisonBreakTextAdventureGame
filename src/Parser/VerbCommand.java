package Parser;

import Game.Player;

public interface VerbCommand {
    
    public String exec(Player player, String[] input);
    
}
