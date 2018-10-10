package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameMap implements Serializable {

    private Territory firstScene;
    private List<Territory> gameTerritories;
    private int terrIndexI, terrIndexJ, borderI, borderJ;
    private Cell cell;

    public GameMap() {
        terrIndexI = 1;
        terrIndexJ = 1;
        gameTerritories = new ArrayList<>();
    }

    public Territory getFirstScene() {
        return firstScene;
    }

    public void setFirstScene(Territory firstScene) {
        this.firstScene = firstScene;
    }

    public Territory getTerritory1() {
        return gameTerritories.get(0);
    }

    public void setTerritory1(Territory Territory1) {
        this.gameTerritories.set(0, Territory1);
    }

    public Territory getTerritory2() {
        return gameTerritories.get(1);
    }

    public void setTerritory2(Territory Territory2) {
        this.gameTerritories.set(1, Territory2);
    }

    public Territory getTerritory3() {
        return gameTerritories.get(2);
    }

    public void setTerritory3(Territory Territory3) {
        this.gameTerritories.set(2, Territory3);
    }

    public Territory getTerritory4() {
        return gameTerritories.get(3);
    }

    public void setTerritory4(Territory Territory4) {
        this.gameTerritories.set(3, Territory4);
    }

    public Cell getCell() {
        return cell;
    }

    public int getTerrIndexI() {
        return terrIndexI;
    }

    public int getTerrIndexJ() {
        return terrIndexJ;
    }

    public int getBorderI() {
        return borderI;
    }

    public int getBorderJ() {
        return borderJ;
    }

    public void setBorderI() {
        int max = 1;
        for (Territory territory : gameTerritories/*int i=0;i<gameTerritories.size();i++*/) {
            if (territory.getPositionI() > max) {
                max = territory.getPositionI();
            }
        }
        borderI = max;
    }

    public void setBorderJ() {
        int max = 1;
        for (Territory territory : gameTerritories) {
            if (territory.getPositionJ() > max) {
                max = territory.getPositionJ();
            }
        }
        borderJ = max;
    }

    public void addOneToTerrIndexJ() {
        this.terrIndexJ += 1;
    }

    public void addOneToTerrIndexI() {
        this.terrIndexI += 1;
    }

    public void subtractOneToTerrIndexJ() {
        this.terrIndexJ -= 1;
    }

    public void subtractOneToTerrIndexI() {
        this.terrIndexI -= 1;
    }

    public void initializeGameMap() {
        Territory territory = new Territory();
        Territory[] allTerrs = new Territory[4];
        allTerrs = territory.createAllTerritories();
        this.setFirstScene(allTerrs[4]);
        gameTerritories.add(allTerrs[0]);
        gameTerritories.add(allTerrs[1]);
        gameTerritories.add(allTerrs[2]);
        gameTerritories.add(allTerrs[3]);
        Room room = this.getTerritory1().getEastRoom();
        Cell cell = new Cell(room.getRoomName(), room.isLockState(), 0.0, false, -1);
        this.cell = cell;
        this.setBorderI();
        this.setBorderJ();
    }

    public Territory getIndexedTerritory() {
        Territory territory = null;
        try {
            for (Territory terr : gameTerritories) {
                if (terr.getPositionI() == terrIndexI && terr.getPositionJ() == terrIndexJ) {
                    territory = terr;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return territory;
    }

    public String checkNorth(Player player) {
        if (terrIndexI > 1) {
            subtractOneToTerrIndexI();
            player.setCurrentTerritory(getIndexedTerritory());
            return "You moved north";
        } else {
            return "Your way is blocked";
        }
    }

    public String checkWest(Player player) {
        if (terrIndexJ > 1) {
            subtractOneToTerrIndexJ();
            player.setCurrentTerritory(getIndexedTerritory());
            return "You moved west";
        } else {
            return "Your way is blocked";
        }
    }

    public String checkSouth(Player player) {
        if (terrIndexI < getBorderI()) {
            addOneToTerrIndexI();
            player.setCurrentTerritory(getIndexedTerritory());
            return "You moved south";
        } else {
            return "Your way is blocked";
        }
    }

    public String checkEast(Player player) {
        if (terrIndexJ < getBorderJ()) {
            addOneToTerrIndexJ();
            player.setCurrentTerritory(getIndexedTerritory());
            return "You moved east";
        } else {
            return "Your way is blocked";
        }
    }

}
