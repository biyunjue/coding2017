package queue;

import java.util.NoSuchElementException;

/**
 * ������ʵ��ѭ������
 * @author liuxin
 *
 * @param <E>
 */
public class CircleQueue <E> {
	
	//private final static int DEFAULT_SIZE = 10;
	
	//������������ѭ�����е�Ԫ��
	private Object[] elementData ;
	int size=0;
	
	public CircleQueue(int capacity)
	{
		elementData=new Object[capacity];
	}
	//��ͷ
	private int front = 0;  
	//��β  
	private int rear = 0;
	
	public boolean isEmpty() {
		
		return front==rear;
    }
	
    public boolean isFull()
    {
    	return size==elementData.length;
    }
    
    public int size() {
    	
        return size;
    }


    public void enQueue(E data) {
        
        if(isFull())
        {
        	throw new NoSuchElementException("Queue is Full!");
        }
        elementData[rear++]=data;
        size++;
    }

    public E deQueue() {
    	if(isEmpty())
    	{
    		throw new NoSuchElementException("Queue is Empty!");
    	}
    	@SuppressWarnings("unchecked")
		E data=(E) elementData[front];
    	elementData[front]=null;
    	front=(front+1)%elementData.length;
    	size--;
        return data;
    }
}
