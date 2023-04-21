package components.sensor;

import patterns.Observer;

public interface SensorObserver extends Observer
{
    void sensorUpdate(boolean value);
}

