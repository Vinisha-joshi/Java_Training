package Assignment3;
import java.util.*;
public class GenericQueue<E> {
    private final List<E> list = new ArrayList<>();
    public void add(E element) {
        list.add(element);
    }
    public E removeElement() {
        if(isEmpty())
            return null;
        E firstElement = list.get(0);
        list.remove(firstElement);
        return firstElement;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
