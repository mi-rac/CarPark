package components.barrier;

import components.sensor.SensorObserver;

public class Barrier implements SensorObserver
{
    private BarrierState state;

    public Barrier() {
        // Set initial state to closed
        state = new ClosedBarrierState(this);
    }

    public void open() {
        state.open();
    }

    public void close() {
        state.close();
    }

    public void setState(BarrierState state) {
        this.state = state;
    }

    @Override
    public void sensorUpdate(boolean value) {

    }
}
