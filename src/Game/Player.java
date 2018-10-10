package Game;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private Room room;
    private Territory currentTerritory;
    private List<Tool> pocketTools;
    private transient Time overallTime;
    final String directions;
    GameMap gameMap = new GameMap();

    public Player() {
        this.overallTime = new Time();
        gameMap.initializeGameMap();
        currentTerritory = gameMap.getFirstScene();
        pocketTools = new ArrayList();
        directions = "east west south north";
        room = gameMap.getFirstScene().getEastRoom();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Time getOverallTime() {
        return overallTime;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public List<Tool> getPocketTools() {
        return pocketTools;
    }

    public void setPocketTools(List<Tool> pocketTools) {
        this.pocketTools = pocketTools;
    }

    public Territory getCurrentTerritory() {
        return currentTerritory;
    }

    public void setCurrentTerritory(Territory currentTerritory) {
        this.currentTerritory = currentTerritory;
    }

    public void setOverallTime(Time overallTime) {
        this.overallTime = overallTime;
    }

    public void setPlayerSecondsPassed(int i) {
        overallTime.setSecondsPassed(i);
    }

    public Player(String name, Room room, List<Tool> pocketTools) {
        this.overallTime = new Time();
        this.name = name;
        this.room = room;
        this.pocketTools = pocketTools;
        directions = "east west south north";
    }

    public String look() {
        String output = "";
        if (getRoom() != null) {
            output = getRoom().getToolNames();
            output += room.showRoomBot();
        } else {
            output = lookTerritory();
        }
        return output;
    }

    public String lookTerritory() {
        String territories = "You see ";
        territories += this.currentTerritory.getEastRoom().getRoomName();
        territories += ", " + this.currentTerritory.getWestRoom().getRoomName();
        territories += ", " + this.currentTerritory.getNorthRoom().getRoomName();
        territories += ", " + this.currentTerritory.getSouthRoom().getRoomName();
        return territories;
    }

    public int killCellmate(Bot cellmate, String input) {
        int action;
        if ("yes".equals(input)) {
            cellmate.setBotInteract(false);
            action = 1;
        } else {
            action = 0;
        }
        return action;
    }

    public void sleep() {
        setPlayerSecondsPassed(overallTime.getSecondsPassed() + 40);
    }

    public void digTunnel(boolean cellmateDiging, Cell cell) {
        if (this.getRoom().getRoomName().equals("cell") && cell.tunnelCompleted == false && cell.dayOfDiging != this.overallTime.days) {
            if (cellmateDiging == true) {
                cell.tunnelProgress += 0.4;
            } else {
                cell.tunnelProgress += 0.2;
            }

            cell.dayOfDiging = overallTime.days;
        }
        if (cell.tunnelProgress >= 1.0) {
            cell.tunnelCompleted = true;
        }
    }

    public boolean exitCell() {
        boolean exited = false;
        Time time = new Time();
        time.calcTime(overallTime);
        if (room.equals(gameMap.getTerritory1().getEastRoom()) && (time.getHours() <= 18) && (time.getHours() >= 10)) {
            room = null;
            currentTerritory = gameMap.getTerritory1();
            exited = true;
        } else {
            exited = false;
        }
        return exited;
    }

    public String exitRoom() {
        this.room = null;
        String output = lookTerritory();
        return output;
    }

    public boolean enter(String room) {
        boolean moved = false;
        String terrRoom1 = currentTerritory.getEastRoom().getRoomName();
        String terrRoom2 = currentTerritory.getWestRoom().getRoomName();
        String terrRoom3 = currentTerritory.getNorthRoom().getRoomName();
        String terrRoom4 = currentTerritory.getSouthRoom().getRoomName();
        if (room.equals(terrRoom1) && this.getCurrentTerritory().getEastRoom().isLockState() == true) {
            this.room = currentTerritory.getEastRoom();
            moved = true;
        } else if (room.equals(terrRoom2) && getCurrentTerritory().getWestRoom().isLockState() == true) {
            this.room = currentTerritory.getWestRoom();
            moved = true;
        } else if (room.equals(terrRoom3) && getCurrentTerritory().getNorthRoom().isLockState() == true) {
            this.room = currentTerritory.getNorthRoom();
            moved = true;
        } else if (room.equals(terrRoom4) && this.getCurrentTerritory().getSouthRoom().isLockState() == true) {
            this.room = currentTerritory.getSouthRoom();
            moved = true;
        }
        return moved;
    }

    public boolean stealBankOrSupermarket() {
        boolean stolen = false;
        if ("bank".equals(this.getRoom().getRoomName())) {
            stolen = true;
            this.setRoom(gameMap.getTerritory1().getEastRoom());
            this.setCurrentTerritory(gameMap.getTerritory1());
        } else if ("supermarket".equals(this.getRoom().getRoomName())) {
            stolen = true;
            this.setRoom(gameMap.getTerritory1().getEastRoom());
            this.setCurrentTerritory(gameMap.getTerritory1());
        }
        return stolen;
    }

    public String pick(String toolName) {
        String pickResult = "";
        if (room.canTakeTool(toolName)) {
            Tool toolToTake = new Tool(toolName, false);
            pocketTools.add(toolToTake);
            pickResult = "You succesfully picked " + toolName;
        } else {
            pickResult = "You cant pick this";
        }
        return pickResult;
    }

    public String drop(String toolName) {
        String dropResult = "";
        if (existInPockets(toolName)) {
            Tool toDropTool = new Tool(toolName, true);
            room.addRoomTool(toDropTool);
            dropResult = "You successfully dropped " + toolName;
        } else {
            dropResult = "You don't have this item in your pockets";
        }
        return dropResult;
    }

    public boolean existInPockets(String toolName) {
        boolean canDrop = false;
        for (Tool tool : pocketTools) {
            if (tool.getToolName().equals(toolName)) {
                canDrop = true;
                pocketTools.remove(tool);
                break;
            }
        }
        return canDrop;
    }
    
    public String move(String[] input){
        String output = "";
        if (room == null && input.length>1){
            output = checkRoomOrHallway(input);
        }
        return output;
    }
    
    public String checkRoomOrHallway(String[] input){
        String output = "";
        if(directions.contains(input[1])){
            output = hallwayMove(input[1]);
            output += "\n" + lookTerritory();
        }
        else{
            output = roomMove(input);
        }
        return output;
    }
    
    public String roomMove(String[] input){
        String roomCheck = "";
        boolean moved = false;
        moved = enter(input[1]);
        if(moved == true){
            roomCheck = "You are in the " + room.getRoomName() +". " + look();
        }
        else{
            roomCheck = "You can't enter that";
        }
        return roomCheck;
    }
    
    public String hallwayMove(String input){
        String directionOut ="";
        if(input.equals("east")){
            directionOut = gameMap.checkEast(this);
        }
        else if(input.equals("west")){
            directionOut = gameMap.checkWest(this);
        }
        else if(input.equals("north")){
            directionOut = gameMap.checkNorth(this);
        }
        else if(input.equals("south")){
            directionOut = gameMap.checkSouth(this);
        }
        return directionOut;
    }

}
