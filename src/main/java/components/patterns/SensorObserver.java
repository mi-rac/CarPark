package components.patterns;

public interface SensorObserver extends Observer
{
    void sensorUpdated(boolean value);
}
