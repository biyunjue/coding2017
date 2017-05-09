package queue;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * ������ջ��ʵ��һ������
 * @author liuxin
 *
 * @param <E>
 */
public class QueueWithTwoStacks<E> {
	private Stack<E> stack1;    
    private Stack<E> stack2;    

    public QueueWithTwoStacks() {
        stack1 = new Stack<E>();
        stack2 = new Stack<E>();
    }

   
    

    public boolean isEmpty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }


    
    public int size() {
        return stack1.size()+stack2.size();   
    }



    public void enQueue(E item) {
        stack1.push(item);
    }

    public E deQueue() {
    	if(stack1.isEmpty())
    	{
    		throw new NoSuchElementException("Queue is Empty!!");
    	}
        
    	if(stack2.isEmpty())
    	{
    		while(!stack1.isEmpty())
    		{
    			stack2.push(stack1.pop());
    		}
    	}
    	
        return stack2.pop() ;
    }

 }
