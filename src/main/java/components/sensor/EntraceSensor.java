package components.sensor;

public class EntraceSensor extends Sensor
{
    public void notifyEntranceObservers(boolean value) {
        for (EntranceSensorObserver observer : super.getObserverList()) {
            observer.entranceSensorUpdate(value);
        }
    }
}
