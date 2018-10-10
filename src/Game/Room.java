package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {

    private String roomName;
    boolean lockState;
    private List<Tool> roomTools;
    private Bot bot;

    public Room(String roomName, boolean lockState) {
        this.roomName = roomName;
        this.lockState = lockState;
        roomTools = new ArrayList();
    }

    public Room() {
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean isLockState() {
        return lockState;
    }

    public void setLockState(boolean lockState) {
        this.lockState = lockState;
    }

    public List<Tool> getRoomTools() {
        return roomTools;
    }

    public void addRoomTool(Tool tool) {
        this.roomTools.add(tool);
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public Bot getBot() {
        return bot;
    }

    public boolean botExists() {
        return this.bot != null;
    }

    public String showRoomBot() {
        if (this.botExists() == true) {
            return " and you also see " + bot.getBotName();
        } else {
            return "";
        }
    }

    public Room[] createRooms() {
        Tool tool = new Tool();
        Tool[] allTools;//= new Game.Tool[51];
        allTools = tool.createAllTools();
        Room[] allRooms = new Room[13];

        //Cell Prison Room
        Bot Sucre = new Bot("Sucre", true);
        Room cell = new Room("cell", true);
        cell.setBot(Sucre);
        cell.addRoomTool(allTools[0]);
        cell.addRoomTool(allTools[1]);
        cell.addRoomTool(allTools[2]);
        cell.addRoomTool(allTools[3]);

        //Laundry Prison Room
        Room laundry = new Room("laundry", true);
        laundry.addRoomTool(allTools[4]);
        laundry.addRoomTool(allTools[5]);
        laundry.addRoomTool(allTools[6]);
        laundry.addRoomTool(allTools[7]);

        //Restaurant Prison Room
        Bot chef = new Bot("Chef", true);
        Room restaurant = new Room("restaurant", true);
        restaurant.setBot(chef);
        restaurant.addRoomTool(allTools[8]);
        restaurant.addRoomTool(allTools[9]);
        restaurant.addRoomTool(allTools[10]);
        restaurant.addRoomTool(allTools[11]);

        //Gym Prison Room
        Room gym = new Room("gym", true);
        gym.addRoomTool(allTools[12]);
        gym.addRoomTool(allTools[13]);
        gym.addRoomTool(allTools[14]);
        gym.addRoomTool(allTools[15]);

        //Isolation Prison Room
        Room isolation = new Room("isolation", false);
        isolation.addRoomTool(allTools[16]);
        isolation.addRoomTool(allTools[17]);
        isolation.addRoomTool(allTools[18]);
        isolation.addRoomTool(allTools[19]);

        //WC Prison Room
        Room wc = new Room("wc", true);
        wc.addRoomTool(allTools[20]);
        wc.addRoomTool(allTools[21]);
        wc.addRoomTool(allTools[22]);
        wc.addRoomTool(allTools[23]);

        //Hospital Prison Room
        Room hospital = new Room("hospital", true);
        hospital.addRoomTool(allTools[24]);
        hospital.addRoomTool(allTools[25]);
        hospital.addRoomTool(allTools[26]);
        hospital.addRoomTool(allTools[27]);

        //Chief Office Prison Room
        Room chiefoffice = new Room("chief office", true);
        chiefoffice.addRoomTool(allTools[28]);
        chiefoffice.addRoomTool(allTools[29]);
        chiefoffice.addRoomTool(allTools[30]);
        chiefoffice.addRoomTool(allTools[31]);

        //Guards Prison Room
        Room guards = new Room("guards", true);
        guards.addRoomTool(allTools[31]);
        guards.addRoomTool(allTools[32]);
        guards.addRoomTool(allTools[33]);
        guards.addRoomTool(allTools[34]);

        //Home FirstScene Room
        Room home = new Room("home", true);
        home.addRoomTool(allTools[35]);
        home.addRoomTool(allTools[36]);
        home.addRoomTool(allTools[37]);
        home.addRoomTool(allTools[38]);

        //Bank FirstScene Room
        Room bank = new Room("bank", true);
        bank.addRoomTool(allTools[39]);
        bank.addRoomTool(allTools[40]);
        bank.addRoomTool(allTools[41]);
        bank.addRoomTool(allTools[42]);

        //SuperMarket FirstScene Room
        Room supermarket = new Room("supermarket", true);
        supermarket.addRoomTool(allTools[43]);
        supermarket.addRoomTool(allTools[44]);
        supermarket.addRoomTool(allTools[45]);
        supermarket.addRoomTool(allTools[46]);

        //trainStation FirstScene Room
        Room trainStation = new Room("trainstation", false);

        allRooms[0] = cell;
        allRooms[1] = restaurant;
        allRooms[2] = laundry;
        allRooms[3] = gym;
        allRooms[4] = isolation;
        allRooms[5] = guards;
        allRooms[6] = hospital;
        allRooms[7] = chiefoffice;
        allRooms[8] = wc;
        allRooms[9] = home;
        allRooms[10] = bank;
        allRooms[11] = supermarket;
        allRooms[12] = trainStation;
        return allRooms;
    }

    public String getToolNames() {
        StringBuffer names = new StringBuffer();
        if (roomTools.isEmpty()) {
            return "This room is empty";
        }
        for (Tool tool : roomTools) {
            names.append(tool.getToolName());
            names.append(" ");
        }
        return names.toString();
    }

    public boolean canTakeTool(String toolName) {
        boolean exists = false;
        for (Tool tool : roomTools) {
            if (tool.getToolName().equals(toolName)) {
                roomTools.remove(tool);
                exists = true;
                break;
            } else {
                exists = false;
            }
        }
        return exists;
    }
}
