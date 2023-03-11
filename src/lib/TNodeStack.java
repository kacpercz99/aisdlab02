package lib;

public class TNodeStack <E>{
    protected E data;
    protected TNodeStack<E> prev;

    @Override
    public String toString() {
        return "TNodeStack{" +
                "data=" + data +
                ", prev=" + prev +
                '}';
    }

    public TNodeStack(E data, TNodeStack<E> ref) {
        this.data = data;
        prev = ref;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TNodeStack<E> getPrev() {
        return prev;
    }

    public void setPrev(TNodeStack<E> prev) {
        this.prev = prev;
    }
}
