package components.patterns;

import java.util.function.Supplier;

public class SingletonDecorator<T> {
    private T instance;

    public SingletonDecorator() {
        instance = null;
    }

    public T getInstance(Supplier<T> constructor) {
        if (instance == null) {
            instance = constructor.get();
        }
        return instance;
    }
}
