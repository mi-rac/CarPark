package components.sensor;

import patterns.observe.Observer;

public interface SensorObserver
{
    void sensorUpdate(boolean value);
}

