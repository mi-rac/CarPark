package components.sensor;

import patterns.Observer;

public interface EntranceSensorObserver extends Observer
{
    void entranceSensorUpdate(boolean value);
}

