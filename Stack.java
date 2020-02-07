
/**
 * @author Augusto Alonso 181085 y David Cuellar 18382

 */
import java.util.Vector;

public class Stack<T> implements iStack<T> {
    /**
     * Se crea un elemento del tipo vector
     */
    private Vector<T> vector = new Vector<T>();

    /**
     *
     * @param element elemento a agregar al vector
     *                se agrega elemento al stack
     */
    public void push(T element) {
        vector.add(element);
    }

    /**
     *
     * @return se retorna el ultimo elemento en el stack
     */
    public T pop() {
        T lastValue = vector.lastElement();
        vector.remove(vector.size() -1);
        return lastValue;
    }

    /**
     *
     * @return se retorna el primer elemento del stack
     */
    public T peek() {
        return vector.get(0);
    }

    /**
     *
     * @return cuantos elementos hay en el vector
     */
    public int size() {
        return vector.size();
    }

    /**
     *
     * @return se retorna un true si esta vacio el vectors
     */
    public boolean empty(){
        return vector.size() == 0;
    }
}
