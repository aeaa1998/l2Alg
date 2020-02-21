import java.util.ArrayList;
import java.util.List;

abstract class AbstractList<T> extends ArrayList<T> implements iList<T>{
    protected Node<T> head = null;
    protected Node<T> tail = null;

}
