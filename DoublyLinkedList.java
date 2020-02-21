public class DoublyLinkedList <T> extends AbstractList<T> {
    @Override
    public void push(T element) {
        this.add(element);
        Node<T> newNode = new Node<>(element);
        if (head == null){
            head = newNode;
            head.setNextNode(head);
            head.setPreviousNode(null);
            if (tail == null){ tail = head; }
        }else{
            newNode.setPreviousNode(tail);
            newNode.setNextNode(head);
            tail = newNode;
            tail.getPreviousNode().setNextNode(tail);
            if (head == null) head = tail;
        }
    }

    @Override
    public T pop() {
        this.remove(this.size() -1);
        T holder = tail.getElement();
        tail = tail.getPreviousNode();
        if (tail == null) head = null; else tail.setNextNode(head);
        return holder;
    }
}
