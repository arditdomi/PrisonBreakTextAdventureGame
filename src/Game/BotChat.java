package Game;

import java.util.Scanner;
import java.lang.Math;
import java.awt.event.KeyEvent;

public class BotChat {

    String[][] chatBot = {
        //-------------------ΑΠΑΝΤΑΕΙ ΣΤΟΝ ΧΑΙΡΕΤΙΣΜΟ----------------------------------//
        {"hi", "HI", "hI", "hello", "Hello", "hola", "Halooo", "halo", "hey", "HEY"},
        {"hi , how you doing ??", "hey", "hello", "Nice day , aha??"},
        //-------------------ΑΠΑΝΤΑΕΙ ΣΤΟ ΤΙ ΚΑΝΕΙΣ----------------------------------//
        {"how are you", "how you doing?", "how are you?", "How are you", "are you ok", "are you ok ?"},
        {"i am fine, you?", "all good ,thanks god", "nahh good", "i am doing fine ,you?"},
        //--------------------τα default του αν δν βρει καποια απαντησει--------------//
        {"are you mad ???", "you must take a cure IMMEDIATLY!!!", "you are out of your mind", "....."}

    };

    public void answering() {

            //---EDW PAIRNOUME TO INPUT KAI VGAZOUME TA ! , ? , .  --------
            Scanner input = new Scanner(System.in);
            String quote;
            int possitionMatch = 0; //Se pia omada apantiseon psaxnoume
            byte response = 0; // 0 psaxnei 1 dn vrethike tipota 2 vrikame tin apantisei
            
            do{
            System.out.print("-->YOU:\t");
            quote = input.next();
            while (response == 0) {
                if (inArray(quote.toLowerCase(), chatBot[possitionMatch * 2])) {
                    response = 2;
                    int random = (int) Math.floor(Math.random() * chatBot[(possitionMatch * 2) + 1].length);
                    System.out.println("-->Bot\t" + chatBot[possitionMatch * 2][random]);
                }
                possitionMatch++;
                if (possitionMatch * 2 == chatBot.length - 1 && response == 0) {
                    response = 1;
                }
                if (response == 1) {
                    int random = (int) Math.floor(Math.random() * chatBot[chatBot.length - 1].length);
                    System.out.println("-->Bot:\t" + chatBot[possitionMatch * 2][random]);
                }
                System.out.println("\n");
            }

        }while (!quote.equals("bye")); 
    }
    
    public boolean inArray(String in,String[] str)
    {
    boolean match = false;
    for(int i=0;i<str.length;i++)
    {
        if(str[i].equals(in))
        {
            match=true;
        }
    }
    return match;
    }
}