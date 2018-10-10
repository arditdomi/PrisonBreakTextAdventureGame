
package SaveOperations;
import Game.Player;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Save {
    public void saveGame(String input,Player player) throws FileNotFoundException, IOException{
        String fileName = "save.bin";
        ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(fileName));
        save.writeObject(player);
        save.close();
        saveTime(player);
    }
    
    public void saveTime(Player player) throws IOException{
        FileWriter timeWrite = new FileWriter("time.txt");
        PrintWriter timePrint = new PrintWriter(timeWrite);
        timePrint.print(correctSecondsPassed(player));
        timePrint.close();
        timeWrite.close();
    }
    
    public int correctSecondsPassed(Player player){
        int time = player.getOverallTime().getDays()*480 + player.getOverallTime().getHours()*20;
        return time;
    }
}
