import java.util.ArrayList;
import java.util.Vector;

public class VectorStack <T> extends AbstractStack<Vector<T>, T> {
    public VectorStack() {
        collection = new Vector<>();
    }

    @Override
    public void push(T element) {
        collection.add(element);
    }

    @Override
    public T pop() {
        var holder = collection.get(collection.size() - 1);
        collection.remove(collection.size() - 1);
        return holder;
    }
}
