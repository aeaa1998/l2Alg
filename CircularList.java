public class CircularList <T> extends AbstractList<T> {
    @Override
    public void push(T element){
        this.add(element);
        var newNode = new Node<T>(element);
        if(head == null) {
            head = newNode;
            tail = newNode;
            tail.setNextNode(head);
            head.setNextNode(tail);
        }
        else {
            tail.setNextNode(newNode);
            tail = newNode;
            tail.setNextNode(head);
        }
    }

    @Override
    public T pop() {
        this.remove(this.size() -1);
        if (this.isEmpty()){
            var holder = head.getElement();
            head = null;
            tail = null;
            return holder;
        }
        if (getLastBeforeTail() == null);
        var lastBeforeTail = getLastBeforeTail();
        var tailHolder = tail;
        tail = lastBeforeTail;
        lastBeforeTail.setNextNode(head);
        if (this.size() == 1){
            head.setNextNode(lastBeforeTail);
        }
        return tailHolder.getElement();
    }

    private Node<T> getLastBeforeTail(){
        Node<T> last = head;
        for (int i = 0; i < this.size() - 1; i++) {
            last = last.getNextNode();
        }
        return last;
    }
}
