package lib;

import java.util.EmptyStackException;

public class TStack<E> implements InterStack<E> {
    protected TNodeStack<E> top;

    public TStack() {
    }

    @Override
    public E top() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public E pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        E out = top.data;
        top = top.prev;
        return out;
    }

    @Override
    public void push(E item) {
        if (top == null) {
            top = new TNodeStack<>(item, null);
        } else {
            top = new TNodeStack<>(item, top);
        }
    }

    @Override
    public int size() {
        int counter = 0;
        TNodeStack<E> ref = top;
        while(ref != null){
            counter++;
            ref = ref.prev;
        }
        return counter;
    }

    public int deepLevel(E item) {
        int counter = 0;
        if(top == null){
            return -1;
        }
        if(top.data == item){
            return 0;
        }
        TNodeStack<E> ref = top.prev;
        while(ref != null){
            counter++;
            if(ref.data == item) return counter;
            ref = ref.prev;
        }
        return -1;
    }
    public void delLast(){
        if(top == null) {
            throw new EmptyStackException();
        }
        TStack<E> stCp = new TStack<>();
        int size = size();
        for (int i=0;i<size;i++){
            stCp.push(this.pop());
        }
        for(int i=0;i<size - 1; i++){
            this.push(stCp.pop());
        }
    }
    @Override
    public boolean isEmpty() {
        return top == null;
    }


    @Override
    public String toString() {
        return "TStack{" +
                "top=" + top +
                '}';
    }
}
