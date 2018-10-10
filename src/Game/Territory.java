package Game;

import java.io.Serializable;

public class Territory implements Serializable {

    private String territoryName;
    private Room eastRoom;
    private Room westRoom;
    private Room northRoom;
    private Room southRoom;
    private int positionI;
    private int positionJ;

    public Territory() {

    }

    public Territory(String territoryName, Room eastRoom, Room westRoom, Room northRoom, Room southRoom, int posI, int posJ) {
        this.territoryName = territoryName;
        this.eastRoom = eastRoom;
        this.westRoom = westRoom;
        this.northRoom = northRoom;
        this.southRoom = southRoom;
        this.positionI = posI;
        this.positionJ = posJ;
    }

    public Territory(String territoryName, Room eastRoom, Room westRoom, Room northRoom, Room southRoom) {
        this.territoryName = territoryName;
        this.eastRoom = eastRoom;
        this.westRoom = westRoom;
        this.northRoom = northRoom;
        this.southRoom = southRoom;
    }

    public Room getEastRoom() {
        return eastRoom;
    }

    public Room getWestRoom() {
        return westRoom;
    }

    public Room getNorthRoom() {
        return northRoom;
    }

    public Room getSouthRoom() {
        return southRoom;
    }

    public int getPositionI() {
        return positionI;
    }

    public int getPositionJ() {
        return positionJ;
    }

    public Territory[] createAllTerritories() {
        Room room = new Room();
        Room[] rooms;//= new Game.Room[14];
        Territory[] allTerritories = new Territory[5];

        rooms = room.createRooms();

        Territory eastTerritory = new Territory("Territory1", rooms[0], rooms[1], rooms[2], rooms[3], 1, 1);
        Territory westTerritory = new Territory("Territory2", rooms[2], rooms[3], rooms[4], rooms[5], 1, 2);
        Territory northTerritory = new Territory("Territory3", rooms[1], rooms[3], rooms[6], rooms[8], 2, 1);
        Territory southTerritory = new Territory("Territory4", rooms[3], rooms[5], rooms[6], rooms[7], 2, 2);
        Territory firstScene = new Territory("firstScene", rooms[9], rooms[10], rooms[11], rooms[12]);
        allTerritories[0] = eastTerritory;
        allTerritories[1] = westTerritory;
        allTerritories[2] = northTerritory;
        allTerritories[3] = southTerritory;
        allTerritories[4] = firstScene;
        return allTerritories;
    }

}
