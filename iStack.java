

/**
 * @author Augusto Alonso 181085 y David Cuellar 18382
 * stack basado en el documento que subio douglas
 * @param <T> recibe el objeto para aplicar generics en este caso se trabajo con strings
 */
public interface iStack <T> {
    public void push(T element);
    // pre:
    // post: item is added to stack
    // will be popped next isf no intervening push

    public T pop();
    // pre: stack is not empty
    // post: most recently pushed item is removed and returned
    public T peek();
    // pre: stack is not empty
    // post: top value (next to be popped) is returned
    public int size();
    // post: returns the number of elements in the stack
    public boolean empty();
    // post: returns true if and only if the stack is empty
}
