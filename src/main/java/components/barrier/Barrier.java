package components.barrier;

import components.vehicle.Vehicle;
import patterns.Observer;

public class Barrier implements Observer, BarrierState
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
    public void registerChange(boolean vehiclePresent, Vehicle vehicle) {
        if (!vehiclePresent) this.close();
    }
}
