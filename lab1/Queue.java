package lab1;
import java.util.Stack;
import java.util.NoSuchElementException;
public class Queue<E> extends Stack<E>{
    private static final long serialVersionUID=1L;
    public final int dump=5;    //size of stack
    private  Stack<E> stk;      //as the entry stack, base class as the export stack
    public Queue(){ 
        stk=new Stack<E>();     //init the que
    }

/**
 * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, 
 * returning true upon success and throwing an IllegalStateException if no space is currently available. 
 */
public boolean add(E e) throws IllegalStateException, ClassCastException, 
NullPointerException, IllegalArgumentException{
    if(stk.size()==dump && super.size()!=0){
        throw new IllegalStateException("The queue is full");
    }
    else if(stk.size()<dump){
        stk.push(e);
    }
    else{
        //all elements to export stack from entry stack
        while(!stk.isEmpty()) super.push(stk.pop()); 
        stk.push(e);
    }
    return true;
}

/**
 * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions. 
 * When using a capacity-restricted queue, this method is generally preferable to add(E), 
 * which can fail to insert an element only by throwing an exception.
 */
public boolean offer(E e) throws ClassCastException, NullPointerException, 
IllegalArgumentException{
    if(stk.size()==dump && super.size()!=0){
        return false;
    }
    else if(stk.size()<dump){
        stk.push(e);
    }
    else{
        //all elements to export stack from entry stack
        while(!stk.isEmpty()) super.push(stk.pop()); 
        stk.push(e);
    }
    return true;
}

    /**
     * Retrieves and removes the head of this queue. 
     * This method differs from poll only in that it throws an exception if this queue is empty.
     */
    public E remove() throws NoSuchElementException {
        if (!super.isEmpty()){
             return super.pop();
        }
        else if(!stk.isEmpty()){
            while(!stk.isEmpty()) super.push(stk.pop()); 
            return super.pop();
        }
        else{
            throw new NoSuchElementException("The queue is empty");
        }
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     */
    public E poll() {
        if (!super.isEmpty()){
             return super.pop();
        }
        else if(!stk.isEmpty()){
            while(!stk.isEmpty()) super.push(stk.pop()); 
            return super.pop();
        }
        else{
            return null;
        }
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     */
    public E peek () {
        if (!super.isEmpty()){
            return super.peek();
        }
        else if(!stk.isEmpty()){
            while(!stk.isEmpty()) super.push(stk.pop()); 
            return super.peek();
        }
        else{
            return null;
        }
        //return this.element();
    }

    /**
     * Retrieves, but does not remove, the head of this queue. 
     * This method differs from peek only in that it throws an exception if this queue is empty.
     */
    public E element() throws NoSuchElementException {
        if (!super.isEmpty()){
            return super.peek();
        }
        else if(!stk.isEmpty()){
            while(!stk.isEmpty()) super.push(stk.pop()); 
            return super.peek();
        }
        else{
            throw new NoSuchElementException("The queue is empty");
        }
    }
}
