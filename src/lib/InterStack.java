package lib;

public interface InterStack <E>{
    E top();
    E pop();
    void push(E item);
    int size();
    boolean isEmpty();
}
