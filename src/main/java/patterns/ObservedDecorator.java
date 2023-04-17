package patterns;

import components.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservedDecorator<T extends Observer>
{
    protected List<T> observerList = new ArrayList<>();

    public List<T> getObserverList() {
        return observerList;
    }
    public void registerObserver(T observer) {
        observerList.add(observer);
    }
    public void unregisterObserver(T observer) {
        observerList.remove(observer);
    }
    public void notifyObservers(boolean value, Vehicle vehicle) {
        for (T observer : getObserverList()) {
            observer.registerChange(value, vehicle);
        }
    }
}
