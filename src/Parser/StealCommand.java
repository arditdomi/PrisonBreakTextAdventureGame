package Parser;

import Game.Player;

/**
 * Created by dito on 9/5/2017.
 */
public class StealCommand implements VerbCommand{
    public String exec(Player player,String[] input){
     String output;
     boolean stolen = player.stealBankOrSupermarket();
        if(stolen==true) output = "The policeman caught you and you are in prison!!!";
        else output = "You cant steal this";
     return output;
    }
}
