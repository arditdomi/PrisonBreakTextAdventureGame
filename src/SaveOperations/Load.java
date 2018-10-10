
package SaveOperations;
import Game.Player;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import Game.Time;
import java.io.File;
import java.util.Scanner;

public class Load {
    public Player loadGame() throws FileNotFoundException, IOException, ClassNotFoundException{
        String fileName = "save.bin";
        ObjectInputStream load = new ObjectInputStream(new FileInputStream(fileName));
        Player player = new Player();
        player = (Player) load.readObject();
        load.close();
        return player;
    }
    
    public String loadTime() throws FileNotFoundException, IOException{
        Scanner reader = new Scanner(new File("time.txt"));
        String seconds = null;
        while(reader.hasNext()){
            seconds = reader.next();
        }
        reader.close();
        return seconds;
    }
        
    public void setPlayerValues(Player player1,Player player2,int seconds){
        player1.setName(player2.getName());
        player1.setRoom(player2.getRoom());
        player1.setCurrentTerritory(player2.getCurrentTerritory());
        player1.setPocketTools(player2.getPocketTools());
        player1.setPlayerSecondsPassed(seconds);
    }
}
