package components;

import java.util.Date;

public class Ticket {
    private Car car;
    private Date entryTime;
    private Date exitTime;

    public Ticket(Car car, Date entryTime) {
        this.car = car;
        this.entryTime = entryTime;
    }

    public double getHoursParked() {
        long differenceInMilliseconds = exitTime.getTime() - entryTime.getTime();
        return (double) differenceInMilliseconds / (1000 * 60 * 60);
    }

    // Getters and setters
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }
}
