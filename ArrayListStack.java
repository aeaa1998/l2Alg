import java.util.ArrayList;
import java.util.Collection;

public class ArrayListStack<T> extends AbstractStack<ArrayList<T>, T>{
    public ArrayListStack() {
        collection = new ArrayList<>();
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
