package components;

import java.util.function.Supplier;

public class SingletonDecorator<T> {
    private T instance;

    public SingletonDecorator() {
        super();
        this.instance = null;
    }

    public T getInstance(Supplier<T> constructor) {
        if (this.instance == null) {
            this.instance = constructor.get();
        }
        return this.instance;
    }
}
