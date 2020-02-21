public class DoublyLinkedListStack<T> extends AbstractStack<DoublyLinkedList<T>, T>  {
    public DoublyLinkedListStack() {
        collection = new DoublyLinkedList<>();
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
