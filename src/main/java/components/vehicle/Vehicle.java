package components.vehicle;

import components.parkingSession.ParkingSession;

public abstract class Vehicle {
    private String regNum;
    private String type;
    private ParkingSession session;

    protected Vehicle(String regNum, String type, ParkingSession session) {
        setRegNum(regNum);
        setType(type);
        setSession(session);
    }
    public ParkingSession getSession() {
        return session;
    }
    protected void setSession(ParkingSession session) {
        this.session = session;
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
    @Override
    public String toString() {
        return "Vehicle{" +
                "regNum='" + regNum + '\'' +
                ", type=" + type + '\'' +
                ", session=" + session.toString() +
                '}';
    }
}
