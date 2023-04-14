package components.vehicle;

import components.parkingSession.ParkingSession;

public abstract class Vehicle<T extends ParkingSession> {
    private String regNum;
    private String type;
    private T session;

    protected Vehicle(String regNum, String type, T session) {
        setRegNum(regNum);
        setType(type);
        setSession(session);
    }
    public T getSession() {
        return session;
    }
    protected void setSession(T session) {
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
}
