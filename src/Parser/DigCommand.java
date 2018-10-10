package Parser;

import Game.Cell;
import Game.Player;

/**
 * Created by dito on 9/5/2017.
 */
public class DigCommand implements VerbCommand{
    public String exec(Player player, String[] input) {
        String output;
        Cell cell = new Cell();
        cell.setTunnelProgress(player.getGameMap().getCell().getTunnelProgress());
        String toStringInput = toStringInput(input);
        if (player.getRoom().getRoomName().equals(player.getGameMap().getCell().getRoomName())) {
            if (toStringInput.contains("cellmate"))
                player.digTunnel(true, player.getGameMap().getCell());
            else
                player.digTunnel(false, player.getGameMap().getCell());
            boolean tunnelChanged;
            tunnelChanged = cell.cellTunnelProgressChanged(player.getGameMap().getCell());
            cell = player.getGameMap().getCell();
            if (tunnelChanged == true)
                output = "You digged and the tunnel is completed " + cell.getTunnelProgress() * 100 + "%";
            else if (cell.isTunnelCompleted() == true)
                output = "Your tunnel is completed";
            else
                output = "Enough for today";
        }
        else output = "You have nothing to dig here";
        return output;
    }

    public String toStringInput(String[] input){
        String toString = null;
        for (int i=0;i<input.length;i++){
            toString += input[i];
        }
        return toString;
    }
}
