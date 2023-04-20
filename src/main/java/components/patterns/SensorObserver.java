package components.patterns;

import java.io.IOException;

public interface SensorObserver extends Observer
{
    void sensorUpdated(boolean value);
}
