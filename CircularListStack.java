import java.util.ArrayList;

public class CircularListStack<T> extends AbstractStack<CircularList<T>, T> {
    public CircularListStack() {
        collection = new CircularList<>();
    }

    @Override
    public void push(T element) {
        collection.push(element);
    }

    @Override
    public T pop() {
        return collection.pop();
    }
}
