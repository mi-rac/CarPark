package components.sensor;

import components.patterns.Observer;

public interface SensorObserver extends Observer
{
    void sensorUpdate(boolean value);
}

