package components.barrier;

import components.sensor.EntranceSensorObserver;

public class Barrier implements EntranceSensorObserver, BarrierState
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
    public void entranceSensorUpdate(boolean vehiclePresent) {
        if (!vehiclePresent) this.close();
    }
}
