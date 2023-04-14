package components.barrier;


public class ClosedBarrierState implements BarrierState {
    private Barrier barrier;

    public ClosedBarrierState(Barrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void open() {
        // Set state to open
        barrier.setState(new OpenBarrierState(barrier));
    }

    @Override
    public void close() {
        // Do nothing, already closed
    }
}
