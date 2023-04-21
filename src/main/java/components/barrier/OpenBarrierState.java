package components.barrier;

import components.userInterface.UserInterface;

public class OpenBarrierState implements BarrierState {
    private Barrier barrier;

    public OpenBarrierState(Barrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void open() {
        // Do nothing, already open
    }

    @Override
    public void close() {
        // Set state to closed
        UserInterface.displayMessage("Barrier closing.");
        barrier.setState(new ClosedBarrierState(barrier));
    }
}
