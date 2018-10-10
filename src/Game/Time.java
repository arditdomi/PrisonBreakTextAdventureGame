package Game;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;


public class Time {
    int days;
    int hours;
    Timer time = new Timer();
    TimerTask task;
    private int secondsPassed;

    public Time(){
        initTime();
        secondsPassed = 0;
        days = 0;
        hours = 0;
    }

    public void setTime(int secondsPassed,int hours,int days){
        this.secondsPassed = secondsPassed;
        this.hours = hours;
        this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }
    
    public void setSecondsPassed(int i){
        secondsPassed = i;
    }
    
    public void addTime(int secondsToAdd){
        secondsPassed += secondsToAdd;
    }

    public int getDays() {
        return days;
    }

    public Timer getTime() {
        return time;
    }

    public void setTime(Timer time){
        this.time = time;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public TimerTask initTask() {
        TimerTask task;
        task = new TimerTask() {
            public void run() {
                secondsPassed++;
            }
        };
        return task;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Time convertTime() {
        Time time = this;
        int remainer;
        days = secondsPassed / 480;
        remainer = secondsPassed - (days * 480);
        hours = remainer / 20;
        this.setHours(hours);
        this.setDays(days);
        return time;
    }

    public void calcTime(Time time){
        Time tempTime = time.convertTime();
        this.setDays(tempTime.days);
        this.setHours(tempTime.hours);
    }

    public void initTime(){
        task = initTask();
        time.scheduleAtFixedRate(task,1000,1000);
    }

}
