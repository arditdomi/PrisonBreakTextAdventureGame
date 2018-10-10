package Game;

import java.io.Serializable;


public class Bot implements Serializable{

    private String botName;
    boolean botInteract;

    public Bot(String botName, boolean botInteract) {
        this.botName = botName;
        this.botInteract = botInteract;
    }

    public Bot() {
    }

    public String getBotName() {
        return botName;
    }

    public boolean isBotInteract() {
        return botInteract;
    }

    public void setBotInteract(boolean botInteract) {
        this.botInteract = botInteract;
    }

}
