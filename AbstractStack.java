import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

abstract class AbstractStack<E extends Collection<T>, T> implements iStack<T> {
    protected E collection;
    public int size(){
        return collection.size();
    }
    public boolean isEmpty(){
        return collection.isEmpty();
    };
}
