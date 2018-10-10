package Game;

import java.io.Serializable;

public class Cell extends Room implements Serializable{

    double tunnelProgress;
    boolean tunnelCompleted;
    int dayOfDiging;


    public double getTunnelProgress() {
        return tunnelProgress;
    }

    public Cell() {
    }

    public void setTunnelProgress(double tunnelProgress) {
        this.tunnelProgress = tunnelProgress;
    }

    public void setTunnelCompleted(boolean tunnelCompleted) {
        this.tunnelCompleted = tunnelCompleted;
    }

    public boolean isTunnelCompleted() {
        return tunnelCompleted;
    }

    public void setDayOfDiging(int dayOfDiging) {
        this.dayOfDiging = dayOfDiging;
    }

    public int getDayOfDiging() {
        return dayOfDiging;
    }

    public Cell(String roomName, boolean lockState, double tunnelProgress, boolean tunnelCompleted, int dayOfDigind) {
        super(roomName, lockState);
        this.tunnelProgress = tunnelProgress;
        this.tunnelCompleted = tunnelCompleted;
        this.dayOfDiging = dayOfDigind;
    }
    public boolean cellTunnelProgressChanged(Cell cell){
        boolean progressChanged;
        if (this.tunnelProgress != cell.tunnelProgress)
            progressChanged = true;
        else progressChanged = false;
        return progressChanged;
    }
}
