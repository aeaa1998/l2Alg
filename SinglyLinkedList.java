public class SinglyLinkedList <T> extends AbstractList<T> {

    @Override
    public void push(T element) {
        this.add(element);
        Node<T> newNode = new Node<T>(element);
        if (head != null)
        {

            getLastNode(head).setNextNode(newNode);
        } else head = newNode;
    }

    @Override
    public T pop() {
        this.remove(this.size() -1);
        T element;
        if (this.isEmpty()){
            element = head.getElement();
            head = null;
        }else if(this.size() == 1){
            element = head.getNextNode().getElement();
            head.setNextNode(null);
        }else{
            element = getLastNode(head).getElement();
            Node<T> beforelast = head;
            for (int i = 0; i < this.size() - 1; i++) {
                beforelast = beforelast.getNextNode();
            }
            beforelast.setNextNode(null);
        }
        return  element;
    }

    private Node<T> getLastNode(Node<T> holderNode){
        if (holderNode.getNextNode() != null){
            return getLastNode(holderNode);
        }
        return holderNode;
    }

    private Node<T> getLastBeforeTail(){
        Node<T> last = head;
        for (int i = 0; i < this.size() - 1; i++) {
            last = last.getNextNode();
        }
        return last;
    }
}
