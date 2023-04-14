package components.vehicle;

import components.parkingData.ParkingSession;

public abstract class Vehicle {
    private String regNum;
    private String type;
    private ParkingSession session;
    protected Vehicle(String regNum, String type) {
        setRegNum(regNum);
        setType(type);
    }
    public String getRegNum() {
        return regNum;
    }
    protected void setRegNum(String regNum) {
        this.regNum = regNum;
    }
    public String getType() {
        return type;
    }
    protected void setType(String type) {
        this.type = type;
    }
}
