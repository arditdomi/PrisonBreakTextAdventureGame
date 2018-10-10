package Game;

import java.io.Serializable;

public class Tool implements Serializable{
    String toolName;
    boolean pickable;

    public Tool(String toolName, boolean pickable) {
        this.toolName = toolName;
        this.pickable = pickable;
    }

    public String getToolName() {
        return toolName;
    }

    public boolean isPickable() {
        return pickable;
    }

    public void setPickable(boolean pickable) {
        this.pickable = pickable;
    }

    public Tool() {

    }

    public Tool[] createAllTools() {
        Tool[] allTools = new Tool[48];
        // cell tools
        Tool toilet = new Tool("toilet",false);
        Tool cellDoor = new Tool("cell door",false);
        Tool bed = new Tool("bed",false);
        Tool cellTable = new Tool("table",false);

        // laundry tools
        Tool washMachine = new Tool("wash machine",false);
        Tool laundryDoor = new Tool("door",false);
        Tool basket = new Tool("basket",false);
        Tool clothes = new Tool("clothes",true);

        // restaurant tools
        Tool restaurantTable = new Tool("table",false);
        Tool knife = new Tool("knife",true);
        Tool restaurantDoor = new Tool("door",false);
        Tool trash = new Tool("trash",false);

        //gym tools
        Tool bicycle = new Tool("bicycle",false);
        Tool barbell = new Tool("barbell",false);
        Tool dumbBells = new Tool("dumb-bells",false);
        Tool gymDoor = new Tool("weight plates",false);

        //isolation tools
        Tool isolationWindow = new Tool("window",false);
        Tool isolationDoor = new Tool("door",false);
        Tool isolationBed = new Tool("bed",false);
        Tool isolationTable = new Tool("table",false);

        // wc tools
        Tool wcToilet = new Tool("toilet",false);
        Tool faucet = new Tool("faucet",false);
        Tool wcWindow = new Tool("window",false);
        Tool wcDoor = new Tool("door",false);

        // hospital tools
        Tool hospitalDoor = new Tool("locker",false);
        Tool medicineKit = new Tool("medicine kit",true);
        Tool pills = new Tool("pills",true);
        Tool medicalTools = new Tool("medical tools",false);

        // office tools
        Tool desk = new Tool("desk",false);
        Tool tajMahal = new Tool("taj mahal",false);
        Tool chair = new Tool("chair",false);
        Tool keys = new Tool("keys",true);

        // guards room tools
        Tool gun = new Tool("gun",true);
        Tool guardClothes = new Tool("guard's clothes",true);
        Tool guardDoor = new Tool("guard door",false);
        
        // home room tools
        Tool tv = new Tool("TV",false);
        Tool homeWindow = new Tool("window",false);
        Tool homeDoor = new Tool("door",false);
        Tool couch = new Tool("couch",false);
        
        // bank room tools
        Tool bankDoor = new Tool("door",false);
        Tool money = new Tool("money",true);
        Tool seats = new Tool("seats",false);
        Tool cashMachine = new Tool("cashMachine",false);

        // supermarket room tools
        Tool milk = new Tool("milk",true);
        Tool bread = new Tool("bread",true);
        Tool apples = new Tool("apples",true);
        Tool everythingInSm = new Tool("everything you can find in a supermarket",false);

        Tool emptyTool = new Tool("",false);
        
        allTools[0] = toilet;
        allTools[1] = cellDoor;
        allTools[2] = bed;
        allTools[3] = cellTable;
        allTools[4] = washMachine;
        allTools[5] = laundryDoor;
        allTools[6] = basket;
        allTools[7] = clothes;
        allTools[8] = restaurantTable;
        allTools[9] = knife;
        allTools[10] = restaurantDoor;
        allTools[11] = trash;
        allTools[12] = bicycle;
        allTools[13] = barbell;
        allTools[14] = dumbBells;
        allTools[15] = gymDoor;
        allTools[16] = isolationWindow;
        allTools[17] = isolationDoor;
        allTools[18] = isolationBed;
        allTools[19] = isolationTable;
        allTools[20] = wcToilet;
        allTools[21] = faucet;
        allTools[22] = wcWindow;
        allTools[23] = wcDoor;
        allTools[24] = hospitalDoor;
        allTools[25] = medicineKit;
        allTools[26] = pills;
        allTools[27] = medicalTools;
        allTools[28] = desk;
        allTools[29] = tajMahal;
        allTools[30] = chair;
        allTools[31] = keys;
        allTools[32] = gun;
        allTools[33] = guardClothes;
        allTools[34] = guardDoor;
        allTools[35] = tv;
        allTools[36] = couch;
        allTools[37] = homeWindow;
        allTools[38] = homeDoor;
        allTools[39] = bankDoor;
        allTools[40] = money;
        allTools[41] = seats;
        allTools[42] = cashMachine;
        allTools[43] = milk;
        allTools[44] = bread;
        allTools[45] = apples;
        allTools[46] = everythingInSm;
        allTools[47] = emptyTool;
        
        return allTools;
    }

}
