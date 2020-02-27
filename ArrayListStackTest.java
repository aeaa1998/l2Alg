

import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

class ArrayListStackTest<T>  {
    private Vector<T> vector = new Vector<T>();
    @Test
    public void push(T element) {
        vector.add(element);
    }

    @Test
    public T pop() {
        T lastValue = vector.lastElement();
        vector.remove(vector.size() -1);
        return lastValue;
    }
}