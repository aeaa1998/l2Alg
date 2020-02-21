public class SinglyLinkedListStack <T> extends AbstractStack<SinglyLinkedList<T>, T>  {
    public SinglyLinkedListStack() {
        collection = new SinglyLinkedList<>();
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
